package org.jcodec.common.io;

import java.io.PrintStream;
import org.jcodec.common.IntArrayList;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class VLC {
    private int[] codeSizes;
    private int[] codes;
    private int[] valueSizes;
    private int[] values;

    public VLC(int[] iArr, int[] iArr2) {
        this.codes = iArr;
        this.codeSizes = iArr2;
        _invert();
    }

    private void _invert() {
        IntArrayList intArrayListCreateIntArrayList = IntArrayList.createIntArrayList();
        IntArrayList intArrayListCreateIntArrayList2 = IntArrayList.createIntArrayList();
        invert(0, 0, 0, intArrayListCreateIntArrayList, intArrayListCreateIntArrayList2);
        this.values = intArrayListCreateIntArrayList.toArray();
        this.valueSizes = intArrayListCreateIntArrayList2.toArray();
    }

    private static String binary(int i, int i2) {
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = ((1 << ((i2 - i3) - 1)) & i) != 0 ? '1' : '0';
        }
        return Platform.stringFromChars(cArr);
    }

    public static VLC createVLC(String[] strArr) {
        IntArrayList intArrayListCreateIntArrayList = IntArrayList.createIntArrayList();
        IntArrayList intArrayListCreateIntArrayList2 = IntArrayList.createIntArrayList();
        for (String str : strArr) {
            intArrayListCreateIntArrayList.add(Integer.parseInt(str, 2) << (32 - str.length()));
            intArrayListCreateIntArrayList2.add(str.length());
        }
        return new VLC(intArrayListCreateIntArrayList.toArray(), intArrayListCreateIntArrayList2.toArray());
    }

    private static String extracted(int i) {
        String string = Integer.toString(i & 255, 2);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 8 - string.length(); i2++) {
            sb.append("0");
        }
        sb.append(string);
        return sb.toString();
    }

    private int invert(int i, int i2, int i3, IntArrayList intArrayList, IntArrayList intArrayList2) {
        int i4 = i + 256;
        intArrayList.fill(i, i4, -1);
        intArrayList2.fill(i, i4, 0);
        int i5 = i2 << 3;
        int iInvert = i4;
        int i6 = 0;
        while (true) {
            int[] iArr = this.codeSizes;
            if (i6 >= iArr.length) {
                return iInvert;
            }
            int i7 = iArr[i6];
            if (i7 > i5 && (i2 <= 0 || (this.codes[i6] >>> (32 - i5)) == i3)) {
                int i8 = this.codes[i6] >>> ((32 - i5) - 8);
                int i9 = i8 & 255;
                int i10 = i7 - i5;
                if (i10 <= 8) {
                    for (int i11 = 0; i11 < (1 << (8 - i10)); i11++) {
                        int i12 = i + i9 + i11;
                        intArrayList.set(i12, i6);
                        intArrayList2.set(i12, i10);
                    }
                } else {
                    int i13 = i9 + i;
                    if (intArrayList.get(i13) == -1) {
                        intArrayList.set(i13, iInvert);
                        iInvert = invert(iInvert, i2 + 1, i8, intArrayList, intArrayList2);
                    }
                }
            }
            i6++;
        }
    }

    public int[] getCodeSizes() {
        return this.codeSizes;
    }

    public int[] getCodes() {
        return this.codes;
    }

    public void printTable(PrintStream printStream) {
        for (int i = 0; i < this.values.length; i++) {
            printStream.println(i + ": " + extracted(i) + " (" + this.valueSizes[i] + ") -> " + this.values[i]);
        }
    }

    public int readVLC(BitReader bitReader) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i == 0) {
            int iCheckNBit = bitReader.checkNBit(8);
            int i5 = i2 + iCheckNBit;
            int i6 = this.values[i5];
            int i7 = this.valueSizes[i5];
            int i8 = i7 != 0 ? i7 : 8;
            i3 = (i3 << i8) | (iCheckNBit >> (8 - i8));
            bitReader.skip(i8);
            if (i6 == -1) {
                throw new RuntimeException("Invalid code prefix " + binary(i3, (i4 << 3) + i8));
            }
            i4++;
            i = i7;
            i2 = i6;
        }
        return i2;
    }

    public int readVLC16(BitReader bitReader) {
        int iCheck16Bits = bitReader.check16Bits();
        int i = iCheck16Bits >>> 8;
        int[] iArr = this.values;
        int i2 = iArr[i];
        int[] iArr2 = this.valueSizes;
        int i3 = iArr2[i];
        if (i3 != 0) {
            bitReader.skipFast(i3);
            return i2;
        }
        int i4 = (iCheck16Bits & 255) + i2;
        int i5 = iArr[i4];
        bitReader.skipFast(iArr2[i4] + 8);
        return i5;
    }

    public void writeVLC(BitWriter bitWriter, int i) {
        int i2 = this.codes[i];
        int i3 = this.codeSizes[i];
        bitWriter.writeNBit(i2 >>> (32 - i3), i3);
    }
}
