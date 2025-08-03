package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class ay implements aa {
    private static volatile ay a;

    /* renamed from: a, reason: collision with other field name */
    private long f6426a;

    /* renamed from: a, reason: collision with other field name */
    public Context f6427a;

    /* renamed from: a, reason: collision with other field name */
    private SharedPreferences f6428a;

    /* renamed from: a, reason: collision with other field name */
    private volatile boolean f6430a = false;

    /* renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, a> f6429a = new ConcurrentHashMap<>();

    public static abstract class a implements Runnable {
        public long a;

        /* renamed from: a, reason: collision with other field name */
        public String f6431a;

        public a(String str, long j) {
            this.f6431a = str;
            this.a = j;
        }

        public abstract void a(ay ayVar);

        @Override // java.lang.Runnable
        public void run() {
            if (ay.a != null) {
                Context context = ay.a.f6427a;
                if (com.xiaomi.push.av.c(context)) {
                    if (System.currentTimeMillis() - ay.a.f6428a.getLong(":ts-" + this.f6431a, 0L) > this.a || com.xiaomi.push.ac.a(context)) {
                        com.xiaomi.push.p.a(ay.a.f6428a.edit().putLong(":ts-" + this.f6431a, System.currentTimeMillis()));
                        a(ay.a);
                    }
                }
            }
        }
    }

    private ay(Context context) {
        this.f6427a = context.getApplicationContext();
        this.f6428a = context.getSharedPreferences("sync", 0);
    }

    public static ay a(Context context) {
        if (a == null) {
            synchronized (ay.class) {
                if (a == null) {
                    a = new ay(context);
                }
            }
        }
        return a;
    }

    @Override // com.xiaomi.push.service.aa
    /* renamed from: a, reason: collision with other method in class */
    public void mo5778a() {
        if (this.f6430a) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f6426a < 3600000) {
            return;
        }
        this.f6426a = jCurrentTimeMillis;
        this.f6430a = true;
        com.xiaomi.push.af.a(this.f6427a).a(new Runnable() { // from class: com.xiaomi.push.service.ay.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator it = ay.this.f6429a.values().iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).run();
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("Sync job exception :" + e2.getMessage());
                }
                ay.this.f6430a = false;
            }
        }, (int) (Math.random() * 10.0d));
    }

    public String a(String str, String str2) {
        return this.f6428a.getString(str + Constants.COLON_SEPARATOR + str2, "");
    }

    public void a(String str, String str2, String str3) {
        com.xiaomi.push.p.a(a.f6428a.edit().putString(str + Constants.COLON_SEPARATOR + str2, str3));
    }

    public void a(a aVar) {
        if (this.f6429a.putIfAbsent(aVar.f6431a, aVar) == null) {
            com.xiaomi.push.af.a(this.f6427a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }
}
