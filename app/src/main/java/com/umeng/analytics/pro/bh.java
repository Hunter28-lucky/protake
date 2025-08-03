package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FieldMetaData.java */
/* loaded from: classes2.dex */
public class bh implements Serializable {
    private static Map<Class<? extends av>, Map<? extends bc, bh>> d = new HashMap();
    public final String a;
    public final byte b;
    public final bi c;

    public bh(String str, byte b, bi biVar) {
        this.a = str;
        this.b = b;
        this.c = biVar;
    }

    public static void a(Class<? extends av> cls, Map<? extends bc, bh> map) {
        d.put(cls, map);
    }

    public static Map<? extends bc, bh> a(Class<? extends av> cls) throws IllegalAccessException, InstantiationException {
        if (!d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            } catch (InstantiationException e3) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e3.getMessage());
            }
        }
        return d.get(cls);
    }
}
