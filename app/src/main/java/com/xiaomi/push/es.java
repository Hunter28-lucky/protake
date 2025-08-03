package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.dq;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class es {

    /* renamed from: a, reason: collision with other field name */
    public int f5868a;

    /* renamed from: a, reason: collision with other field name */
    private dq.a f5869a;

    /* renamed from: a, reason: collision with other field name */
    public String f5870a;

    /* renamed from: a, reason: collision with other field name */
    private short f5871a;

    /* renamed from: b, reason: collision with other field name */
    private final long f5872b;

    /* renamed from: b, reason: collision with other field name */
    private byte[] f5873b;
    private static String b = fy.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    private static long a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static final byte[] f5867a = new byte[0];

    public es() {
        this.f5871a = (short) 2;
        this.f5873b = f5867a;
        this.f5870a = null;
        this.f5872b = System.currentTimeMillis();
        this.f5869a = new dq.a();
        this.f5868a = 1;
    }

    public static synchronized String d() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(b);
        long j = a;
        a = 1 + j;
        sb.append(Long.toString(j));
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m5454a() {
        return this.f5872b;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m5462b() {
        return this.f5869a.m5356d();
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m5465c() {
        return this.f5869a.m5360f();
    }

    public String e() {
        String strM5358e = this.f5869a.m5358e();
        if ("ID_NOT_AVAILABLE".equals(strM5358e)) {
            return null;
        }
        if (this.f5869a.g()) {
            return strM5358e;
        }
        String strD = d();
        this.f5869a.e(strD);
        return strD;
    }

    public String f() {
        return this.f5870a;
    }

    public String g() {
        if (!this.f5869a.m5352b()) {
            return null;
        }
        return Long.toString(this.f5869a.m5346a()) + "@" + this.f5869a.m5348a() + "/" + this.f5869a.m5351b();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.aj.a(e()) + "; cmd=" + m5455a() + "; type=" + ((int) m5457a()) + "; from=" + g() + " ]";
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f5869a.c(str);
        this.f5869a.m5347a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f5869a.d(str2);
    }

    public int b() {
        return this.f5869a.f();
    }

    public void c(long j) {
        this.f5869a.c(j);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5463b() {
        return this.f5869a.l();
    }

    /* renamed from: c, reason: collision with other method in class */
    public long m5464c() {
        return this.f5869a.m5346a();
    }

    public void b(long j) {
        this.f5869a.b(j);
    }

    public void c(String str) throws NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iIndexOf = str.indexOf("@");
        try {
            long j = Long.parseLong(str.substring(0, iIndexOf));
            int iIndexOf2 = str.indexOf("/", iIndexOf);
            String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
            String strSubstring2 = str.substring(iIndexOf2 + 1);
            this.f5869a.a(j);
            this.f5869a.a(strSubstring);
            this.f5869a.b(strSubstring2);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("Blob parse user err " + e2.getMessage());
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public long m5461b() {
        return this.f5869a.m5350b();
    }

    public void b(String str) {
        this.f5870a = str;
    }

    public es(dq.a aVar, short s, byte[] bArr) {
        this.f5871a = (short) 2;
        this.f5873b = f5867a;
        this.f5870a = null;
        this.f5872b = System.currentTimeMillis();
        this.f5869a = aVar;
        this.f5871a = s;
        this.f5873b = bArr;
        this.f5868a = 2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5455a() {
        return this.f5869a.m5354c();
    }

    public void a(int i) {
        this.f5869a.a(i);
    }

    public int a() {
        return this.f5869a.c();
    }

    public void a(String str) {
        this.f5869a.e(str);
    }

    public void a(long j) {
        this.f5869a.a(j);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5458a() {
        return this.f5869a.j();
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f5869a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f5869a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f5869a.b(str2);
    }

    public int c() {
        return this.f5869a.b() + 8 + this.f5873b.length;
    }

    public void a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f5869a.c(1);
            this.f5873b = com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(str, e()), bArr);
        } else {
            this.f5869a.c(0);
            this.f5873b = bArr;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m5459a() {
        return et.a(this, this.f5873b);
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m5460a(String str) {
        if (this.f5869a.e() == 1) {
            return et.a(this, com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(str, e()), this.f5873b));
        }
        if (this.f5869a.e() == 0) {
            return et.a(this, this.f5873b);
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("unknow cipher = " + this.f5869a.e());
        return et.a(this, this.f5873b);
    }

    @Deprecated
    public static es a(fp fpVar, String str) throws NumberFormatException {
        int i;
        es esVar = new es();
        try {
            i = Integer.parseInt(fpVar.k());
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("Blob parse chid err " + e2.getMessage());
            i = 1;
        }
        esVar.a(i);
        esVar.a(fpVar.j());
        esVar.c(fpVar.m());
        esVar.b(fpVar.n());
        esVar.a("XMLMSG", (String) null);
        try {
            esVar.a(fpVar.mo5496a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                esVar.a((short) 3);
            } else {
                esVar.a((short) 2);
                esVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e3) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("Blob setPayload err： " + e3.getMessage());
        }
        return esVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo5456a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f5871a);
        byteBuffer.putShort((short) this.f5869a.a());
        byteBuffer.putInt(this.f5873b.length);
        int iPosition = byteBuffer.position();
        this.f5869a.m5436a(byteBuffer.array(), byteBuffer.arrayOffset() + iPosition, this.f5869a.a());
        byteBuffer.position(iPosition + this.f5869a.a());
        byteBuffer.put(this.f5873b);
        return byteBuffer;
    }

    public static es a(ByteBuffer byteBuffer) throws IOException {
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            short s = byteBufferSlice.getShort(0);
            short s2 = byteBufferSlice.getShort(2);
            int i = byteBufferSlice.getInt(4);
            dq.a aVar = new dq.a();
            aVar.a(byteBufferSlice.array(), byteBufferSlice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            byteBufferSlice.position(s2 + 8);
            byteBufferSlice.get(bArr, 0, i);
            return new es(aVar, s, bArr);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("read Blob err :" + e2.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public short m5457a() {
        return this.f5871a;
    }

    public void a(short s) {
        this.f5871a = s;
    }
}
