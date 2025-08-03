package com.xiaomi.push;

import com.xiaomi.push.hx;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class ih extends hx {
    private static int b = 10000;
    private static int c = 10000;
    private static int d = 10000;

    /* renamed from: e, reason: collision with root package name */
    private static int f17897e = 10485760;
    private static int f = 104857600;

    public static class a extends hx.a {
        public a() {
            super(false, true);
        }

        @Override // com.xiaomi.push.hx.a, com.xiaomi.push.id
        public ib a(il ilVar) {
            ih ihVar = new ih(ilVar, ((hx.a) this).f6302a, this.b);
            int i = ((hx.a) this).a;
            if (i != 0) {
                ihVar.b(i);
            }
            return ihVar;
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }
    }

    public ih(il ilVar, boolean z, boolean z2) {
        super(ilVar, z, z2);
    }

    @Override // com.xiaomi.push.hx, com.xiaomi.push.ib
    /* renamed from: a */
    public ia mo5669a() throws hv {
        byte bA = a();
        byte bA2 = a();
        int iMo5665a = mo5665a();
        if (iMo5665a <= b) {
            return new ia(bA, bA2, iMo5665a);
        }
        throw new ic(3, "Thrift map size " + iMo5665a + " out of range!");
    }

    @Override // com.xiaomi.push.hx, com.xiaomi.push.ib
    /* renamed from: a */
    public hz mo5668a() throws hv {
        byte bA = a();
        int iMo5665a = mo5665a();
        if (iMo5665a <= c) {
            return new hz(bA, iMo5665a);
        }
        throw new ic(3, "Thrift list size " + iMo5665a + " out of range!");
    }

    @Override // com.xiaomi.push.hx, com.xiaomi.push.ib
    /* renamed from: a */
    public Cif mo5670a() throws hv {
        byte bA = a();
        int iMo5665a = mo5665a();
        if (iMo5665a <= d) {
            return new Cif(bA, iMo5665a);
        }
        throw new ic(3, "Thrift set size " + iMo5665a + " out of range!");
    }

    @Override // com.xiaomi.push.hx, com.xiaomi.push.ib
    /* renamed from: a */
    public String mo5672a() throws hv {
        int iMo5665a = mo5665a();
        if (iMo5665a <= f17897e) {
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
        throw new ic(3, "Thrift string size " + iMo5665a + " out of range!");
    }

    @Override // com.xiaomi.push.hx, com.xiaomi.push.ib
    /* renamed from: a */
    public ByteBuffer mo5673a() throws hv {
        int iMo5665a = mo5665a();
        if (iMo5665a <= f) {
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
        throw new ic(3, "Thrift binary size " + iMo5665a + " out of range!");
    }
}
