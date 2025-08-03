package org.jcodec.codecs.mpeg12;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.Codec;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.ChannelLabel;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mps.MPSUtils;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class MPSMediaInfo extends MPSUtils.PESReader {
    private Map<Integer, MPEGTrackMetadata> infos = new HashMap();
    private int pesTried;
    private PSM psm;

    public static class MPEGTimecodeMetadata {
        public String getNumFrames() {
            return null;
        }

        public String getStartCounter() {
            return null;
        }

        public String isDropFrame() {
            return null;
        }
    }

    public static class MPEGTrackMetadata {
        public Codec codec;
        public ByteBuffer probeData;
        public int streamId;

        public MPEGTrackMetadata(int i) {
            this.streamId = i;
        }

        public AudioFormat getAudioFormat() {
            return null;
        }

        public ChannelLabel[] getChannelLables() {
            return null;
        }

        public Size getCodedSize() {
            return null;
        }

        public Size getDisplaySize() {
            return null;
        }

        public float getDuration() {
            return 0.0f;
        }

        public String getFourcc() {
            return null;
        }

        public float getFps() {
            return 0.0f;
        }

        public Rational getFpsR() {
            return null;
        }

        public int getNumFrames() {
            return 0;
        }

        public MPEGTimecodeMetadata getTimecode() {
            return null;
        }
    }

    public static class MediaInfoDone extends RuntimeException {
    }

    public static class PSM {
    }

    private void deriveMediaInfo() {
        for (MPEGTrackMetadata mPEGTrackMetadata : this.infos.values()) {
            int i = mPEGTrackMetadata.streamId | 256;
            if (i >= 448 && i <= 479) {
                mPEGTrackMetadata.codec = Codec.MP2;
            } else if (i == 445) {
                ByteBuffer byteBufferDuplicate = mPEGTrackMetadata.probeData.duplicate();
                MPSUtils.readPESHeader(byteBufferDuplicate, 0L);
                int i2 = byteBufferDuplicate.get() & ExifInterface.MARKER;
                if (i2 >= 128 && i2 <= 135) {
                    mPEGTrackMetadata.codec = Codec.AC3;
                } else if ((i2 >= 136 && i2 <= 143) || (i2 >= 152 && i2 <= 159)) {
                    mPEGTrackMetadata.codec = Codec.DTS;
                } else if (i2 >= 160 && i2 <= 175) {
                    mPEGTrackMetadata.codec = Codec.PCM_DVD;
                } else if (i2 >= 176 && i2 <= 191) {
                    mPEGTrackMetadata.codec = Codec.TRUEHD;
                } else if (i2 >= 192 && i2 <= 207) {
                    mPEGTrackMetadata.codec = Codec.AC3;
                }
            } else if (i >= 480 && i <= 495) {
                mPEGTrackMetadata.codec = Codec.MPEG2;
            }
        }
    }

    public static MPSMediaInfo extract(SeekableByteChannel seekableByteChannel) {
        return null;
    }

    public static void main1(String[] strArr) throws Throwable {
        new MPSMediaInfo().getMediaInfo(new File(strArr[0]));
    }

    private void parseElStreams(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            byteBuffer.get();
            byteBuffer.get();
            NIOUtils.read(byteBuffer, byteBuffer.getShort() & 65535);
        }
    }

    private PSM parsePSM(ByteBuffer byteBuffer) {
        byteBuffer.getInt();
        if (byteBuffer.getShort() > 1018) {
            throw new RuntimeException("Invalid PSM");
        }
        byteBuffer.get();
        if ((byteBuffer.get() & 1) != 1) {
            throw new RuntimeException("Invalid PSM");
        }
        NIOUtils.read(byteBuffer, byteBuffer.getShort() & 65535);
        parseElStreams(NIOUtils.read(byteBuffer, byteBuffer.getShort() & 65535));
        byteBuffer.getInt();
        return new PSM();
    }

    private int[] parseSystem(ByteBuffer byteBuffer) {
        NIOUtils.skip(byteBuffer, 12);
        IntArrayList intArrayListCreateIntArrayList = IntArrayList.createIntArrayList();
        while (byteBuffer.remaining() >= 3 && (byteBuffer.get(byteBuffer.position()) & BER.ASN_LONG_LEN) == 128) {
            intArrayListCreateIntArrayList.add(byteBuffer.get() & ExifInterface.MARKER);
            byteBuffer.getShort();
        }
        return intArrayListCreateIntArrayList.toArray();
    }

    public List<MPEGTrackMetadata> getAudioTracks() {
        return null;
    }

    public List<MPEGTrackMetadata> getInfos() {
        return new ArrayList(this.infos.values());
    }

    public List<MPEGTrackMetadata> getMediaInfo(File file) throws Throwable {
        try {
            new NIOUtils.FileReader() { // from class: org.jcodec.codecs.mpeg12.MPSMediaInfo.1
                @Override // org.jcodec.common.io.NIOUtils.FileReader
                public void data(ByteBuffer byteBuffer, long j) {
                    MPSMediaInfo.this.analyseBuffer(byteBuffer, j);
                }

                @Override // org.jcodec.common.io.NIOUtils.FileReader
                public void done() {
                }
            }.readFile(file, 65536, null);
        } catch (MediaInfoDone unused) {
            Logger.info("Media info done");
        }
        return getInfos();
    }

    public MPEGTrackMetadata getVideoTrack() {
        return null;
    }

    @Override // org.jcodec.containers.mps.MPSUtils.PESReader
    public void pes(ByteBuffer byteBuffer, long j, int i, int i2) {
        if (MPSUtils.mediaStream(i2)) {
            MPEGTrackMetadata mPEGTrackMetadata = this.infos.get(Integer.valueOf(i2));
            if (mPEGTrackMetadata == null) {
                mPEGTrackMetadata = new MPEGTrackMetadata(i2);
                this.infos.put(Integer.valueOf(i2), mPEGTrackMetadata);
            }
            if (mPEGTrackMetadata.probeData == null) {
                mPEGTrackMetadata.probeData = NIOUtils.cloneBuffer(byteBuffer);
            }
            int i3 = this.pesTried + 1;
            this.pesTried = i3;
            if (i3 < 100) {
                return;
            }
            deriveMediaInfo();
            throw new MediaInfoDone();
        }
    }
}
