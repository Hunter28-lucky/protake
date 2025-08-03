package org.jcodec.common.dct;

import java.nio.ShortBuffer;

/* loaded from: classes2.dex */
public class FfmpegIntDct {
    private static final int CONST_BITS = 13;
    private static final int D1 = 11;
    private static final int D2 = 18;
    private static final int DCTSIZE = 8;
    private static final int DCTSIZE_0 = 0;
    private static final int DCTSIZE_1 = 8;
    private static final int DCTSIZE_2 = 16;
    private static final int DCTSIZE_3 = 24;
    private static final int DCTSIZE_4 = 32;
    private static final int DCTSIZE_5 = 40;
    private static final int DCTSIZE_6 = 48;
    private static final int DCTSIZE_7 = 56;
    private static final short FIX_0_211164243 = 1730;
    private static final short FIX_0_275899380 = 2260;
    private static final short FIX_0_298631336 = 2446;
    private static final short FIX_0_390180644 = 3196;
    private static final short FIX_0_509795579 = 4176;
    private static final short FIX_0_541196100 = 4433;
    private static final short FIX_0_601344887 = 4926;
    private static final short FIX_0_765366865 = 6270;
    private static final short FIX_0_785694958 = 6436;
    private static final short FIX_0_899976223 = 7373;
    private static final short FIX_1_061594337 = 8697;
    private static final short FIX_1_111140466 = 9102;
    private static final short FIX_1_175875602 = 9633;
    private static final short FIX_1_306562965 = 10703;
    private static final short FIX_1_387039845 = 11363;
    private static final short FIX_1_451774981 = 11893;
    private static final short FIX_1_501321110 = 12299;
    private static final short FIX_1_662939225 = 13623;
    private static final short FIX_1_847759065 = 15137;
    private static final short FIX_1_961570560 = 16069;
    private static final short FIX_2_053119869 = 16819;
    private static final short FIX_2_172734803 = 17799;
    private static final short FIX_2_562915447 = 20995;
    private static final short FIX_3_072711026 = 25172;
    private static final int ONEHALF_11 = 1024;
    private static final int ONEHALF_18 = 131072;
    private static final int PASS1_BITS = 2;

    private static final int DESCALE(int i, int i2) {
        return (i + (1 << (i2 - 1))) >> i2;
    }

    private static final short DESCALE11(int i) {
        return (short) ((i + 1024) >> 11);
    }

    private static final short DESCALE18(int i) {
        return (short) ((i + 131072) >> 18);
    }

    private static int MULTIPLY(int i, short s) {
        return s * ((short) i);
    }

    private static ShortBuffer advance(ShortBuffer shortBuffer, int i) {
        shortBuffer.position(shortBuffer.position() + i);
        return shortBuffer.slice();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x029c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void pass1(java.nio.ShortBuffer r18) {
        /*
            Method dump skipped, instructions count: 1067
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.common.dct.FfmpegIntDct.pass1(java.nio.ShortBuffer):void");
    }

    private static final void pass2(ShortBuffer shortBuffer) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int iMULTIPLY;
        int iMULTIPLY2;
        int iMULTIPLY3;
        int iMULTIPLY4;
        int iMULTIPLY5;
        int iMULTIPLY6;
        int iMULTIPLY7;
        int iMULTIPLY8;
        int iMULTIPLY9;
        ShortBuffer shortBufferDuplicate = shortBuffer.duplicate();
        int i7 = 7;
        while (i7 >= 0) {
            short s = shortBufferDuplicate.get(0);
            short s2 = shortBufferDuplicate.get(8);
            short s3 = shortBufferDuplicate.get(16);
            short s4 = shortBufferDuplicate.get(24);
            short s5 = shortBufferDuplicate.get(32);
            short s6 = shortBufferDuplicate.get(40);
            short s7 = shortBufferDuplicate.get(48);
            short s8 = shortBufferDuplicate.get(56);
            if (s7 != 0) {
                if (s3 != 0) {
                    int iMULTIPLY10 = MULTIPLY(s3 + s7, FIX_0_541196100);
                    int iMULTIPLY11 = MULTIPLY(-s7, FIX_1_847759065) + iMULTIPLY10;
                    int iMULTIPLY12 = iMULTIPLY10 + MULTIPLY(s3, FIX_0_765366865);
                    int i8 = (s + s5) << 13;
                    int i9 = (s - s5) << 13;
                    i3 = i8 + iMULTIPLY12;
                    i = i8 - iMULTIPLY12;
                    i2 = i9 + iMULTIPLY11;
                    i4 = i9 - iMULTIPLY11;
                } else {
                    int iMULTIPLY13 = MULTIPLY(-s7, FIX_1_306562965);
                    int iMULTIPLY14 = MULTIPLY(s7, FIX_0_541196100);
                    int i10 = (s + s5) << 13;
                    int i11 = (s - s5) << 13;
                    i3 = i10 + iMULTIPLY14;
                    int i12 = i10 - iMULTIPLY14;
                    i5 = i11 + iMULTIPLY13;
                    i4 = i11 - iMULTIPLY13;
                    i = i12;
                    i2 = i5;
                }
            } else if (s3 != 0) {
                int iMULTIPLY15 = MULTIPLY(s3, FIX_0_541196100);
                int iMULTIPLY16 = MULTIPLY(s3, FIX_1_306562965);
                int i13 = (s + s5) << 13;
                int i14 = (s - s5) << 13;
                i3 = i13 + iMULTIPLY16;
                i = i13 - iMULTIPLY16;
                i5 = i14 + iMULTIPLY15;
                i4 = i14 - iMULTIPLY15;
                i2 = i5;
            } else {
                i = (s + s5) << 13;
                i2 = (s - s5) << 13;
                i3 = i;
                i4 = i2;
            }
            if (s8 == 0) {
                i6 = i7;
                if (s6 != 0) {
                    if (s4 != 0) {
                        if (s2 != 0) {
                            int i15 = s6 + s2;
                            int iMULTIPLY17 = MULTIPLY(s4 + i15, FIX_1_175875602);
                            int iMULTIPLY18 = MULTIPLY(s6, FIX_2_053119869);
                            int iMULTIPLY19 = MULTIPLY(s4, FIX_3_072711026);
                            int iMULTIPLY20 = MULTIPLY(s2, FIX_1_501321110);
                            int iMULTIPLY21 = MULTIPLY(-s2, FIX_0_899976223);
                            int iMULTIPLY22 = MULTIPLY(-(s6 + s4), FIX_2_562915447);
                            int iMULTIPLY23 = MULTIPLY(-s4, FIX_1_961570560) + iMULTIPLY17;
                            int iMULTIPLY24 = MULTIPLY(-i15, FIX_0_390180644) + iMULTIPLY17;
                            iMULTIPLY = iMULTIPLY21 + iMULTIPLY23;
                            iMULTIPLY4 = iMULTIPLY22 + iMULTIPLY24 + iMULTIPLY18;
                            iMULTIPLY3 = iMULTIPLY19 + iMULTIPLY22 + iMULTIPLY23;
                            iMULTIPLY2 = iMULTIPLY21 + iMULTIPLY24 + iMULTIPLY20;
                        } else {
                            int i16 = s6 + s4;
                            int iMULTIPLY25 = MULTIPLY(i16, FIX_1_175875602);
                            int iMULTIPLY26 = MULTIPLY(s6, FIX_1_662939225);
                            int iMULTIPLY27 = MULTIPLY(-s6, FIX_0_390180644);
                            int iMULTIPLY28 = MULTIPLY(-i16, FIX_1_387039845);
                            int iMULTIPLY29 = MULTIPLY(s4, FIX_1_111140466);
                            iMULTIPLY4 = iMULTIPLY26 + iMULTIPLY28;
                            iMULTIPLY2 = iMULTIPLY27 + iMULTIPLY25;
                            iMULTIPLY = MULTIPLY(-s4, FIX_1_961570560) + iMULTIPLY25;
                            iMULTIPLY3 = iMULTIPLY28 + iMULTIPLY29;
                        }
                    } else if (s2 != 0) {
                        int i17 = s6 + s2;
                        iMULTIPLY6 = MULTIPLY(i17, FIX_1_175875602);
                        int iMULTIPLY30 = MULTIPLY(-s2, FIX_0_899976223);
                        iMULTIPLY7 = MULTIPLY(s2, FIX_0_601344887);
                        int i18 = -s6;
                        int iMULTIPLY31 = MULTIPLY(i18, FIX_0_509795579);
                        iMULTIPLY8 = MULTIPLY(i18, FIX_2_562915447);
                        iMULTIPLY9 = MULTIPLY(i17, FIX_0_785694958);
                        iMULTIPLY5 = iMULTIPLY30 + iMULTIPLY6;
                        iMULTIPLY4 = iMULTIPLY31 + iMULTIPLY9;
                        iMULTIPLY3 = iMULTIPLY8 + iMULTIPLY6;
                        iMULTIPLY2 = iMULTIPLY7 + iMULTIPLY9;
                        iMULTIPLY = iMULTIPLY5;
                    } else {
                        iMULTIPLY = MULTIPLY(s6, FIX_1_175875602);
                        int iMULTIPLY32 = MULTIPLY(s6, FIX_0_275899380);
                        iMULTIPLY3 = MULTIPLY(-s6, FIX_1_387039845);
                        iMULTIPLY2 = MULTIPLY(s6, FIX_0_785694958);
                        iMULTIPLY4 = iMULTIPLY32;
                    }
                } else if (s4 != 0) {
                    if (s2 != 0) {
                        int i19 = s2 + s4;
                        int iMULTIPLY33 = MULTIPLY(s2, FIX_0_211164243);
                        int i20 = -s4;
                        int iMULTIPLY34 = MULTIPLY(i20, FIX_1_451774981);
                        int iMULTIPLY35 = MULTIPLY(s2, FIX_1_061594337);
                        int iMULTIPLY36 = MULTIPLY(i20, FIX_2_172734803);
                        int iMULTIPLY37 = MULTIPLY(i19, FIX_0_785694958);
                        int iMULTIPLY38 = MULTIPLY(i19, FIX_1_175875602);
                        iMULTIPLY = iMULTIPLY35 - iMULTIPLY37;
                        iMULTIPLY4 = iMULTIPLY36 + iMULTIPLY37;
                        iMULTIPLY3 = iMULTIPLY34 + iMULTIPLY38;
                        iMULTIPLY2 = iMULTIPLY33 + iMULTIPLY38;
                    } else {
                        int i21 = -s4;
                        iMULTIPLY5 = MULTIPLY(i21, FIX_0_785694958);
                        iMULTIPLY4 = MULTIPLY(i21, FIX_1_387039845);
                        int iMULTIPLY39 = MULTIPLY(i21, FIX_0_275899380);
                        iMULTIPLY2 = MULTIPLY(s4, FIX_1_175875602);
                        iMULTIPLY3 = iMULTIPLY39;
                        iMULTIPLY = iMULTIPLY5;
                    }
                } else if (s2 != 0) {
                    int iMULTIPLY40 = MULTIPLY(s2, FIX_0_275899380);
                    iMULTIPLY4 = MULTIPLY(s2, FIX_0_785694958);
                    iMULTIPLY3 = MULTIPLY(s2, FIX_1_175875602);
                    iMULTIPLY2 = MULTIPLY(s2, FIX_1_387039845);
                    iMULTIPLY = iMULTIPLY40;
                } else {
                    iMULTIPLY = 0;
                    iMULTIPLY2 = 0;
                    iMULTIPLY3 = 0;
                    iMULTIPLY4 = 0;
                }
            } else if (s6 == 0) {
                i6 = i7;
                if (s4 != 0) {
                    if (s2 != 0) {
                        int i22 = s8 + s4;
                        int iMULTIPLY41 = MULTIPLY(i22 + s2, FIX_1_175875602);
                        int iMULTIPLY42 = MULTIPLY(s8, FIX_0_298631336);
                        int iMULTIPLY43 = MULTIPLY(s4, FIX_3_072711026);
                        int iMULTIPLY44 = MULTIPLY(s2, FIX_1_501321110);
                        int iMULTIPLY45 = MULTIPLY(-(s8 + s2), FIX_0_899976223);
                        int iMULTIPLY46 = MULTIPLY(-s4, FIX_2_562915447);
                        int iMULTIPLY47 = MULTIPLY(-i22, FIX_1_961570560) + iMULTIPLY41;
                        int iMULTIPLY48 = MULTIPLY(-s2, FIX_0_390180644) + iMULTIPLY41;
                        iMULTIPLY = iMULTIPLY45 + iMULTIPLY47 + iMULTIPLY42;
                        iMULTIPLY4 = iMULTIPLY46 + iMULTIPLY48;
                        iMULTIPLY3 = iMULTIPLY46 + iMULTIPLY47 + iMULTIPLY43;
                        iMULTIPLY2 = iMULTIPLY44 + iMULTIPLY45 + iMULTIPLY48;
                    } else {
                        int i23 = s8 + s4;
                        int i24 = -s8;
                        int iMULTIPLY49 = MULTIPLY(i24, FIX_0_601344887);
                        int iMULTIPLY50 = MULTIPLY(i24, FIX_0_899976223);
                        int iMULTIPLY51 = MULTIPLY(s4, FIX_0_509795579);
                        int iMULTIPLY52 = MULTIPLY(-s4, FIX_2_562915447);
                        int iMULTIPLY53 = MULTIPLY(i23, FIX_1_175875602);
                        int iMULTIPLY54 = MULTIPLY(-i23, FIX_0_785694958);
                        int i25 = iMULTIPLY49 + iMULTIPLY54;
                        iMULTIPLY4 = iMULTIPLY52 + iMULTIPLY53;
                        iMULTIPLY3 = iMULTIPLY51 + iMULTIPLY54;
                        int i26 = iMULTIPLY50 + iMULTIPLY53;
                        iMULTIPLY = i25;
                        iMULTIPLY2 = i26;
                    }
                } else if (s2 != 0) {
                    int i27 = s8 + s2;
                    iMULTIPLY6 = MULTIPLY(i27, FIX_1_175875602);
                    iMULTIPLY9 = MULTIPLY(i27, FIX_0_275899380);
                    int i28 = -s8;
                    iMULTIPLY8 = MULTIPLY(i28, FIX_1_961570560);
                    int iMULTIPLY55 = MULTIPLY(i28, FIX_1_662939225);
                    int iMULTIPLY56 = MULTIPLY(-s2, FIX_0_390180644);
                    iMULTIPLY7 = MULTIPLY(s2, FIX_1_111140466);
                    iMULTIPLY5 = iMULTIPLY55 + iMULTIPLY9;
                    iMULTIPLY4 = iMULTIPLY56 + iMULTIPLY6;
                    iMULTIPLY3 = iMULTIPLY8 + iMULTIPLY6;
                    iMULTIPLY2 = iMULTIPLY7 + iMULTIPLY9;
                    iMULTIPLY = iMULTIPLY5;
                } else {
                    int i29 = -s8;
                    iMULTIPLY5 = MULTIPLY(i29, FIX_1_387039845);
                    iMULTIPLY4 = MULTIPLY(s8, FIX_1_175875602);
                    iMULTIPLY3 = MULTIPLY(i29, FIX_0_785694958);
                    iMULTIPLY2 = MULTIPLY(s8, FIX_0_275899380);
                    iMULTIPLY = iMULTIPLY5;
                }
            } else if (s4 == 0) {
                i6 = i7;
                if (s2 != 0) {
                    int i30 = s8 + s2;
                    int i31 = s6 + s2;
                    int iMULTIPLY57 = MULTIPLY(s8 + i31, FIX_1_175875602);
                    int iMULTIPLY58 = MULTIPLY(s8, FIX_0_298631336);
                    int iMULTIPLY59 = MULTIPLY(s6, FIX_2_053119869);
                    int iMULTIPLY60 = MULTIPLY(s2, FIX_1_501321110);
                    int iMULTIPLY61 = MULTIPLY(-i30, FIX_0_899976223);
                    int iMULTIPLY62 = MULTIPLY(-s6, FIX_2_562915447);
                    int iMULTIPLY63 = MULTIPLY(-s8, FIX_1_961570560) + iMULTIPLY57;
                    int iMULTIPLY64 = MULTIPLY(-i31, FIX_0_390180644) + iMULTIPLY57;
                    iMULTIPLY = iMULTIPLY61 + iMULTIPLY63 + iMULTIPLY58;
                    iMULTIPLY4 = iMULTIPLY59 + iMULTIPLY62 + iMULTIPLY64;
                    iMULTIPLY3 = iMULTIPLY62 + iMULTIPLY63;
                    iMULTIPLY2 = iMULTIPLY60 + iMULTIPLY61 + iMULTIPLY64;
                } else {
                    int i32 = -s8;
                    int iMULTIPLY65 = MULTIPLY(i32, FIX_0_601344887);
                    int iMULTIPLY66 = MULTIPLY(i32, FIX_0_899976223);
                    int iMULTIPLY67 = MULTIPLY(i32, FIX_1_961570560);
                    int i33 = -s6;
                    int iMULTIPLY68 = MULTIPLY(i33, FIX_0_509795579);
                    int iMULTIPLY69 = MULTIPLY(i33, FIX_2_562915447);
                    int iMULTIPLY70 = MULTIPLY(i33, FIX_0_390180644);
                    int iMULTIPLY71 = MULTIPLY(s6 + s8, FIX_1_175875602);
                    int i34 = iMULTIPLY67 + iMULTIPLY71;
                    int i35 = iMULTIPLY70 + iMULTIPLY71;
                    iMULTIPLY = iMULTIPLY65 + i34;
                    iMULTIPLY4 = iMULTIPLY68 + i35;
                    iMULTIPLY3 = iMULTIPLY69 + i34;
                    iMULTIPLY2 = iMULTIPLY66 + i35;
                }
            } else if (s2 != 0) {
                int i36 = s8 + s2;
                int i37 = s6 + s4;
                int i38 = s8 + s4;
                int i39 = s6 + s2;
                i6 = i7;
                int iMULTIPLY72 = MULTIPLY(i38 + i39, FIX_1_175875602);
                int iMULTIPLY73 = MULTIPLY(s8, FIX_0_298631336);
                int iMULTIPLY74 = MULTIPLY(s6, FIX_2_053119869);
                int iMULTIPLY75 = MULTIPLY(s4, FIX_3_072711026);
                int iMULTIPLY76 = MULTIPLY(s2, FIX_1_501321110);
                int iMULTIPLY77 = MULTIPLY(-i36, FIX_0_899976223);
                int iMULTIPLY78 = MULTIPLY(-i37, FIX_2_562915447);
                int iMULTIPLY79 = MULTIPLY(-i38, FIX_1_961570560) + iMULTIPLY72;
                int iMULTIPLY80 = MULTIPLY(-i39, FIX_0_390180644) + iMULTIPLY72;
                iMULTIPLY = iMULTIPLY73 + iMULTIPLY77 + iMULTIPLY79;
                iMULTIPLY4 = iMULTIPLY74 + iMULTIPLY78 + iMULTIPLY80;
                iMULTIPLY3 = iMULTIPLY75 + iMULTIPLY78 + iMULTIPLY79;
                iMULTIPLY2 = iMULTIPLY76 + iMULTIPLY77 + iMULTIPLY80;
            } else {
                i6 = i7;
                int i40 = s6 + s4;
                int i41 = s8 + s4;
                int iMULTIPLY81 = MULTIPLY(i41 + s6, FIX_1_175875602);
                int iMULTIPLY82 = MULTIPLY(s8, FIX_0_298631336);
                int iMULTIPLY83 = MULTIPLY(s6, FIX_2_053119869);
                int iMULTIPLY84 = MULTIPLY(s4, FIX_3_072711026);
                int iMULTIPLY85 = MULTIPLY(-s8, FIX_0_899976223);
                int iMULTIPLY86 = MULTIPLY(-i40, FIX_2_562915447);
                int iMULTIPLY87 = MULTIPLY(-i41, FIX_1_961570560) + iMULTIPLY81;
                int iMULTIPLY88 = MULTIPLY(-s6, FIX_0_390180644) + iMULTIPLY81;
                iMULTIPLY = iMULTIPLY85 + iMULTIPLY87 + iMULTIPLY82;
                iMULTIPLY4 = iMULTIPLY83 + iMULTIPLY86 + iMULTIPLY88;
                iMULTIPLY3 = iMULTIPLY84 + iMULTIPLY86 + iMULTIPLY87;
                iMULTIPLY2 = iMULTIPLY85 + iMULTIPLY88;
            }
            shortBufferDuplicate.put(0, DESCALE18(i3 + iMULTIPLY2));
            shortBufferDuplicate.put(56, DESCALE18(i3 - iMULTIPLY2));
            shortBufferDuplicate.put(8, DESCALE18(i2 + iMULTIPLY3));
            shortBufferDuplicate.put(48, DESCALE18(i2 - iMULTIPLY3));
            shortBufferDuplicate.put(16, DESCALE18(i4 + iMULTIPLY4));
            shortBufferDuplicate.put(40, DESCALE18(i4 - iMULTIPLY4));
            shortBufferDuplicate.put(24, DESCALE18(i + iMULTIPLY));
            shortBufferDuplicate.put(32, DESCALE18(i - iMULTIPLY));
            shortBufferDuplicate = advance(shortBufferDuplicate, 1);
            i7 = i6 - 1;
        }
    }

    public short[] decode(short[] sArr) {
        ShortBuffer shortBufferWrap = ShortBuffer.wrap(sArr);
        pass1(shortBufferWrap);
        pass2(shortBufferWrap);
        return sArr;
    }
}
