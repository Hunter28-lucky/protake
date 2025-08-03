package org.jcodec.containers.mps.index;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mps.MPSUtils;
import org.jcodec.containers.mps.PESPacket;

/* loaded from: classes2.dex */
public class MPSIndexer extends BaseIndexer {
    private long predFileStart;

    public static void main1(String[] strArr) throws Throwable {
        MPSIndexer mPSIndexer = new MPSIndexer();
        mPSIndexer.index(new File(strArr[0]), new NIOUtils.FileReaderListener() { // from class: org.jcodec.containers.mps.index.MPSIndexer.2
            @Override // org.jcodec.common.io.NIOUtils.FileReaderListener
            public void progress(int i) {
                System.out.println(i);
            }
        });
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(65536);
        mPSIndexer.serialize().serializeTo(byteBufferAllocate);
        NIOUtils.writeTo(byteBufferAllocate, new File(strArr[1]));
    }

    private NIOUtils.FileReader newReader() {
        return new NIOUtils.FileReader() { // from class: org.jcodec.containers.mps.index.MPSIndexer.1
            @Override // org.jcodec.common.io.NIOUtils.FileReader
            public void data(ByteBuffer byteBuffer, long j) {
                this.analyseBuffer(byteBuffer, j);
            }

            @Override // org.jcodec.common.io.NIOUtils.FileReader
            public void done() {
                this.finishAnalyse();
            }
        };
    }

    public void index(File file, NIOUtils.FileReaderListener fileReaderListener) throws Throwable {
        newReader().readFile(file, 65536, fileReaderListener);
    }

    public void indexChannel(SeekableByteChannel seekableByteChannel, NIOUtils.FileReaderListener fileReaderListener) throws IOException {
        newReader().readChannel(seekableByteChannel, 65536, fileReaderListener);
    }

    @Override // org.jcodec.containers.mps.MPSUtils.PESReader
    public void pes(ByteBuffer byteBuffer, long j, int i, int i2) {
        if (MPSUtils.mediaStream(i2)) {
            PESPacket pESHeader = MPSUtils.readPESHeader(byteBuffer, j);
            long j2 = this.predFileStart;
            int i3 = j2 != j ? 0 + ((int) (j - j2)) : 0;
            long j3 = i;
            this.predFileStart = j + j3;
            savePESMeta(i2, MPSIndex.makePESToken(i3, j3, byteBuffer.remaining()));
            getAnalyser(i2).pkt(byteBuffer, pESHeader);
        }
    }
}
