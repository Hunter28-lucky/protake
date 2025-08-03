package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class b {
    private static int a = 2;

    /* renamed from: a, reason: collision with other field name */
    private static Context f5465a = null;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f5471a = false;

    /* renamed from: b, reason: collision with other field name */
    private static boolean f5472b = false;

    /* renamed from: a, reason: collision with other field name */
    private static String f5468a = "XMPush-" + Process.myPid();

    /* renamed from: a, reason: collision with other field name */
    private static LoggerInterface f5466a = new a();

    /* renamed from: a, reason: collision with other field name */
    private static final HashMap<Integer, Long> f5469a = new HashMap<>();
    private static final HashMap<Integer, String> b = new HashMap<>();

    /* renamed from: a, reason: collision with other field name */
    private static final Integer f5467a = -1;

    /* renamed from: a, reason: collision with other field name */
    private static AtomicInteger f5470a = new AtomicInteger(1);

    public static class a implements LoggerInterface {
        private String a = b.f5468a;

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.a = str;
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.a, str, th);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m5116a() {
        return false;
    }

    public static void b(String str) {
        if (m5117a(0)) {
            a(0, m5112a(str));
        }
    }

    public static void c(String str) {
        if (m5117a(0)) {
            a(1, m5112a(str));
        }
    }

    public static void d(String str) {
        if (m5117a(4)) {
            a(4, m5112a(str));
        }
    }

    public static void e(String str) {
        if (f5471a) {
            m5113a(str);
            return;
        }
        Log.w(f5468a, m5112a(str));
        if (f5472b) {
            return;
        }
        m5113a(str);
    }

    public static void a(LoggerInterface loggerInterface) {
        f5466a = loggerInterface;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m5117a(int i) {
        return i >= a || m5116a();
    }

    /* renamed from: b, reason: collision with other method in class */
    public static void m5118b(String str, String str2) {
        if (m5117a(1)) {
            a(1, b(str, str2));
        }
    }

    public static void c(String str, String str2) {
        if (m5117a(4)) {
            a(4, b(str, str2));
        }
    }

    public static void d(String str, String str2) {
        if (f5471a) {
            m5114a(str, str2);
            return;
        }
        Log.w(f5468a, b(str, str2));
        if (f5472b) {
            return;
        }
        m5114a(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m5113a(String str) {
        if (m5117a(2)) {
            a(2, m5112a(str));
        }
    }

    public static void b(String str, Object... objArr) {
        if (m5117a(1)) {
            a(1, a(str, objArr));
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m5114a(String str, String str2) {
        if (m5117a(2)) {
            a(2, b(str, str2));
        }
    }

    private static String b(String str, String str2) {
        return b() + a(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m5115a(String str, Object... objArr) {
        if (m5117a(2)) {
            a(2, a(str, objArr));
        }
    }

    private static String b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    public static void a(String str, Throwable th) {
        if (m5117a(4)) {
            a(4, m5112a(str), th);
        }
    }

    public static void a(Throwable th) {
        if (m5117a(4)) {
            a(4, th);
        }
    }

    public static Integer a(String str) {
        if (a <= 1) {
            Integer numValueOf = Integer.valueOf(f5470a.incrementAndGet());
            f5469a.put(numValueOf, Long.valueOf(System.currentTimeMillis()));
            b.put(numValueOf, str);
            f5466a.log(str + " starts");
            return numValueOf;
        }
        return f5467a;
    }

    public static void a(Integer num) {
        if (a <= 1) {
            HashMap<Integer, Long> map = f5469a;
            if (map.containsKey(num)) {
                long jLongValue = map.remove(num).longValue();
                String strRemove = b.remove(num);
                long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                f5466a.log(strRemove + " ends in " + jCurrentTimeMillis + " ms");
            }
        }
    }

    public static void a(int i, String str) {
        if (i >= a) {
            f5466a.log(str);
            return;
        }
        if (m5116a()) {
            Log.d("MyLog", "-->log(" + i + "): " + str);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= a) {
            f5466a.log("", th);
            return;
        }
        if (m5116a()) {
            Log.w("MyLog", "-->log(" + i + "): ", th);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= a) {
            f5466a.log(str, th);
            return;
        }
        if (m5116a()) {
            Log.w("MyLog", "-->log(" + i + "): " + str, th);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String m5112a(String str) {
        return b() + str;
    }

    private static String a(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[Tid:");
        sb.append(Thread.currentThread().getId());
        sb.append("] ");
        sb.append("[");
        sb.append(str);
        sb.append("] ");
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static String a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        a = i;
    }

    public static int a() {
        return a;
    }

    public static void a(Context context) {
        f5465a = context;
        if (j.m5690a(context)) {
            f5471a = true;
        }
        if (j.m5689a()) {
            f5472b = true;
        }
    }
}
