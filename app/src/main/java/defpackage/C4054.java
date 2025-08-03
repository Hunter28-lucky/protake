package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.blink.academy.film.FilmApp;

/* compiled from: ScoreUtils.java */
/* renamed from: ऒ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4054 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C4054 f14073;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C4054 m12975() {
        if (f14073 == null) {
            synchronized (C4054.class) {
                if (f14073 == null) {
                    f14073 = new C4054();
                }
            }
        }
        return f14073;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean m12976(Context context) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("market://details?id=android.browser"));
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() != 0;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m12977(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && m12976(FilmApp.m402())) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
                if (!TextUtils.isEmpty(str2)) {
                    intent.setPackage(str2);
                }
                intent.addFlags(268435456);
                FilmApp.m402().startActivity(intent);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
