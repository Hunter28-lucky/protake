package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class af {
    private static volatile af a;

    /* renamed from: a, reason: collision with other field name */
    private SharedPreferences f5558a;

    /* renamed from: a, reason: collision with other field name */
    private ScheduledThreadPoolExecutor f5561a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: a, reason: collision with other field name */
    private Map<String, ScheduledFuture> f5560a = new HashMap();

    /* renamed from: a, reason: collision with other field name */
    private Object f5559a = new Object();

    public static abstract class a implements Runnable {
        /* renamed from: a */
        public abstract String mo5248a();
    }

    public static class b implements Runnable {
        public a a;

        public b(a aVar) {
            this.a = aVar;
        }

        public void a() {
        }

        public void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.a.run();
            b();
        }
    }

    private af(Context context) {
        this.f5558a = context.getSharedPreferences("mipush_extra", 0);
    }

    public boolean b(a aVar, int i) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> scheduledFutureSchedule = this.f5561a.schedule(new b(aVar) { // from class: com.xiaomi.push.af.2
            @Override // com.xiaomi.push.af.b
            public void b() {
                synchronized (af.this.f5559a) {
                    af.this.f5560a.remove(super.a.mo5248a());
                }
            }
        }, i, TimeUnit.SECONDS);
        synchronized (this.f5559a) {
            this.f5560a.put(aVar.mo5248a(), scheduledFutureSchedule);
        }
        return true;
    }

    public static af a(Context context) {
        if (a == null) {
            synchronized (af.class) {
                if (a == null) {
                    a = new af(context);
                }
            }
        }
        return a;
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        return a(aVar, i, i2, false);
    }

    public boolean a(a aVar, int i, int i2, final boolean z) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        final String strA = a(aVar.mo5248a());
        b bVar = new b(aVar) { // from class: com.xiaomi.push.af.1
            @Override // com.xiaomi.push.af.b
            public void a() {
                super.a();
            }

            @Override // com.xiaomi.push.af.b
            public void b() {
                if (z) {
                    return;
                }
                af.this.f5558a.edit().putLong(strA, System.currentTimeMillis()).commit();
            }
        };
        if (!z) {
            long jAbs = Math.abs(System.currentTimeMillis() - this.f5558a.getLong(strA, 0L)) / 1000;
            if (jAbs < i - i2) {
                i2 = (int) (i - jAbs);
            }
        }
        try {
            ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = this.f5561a.scheduleAtFixedRate(bVar, i2, i, TimeUnit.SECONDS);
            synchronized (this.f5559a) {
                this.f5560a.put(aVar.mo5248a(), scheduledFutureScheduleAtFixedRate);
            }
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return true;
        }
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f5561a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5195a(a aVar) {
        return b(aVar, 0);
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f5559a) {
            scheduledFuture = this.f5560a.get(aVar.mo5248a());
        }
        return scheduledFuture;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5196a(String str) {
        synchronized (this.f5559a) {
            ScheduledFuture scheduledFuture = this.f5560a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f5560a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    private static String a(String str) {
        return "last_job_time" + str;
    }
}
