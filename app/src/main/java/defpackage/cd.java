package defpackage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import org.json.alipay.a;

/* loaded from: classes.dex */
public final class cd implements kg, og {
    /* renamed from: ԩ, reason: contains not printable characters */
    public static Collection<Object> m296(Class<?> cls, Type type) {
        if (cls == AbstractCollection.class) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception unused) {
            throw new IllegalArgumentException("create instane error, class " + cls.getName());
        }
    }

    @Override // defpackage.og
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((Iterable) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(uf.m8397(it.next()));
        }
        return arrayList;
    }

    @Override // defpackage.kg, defpackage.og
    /* renamed from: Ϳ */
    public final boolean mo35(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls);
    }

    @Override // defpackage.kg
    /* renamed from: Ԩ */
    public final Object mo36(Object obj, Type type) {
        if (!obj.getClass().equals(a.class)) {
            return null;
        }
        a aVar = (a) obj;
        Collection<Object> collectionM296 = m296(u9.m8366(type), type);
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Does not support the implement for generics.");
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        for (int i = 0; i < aVar.a(); i++) {
            collectionM296.add(kf.m7205(aVar.a(i), type2));
        }
        return collectionM296;
    }
}
