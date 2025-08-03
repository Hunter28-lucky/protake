package org.jcodec.containers.mps.index;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.ts.TsConstants;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.Preconditions;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.logging.Logger;
import org.jcodec.containers.mps.MPSUtils;
import org.jcodec.containers.mps.MTSUtils;
import org.jcodec.containers.mps.PESPacket;
import org.jcodec.containers.mps.index.MTSIndex;

/* loaded from: classes2.dex */
public class MTSIndexer {
    public static final int BUFFER_SIZE = 96256;
    private MTSAnalyser[] indexers;

    public static class MTSAnalyser extends BaseIndexer {
        private long predFileStartInTsPkt;
        private int targetGuid;

        public MTSAnalyser(int i) {
            this.targetGuid = i;
        }

        @Override // org.jcodec.containers.mps.MPSUtils.PESReader
        public void pes(ByteBuffer byteBuffer, long j, int i, int i2) {
            if (MPSUtils.mediaStream(i2)) {
                Logger.debug(String.format("PES: %08x, %d", Long.valueOf(j), Integer.valueOf(i)));
                PESPacket pESHeader = MPSUtils.readPESHeader(byteBuffer, j);
                long j2 = this.predFileStartInTsPkt;
                int i3 = j2 != j ? (int) ((j / 188) - j2) : 0;
                this.predFileStartInTsPkt = (i + j) / 188;
                savePESMeta(i2, MPSIndex.makePESToken(i3, (int) (r3 - (j / 188)), byteBuffer.remaining()));
                getAnalyser(i2).pkt(byteBuffer, pESHeader);
            }
        }

        public MTSIndex.MTSProgram serializeTo() {
            return MTSIndex.createMTSProgram(super.serialize(), this.targetGuid);
        }
    }

    public static final class MTSFileReader extends NIOUtils.FileReader {
        private MTSIndexer indexer;

        public MTSFileReader(MTSIndexer mTSIndexer) {
            this.indexer = mTSIndexer;
        }

        public void analyseBuffer(ByteBuffer byteBuffer, long j) {
            while (byteBuffer.hasRemaining()) {
                ByteBuffer byteBuffer2 = NIOUtils.read(byteBuffer, TsConstants.TS_PACKET_SIZE);
                j += 188;
                Preconditions.checkState(71 == (byteBuffer2.get() & ExifInterface.MARKER));
                int i = (((byteBuffer2.get() & ExifInterface.MARKER) << 8) | (byteBuffer2.get() & ExifInterface.MARKER)) & 8191;
                for (int i2 = 0; i2 < this.indexer.indexers.length; i2++) {
                    if (i == this.indexer.indexers[i2].targetGuid) {
                        if ((byteBuffer2.get() & ExifInterface.MARKER & 32) != 0) {
                            NIOUtils.skip(byteBuffer2, byteBuffer2.get() & ExifInterface.MARKER);
                        }
                        this.indexer.indexers[i2].analyseBuffer(byteBuffer2, j - byteBuffer2.remaining());
                    }
                }
            }
        }

        @Override // org.jcodec.common.io.NIOUtils.FileReader
        public void data(ByteBuffer byteBuffer, long j) {
            analyseBuffer(byteBuffer, j);
        }

        @Override // org.jcodec.common.io.NIOUtils.FileReader
        public void done() {
            for (MTSAnalyser mTSAnalyser : this.indexer.indexers) {
                mTSAnalyser.finishAnalyse();
            }
        }
    }

    public static void main1(String[] strArr) throws Throwable {
        File file = new File(strArr[0]);
        MTSIndexer mTSIndexer = new MTSIndexer();
        mTSIndexer.index(file, new NIOUtils.FileReaderListener() { // from class: org.jcodec.containers.mps.index.MTSIndexer.1
            @Override // org.jcodec.common.io.NIOUtils.FileReaderListener
            public void progress(int i) {
                System.out.println(i);
            }
        });
        NIOUtils.writeTo(mTSIndexer.serialize().serialize(), new File(strArr[1]));
    }

    public void index(File file, NIOUtils.FileReaderListener fileReaderListener) throws Throwable {
        indexReader(fileReaderListener, MTSUtils.getMediaPids(file)).readFile(file, 96256, fileReaderListener);
    }

    public void indexChannel(SeekableByteChannel seekableByteChannel, NIOUtils.FileReaderListener fileReaderListener) throws IOException {
        indexReader(fileReaderListener, MTSUtils.getMediaPidsFromChannel(seekableByteChannel)).readChannel(seekableByteChannel, 96256, fileReaderListener);
    }

    public NIOUtils.FileReader indexReader(NIOUtils.FileReaderListener fileReaderListener, int[] iArr) throws IOException {
        this.indexers = new MTSAnalyser[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.indexers[i] = new MTSAnalyser(iArr[i]);
        }
        return new MTSFileReader(this);
    }

    public MTSIndex serialize() {
        MTSIndex.MTSProgram[] mTSProgramArr = new MTSIndex.MTSProgram[this.indexers.length];
        int i = 0;
        while (true) {
            MTSAnalyser[] mTSAnalyserArr = this.indexers;
            if (i >= mTSAnalyserArr.length) {
                return new MTSIndex(mTSProgramArr);
            }
            mTSProgramArr[i] = mTSAnalyserArr[i].serializeTo();
            i++;
        }
    }
}
