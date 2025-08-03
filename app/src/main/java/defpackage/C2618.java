package defpackage;

import android.content.SharedPreferences;
import com.blink.academy.film.FilmApp;

/* compiled from: SharedPrefUtil.java */
/* renamed from: ɰ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2618 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static SharedPreferences f9728;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean m9565(String str, boolean z) {
        return m9568().getBoolean(str, z);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int m9566(String str, int i) {
        return m9568().getInt(str, i);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static Long m9567(String str, long j) {
        return Long.valueOf(m9568().getLong(str, j));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static SharedPreferences m9568() {
        if (f9728 == null) {
            f9728 = FilmApp.m402().getSharedPreferences("setting_pref", 0);
        }
        return f9728;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m9569(String str, String str2) {
        return m9568().getString(str, str2);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m9570(String str, boolean z) {
        m9568().edit().putBoolean(str, z).apply();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static void m9571(String str, int i) {
        m9568().edit().putInt(str, i).apply();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static void m9572(String str, long j) {
        m9568().edit().putLong(str, j).apply();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static void m9573(String str, String str2) {
        m9568().edit().putString(str, str2).apply();
    }
}
