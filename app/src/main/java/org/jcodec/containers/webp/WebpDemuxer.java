package org.jcodec.containers.webp;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.Demuxer;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.UsedViaReflection;
import org.jcodec.common.io.DataReader;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Packet;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class WebpDemuxer implements Demuxer, DemuxerTrack {
    public static final int FOURCC_ALPH = 1213221953;
    public static final int FOURCC_ANIM = 1296649793;
    public static final int FOURCC_ANMF = 1179471425;
    public static final int FOURCC_EXIF = 1179211845;
    public static final int FOURCC_ICCP = 1346585417;
    public static final int FOURCC_RIFF = 1179011410;
    public static final int FOURCC_VP8 = 540561494;
    public static final int FOURCC_VP8L = 1278758998;
    public static final int FOURCC_VP8X = 1480085590;
    public static final int FOURCC_WEBP = 1346520407;
    public static final int FOURCC_XMP = 542133592;
    private boolean done;
    private boolean headerRead;
    private DataReader raf;
    private ArrayList<DemuxerTrack> vt;

    public WebpDemuxer(SeekableByteChannel seekableByteChannel) {
        this.raf = DataReader.createDataReader(seekableByteChannel, ByteOrder.LITTLE_ENDIAN);
        ArrayList<DemuxerTrack> arrayList = new ArrayList<>();
        this.vt = arrayList;
        arrayList.add(this);
    }

    public static String dwToFourCC(int i) {
        return Platform.stringFromChars(new char[]{(char) ((i >> 24) & 255), (char) ((i >> 16) & 255), (char) ((i >> 8) & 255), (char) ((i >> 0) & 255)});
    }

    @UsedViaReflection
    public static int probe(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        if (byteBufferDuplicate.remaining() < 12) {
            return 0;
        }
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        if (byteBufferDuplicate.getInt() != 1179011410) {
            return 0;
        }
        byteBufferDuplicate.getInt();
        return byteBufferDuplicate.getInt() != 1346520407 ? 0 : 100;
    }

    private void readHeader() throws IOException {
        if (this.raf.readInt() != 1179011410) {
            throw new IOException("Invalid RIFF file.");
        }
        this.raf.readInt();
        if (this.raf.readInt() != 1346520407) {
            throw new IOException("Not a WEBP file.");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.raf.close();
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getAudioTracks() {
        return new ArrayList();
    }

    @Override // org.jcodec.common.DemuxerTrack
    public DemuxerTrackMeta getMeta() {
        return null;
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getTracks() {
        return this.vt;
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getVideoTracks() {
        return this.vt;
    }

    @Override // org.jcodec.common.DemuxerTrack
    public Packet nextFrame() throws IOException {
        if (this.done) {
            return null;
        }
        if (!this.headerRead) {
            readHeader();
            this.headerRead = true;
        }
        int i = this.raf.readInt();
        int i2 = this.raf.readInt();
        this.done = true;
        if (i == 540561494) {
            byte[] bArr = new byte[i2];
            this.raf.readFully(bArr);
            return new Packet(ByteBuffer.wrap(bArr), 0L, 25, 1L, 0L, Packet.FrameType.KEY, null, 0);
        }
        Logger.warn("Skipping unsupported chunk: " + dwToFourCC(i) + ".");
        this.raf.readFully(new byte[i2]);
        return null;
    }
}
