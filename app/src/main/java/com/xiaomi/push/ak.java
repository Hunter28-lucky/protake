package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes2.dex */
class ak implements aj, InvocationHandler {
    private static final String[][] a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: a, reason: collision with other field name */
    private Context f5579a;

    /* renamed from: a, reason: collision with other field name */
    private Class f5581a = null;
    private Class b = null;

    /* renamed from: a, reason: collision with other field name */
    private Method f5583a = null;

    /* renamed from: b, reason: collision with other field name */
    private Method f5584b = null;
    private Method c = null;
    private Method d = null;

    /* renamed from: e, reason: collision with root package name */
    private Method f17837e = null;
    private Method f = null;
    private Method g = null;

    /* renamed from: a, reason: collision with other field name */
    private final Object f5582a = new Object();

    /* renamed from: a, reason: collision with other field name */
    private volatile int f5577a = 0;

    /* renamed from: a, reason: collision with other field name */
    private volatile long f5578a = 0;

    /* renamed from: a, reason: collision with other field name */
    private volatile a f5580a = null;

    public class a {

        /* renamed from: a, reason: collision with other field name */
        public Boolean f5585a;

        /* renamed from: a, reason: collision with other field name */
        public String f5586a;
        public String b;
        public String c;
        public String d;

        private a() {
            this.f5585a = null;
            this.f5586a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }

        public boolean a() {
            if (!TextUtils.isEmpty(this.f5586a) || !TextUtils.isEmpty(this.b) || !TextUtils.isEmpty(this.c) || !TextUtils.isEmpty(this.d)) {
                this.f5585a = Boolean.TRUE;
            }
            return this.f5585a != null;
        }
    }

    public ak(Context context) {
        this.f5579a = context.getApplicationContext();
        a(context);
        b(context);
    }

    private void b(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = -jElapsedRealtime;
        Class cls = this.b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                a(this.f5583a, this.f5581a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.b}, this));
            } catch (Throwable th) {
                b("call init sdk error:" + th);
            }
        } else {
            jElapsedRealtime = j;
        }
        this.f5578a = jElapsedRealtime;
    }

    @Override // com.xiaomi.push.aj
    /* renamed from: a */
    public boolean mo5202a() {
        a("isSupported");
        return this.f5580a != null && Boolean.TRUE.equals(this.f5580a.f5585a);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f5578a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj2 = objArr[i];
                if (obj2 != null && !a(obj2)) {
                    aVar.b = (String) a(this.c, obj2, new Object[0]);
                    aVar.f5585a = (Boolean) a(this.f, obj2, new Object[0]);
                    a(this.g, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("has get succ, check duplicate:");
                        sb.append(this.f5580a != null);
                        b(sb.toString());
                        synchronized (ak.class) {
                            if (this.f5580a == null) {
                                this.f5580a = aVar;
                            }
                        }
                    }
                }
                i++;
            }
        }
        a();
        return null;
    }

    @Override // com.xiaomi.push.aj
    /* renamed from: a */
    public String mo5201a() {
        a("getOAID");
        if (this.f5580a == null) {
            return null;
        }
        return this.f5580a.b;
    }

    private void a(Context context) {
        Class<?> clsA = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i = 0;
        while (true) {
            String[][] strArr = a;
            if (i >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i];
            Class<?> clsA2 = a(context, strArr2[0]);
            Class<?> clsA3 = a(context, strArr2[1]);
            if (clsA2 != null && clsA3 != null) {
                b("found class in index " + i);
                cls2 = clsA3;
                cls = clsA2;
                break;
            }
            i++;
            cls2 = clsA3;
            cls = clsA2;
        }
        this.f5581a = clsA;
        this.f5583a = a(clsA, "InitSdk", (Class<?>[]) new Class[]{Context.class, cls});
        this.b = cls;
        this.c = a(cls2, "getOAID", (Class<?>[]) new Class[0]);
        this.f = a(cls2, "isSupported", (Class<?>[]) new Class[0]);
        this.g = a(cls2, "shutDown", (Class<?>[]) new Class[0]);
    }

    private static void b(String str) {
        com.xiaomi.channel.commonutils.logger.b.m5113a("mdid:" + str);
    }

    private void a(String str) {
        if (this.f5580a != null) {
            return;
        }
        long j = this.f5578a;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
        int i = this.f5577a;
        if (jElapsedRealtime > 3000 && i < 3) {
            synchronized (this.f5582a) {
                if (this.f5578a == j && this.f5577a == i) {
                    b("retry, current count is " + i);
                    this.f5577a = this.f5577a + 1;
                    b(this.f5579a);
                    j = this.f5578a;
                    jElapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
                }
            }
        }
        if (this.f5580a != null || j < 0 || jElapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f5582a) {
            if (this.f5580a == null) {
                try {
                    b(str + " wait...");
                    this.f5582a.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    private void a() {
        synchronized (this.f5582a) {
            try {
                this.f5582a.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    private static boolean a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    private static Class<?> a(Context context, String str) {
        try {
            return s.a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static <T> T a(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            T t = (T) method.invoke(obj, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
