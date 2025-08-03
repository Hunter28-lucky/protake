package net.sourceforge.jaad.aac.tools;

import net.sourceforge.jaad.aac.huffman.HCB;
import net.sourceforge.jaad.aac.syntax.CPE;
import net.sourceforge.jaad.aac.syntax.ICSInfo;
import net.sourceforge.jaad.aac.syntax.ICStream;
import net.sourceforge.jaad.aac.syntax.SyntaxConstants;

/* loaded from: classes2.dex */
public final class MS implements SyntaxConstants, HCB {
    private MS() {
    }

    public static void process(CPE cpe, float[] fArr, float[] fArr2) {
        ICStream leftChannel = cpe.getLeftChannel();
        ICSInfo info = leftChannel.getInfo();
        int[] sWBOffsets = info.getSWBOffsets();
        int windowGroupCount = info.getWindowGroupCount();
        int maxSFB = info.getMaxSFB();
        int[] sfbCB = leftChannel.getSfbCB();
        int[] sfbCB2 = cpe.getRightChannel().getSfbCB();
        int windowGroupLength = 0;
        int i = 0;
        for (int i2 = 0; i2 < windowGroupCount; i2++) {
            int i3 = 0;
            while (i3 < maxSFB) {
                if (cpe.isMSUsed(i) && sfbCB[i] < 13 && sfbCB2[i] < 13) {
                    for (int i4 = 0; i4 < info.getWindowGroupLength(i2); i4++) {
                        int i5 = (i4 * 128) + windowGroupLength + sWBOffsets[i3];
                        for (int i6 = 0; i6 < sWBOffsets[i3 + 1] - sWBOffsets[i3]; i6++) {
                            int i7 = i5 + i6;
                            float f = fArr[i7];
                            float f2 = fArr2[i7];
                            fArr[i7] = f + f2;
                            fArr2[i7] = f - f2;
                        }
                    }
                }
                i3++;
                i++;
            }
            windowGroupLength += info.getWindowGroupLength(i2) * 128;
        }
    }
}
