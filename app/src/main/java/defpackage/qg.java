package defpackage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import org.json.alipay.a;

/* loaded from: classes.dex */
public final class qg implements kg {
    @Override // defpackage.kg, defpackage.og
    /* renamed from: Ϳ */
    public final boolean mo35(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }

    @Override // defpackage.kg
    /* renamed from: Ԩ */
    public final Object mo36(Object obj, Type type) {
        if (!obj.getClass().equals(a.class)) {
            return null;
        }
        a aVar = (a) obj;
        HashSet hashSet = new HashSet();
        Class cls = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class;
        for (int i = 0; i < aVar.a(); i++) {
            hashSet.add(kf.m7205(aVar.a(i), cls));
        }
        return hashSet;
    }
}
