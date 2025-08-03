package com.alipay.sdk.m.x;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public abstract class c extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Activity f285;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final String f286;

    public c(Activity activity, String str) {
        super(activity);
        this.f285 = activity;
        this.f286 = str;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static void m345(WebView webView) {
        if (webView != null) {
            try {
                webView.resumeTimers();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m346(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        CookieSyncManager.createInstance(this.f285.getApplicationContext()).sync();
        CookieManager.getInstance().setCookie(str, str2);
        CookieSyncManager.getInstance().sync();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean m347() {
        return "v1".equals(this.f286);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public abstract boolean mo348();

    /* renamed from: ؠ, reason: contains not printable characters */
    public abstract void mo349();
}
