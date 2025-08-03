package com.uc.crashsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class f {
    public static final /* synthetic */ boolean a = true;
    private static volatile HandlerThread b;
    private static volatile HandlerThread c;
    private static volatile HandlerThread d;

    /* renamed from: e, reason: collision with root package name */
    private static Handler f17736e;
    private static Handler f;
    private static Handler g;
    private static Handler h;
    private static final HashMap<Object, Object[]> i = new HashMap<>();

    public static Handler a(int i2) {
        if (i2 == 0) {
            if (b == null) {
                a();
            }
            return f17736e;
        }
        if (i2 == 1) {
            if (c == null) {
                b();
            }
            return f;
        }
        if (i2 == 2) {
            if (g == null) {
                g = new Handler(Looper.getMainLooper());
            }
            return g;
        }
        if (i2 == 3) {
            if (h == null) {
                c();
            }
            return h;
        }
        throw new RuntimeException("unknown thread type: " + i2);
    }

    public static boolean b(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return false;
        }
        HashMap<Object, Object[]> map = i;
        synchronized (map) {
            objArr = map.get(runnable);
        }
        return objArr != null;
    }

    private static synchronized void c() {
        if (d == null) {
            HandlerThread handlerThread = new HandlerThread("CrashSDKAnrHandler", 0);
            d = handlerThread;
            handlerThread.start();
            h = new Handler(d.getLooper());
        }
    }

    private static synchronized void b() {
        if (c == null) {
            HandlerThread handlerThread = new HandlerThread("CrashSDKNormalHandler", 0);
            c = handlerThread;
            handlerThread.start();
            f = new Handler(c.getLooper());
        }
    }

    public static boolean a(int i2, Runnable runnable, long j) {
        Handler handlerA;
        if (runnable == null || (handlerA = a(i2)) == null) {
            return false;
        }
        e eVar = new e(10, new Object[]{runnable});
        HashMap<Object, Object[]> map = i;
        synchronized (map) {
            map.put(runnable, new Object[]{eVar, Integer.valueOf(i2)});
        }
        return handlerA.postDelayed(eVar, j);
    }

    public static void a(int i2, Object[] objArr) {
        if (i2 != 10) {
            if (!a) {
                throw new AssertionError();
            }
        } else {
            if (!a && objArr == null) {
                throw new AssertionError();
            }
            Runnable runnable = (Runnable) objArr[0];
            HashMap<Object, Object[]> map = i;
            synchronized (map) {
                if (map.get(runnable) != null) {
                    map.remove(runnable);
                }
            }
            runnable.run();
        }
    }

    public static boolean a(int i2, Runnable runnable) {
        return a(i2, runnable, 0L);
    }

    public static void a(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return;
        }
        HashMap<Object, Object[]> map = i;
        synchronized (map) {
            objArr = map.get(runnable);
        }
        if (objArr == null) {
            return;
        }
        int iIntValue = ((Integer) objArr[1]).intValue();
        Handler handler = null;
        if (iIntValue == 0) {
            handler = f17736e;
        } else if (iIntValue == 1) {
            handler = f;
        } else if (iIntValue == 2) {
            handler = g;
        }
        if (handler != null) {
            handler.removeCallbacks((Runnable) objArr[0]);
        }
        synchronized (map) {
            if (map.get(runnable) != null) {
                map.remove(runnable);
            }
        }
    }

    private static synchronized void a() {
        if (b == null) {
            HandlerThread handlerThread = new HandlerThread("CrashSDKBkgdHandler", 10);
            b = handlerThread;
            handlerThread.start();
            f17736e = new Handler(b.getLooper());
        }
    }
}
