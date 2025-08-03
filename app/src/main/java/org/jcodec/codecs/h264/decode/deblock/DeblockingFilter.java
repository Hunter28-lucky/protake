package org.jcodec.codecs.h264.decode.deblock;

import com.google.mlkit.common.MlKitException;
import java.lang.reflect.Array;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.decode.DeblockerInput;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class DeblockingFilter {
    private DeblockerInput di;
    public static int[] alphaTab = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 5, 6, 7, 8, 9, 10, 12, 13, 15, 17, 20, 22, 25, 28, 32, 36, 40, 45, 50, 56, 63, 71, 80, 90, 101, 113, 127, 144, 162, 182, MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE, JpegConst.APP2, 255, 255};
    public static int[] betaTab = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18};
    public static int[][] tcs = {new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 6, 6, 7, 8, 9, 10, 11, 13}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 8, 8, 10, 11, 12, 13, 15, 17}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 6, 6, 7, 8, 9, 10, 11, 13, 14, 16, 18, 20, 23, 25}};
    public static int[] inverse = {0, 1, 4, 5, 2, 3, 6, 7, 8, 9, 12, 13, 10, 11, 14, 15};

    public DeblockingFilter(int i, int i2, DeblockerInput deblockerInput) {
        this.di = deblockerInput;
    }

    private int calcBoundaryStrenth(boolean z, boolean z2, boolean z3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (z && (z2 || z3)) {
            return 4;
        }
        if (z2 || z3) {
            return 3;
        }
        if (i > 0 || i2 > 0) {
            return 2;
        }
        if ((H264Utils.Mv.mvRef(i3) == -1 ? 0 : 1) + (H264Utils.Mv.mvRef(i5) == -1 ? 0 : 1) != (H264Utils.Mv.mvRef(i4) == -1 ? 0 : 1) + (H264Utils.Mv.mvRef(i6) == -1 ? 0 : 1)) {
            return 1;
        }
        Frame frame = H264Utils.Mv.mvRef(i3) < 0 ? null : this.di.refsUsed[i7][0][H264Utils.Mv.mvRef(i3)];
        Frame frame2 = H264Utils.Mv.mvRef(i5) < 0 ? null : this.di.refsUsed[i7][1][H264Utils.Mv.mvRef(i5)];
        Frame frame3 = H264Utils.Mv.mvRef(i4) < 0 ? null : this.di.refsUsed[i8][0][H264Utils.Mv.mvRef(i4)];
        Frame frame4 = H264Utils.Mv.mvRef(i6) >= 0 ? this.di.refsUsed[i8][1][H264Utils.Mv.mvRef(i6)] : null;
        if ((frame != frame3 && frame != frame4) || ((frame2 != frame3 && frame2 != frame4) || ((frame3 != frame && frame3 != frame2) || (frame4 != frame && frame4 != frame2)))) {
            return 1;
        }
        if (frame == frame2 && frame2 == frame3 && frame3 == frame4) {
            if (frame != null) {
                return (mvThresh(i3, i4) || mvThresh(i5, i4) || mvThresh(i3, i6) || mvThresh(i5, i6)) ? 1 : 0;
            }
            return 0;
        }
        if (frame == frame3 && frame2 == frame4) {
            return ((frame == null || !mvThresh(i3, i4)) && (frame2 == null || !mvThresh(i5, i6))) ? 0 : 1;
        }
        if (frame == frame4 && frame2 == frame3) {
            return ((frame == null || !mvThresh(i3, i6)) && (frame2 == null || !mvThresh(i5, i4))) ? 0 : 1;
        }
        return 0;
    }

    private void calcBsH(Picture picture, int i, int[][] iArr) {
        DeblockerInput deblockerInput = this.di;
        SliceHeader[] sliceHeaderArr = deblockerInput.shs;
        SliceHeader sliceHeader = sliceHeaderArr[i];
        int i2 = 1;
        int i3 = sliceHeader.sps.picWidthInMbsMinus1 + 1;
        int i4 = i % i3;
        int i5 = i / i3;
        char c = 2;
        int i6 = 0;
        boolean z = i5 > 0 && (sliceHeader.disableDeblockingFilterIdc != 2 || sliceHeaderArr[i - i3] == sliceHeader);
        MBType mBType = deblockerInput.mbTypes[i];
        boolean z2 = mBType != null && mBType.isIntra();
        int i7 = 4;
        if (z) {
            int i8 = i - i3;
            MBType mBType2 = this.di.mbTypes[i8];
            boolean z3 = mBType2 != null && mBType2.isIntra();
            int i9 = 0;
            while (i9 < i7) {
                int i10 = (i4 << 2) + i9;
                int i11 = i5 << 2;
                int[] iArr2 = iArr[i6];
                DeblockerInput deblockerInput2 = this.di;
                int[][] iArr3 = deblockerInput2.nCoeff;
                int i12 = i11 - 1;
                int i13 = i9;
                iArr2[i13] = calcBoundaryStrenth(true, z3, z2, iArr3[i11][i10], iArr3[i12][i10], deblockerInput2.mvs.getMv(i10, i11, i6), this.di.mvs.getMv(i10, i12, i6), this.di.mvs.getMv(i10, i11, i2), this.di.mvs.getMv(i10, i12, i2), i, i8);
                i9 = i13 + 1;
                i7 = i7;
                c = c;
                i6 = 0;
                i2 = 1;
            }
        }
        int i14 = i7;
        int i15 = 1;
        while (i15 < i14) {
            int i16 = 0;
            while (i16 < i14) {
                int i17 = (i4 << 2) + i16;
                int i18 = (i5 << 2) + i15;
                int[] iArr4 = iArr[i15];
                DeblockerInput deblockerInput3 = this.di;
                int[][] iArr5 = deblockerInput3.nCoeff;
                int i19 = i18 - 1;
                int i20 = i16;
                iArr4[i20] = calcBoundaryStrenth(false, z2, z2, iArr5[i18][i17], iArr5[i19][i17], deblockerInput3.mvs.getMv(i17, i18, 0), this.di.mvs.getMv(i17, i19, 0), this.di.mvs.getMv(i17, i18, 1), this.di.mvs.getMv(i17, i19, 1), i, i);
                i16 = i20 + 1;
                i15 = i15;
            }
            i15++;
        }
    }

    private void calcBsV(Picture picture, int i, int[][] iArr) {
        DeblockerInput deblockerInput = this.di;
        SliceHeader[] sliceHeaderArr = deblockerInput.shs;
        SliceHeader sliceHeader = sliceHeaderArr[i];
        int i2 = 1;
        int i3 = sliceHeader.sps.picWidthInMbsMinus1 + 1;
        int i4 = i % i3;
        int i5 = i / i3;
        char c = 2;
        int i6 = 0;
        boolean z = i4 > 0 && (sliceHeader.disableDeblockingFilterIdc != 2 || sliceHeaderArr[i + (-1)] == sliceHeader);
        MBType mBType = deblockerInput.mbTypes[i];
        boolean z2 = mBType != null && mBType.isIntra();
        int i7 = 4;
        if (z) {
            int i8 = i - 1;
            MBType mBType2 = this.di.mbTypes[i8];
            boolean z3 = mBType2 != null && mBType2.isIntra();
            int i9 = 0;
            while (i9 < i7) {
                int i10 = i4 << 2;
                int i11 = (i5 << 2) + i9;
                int[] iArr2 = iArr[i9];
                DeblockerInput deblockerInput2 = this.di;
                int[] iArr3 = deblockerInput2.nCoeff[i11];
                int i12 = iArr3[i10];
                int i13 = i10 - 1;
                int i14 = iArr3[i13];
                int mv = deblockerInput2.mvs.getMv(i10, i11, i6);
                int mv2 = this.di.mvs.getMv(i13, i11, i6);
                int mv3 = this.di.mvs.getMv(i10, i11, i2);
                int mv4 = this.di.mvs.getMv(i13, i11, i2);
                int i15 = i6;
                iArr2[i15] = calcBoundaryStrenth(true, z3, z2, i12, i14, mv, mv2, mv3, mv4, i, i8);
                i9++;
                i6 = i15;
                c = c;
                i7 = 4;
                i2 = 1;
            }
        }
        int i16 = i6;
        int i17 = 4;
        int i18 = 1;
        while (i18 < i17) {
            int i19 = i16;
            while (i19 < i17) {
                int i20 = (i4 << 2) + i18;
                int i21 = (i5 << 2) + i19;
                int[] iArr4 = iArr[i19];
                DeblockerInput deblockerInput3 = this.di;
                int[] iArr5 = deblockerInput3.nCoeff[i21];
                int i22 = i20 - 1;
                int i23 = i18;
                iArr4[i23] = calcBoundaryStrenth(false, z2, z2, iArr5[i20], iArr5[i22], deblockerInput3.mvs.getMv(i20, i21, i16), this.di.mvs.getMv(i22, i21, i16), this.di.mvs.getMv(i20, i21, 1), this.di.mvs.getMv(i22, i21, 1), i, i);
                i19++;
                i17 = i17;
                i18 = i23;
            }
            i18++;
        }
    }

    private void fillHorizontalEdge(Picture picture, int i, int i2, int[][] iArr) {
        DeblockerInput deblockerInput = this.di;
        SliceHeader[] sliceHeaderArr = deblockerInput.shs;
        SliceHeader sliceHeader = sliceHeaderArr[i2];
        int i3 = sliceHeader.sps.picWidthInMbsMinus1 + 1;
        int i4 = sliceHeader.sliceAlphaC0OffsetDiv2 << 1;
        int i5 = sliceHeader.sliceBetaOffsetDiv2 << 1;
        int i6 = i2 % i3;
        int i7 = i2 / i3;
        char c = 0;
        char c2 = 2;
        boolean z = i7 > 0 && (sliceHeader.disableDeblockingFilterIdc != 2 || sliceHeaderArr[i2 - i3] == sliceHeader);
        int i8 = deblockerInput.mbQps[i][i2];
        int i9 = 2 - picture.getColor().compWidth[i];
        int i10 = 2 - picture.getColor().compHeight[i];
        int i11 = 4;
        if (z) {
            int i12 = ((this.di.mbQps[i][i2 - i3] + i8) + 1) >> 1;
            int i13 = 0;
            while (i13 < i11) {
                filterBlockEdgeHoris(picture, i, ((i6 << 2) + i13) << i9, (i7 << 2) << i10, getIdxAlpha(i4, i12), getIdxBeta(i5, i12), iArr[c][i13], 1 << i9);
                i13++;
                i10 = i10;
                i12 = i12;
                c2 = c2;
                i8 = i8;
                i11 = 4;
                c = 0;
            }
        }
        int i14 = i10;
        int i15 = i8;
        boolean z2 = (i == 0 && this.di.tr8x8Used[i2]) || i14 == 1;
        int i16 = 1;
        int i17 = 4;
        while (i16 < i17) {
            if (!z2 || (i16 & 1) != 1) {
                int i18 = 0;
                while (i18 < i17) {
                    filterBlockEdgeHoris(picture, i, ((i6 << 2) + i18) << i9, ((i7 << 2) + i16) << i14, getIdxAlpha(i4, i15), getIdxBeta(i5, i15), iArr[i16][i18], 1 << i9);
                    i18++;
                    i17 = i17;
                    i16 = i16;
                }
            }
            i16++;
            i17 = i17;
        }
    }

    private void fillVerticalEdge(Picture picture, int i, int i2, int[][] iArr) {
        DeblockerInput deblockerInput = this.di;
        SliceHeader[] sliceHeaderArr = deblockerInput.shs;
        SliceHeader sliceHeader = sliceHeaderArr[i2];
        int i3 = sliceHeader.sps.picWidthInMbsMinus1 + 1;
        int i4 = sliceHeader.sliceAlphaC0OffsetDiv2 << 1;
        int i5 = sliceHeader.sliceBetaOffsetDiv2 << 1;
        int i6 = i2 % i3;
        int i7 = i2 / i3;
        char c = 0;
        char c2 = 2;
        boolean z = i6 > 0 && (sliceHeader.disableDeblockingFilterIdc != 2 || sliceHeaderArr[i2 + (-1)] == sliceHeader);
        int i8 = deblockerInput.mbQps[i][i2];
        int i9 = 2 - picture.getColor().compWidth[i];
        int i10 = 2 - picture.getColor().compHeight[i];
        int i11 = 4;
        if (z) {
            int i12 = ((this.di.mbQps[i][i2 - 1] + i8) + 1) >> 1;
            int i13 = 0;
            while (i13 < i11) {
                filterBlockEdgeVert(picture, i, (i6 << 2) << i9, ((i7 << 2) + i13) << i10, getIdxAlpha(i4, i12), getIdxBeta(i5, i12), iArr[i13][c], 1 << i10);
                i13++;
                i9 = i9;
                i12 = i12;
                c2 = c2;
                i8 = i8;
                i11 = 4;
                c = 0;
            }
        }
        int i14 = i9;
        int i15 = i8;
        boolean z2 = (i == 0 && this.di.tr8x8Used[i2]) || i14 == 1;
        int i16 = 1;
        int i17 = 4;
        while (i16 < i17) {
            if (!z2 || (i16 & 1) != 1) {
                int i18 = 0;
                while (i18 < i17) {
                    filterBlockEdgeVert(picture, i, ((i6 << 2) + i16) << i14, ((i7 << 2) + i18) << i10, getIdxAlpha(i4, i15), getIdxBeta(i5, i15), iArr[i18][i16], 1 << i10);
                    i18++;
                    i17 = i17;
                    i16 = i16;
                }
            }
            i16++;
            i17 = i17;
        }
    }

    private void filterBlockEdgeHoris(Picture picture, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int planeWidth = picture.getPlaneWidth(i);
        int i9 = (i3 * planeWidth) + i2;
        int i10 = i7;
        int i11 = 0;
        while (i11 < i10) {
            int i12 = planeWidth * 3;
            int i13 = (i9 - i12) + i11;
            int i14 = planeWidth * 2;
            int i15 = (i9 - i14) + i11;
            int i16 = (i9 - planeWidth) + i11;
            int i17 = i9 + i11;
            int i18 = i9 + planeWidth + i11;
            int i19 = i14 + i9 + i11;
            if (i6 == 4) {
                filterBs4(i4, i5, picture.getPlaneData(i), picture.getPlaneData(i), (i9 - (planeWidth * 4)) + i11, i13, i15, i16, i17, i18, i19, i12 + i9 + i11, i != 0);
            } else {
                if (i6 > 0) {
                    i8 = i11;
                    filterBs(i6, i4, i5, picture.getPlaneData(i), picture.getPlaneData(i), i13, i15, i16, i17, i18, i19, i != 0);
                }
                i11 = i8 + 1;
                i10 = i7;
            }
            i8 = i11;
            i11 = i8 + 1;
            i10 = i7;
        }
    }

    private void filterBlockEdgeVert(Picture picture, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int planeWidth = picture.getPlaneWidth(i);
        int i9 = 0;
        while (i9 < i7) {
            int i10 = ((i3 + i9) * planeWidth) + i2;
            int i11 = i10 - 3;
            int i12 = i10 - 2;
            int i13 = i10 - 1;
            int i14 = i10 + 1;
            int i15 = i10 + 2;
            if (i6 == 4) {
                filterBs4(i4, i5, picture.getPlaneData(i), picture.getPlaneData(i), i10 - 4, i11, i12, i13, i10, i14, i15, i10 + 3, i != 0);
            } else {
                if (i6 > 0) {
                    i8 = i9;
                    filterBs(i6, i4, i5, picture.getPlaneData(i), picture.getPlaneData(i), i11, i12, i13, i10, i14, i15, i != 0);
                }
                i9 = i8 + 1;
            }
            i8 = i9;
            i9 = i8 + 1;
        }
    }

    public static void filterBs(int i, int i2, int i3, byte[] bArr, byte[] bArr2, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        int i10;
        boolean z2;
        byte b = bArr[i5];
        byte b2 = bArr[i6];
        byte b3 = bArr2[i7];
        byte b4 = bArr2[i8];
        int i11 = alphaTab[i2];
        int i12 = betaTab[i3];
        if (Math.abs(b2 - b3) < i11 && Math.abs(b - b2) < i12 && Math.abs(b4 - b3) < i12) {
            int i13 = tcs[i - 1][i2];
            if (z) {
                i10 = i13 + 1;
                z2 = false;
            } else {
                int iAbs = Math.abs(bArr[i4] - b2);
                int iAbs2 = Math.abs(bArr2[i9] - b3);
                i10 = (iAbs < i12 ? 1 : 0) + i13 + (iAbs2 < i12 ? 1 : 0);
                boolean z3 = iAbs < i12;
                z2 = iAbs2 < i12;
                z = z3;
            }
            int i14 = ((((b3 - b2) << 2) + (b - b4)) + 4) >> 3;
            int i15 = -i10;
            if (i14 < i15) {
                i10 = i15;
            } else if (i14 <= i10) {
                i10 = i14;
            }
            int i16 = b2 + i10;
            if (i16 < -128) {
                i16 = -128;
            }
            int i17 = b3 - i10;
            if (i17 < -128) {
                i17 = -128;
            }
            if (z) {
                int i18 = ((bArr[i4] + (((b2 + b3) + 1) >> 1)) - (b << 1)) >> 1;
                int i19 = -i13;
                if (i18 < i19) {
                    i18 = i19;
                } else if (i18 > i13) {
                    i18 = i13;
                }
                bArr[i5] = (byte) MathUtil.clip(b + i18, -128, 127);
            }
            if (z2) {
                int i20 = ((bArr2[i9] + (((b2 + b3) + 1) >> 1)) - (b4 << 1)) >> 1;
                int i21 = -i13;
                if (i20 < i21) {
                    i13 = i21;
                } else if (i20 <= i13) {
                    i13 = i20;
                }
                bArr2[i8] = (byte) MathUtil.clip(b4 + i13, -128, 127);
            }
            bArr2[i7] = (byte) MathUtil.clip(i17, -128, 127);
            bArr[i6] = (byte) MathUtil.clip(i16, -128, 127);
        }
    }

    public static void filterBs4(int i, int i2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z) {
        boolean z2;
        byte b = bArr[i6];
        byte b2 = bArr2[i7];
        byte b3 = bArr[i5];
        byte b4 = bArr2[i8];
        int i11 = alphaTab[i];
        int i12 = betaTab[i2];
        int i13 = b - b2;
        boolean z3 = false;
        if (Math.abs(i13) < i11 && Math.abs(b3 - b) < i12 && Math.abs(b4 - b2) < i12) {
            if (z) {
                z2 = false;
            } else {
                int iAbs = Math.abs(bArr[i4] - b);
                int iAbs2 = Math.abs(bArr2[i9] - b2);
                boolean z4 = iAbs < i12 && Math.abs(i13) < (i11 >> 2) + 2;
                z2 = iAbs2 < i12 && Math.abs(i13) < (i11 >> 2) + 2;
                z3 = z4;
            }
            if (z3) {
                byte b5 = bArr[i3];
                byte b6 = bArr[i4];
                bArr[i6] = (byte) MathUtil.clip(((((((b3 * 2) + b6) + (b * 2)) + (b2 * 2)) + b4) + 4) >> 3, -128, 127);
                bArr[i5] = (byte) MathUtil.clip(((((b6 + b3) + b) + b2) + 2) >> 2, -128, 127);
                bArr[i4] = (byte) MathUtil.clip(((((((b5 * 2) + (b6 * 3)) + b3) + b) + b2) + 4) >> 3, -128, 127);
            } else {
                bArr[i6] = (byte) MathUtil.clip(((((b3 * 2) + b) + b4) + 2) >> 2, -128, 127);
            }
            if (!z2 || z) {
                bArr2[i7] = (byte) MathUtil.clip(((((b4 * 2) + b2) + b3) + 2) >> 2, -128, 127);
                return;
            }
            byte b7 = bArr2[i9];
            int i14 = (((((b3 + (b * 2)) + (b2 * 2)) + (b4 * 2)) + b7) + 4) >> 3;
            int i15 = ((((b + b2) + b4) + b7) + 2) >> 2;
            int i16 = ((((((bArr2[i10] * 2) + (b7 * 3)) + b4) + b2) + b) + 4) >> 3;
            bArr2[i7] = (byte) MathUtil.clip(i14, -128, 127);
            bArr2[i8] = (byte) MathUtil.clip(i15, -128, 127);
            bArr2[i9] = (byte) MathUtil.clip(i16, -128, 127);
        }
    }

    private static int getIdxAlpha(int i, int i2) {
        return MathUtil.clip(i2 + i, 0, 51);
    }

    private static int getIdxBeta(int i, int i2) {
        return MathUtil.clip(i2 + i, 0, 51);
    }

    private boolean mvThresh(int i, int i2) {
        return Math.abs(H264Utils.Mv.mvX(i) - H264Utils.Mv.mvX(i2)) >= 4 || Math.abs(H264Utils.Mv.mvY(i) - H264Utils.Mv.mvY(i2)) >= 4;
    }

    public void deblockFrame(Picture picture) {
        ColorSpace color = picture.getColor();
        Class cls = Integer.TYPE;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, 4, 4);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, 4, 4);
        for (int i = 0; i < this.di.shs.length; i++) {
            calcBsH(picture, i, iArr2);
            calcBsV(picture, i, iArr);
            for (int i2 = 0; i2 < color.nComp; i2++) {
                fillVerticalEdge(picture, i2, i, iArr);
                fillHorizontalEdge(picture, i2, i, iArr2);
            }
        }
    }
}
