package net.sourceforge.jaad.aac.error;

import androidx.core.view.InputDeviceCompat;
import defpackage.InterfaceC4702;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.syntax.IBitStream;
import net.sourceforge.jaad.aac.syntax.ICSInfo;
import net.sourceforge.jaad.aac.syntax.ICStream;

/* loaded from: classes2.dex */
public class RVLC implements InterfaceC4702 {
    private static final int ESCAPE_FLAG = 7;

    private void decodeEscapes(IBitStream iBitStream, ICStream iCStream, int[][] iArr) throws AACException {
        ICSInfo info = iCStream.getInfo();
        int windowGroupCount = info.getWindowGroupCount();
        int maxSFB = info.getMaxSFB();
        int[][] iArr2 = {new int[0]};
        iBitStream.readBits(8);
        boolean z = false;
        for (int i = 0; i < windowGroupCount; i++) {
            for (int i2 = 0; i2 < maxSFB; i2++) {
                int i3 = iArr2[i][i2];
                if (i3 == 13 && !z) {
                    z = true;
                } else if (Math.abs(i3) == 7) {
                    int iDecodeHuffmanEscape = decodeHuffmanEscape(iBitStream);
                    if (iArr2[i][i2] == -7) {
                        int[] iArr3 = iArr[i];
                        iArr3[i2] = iArr3[i2] - iDecodeHuffmanEscape;
                    } else {
                        int[] iArr4 = iArr[i];
                        iArr4[i2] = iArr4[i2] + iDecodeHuffmanEscape;
                    }
                }
            }
        }
    }

    private int decodeHuffman(IBitStream iBitStream) throws AACException {
        int[] iArr;
        int i = InterfaceC4702.f15963[0][1];
        int bits = iBitStream.readBits(i);
        int i2 = 0;
        while (true) {
            int[][] iArr2 = InterfaceC4702.f15963;
            iArr = iArr2[i2];
            if (bits == iArr[2] || i >= 10) {
                break;
            }
            i2++;
            int i3 = iArr2[i2][1] - i;
            i += i3;
            bits = (bits << i3) | iBitStream.readBits(i3);
        }
        return iArr[0];
    }

    private int decodeHuffmanEscape(IBitStream iBitStream) throws AACException {
        int[] iArr;
        int i = InterfaceC4702.f15964[0][1];
        int bits = iBitStream.readBits(i);
        int i2 = 0;
        while (true) {
            int[][] iArr2 = InterfaceC4702.f15964;
            iArr = iArr2[i2];
            if (bits == iArr[2] || i >= 21) {
                break;
            }
            i2++;
            int i3 = iArr2[i2][1] - i;
            i += i3;
            bits = (bits << i3) | iBitStream.readBits(i3);
        }
        return iArr[0];
    }

    public void decode(IBitStream iBitStream, ICStream iCStream, int[][] iArr) throws AACException {
        int i = iCStream.getInfo().isEightShortFrame() ? 11 : 9;
        iBitStream.readBool();
        iBitStream.readBits(8);
        iBitStream.readBits(i);
        ICSInfo info = iCStream.getInfo();
        int windowGroupCount = info.getWindowGroupCount();
        int maxSFB = info.getMaxSFB();
        int[][] iArr2 = {new int[0]};
        int globalGain = iCStream.getGlobalGain();
        int iDecodeHuffman = (globalGain - 90) + InputDeviceCompat.SOURCE_ANY;
        boolean z = false;
        boolean z2 = false;
        int iDecodeHuffman2 = 0;
        for (int i2 = 0; i2 < windowGroupCount; i2++) {
            for (int i3 = 0; i3 < maxSFB; i3++) {
                int i4 = iArr2[i2][i3];
                if (i4 != 0) {
                    switch (i4) {
                        case 13:
                            if (z2) {
                                iDecodeHuffman += decodeHuffman(iBitStream);
                                iArr[i2][i3] = iDecodeHuffman;
                                break;
                            } else {
                                iDecodeHuffman = decodeHuffman(iBitStream);
                                z2 = true;
                                break;
                            }
                        case 14:
                        case 15:
                            if (!z) {
                                z = true;
                            }
                            iDecodeHuffman2 += decodeHuffman(iBitStream);
                            iArr[i2][i3] = iDecodeHuffman2;
                            break;
                        default:
                            globalGain += decodeHuffman(iBitStream);
                            iArr[i2][i3] = globalGain;
                            break;
                    }
                } else {
                    iArr[i2][i3] = 0;
                }
            }
        }
        if (z) {
            decodeHuffman(iBitStream);
        }
        if (iBitStream.readBool()) {
            decodeEscapes(iBitStream, iCStream, iArr);
        }
    }
}
