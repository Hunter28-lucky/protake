package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class p {
    private static volatile p a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5535a;

    /* renamed from: a, reason: collision with other field name */
    private List<n> f5536a = new ArrayList();

    private p(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f5535a = applicationContext;
        if (applicationContext == null) {
            this.f5535a = context;
        }
    }

    public static p a(Context context) {
        if (a == null) {
            synchronized (p.class) {
                if (a == null) {
                    a = new p(context);
                }
            }
        }
        return a;
    }

    public void b(String str) {
        synchronized (this.f5536a) {
            n nVar = new n();
            nVar.f5533a = str;
            if (this.f5536a.contains(nVar)) {
                Iterator<n> it = this.f5536a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if (nVar.equals(next)) {
                        nVar = next;
                        break;
                    }
                }
            }
            nVar.a++;
            this.f5536a.remove(nVar);
            this.f5536a.add(nVar);
        }
    }

    public void c(String str) {
        synchronized (this.f5536a) {
            n nVar = new n();
            nVar.f5533a = str;
            if (this.f5536a.contains(nVar)) {
                this.f5536a.remove(nVar);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5169a(String str) {
        synchronized (this.f5536a) {
            n nVar = new n();
            nVar.a = 0;
            nVar.f5533a = str;
            if (this.f5536a.contains(nVar)) {
                this.f5536a.remove(nVar);
            }
            this.f5536a.add(nVar);
        }
    }

    public int a(String str) {
        synchronized (this.f5536a) {
            n nVar = new n();
            nVar.f5533a = str;
            if (this.f5536a.contains(nVar)) {
                for (n nVar2 : this.f5536a) {
                    if (nVar2.equals(nVar)) {
                        return nVar2.a;
                    }
                }
            }
            return 0;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5170a(String str) {
        synchronized (this.f5536a) {
            n nVar = new n();
            nVar.f5533a = str;
            return this.f5536a.contains(nVar);
        }
    }

    public synchronized String a(v vVar) {
        return this.f5535a.getSharedPreferences("mipush_extra", 0).getString(vVar.name(), "");
    }

    public synchronized void a(v vVar, String str) {
        SharedPreferences sharedPreferences = this.f5535a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(vVar.name(), str).apply();
    }
}
