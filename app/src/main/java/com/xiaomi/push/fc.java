package com.xiaomi.push;

import java.util.Map;

/* loaded from: classes2.dex */
public class fc implements Cloneable {
    public static String a = "wcc-ml-test10.bj";
    public static String b;

    /* renamed from: a, reason: collision with other field name */
    private int f5915a;

    /* renamed from: a, reason: collision with other field name */
    private ff f5916a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f5917a = fb.f5900a;

    /* renamed from: b, reason: collision with other field name */
    private boolean f5918b = true;
    private String c;
    private String d;

    /* renamed from: e, reason: collision with root package name */
    private String f17861e;

    public fc(Map<String, Integer> map, int i, String str, ff ffVar) {
        a(map, i, str, ffVar);
    }

    public static final String a() {
        String str = b;
        return str != null ? str : y.m5832a() ? "sandbox.xmpush.xiaomi.com" : y.b() ? "10.38.162.35" : "app.chat.xiaomi.net";
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] mo5487a() {
        return null;
    }

    public void b(String str) {
        this.f17861e = str;
    }

    public String c() {
        if (this.d == null) {
            this.d = a();
        }
        return this.d;
    }

    public String b() {
        return this.f17861e;
    }

    public static final void a(String str) {
        if (y.b()) {
            return;
        }
        b = str;
    }

    public void c(String str) {
        this.d = str;
    }

    private void a(Map<String, Integer> map, int i, String str, ff ffVar) {
        this.f5915a = i;
        this.c = str;
        this.f5916a = ffVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m5485a() {
        return this.f5915a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5486a() {
        return this.f5917a;
    }

    public void a(boolean z) {
        this.f5917a = z;
    }
}
