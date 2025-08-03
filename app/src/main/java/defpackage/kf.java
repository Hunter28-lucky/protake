package defpackage;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.alipay.a;
import org.json.alipay.b;

/* loaded from: classes.dex */
public final class kf {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static List<kg> f7827;

    static {
        ArrayList arrayList = new ArrayList();
        f7827 = arrayList;
        arrayList.add(new sg());
        f7827.add(new cf());
        f7827.add(new ae());
        f7827.add(new ig());
        f7827.add(new qg());
        f7827.add(new cd());
        f7827.add(new t9());
        f7827.add(new eg());
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <T> T m7205(Object obj, Type type) {
        T t;
        for (kg kgVar : f7827) {
            if (kgVar.mo35(u9.m8366(type)) && (t = (T) kgVar.mo36(obj, type)) != null) {
                return t;
            }
        }
        return null;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Object m7206(String str, Type type) {
        Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("[") && strTrim.endsWith("]")) {
            bVar = new a(strTrim);
        } else {
            if (!strTrim.startsWith("{") || !strTrim.endsWith("}")) {
                return m7205(strTrim, type);
            }
            bVar = new b(strTrim);
        }
        return m7205(bVar, type);
    }
}
