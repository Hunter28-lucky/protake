package org.jcodec.common;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jcodec.common.RunLength;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.io.VLC;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class DictionaryCompressor {

    public static class Int extends DictionaryCompressor {
        private RunLength.Integer getValueStats(int[] iArr) {
            int[] iArrCopyOfInt = Platform.copyOfInt(iArr, iArr.length);
            Arrays.sort(iArrCopyOfInt);
            RunLength.Integer integer = new RunLength.Integer();
            for (int i : iArrCopyOfInt) {
                integer.add(i);
            }
            return integer;
        }

        public void compress(int[] iArr, ByteBuffer byteBuffer) {
            RunLength.Integer valueStats = getValueStats(iArr);
            int[] counts = valueStats.getCounts();
            int[] values = valueStats.getValues();
            int iMax = Math.max(1, (1 << (MathUtil.log2(counts.length) - 2)) - 1);
            VLC vlcBuildCodes = buildCodes(counts, iMax);
            int[] codes = vlcBuildCodes.getCodes();
            int[] codeSizes = vlcBuildCodes.getCodeSizes();
            byteBuffer.putInt(codes.length);
            for (int i = 0; i < codes.length; i++) {
                byteBuffer.put((byte) codeSizes[i]);
                byteBuffer.putShort((short) (codes[i] >>> 16));
                byteBuffer.putInt(values[i]);
            }
            BitWriter bitWriter = new BitWriter(byteBuffer);
            for (int i2 : iArr) {
                for (int i3 = 0; i3 < values.length; i3++) {
                    if (values[i3] == i2) {
                        vlcBuildCodes.writeVLC(bitWriter, i3);
                        if (codes[i3] == iMax) {
                            bitWriter.writeNBit(i3, 16);
                        }
                    }
                }
            }
            bitWriter.flush();
        }
    }

    public static class Long extends DictionaryCompressor {
        private RunLength.Long getValueStats(long[] jArr) {
            long[] jArrCopyOfLong = Platform.copyOfLong(jArr, jArr.length);
            Arrays.sort(jArrCopyOfLong);
            RunLength.Long r0 = new RunLength.Long();
            for (long j : jArrCopyOfLong) {
                r0.add(j);
            }
            return r0;
        }

        public void compress(long[] jArr, ByteBuffer byteBuffer) {
            RunLength.Long valueStats = getValueStats(jArr);
            int[] counts = valueStats.getCounts();
            long[] values = valueStats.getValues();
            VLC vlcBuildCodes = buildCodes(counts, jArr.length / 10);
            int[] codes = vlcBuildCodes.getCodes();
            int[] codeSizes = vlcBuildCodes.getCodeSizes();
            byteBuffer.putInt(codes.length);
            for (int i = 0; i < codes.length; i++) {
                byteBuffer.put((byte) codeSizes[i]);
                byteBuffer.putShort((short) (codes[i] >>> 16));
                byteBuffer.putLong(values[i]);
            }
            BitWriter bitWriter = new BitWriter(byteBuffer);
            for (long j : jArr) {
                for (int i2 = 0; i2 < values.length; i2++) {
                    if (values[i2] == j) {
                        vlcBuildCodes.writeVLC(bitWriter, i2);
                        if (codes[i2] == 15) {
                            bitWriter.writeNBit(16, i2);
                        }
                    }
                }
            }
            bitWriter.flush();
        }
    }

    public VLC buildCodes(int[] iArr, int i) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int[] iArr3 = new int[iArr.length];
        for (int i2 = 0; i2 < Math.min(length, i); i2++) {
            int i3 = 0;
            for (int i4 = 0; i4 < iArr.length; i4++) {
                if (iArr[i4] > iArr[i3]) {
                    i3 = i4;
                }
            }
            iArr2[i3] = i2;
            iArr3[i3] = Math.max(1, MathUtil.log2(i2));
            iArr[i3] = Integer.MIN_VALUE;
        }
        int iLog2 = MathUtil.log2(i);
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (iArr[i5] >= 0) {
                iArr2[i5] = i;
                iArr3[i5] = iLog2;
            }
        }
        return new VLC(iArr2, iArr3);
    }
}
