package org.jcodec.codecs.vpx.vp9;

import org.jcodec.codecs.vpx.VPXBooleanDecoder;

/* loaded from: classes2.dex */
public class Residual {
    public static int[][] blk_size_lookup = {new int[]{-1, 0, 2}, new int[]{1, 3, 5}, new int[]{4, 6, 8}, new int[]{7, 9, 11}, new int[]{10, 12, -1}};
    private int[][][] coefs;

    public Residual(int[][][] iArr) {
        this.coefs = iArr;
    }

    private static int calcTokenContextCoef0(int i, int i2, int i3, int i4, DecodingContext decodingContext) {
        int[][] aboveNonzeroContext = decodingContext.getAboveNonzeroContext();
        int[][] leftNonzeroContext = decodingContext.getLeftNonzeroContext();
        int subX = i > 0 ? decodingContext.getSubX() : 0;
        int subY = i > 0 ? decodingContext.getSubY() : 0;
        int miFrameWidth = (decodingContext.getMiFrameWidth() << 1) >> subX;
        int miFrameHeight = (decodingContext.getMiFrameHeight() << 1) >> subY;
        int i5 = 1 << i2;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = i3 + i8;
            if (i9 < miFrameWidth) {
                i6 |= aboveNonzeroContext[i][i9];
            }
            int i10 = i4 + i8;
            if (i10 < miFrameHeight) {
                i7 |= leftNonzeroContext[i][i10 & 15];
            }
        }
        return i6 + i7;
    }

    private static int readCoef(int i, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        int[] iArr = Consts.extra_bits[i];
        int i2 = iArr[0];
        int i3 = iArr[1];
        int bit = iArr[2];
        for (int i4 = 0; i4 < i3; i4++) {
            bit += vPXBooleanDecoder.readBit(Consts.cat_probs[i2][i4]) << ((i3 - 1) - i4);
        }
        return bit;
    }

    public static Residual readResidual(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext, ModeInfo modeInfo) {
        Residual residual = new Residual();
        residual.read(i, i2, i3, vPXBooleanDecoder, decodingContext, modeInfo);
        return residual;
    }

    public int[][][] getCoefs() {
        return this.coefs;
    }

    public void read(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext, ModeInfo modeInfo) {
        int uvMode;
        if (modeInfo.isSkip()) {
            return;
        }
        int subX = (1 << decodingContext.getSubX()) - 1;
        int subY = (1 << decodingContext.getSubY()) - 1;
        int[][][] iArr = new int[3][][];
        int i4 = 0;
        while (i4 < 3) {
            int txSize = i4 == 0 ? modeInfo.getTxSize() : Consts.uv_txsize_lookup[i3][modeInfo.getTxSize()][decodingContext.getSubX()][decodingContext.getSubY()];
            int i5 = 1 << txSize;
            int subX2 = 1 << Consts.blW[i3];
            int subY2 = 1 << Consts.blH[i3];
            if (i4 != 0) {
                subX2 >>= decodingContext.getSubX();
                subY2 >>= decodingContext.getSubY();
            }
            int i6 = subX2;
            int subX3 = i << 1;
            int frameWidth = (subX3 + i6) - ((decodingContext.getFrameWidth() + 3) >> 2);
            int subY3 = i2 << 1;
            int frameHeight = (subY3 + subY2) - ((decodingContext.getFrameHeight() + 3) >> 2);
            if (i4 != 0) {
                frameWidth = (frameWidth + subX) >> decodingContext.getSubX();
                frameHeight = (frameHeight + subY) >> decodingContext.getSubY();
                subX3 >>= decodingContext.getSubX();
                subY3 >>= decodingContext.getSubY();
            }
            int i7 = subX3;
            int i8 = subY3;
            if (frameWidth <= 0) {
                frameWidth = 0;
            }
            int i9 = i6 - frameWidth;
            if (frameHeight <= 0) {
                frameHeight = 0;
            }
            int i10 = subY2 - frameHeight;
            iArr[i4] = new int[subY2 * i6][];
            int i11 = 0;
            while (i11 < i10) {
                int i12 = 0;
                while (i12 < i9) {
                    int i13 = i7 + i12;
                    int i14 = i8 + i11;
                    if (i4 == 0) {
                        uvMode = modeInfo.getYMode();
                        if (i3 < 3) {
                            uvMode = ModeInfo.vect4get(modeInfo.getSubModes(), (i11 << 1) + i12);
                        }
                    } else {
                        uvMode = modeInfo.getUvMode();
                    }
                    iArr[i4][i12 + (i6 * i11)] = readOneTU(i4 == 0 ? 0 : 1, i13, i14, txSize, modeInfo.isInter(), uvMode, vPXBooleanDecoder, decodingContext);
                    i12 += i5;
                    i9 = i9;
                    i11 = i11;
                    i10 = i10;
                }
                i11 += i5;
            }
            i4++;
        }
        this.coefs = iArr;
    }

    public int[] readOneTU(int i, int i2, int i3, int i4, boolean z, int i5, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        int tree;
        int i6 = 16 << (i4 << 1);
        int[] iArr = new int[i6];
        int i7 = 0;
        int i8 = (i != 0 || z) ? 0 : Consts.intra_mode_to_tx_type_lookup[i5];
        int[] iArr2 = (i != 0 || z) ? Scan.vp9_default_scan_orders[i4][0] : Scan.vp9_scan_orders[i4][i8][0];
        int[] iArr3 = (i != 0 || z) ? Scan.vp9_default_scan_orders[i4][2] : Scan.vp9_scan_orders[i4][i8][2];
        int[] iArr4 = new int[i6];
        int iCalcTokenContextCoef0 = calcTokenContextCoef0(i, i4, i2, i3, decodingContext);
        int i9 = 0;
        boolean z2 = false;
        while (i9 < i6) {
            int i10 = i4 == 0 ? Consts.coefband_4x4[i9] : Consts.coefband_8x8plus[i9];
            int i11 = iArr2[i9];
            int[] iArr5 = decodingContext.getCoefProbs()[i4][i > 0 ? 1 : i7][z ? 1 : 0][i10][iCalcTokenContextCoef0];
            if (!z2) {
                if ((vPXBooleanDecoder.readBit(iArr5[i7]) == 1 ? 1 : i7) == 0) {
                    break;
                }
            }
            if (vPXBooleanDecoder.readBit(iArr5[1]) == 0) {
                iArr[i11] = i7;
                z2 = true;
            } else {
                if (vPXBooleanDecoder.readBit(iArr5[2]) == 0) {
                    iArr[i11] = 1;
                    tree = 1;
                } else {
                    tree = vPXBooleanDecoder.readTree(Consts.TOKEN_TREE, Consts.PARETO_TABLE[iArr5[2] - 1]);
                    if (tree >= 5) {
                        if (tree < 7) {
                            iArr[i11] = 4;
                        } else {
                            iArr[i11] = 5;
                        }
                        tree = readCoef(tree, vPXBooleanDecoder, decodingContext);
                    } else if (tree == 2) {
                        iArr[i11] = 2;
                    } else {
                        iArr[i11] = 3;
                    }
                }
                if (vPXBooleanDecoder.readBitEq() == 1) {
                    tree = -tree;
                }
                iArr4[i11] = tree;
                z2 = false;
            }
            int i12 = i9 * 2;
            iCalcTokenContextCoef0 = ((iArr[iArr3[i12 + 2]] + 1) + iArr[iArr3[i12 + 3]]) >> 1;
            System.out.println("CTX: " + iCalcTokenContextCoef0);
            i9++;
            i7 = 0;
        }
        return iArr4;
    }

    public Residual() {
    }
}
