package net.sourceforge.jaad.aac.huffman;

import defpackage.InterfaceC3289;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.syntax.IBitStream;

/* loaded from: classes2.dex */
public class Huffman implements InterfaceC3289 {
    private static final int PAIR_LEN = 2;
    private static final int QUAD_LEN = 4;
    private static final boolean[] UNSIGNED = {false, false, true, true, false, false, true, true, true, true, true};

    private Huffman() {
    }

    public static int decodeScaleFactor(IBitStream iBitStream) throws AACException {
        int[][] iArr = InterfaceC3289.f11545;
        return iArr[findOffset(iBitStream, iArr)][2];
    }

    public static void decodeSpectralData(IBitStream iBitStream, int i, int[] iArr, int i2) throws AACException {
        int i3 = i - 1;
        int[][] iArr2 = InterfaceC3289.f11546[i3];
        int[] iArr3 = iArr2[findOffset(iBitStream, iArr2)];
        iArr[i2] = iArr3[2];
        int i4 = i2 + 1;
        iArr[i4] = iArr3[3];
        if (i < 5) {
            iArr[i2 + 2] = iArr3[4];
            iArr[i2 + 3] = iArr3[5];
        }
        if (i < 11) {
            if (UNSIGNED[i3]) {
                signValues(iBitStream, iArr, i2, i < 5 ? 4 : 2);
            }
        } else {
            if (i != 11 && i <= 15) {
                throw new AACException("Huffman: unknown spectral codebook: " + i);
            }
            signValues(iBitStream, iArr, i2, i < 5 ? 4 : 2);
            if (Math.abs(iArr[i2]) == 16) {
                iArr[i2] = getEscape(iBitStream, iArr[i2]);
            }
            if (Math.abs(iArr[i4]) == 16) {
                iArr[i4] = getEscape(iBitStream, iArr[i4]);
            }
        }
    }

    private static int findOffset(IBitStream iBitStream, int[][] iArr) throws AACException {
        int i = iArr[0][0];
        int bits = iBitStream.readBits(i);
        int i2 = 0;
        while (bits != iArr[i2][1]) {
            i2++;
            int i3 = iArr[i2][0];
            int i4 = i3 - i;
            bits = (bits << i4) | iBitStream.readBits(i4);
            i = i3;
        }
        return i2;
    }

    private static int getEscape(IBitStream iBitStream, int i) throws AACException {
        boolean z = i < 0;
        int i2 = 4;
        while (iBitStream.readBool()) {
            i2++;
        }
        int bits = iBitStream.readBits(i2) | (1 << i2);
        return z ? -bits : bits;
    }

    private static void signValues(IBitStream iBitStream, int[] iArr, int i, int i2) throws AACException {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (iArr[i3] != 0 && iBitStream.readBool()) {
                iArr[i3] = -iArr[i3];
            }
        }
    }
}
