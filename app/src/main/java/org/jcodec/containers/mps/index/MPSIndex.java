package org.jcodec.containers.mps.index;

import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import org.jcodec.common.RunLength;

/* loaded from: classes2.dex */
public class MPSIndex {
    public RunLength.Integer pesStreamIds;
    public long[] pesTokens;
    public MPSStreamIndex[] streams;

    public static class MPSStreamIndex {
        public int[] fdur;
        public int[] fpts;
        public int[] fsizes;
        public int streamId;
        public int[] sync;

        public MPSStreamIndex(int i, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
            this.streamId = i;
            this.fsizes = iArr;
            this.fpts = iArr2;
            this.fdur = iArr3;
            this.sync = iArr4;
        }

        public static MPSStreamIndex parseIndex(ByteBuffer byteBuffer) {
            int i = byteBuffer.get() & ExifInterface.MARKER;
            int i2 = byteBuffer.getInt();
            int[] iArr = new int[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                iArr[i3] = byteBuffer.getInt();
            }
            int i4 = byteBuffer.getInt();
            int[] iArr2 = new int[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                iArr2[i5] = byteBuffer.getInt();
            }
            int i6 = byteBuffer.getInt();
            int[] iArr3 = new int[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                iArr3[i7] = byteBuffer.getInt();
            }
            int i8 = byteBuffer.getInt();
            int[] iArr4 = new int[i8];
            for (int i9 = 0; i9 < i8; i9++) {
                iArr4[i9] = byteBuffer.getInt();
            }
            return new MPSStreamIndex(i, iArr, iArr2, iArr3, iArr4);
        }

        public int estimateSize() {
            return (this.fpts.length << 2) + (this.fdur.length << 2) + (this.sync.length << 2) + (this.fsizes.length << 2) + 64;
        }

        public int[] getFdur() {
            return this.fdur;
        }

        public int[] getFpts() {
            return this.fpts;
        }

        public int[] getFsizes() {
            return this.fsizes;
        }

        public int getStreamId() {
            return this.streamId;
        }

        public int[] getSync() {
            return this.sync;
        }

        public void serialize(ByteBuffer byteBuffer) {
            byteBuffer.put((byte) this.streamId);
            byteBuffer.putInt(this.fsizes.length);
            int i = 0;
            int i2 = 0;
            while (true) {
                int[] iArr = this.fsizes;
                if (i2 >= iArr.length) {
                    break;
                }
                byteBuffer.putInt(iArr[i2]);
                i2++;
            }
            byteBuffer.putInt(this.fpts.length);
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.fpts;
                if (i3 >= iArr2.length) {
                    break;
                }
                byteBuffer.putInt(iArr2[i3]);
                i3++;
            }
            byteBuffer.putInt(this.fdur.length);
            int i4 = 0;
            while (true) {
                int[] iArr3 = this.fdur;
                if (i4 >= iArr3.length) {
                    break;
                }
                byteBuffer.putInt(iArr3[i4]);
                i4++;
            }
            byteBuffer.putInt(this.sync.length);
            while (true) {
                int[] iArr4 = this.sync;
                if (i >= iArr4.length) {
                    return;
                }
                byteBuffer.putInt(iArr4[i]);
                i++;
            }
        }
    }

    public MPSIndex(long[] jArr, RunLength.Integer integer, MPSStreamIndex[] mPSStreamIndexArr) {
        this.pesTokens = jArr;
        this.pesStreamIds = integer;
        this.streams = mPSStreamIndexArr;
    }

    public static int leadingSize(long j) {
        return ((int) (j >> 48)) & 65535;
    }

    public static long makePESToken(long j, long j2, long j3) {
        return (j << 48) | (j2 << 24) | j3;
    }

    public static MPSIndex parseIndex(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = byteBuffer.getLong();
        }
        RunLength.Integer integer = RunLength.Integer.parse(byteBuffer);
        int i3 = byteBuffer.getInt();
        MPSStreamIndex[] mPSStreamIndexArr = new MPSStreamIndex[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            mPSStreamIndexArr[i4] = MPSStreamIndex.parseIndex(byteBuffer);
        }
        return new MPSIndex(jArr, integer, mPSStreamIndexArr);
    }

    public static int payLoadSize(long j) {
        return ((int) j) & ViewCompat.MEASURED_SIZE_MASK;
    }

    public static int pesLen(long j) {
        return ((int) (j >> 24)) & ViewCompat.MEASURED_SIZE_MASK;
    }

    public int estimateSize() {
        int length = (this.pesTokens.length << 3) + this.pesStreamIds.estimateSize();
        for (MPSStreamIndex mPSStreamIndex : this.streams) {
            length += mPSStreamIndex.estimateSize();
        }
        return length + 64;
    }

    public RunLength.Integer getPesStreamIds() {
        return this.pesStreamIds;
    }

    public long[] getPesTokens() {
        return this.pesTokens;
    }

    public MPSStreamIndex[] getStreams() {
        return this.streams;
    }

    public void serializeTo(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.pesTokens.length);
        int i = 0;
        while (true) {
            long[] jArr = this.pesTokens;
            if (i >= jArr.length) {
                break;
            }
            byteBuffer.putLong(jArr[i]);
            i++;
        }
        this.pesStreamIds.serialize(byteBuffer);
        byteBuffer.putInt(this.streams.length);
        for (MPSStreamIndex mPSStreamIndex : this.streams) {
            mPSStreamIndex.serialize(byteBuffer);
        }
    }
}
