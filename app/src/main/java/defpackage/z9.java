package defpackage;

import android.content.Context;
import defpackage.s9;

/* loaded from: classes.dex */
public class z9 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean m8661() {
        if (r9.f8474) {
            return r9.f8475;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m8662(Context context) {
        if (r9.f8474) {
            return s9.C2262.f8516.m8215(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m8663(Context context) {
        r9.f8475 = s9.C2262.f8516.m8216(context.getApplicationContext());
        r9.f8474 = true;
    }
}
