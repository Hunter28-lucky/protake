package defpackage;

import android.util.Log;

/* loaded from: classes2.dex */
public class qd {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String f8455 = "MCS";

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean f8456 = false;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean f8457 = false;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean f8458 = true;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean f8459 = true;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean f8460 = true;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String f8461 = "-->";

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static boolean f8462 = true;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m8124(String str) {
        if (f8458 && f8462) {
            Log.d("mcssdk---", f8455 + f8461 + str);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m8125(String str) {
        if (f8460 && f8462) {
            Log.e("mcssdk---", f8455 + f8461 + str);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m8126(String str, String str2) {
        if (f8460 && f8462) {
            Log.e(str, f8455 + f8461 + str2);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m8127(boolean z) {
        f8462 = z;
        boolean z2 = z;
        f8456 = z2;
        f8458 = z2;
        f8457 = z2;
        f8459 = z2;
        f8460 = z2;
    }
}
