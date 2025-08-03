package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.alipay.a;
import org.json.alipay.b;

/* loaded from: classes.dex */
public final class uf {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static List<og> f8649;

    static {
        ArrayList arrayList = new ArrayList();
        f8649 = arrayList;
        arrayList.add(new sg());
        f8649.add(new cf());
        f8649.add(new ae());
        f8649.add(new ig());
        f8649.add(new cd());
        f8649.add(new t9());
        f8649.add(new eg());
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m8396(Object obj) {
        if (obj == null) {
            return null;
        }
        Object objM8397 = m8397(obj);
        if (u9.m8367(objM8397.getClass())) {
            return b.c(objM8397.toString());
        }
        if (Collection.class.isAssignableFrom(objM8397.getClass())) {
            return new a((Collection) objM8397).toString();
        }
        if (Map.class.isAssignableFrom(objM8397.getClass())) {
            return new b((Map) objM8397).toString();
        }
        throw new IllegalArgumentException("Unsupported Class : " + objM8397.getClass());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Object m8397(Object obj) {
        Object objA;
        if (obj == null) {
            return null;
        }
        for (og ogVar : f8649) {
            if (ogVar.mo35(obj.getClass()) && (objA = ogVar.a(obj)) != null) {
                return objA;
            }
        }
        throw new IllegalArgumentException("Unsupported Class : " + obj.getClass());
    }
}
