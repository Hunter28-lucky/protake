package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* loaded from: classes.dex */
public final class s {
    public static Boolean a;

    public static final boolean a(Context context) {
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean boolValueOf = Boolean.valueOf((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0);
            a = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
