package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ay;
import com.xiaomi.push.dq;
import com.xiaomi.push.ih;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ax;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class ep {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private long f5861a;

    /* renamed from: a, reason: collision with other field name */
    private eo f5863a;

    /* renamed from: a, reason: collision with other field name */
    private String f5864a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f5865a = false;

    /* renamed from: a, reason: collision with other field name */
    private ay f5862a = ay.a();

    public static class a {
        public static final ep a = new ep();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static ep m5447a() {
        return a.a;
    }

    public boolean b() {
        m5448a();
        return this.f5865a && this.f5862a.m5224a() > 0;
    }

    public static eo a() {
        eo eoVar;
        ep epVar = a.a;
        synchronized (epVar) {
            eoVar = epVar.f5863a;
        }
        return eoVar;
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f5863a = new eo(xMPushService);
        this.f5864a = "";
        com.xiaomi.push.service.ax.a().a(new ax.a() { // from class: com.xiaomi.push.ep.1
            @Override // com.xiaomi.push.service.ax.a
            public void a(dq.b bVar) {
                if (bVar.m5366e()) {
                    ep.m5447a().m5451a(bVar.e());
                }
            }
        });
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5452a() {
        return this.f5865a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5451a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.a == i2 && this.f5865a) {
                return;
            }
            this.f5865a = true;
            this.f5861a = System.currentTimeMillis();
            this.a = i2;
            com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f5861a);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m5448a() {
        if (!this.f5865a || System.currentTimeMillis() - this.f5861a <= this.a) {
            return;
        }
        this.f5865a = false;
        this.f5861a = 0L;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized el m5450a() {
        el elVarA;
        elVarA = null;
        if (b()) {
            elVarA = a(av.d(this.f5863a.f5858a) ? 750 : 375);
        }
        return elVarA;
    }

    private el a(int i) {
        ArrayList arrayList = new ArrayList();
        el elVar = new el(this.f5864a, arrayList);
        if (!av.d(this.f5863a.f5858a)) {
            elVar.a(i.f(this.f5863a.f5858a));
        }
        ij ijVar = new ij(i);
        ib ibVarA = new ih.a().a(ijVar);
        try {
            elVar.b(ibVarA);
        } catch (hv unused) {
        }
        LinkedList<ay.a> linkedListM5225a = this.f5862a.m5225a();
        while (linkedListM5225a.size() > 0) {
            try {
                ek ekVarA = a(linkedListM5225a.getLast());
                if (ekVarA != null) {
                    ekVarA.b(ibVarA);
                }
                if (ijVar.a() > i) {
                    break;
                }
                if (ekVarA != null) {
                    arrayList.add(ekVarA);
                }
                linkedListM5225a.removeLast();
            } catch (hv | NoSuchElementException unused2) {
            }
        }
        return elVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized ek m5449a() {
        ek ekVar;
        ekVar = new ek();
        ekVar.a(av.m5212a((Context) this.f5863a.f5858a));
        ekVar.f5835a = (byte) 0;
        ekVar.f5839b = 1;
        ekVar.d((int) (System.currentTimeMillis() / 1000));
        return ekVar;
    }

    private ek a(ay.a aVar) {
        if (aVar.f5607a == 0) {
            Object obj = aVar.f5608a;
            if (obj instanceof ek) {
                return (ek) obj;
            }
            return null;
        }
        ek ekVarM5449a = m5449a();
        ekVarM5449a.a(ej.CHANNEL_STATS_COUNTER.a());
        ekVarM5449a.c(aVar.f5607a);
        ekVarM5449a.c(aVar.f5609a);
        return ekVarM5449a;
    }

    public synchronized void a(ek ekVar) {
        this.f5862a.a(ekVar);
    }
}
