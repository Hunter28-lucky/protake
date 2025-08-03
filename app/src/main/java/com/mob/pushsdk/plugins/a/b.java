package com.mob.pushsdk.plugins.a;

/* loaded from: classes2.dex */
public class b {
    private String a;
    private int b;
    private com.mob.pushsdk.plugins.b c = new com.mob.pushsdk.plugins.b();

    public void a(String str) {
        this.a = str;
    }

    public void b() {
        this.b = 3002;
        this.c.a(this.a);
    }

    public void c() {
        this.b = 3004;
        this.c.b(this.a);
    }

    public void d() {
        this.b = 3005;
        this.c.c(this.a);
    }

    public void e() {
        this.b = 3007;
        this.c.d(this.a);
    }

    public void f() {
        this.b = 3008;
        this.c.e(this.a);
    }

    public int a() {
        return this.b;
    }
}
