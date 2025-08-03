package defpackage;

import android.app.Activity;

/* compiled from: SystemUiUtil.java */
/* loaded from: classes.dex */
public class y0 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m8615(Activity activity) {
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }
}
