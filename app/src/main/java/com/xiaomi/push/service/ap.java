package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.mob.pushsdk.MobPush;

/* loaded from: classes2.dex */
public class ap {
    private static ap a;

    /* renamed from: a, reason: collision with other field name */
    private int f6414a = 0;

    /* renamed from: a, reason: collision with other field name */
    private Context f6415a;

    private ap(Context context) {
        this.f6415a = context.getApplicationContext();
    }

    public static ap a(Context context) {
        if (a == null) {
            a = new ap(context);
        }
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5767a() {
        String str = com.xiaomi.push.y.f6514a;
        return str.contains("xmsf") || str.contains(MobPush.Channels.XIAOMI) || str.contains("miui");
    }

    @SuppressLint({"NewApi"})
    public int a() {
        int i = this.f6414a;
        if (i != 0) {
            return i;
        }
        try {
            this.f6414a = Settings.Global.getInt(this.f6415a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f6414a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a, reason: collision with other method in class */
    public Uri m5766a() {
        return Settings.Global.getUriFor("device_provisioned");
    }
}
