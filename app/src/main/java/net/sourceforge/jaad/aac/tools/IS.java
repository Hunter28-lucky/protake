package net.sourceforge.jaad.aac.tools;

import net.sourceforge.jaad.aac.huffman.HCB;
import net.sourceforge.jaad.aac.syntax.CPE;
import net.sourceforge.jaad.aac.syntax.ICSInfo;
import net.sourceforge.jaad.aac.syntax.ICStream;
import net.sourceforge.jaad.aac.syntax.SyntaxConstants;

/* loaded from: classes2.dex */
public final class IS implements SyntaxConstants, HCB {
    private IS() {
    }

    public static void process(CPE cpe, float[] fArr, float[] fArr2) {
        int[] iArr;
        ICStream rightChannel = cpe.getRightChannel();
        ICSInfo info = rightChannel.getInfo();
        int[] sWBOffsets = info.getSWBOffsets();
        int windowGroupCount = info.getWindowGroupCount();
        int maxSFB = info.getMaxSFB();
        int[] sfbCB = rightChannel.getSfbCB();
        int[] sectEnd = rightChannel.getSectEnd();
        float[] scaleFactors = rightChannel.getScaleFactors();
        int i = 0;
        int i2 = 0;
        int windowGroupLength = 0;
        while (i < windowGroupCount) {
            int i3 = 0;
            while (i3 < maxSFB) {
                int i4 = sfbCB[i2];
                int i5 = 15;
                if (i4 == 15 || i4 == 14) {
                    int i6 = sectEnd[i2];
                    while (i3 < i6) {
                        int i7 = sfbCB[i2] == i5 ? 1 : -1;
                        if (cpe.isMSMaskPresent()) {
                            i7 *= cpe.isMSUsed(i2) ? -1 : 1;
                        }
                        float f = i7 * scaleFactors[i2];
                        int i8 = 0;
                        while (i8 < info.getWindowGroupLength(i)) {
                            int i9 = (i8 * 128) + windowGroupLength + sWBOffsets[i3];
                            float[] fArr3 = scaleFactors;
                            int i10 = 0;
                            while (true) {
                                iArr = sWBOffsets;
                                if (i10 < sWBOffsets[i3 + 1] - sWBOffsets[i3]) {
                                    int i11 = i9 + i10;
                                    fArr2[i11] = fArr[i11] * f;
                                    i10++;
                                    sWBOffsets = iArr;
                                }
                            }
                            i8++;
                            scaleFactors = fArr3;
                            sWBOffsets = iArr;
                        }
                        i3++;
                        i2++;
                        i5 = 15;
                    }
                } else {
                    int i12 = sectEnd[i2];
                    i2 += i12 - i3;
                    i3 = i12;
                }
            }
            windowGroupLength += info.getWindowGroupLength(i) * 128;
            i++;
            scaleFactors = scaleFactors;
        }
    }
}
