package org.jcodec.containers.mps.index;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.ts.TsConstants;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.Preconditions;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mps.index.MPSIndex;
import org.jcodec.containers.mps.index.MPSRandomAccessDemuxer;
import org.jcodec.containers.mps.index.MTSIndex;

/* loaded from: classes2.dex */
public class MTSRandomAccessDemuxer {
    private SeekableByteChannel ch;
    private MTSIndex.MTSProgram[] programs;

    public MTSRandomAccessDemuxer(SeekableByteChannel seekableByteChannel, MTSIndex mTSIndex) {
        this.programs = mTSIndex.getPrograms();
        this.ch = seekableByteChannel;
    }

    private MPSIndex getProgram(int i) {
        for (MTSIndex.MTSProgram mTSProgram : this.programs) {
            if (mTSProgram.getTargetGuid() == i) {
                return mTSProgram;
            }
        }
        return null;
    }

    public int[] getGuids() {
        int[] iArr = new int[this.programs.length];
        int i = 0;
        while (true) {
            MTSIndex.MTSProgram[] mTSProgramArr = this.programs;
            if (i >= mTSProgramArr.length) {
                return iArr;
            }
            iArr[i] = mTSProgramArr[i].getTargetGuid();
            i++;
        }
    }

    public MPSRandomAccessDemuxer getProgramDemuxer(final int i) throws IOException {
        return new MPSRandomAccessDemuxer(this.ch, getProgram(i)) { // from class: org.jcodec.containers.mps.index.MTSRandomAccessDemuxer.1
            @Override // org.jcodec.containers.mps.index.MPSRandomAccessDemuxer
            public MPSRandomAccessDemuxer.Stream newStream(SeekableByteChannel seekableByteChannel, MPSIndex.MPSStreamIndex mPSStreamIndex) throws IOException {
                return new MPSRandomAccessDemuxer.Stream(this, mPSStreamIndex, seekableByteChannel) { // from class: org.jcodec.containers.mps.index.MTSRandomAccessDemuxer.1.1
                    @Override // org.jcodec.containers.mps.index.MPSRandomAccessDemuxer.Stream
                    public ByteBuffer fetch(int i2) throws IOException {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i2 * TsConstants.TS_PACKET_SIZE);
                        for (int i3 = 0; i3 < i2; i3++) {
                            ByteBuffer byteBufferFetchFromChannel = NIOUtils.fetchFromChannel(this.source, TsConstants.TS_PACKET_SIZE);
                            Preconditions.checkState(71 == (byteBufferFetchFromChannel.get() & ExifInterface.MARKER));
                            if (((((byteBufferFetchFromChannel.get() & ExifInterface.MARKER) << 8) | (byteBufferFetchFromChannel.get() & ExifInterface.MARKER)) & 8191) == i) {
                                if ((byteBufferFetchFromChannel.get() & ExifInterface.MARKER & 32) != 0) {
                                    NIOUtils.skip(byteBufferFetchFromChannel, byteBufferFetchFromChannel.get() & ExifInterface.MARKER);
                                }
                                byteBufferAllocate.put(byteBufferFetchFromChannel);
                            }
                        }
                        byteBufferAllocate.flip();
                        return byteBufferAllocate;
                    }

                    @Override // org.jcodec.containers.mps.index.MPSRandomAccessDemuxer.Stream
                    public void reset() throws IOException {
                        this.source.setPosition(0L);
                    }

                    @Override // org.jcodec.containers.mps.index.MPSRandomAccessDemuxer.Stream
                    public void skip(long j) throws IOException {
                        SeekableByteChannel seekableByteChannel2 = this.source;
                        seekableByteChannel2.setPosition(seekableByteChannel2.position() + (j * 188));
                    }
                };
            }
        };
    }
}
