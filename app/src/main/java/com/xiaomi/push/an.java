package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes2.dex */
class an {
    public static int a;

    public static aj a(Context context) {
        if (j.m5689a()) {
            a = 1;
            return new am(context);
        }
        if (ai.a(context)) {
            a = 2;
            return new ai(context);
        }
        if (ap.a(context)) {
            a = 4;
            return new ap(context);
        }
        if (ar.a(context)) {
            a = 5;
            return new ar(context);
        }
        if (al.a(context)) {
            a = 3;
            return new ak(context);
        }
        a = 0;
        return new aq();
    }
}
