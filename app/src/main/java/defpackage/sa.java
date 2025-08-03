package defpackage;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class sa {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static ConcurrentHashMap<Integer, Pair<Long, ?>> f8517;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static ExecutorService f8518 = Executors.newFixedThreadPool(16);

    /* renamed from: sa$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2263<T, R> {
        R a(T t);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static Context m8218(Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Pair<Boolean, ?> m8219(int i, TimeUnit timeUnit, long j) {
        ConcurrentHashMap<Integer, Pair<Long, ?>> concurrentHashMap = f8517;
        if (concurrentHashMap == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Pair<Long, ?> pair = concurrentHashMap.get(Integer.valueOf(i));
        if (pair == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Long l = (Long) pair.first;
        return (l == null || SystemClock.elapsedRealtime() - l.longValue() > TimeUnit.MILLISECONDS.convert(j, timeUnit)) ? new Pair<>(Boolean.FALSE, null) : new Pair<>(Boolean.TRUE, pair.second);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T> T m8220(int i, long j, TimeUnit timeUnit, InterfaceC2263<Object, Boolean> interfaceC2263, Callable<T> callable, boolean z, long j2, TimeUnit timeUnit2, pa paVar, boolean z2) {
        T tCall;
        try {
            Pair<Boolean, ?> pairM8219 = m8219(i, timeUnit, j);
            if (((Boolean) pairM8219.first).booleanValue() && interfaceC2263.a(pairM8219.second).booleanValue()) {
                hf.m6209("getC", i + " got " + pairM8219.second);
                return (T) pairM8219.second;
            }
            if (z2 && ug.m8449()) {
                q9.m8091(paVar, "biz", "ch_get_main", "" + i);
                hf.m6209("getC", i + " skip");
                tCall = null;
            } else {
                tCall = z ? f8518.submit(callable).get(j2, timeUnit2) : callable.call();
                m8221(i, tCall);
            }
            hf.m6209("getC", i + " new " + tCall);
            return tCall;
        } catch (Throwable th) {
            hf.m6204("CDT", "ch_get_e|" + i, th);
            q9.m8087(paVar, "biz", "ch_get_e|" + i, th);
            hf.m6209("getC", i + " err");
            return null;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static synchronized void m8221(int i, Object obj) {
        if (f8517 == null) {
            f8517 = new ConcurrentHashMap<>();
        }
        f8517.put(Integer.valueOf(i), new Pair<>(Long.valueOf(SystemClock.elapsedRealtime()), obj));
    }
}
