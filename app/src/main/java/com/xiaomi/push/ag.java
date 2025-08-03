package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ag {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f5564a;

    /* renamed from: a, reason: collision with other field name */
    private a f5565a;

    /* renamed from: a, reason: collision with other field name */
    private volatile b f5566a;

    /* renamed from: a, reason: collision with other field name */
    private volatile boolean f5567a;
    private final boolean b;

    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        /* renamed from: c */
        public void mo5330c() {
        }
    }

    public ag() {
        this(false);
    }

    public class a extends Thread {

        /* renamed from: a, reason: collision with other field name */
        private final LinkedBlockingQueue<b> f5569a;

        public a() {
            super("PackageProcessor");
            this.f5569a = new LinkedBlockingQueue<>();
        }

        public void a(b bVar) {
            try {
                this.f5569a.add(bVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            long j = ag.this.a > 0 ? ag.this.a : Long.MAX_VALUE;
            while (!ag.this.f5567a) {
                try {
                    b bVarPoll = this.f5569a.poll(j, TimeUnit.SECONDS);
                    ag.this.f5566a = bVarPoll;
                    if (bVarPoll != null) {
                        a(0, bVarPoll);
                        bVarPoll.b();
                        a(1, bVarPoll);
                    } else if (ag.this.a > 0) {
                        ag.this.a();
                    }
                } catch (InterruptedException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
        }

        private void a(int i, b bVar) {
            try {
                ag.this.f5564a.sendMessage(ag.this.f5564a.obtainMessage(i, bVar));
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    public ag(boolean z) {
        this(z, 0);
    }

    public ag(boolean z, int i) {
        this.f5564a = null;
        this.f5567a = false;
        this.a = 0;
        this.f5564a = new Handler(Looper.getMainLooper()) { // from class: com.xiaomi.push.ag.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                b bVar = (b) message.obj;
                int i2 = message.what;
                if (i2 == 0) {
                    bVar.a();
                } else if (i2 == 1) {
                    bVar.mo5330c();
                }
                super.handleMessage(message);
            }
        };
        this.b = z;
        this.a = i;
    }

    public synchronized void a(b bVar) {
        if (this.f5565a == null) {
            a aVar = new a();
            this.f5565a = aVar;
            aVar.setDaemon(this.b);
            this.f5567a = false;
            this.f5565a.start();
        }
        this.f5565a.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f5565a = null;
        this.f5567a = true;
    }

    public void a(final b bVar, long j) {
        this.f5564a.postDelayed(new Runnable() { // from class: com.xiaomi.push.ag.2
            @Override // java.lang.Runnable
            public void run() {
                ag.this.a(bVar);
            }
        }, j);
    }
}
