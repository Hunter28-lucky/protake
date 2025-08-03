package defpackage;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class cf implements kg, og {
    @Override // defpackage.og
    public final Object a(Object obj) {
        return ((Enum) obj).name();
    }

    @Override // defpackage.kg, defpackage.og
    /* renamed from: Ϳ */
    public final boolean mo35(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }

    @Override // defpackage.kg
    /* renamed from: Ԩ */
    public final Object mo36(Object obj, Type type) {
        return Enum.valueOf((Class) type, obj.toString());
    }
}
