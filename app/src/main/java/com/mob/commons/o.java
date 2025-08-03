package com.mob.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class o {
    private static o a;
    private HashMap<String, Object> b;

    private o() {
        HashMap<String, Object> mapC = c();
        this.b = mapC;
        if (mapC == null) {
            this.b = new HashMap<>();
        }
        ArrayList<MobProduct> arrayListB = v.b();
        if (arrayListB == null || arrayListB.isEmpty()) {
            return;
        }
        Iterator<MobProduct> it = arrayListB.iterator();
        while (it.hasNext()) {
            MobProduct next = it.next();
            if (!this.b.containsKey(next.getProductTag())) {
                this.b.put(next.getProductTag(), 0);
            }
        }
    }

    public static o a() {
        if (a == null) {
            synchronized (o.class) {
                if (a == null) {
                    a = new o();
                }
            }
        }
        return a;
    }

    private HashMap<String, Object> c() {
        try {
            return w.a().c();
        } catch (Throwable unused) {
            return null;
        }
    }

    public HashMap<String, Object> b() {
        return this.b;
    }

    public void a(MobProduct mobProduct, int i) {
        if (mobProduct != null) {
            this.b.put(mobProduct.getProductTag(), Integer.valueOf(i));
            a(this.b);
        }
    }

    private void a(HashMap<String, Object> map) {
        try {
            w.a().a(map);
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        return C5340r.a(str, 99);
    }
}
