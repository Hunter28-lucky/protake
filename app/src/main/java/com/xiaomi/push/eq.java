package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.en;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class eq {
    private static final int a = ej.PING_RTT.a();

    /* renamed from: a, reason: collision with other field name */
    private static long f5866a = 0;

    public static class a {
        public static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a(String str, Exception exc) {
        try {
            en.a aVarB = en.b(exc);
            ek ekVarM5449a = ep.m5447a().m5449a();
            ekVarM5449a.a(aVarB.a.a());
            ekVarM5449a.c(aVarB.f5855a);
            ekVarM5449a.b(str);
            if (ep.a() != null && ep.a().f5858a != null) {
                ekVarM5449a.c(av.b(ep.a().f5858a) ? 1 : 0);
            }
            ep.m5447a().a(ekVarM5449a);
        } catch (NullPointerException unused) {
        }
    }

    public static void b(String str, Exception exc) {
        try {
            en.a aVarD = en.d(exc);
            ek ekVarM5449a = ep.m5447a().m5449a();
            ekVarM5449a.a(aVarD.a.a());
            ekVarM5449a.c(aVarD.f5855a);
            ekVarM5449a.b(str);
            if (ep.a() != null && ep.a().f5858a != null) {
                ekVarM5449a.c(av.b(ep.a().f5858a) ? 1 : 0);
            }
            ep.m5447a().a(ekVarM5449a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, int i, Exception exc) {
        ek ekVarM5449a = ep.m5447a().m5449a();
        if (ep.a() != null && ep.a().f5858a != null) {
            ekVarM5449a.c(av.b(ep.a().f5858a) ? 1 : 0);
        }
        if (i > 0) {
            ekVarM5449a.a(ej.GSLB_REQUEST_SUCCESS.a());
            ekVarM5449a.b(str);
            ekVarM5449a.b(i);
            ep.m5447a().a(ekVarM5449a);
            return;
        }
        try {
            en.a aVarA = en.a(exc);
            ekVarM5449a.a(aVarA.a.a());
            ekVarM5449a.c(aVarA.f5855a);
            ekVarM5449a.b(str);
            ep.m5447a().a(ekVarM5449a);
        } catch (NullPointerException unused) {
        }
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void a(XMPushService xMPushService, am.b bVar) {
        new em(xMPushService, bVar).a();
    }

    public static synchronized void a(int i, int i2) {
        if (i2 < 16777215) {
            a.a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
        }
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i4 = (i << 24) | i2;
        if (a.a.containsKey(Integer.valueOf(i4))) {
            ek ekVarM5449a = ep.m5447a().m5449a();
            ekVarM5449a.a(i2);
            ekVarM5449a.b((int) (jCurrentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
            ekVarM5449a.b(str);
            if (i3 > -1) {
                ekVarM5449a.c(i3);
            }
            ep.m5447a().a(ekVarM5449a);
            a.a.remove(Integer.valueOf(i2));
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
        }
    }

    public static void a() {
        if (f5866a == 0 || SystemClock.elapsedRealtime() - f5866a > 7200000) {
            f5866a = SystemClock.elapsedRealtime();
            a(0, a);
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        ek ekVarM5449a = ep.m5447a().m5449a();
        ekVarM5449a.a((byte) i);
        ekVarM5449a.a(i2);
        ekVarM5449a.b(i3);
        ekVarM5449a.b(str);
        ekVarM5449a.c(i4);
        ep.m5447a().a(ekVarM5449a);
    }

    public static void a(int i) {
        ek ekVarM5449a = ep.m5447a().m5449a();
        ekVarM5449a.a(ej.CHANNEL_STATS_COUNTER.a());
        ekVarM5449a.c(i);
        ep.m5447a().a(ekVarM5449a);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static byte[] m5453a() {
        el elVarM5450a = ep.m5447a().m5450a();
        if (elVarM5450a != null) {
            return hq.a(elVarM5450a);
        }
        return null;
    }
}
