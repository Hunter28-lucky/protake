package defpackage;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class ye {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static synchronized void m8632(Context context, String str, String str2, String str3) {
        if (!ua.m8370(str)) {
            if (!ua.m8370(str2) && context != null) {
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
}
