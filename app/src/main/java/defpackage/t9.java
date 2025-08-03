package defpackage;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.json.alipay.a;

/* loaded from: classes.dex */
public final class t9 implements kg, og {
    @Override // defpackage.og
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Object[]) obj) {
            arrayList.add(uf.m8397(obj2));
        }
        return arrayList;
    }

    @Override // defpackage.kg, defpackage.og
    /* renamed from: Ϳ */
    public final boolean mo35(Class<?> cls) {
        return cls.isArray();
    }

    @Override // defpackage.kg
    /* renamed from: Ԩ */
    public final Object mo36(Object obj, Type type) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (!obj.getClass().equals(a.class)) {
            return null;
        }
        a aVar = (a) obj;
        if (type instanceof GenericArrayType) {
            throw new IllegalArgumentException("Does not support generic array!");
        }
        Class<?> componentType = ((Class) type).getComponentType();
        int iA = aVar.a();
        Object objNewInstance = Array.newInstance(componentType, iA);
        for (int i = 0; i < iA; i++) {
            Array.set(objNewInstance, i, kf.m7205(aVar.a(i), componentType));
        }
        return objNewInstance;
    }
}
