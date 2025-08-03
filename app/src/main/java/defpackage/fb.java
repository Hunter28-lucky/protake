package defpackage;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes.dex */
public class fb {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m6065(Context context, String str, String str2) {
        String strM8239;
        synchronized (fb.class) {
            String strM7560 = null;
            if (context != null) {
                try {
                    if (!ua.m8370(str) && !ua.m8370(str2)) {
                        try {
                            strM8239 = sf.m8239(context, str, str2, "");
                        } catch (Throwable unused) {
                        }
                        if (ua.m8370(strM8239)) {
                            return null;
                        }
                        strM7560 = md.m7560(md.m7556(), strM8239);
                        return strM7560;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m6066(Context context, String str, String str2, String str3) {
        synchronized (fb.class) {
            if (ua.m8370(str) || ua.m8370(str2) || context == null) {
                return;
            }
            try {
                String strM7557 = md.m7557(md.m7556(), str3);
                HashMap map = new HashMap();
                map.put(str2, strM7557);
                sf.m8240(context, str, map);
            } catch (Throwable unused) {
            }
        }
    }
}
