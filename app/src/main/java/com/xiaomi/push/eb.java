package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.xiaomi.push.ea;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
class eb implements ea.a {

    /* renamed from: a, reason: collision with other field name */
    public Context f5826a;

    /* renamed from: a, reason: collision with other field name */
    private PendingIntent f5825a = null;
    private volatile long a = 0;

    public eb(Context context) {
        this.f5826a = null;
        this.f5826a = context;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f5826a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            this.f5825a = PendingIntent.getBroadcast(this.f5826a, 0, intent, 33554432);
        } else {
            this.f5825a = PendingIntent.getBroadcast(this.f5826a, 0, intent, 0);
        }
        if (i < 31 || j.m5690a(this.f5826a)) {
            ax.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j), this.f5825a);
        } else {
            alarmManager.set(2, j, this.f5825a);
        }
        com.xiaomi.channel.commonutils.logger.b.c("[Alarm] register timer " + j);
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j), pendingIntent);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("[Alarm] invoke setExact method meet error. " + e2);
        }
    }

    @Override // com.xiaomi.push.ea.a
    public void a(boolean z) {
        long jM5789a = com.xiaomi.push.service.m.a(this.f5826a).m5789a();
        if (z || this.a != 0) {
            if (z) {
                a();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.a == 0) {
                this.a = jElapsedRealtime + (jM5789a - (jElapsedRealtime % jM5789a));
            } else if (this.a <= jElapsedRealtime) {
                this.a += jM5789a;
                if (this.a < jElapsedRealtime) {
                    this.a = jElapsedRealtime + jM5789a;
                }
            }
            Intent intent = new Intent(com.xiaomi.push.service.an.r);
            intent.setPackage(this.f5826a.getPackageName());
            a(intent, this.a);
        }
    }

    @Override // com.xiaomi.push.ea.a
    public void a() {
        if (this.f5825a != null) {
            try {
                ((AlarmManager) this.f5826a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f5825a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f5825a = null;
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
                this.a = 0L;
                throw th;
            }
            this.f5825a = null;
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
            this.a = 0L;
        }
        this.a = 0L;
    }

    @Override // com.xiaomi.push.ea.a
    /* renamed from: a */
    public boolean mo5439a() {
        return this.a != 0;
    }
}
