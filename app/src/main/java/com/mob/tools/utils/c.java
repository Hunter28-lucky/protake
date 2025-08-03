package com.mob.tools.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;

@SuppressLint({"MissingPermission"})
/* loaded from: classes2.dex */
public class c {
    private static c a;

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public Location a(Context context, int i, int i2, boolean z, boolean z2) {
        return null;
    }

    public Location a(Context context, int i, int i2, boolean z) {
        return a(context, i, i2, z, false);
    }
}
