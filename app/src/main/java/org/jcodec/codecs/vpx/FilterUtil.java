package org.jcodec.codecs.vpx;

import org.jcodec.api.NotImplementedException;
import org.jcodec.codecs.vpx.VPXMacroblock;

/* loaded from: classes2.dex */
public class FilterUtil {

    public static class Segment {
        public int p0;
        public int p1;
        public int p2;
        public int p3;
        public int q0;
        public int q1;
        public int q2;
        public int q3;

        private int adjust(boolean z) {
            int iMinus128 = FilterUtil.minus128(this.p1);
            int iMinus1282 = FilterUtil.minus128(this.p0);
            int iMinus1283 = FilterUtil.minus128(this.q0);
            int iClipSigned = FilterUtil.clipSigned((z ? FilterUtil.clipSigned(iMinus128 - FilterUtil.minus128(this.q1)) : 0) + ((iMinus1283 - iMinus1282) * 3));
            int iClipSigned2 = FilterUtil.clipSigned(iClipSigned + 3) >> 3;
            int iClipSigned3 = FilterUtil.clipSigned(iClipSigned + 4) >> 3;
            this.q0 = FilterUtil.clipPlus128(iMinus1283 - iClipSigned3);
            this.p0 = FilterUtil.clipPlus128(iMinus1282 + iClipSigned2);
            return iClipSigned3;
        }

        public static Segment horizontal(VPXMacroblock.Subblock subblock, VPXMacroblock.Subblock subblock2, int i) {
            Segment segment = new Segment();
            int[] iArr = subblock2.val;
            int i2 = i + 12;
            segment.p0 = iArr[i2];
            int i3 = i + 8;
            segment.p1 = iArr[i3];
            int i4 = i + 4;
            segment.p2 = iArr[i4];
            int i5 = i + 0;
            segment.p3 = iArr[i5];
            int[] iArr2 = subblock.val;
            segment.q0 = iArr2[i5];
            segment.q1 = iArr2[i4];
            segment.q2 = iArr2[i3];
            segment.q3 = iArr2[i2];
            return segment;
        }

        public static Segment vertical(VPXMacroblock.Subblock subblock, VPXMacroblock.Subblock subblock2, int i) {
            Segment segment = new Segment();
            int[] iArr = subblock2.val;
            int i2 = i * 4;
            int i3 = i2 + 3;
            segment.p0 = iArr[i3];
            int i4 = i2 + 2;
            segment.p1 = iArr[i4];
            int i5 = i2 + 1;
            segment.p2 = iArr[i5];
            int i6 = i2 + 0;
            segment.p3 = iArr[i6];
            int[] iArr2 = subblock.val;
            segment.q0 = iArr2[i6];
            segment.q1 = iArr2[i5];
            segment.q2 = iArr2[i4];
            segment.q3 = iArr2[i3];
            return segment;
        }

        public void applyHorizontally(VPXMacroblock.Subblock subblock, VPXMacroblock.Subblock subblock2, int i) {
            int[] iArr = subblock2.val;
            int i2 = i + 12;
            iArr[i2] = this.p0;
            int i3 = i + 8;
            iArr[i3] = this.p1;
            int i4 = i + 4;
            iArr[i4] = this.p2;
            int i5 = i + 0;
            iArr[i5] = this.p3;
            int[] iArr2 = subblock.val;
            iArr2[i5] = this.q0;
            iArr2[i4] = this.q1;
            iArr2[i3] = this.q2;
            iArr2[i2] = this.q3;
        }

        public void applyVertically(VPXMacroblock.Subblock subblock, VPXMacroblock.Subblock subblock2, int i) {
            int[] iArr = subblock2.val;
            int i2 = i * 4;
            int i3 = i2 + 3;
            iArr[i3] = this.p0;
            int i4 = i2 + 2;
            iArr[i4] = this.p1;
            int i5 = i2 + 1;
            iArr[i5] = this.p2;
            int i6 = i2 + 0;
            iArr[i6] = this.p3;
            int[] iArr2 = subblock.val;
            iArr2[i6] = this.q0;
            iArr2[i5] = this.q1;
            iArr2[i4] = this.q2;
            iArr2[i3] = this.q3;
        }

        public void filterMb(int i, int i2, int i3) {
            Segment signed = getSigned();
            if (signed.isFilterRequired(i2, i3)) {
                if (signed.isHighVariance(i)) {
                    adjust(true);
                    return;
                }
                int iClipSigned = FilterUtil.clipSigned(FilterUtil.clipSigned(signed.p1 - signed.q1) + ((signed.q0 - signed.p0) * 3));
                int i4 = ((iClipSigned * 27) + 63) >> 7;
                this.q0 = FilterUtil.clipPlus128(signed.q0 - i4);
                this.p0 = FilterUtil.clipPlus128(signed.p0 + i4);
                int i5 = ((iClipSigned * 18) + 63) >> 7;
                this.q1 = FilterUtil.clipPlus128(signed.q1 - i5);
                this.p1 = FilterUtil.clipPlus128(signed.p1 + i5);
                int i6 = ((iClipSigned * 9) + 63) >> 7;
                this.q2 = FilterUtil.clipPlus128(signed.q2 - i6);
                this.p2 = FilterUtil.clipPlus128(signed.p2 + i6);
            }
        }

        public void filterSb(int i, int i2, int i3) {
            Segment signed = getSigned();
            if (signed.isFilterRequired(i2, i3)) {
                boolean zIsHighVariance = signed.isHighVariance(i);
                int iAdjust = (adjust(zIsHighVariance) + 1) >> 1;
                if (zIsHighVariance) {
                    return;
                }
                this.q1 = FilterUtil.clipPlus128(signed.q1 - iAdjust);
                this.p1 = FilterUtil.clipPlus128(signed.p1 + iAdjust);
            }
        }

        public Segment getSigned() {
            Segment segment = new Segment();
            segment.p3 = FilterUtil.minus128(this.p3);
            segment.p2 = FilterUtil.minus128(this.p2);
            segment.p1 = FilterUtil.minus128(this.p1);
            segment.p0 = FilterUtil.minus128(this.p0);
            segment.q0 = FilterUtil.minus128(this.q0);
            segment.q1 = FilterUtil.minus128(this.q1);
            segment.q2 = FilterUtil.minus128(this.q2);
            segment.q3 = FilterUtil.minus128(this.q3);
            return segment;
        }

        public boolean isFilterRequired(int i, int i2) {
            return (Math.abs(this.p0 - this.q0) << 2) + (Math.abs(this.p1 - this.q1) >> 2) <= i2 && Math.abs(this.p3 - this.p2) <= i && Math.abs(this.p2 - this.p1) <= i && Math.abs(this.p1 - this.p0) <= i && Math.abs(this.q3 - this.q2) <= i && Math.abs(this.q2 - this.q1) <= i && Math.abs(this.q1 - this.q0) <= i;
        }

        public boolean isHighVariance(int i) {
            return Math.abs(this.p1 - this.p0) > i || Math.abs(this.q1 - this.q0) > i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int clipPlus128(int i) {
        return clipSigned(i) + 128;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int clipSigned(int i) {
        if (i < -128) {
            return -128;
        }
        if (i > 127) {
            return 127;
        }
        return i;
    }

    public static void loopFilterUV(VPXMacroblock[][] vPXMacroblockArr, int i, boolean z) {
        int i2;
        int i3 = i;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = 2;
            if (i5 >= vPXMacroblockArr.length - 2) {
                return;
            }
            int i7 = i4;
            while (i7 < vPXMacroblockArr[i4].length - i6) {
                int i8 = i5 + 1;
                VPXMacroblock[] vPXMacroblockArr2 = vPXMacroblockArr[i8];
                int i9 = i7 + 1;
                VPXMacroblock vPXMacroblock = vPXMacroblockArr2[i9];
                int i10 = vPXMacroblock.filterLevel;
                if (i10 != 0) {
                    char c = 1;
                    if (i3 > 0) {
                        i2 = i10 >> (i3 > 4 ? i6 : 1);
                        int i11 = 9 - i3;
                        if (i2 > i11) {
                            i2 = i11;
                        }
                    } else {
                        i2 = i10;
                    }
                    if (i2 == 0) {
                        i2 = 1;
                    }
                    if (!z) {
                        throw new NotImplementedException("TODO: non-key frames are not supported yet.");
                    }
                    int i12 = i10 >= 40 ? i6 : i10 >= 15 ? 1 : i4;
                    int i13 = ((i10 + 2) * i6) + i2;
                    int i14 = (i10 * 2) + i2;
                    if (i7 > 0) {
                        VPXMacroblock vPXMacroblock2 = vPXMacroblockArr2[i9 - 1];
                        int i15 = i4;
                        while (i15 < i6) {
                            VPXMacroblock.Subblock subblock = vPXMacroblock.uSubblocks[i15][i4];
                            VPXMacroblock.Subblock subblock2 = vPXMacroblock2.uSubblocks[i15][c];
                            VPXMacroblock.Subblock subblock3 = vPXMacroblock.vSubblocks[i15][i4];
                            VPXMacroblock.Subblock subblock4 = vPXMacroblock2.vSubblocks[i15][1];
                            VPXMacroblock vPXMacroblock3 = vPXMacroblock2;
                            for (int i16 = 0; i16 < 4; i16++) {
                                Segment segmentHorizontal = Segment.horizontal(subblock, subblock2, i16);
                                segmentHorizontal.filterMb(i12, i2, i13);
                                segmentHorizontal.applyHorizontally(subblock, subblock2, i16);
                                Segment segmentHorizontal2 = Segment.horizontal(subblock3, subblock4, i16);
                                segmentHorizontal2.filterMb(i12, i2, i13);
                                segmentHorizontal2.applyHorizontally(subblock3, subblock4, i16);
                            }
                            i15++;
                            vPXMacroblock2 = vPXMacroblock3;
                            i4 = 0;
                            i6 = 2;
                            c = 1;
                        }
                    }
                    if (!vPXMacroblock.skipFilter) {
                        int i17 = 1;
                        while (true) {
                            if (i17 >= 2) {
                                break;
                            }
                            int i18 = 0;
                            for (int i19 = 2; i18 < i19; i19 = 2) {
                                VPXMacroblock.Subblock[] subblockArr = vPXMacroblock.uSubblocks[i18];
                                int i20 = i17 - 1;
                                VPXMacroblock.Subblock subblock5 = subblockArr[i20];
                                VPXMacroblock.Subblock subblock6 = subblockArr[i17];
                                VPXMacroblock.Subblock[] subblockArr2 = vPXMacroblock.vSubblocks[i18];
                                VPXMacroblock.Subblock subblock7 = subblockArr2[i20];
                                VPXMacroblock.Subblock subblock8 = subblockArr2[i17];
                                int i21 = i13;
                                for (int i22 = 0; i22 < 4; i22++) {
                                    Segment segmentHorizontal3 = Segment.horizontal(subblock6, subblock5, i22);
                                    segmentHorizontal3.filterSb(i12, i2, i14);
                                    segmentHorizontal3.applyHorizontally(subblock6, subblock5, i22);
                                    Segment segmentHorizontal4 = Segment.horizontal(subblock8, subblock7, i22);
                                    segmentHorizontal4.filterSb(i12, i2, i14);
                                    segmentHorizontal4.applyHorizontally(subblock8, subblock7, i22);
                                }
                                i18++;
                                i13 = i21;
                            }
                            i17++;
                        }
                    }
                    int i23 = i13;
                    if (i5 > 0) {
                        VPXMacroblock vPXMacroblock4 = vPXMacroblockArr[i8 - 1][i9];
                        for (int i24 = 0; i24 < 2; i24++) {
                            VPXMacroblock.Subblock subblock9 = vPXMacroblock4.uSubblocks[1][i24];
                            VPXMacroblock.Subblock subblock10 = vPXMacroblock.uSubblocks[0][i24];
                            VPXMacroblock.Subblock subblock11 = vPXMacroblock4.vSubblocks[1][i24];
                            VPXMacroblock.Subblock subblock12 = vPXMacroblock.vSubblocks[0][i24];
                            int i25 = 0;
                            for (int i26 = 4; i25 < i26; i26 = 4) {
                                Segment segmentVertical = Segment.vertical(subblock10, subblock9, i25);
                                segmentVertical.filterMb(i12, i2, i23);
                                segmentVertical.applyVertically(subblock10, subblock9, i25);
                                Segment segmentVertical2 = Segment.vertical(subblock12, subblock11, i25);
                                segmentVertical2.filterMb(i12, i2, i23);
                                segmentVertical2.applyVertically(subblock12, subblock11, i25);
                                i25++;
                            }
                        }
                    }
                    if (!vPXMacroblock.skipFilter) {
                        int i27 = 2;
                        int i28 = 1;
                        while (i28 < i27) {
                            int i29 = 0;
                            while (i29 < i27) {
                                VPXMacroblock.Subblock[][] subblockArr3 = vPXMacroblock.uSubblocks;
                                int i30 = i28 - 1;
                                VPXMacroblock.Subblock subblock13 = subblockArr3[i30][i29];
                                VPXMacroblock.Subblock subblock14 = subblockArr3[i28][i29];
                                VPXMacroblock.Subblock[][] subblockArr4 = vPXMacroblock.vSubblocks;
                                VPXMacroblock.Subblock subblock15 = subblockArr4[i30][i29];
                                VPXMacroblock.Subblock subblock16 = subblockArr4[i28][i29];
                                for (int i31 = 0; i31 < 4; i31++) {
                                    Segment segmentVertical3 = Segment.vertical(subblock14, subblock13, i31);
                                    segmentVertical3.filterSb(i12, i2, i14);
                                    segmentVertical3.applyVertically(subblock14, subblock13, i31);
                                    Segment segmentVertical4 = Segment.vertical(subblock16, subblock15, i31);
                                    segmentVertical4.filterSb(i12, i2, i14);
                                    segmentVertical4.applyVertically(subblock16, subblock15, i31);
                                }
                                i29++;
                                i27 = 2;
                            }
                            i28++;
                            i27 = 2;
                        }
                    }
                }
                i3 = i;
                i7 = i9;
                i4 = 0;
                i6 = 2;
            }
            i5++;
            i3 = i;
            i4 = 0;
        }
    }

    public static void loopFilterY(VPXMacroblock[][] vPXMacroblockArr, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= vPXMacroblockArr.length - 2) {
                return;
            }
            int i6 = i4;
            for (int i7 = 2; i6 < vPXMacroblockArr[i4].length - i7; i7 = 2) {
                VPXMacroblock[] vPXMacroblockArr2 = vPXMacroblockArr[i5 + 1];
                int i8 = i6 + 1;
                VPXMacroblock vPXMacroblock = vPXMacroblockArr2[i8];
                int i9 = vPXMacroblock.filterLevel;
                if (i9 != 0) {
                    if (i > 0) {
                        i3 = i9 >> (i > 4 ? i7 : 1);
                        int i10 = 9 - i;
                        if (i3 > i10) {
                            i3 = i10;
                        }
                    } else {
                        i3 = i9;
                    }
                    if (i3 == 0) {
                        i3 = 1;
                    }
                    if (!z) {
                        throw new NotImplementedException("TODO: non-key frames are not supported yet");
                    }
                    int i11 = i9 >= 40 ? i7 : i9 >= 15 ? 1 : i4;
                    int i12 = ((i9 + 2) * i7) + i3;
                    int i13 = (i9 * 2) + i3;
                    char c = 3;
                    if (i6 > 0) {
                        VPXMacroblock vPXMacroblock2 = vPXMacroblockArr2[(i6 - 1) + 1];
                        int i14 = i4;
                        while (i14 < 4) {
                            VPXMacroblock.Subblock subblock = vPXMacroblock.ySubblocks[i14][i4];
                            VPXMacroblock.Subblock subblock2 = vPXMacroblock2.ySubblocks[i14][c];
                            for (int i15 = 0; i15 < 4; i15++) {
                                Segment segmentHorizontal = Segment.horizontal(subblock, subblock2, i15);
                                segmentHorizontal.filterMb(i11, i3, i12);
                                segmentHorizontal.applyHorizontally(subblock, subblock2, i15);
                            }
                            i14++;
                            i4 = 0;
                            c = 3;
                        }
                    }
                    if (!vPXMacroblock.skipFilter) {
                        for (int i16 = 1; i16 < 4; i16++) {
                            for (int i17 = 0; i17 < 4; i17++) {
                                VPXMacroblock.Subblock[] subblockArr = vPXMacroblock.ySubblocks[i17];
                                VPXMacroblock.Subblock subblock3 = subblockArr[i16 - 1];
                                VPXMacroblock.Subblock subblock4 = subblockArr[i16];
                                for (int i18 = 0; i18 < 4; i18++) {
                                    Segment segmentHorizontal2 = Segment.horizontal(subblock4, subblock3, i18);
                                    segmentHorizontal2.filterSb(i11, i3, i13);
                                    segmentHorizontal2.applyHorizontally(subblock4, subblock3, i18);
                                }
                            }
                        }
                    }
                    if (i5 > 0) {
                        VPXMacroblock vPXMacroblock3 = vPXMacroblockArr[(i5 - 1) + 1][i8];
                        for (int i19 = 0; i19 < 4; i19++) {
                            VPXMacroblock.Subblock subblock5 = vPXMacroblock3.ySubblocks[3][i19];
                            VPXMacroblock.Subblock subblock6 = vPXMacroblock.ySubblocks[0][i19];
                            for (int i20 = 0; i20 < 4; i20++) {
                                Segment segmentVertical = Segment.vertical(subblock6, subblock5, i20);
                                segmentVertical.filterMb(i11, i3, i12);
                                segmentVertical.applyVertically(subblock6, subblock5, i20);
                            }
                        }
                    }
                    i2 = 0;
                    if (!vPXMacroblock.skipFilter) {
                        for (int i21 = 1; i21 < 4; i21++) {
                            for (int i22 = 0; i22 < 4; i22++) {
                                VPXMacroblock.Subblock[][] subblockArr2 = vPXMacroblock.ySubblocks;
                                VPXMacroblock.Subblock subblock7 = subblockArr2[i21 - 1][i22];
                                VPXMacroblock.Subblock subblock8 = subblockArr2[i21][i22];
                                for (int i23 = 0; i23 < 4; i23++) {
                                    Segment segmentVertical2 = Segment.vertical(subblock8, subblock7, i23);
                                    segmentVertical2.filterSb(i11, i3, i13);
                                    segmentVertical2.applyVertically(subblock8, subblock7, i23);
                                }
                            }
                        }
                    }
                } else {
                    i2 = i4;
                }
                i6 = i8;
                i4 = i2;
            }
            i5++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int minus128(int i) {
        return i - 128;
    }
}
