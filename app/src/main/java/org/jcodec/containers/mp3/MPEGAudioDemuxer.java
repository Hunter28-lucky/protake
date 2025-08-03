package org.jcodec.containers.mp3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.uc.crashsdk.export.LogType;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.codecs.vpx.vp9.Consts;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.Codec;
import org.jcodec.common.Demuxer;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.TrackType;
import org.jcodec.common.UsedViaReflection;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Packet;
import org.jcodec.containers.mps.MPSUtils;

/* loaded from: classes2.dex */
public class MPEGAudioDemuxer implements Demuxer, DemuxerTrack {
    private static final int MAX_FRAME_SIZE = 1728;
    private static final int MIN_FRAME_SIZE = 52;
    private static final int MPEG1 = 3;
    private static final int MPEG2 = 2;
    private static final int MPEG25 = 0;
    private SeekableByteChannel ch;
    private boolean eof;
    private int frameNo;
    private DemuxerTrackMeta meta;
    private ByteBuffer readBuffer = ByteBuffer.allocate(262144);
    private int runningFour;
    private int sampleRate;
    private List<DemuxerTrack> tracks;
    private static final int CHANNELS = field(6, 2);
    private static final int PADDING = field(9, 1);
    private static final int SAMPLE_RATE = field(10, 2);
    private static final int BITRATE = field(12, 4);
    private static final int VERSION = field(19, 2);
    private static final int LAYER = field(17, 2);
    private static final int SYNC = field(21, 11);
    private static int[][][] bitrateTable = {new int[][]{new int[]{0, 32, 64, 96, 128, Consts.BORDERINPIXELS, 192, 224, 256, 288, 320, 352, 384, TypedValues.CycleType.TYPE_PATH_ROTATE, MPSUtils.AUDIO_MIN}, new int[]{0, 32, 48, 56, 64, 80, 96, 112, 128, Consts.BORDERINPIXELS, 192, 224, 256, 320, 384}, new int[]{0, 32, 40, 48, 56, 64, 80, 96, 112, 128, Consts.BORDERINPIXELS, 192, 224, 256, 320}}, new int[][]{new int[]{0, 32, 48, 56, 64, 80, 96, 112, 128, 144, Consts.BORDERINPIXELS, 176, 192, 224, 256}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, Consts.BORDERINPIXELS}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, Consts.BORDERINPIXELS}}};
    private static int[] freqTab = {44100, 48000, LogType.UNEXP_KNOWN_REASON};
    private static int[] rateReductTab = {2, 0, 1, 0};

    public MPEGAudioDemuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        this.ch = seekableByteChannel;
        readMoreData();
        if (this.readBuffer.remaining() < 4) {
            this.eof = true;
        } else {
            int i = this.readBuffer.getInt();
            this.runningFour = i;
            if (!validHeader(i)) {
                this.eof = skipJunk();
            }
            extractMeta();
        }
        ArrayList arrayList = new ArrayList();
        this.tracks = arrayList;
        arrayList.add(this);
    }

    private static int calcFrameSize(int i) {
        int field = getField(i, BITRATE);
        int field2 = 3 - getField(i, LAYER);
        int field3 = getField(i, VERSION);
        int i2 = bitrateTable[field3 != 3 ? (char) 1 : (char) 0][field2][field] * 1000;
        int i3 = freqTab[getField(i, SAMPLE_RATE)] >> rateReductTab[field3];
        int field4 = getField(i, PADDING);
        return field2 != 0 ? field2 != 1 ? ((i2 * 144) / (i3 << ((field3 == 0 || field3 == 2) ? 1 : 0))) + field4 : ((i2 * 144) / i3) + field4 : (((i2 * 12) / i3) + field4) * 4;
    }

    private void extractMeta() {
        if (validHeader(this.runningFour)) {
            int field = 3 - getField(this.runningFour, LAYER);
            int i = getField(this.runningFour, CHANNELS) == 3 ? 1 : 2;
            int i2 = freqTab[getField(this.runningFour, SAMPLE_RATE)] >> rateReductTab[getField(this.runningFour, VERSION)];
            this.sampleRate = i2;
            this.meta = new DemuxerTrackMeta(TrackType.AUDIO, field == 2 ? Codec.MP3 : field == 1 ? Codec.MP2 : Codec.MP1, 0.0d, null, 0, null, null, AudioCodecMeta.createAudioCodecMeta(".mp3", 16, i, i2, ByteOrder.LITTLE_ENDIAN, false, null, null));
        }
    }

    private static int field(int i, int i2) {
        return i | (((1 << i2) - 1) << 16);
    }

    private static int getField(int i, int i2) {
        return (i >> (65535 & i2)) & (i2 >> 16);
    }

    @UsedViaReflection
    public static int probe(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        int iSkipJunkBB = byteBufferDuplicate.getInt();
        int i = 0;
        int i2 = 0;
        do {
            if (!validHeader(iSkipJunkBB)) {
                iSkipJunkBB = skipJunkBB(iSkipJunkBB, byteBufferDuplicate);
            }
            int iCalcFrameSize = calcFrameSize(iSkipJunkBB);
            if (byteBufferDuplicate.remaining() < iCalcFrameSize) {
                break;
            }
            i++;
            if (iCalcFrameSize > 0) {
                NIOUtils.skip(byteBufferDuplicate, iCalcFrameSize - 4);
            } else {
                iSkipJunkBB = skipJunkBB(iSkipJunkBB, byteBufferDuplicate);
            }
            if (byteBufferDuplicate.remaining() >= 4) {
                iSkipJunkBB = byteBufferDuplicate.getInt();
                if (iCalcFrameSize >= 52 && iCalcFrameSize <= MAX_FRAME_SIZE && validHeader(iSkipJunkBB)) {
                    i2++;
                }
            }
        } while (byteBufferDuplicate.remaining() >= 4);
        return (i2 * 100) / i;
    }

    private boolean readFrame(ByteBuffer byteBuffer) throws IOException {
        boolean z = false;
        while (byteBuffer.hasRemaining()) {
            byteBuffer.put((byte) (this.runningFour >> 24));
            this.runningFour <<= 8;
            if (!this.readBuffer.hasRemaining()) {
                readMoreData();
            }
            if (this.readBuffer.hasRemaining()) {
                this.runningFour |= this.readBuffer.get() & ExifInterface.MARKER;
            } else {
                z = true;
            }
        }
        return z;
    }

    private void readMoreData() throws IOException {
        this.readBuffer.clear();
        this.ch.read(this.readBuffer);
        this.readBuffer.flip();
    }

    private boolean skipJunk() throws IOException {
        boolean z;
        int i = 0;
        while (true) {
            if (validHeader(this.runningFour)) {
                z = false;
                break;
            }
            if (!this.readBuffer.hasRemaining()) {
                readMoreData();
            }
            if (!this.readBuffer.hasRemaining()) {
                z = true;
                break;
            }
            int i2 = this.runningFour << 8;
            this.runningFour = i2;
            this.runningFour = i2 | (this.readBuffer.get() & ExifInterface.MARKER);
            i++;
        }
        Logger.warn(String.format("[mp3demuxer] Skipped %d bytes of junk", Integer.valueOf(i)));
        return z;
    }

    private static int skipJunkBB(int i, ByteBuffer byteBuffer) {
        while (!validHeader(i) && byteBuffer.hasRemaining()) {
            i = (i << 8) | (byteBuffer.get() & ExifInterface.MARKER);
        }
        return i;
    }

    private static boolean validHeader(int i) {
        return (getField(i, SYNC) != 2047 || getField(i, LAYER) == 0 || getField(i, SAMPLE_RATE) == 3 || getField(i, BITRATE) == 15) ? false : true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ch.close();
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getAudioTracks() {
        return this.tracks;
    }

    @Override // org.jcodec.common.DemuxerTrack
    public DemuxerTrackMeta getMeta() {
        return this.meta;
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getTracks() {
        return this.tracks;
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getVideoTracks() {
        return null;
    }

    @Override // org.jcodec.common.DemuxerTrack
    public Packet nextFrame() throws IOException {
        if (this.eof) {
            return null;
        }
        if (!validHeader(this.runningFour)) {
            this.eof = skipJunk();
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(calcFrameSize(this.runningFour));
        this.eof = readFrame(byteBufferAllocate);
        byteBufferAllocate.flip();
        Packet packet = new Packet(byteBufferAllocate, r1 * 1152, this.sampleRate, 1152L, this.frameNo, Packet.FrameType.KEY, null, 0);
        this.frameNo++;
        return packet;
    }
}
