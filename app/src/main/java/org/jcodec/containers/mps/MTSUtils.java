package org.jcodec.containers.mps;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.Preconditions;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mps.psi.PATSection;
import org.jcodec.containers.mps.psi.PMTSection;
import org.jcodec.containers.mps.psi.PSISection;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class MTSUtils {

    public static class PMTExtractor extends TSReader {
        private PMTSection pmt;
        private int pmtGuid;

        public PMTExtractor() {
            super(false);
            this.pmtGuid = -1;
        }

        public PMTSection getPmt() {
            return this.pmt;
        }

        @Override // org.jcodec.containers.mps.MTSUtils.TSReader
        public boolean onPkt(int i, boolean z, ByteBuffer byteBuffer, long j, boolean z2, ByteBuffer byteBuffer2) {
            if (i == 0) {
                this.pmtGuid = MTSUtils.parsePAT(byteBuffer);
                return true;
            }
            int i2 = this.pmtGuid;
            if (i2 == -1 || i != i2) {
                return true;
            }
            this.pmt = MTSUtils.parsePMT(byteBuffer);
            return false;
        }
    }

    public static abstract class TSReader {
        public static final int BUFFER_SIZE = 96256;
        private static final int TS_PKT_SIZE = 188;
        private static final int TS_SYNC_MARKER = 71;
        private boolean flush;

        public TSReader(boolean z) {
            this.flush = z;
        }

        public boolean onPkt(int i, boolean z, ByteBuffer byteBuffer, long j, boolean z2, ByteBuffer byteBuffer2) {
            return true;
        }

        public void readTsFile(SeekableByteChannel seekableByteChannel) throws IOException {
            seekableByteChannel.setPosition(0L);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(96256);
            while (true) {
                long jPosition = seekableByteChannel.position();
                if (seekableByteChannel.read(byteBufferAllocate) < 188) {
                    return;
                }
                byteBufferAllocate.flip();
                long j = jPosition;
                while (byteBufferAllocate.remaining() >= 188) {
                    ByteBuffer byteBuffer = NIOUtils.read(byteBufferAllocate, 188);
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    j += 188;
                    Preconditions.checkState(71 == (byteBuffer.get() & ExifInterface.MARKER));
                    int i = ((byteBuffer.get() & ExifInterface.MARKER) << 8) | (byteBuffer.get() & ExifInterface.MARKER);
                    int i2 = i & 8191;
                    int i3 = (i >> 14) & 1;
                    if ((byteBuffer.get() & ExifInterface.MARKER & 32) != 0) {
                        NIOUtils.skip(byteBuffer, byteBuffer.get() & ExifInterface.MARKER);
                    }
                    boolean z = i3 == 1 && (NIOUtils.getRel(byteBuffer, NIOUtils.getRel(byteBuffer, 0) + 2) & BER.ASN_LONG_LEN) == 128;
                    if (z) {
                        NIOUtils.skip(byteBuffer, byteBuffer.get() & ExifInterface.MARKER);
                    }
                    if (!onPkt(i2, i3 == 1, byteBuffer, j - byteBuffer.remaining(), z, byteBufferDuplicate)) {
                        return;
                    }
                }
                if (this.flush) {
                    byteBufferAllocate.flip();
                    seekableByteChannel.setPosition(jPosition);
                    seekableByteChannel.write(byteBufferAllocate);
                }
                byteBufferAllocate.clear();
            }
        }
    }

    private static int[] filterMediaPids(PMTSection.PMTStream[] pMTStreamArr) {
        IntArrayList intArrayListCreateIntArrayList = IntArrayList.createIntArrayList();
        for (PMTSection.PMTStream pMTStream : pMTStreamArr) {
            if (pMTStream.getStreamType().isVideo() || pMTStream.getStreamType().isAudio()) {
                intArrayListCreateIntArrayList.add(pMTStream.getPid());
            }
        }
        return intArrayListCreateIntArrayList.toArray();
    }

    public static int getAudioPid(File file) throws Throwable {
        for (PMTSection.PMTStream pMTStream : getProgramGuids(file)) {
            if (pMTStream.getStreamType().isAudio()) {
                return pMTStream.getPid();
            }
        }
        throw new RuntimeException("No audio stream");
    }

    public static int[] getMediaPids(File file) throws IOException {
        return filterMediaPids(getProgramGuids(file));
    }

    public static int[] getMediaPidsFromChannel(SeekableByteChannel seekableByteChannel) throws IOException {
        return filterMediaPids(getProgramGuidsFromChannel(seekableByteChannel));
    }

    public static PMTSection.PMTStream[] getProgramGuids(File file) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        try {
            fileChannelWrapper = NIOUtils.readableChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapper = null;
        }
        try {
            PMTSection.PMTStream[] programGuidsFromChannel = getProgramGuidsFromChannel(fileChannelWrapper);
            NIOUtils.closeQuietly(fileChannelWrapper);
            return programGuidsFromChannel;
        } catch (Throwable th2) {
            th = th2;
            NIOUtils.closeQuietly(fileChannelWrapper);
            throw th;
        }
    }

    public static PMTSection.PMTStream[] getProgramGuidsFromChannel(SeekableByteChannel seekableByteChannel) throws IOException {
        PMTExtractor pMTExtractor = new PMTExtractor();
        pMTExtractor.readTsFile(seekableByteChannel);
        return pMTExtractor.getPmt().getStreams();
    }

    public static int getVideoPid(File file) throws Throwable {
        for (PMTSection.PMTStream pMTStream : getProgramGuids(file)) {
            if (pMTStream.getStreamType().isVideo()) {
                return pMTStream.getPid();
            }
        }
        throw new RuntimeException("No video stream");
    }

    private static void parseEsInfo(ByteBuffer byteBuffer) {
    }

    @Deprecated
    public static int parsePAT(ByteBuffer byteBuffer) {
        PATSection pat = PATSection.parsePAT(byteBuffer);
        if (pat.getPrograms().size() > 0) {
            return pat.getPrograms().values()[0];
        }
        return -1;
    }

    @Deprecated
    public static PMTSection parsePMT(ByteBuffer byteBuffer) {
        return PMTSection.parsePMT(byteBuffer);
    }

    @Deprecated
    public static PSISection parseSection(ByteBuffer byteBuffer) {
        return PSISection.parsePSI(byteBuffer);
    }
}
