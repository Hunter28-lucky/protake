package org.jcodec.containers.mps.index;

import java.nio.ByteBuffer;
import org.jcodec.common.RunLength;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.containers.mps.index.MPSIndex;

/* loaded from: classes2.dex */
public class MTSIndex {
    private MTSProgram[] programs;

    public static class MTSProgram extends MPSIndex {
        private int targetGuid;

        public MTSProgram(long[] jArr, RunLength.Integer integer, MPSIndex.MPSStreamIndex[] mPSStreamIndexArr, int i) {
            super(jArr, integer, mPSStreamIndexArr);
            this.targetGuid = i;
        }

        public static MTSProgram parse(ByteBuffer byteBuffer) {
            return MTSIndex.createMTSProgram(MPSIndex.parseIndex(byteBuffer), byteBuffer.getInt());
        }

        public int getTargetGuid() {
            return this.targetGuid;
        }

        @Override // org.jcodec.containers.mps.index.MPSIndex
        public void serializeTo(ByteBuffer byteBuffer) {
            byteBuffer.putInt(this.targetGuid);
            super.serializeTo(byteBuffer);
        }
    }

    public MTSIndex(MTSProgram[] mTSProgramArr) {
        this.programs = mTSProgramArr;
    }

    public static MTSProgram createMTSProgram(MPSIndex mPSIndex, int i) {
        return new MTSProgram(mPSIndex.pesTokens, mPSIndex.pesStreamIds, mPSIndex.streams, i);
    }

    public static MTSIndex parse(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        MTSProgram[] mTSProgramArr = new MTSProgram[i];
        for (int i2 = 0; i2 < i; i2++) {
            mTSProgramArr[i2] = MTSProgram.parse(NIOUtils.read(byteBuffer, byteBuffer.getInt()));
        }
        return new MTSIndex(mTSProgramArr);
    }

    public int estimateSize() {
        int iEstimateSize = 64;
        for (MTSProgram mTSProgram : this.programs) {
            iEstimateSize += mTSProgram.estimateSize() + 4;
        }
        return iEstimateSize;
    }

    public MTSProgram[] getPrograms() {
        return this.programs;
    }

    public ByteBuffer serialize() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(estimateSize());
        serializeTo(byteBufferAllocate);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public void serializeTo(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.programs.length);
        for (MTSProgram mTSProgram : this.programs) {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            NIOUtils.skip(byteBuffer, 4);
            mTSProgram.serializeTo(byteBuffer);
            byteBufferDuplicate.putInt((byteBuffer.position() - byteBufferDuplicate.position()) - 4);
        }
    }
}
