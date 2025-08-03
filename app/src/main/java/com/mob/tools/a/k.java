package com.mob.tools.a;

import android.content.Context;

/* loaded from: classes2.dex */
public class k {
    private static k a = new k();
    private volatile Context b;
    private volatile j c;
    private volatile j d;

    public static k a(Context context) {
        if (a.b == null && context != null) {
            a.b = context.getApplicationContext();
        }
        return a;
    }

    public j b() {
        if (this.d == null) {
            this.d = new e(this.b);
        }
        return this.d;
    }

    public void a(j jVar) {
        this.c = jVar;
    }

    public j a() {
        if (this.c == null) {
            return b();
        }
        return this.c;
    }
}
