package com.mob.commons.a;

import com.mob.commons.g;
import com.mob.commons.n;
import com.mob.commons.u;
import com.mob.tools.MobLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    private static final WeakHashMap<String, Object> g = new WeakHashMap<>();
    public Object a;
    private final String c;
    private final String d;

    /* renamed from: e, reason: collision with root package name */
    private final long f17665e;
    private final long f;
    public int b = 0;
    private int h = 2;
    private boolean i = false;

    /* renamed from: com.mob.commons.a.a$a, reason: collision with other inner class name */
    public static class C1886a {
        private static WeakHashMap<Integer, a> a = new WeakHashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        public static synchronized void c(a aVar) {
            a.put(Integer.valueOf(aVar.getClass().getName().hashCode()), aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static synchronized void d(a aVar) {
            a.remove(Integer.valueOf(aVar.getClass().getName().hashCode()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static synchronized a b(Class<? extends a> cls) {
            return a.get(Integer.valueOf(cls.getName().hashCode()));
        }
    }

    public a(String str, long j, String str2, long j2) {
        this.c = str;
        this.d = str2;
        this.f17665e = j;
        this.f = j2;
    }

    public static a a(Class<? extends a> cls) {
        a aVarB = C1886a.b(cls);
        if (aVarB != null) {
            return aVarB;
        }
        try {
            return cls.newInstance();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return aVarB;
        }
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return ((Long) com.mob.commons.b.a(this.c, Long.valueOf(this.f17665e))).longValue() != 0 && l();
    }

    public boolean d() {
        return this.b == 0;
    }

    public boolean e() {
        return f();
    }

    public boolean f() {
        if (!c()) {
            return false;
        }
        u.c.execute(this);
        return true;
    }

    public boolean g() {
        boolean zA = com.mob.commons.b.a();
        boolean zB = com.mob.commons.b.b();
        if (!zA || !zB) {
            MobLog.getInstance().d("run clt: " + b() + ", to: " + zA + ", conn: " + zB, new Object[0]);
            return false;
        }
        boolean zC = c();
        MobLog.getInstance().d("run clt: " + getClass().getSimpleName() + ", to: " + zA + ", conn: " + zB + ", " + this.c + ": " + zC + ", key: " + a(this.c, (String) 0) + ", gp: " + k(), new Object[0]);
        return zC;
    }

    public abstract void h();

    public void i() {
        long jK = k();
        if (jK <= 0 || jK >= 604800) {
            return;
        }
        a(jK);
    }

    public void j() {
    }

    public long k() {
        try {
            String str = this.d;
            if (str != null) {
                return Long.parseLong(String.valueOf(com.mob.commons.b.a(str, Long.valueOf(this.f))));
            }
            return 0L;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return 0L;
        }
    }

    public final boolean l() {
        if ("bs,l,ol,wi,wl,ext,aa,".contains(this.c + Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            return g.a().b();
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                if (g()) {
                    if (!com.mob.commons.b.d()) {
                        a(60000L);
                        try {
                            j();
                            return;
                        } catch (Throwable th) {
                            MobLog.getInstance().d(th);
                            return;
                        }
                    }
                    h();
                    if (this.i) {
                        C1886a.c(this);
                    } else {
                        C1886a.d(this);
                    }
                    i();
                }
                j();
            } catch (Throwable th2) {
                try {
                    MobLog.getInstance().d(th2);
                    j();
                } catch (Throwable th3) {
                    try {
                        j();
                    } catch (Throwable th4) {
                        MobLog.getInstance().d(th4);
                    }
                    throw th3;
                }
            }
        } catch (Throwable th5) {
            MobLog.getInstance().d(th5);
        }
    }

    public void a() {
        this.i = true;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(long j) {
        a(j, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(long j, Object obj) {
        d.a().a(j, getClass(), new Object[]{Integer.valueOf(this.b + 1), obj}, this.h);
    }

    public <T> T a(String str, T t) {
        return (T) com.mob.commons.b.a(str, t);
    }

    public void a(com.mob.tools.utils.b<HashMap<String, Object>> bVar) {
        bVar.a(null);
    }

    public void a(String str, HashMap<String, Object> map) {
        a(str, map, false);
    }

    public void a(String str, HashMap<String, Object> map, boolean z) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final HashMap<String, Object> map2 = new HashMap<>();
        map2.put(n.b("004cIchFdh"), str);
        if (map != null) {
            map2.put(n.b("004gUce,c$ce"), map);
        }
        map2.put(n.b("008g=ceOchcRcd!kh"), Long.valueOf(jCurrentTimeMillis));
        if (z) {
            a(new com.mob.tools.utils.b<HashMap<String, Object>>() { // from class: com.mob.commons.a.a.1
                @Override // com.mob.tools.utils.b
                public void a(HashMap<String, Object> map3) {
                    map2.put(n.b("002<cfdc"), map3);
                    com.mob.commons.d.a().a(jCurrentTimeMillis, map2);
                }
            });
        } else {
            com.mob.commons.d.a().a(jCurrentTimeMillis, map2);
        }
    }
}
