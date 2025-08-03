package defpackage;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/* compiled from: InputMethodManagerUtil.java */
/* renamed from: च, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4066 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m13001(Activity activity) {
        if (activity == null || !m13002(activity) || activity.getCurrentFocus() == null || activity.getCurrentFocus().getWindowToken() == null) {
            return;
        }
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m13002(Activity activity) {
        return activity != null && ((InputMethodManager) activity.getSystemService("input_method")).isActive();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m13003(Context context) {
        ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(0, 2);
    }
}
