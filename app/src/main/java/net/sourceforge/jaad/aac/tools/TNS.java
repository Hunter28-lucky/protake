package net.sourceforge.jaad.aac.tools;

import defpackage.b1;
import java.lang.reflect.Array;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.SampleFrequency;
import net.sourceforge.jaad.aac.syntax.IBitStream;
import net.sourceforge.jaad.aac.syntax.ICSInfo;
import net.sourceforge.jaad.aac.syntax.ICStream;
import net.sourceforge.jaad.aac.syntax.SyntaxConstants;

/* loaded from: classes2.dex */
public class TNS implements SyntaxConstants, b1 {
    private static final int TNS_MAX_ORDER = 20;
    private float[][][] coef;
    private boolean[][] direction;
    private int[][] length;
    private int[] nFilt = new int[8];
    private int[][] order;
    private static final int[] SHORT_BITS = {1, 4, 3};
    private static final int[] LONG_BITS = {2, 6, 5};

    public TNS() {
        Class cls = Integer.TYPE;
        this.length = (int[][]) Array.newInstance((Class<?>) cls, 8, 4);
        this.direction = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, 8, 4);
        this.order = (int[][]) Array.newInstance((Class<?>) cls, 8, 4);
        this.coef = (float[][][]) Array.newInstance((Class<?>) Float.TYPE, 8, 4, 20);
    }

    public void decode(IBitStream iBitStream, ICSInfo iCSInfo) throws AACException {
        int windowCount = iCSInfo.getWindowCount();
        int[] iArr = iCSInfo.isEightShortFrame() ? SHORT_BITS : LONG_BITS;
        for (int i = 0; i < windowCount; i++) {
            int[] iArr2 = this.nFilt;
            int bits = iBitStream.readBits(iArr[0]);
            iArr2[i] = bits;
            if (bits != 0) {
                int bit = iBitStream.readBit();
                for (int i2 = 0; i2 < this.nFilt[i]; i2++) {
                    this.length[i][i2] = iBitStream.readBits(iArr[1]);
                    int[] iArr3 = this.order[i];
                    int bits2 = iBitStream.readBits(iArr[2]);
                    iArr3[i2] = bits2;
                    if (bits2 > 20) {
                        throw new AACException("TNS filter out of range: " + this.order[i][i2]);
                    }
                    if (this.order[i][i2] != 0) {
                        this.direction[i][i2] = iBitStream.readBool();
                        int bit2 = iBitStream.readBit();
                        int i3 = (bit + 3) - bit2;
                        int i4 = (bit2 * 2) + bit;
                        for (int i5 = 0; i5 < this.order[i][i2]; i5++) {
                            this.coef[i][i2][i5] = b1.f92[i4][iBitStream.readBits(i3)];
                        }
                    }
                }
            }
        }
    }

    public void process(ICStream iCStream, float[] fArr, SampleFrequency sampleFrequency, boolean z) {
    }
}
