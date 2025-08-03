package org.jcodec.common.dct;

import java.nio.IntBuffer;
import org.jcodec.containers.dpx.DPXReader;

/* loaded from: classes2.dex */
public class IntDCT extends DCT {
    private static final int CENTERJSAMPLE = 128;
    private static final int CONST_BITS = 13;
    private static final int DCTSIZE = 8;
    private static final int FIX_0_298631336;
    private static final int FIX_0_390180644;
    private static final int FIX_0_541196100;
    private static final int FIX_0_765366865;
    private static final int FIX_0_899976223;
    private static final int FIX_1_175875602;
    private static final int FIX_1_501321110;
    private static final int FIX_1_847759065;
    private static final int FIX_1_961570560;
    private static final int FIX_2_053119869;
    private static final int FIX_2_562915447;
    private static final int FIX_3_072711026;
    private static final int MAXJSAMPLE = 255;
    private static final int ONE_HALF = 4096;
    private static final int PASS1_BITS = 2;
    private static final int RANGE_MASK = 1023;
    private static final IntBuffer idct_sample_range_limit;
    public static final IntDCT INSTANCE = new IntDCT();
    private static final IntBuffer sample_range_limit = IntBuffer.allocate(DPXReader.IMAGESOURCE_OFFSET);

    static {
        idct_sample_range_limit = IntBuffer.allocate(r0.capacity() - 128);
        prepare_range_limit_table();
        FIX_0_298631336 = FIX(0.298631336d);
        FIX_0_390180644 = FIX(0.390180644d);
        FIX_0_541196100 = FIX(0.5411961d);
        FIX_0_765366865 = FIX(0.765366865d);
        FIX_0_899976223 = FIX(0.899976223d);
        FIX_1_175875602 = FIX(1.175875602d);
        FIX_1_501321110 = FIX(1.50132111d);
        FIX_1_847759065 = FIX(1.847759065d);
        FIX_1_961570560 = FIX(1.96157056d);
        FIX_2_053119869 = FIX(2.053119869d);
        FIX_2_562915447 = FIX(2.562915447d);
        FIX_3_072711026 = FIX(3.072711026d);
    }

    public static int DESCALE(int i, int i2) {
        return RIGHT_SHIFT(i + (1 << (i2 - 1)), i2);
    }

    private static int FIX(double d) {
        return (int) ((d * 8192.0d) + 0.5d);
    }

    private static int MULTIPLY(int i, int i2) {
        return i * i2;
    }

    private static int RIGHT_SHIFT(int i, int i2) {
        return i >> i2;
    }

    private static IntBuffer advance(IntBuffer intBuffer) {
        return doAdvance(intBuffer, 1);
    }

    private static IntBuffer doAdvance(IntBuffer intBuffer, int i) {
        intBuffer.position(intBuffer.position() + i);
        return intBuffer.slice();
    }

    public static IntBuffer doDecode(IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3) {
        pass1(intBuffer, intBuffer2.duplicate());
        pass2(intBuffer3, intBuffer2.duplicate());
        return intBuffer3;
    }

    private static void pass1(IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i = 8;
        IntBuffer intBufferAdvance = intBuffer;
        IntBuffer intBufferAdvance2 = intBuffer2;
        int i2 = 8;
        while (i2 > 0) {
            int i3 = intBufferAdvance.get(16);
            int i4 = intBufferAdvance.get(48);
            int iMULTIPLY = MULTIPLY(i3 + i4, FIX_0_541196100);
            int iMULTIPLY2 = MULTIPLY(i4, -FIX_1_847759065) + iMULTIPLY;
            int iMULTIPLY3 = iMULTIPLY + MULTIPLY(i3, FIX_0_765366865);
            int i5 = intBufferAdvance.get(0);
            int i6 = intBufferAdvance.get(32);
            int i7 = (i5 + i6) << 13;
            int i8 = (i5 - i6) << 13;
            int i9 = i7 + iMULTIPLY3;
            int i10 = i7 - iMULTIPLY3;
            int i11 = i8 + iMULTIPLY2;
            int i12 = i8 - iMULTIPLY2;
            int i13 = intBufferAdvance.get(56);
            int i14 = intBufferAdvance.get(40);
            int i15 = intBufferAdvance.get(24);
            int i16 = intBufferAdvance.get(i);
            int i17 = i13 + i16;
            int i18 = i14 + i15;
            int i19 = i13 + i15;
            int i20 = i14 + i16;
            int i21 = i2;
            int iMULTIPLY4 = MULTIPLY(i19 + i20, FIX_1_175875602);
            int iMULTIPLY5 = MULTIPLY(i13, FIX_0_298631336);
            int iMULTIPLY6 = MULTIPLY(i14, FIX_2_053119869);
            int iMULTIPLY7 = MULTIPLY(i15, FIX_3_072711026);
            int iMULTIPLY8 = MULTIPLY(i16, FIX_1_501321110);
            int iMULTIPLY9 = MULTIPLY(i17, -FIX_0_899976223);
            int iMULTIPLY10 = MULTIPLY(i18, -FIX_2_562915447);
            int iMULTIPLY11 = MULTIPLY(i19, -FIX_1_961570560) + iMULTIPLY4;
            int iMULTIPLY12 = MULTIPLY(i20, -FIX_0_390180644) + iMULTIPLY4;
            int i22 = iMULTIPLY5 + iMULTIPLY9 + iMULTIPLY11;
            int i23 = iMULTIPLY6 + iMULTIPLY10 + iMULTIPLY12;
            int i24 = iMULTIPLY7 + iMULTIPLY10 + iMULTIPLY11;
            int i25 = iMULTIPLY8 + iMULTIPLY9 + iMULTIPLY12;
            intBufferAdvance2.put(0, DESCALE(i9 + i25, 11));
            intBufferAdvance2.put(56, DESCALE(i9 - i25, 11));
            intBufferAdvance2.put(8, DESCALE(i11 + i24, 11));
            intBufferAdvance2.put(48, DESCALE(i11 - i24, 11));
            intBufferAdvance2.put(16, DESCALE(i12 + i23, 11));
            intBufferAdvance2.put(40, DESCALE(i12 - i23, 11));
            intBufferAdvance2.put(24, DESCALE(i10 + i22, 11));
            intBufferAdvance2.put(32, DESCALE(i10 - i22, 11));
            intBufferAdvance = advance(intBufferAdvance);
            intBufferAdvance2 = advance(intBufferAdvance2);
            i2 = i21 - 1;
            i = 8;
        }
    }

    private static void pass2(IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i = 0;
        IntBuffer intBufferDoAdvance = intBuffer2;
        int i2 = 0;
        while (i2 < 8) {
            int i3 = intBufferDoAdvance.get(2);
            int i4 = intBufferDoAdvance.get(6);
            int iMULTIPLY = MULTIPLY(i3 + i4, FIX_0_541196100);
            int iMULTIPLY2 = MULTIPLY(i4, -FIX_1_847759065) + iMULTIPLY;
            int iMULTIPLY3 = iMULTIPLY + MULTIPLY(i3, FIX_0_765366865);
            int i5 = (intBufferDoAdvance.get(i) + intBufferDoAdvance.get(4)) << 13;
            int i6 = (intBufferDoAdvance.get(i) - intBufferDoAdvance.get(4)) << 13;
            int i7 = i5 + iMULTIPLY3;
            int i8 = i5 - iMULTIPLY3;
            int i9 = i6 + iMULTIPLY2;
            int i10 = i6 - iMULTIPLY2;
            int i11 = intBufferDoAdvance.get(7);
            int i12 = intBufferDoAdvance.get(5);
            int i13 = intBufferDoAdvance.get(3);
            int i14 = intBufferDoAdvance.get(1);
            int i15 = i11 + i14;
            int i16 = i12 + i13;
            int i17 = i11 + i13;
            int i18 = i12 + i14;
            int i19 = i2;
            int iMULTIPLY4 = MULTIPLY(i17 + i18, FIX_1_175875602);
            int iMULTIPLY5 = MULTIPLY(i11, FIX_0_298631336);
            int iMULTIPLY6 = MULTIPLY(i12, FIX_2_053119869);
            int iMULTIPLY7 = MULTIPLY(i13, FIX_3_072711026);
            int iMULTIPLY8 = MULTIPLY(i14, FIX_1_501321110);
            int iMULTIPLY9 = MULTIPLY(i15, -FIX_0_899976223);
            int iMULTIPLY10 = MULTIPLY(i16, -FIX_2_562915447);
            int iMULTIPLY11 = MULTIPLY(i17, -FIX_1_961570560) + iMULTIPLY4;
            int iMULTIPLY12 = MULTIPLY(i18, -FIX_0_390180644) + iMULTIPLY4;
            int i20 = iMULTIPLY5 + iMULTIPLY9 + iMULTIPLY11;
            int i21 = iMULTIPLY6 + iMULTIPLY10 + iMULTIPLY12;
            int i22 = iMULTIPLY7 + iMULTIPLY10 + iMULTIPLY11;
            int i23 = iMULTIPLY8 + iMULTIPLY9 + iMULTIPLY12;
            intBuffer.put(range_limit(DESCALE(i7 + i23, 18) & RANGE_MASK));
            intBuffer.put(range_limit(DESCALE(i9 + i22, 18) & RANGE_MASK));
            intBuffer.put(range_limit(DESCALE(i10 + i21, 18) & RANGE_MASK));
            intBuffer.put(range_limit(DESCALE(i8 + i20, 18) & RANGE_MASK));
            intBuffer.put(range_limit(DESCALE(i8 - i20, 18) & RANGE_MASK));
            intBuffer.put(range_limit(DESCALE(i10 - i21, 18) & RANGE_MASK));
            intBuffer.put(range_limit(DESCALE(i9 - i22, 18) & RANGE_MASK));
            intBuffer.put(range_limit(DESCALE(i7 - i23, 18) & RANGE_MASK));
            intBufferDoAdvance = doAdvance(intBufferDoAdvance, 8);
            i2 = i19 + 1;
            i = 0;
        }
    }

    private static void prepare_range_limit_table() {
        sample_range_limit.position(256);
        int i = 0;
        for (int i2 = 0; i2 < 128; i2++) {
            sample_range_limit.put(i2);
        }
        for (int i3 = -128; i3 < 0; i3++) {
            sample_range_limit.put(i3);
        }
        for (int i4 = 0; i4 < 384; i4++) {
            sample_range_limit.put(-1);
        }
        for (int i5 = 0; i5 < 384; i5++) {
            sample_range_limit.put(0);
        }
        for (int i6 = 0; i6 < 128; i6++) {
            sample_range_limit.put(i6);
        }
        while (true) {
            IntBuffer intBuffer = idct_sample_range_limit;
            if (i >= intBuffer.capacity()) {
                return;
            }
            intBuffer.put(sample_range_limit.get(i + 128) & 255);
            i++;
        }
    }

    public static int range_limit(int i) {
        return idct_sample_range_limit.get(i + 256);
    }

    private static boolean shortcut(IntBuffer intBuffer, IntBuffer intBuffer2) {
        if (intBuffer.get(8) != 0 || intBuffer.get(16) != 0 || intBuffer.get(24) != 0 || intBuffer.get(32) != 0 || intBuffer.get(40) != 0 || intBuffer.get(48) != 0 || intBuffer.get(56) != 0) {
            return false;
        }
        int i = intBuffer.get(0) << 2;
        intBuffer2.put(0, i);
        intBuffer2.put(8, i);
        intBuffer2.put(16, i);
        intBuffer2.put(24, i);
        intBuffer2.put(32, i);
        intBuffer2.put(40, i);
        intBuffer2.put(48, i);
        intBuffer2.put(56, i);
        advance(intBuffer);
        advance(intBuffer2);
        return true;
    }

    @Override // org.jcodec.common.dct.DCT
    public int[] decode(int[] iArr) {
        IntBuffer intBufferWrap = IntBuffer.wrap(iArr);
        IntBuffer intBufferAllocate = IntBuffer.allocate(64);
        IntBuffer intBufferAllocate2 = IntBuffer.allocate(64);
        doDecode(intBufferWrap, intBufferAllocate, intBufferAllocate2);
        return intBufferAllocate2.array();
    }
}
