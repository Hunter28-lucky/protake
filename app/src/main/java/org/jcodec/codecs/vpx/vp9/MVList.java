package org.jcodec.codecs.vpx.vp9;

/* loaded from: classes2.dex */
public class MVList {
    private static long HI_MASK = 0;
    private static long HI_MASK_NEG = 0;
    private static long LO_MASK = 2147483647L;
    private static long LO_MASK_NEG = ~(2147483647L | (-4611686018427387904L));

    static {
        long j = 2147483647L << 31;
        HI_MASK = j;
        HI_MASK_NEG = ~(j | (-4611686018427387904L));
    }

    public static long add(long j, int i) {
        long j2;
        long j3;
        long j4;
        long j5 = (j >> 62) & 3;
        if (j5 == 2) {
            return j;
        }
        if (j5 == 0) {
            j2 = (j & LO_MASK_NEG) | 4611686018427387904L;
            j3 = i;
            j4 = LO_MASK;
        } else {
            j2 = (j & HI_MASK_NEG) | Long.MIN_VALUE;
            j3 = i << 31;
            j4 = HI_MASK;
        }
        return j2 | (j3 & j4);
    }

    public static long addUniq(long j, int i) {
        long j2;
        long j3;
        long j4;
        long j5 = (j >> 62) & 3;
        if (j5 == 2) {
            return j;
        }
        if (j5 == 0) {
            j2 = (j & LO_MASK_NEG) | 4611686018427387904L;
            j3 = i;
            j4 = LO_MASK;
        } else {
            if (((int) (LO_MASK & j)) == i) {
                return j;
            }
            j2 = (j & HI_MASK_NEG) | Long.MIN_VALUE;
            j3 = i << 31;
            j4 = HI_MASK;
        }
        return j2 | (j3 & j4);
    }

    public static long create(int i, int i2) {
        return (i & LO_MASK) | (i2 << 31) | Long.MIN_VALUE;
    }

    public static int get(long j, int i) {
        long j2;
        if (i == 0) {
            j2 = LO_MASK;
        } else {
            j >>= 31;
            j2 = LO_MASK;
        }
        return (int) (j & j2);
    }

    public static long set(long j, int i, int i2) {
        long j2;
        long j3;
        long j4;
        long j5 = (j >> 62) & 3;
        long j6 = i + 1;
        if (j6 > j5) {
            j5 = j6;
        }
        if (i == 0) {
            j2 = (j & LO_MASK_NEG) | (j5 << 62);
            j3 = i2;
            j4 = LO_MASK;
        } else {
            j2 = (j & HI_MASK_NEG) | (j5 << 62);
            j3 = i2 << 31;
            j4 = HI_MASK;
        }
        return j2 | (j3 & j4);
    }

    public static int size(long j) {
        return (int) ((j >> 62) & 3);
    }
}
