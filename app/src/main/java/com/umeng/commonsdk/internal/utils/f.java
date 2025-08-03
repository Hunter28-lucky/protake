package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: InfoPreference.java */
/* loaded from: classes2.dex */
public class f {
    private static final String a = "info";
    private static final String b = "ua";

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(b, str).commit();
        }
    }

    public static String a(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(b, null);
        }
        return null;
    }
}
