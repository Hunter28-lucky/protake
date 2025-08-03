package com.xiaomi.push;

import androidx.exifinterface.media.ExifInterface;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class hx extends ib {
    private static final ig a = new ig();

    /* renamed from: a, reason: collision with other field name */
    public int f6297a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f6298a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f6299a;
    public boolean b;

    /* renamed from: b, reason: collision with other field name */
    private byte[] f6300b;
    public boolean c;

    /* renamed from: c, reason: collision with other field name */
    private byte[] f6301c;
    private byte[] d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f17895e;
    private byte[] f;
    private byte[] g;
    private byte[] h;

    public static class a implements id {
        public int a;

        /* renamed from: a, reason: collision with other field name */
        public boolean f6302a;
        public boolean b;

        public a() {
            this(false, true);
        }

        @Override // com.xiaomi.push.id
        public ib a(il ilVar) {
            hx hxVar = new hx(ilVar, this.f6302a, this.b);
            int i = this.a;
            if (i != 0) {
                hxVar.b(i);
            }
            return hxVar;
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f6302a = z;
            this.b = z2;
            this.a = i;
        }
    }

    public hx(il ilVar, boolean z, boolean z2) {
        super(ilVar);
        this.c = false;
        this.f6299a = new byte[1];
        this.f6300b = new byte[2];
        this.f6301c = new byte[4];
        this.d = new byte[8];
        this.f17895e = new byte[1];
        this.f = new byte[2];
        this.g = new byte[4];
        this.h = new byte[8];
        this.f6298a = z;
        this.b = z2;
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public void mo5675a() {
    }

    @Override // com.xiaomi.push.ib
    public void a(hy hyVar) {
        a(hyVar.a);
        a(hyVar.f6304a);
    }

    @Override // com.xiaomi.push.ib
    public void a(ig igVar) {
    }

    @Override // com.xiaomi.push.ib
    public void b() {
    }

    public void b(int i) {
        this.f6297a = i;
        this.c = true;
    }

    @Override // com.xiaomi.push.ib
    public void c() {
        a((byte) 0);
    }

    @Override // com.xiaomi.push.ib
    public void d() {
    }

    @Override // com.xiaomi.push.ib
    public void e() {
    }

    @Override // com.xiaomi.push.ib
    public void f() {
    }

    @Override // com.xiaomi.push.ib
    public void g() {
    }

    @Override // com.xiaomi.push.ib
    public void h() {
    }

    @Override // com.xiaomi.push.ib
    public void i() {
    }

    @Override // com.xiaomi.push.ib
    public void j() {
    }

    public void c(int i) throws hv {
        if (i < 0) {
            throw new hv("Negative length: " + i);
        }
        if (this.c) {
            int i2 = this.f6297a - i;
            this.f6297a = i2;
            if (i2 >= 0) {
                return;
            }
            throw new hv("Message length exceeded: " + i);
        }
    }

    @Override // com.xiaomi.push.ib
    public void a(ia iaVar) {
        a(iaVar.a);
        a(iaVar.b);
        mo5676a(iaVar.f6308a);
    }

    @Override // com.xiaomi.push.ib
    public void a(hz hzVar) {
        a(hzVar.a);
        mo5676a(hzVar.f6305a);
    }

    @Override // com.xiaomi.push.ib
    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.ib
    public void a(byte b) {
        byte[] bArr = this.f6299a;
        bArr[0] = b;
        ((ib) this).a.mo5685a(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.ib
    public void a(short s) {
        byte[] bArr = this.f6300b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        ((ib) this).a.mo5685a(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public void mo5676a(int i) {
        byte[] bArr = this.f6301c;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        ((ib) this).a.mo5685a(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.ib
    public void a(long j) {
        byte[] bArr = this.d;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        ((ib) this).a.mo5685a(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.ib
    public void a(String str) throws hv, UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes(Platform.UTF_8);
            mo5676a(bytes.length);
            ((ib) this).a.mo5685a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new hv("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ib
    public void a(ByteBuffer byteBuffer) {
        int iLimit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo5676a(iLimit);
        ((ib) this).a.mo5685a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), iLimit);
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public ig mo5671a() {
        return a;
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public hy mo5667a() throws hv {
        byte bA = a();
        return new hy("", bA, bA == 0 ? (short) 0 : mo5674a());
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public ia mo5669a() {
        return new ia(a(), a(), mo5665a());
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public hz mo5668a() {
        return new hz(a(), mo5665a());
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public Cif mo5670a() {
        return new Cif(a(), mo5665a());
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo5677a() {
        return a() == 1;
    }

    @Override // com.xiaomi.push.ib
    public byte a() throws hv {
        if (((ib) this).a.b() >= 1) {
            byte b = ((ib) this).a.a()[((ib) this).a.a_()];
            ((ib) this).a.a(1);
            return b;
        }
        a(this.f17895e, 0, 1);
        return this.f17895e[0];
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public short mo5674a() throws hv {
        byte[] bArrA = this.f;
        int iA_ = 0;
        if (((ib) this).a.b() >= 2) {
            bArrA = ((ib) this).a.a();
            iA_ = ((ib) this).a.a_();
            ((ib) this).a.a(2);
        } else {
            a(this.f, 0, 2);
        }
        return (short) ((bArrA[iA_ + 1] & ExifInterface.MARKER) | ((bArrA[iA_] & ExifInterface.MARKER) << 8));
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public int mo5665a() throws hv {
        byte[] bArrA = this.g;
        int iA_ = 0;
        if (((ib) this).a.b() >= 4) {
            bArrA = ((ib) this).a.a();
            iA_ = ((ib) this).a.a_();
            ((ib) this).a.a(4);
        } else {
            a(this.g, 0, 4);
        }
        return (bArrA[iA_ + 3] & ExifInterface.MARKER) | ((bArrA[iA_] & ExifInterface.MARKER) << 24) | ((bArrA[iA_ + 1] & ExifInterface.MARKER) << 16) | ((bArrA[iA_ + 2] & ExifInterface.MARKER) << 8);
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public long mo5666a() throws hv {
        byte[] bArrA = this.h;
        int iA_ = 0;
        if (((ib) this).a.b() >= 8) {
            bArrA = ((ib) this).a.a();
            iA_ = ((ib) this).a.a_();
            ((ib) this).a.a(8);
        } else {
            a(this.h, 0, 8);
        }
        return (bArrA[iA_ + 7] & ExifInterface.MARKER) | ((bArrA[iA_] & ExifInterface.MARKER) << 56) | ((bArrA[iA_ + 1] & ExifInterface.MARKER) << 48) | ((bArrA[iA_ + 2] & ExifInterface.MARKER) << 40) | ((bArrA[iA_ + 3] & ExifInterface.MARKER) << 32) | ((bArrA[iA_ + 4] & ExifInterface.MARKER) << 24) | ((bArrA[iA_ + 5] & ExifInterface.MARKER) << 16) | ((bArrA[iA_ + 6] & ExifInterface.MARKER) << 8);
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public double mo5664a() {
        return Double.longBitsToDouble(mo5666a());
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public String mo5672a() throws hv {
        int iMo5665a = mo5665a();
        if (((ib) this).a.b() >= iMo5665a) {
            try {
                String str = new String(((ib) this).a.a(), ((ib) this).a.a_(), iMo5665a, Platform.UTF_8);
                ((ib) this).a.a(iMo5665a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new hv("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return a(iMo5665a);
    }

    public String a(int i) throws hv {
        try {
            c(i);
            byte[] bArr = new byte[i];
            ((ib) this).a.b(bArr, 0, i);
            return new String(bArr, Platform.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            throw new hv("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ib
    /* renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo5673a() throws hv {
        int iMo5665a = mo5665a();
        c(iMo5665a);
        if (((ib) this).a.b() >= iMo5665a) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(((ib) this).a.a(), ((ib) this).a.a_(), iMo5665a);
            ((ib) this).a.a(iMo5665a);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iMo5665a];
        ((ib) this).a.b(bArr, 0, iMo5665a);
        return ByteBuffer.wrap(bArr);
    }

    private int a(byte[] bArr, int i, int i2) throws hv {
        c(i2);
        return ((ib) this).a.b(bArr, i, i2);
    }
}
