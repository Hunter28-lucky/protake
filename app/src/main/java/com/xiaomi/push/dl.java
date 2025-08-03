package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.af;

/* loaded from: classes2.dex */
public class dl {
    private static volatile dl a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5734a;

    /* renamed from: a, reason: collision with other field name */
    private a f5735a;

    public interface a {
        void a();
    }

    private dl(Context context) {
        this.f5734a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a aVar;
        af afVarA = af.a(this.f5734a);
        com.xiaomi.push.service.ah ahVarA = com.xiaomi.push.service.ah.a(this.f5734a);
        SharedPreferences sharedPreferences = this.f5734a.getSharedPreferences("mipush_extra", 0);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", jCurrentTimeMillis);
        if (j == jCurrentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", jCurrentTimeMillis).commit();
        }
        if (Math.abs(jCurrentTimeMillis - j) < 172800000) {
            return;
        }
        a(ahVarA, afVarA, false);
        if (ahVarA.a(gl.StorageCollectionSwitch.a(), true)) {
            int iA = a(ahVarA.a(gl.StorageCollectionFrequency.a(), 86400));
            afVarA.a(new dn(this.f5734a, iA), iA, 0);
        }
        if (j.m5690a(this.f5734a) && (aVar = this.f5735a) != null) {
            aVar.a();
        }
        if (ahVarA.a(gl.ActivityTSSwitch.a(), false)) {
            a();
        }
        a(ahVarA, afVarA, true);
    }

    public static dl a(Context context) {
        if (a == null) {
            synchronized (dl.class) {
                if (a == null) {
                    a = new dl(context);
                }
            }
        }
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5335a() {
        af.a(this.f5734a).a(new Runnable() { // from class: com.xiaomi.push.dl.1
            @Override // java.lang.Runnable
            public void run() {
                dl.this.b();
            }
        });
    }

    private void a(com.xiaomi.push.service.ah ahVar, af afVar, boolean z) {
        if (ahVar.a(gl.UploadSwitch.a(), true)) {
            Cdo cdo = new Cdo(this.f5734a);
            if (z) {
                afVar.a((af.a) cdo, a(ahVar.a(gl.UploadFrequency.a(), 86400)));
            } else {
                afVar.m5195a((af.a) cdo);
            }
        }
    }

    public static int a(int i) {
        return Math.max(60, i);
    }

    private boolean a() {
        Application application;
        try {
            Context context = this.f5734a;
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                application = (Application) context.getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(new df(this.f5734a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }
}
