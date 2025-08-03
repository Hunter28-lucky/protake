package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class fb {
    private static final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: a, reason: collision with other field name */
    public static boolean f5900a;

    /* renamed from: a, reason: collision with other field name */
    public fc f5903a;

    /* renamed from: a, reason: collision with other field name */
    public XMPushService f5905a;

    /* renamed from: a, reason: collision with other field name */
    public int f5901a = 0;

    /* renamed from: a, reason: collision with other field name */
    public long f5902a = -1;

    /* renamed from: b, reason: collision with other field name */
    public volatile long f5910b = 0;

    /* renamed from: c, reason: collision with other field name */
    public volatile long f5913c = 0;

    /* renamed from: a, reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f5908a = new LinkedList<>();

    /* renamed from: a, reason: collision with other field name */
    private final Collection<fe> f5907a = new CopyOnWriteArrayList();

    /* renamed from: a, reason: collision with other field name */
    public final Map<fg, a> f5909a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with other field name */
    public final Map<fg, a> f5912b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with other field name */
    public fk f5904a = null;

    /* renamed from: a, reason: collision with other field name */
    public String f5906a = "";

    /* renamed from: b, reason: collision with other field name */
    public String f5911b = "";
    private int c = 2;
    public final int b = a.getAndIncrement();

    /* renamed from: e, reason: collision with root package name */
    private long f17860e = 0;
    public long d = 0;

    static {
        f5900a = false;
        try {
            f5900a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        fh.m5488a();
    }

    public fb(XMPushService xMPushService, fc fcVar) throws ClassNotFoundException {
        this.f5903a = fcVar;
        this.f5905a = xMPushService;
        m5482b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? NetworkUtil.NETWORK_CLASS_DISCONNECTED : "unknown";
    }

    /* renamed from: a, reason: collision with other method in class */
    public fc m5478a() {
        return this.f5903a;
    }

    public abstract void a(fp fpVar);

    public abstract void a(am.b bVar);

    public abstract void a(String str, String str2);

    public abstract void a(es[] esVarArr);

    /* renamed from: a */
    public boolean mo5472a() {
        return false;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m5481b() {
        return this.f5903a.b();
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(es esVar);

    public abstract void b(boolean z);

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5484c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f5908a) {
            this.f5908a.clear();
        }
    }

    public static class a {
        private fg a;

        /* renamed from: a, reason: collision with other field name */
        private fl f5914a;

        public a(fg fgVar, fl flVar) {
            this.a = fgVar;
            this.f5914a = flVar;
        }

        public void a(fp fpVar) {
            fl flVar = this.f5914a;
            if (flVar == null || flVar.mo5305a(fpVar)) {
                this.a.a(fpVar);
            }
        }

        public void a(es esVar) {
            this.a.a(esVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public String mo5479a() {
        return this.f5903a.c();
    }

    public void b(fe feVar) {
        this.f5907a.remove(feVar);
    }

    public synchronized void c() {
        this.f17860e = SystemClock.elapsedRealtime();
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m5477a() {
        return this.f5913c;
    }

    public void b(fg fgVar, fl flVar) {
        if (fgVar != null) {
            this.f5912b.put(fgVar, new a(fgVar, flVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public void a(fe feVar) {
        if (feVar == null || this.f5907a.contains(feVar)) {
            return;
        }
        this.f5907a.add(feVar);
    }

    public void a(fg fgVar, fl flVar) {
        if (fgVar != null) {
            this.f5909a.put(fgVar, new a(fgVar, flVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public void b(fg fgVar) {
        this.f5912b.remove(fgVar);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m5482b() throws ClassNotFoundException {
        String property;
        if (this.f5903a.m5486a() && this.f5904a == null) {
            Class<?> cls = null;
            try {
                property = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                property = null;
            }
            if (property != null) {
                try {
                    cls = Class.forName(property);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (cls == null) {
                this.f5904a = new fa(this);
                return;
            }
            try {
                this.f5904a = (fk) cls.getConstructor(fb.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e3) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e3);
            }
        }
    }

    public void a(fg fgVar) {
        this.f5909a.remove(fgVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<fg, a> m5480a() {
        return this.f5909a;
    }

    public int a() {
        return this.f5901a;
    }

    public void a(int i, int i2, Exception exc) {
        int i3 = this.c;
        if (i != i3) {
            com.xiaomi.channel.commonutils.logger.b.m5113a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i3), a(i), com.xiaomi.push.service.an.a(i2)));
        }
        if (av.m5216a((Context) this.f5905a)) {
            m5476a(i);
        }
        if (i == 1) {
            this.f5905a.a(10);
            if (this.c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("try set connected while not connecting.");
            }
            this.c = i;
            Iterator<fe> it = this.f5907a.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            return;
        }
        if (i == 0) {
            if (this.c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("try set connecting while not disconnected.");
            }
            this.c = i;
            Iterator<fe> it2 = this.f5907a.iterator();
            while (it2.hasNext()) {
                it2.next().a(this);
            }
            return;
        }
        if (i == 2) {
            this.f5905a.a(10);
            int i4 = this.c;
            if (i4 == 0) {
                Iterator<fe> it3 = this.f5907a.iterator();
                while (it3.hasNext()) {
                    it3.next().a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                Iterator<fe> it4 = this.f5907a.iterator();
                while (it4.hasNext()) {
                    it4.next().a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5483b() {
        return this.c == 0;
    }

    public int b() {
        return this.c;
    }

    public synchronized void a(String str) {
        if (this.c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("setChallenge hash = " + bb.a(str).substring(0, 8));
            this.f5906a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m5113a("ignore setChallenge because connection was disconnected");
        }
    }

    public synchronized boolean a(long j) {
        return this.f17860e >= j;
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m5476a(int i) {
        synchronized (this.f5908a) {
            if (i == 1) {
                this.f5908a.clear();
            } else {
                this.f5908a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f5908a.size() > 6) {
                    this.f5908a.remove(0);
                }
            }
        }
    }
}
