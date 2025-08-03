package defpackage;

import android.annotation.SuppressLint;
import androidx.exifinterface.media.ExifInterface;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class dc {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final /* synthetic */ boolean f6546 = true;

    /* renamed from: dc$Ϳ, reason: contains not printable characters */
    public static abstract class AbstractC1949 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public byte[] f6547;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f6548;
    }

    /* renamed from: dc$Ԩ, reason: contains not printable characters */
    public static class C1950 extends AbstractC1949 {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final int[] f6549 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: ԭ, reason: contains not printable characters */
        public static final int[] f6550 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: ԩ, reason: contains not printable characters */
        public int f6551;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public int f6552;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int[] f6553;

        public C1950(int i, byte[] bArr) {
            this.f6547 = bArr;
            this.f6553 = (i & 8) == 0 ? f6549 : f6550;
            this.f6551 = 0;
            this.f6552 = 0;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m5941(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.f6551;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.f6552;
            byte[] bArr2 = this.f6547;
            int[] iArr = this.f6553;
            int i6 = 0;
            int i7 = i5;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4 || (i7 = (iArr[bArr[i9] & ExifInterface.MARKER] << 18) | (iArr[bArr[i9 + 1] & ExifInterface.MARKER] << 12) | (iArr[bArr[i9 + 2] & ExifInterface.MARKER] << 6) | iArr[bArr[i9 + 3] & ExifInterface.MARKER]) < 0) {
                            break;
                        }
                        bArr2[i6 + 2] = (byte) i7;
                        bArr2[i6 + 1] = (byte) (i7 >> 8);
                        bArr2[i6] = (byte) (i7 >> 16);
                        i6 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bArr[i9] & ExifInterface.MARKER];
                if (i8 != 0) {
                    if (i8 == 1) {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.f6551 = 6;
                                return false;
                            }
                        }
                        i12 |= i7 << 6;
                    } else if (i8 == 2) {
                        if (i12 < 0) {
                            if (i12 == -2) {
                                bArr2[i6] = (byte) (i7 >> 4);
                                i6++;
                                i8 = 4;
                            } else if (i12 != -1) {
                                this.f6551 = 6;
                                return false;
                            }
                        }
                        i12 |= i7 << 6;
                    } else if (i8 != 3) {
                        if (i8 != 4) {
                            if (i8 == 5 && i12 != -1) {
                                this.f6551 = 6;
                                return false;
                            }
                        } else if (i12 == -2) {
                            i8++;
                        } else if (i12 != -1) {
                            this.f6551 = 6;
                            return false;
                        }
                    } else if (i12 >= 0) {
                        int i13 = i12 | (i7 << 6);
                        bArr2[i6 + 2] = (byte) i13;
                        bArr2[i6 + 1] = (byte) (i13 >> 8);
                        bArr2[i6] = (byte) (i13 >> 16);
                        i6 += 3;
                        i7 = i13;
                        i8 = 0;
                    } else if (i12 == -2) {
                        bArr2[i6 + 1] = (byte) (i7 >> 2);
                        bArr2[i6] = (byte) (i7 >> 10);
                        i6 += 2;
                        i8 = 5;
                    } else if (i12 != -1) {
                        this.f6551 = 6;
                        return false;
                    }
                    i8++;
                    i7 = i12;
                } else if (i12 >= 0) {
                    i8++;
                    i7 = i12;
                } else if (i12 != -1) {
                    this.f6551 = 6;
                    return false;
                }
                i9 = i11;
            }
            if (!z) {
                this.f6551 = i8;
                this.f6552 = i7;
                this.f6548 = i6;
                return true;
            }
            if (i8 == 1) {
                this.f6551 = 6;
                return false;
            }
            if (i8 == 2) {
                bArr2[i6] = (byte) (i7 >> 4);
                i6++;
            } else if (i8 == 3) {
                int i14 = i6 + 1;
                bArr2[i6] = (byte) (i7 >> 10);
                i6 = i14 + 1;
                bArr2[i14] = (byte) (i7 >> 2);
            } else if (i8 == 4) {
                this.f6551 = 6;
                return false;
            }
            this.f6551 = i8;
            this.f6548 = i6;
            return true;
        }
    }

    /* renamed from: dc$Ԫ, reason: contains not printable characters */
    public static class C1951 extends AbstractC1949 {

        /* renamed from: ՠ, reason: contains not printable characters */
        public static final byte[] f6554 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: ֈ, reason: contains not printable characters */
        public static final byte[] f6555 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: ֏, reason: contains not printable characters */
        public static final /* synthetic */ boolean f6556 = true;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final byte[] f6557;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public int f6558;

        /* renamed from: ԫ, reason: contains not printable characters */
        public int f6559;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final boolean f6560;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final boolean f6561;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final boolean f6562;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final byte[] f6563;

        public C1951(int i, byte[] bArr) {
            this.f6547 = bArr;
            this.f6560 = (i & 1) == 0;
            boolean z = (i & 2) == 0;
            this.f6561 = z;
            this.f6562 = (i & 4) != 0;
            this.f6563 = (i & 8) == 0 ? f6554 : f6555;
            this.f6557 = new byte[2];
            this.f6558 = 0;
            this.f6559 = z ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01be  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01cb A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:99:0x00e6 A[SYNTHETIC] */
        /* renamed from: Ϳ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean m5942(byte[] r19, int r20, int r21, boolean r22) {
            /*
                Method dump skipped, instructions count: 512
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.dc.C1951.m5942(byte[], int, int, boolean):boolean");
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static byte[] m5936(byte[] bArr, int i) {
        return m5937(bArr, 0, bArr.length, i);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static byte[] m5937(byte[] bArr, int i, int i2, int i3) {
        C1950 c1950 = new C1950(i3, new byte[(i2 * 3) / 4]);
        if (!c1950.m5941(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i4 = c1950.f6548;
        byte[] bArr2 = c1950.f6547;
        if (i4 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr3, 0, i4);
        return bArr3;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static byte[] m5938(byte[] bArr, int i) {
        return m5939(bArr, 0, bArr.length, i);
    }

    @SuppressLint({"Assert"})
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static byte[] m5939(byte[] bArr, int i, int i2, int i3) {
        C1951 c1951 = new C1951(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!c1951.f6560) {
            int i5 = i2 % 3;
            if (i5 == 1) {
                i4 += 2;
            } else if (i5 == 2) {
                i4 += 3;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (c1951.f6561 && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (c1951.f6562 ? 2 : 1);
        }
        c1951.f6547 = new byte[i4];
        c1951.m5942(bArr, i, i2, true);
        if (f6546 || c1951.f6548 == i4) {
            return c1951.f6547;
        }
        throw new AssertionError();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m5940(byte[] bArr, int i) {
        try {
            return new String(m5938(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }
}
