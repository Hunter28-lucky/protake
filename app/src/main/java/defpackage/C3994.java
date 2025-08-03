package defpackage;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.C2138;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: AndroidLog.kt */
/* renamed from: ࢶ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3994 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Map<String, String> f13946;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final C3994 f13947 = new C3994();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final CopyOnWriteArraySet<Logger> f13945 = new CopyOnWriteArraySet<>();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r1 = C5121.class.getPackage();
        String name = r1 != null ? r1.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = C5121.class.getName();
        C3921.m12663(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = C3700.class.getName();
        C3921.m12663(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = m1.class.getName();
        C3921.m12663(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        f13946 = C2138.m7240(linkedHashMap);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m12858(String str, int i, String str2, Throwable th) {
        int iMin;
        C3921.m12667(str, "loggerName");
        C3921.m12667(str2, "message");
        String strM12861 = m12861(str);
        if (Log.isLoggable(strM12861, i)) {
            if (th != null) {
                str2 = str2 + "\n" + Log.getStackTraceString(th);
            }
            int i2 = 0;
            int length = str2.length();
            while (i2 < length) {
                int iM7285 = StringsKt__StringsKt.m7285(str2, '\n', i2, false, 4, null);
                if (iM7285 == -1) {
                    iM7285 = length;
                }
                while (true) {
                    iMin = Math.min(iM7285, i2 + 4000);
                    String strSubstring = str2.substring(i2, iMin);
                    C3921.m12663(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i, strM12861, strSubstring);
                    if (iMin >= iM7285) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m12859() {
        for (Map.Entry<String, String> entry : f13946.entrySet()) {
            m12860(entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m12860(String str, String str2) throws SecurityException {
        Logger logger = Logger.getLogger(str);
        if (f13945.add(logger)) {
            C3921.m12663(logger, "logger");
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(C3995.f13948);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String m12861(String str) {
        String str2 = f13946.get(str);
        return str2 != null ? str2 : g0.m6072(str, 23);
    }
}
