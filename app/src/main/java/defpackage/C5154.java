package defpackage;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: Base64.java */
/* renamed from: ၜ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C5154 {

    /* compiled from: Base64.java */
    /* renamed from: ၜ$Ԩ, reason: contains not printable characters */
    public static abstract class AbstractC5156 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public byte[] f17086;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f17087;
    }

    /* compiled from: Base64.java */
    /* renamed from: ၜ$Ԫ, reason: contains not printable characters */
    public static class C5157 extends AbstractC5156 {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final int[] f17088 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: ԭ, reason: contains not printable characters */
        public static final int[] f17089 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: ԩ, reason: contains not printable characters */
        public int f17090;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public int f17091;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int[] f17092;

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m15078(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.f17090;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.f17091;
            byte[] bArr2 = this.f17086;
            int[] iArr = this.f17092;
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
                                this.f17090 = 6;
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
                                this.f17090 = 6;
                                return false;
                            }
                        }
                        i12 |= i7 << 6;
                    } else if (i8 != 3) {
                        if (i8 != 4) {
                            if (i8 == 5 && i12 != -1) {
                                this.f17090 = 6;
                                return false;
                            }
                        } else if (i12 == -2) {
                            i8++;
                        } else if (i12 != -1) {
                            this.f17090 = 6;
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
                        this.f17090 = 6;
                        return false;
                    }
                    i8++;
                    i7 = i12;
                } else if (i12 >= 0) {
                    i8++;
                    i7 = i12;
                } else if (i12 != -1) {
                    this.f17090 = 6;
                    return false;
                }
                i9 = i11;
            }
            if (!z) {
                this.f17090 = i8;
                this.f17091 = i7;
                this.f17087 = i6;
                return true;
            }
            if (i8 == 1) {
                this.f17090 = 6;
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
                this.f17090 = 6;
                return false;
            }
            this.f17090 = i8;
            this.f17087 = i6;
            return true;
        }

        public C5157(int i, byte[] bArr) {
            this.f17086 = bArr;
            this.f17092 = (i & 8) == 0 ? f17088 : f17089;
            this.f17090 = 0;
            this.f17091 = 0;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static byte[] m15075(String str, int i) {
        return m15076(str.getBytes(), i);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static byte[] m15076(byte[] bArr, int i) {
        return m15077(bArr, 0, bArr.length, i);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static byte[] m15077(byte[] bArr, int i, int i2, int i3) {
        C5157 c5157 = new C5157(i3, new byte[(i2 * 3) / 4]);
        if (!c5157.m15078(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i4 = c5157.f17087;
        byte[] bArr2 = c5157.f17086;
        if (i4 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr3, 0, i4);
        return bArr3;
    }
}
