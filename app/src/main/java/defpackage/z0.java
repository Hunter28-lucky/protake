package defpackage;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

/* compiled from: SystemUtil.java */
/* loaded from: classes.dex */
public class z0 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int f8770;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m8635(Activity activity) {
        m8636(activity, f8770);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m8636(Activity activity, int i) {
        try {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            f8770 = i;
            if (i == 1) {
                attributes.screenBrightness = 1.0f;
                window.setAttributes(attributes);
            } else {
                attributes.screenBrightness = -1.0f;
                window.setAttributes(attributes);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static int m8637() {
        return f8770;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m8638(int i) {
        f8770 = i;
    }
}
