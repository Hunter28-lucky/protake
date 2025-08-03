package defpackage;

import android.content.Context;

/* loaded from: classes.dex */
public final class eb {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static eb f6610 = new eb();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static eb m6000() {
        return f6610;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m6001(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception unused) {
            return "0.0.0";
        }
    }
}
