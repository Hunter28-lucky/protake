package com.mob.pushsdk.impl;

import android.text.TextUtils;
import com.mob.pushsdk.b.k;
import com.mob.pushsdk.base.PLog;
import java.util.HashSet;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class i {
    private static i a;
    private HashSet<String> b = new HashSet<>();
    private Object c = new Object();
    private Object d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private volatile String f17696e;
    private Timer f;
    private TimerTask g;

    private i() {
        c();
    }

    public static i a() {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new i();
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        try {
            if (TextUtils.isEmpty(this.f17696e)) {
                this.f17696e = com.mob.pushsdk.plugins.b.b().getName().toLowerCase(Locale.ROOT);
            }
            return !TextUtils.isEmpty(this.f17696e);
        } catch (Exception e2) {
            PLog.getInstance().e(e2);
            return false;
        }
    }

    private void c() {
        com.mob.pushsdk.b.k.b(new k.a() { // from class: com.mob.pushsdk.impl.i.1
            @Override // com.mob.pushsdk.b.k.a
            public void a() {
                if (!i.this.b()) {
                    PLog.getInstance().d("failed to get Manufacturer channel", new Object[0]);
                    return;
                }
                synchronized (i.this.c) {
                    HashSet<String> hashSetA = com.mob.pushsdk.biz.c.a().a(i.this.f17696e);
                    if (hashSetA != null && !hashSetA.isEmpty()) {
                        i.this.b.addAll(hashSetA);
                    }
                }
                i.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.mob.pushsdk.b.k.b(new k.a() { // from class: com.mob.pushsdk.impl.i.2
            @Override // com.mob.pushsdk.b.k.a
            public void a() {
                synchronized (i.this.c) {
                    if (com.mob.pushsdk.b.b.a(i.this.b)) {
                        return;
                    }
                    final HashSet hashSet = (HashSet) i.this.b.clone();
                    if (com.mob.pushsdk.b.b.a(hashSet)) {
                        return;
                    }
                    com.mob.pushsdk.biz.e.c((String[]) hashSet.toArray(new String[0]), i.this.f17696e, new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.i.2.1
                        @Override // com.mob.pushsdk.biz.b
                        public void a(int i, Throwable th) {
                            super.a(i, th);
                            i.this.e();
                        }

                        @Override // com.mob.pushsdk.biz.b
                        public void b(Object obj) {
                            super.b(obj);
                            synchronized (i.this.c) {
                                i.this.b.removeAll(hashSet);
                                com.mob.pushsdk.biz.c.a().a(i.this.f17696e, i.this.b);
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            synchronized (this.d) {
                if (this.f == null) {
                    this.f = new Timer();
                }
                if (this.g == null) {
                    this.g = new n() { // from class: com.mob.pushsdk.impl.i.3
                        @Override // com.mob.pushsdk.impl.n
                        public void a() {
                            synchronized (i.this.d) {
                                i.this.f();
                            }
                            i.this.d();
                        }
                    };
                }
                this.f.schedule(this.g, 30000L);
            }
        } catch (Exception e2) {
            PLog.getInstance().e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        TimerTask timerTask;
        synchronized (this.d) {
            try {
                Timer timer = this.f;
                if (timer != null) {
                    timer.cancel();
                    this.f = null;
                }
                timerTask = this.g;
            } catch (Exception e2) {
                PLog.getInstance().e(e2);
            }
            if (timerTask != null) {
                timerTask.cancel();
                this.g = null;
            }
        }
    }

    public void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.mob.pushsdk.b.k.b(new k.a() { // from class: com.mob.pushsdk.impl.i.4
            @Override // com.mob.pushsdk.b.k.a
            public void a() {
                if (!i.this.b()) {
                    PLog.getInstance().d("failed to get Manufacturer channel", new Object[0]);
                    return;
                }
                synchronized (i.this.c) {
                    if (i.this.b.contains(str)) {
                        return;
                    }
                    i.this.b.add(str);
                    com.mob.pushsdk.biz.c.a().a(i.this.f17696e, i.this.b);
                    i.this.f();
                    i.this.d();
                }
            }
        });
    }
}
