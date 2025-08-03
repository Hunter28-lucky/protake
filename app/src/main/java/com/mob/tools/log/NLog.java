package com.mob.tools.log;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.mob.commons.m;
import com.mob.commons.n;
import com.mob.tools.b;
import com.mob.tools.proguard.ClassKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class NLog implements ClassKeeper, PublicMemberKeeper {
    private static final HashMap<String, NLog> a = new HashMap<>();
    private static final HashMap<String, String> b = new HashMap<>();
    private String c;
    private int d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f17718e;

    static {
        b.a();
    }

    public NLog() {
        this.f17718e = false;
        this.c = null;
        this.d = -1;
    }

    private String a(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Throwable th2) {
            return th2 instanceof OutOfMemoryError ? n.b("0235ee hc$dgGc*cecfcidhcgcecfDh dg^c,cgcdcjeehbdbdbMk") : th2.getMessage();
        }
    }

    private String b(Throwable th) {
        try {
            String name = th.getClass().getName();
            String strC = c(th);
            String string = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
            Throwable cause = th;
            while (cause != null && cause.getCause() != null) {
                cause = cause.getCause();
            }
            if (cause == null || cause == th) {
                return a(th);
            }
            return name + Constants.COLON_SEPARATOR + strC + "\n" + string + "\n......\nCaused by:\n" + a(cause);
        } catch (Throwable unused) {
            return a(th);
        }
    }

    private static String c(Throwable th) {
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, cut!]";
    }

    public static NLog getInstance(String str, int i, String str2) {
        NLog nLog;
        HashMap<String, NLog> map = a;
        synchronized (map) {
            nLog = map.get(str);
            if (nLog == null) {
                nLog = new NLog(str, i);
                b.put(str, str2);
                map.put(str, nLog);
            }
        }
        return nLog;
    }

    public static NLog getInstanceForSDK(String str, boolean z) {
        return getInstance(str);
    }

    public static void setCollector(String str, LogCollector logCollector) {
        getInstance(str).setCollector(logCollector);
    }

    public final void crash(Throwable th) {
        a(6, 1, b(th));
    }

    public final int d(Throwable th) {
        return log(3, th);
    }

    public final void dg() {
        this.f17718e = true;
    }

    public final int e(Throwable th) {
        return log(6, th);
    }

    public final void error(Throwable th) {
        error(a(th));
    }

    public final int i(Throwable th) {
        return log(4, th);
    }

    public final int log(int i, Throwable th) {
        return a(i, 0, a(th));
    }

    public NLog setCollector(LogCollector logCollector) {
        return this;
    }

    public final int v(Throwable th) {
        return log(2, th);
    }

    public final int w(Throwable th) {
        return log(5, th);
    }

    public final int d(Object obj, Object... objArr) {
        return log(3, obj, objArr);
    }

    public final int e(Throwable th, Object obj, Object... objArr) {
        return log(6, th, obj, objArr);
    }

    public final void error(String str) {
        a(6, 2, str);
    }

    public final int i(Throwable th, Object obj, Object... objArr) {
        return log(4, th, obj, objArr);
    }

    public final int log(int i, Object obj, Object... objArr) {
        String string = obj.toString();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        return a(i, 0, string);
    }

    public final int v(Object obj, Object... objArr) {
        return log(2, obj, objArr);
    }

    public final int w(Object obj, Object... objArr) {
        return log(5, obj, objArr);
    }

    public final int d(Throwable th, Object obj, Object... objArr) {
        return log(3, th, obj, objArr);
    }

    public final int e(Object obj, Object... objArr) {
        return log(6, obj, objArr);
    }

    public final int i(Object obj, Object... objArr) {
        return log(4, obj, objArr);
    }

    public final int v(Throwable th, Object obj, Object... objArr) {
        return log(2, th, obj, objArr);
    }

    public final int w(Throwable th, Object obj, Object... objArr) {
        return log(5, th, obj, objArr);
    }

    public final int e(String str) {
        return log(6, str, new Object[0]);
    }

    public final int i(String str) {
        return log(4, str, new Object[0]);
    }

    public final int w(String str) {
        return log(5, str, new Object[0]);
    }

    private NLog(String str, int i) {
        this.f17718e = false;
        this.c = str;
        this.d = i;
    }

    private int a(int i, int i2, String str) {
        String str2;
        try {
            str2 = Process.myPid() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myTid() + "(" + Thread.currentThread().getName() + ") " + str;
        } catch (Throwable unused) {
            str2 = str;
        }
        try {
            if (i2 == 1) {
                String str3 = this.c;
                int i3 = this.d;
                HashMap<String, String> map = b;
                if (!map.isEmpty()) {
                    NLog nLog = null;
                    Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, String> next = it.next();
                        if (next.getValue() != null && str.contains(next.getValue())) {
                            nLog = a.get(next.getKey());
                            break;
                        }
                    }
                    if (nLog != null) {
                        str3 = nLog.c;
                        i3 = nLog.d;
                    }
                }
                m.a().a(1, str3, i3, str2);
            } else if (i2 == 2) {
                m.a().a(2, this.c, this.d, str2);
            }
            m.a().a(i, str2);
            return 0;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public final int log(int i, Throwable th, Object obj, Object... objArr) {
        String string = obj.toString();
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            string = String.format(string, objArr);
        }
        sb.append(string);
        sb.append('\n');
        sb.append(a(th));
        return a(i, 0, sb.toString());
    }

    @Deprecated
    public static NLog getInstance(String str) {
        NLog nLog;
        HashMap<String, NLog> map = a;
        synchronized (map) {
            nLog = map.get(str);
            if (nLog == null) {
                nLog = new NLog(str, -1);
                b.put(str, null);
                map.put(str, nLog);
            }
        }
        return nLog;
    }
}
