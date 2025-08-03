package org.jcodec.codecs.vpx;

import com.google.zxing.oned.Code39Reader;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class VPXBitstream {
    public static final int[] coeffBandMapping = {0, 1, 2, 3, 6, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7};
    private int[][] dctNzTop;
    private int[][][][] tokenBinProbs;
    private int[] whtNzTop;
    private int whtNzLeft = 0;
    private int[][] dctNzLeft = {new int[4], new int[2], new int[2]};

    public VPXBitstream(int[][][][] iArr, int i) {
        this.tokenBinProbs = iArr;
        this.whtNzTop = new int[i];
        int i2 = i << 1;
        this.dctNzTop = new int[][]{new int[i << 2], new int[i2], new int[i2]};
    }

    private int countCoeff(int[] iArr, int i) {
        while (i > 0) {
            i--;
            if (iArr[i] != 0) {
                return i + 1;
            }
        }
        return i;
    }

    private int fastCountCoeffWHT(int[] iArr) {
        if (iArr[15] != 0) {
            return 16;
        }
        return countCoeff(iArr, 15);
    }

    private static void writeCat3Ext(VPXBooleanEncoder vPXBooleanEncoder, int i) {
        int i2 = i - 11;
        vPXBooleanEncoder.writeBit(173, i2 >> 2);
        vPXBooleanEncoder.writeBit(Code39Reader.ASTERISK_ENCODING, (i2 >> 1) & 1);
        vPXBooleanEncoder.writeBit(140, i2 & 1);
    }

    private static void writeCat4Ext(VPXBooleanEncoder vPXBooleanEncoder, int i) {
        int i2 = i - 19;
        vPXBooleanEncoder.writeBit(176, i2 >> 3);
        vPXBooleanEncoder.writeBit(155, (i2 >> 2) & 1);
        vPXBooleanEncoder.writeBit(140, (i2 >> 1) & 1);
        vPXBooleanEncoder.writeBit(135, i2 & 1);
    }

    private static final void writeCatExt(VPXBooleanEncoder vPXBooleanEncoder, int i, int i2, int[] iArr) {
        int i3 = i - i2;
        int length = iArr.length - 1;
        int i4 = 0;
        while (length >= 0) {
            vPXBooleanEncoder.writeBit(iArr[i4], (i3 >> length) & 1);
            length--;
            i4++;
        }
    }

    public void encodeCoeffs(VPXBooleanEncoder vPXBooleanEncoder, int[] iArr, int i, int i2, int i3, int i4) {
        boolean z = false;
        while (i < i2) {
            int[] iArr2 = this.tokenBinProbs[i3][coeffBandMapping[i]][i4];
            int iAbs = MathUtil.abs(iArr[i]);
            if (!z) {
                vPXBooleanEncoder.writeBit(iArr2[0], 1);
            }
            if (iAbs == 0) {
                vPXBooleanEncoder.writeBit(iArr2[1], 0);
                i4 = 0;
            } else {
                vPXBooleanEncoder.writeBit(iArr2[1], 1);
                int i5 = 2;
                if (iAbs == 1) {
                    vPXBooleanEncoder.writeBit(iArr2[2], 0);
                    i5 = 1;
                } else {
                    vPXBooleanEncoder.writeBit(iArr2[2], 1);
                    if (iAbs <= 4) {
                        vPXBooleanEncoder.writeBit(iArr2[3], 0);
                        if (iAbs == 2) {
                            vPXBooleanEncoder.writeBit(iArr2[4], 0);
                        } else {
                            vPXBooleanEncoder.writeBit(iArr2[4], 1);
                            vPXBooleanEncoder.writeBit(iArr2[5], iAbs - 3);
                        }
                    } else {
                        vPXBooleanEncoder.writeBit(iArr2[3], 1);
                        if (iAbs <= 10) {
                            vPXBooleanEncoder.writeBit(iArr2[6], 0);
                            if (iAbs <= 6) {
                                vPXBooleanEncoder.writeBit(iArr2[7], 0);
                                vPXBooleanEncoder.writeBit(159, iAbs - 5);
                            } else {
                                vPXBooleanEncoder.writeBit(iArr2[7], 1);
                                int i6 = iAbs - 7;
                                vPXBooleanEncoder.writeBit(165, i6 >> 1);
                                vPXBooleanEncoder.writeBit(145, i6 & 1);
                            }
                        } else {
                            vPXBooleanEncoder.writeBit(iArr2[6], 1);
                            if (iAbs <= 34) {
                                vPXBooleanEncoder.writeBit(iArr2[8], 0);
                                if (iAbs <= 18) {
                                    vPXBooleanEncoder.writeBit(iArr2[9], 0);
                                    writeCat3Ext(vPXBooleanEncoder, iAbs);
                                } else {
                                    vPXBooleanEncoder.writeBit(iArr2[9], 1);
                                    writeCat4Ext(vPXBooleanEncoder, iAbs);
                                }
                            } else {
                                vPXBooleanEncoder.writeBit(iArr2[8], 1);
                                if (iAbs <= 66) {
                                    vPXBooleanEncoder.writeBit(iArr2[10], 0);
                                    writeCatExt(vPXBooleanEncoder, iAbs, 35, VPXConst.probCoeffExtCat5);
                                } else {
                                    vPXBooleanEncoder.writeBit(iArr2[10], 1);
                                    writeCatExt(vPXBooleanEncoder, iAbs, 67, VPXConst.probCoeffExtCat6);
                                }
                            }
                        }
                    }
                }
                vPXBooleanEncoder.writeBit(128, MathUtil.sign(iArr[i]));
                i4 = i5;
            }
            z = iAbs == 0;
            i++;
        }
        if (i2 < 16) {
            vPXBooleanEncoder.writeBit(this.tokenBinProbs[i3][coeffBandMapping[i]][i4][0], 0);
        }
    }

    public void encodeCoeffsDCT15(VPXBooleanEncoder vPXBooleanEncoder, int[] iArr, int i, int i2, int i3) {
        int iCountCoeff = countCoeff(iArr, 16);
        int i4 = (i << 2) + i2;
        encodeCoeffs(vPXBooleanEncoder, iArr, 1, iCountCoeff, 0, ((i4 == 0 || this.dctNzLeft[0][i3] <= 0) ? 0 : 1) + (this.dctNzTop[0][i4] > 0 ? 1 : 0));
        int i5 = iCountCoeff - 1;
        this.dctNzLeft[0][i3] = Math.max(i5, 0);
        this.dctNzTop[0][i4] = Math.max(i5, 0);
    }

    public void encodeCoeffsDCT16(VPXBooleanEncoder vPXBooleanEncoder, int[] iArr, int i, int i2, int i3) {
        int iCountCoeff = countCoeff(iArr, 16);
        int i4 = (i << 2) + i2;
        encodeCoeffs(vPXBooleanEncoder, iArr, 0, iCountCoeff, 3, ((i4 == 0 || this.dctNzLeft[0][i3] <= 0) ? 0 : 1) + (this.dctNzTop[0][i4] <= 0 ? 0 : 1));
        this.dctNzLeft[0][i3] = iCountCoeff;
        this.dctNzTop[0][i4] = iCountCoeff;
    }

    public void encodeCoeffsDCTUV(VPXBooleanEncoder vPXBooleanEncoder, int[] iArr, int i, int i2, int i3, int i4) {
        int iCountCoeff = countCoeff(iArr, 16);
        int i5 = (i2 << 1) + i3;
        encodeCoeffs(vPXBooleanEncoder, iArr, 0, iCountCoeff, 2, ((i5 == 0 || this.dctNzLeft[i][i4] <= 0) ? 0 : 1) + (this.dctNzTop[i][i5] <= 0 ? 0 : 1));
        this.dctNzLeft[i][i4] = iCountCoeff;
        this.dctNzTop[i][i5] = iCountCoeff;
    }

    public void encodeCoeffsWHT(VPXBooleanEncoder vPXBooleanEncoder, int[] iArr, int i) {
        int iFastCountCoeffWHT = fastCountCoeffWHT(iArr);
        encodeCoeffs(vPXBooleanEncoder, iArr, 0, iFastCountCoeffWHT, 1, ((i == 0 || this.whtNzLeft <= 0) ? 0 : 1) + (this.whtNzTop[i] <= 0 ? 0 : 1));
        this.whtNzLeft = iFastCountCoeffWHT;
        this.whtNzTop[i] = iFastCountCoeffWHT;
    }
}
