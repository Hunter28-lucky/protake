package com.blink.academy.film.zxing.camera;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public enum FrontLightMode {
    ON,
    AUTO,
    OFF;

    public static FrontLightMode readPref(SharedPreferences sharedPreferences) {
        return m4772(sharedPreferences.getString("preferences_front_light_mode", OFF.toString()));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static FrontLightMode m4772(String str) {
        return str == null ? OFF : valueOf(str);
    }
}
