package org.jcodec.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.codecs.h264.H264Decoder;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.common.ArrayUtil;
import org.jcodec.common.JCodecUtil2;
import org.jcodec.common.SeekableDemuxerTrack;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.IOUtils;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mp4.demuxer.MP4Demuxer;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class TestTool {
    private File errs;
    private String jm;
    private File coded = File.createTempFile("seq", ".264");
    private File decoded = File.createTempFile("seq_dec", ".yuv");
    private File jmconf = File.createTempFile("ldecod", ".conf");

    public TestTool(String str, String str2) throws IOException {
        this.jm = str;
        this.errs = new File(str2);
        prepareJMConf();
    }

    private void diff(int i) {
        System.out.println(i + ": DIFF!!!");
        this.coded.renameTo(new File(this.errs, String.format("seq%08d.264", Integer.valueOf(i))));
        this.decoded.renameTo(new File(this.errs, String.format("seq%08d_dec.yuv", Integer.valueOf(i))));
    }

    private void doIt(String str) throws Exception {
        FileChannelWrapper fileChannelWrapper;
        Packet packetNextFrame;
        FileChannelWrapper fileChannelWrapper2 = null;
        try {
            FileChannelWrapper fileChannelWrapper3 = new FileChannelWrapper(new FileInputStream(str).getChannel());
            try {
                SeekableDemuxerTrack seekableDemuxerTrack = (SeekableDemuxerTrack) MP4Demuxer.createMP4Demuxer(fileChannelWrapper3).getVideoTrack();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12533760);
                ByteBuffer codecPrivate = seekableDemuxerTrack.getMeta().getCodecPrivate();
                H264Decoder h264DecoderCreateH264DecoderFromCodecPrivate = H264Decoder.createH264DecoderFromCodecPrivate(codecPrivate);
                int i = 2600;
                seekableDemuxerTrack.gotoFrame(2600);
                do {
                    packetNextFrame = seekableDemuxerTrack.nextFrame();
                    if (packetNextFrame == null) {
                        break;
                    }
                } while (!packetNextFrame.isKeyFrame());
                if (packetNextFrame == null) {
                    throw new NullPointerException("inFrame == null");
                }
                seekableDemuxerTrack.gotoFrame(packetNextFrame.getFrameNo());
                ArrayList arrayList = new ArrayList();
                int totalFrames = seekableDemuxerTrack.getMeta().getTotalFrames();
                int i2 = 0;
                while (true) {
                    Packet packetNextFrame2 = seekableDemuxerTrack.nextFrame();
                    if (packetNextFrame2 == null) {
                        if (arrayList.size() > 0) {
                            runJMCompareResults(arrayList, i2);
                        }
                        fileChannelWrapper3.close();
                        if (fileChannelWrapper2 != null) {
                            fileChannelWrapper2.close();
                            return;
                        }
                        return;
                    }
                    List<ByteBuffer> listSplitFrame = H264Utils.splitFrame(packetNextFrame2.getData());
                    byteBufferAllocate.clear();
                    H264Utils.joinNALUnitsToBuffer(listSplitFrame, byteBufferAllocate);
                    byteBufferAllocate.flip();
                    if (H264Utils.isByteBufferIDRSlice(byteBufferAllocate)) {
                        if (fileChannelWrapper2 != null) {
                            fileChannelWrapper2.close();
                            runJMCompareResults(arrayList, i2);
                            arrayList = new ArrayList();
                            i2 = i;
                        }
                        fileChannelWrapper = new FileChannelWrapper(new FileOutputStream(this.coded).getChannel());
                        try {
                            fileChannelWrapper.write(codecPrivate);
                            fileChannelWrapper2 = fileChannelWrapper;
                        } catch (Throwable th) {
                            th = th;
                            fileChannelWrapper2 = fileChannelWrapper3;
                            if (fileChannelWrapper2 != null) {
                                fileChannelWrapper2.close();
                            }
                            if (fileChannelWrapper != null) {
                                fileChannelWrapper.close();
                            }
                            throw th;
                        }
                    }
                    if (fileChannelWrapper2 == null) {
                        throw new IllegalStateException("IDR slice not found");
                    }
                    fileChannelWrapper2.write(byteBufferAllocate);
                    Size size = seekableDemuxerTrack.getMeta().getVideoCodecMeta().getSize();
                    arrayList.add(h264DecoderCreateH264DecoderFromCodecPrivate.decodeFrameFromNals(listSplitFrame, Picture.create((size.getWidth() + 15) & (-16), (size.getHeight() + 15) & (-16), ColorSpace.YUV420).getData()));
                    if (i % 500 == 0) {
                        System.out.println(((i * 100) / totalFrames) + "%");
                    }
                    i++;
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannelWrapper = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannelWrapper = null;
        }
    }

    public static void main1(String[] strArr) throws Exception {
        if (strArr.length == 3) {
            new TestTool(strArr[0], strArr[2]).doIt(strArr[1]);
        } else {
            System.out.println("JCodec h.264 test tool");
            System.out.println("Syntax: <path to ldecod> <movie file> <foder for errors>");
        }
    }

    private void prepareJMConf() throws IOException {
        IOUtils.writeStringToFile(this.jmconf, "InputFile              = \"" + this.coded.getAbsolutePath() + "\"\nOutputFile             = \"" + this.decoded.getAbsolutePath() + "\"\nRefFile                = \"/dev/null\"\nWriteUV                = 1\nFileFormat             = 0\nRefOffset              = 0\nPOCScale               = 2\nDisplayDecParams       = 0\nConcealMode            = 0\nRefPOCGap              = 2\nPOCGap                 = 2\nSilent                 = 1\nIntraProfileDeblocking = 1\nDecFrmNum              = 0\nDecodeAllLayers        = 0\n");
    }

    private void runJMCompareResults(List<Picture> list, int i) throws Exception {
        try {
            Runtime.getRuntime().exec(this.jm + " -d " + this.jmconf.getAbsolutePath()).waitFor();
            ByteBuffer byteBufferFetchFromFile = NIOUtils.fetchFromFile(this.decoded);
            Iterator<Picture> it = list.iterator();
            while (it.hasNext()) {
                Picture pictureCropped = it.next().cropped();
                if (!(Platform.arrayEqualsByte(ArrayUtil.toByteArrayShifted(JCodecUtil2.getAsIntArray(byteBufferFetchFromFile, pictureCropped.getPlaneWidth(2) * pictureCropped.getPlaneHeight(2))), pictureCropped.getPlaneData(2)) & Platform.arrayEqualsByte(ArrayUtil.toByteArrayShifted(JCodecUtil2.getAsIntArray(byteBufferFetchFromFile, pictureCropped.getPlaneWidth(0) * pictureCropped.getPlaneHeight(0))), pictureCropped.getPlaneData(0)) & Platform.arrayEqualsByte(ArrayUtil.toByteArrayShifted(JCodecUtil2.getAsIntArray(byteBufferFetchFromFile, pictureCropped.getPlaneWidth(1) * pictureCropped.getPlaneHeight(1))), pictureCropped.getPlaneData(1)))) {
                    diff(i);
                }
            }
        } catch (Exception unused) {
            diff(i);
        }
    }
}
