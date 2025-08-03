package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.dq;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* loaded from: classes2.dex */
public class ev {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private ez f5880a;

    /* renamed from: a, reason: collision with other field name */
    private OutputStream f5881a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f5884a;
    private int b;

    /* renamed from: a, reason: collision with other field name */
    public ByteBuffer f5882a = ByteBuffer.allocate(2048);

    /* renamed from: b, reason: collision with other field name */
    private ByteBuffer f5885b = ByteBuffer.allocate(4);

    /* renamed from: a, reason: collision with other field name */
    private Adler32 f5883a = new Adler32();

    public ev(OutputStream outputStream, ez ezVar) {
        this.f5881a = new BufferedOutputStream(outputStream);
        this.f5880a = ezVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(es esVar) throws IOException {
        int iC = esVar.c();
        if (iC > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("Blob size=" + iC + " should be less than 32768 Drop blob chid=" + esVar.a() + " id=" + esVar.e());
            return 0;
        }
        this.f5882a.clear();
        int i = iC + 8 + 4;
        if (i > this.f5882a.capacity() || this.f5882a.capacity() > 4096) {
            this.f5882a = ByteBuffer.allocate(i);
        }
        this.f5882a.putShort((short) -15618);
        this.f5882a.putShort((short) 5);
        this.f5882a.putInt(iC);
        int iPosition = this.f5882a.position();
        this.f5882a = esVar.mo5456a(this.f5882a);
        if (!"CONN".equals(esVar.m5455a())) {
            if (this.f5884a == null) {
                this.f5884a = this.f5880a.m5473a();
            }
            com.xiaomi.push.service.ar.a(this.f5884a, this.f5882a.array(), true, iPosition, iC);
        }
        this.f5883a.reset();
        this.f5883a.update(this.f5882a.array(), 0, this.f5882a.position());
        this.f5885b.putInt(0, (int) this.f5883a.getValue());
        this.f5881a.write(this.f5882a.array(), 0, this.f5882a.position());
        this.f5881a.write(this.f5885b.array(), 0, 4);
        this.f5881a.flush();
        int iPosition2 = this.f5882a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + esVar.m5455a() + ";chid=" + esVar.a() + ";len=" + iPosition2 + "}");
        return iPosition2;
    }

    public void b() throws IOException {
        es esVar = new es();
        esVar.a("CLOSE", (String) null);
        a(esVar);
        this.f5881a.close();
    }

    public void a() throws IOException {
        dq.e eVar = new dq.e();
        eVar.a(106);
        eVar.a(k.a());
        eVar.b(s.m5703a());
        eVar.c(com.xiaomi.push.service.ax.m5771a());
        eVar.b(48);
        eVar.d(this.f5880a.m5481b());
        eVar.e(this.f5880a.mo5479a());
        eVar.f(Locale.getDefault().toString());
        int i = Build.VERSION.SDK_INT;
        eVar.c(i);
        eVar.d(g.a(this.f5880a.a(), "com.xiaomi.xmsf"));
        byte[] bArrMo5487a = this.f5880a.m5478a().mo5487a();
        if (bArrMo5487a != null) {
            eVar.a(dq.b.a(bArrMo5487a));
        }
        es esVar = new es();
        esVar.a(0);
        esVar.a("CONN", (String) null);
        esVar.a(0L, "xiaomi.com", null);
        esVar.a(eVar.m5437a(), (String) null);
        a(esVar);
        com.xiaomi.channel.commonutils.logger.b.m5113a("[slim] open conn: andver=" + i + " sdk=48 tz=" + this.a + Constants.COLON_SEPARATOR + this.b + " Model=" + k.a() + " os=" + j.e());
    }
}
