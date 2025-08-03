package org.jcodec.codecs.vpx;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.jcodec.api.NotImplementedException;
import org.jcodec.api.NotSupportedException;
import org.jcodec.codecs.vpx.VP8Util;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class VPXMacroblock {
    public final int Rrow;
    public int chromaMode;
    public final int column;
    public int filterLevel;
    public int lumaMode;
    public VP8Util.QuantizationParams quants;
    public int skipCoeff;
    public boolean skipFilter;
    public int segment = 0;
    public boolean debug = true;
    public final Subblock[][] ySubblocks = (Subblock[][]) Array.newInstance((Class<?>) Subblock.class, 4, 4);
    public final Subblock y2 = new Subblock(this, 0, 0, VP8Util.PLANE.Y2);
    public final Subblock[][] uSubblocks = (Subblock[][]) Array.newInstance((Class<?>) Subblock.class, 2, 2);
    public final Subblock[][] vSubblocks = (Subblock[][]) Array.newInstance((Class<?>) Subblock.class, 2, 2);

    public static class Subblock {
        public int[] _predict;
        private int col;
        public int mode;
        private VP8Util.PLANE plane;
        public int[] residue;
        private int row;
        private VPXMacroblock self;
        public boolean someValuePresent;
        private int[] tokens = new int[16];
        public int[] val;

        public Subblock(VPXMacroblock vPXMacroblock, int i, int i2, VP8Util.PLANE plane) {
            this.self = vPXMacroblock;
            this.row = i;
            this.col = i2;
            this.plane = plane;
        }

        private int DCTextra(VPXBooleanDecoder vPXBooleanDecoder, int[] iArr) {
            int bit = 0;
            int i = 0;
            do {
                bit += vPXBooleanDecoder.readBit(iArr[i]) + bit;
                i++;
            } while (iArr[i] > 0);
            return bit;
        }

        private int decodeToken(VPXBooleanDecoder vPXBooleanDecoder, int i) {
            int iDCTextra = i == 5 ? DCTextra(vPXBooleanDecoder, VP8Util.SubblockConstants.Pcat1) + 5 : i;
            if (i == 6) {
                iDCTextra = DCTextra(vPXBooleanDecoder, VP8Util.SubblockConstants.Pcat2) + 7;
            }
            if (i == 7) {
                iDCTextra = DCTextra(vPXBooleanDecoder, VP8Util.SubblockConstants.Pcat3) + 11;
            }
            if (i == 8) {
                iDCTextra = DCTextra(vPXBooleanDecoder, VP8Util.SubblockConstants.Pcat4) + 19;
            }
            if (i == 9) {
                iDCTextra = DCTextra(vPXBooleanDecoder, VP8Util.SubblockConstants.Pcat5) + 35;
            }
            if (i == 10) {
                iDCTextra = DCTextra(vPXBooleanDecoder, VP8Util.SubblockConstants.Pcat6) + 67;
            }
            return (i == 0 || i == 11 || vPXBooleanDecoder.readBitEq() <= 0) ? iDCTextra : -iDCTextra;
        }

        private int[] getAboveRightLowestRow(VPXMacroblock[][] vPXMacroblockArr) {
            int[] iArr;
            int i;
            int i2;
            if (!VP8Util.PLANE.Y1.equals(this.plane)) {
                throw new NotImplementedException("Decoder.getAboveRight: not implemented for Y2 and chroma planes");
            }
            int i3 = this.row;
            if (i3 == 0 && (i2 = this.col) < 3) {
                VPXMacroblock vPXMacroblock = this.self;
                iArr = vPXMacroblockArr[vPXMacroblock.Rrow - 1][vPXMacroblock.column].ySubblocks[3][i2 + 1].val;
            } else if (i3 > 0 && (i = this.col) < 3) {
                iArr = this.self.ySubblocks[i3 - 1][i + 1].val;
            } else {
                if (i3 != 0 || this.col != 3) {
                    return this.self.ySubblocks[0][3].getAboveRightLowestRow(vPXMacroblockArr);
                }
                VPXMacroblock vPXMacroblock2 = this.self;
                int i4 = vPXMacroblock2.Rrow;
                VPXMacroblock[] vPXMacroblockArr2 = vPXMacroblockArr[i4 - 1];
                int i5 = vPXMacroblock2.column;
                VPXMacroblock vPXMacroblock3 = vPXMacroblockArr2[i5 + 1];
                if (vPXMacroblock3.column < vPXMacroblockArr[0].length - 1) {
                    iArr = vPXMacroblock3.ySubblocks[3][0].val;
                } else {
                    int[] iArr2 = new int[16];
                    Arrays.fill(iArr2, vPXMacroblock3.Rrow == 0 ? 127 : vPXMacroblockArr[i4 - 1][i5].ySubblocks[3][3].val[15]);
                    iArr = iArr2;
                }
            }
            if (iArr == null) {
                iArr = VP8Util.PRED_BLOCK_127;
            }
            return new int[]{iArr[12], iArr[13], iArr[14], iArr[15]};
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void decodeSubBlock(VPXBooleanDecoder vPXBooleanDecoder, int[][][][] iArr, int i, int i2, boolean z) {
            int i3;
            byte b;
            int i4;
            this.someValuePresent = false;
            int i5 = 0;
            byte b2 = false;
            int i6 = 1;
            while (i6 != 11 && (i3 = i5 + (z ? 1 : 0)) < 16) {
                int[] iArr2 = iArr[i2][VP8Util.SubblockConstants.vp8CoefBands[i3]][i];
                int tree = b2 == false ? vPXBooleanDecoder.readTree(VP8Util.SubblockConstants.vp8CoefTree, iArr2) : vPXBooleanDecoder.readTreeSkip(VP8Util.SubblockConstants.vp8CoefTree, iArr2, 1);
                int iDecodeToken = decodeToken(vPXBooleanDecoder, tree);
                if (iDecodeToken == 1 || iDecodeToken == -1) {
                    b = false;
                    i4 = 1;
                } else if (iDecodeToken > 1 || iDecodeToken < -1) {
                    i4 = 2;
                    b = false;
                } else {
                    i4 = 0;
                    b = iDecodeToken == 0;
                }
                if (tree != 11) {
                    this.tokens[VP8Util.SubblockConstants.vp8defaultZigZag1d[i3]] = iDecodeToken;
                }
                i5++;
                i6 = tree;
                i = i4;
                b2 = b;
            }
            for (int i7 = 0; i7 < 16; i7++) {
                if (this.tokens[i7] != 0) {
                    this.someValuePresent = true;
                }
            }
        }

        public void dequantSubblock(int i, int i2, Integer num) {
            int[] iArr = new int[16];
            iArr[0] = this.tokens[0] * i;
            for (int i3 = 1; i3 < 16; i3++) {
                iArr[i3] = this.tokens[i3] * i2;
            }
            if (num != null) {
                iArr[0] = num.intValue();
            }
            this.residue = VP8DCT.decodeDCT(iArr);
        }

        public Subblock getAbove(VP8Util.PLANE plane, VPXMacroblock[][] vPXMacroblockArr) {
            if (this.row > 0) {
                if (VP8Util.PLANE.Y1.equals(this.plane)) {
                    return this.self.ySubblocks[this.row - 1][this.col];
                }
                if (VP8Util.PLANE.U.equals(this.plane)) {
                    return this.self.uSubblocks[this.row - 1][this.col];
                }
                if (VP8Util.PLANE.V.equals(this.plane)) {
                    return this.self.vSubblocks[this.row - 1][this.col];
                }
            }
            int i = this.col;
            VPXMacroblock vPXMacroblock = vPXMacroblockArr[r1.Rrow - 1][this.self.column];
            if (plane == VP8Util.PLANE.Y2) {
                while (vPXMacroblock.lumaMode == 4) {
                    vPXMacroblock = vPXMacroblockArr[vPXMacroblock.Rrow - 1][vPXMacroblock.column];
                }
            }
            return vPXMacroblock.getBottomSubblock(i, plane);
        }

        public Subblock getLeft(VP8Util.PLANE plane, VPXMacroblock[][] vPXMacroblockArr) {
            if (this.col > 0) {
                if (VP8Util.PLANE.Y1.equals(this.plane)) {
                    return this.self.ySubblocks[this.row][this.col - 1];
                }
                if (VP8Util.PLANE.U.equals(this.plane)) {
                    return this.self.uSubblocks[this.row][this.col - 1];
                }
                if (VP8Util.PLANE.V.equals(this.plane)) {
                    return this.self.vSubblocks[this.row][this.col - 1];
                }
            }
            int i = this.row;
            VPXMacroblock vPXMacroblock = vPXMacroblockArr[this.self.Rrow][r1.column - 1];
            if (plane == VP8Util.PLANE.Y2) {
                while (vPXMacroblock.lumaMode == 4) {
                    vPXMacroblock = vPXMacroblockArr[vPXMacroblock.Rrow][vPXMacroblock.column - 1];
                }
            }
            return vPXMacroblock.getRightSubBlock(i, plane);
        }

        public void predict(VPXMacroblock[][] vPXMacroblockArr) {
            Subblock above = getAbove(this.plane, vPXMacroblockArr);
            Subblock left = getLeft(this.plane, vPXMacroblockArr);
            int[] iArr = new int[4];
            int[] iArr2 = new int[4];
            int[] iArr3 = above.val;
            if (iArr3 == null) {
                iArr3 = VP8Util.PRED_BLOCK_127;
            }
            iArr[0] = iArr3[12];
            iArr[1] = iArr3[13];
            iArr[2] = iArr3[14];
            iArr[3] = iArr3[15];
            int[] iArrPickDefaultPrediction = left.val;
            if (iArrPickDefaultPrediction == null) {
                iArrPickDefaultPrediction = VP8Util.pickDefaultPrediction(this.mode);
            }
            iArr2[0] = iArrPickDefaultPrediction[3];
            iArr2[1] = iArrPickDefaultPrediction[7];
            iArr2[2] = iArrPickDefaultPrediction[11];
            iArr2[3] = iArrPickDefaultPrediction[15];
            Subblock left2 = above.getLeft(this.plane, vPXMacroblockArr);
            int i = 127;
            if ((left.val != null || above.val != null) && above.val != null) {
                int[] iArr4 = left2.val;
                i = iArr4 != null ? iArr4[15] : VP8Util.pickDefaultPrediction(this.mode)[15];
            }
            int[] aboveRightLowestRow = getAboveRightLowestRow(vPXMacroblockArr);
            switch (this.mode) {
                case 0:
                    this._predict = VP8Util.predictDC(iArr, iArr2);
                    return;
                case 1:
                    this._predict = VP8Util.predictTM(iArr, iArr2, i);
                    return;
                case 2:
                    this._predict = VP8Util.predictVE(iArr, i, aboveRightLowestRow);
                    return;
                case 3:
                    this._predict = VP8Util.predictHE(iArr2, i);
                    return;
                case 4:
                    this._predict = VP8Util.predictLD(iArr, aboveRightLowestRow);
                    return;
                case 5:
                    this._predict = VP8Util.predictRD(iArr, iArr2, i);
                    return;
                case 6:
                    this._predict = VP8Util.predictVR(iArr, iArr2, i);
                    return;
                case 7:
                    this._predict = VP8Util.predictVL(iArr, aboveRightLowestRow);
                    return;
                case 8:
                    this._predict = VP8Util.predictHD(iArr, iArr2, i);
                    return;
                case 9:
                    this._predict = VP8Util.predictHU(iArr2);
                    return;
                default:
                    throw new NotSupportedException("TODO: unknowwn mode: " + this.mode);
            }
        }

        public void reconstruct() {
            int[] iArr = this.val;
            if (iArr == null) {
                iArr = this._predict;
            }
            int[] iArr2 = new int[16];
            for (int i = 0; i < 4; i++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    int i3 = (i * 4) + i2;
                    iArr2[i3] = VP8Util.QuantizationParams.clip255(this.residue[i3] + iArr[i3]);
                }
            }
            this.val = iArr2;
        }
    }

    public VPXMacroblock(int i, int i2) {
        this.Rrow = i;
        this.column = i2;
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i4 = 0; i4 < 4; i4++) {
                this.ySubblocks[i3][i4] = new Subblock(this, i3, i4, VP8Util.PLANE.Y1);
            }
        }
        for (int i5 = 0; i5 < 2; i5++) {
            for (int i6 = 0; i6 < 2; i6++) {
                this.uSubblocks[i5][i6] = new Subblock(this, i5, i6, VP8Util.PLANE.U);
                this.vSubblocks[i5][i6] = new Subblock(this, i5, i6, VP8Util.PLANE.V);
            }
        }
    }

    private void decodeMacroBlockTokens(boolean z, VPXMacroblock[][] vPXMacroblockArr, VPXBooleanDecoder vPXBooleanDecoder, int[][][][] iArr) {
        this.skipFilter = false;
        if (z) {
            this.skipFilter = false | decodePlaneTokens(1, VP8Util.PLANE.Y2, false, vPXMacroblockArr, vPXBooleanDecoder, iArr);
        }
        boolean zDecodePlaneTokens = decodePlaneTokens(4, VP8Util.PLANE.Y1, z, vPXMacroblockArr, vPXBooleanDecoder, iArr) | this.skipFilter;
        this.skipFilter = zDecodePlaneTokens;
        this.skipFilter = zDecodePlaneTokens | decodePlaneTokens(2, VP8Util.PLANE.U, false, vPXMacroblockArr, vPXBooleanDecoder, iArr);
        this.skipFilter = !(r9 | decodePlaneTokens(2, VP8Util.PLANE.V, false, vPXMacroblockArr, vPXBooleanDecoder, iArr));
    }

    private boolean decodePlaneTokens(int i, VP8Util.PLANE plane, boolean z, VPXMacroblock[][] vPXMacroblockArr, VPXBooleanDecoder vPXBooleanDecoder, int[][][][] iArr) {
        Subblock subblock;
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (VP8Util.PLANE.Y1.equals(plane)) {
                    subblock = this.ySubblocks[i2][i3];
                } else if (VP8Util.PLANE.U.equals(plane)) {
                    subblock = this.uSubblocks[i2][i3];
                } else if (VP8Util.PLANE.V.equals(plane)) {
                    subblock = this.vSubblocks[i2][i3];
                } else {
                    if (!VP8Util.PLANE.Y2.equals(plane)) {
                        throw new IllegalStateException("unknown plane type " + plane);
                    }
                    subblock = this.y2;
                }
                subblock.decodeSubBlock(vPXBooleanDecoder, iArr, (subblock.getLeft(plane, vPXMacroblockArr).someValuePresent ? 1 : 0) + (subblock.getAbove(plane, vPXMacroblockArr).someValuePresent ? 1 : 0), VP8Util.planeToType(plane, Boolean.valueOf(z)), z);
                z2 |= subblock.someValuePresent;
            }
        }
        return z2;
    }

    private void predictLumaDC(VPXMacroblock vPXMacroblock, VPXMacroblock vPXMacroblock2) {
        int i;
        boolean z = this.Rrow > 1;
        boolean z2 = this.column > 1;
        int i2 = 128;
        if (z || z2) {
            if (z) {
                i = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    Subblock subblock = vPXMacroblock.ySubblocks[3][i3];
                    for (int i4 = 0; i4 < 4; i4++) {
                        i += subblock.val[i4 + 12];
                    }
                }
            } else {
                i = 0;
            }
            if (z2) {
                for (int i5 = 0; i5 < 4; i5++) {
                    Subblock subblock2 = vPXMacroblock2.ySubblocks[i5][3];
                    for (int i6 = 0; i6 < 4; i6++) {
                        i += subblock2.val[(i6 * 4) + 3];
                    }
                }
            }
            int i7 = z ? 4 : 3;
            if (z2) {
                i7++;
            }
            i2 = (i + (1 << (i7 - 1))) >> i7;
        }
        int[] iArr = new int[16];
        for (int i8 = 0; i8 < 16; i8++) {
            iArr[i8] = i2;
        }
        for (int i9 = 0; i9 < 4; i9++) {
            for (int i10 = 0; i10 < 4; i10++) {
                this.ySubblocks[i9][i10]._predict = iArr;
            }
        }
    }

    private void predictLumaH(VPXMacroblock vPXMacroblock) {
        Subblock[] subblockArr = new Subblock[4];
        for (int i = 0; i < 4; i++) {
            subblockArr[i] = vPXMacroblock.ySubblocks[i][3];
        }
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                Subblock subblock = this.ySubblocks[i2][i3];
                int[] iArr = new int[16];
                for (int i4 = 0; i4 < 4; i4++) {
                    for (int i5 = 0; i5 < 4; i5++) {
                        int i6 = i4 * 4;
                        int i7 = i6 + i5;
                        int[] iArr2 = subblockArr[i2].val;
                        iArr[i7] = iArr2 != null ? iArr2[i6 + 3] : 129;
                    }
                }
                subblock._predict = iArr;
            }
        }
    }

    private void predictLumaTM(VPXMacroblock vPXMacroblock, VPXMacroblock vPXMacroblock2, int i) {
        Subblock[] subblockArr = new Subblock[4];
        Subblock[] subblockArr2 = new Subblock[4];
        for (int i2 = 0; i2 < 4; i2++) {
            subblockArr[i2] = vPXMacroblock.ySubblocks[3][i2];
        }
        for (int i3 = 0; i3 < 4; i3++) {
            subblockArr2[i3] = vPXMacroblock2.ySubblocks[i3][3];
        }
        for (int i4 = 0; i4 < 4; i4++) {
            for (int i5 = 0; i5 < 4; i5++) {
                for (int i6 = 0; i6 < 4; i6++) {
                    Subblock subblock = this.ySubblocks[i4][i6];
                    if (subblock.val == null) {
                        subblock.val = new int[16];
                    }
                    for (int i7 = 0; i7 < 4; i7++) {
                        int i8 = i5 * 4;
                        this.ySubblocks[i4][i6].val[i8 + i7] = VP8Util.QuantizationParams.clip255((subblockArr2[i4].val[i8 + 3] + subblockArr[i6].val[i7 + 12]) - i);
                    }
                }
            }
        }
    }

    private void predictLumaV(VPXMacroblock vPXMacroblock) {
        Subblock[] subblockArr = new Subblock[4];
        for (int i = 0; i < 4; i++) {
            subblockArr[i] = vPXMacroblock.ySubblocks[3][i];
        }
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                Subblock subblock = this.ySubblocks[i2][i3];
                int[] iArr = new int[16];
                for (int i4 = 0; i4 < 4; i4++) {
                    for (int i5 = 0; i5 < 4; i5++) {
                        int i6 = (i4 * 4) + i5;
                        int[] iArr2 = subblockArr[i3].val;
                        iArr[i6] = iArr2 != null ? iArr2[i5 + 12] : 127;
                    }
                }
                subblock._predict = iArr;
            }
        }
    }

    private void predictY(VPXMacroblock[][] vPXMacroblockArr) {
        int i = this.Rrow;
        VPXMacroblock[] vPXMacroblockArr2 = vPXMacroblockArr[i - 1];
        int i2 = this.column;
        VPXMacroblock vPXMacroblock = vPXMacroblockArr2[i2];
        VPXMacroblock vPXMacroblock2 = vPXMacroblockArr[i][i2 - 1];
        int i3 = this.lumaMode;
        if (i3 == 0) {
            predictLumaDC(vPXMacroblock, vPXMacroblock2);
            return;
        }
        if (i3 == 1) {
            predictLumaV(vPXMacroblock);
            return;
        }
        if (i3 == 2) {
            predictLumaH(vPXMacroblock2);
            return;
        }
        if (i3 == 3) {
            predictLumaTM(vPXMacroblock, vPXMacroblock2, vPXMacroblockArr[i - 1][i2 - 1].ySubblocks[3][3].val[15]);
            return;
        }
        System.err.println("TODO predict_mb_y: " + this.lumaMode);
        System.exit(0);
    }

    public void decodeMacroBlock(VPXMacroblock[][] vPXMacroblockArr, VPXBooleanDecoder vPXBooleanDecoder, int[][][][] iArr) {
        if (this.skipCoeff > 0) {
            this.skipFilter = this.lumaMode != 4;
        } else if (this.lumaMode != 4) {
            decodeMacroBlockTokens(true, vPXMacroblockArr, vPXBooleanDecoder, iArr);
        } else {
            decodeMacroBlockTokens(false, vPXMacroblockArr, vPXBooleanDecoder, iArr);
        }
    }

    public void dequantMacroBlock(VPXMacroblock[][] vPXMacroblockArr) {
        VP8Util.QuantizationParams quantizationParams = this.quants;
        if (this.lumaMode != 4) {
            int i = quantizationParams.y2AC;
            int[] iArr = new int[16];
            iArr[0] = this.y2.tokens[0] * quantizationParams.y2DC;
            for (int i2 = 1; i2 < 16; i2++) {
                iArr[i2] = this.y2.tokens[i2] * i;
            }
            this.y2.residue = VP8DCT.decodeWHT(iArr);
            for (int i3 = 0; i3 < 4; i3++) {
                for (int i4 = 0; i4 < 4; i4++) {
                    this.ySubblocks[i3][i4].dequantSubblock(quantizationParams.yDC, quantizationParams.yAC, Integer.valueOf(this.y2.residue[(i3 * 4) + i4]));
                }
            }
            predictY(vPXMacroblockArr);
            predictUV(vPXMacroblockArr);
            for (int i5 = 0; i5 < 2; i5++) {
                for (int i6 = 0; i6 < 2; i6++) {
                    this.uSubblocks[i5][i6].dequantSubblock(quantizationParams.chromaDC, quantizationParams.chromaAC, null);
                    this.vSubblocks[i5][i6].dequantSubblock(quantizationParams.chromaDC, quantizationParams.chromaAC, null);
                }
            }
            reconstruct();
            return;
        }
        for (int i7 = 0; i7 < 4; i7++) {
            for (int i8 = 0; i8 < 4; i8++) {
                Subblock subblock = this.ySubblocks[i7][i8];
                subblock.dequantSubblock(quantizationParams.yDC, quantizationParams.yAC, null);
                subblock.predict(vPXMacroblockArr);
                subblock.reconstruct();
            }
        }
        predictUV(vPXMacroblockArr);
        for (int i9 = 0; i9 < 2; i9++) {
            for (int i10 = 0; i10 < 2; i10++) {
                Subblock subblock2 = this.uSubblocks[i9][i10];
                subblock2.dequantSubblock(quantizationParams.chromaDC, quantizationParams.chromaAC, null);
                subblock2.reconstruct();
            }
        }
        for (int i11 = 0; i11 < 2; i11++) {
            for (int i12 = 0; i12 < 2; i12++) {
                Subblock subblock3 = this.vSubblocks[i11][i12];
                subblock3.dequantSubblock(quantizationParams.chromaDC, quantizationParams.chromaAC, null);
                subblock3.reconstruct();
            }
        }
    }

    public Subblock getBottomSubblock(int i, VP8Util.PLANE plane) {
        if (plane == VP8Util.PLANE.Y1) {
            return this.ySubblocks[3][i];
        }
        if (plane == VP8Util.PLANE.U) {
            return this.uSubblocks[1][i];
        }
        if (plane == VP8Util.PLANE.V) {
            return this.vSubblocks[1][i];
        }
        if (plane == VP8Util.PLANE.Y2) {
            return this.y2;
        }
        return null;
    }

    public Subblock getRightSubBlock(int i, VP8Util.PLANE plane) {
        if (plane == VP8Util.PLANE.Y1) {
            return this.ySubblocks[i][3];
        }
        if (plane == VP8Util.PLANE.U) {
            return this.uSubblocks[i][1];
        }
        if (plane == VP8Util.PLANE.V) {
            return this.vSubblocks[i][1];
        }
        if (plane == VP8Util.PLANE.Y2) {
            return this.y2;
        }
        return null;
    }

    public void predictUV(VPXMacroblock[][] vPXMacroblockArr) {
        int i;
        int i2;
        int i3;
        int i4 = this.Rrow;
        VPXMacroblock[] vPXMacroblockArr2 = vPXMacroblockArr[i4 - 1];
        int i5 = this.column;
        VPXMacroblock vPXMacroblock = vPXMacroblockArr2[i5];
        VPXMacroblock vPXMacroblock2 = vPXMacroblockArr[i4][i5 - 1];
        int i6 = this.chromaMode;
        int i7 = 4;
        int i8 = 0;
        if (i6 == 0) {
            boolean z = i5 > 1;
            boolean z2 = i4 > 1;
            int i9 = 128;
            if (z2 || z) {
                if (z2) {
                    i = 0;
                    i2 = 0;
                    for (int i10 = 0; i10 < 2; i10++) {
                        Subblock subblock = vPXMacroblock.uSubblocks[1][i10];
                        Subblock subblock2 = vPXMacroblock.vSubblocks[1][i10];
                        for (int i11 = 0; i11 < 4; i11++) {
                            int i12 = i11 + 12;
                            i += subblock.val[i12];
                            i2 += subblock2.val[i12];
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (z) {
                    for (int i13 = 0; i13 < 2; i13++) {
                        Subblock subblock3 = vPXMacroblock2.uSubblocks[i13][1];
                        Subblock subblock4 = vPXMacroblock2.vSubblocks[i13][1];
                        for (int i14 = 0; i14 < 4; i14++) {
                            int i15 = (i14 * 4) + 3;
                            i += subblock3.val[i15];
                            i2 += subblock4.val[i15];
                        }
                    }
                }
                int i16 = z2 ? 3 : 2;
                if (z) {
                    i16++;
                }
                int i17 = 1 << (i16 - 1);
                i9 = (i + i17) >> i16;
                i3 = (i2 + i17) >> i16;
            } else {
                i3 = 128;
            }
            int[] iArr = new int[16];
            int i18 = 0;
            while (true) {
                if (i18 >= 4) {
                    break;
                }
                int i19 = 0;
                for (int i20 = 4; i19 < i20; i20 = 4) {
                    iArr[(i18 * 4) + i19] = i9;
                    i19++;
                }
                i18++;
            }
            int[] iArr2 = new int[16];
            for (int i21 = 0; i21 < 4; i21++) {
                for (int i22 = 0; i22 < 4; i22++) {
                    iArr2[(i21 * 4) + i22] = i3;
                }
            }
            for (int i23 = 0; i23 < 2; i23++) {
                for (int i24 = 0; i24 < 2; i24++) {
                    Subblock subblock5 = this.uSubblocks[i23][i24];
                    Subblock subblock6 = this.vSubblocks[i23][i24];
                    subblock5._predict = iArr;
                    subblock6._predict = iArr2;
                }
            }
            return;
        }
        if (i6 == 1) {
            Subblock[] subblockArr = new Subblock[2];
            Subblock[] subblockArr2 = new Subblock[2];
            for (int i25 = 0; i25 < 2; i25++) {
                subblockArr[i25] = vPXMacroblock.uSubblocks[1][i25];
                subblockArr2[i25] = vPXMacroblock.vSubblocks[1][i25];
            }
            for (int i26 = 0; i26 < 2; i26++) {
                for (int i27 = 0; i27 < 2; i27++) {
                    Subblock subblock7 = this.uSubblocks[i26][i27];
                    Subblock subblock8 = this.vSubblocks[i26][i27];
                    int[] iArr3 = new int[16];
                    int[] iArr4 = new int[16];
                    int i28 = 0;
                    while (true) {
                        if (i28 < 4) {
                            int i29 = 0;
                            for (int i30 = 4; i29 < i30; i30 = 4) {
                                int i31 = (i28 * 4) + i29;
                                int[] iArr5 = subblockArr[i27].val;
                                int i32 = 127;
                                iArr3[i31] = iArr5 != null ? iArr5[i29 + 12] : 127;
                                int[] iArr6 = subblockArr2[i27].val;
                                if (iArr6 != null) {
                                    i32 = iArr6[i29 + 12];
                                }
                                iArr4[i31] = i32;
                                i29++;
                            }
                            i28++;
                        }
                    }
                    subblock7._predict = iArr3;
                    subblock8._predict = iArr4;
                }
            }
            return;
        }
        if (i6 == 2) {
            Subblock[] subblockArr3 = new Subblock[2];
            Subblock[] subblockArr4 = new Subblock[2];
            for (int i33 = 0; i33 < 2; i33++) {
                subblockArr3[i33] = vPXMacroblock2.uSubblocks[i33][1];
                subblockArr4[i33] = vPXMacroblock2.vSubblocks[i33][1];
            }
            int i34 = 0;
            while (i34 < 2) {
                int i35 = 0;
                while (i35 < 2) {
                    Subblock subblock9 = this.uSubblocks[i34][i35];
                    Subblock subblock10 = this.vSubblocks[i34][i35];
                    int[] iArr7 = new int[16];
                    int[] iArr8 = new int[16];
                    int i36 = 0;
                    while (i36 < i7) {
                        int i37 = 0;
                        while (i37 < i7) {
                            int i38 = i36 * 4;
                            int i39 = i38 + i37;
                            int[] iArr9 = subblockArr3[i34].val;
                            int i40 = 129;
                            iArr7[i39] = iArr9 != null ? iArr9[i38 + 3] : 129;
                            int[] iArr10 = subblockArr4[i34].val;
                            if (iArr10 != null) {
                                i40 = iArr10[i38 + 3];
                            }
                            iArr8[i39] = i40;
                            i37++;
                            i7 = 4;
                        }
                        i36++;
                        i7 = 4;
                    }
                    subblock9._predict = iArr7;
                    subblock10._predict = iArr8;
                    i35++;
                    i7 = 4;
                }
                i34++;
                i7 = 4;
            }
            return;
        }
        if (i6 != 3) {
            System.err.println("TODO predict_mb_uv: " + this.lumaMode);
            System.exit(0);
            return;
        }
        VPXMacroblock vPXMacroblock3 = vPXMacroblockArr[i4 - 1][i5 - 1];
        int i41 = vPXMacroblock3.uSubblocks[1][1].val[15];
        int i42 = vPXMacroblock3.vSubblocks[1][1].val[15];
        Subblock[] subblockArr5 = new Subblock[2];
        Subblock[] subblockArr6 = new Subblock[2];
        Subblock[] subblockArr7 = new Subblock[2];
        Subblock[] subblockArr8 = new Subblock[2];
        for (int i43 = 0; i43 < 2; i43++) {
            subblockArr5[i43] = vPXMacroblock.uSubblocks[1][i43];
            subblockArr6[i43] = vPXMacroblock2.uSubblocks[i43][1];
            subblockArr7[i43] = vPXMacroblock.vSubblocks[1][i43];
            subblockArr8[i43] = vPXMacroblock2.vSubblocks[i43][1];
        }
        int i44 = 0;
        while (i44 < 2) {
            int i45 = i8;
            while (i45 < 4) {
                int i46 = i8;
                while (i46 < 2) {
                    Subblock subblock11 = this.uSubblocks[i44][i46];
                    if (subblock11.val == null) {
                        subblock11.val = new int[16];
                    }
                    Subblock subblock12 = this.vSubblocks[i44][i46];
                    if (subblock12.val == null) {
                        subblock12.val = new int[16];
                    }
                    for (int i47 = i8; i47 < 4; i47++) {
                        int i48 = i45 * 4;
                        int i49 = i48 + 3;
                        int i50 = i47 + 12;
                        int i51 = i48 + i47;
                        this.uSubblocks[i44][i46].val[i51] = VP8Util.QuantizationParams.clip255((subblockArr6[i44].val[i49] + subblockArr5[i46].val[i50]) - i41);
                        this.vSubblocks[i44][i46].val[i51] = VP8Util.QuantizationParams.clip255((subblockArr8[i44].val[i49] + subblockArr7[i46].val[i50]) - i42);
                    }
                    i46++;
                    i8 = 0;
                }
                i45++;
                i8 = 0;
            }
            i44++;
            i8 = 0;
        }
    }

    public void put(int i, int i2, Picture picture) {
        byte[] planeData = picture.getPlaneData(0);
        byte[] planeData2 = picture.getPlaneData(1);
        byte[] planeData3 = picture.getPlaneData(2);
        int planeWidth = picture.getPlaneWidth(0);
        int planeWidth2 = picture.getPlaneWidth(1);
        for (int i3 = 0; i3 < 4; i3++) {
            for (int i4 = 0; i4 < 4; i4++) {
                for (int i5 = 0; i5 < 4; i5++) {
                    for (int i6 = 0; i6 < 4; i6++) {
                        int i7 = (i << 4) + (i3 << 2) + i5;
                        int i8 = (i2 << 4) + (i4 << 2) + i6;
                        if (i8 < planeWidth && i7 < planeData.length / planeWidth) {
                            planeData[(i7 * planeWidth) + i8] = (byte) (this.ySubblocks[i3][i4].val[(i5 * 4) + i6] - 128);
                        }
                    }
                }
            }
        }
        for (int i9 = 0; i9 < 2; i9++) {
            for (int i10 = 0; i10 < 2; i10++) {
                for (int i11 = 0; i11 < 4; i11++) {
                    for (int i12 = 0; i12 < 4; i12++) {
                        int i13 = (i << 3) + (i9 << 2) + i11;
                        int i14 = (i2 << 3) + (i10 << 2) + i12;
                        if (i14 < planeWidth2 && i13 < planeData2.length / planeWidth2) {
                            int i15 = (i11 * 4) + i12;
                            int i16 = this.uSubblocks[i9][i10].val[i15];
                            int i17 = this.vSubblocks[i9][i10].val[i15];
                            int i18 = (i13 * planeWidth2) + i14;
                            planeData2[i18] = (byte) (i16 - 128);
                            planeData3[i18] = (byte) (i17 - 128);
                        }
                    }
                }
            }
        }
    }

    public void reconstruct() {
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                this.ySubblocks[i][i2].reconstruct();
            }
        }
        for (int i3 = 0; i3 < 2; i3++) {
            for (int i4 = 0; i4 < 2; i4++) {
                this.uSubblocks[i3][i4].reconstruct();
            }
        }
        for (int i5 = 0; i5 < 2; i5++) {
            for (int i6 = 0; i6 < 2; i6++) {
                this.vSubblocks[i5][i6].reconstruct();
            }
        }
    }
}
