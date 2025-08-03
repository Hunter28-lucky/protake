package com.xiaomi.push;

/* loaded from: classes2.dex */
public class dh {
    private static volatile dh a;

    /* renamed from: a, reason: collision with other field name */
    private dg f5732a;

    public static dh a() {
        if (a == null) {
            synchronized (dh.class) {
                if (a == null) {
                    a = new dh();
                }
            }
        }
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public dg m5334a() {
        return this.f5732a;
    }

    public void a(dg dgVar) {
        this.f5732a = dgVar;
    }
}
