package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class r {
    private static r a;

    /* renamed from: a, reason: collision with other field name */
    private Context f6475a;

    /* renamed from: a, reason: collision with other field name */
    private List<String> f6476a = new ArrayList();
    private final List<String> b = new ArrayList();
    private final List<String> c = new ArrayList();

    private r(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f6475a = applicationContext;
        if (applicationContext == null) {
            this.f6475a = context;
        }
        SharedPreferences sharedPreferences = this.f6475a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (TextUtils.isEmpty(str)) {
                this.f6476a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str2)) {
                this.b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str3)) {
                this.c.add(str3);
            }
        }
    }

    public static r a(Context context) {
        if (a == null) {
            a = new r(context);
        }
        return a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5812b(String str) {
        boolean zContains;
        synchronized (this.b) {
            zContains = this.b.contains(str);
        }
        return zContains;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5813c(String str) {
        boolean zContains;
        synchronized (this.c) {
            zContains = this.c.contains(str);
        }
        return zContains;
    }

    public void d(String str) {
        synchronized (this.f6476a) {
            if (this.f6476a.contains(str)) {
                this.f6476a.remove(str);
                this.f6475a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bc.a(this.f6476a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.b) {
            if (this.b.contains(str)) {
                this.b.remove(str);
                this.f6475a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bc.a(this.b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                this.c.remove(str);
                this.f6475a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bc.a(this.c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5811a(String str) {
        boolean zContains;
        synchronized (this.f6476a) {
            zContains = this.f6476a.contains(str);
        }
        return zContains;
    }

    public void b(String str) {
        synchronized (this.b) {
            if (!this.b.contains(str)) {
                this.b.add(str);
                this.f6475a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bc.a(this.b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void c(String str) {
        synchronized (this.c) {
            if (!this.c.contains(str)) {
                this.c.add(str);
                this.f6475a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bc.a(this.c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void a(String str) {
        synchronized (this.f6476a) {
            if (!this.f6476a.contains(str)) {
                this.f6476a.add(str);
                this.f6475a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bc.a(this.f6476a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }
}
