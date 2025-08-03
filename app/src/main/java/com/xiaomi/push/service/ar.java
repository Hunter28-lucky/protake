package com.xiaomi.push.service;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class ar {
    private static int a = 8;
    private int d = -666;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f6416a = new byte[256];
    private int c = 0;
    private int b = 0;

    public static int a(byte b) {
        return b >= 0 ? b : b + 256;
    }

    private void a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i2 = 0; i2 < 256; i2++) {
            this.f6416a[i2] = (byte) i2;
        }
        this.c = 0;
        this.b = 0;
        while (true) {
            int i3 = this.b;
            if (i3 >= i) {
                break;
            }
            int iA = ((this.c + a(this.f6416a[i3])) + a(bArr[this.b % length])) % 256;
            this.c = iA;
            a(this.f6416a, this.b, iA);
            this.b++;
        }
        if (i != 256) {
            this.d = ((this.c + a(this.f6416a[i])) + a(bArr[i % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_");
            int i4 = i - 1;
            sb.append(i4);
            sb.append(Constants.COLON_SEPARATOR);
            for (int i5 = 0; i5 <= i; i5++) {
                sb.append(MyUTIL.white_space);
                sb.append(a(this.f6416a[i5]));
            }
            sb.append("   j_");
            sb.append(i4);
            sb.append("=");
            sb.append(this.c);
            sb.append("   j_");
            sb.append(i);
            sb.append("=");
            sb.append(this.d);
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i4);
            sb.append("]=");
            sb.append(a(this.f6416a[this.c]));
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i);
            sb.append("]=");
            sb.append(a(this.f6416a[this.d]));
            if (this.f6416a[1] != 0) {
                sb.append("   S[1]!=0");
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a(sb.toString());
        }
    }

    private void a(byte[] bArr) {
        a(256, bArr, false);
    }

    private void a() {
        this.c = 0;
        this.b = 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte m5768a() {
        int i = (this.b + 1) % 256;
        this.b = i;
        int iA = (this.c + a(this.f6416a[i])) % 256;
        this.c = iA;
        a(this.f6416a, this.b, iA);
        byte[] bArr = this.f6416a;
        return bArr[(a(bArr[this.b]) + a(this.f6416a[this.c])) % 256];
    }

    private static void a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        ar arVar = new ar();
        arVar.a(bArr);
        arVar.a();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ arVar.m5768a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i, int i2) {
        byte[] bArr3;
        int i3;
        if (i >= 0 && i <= bArr2.length && i + i2 <= bArr2.length) {
            if (z) {
                bArr3 = bArr2;
                i3 = i;
            } else {
                bArr3 = new byte[i2];
                i3 = 0;
            }
            ar arVar = new ar();
            arVar.a(bArr);
            arVar.a();
            for (int i4 = 0; i4 < i2; i4++) {
                bArr3[i3 + i4] = (byte) (bArr2[i + i4] ^ arVar.m5768a());
            }
            return bArr3;
        }
        throw new IllegalArgumentException("start = " + i + " len = " + i2);
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, com.xiaomi.push.az.m5226a(str));
    }

    public static byte[] a(String str, String str2) {
        byte[] bArrM5226a = com.xiaomi.push.az.m5226a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[bArrM5226a.length + 1 + bytes.length];
        for (int i = 0; i < bArrM5226a.length; i++) {
            bArr[i] = bArrM5226a[i];
        }
        bArr[bArrM5226a.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[bArrM5226a.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }
}
