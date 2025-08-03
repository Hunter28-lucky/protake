package defpackage;

import java.lang.reflect.Type;
import java.util.Date;

/* loaded from: classes.dex */
public final class ae implements kg, og {
    @Override // defpackage.og
    public final Object a(Object obj) {
        return Long.valueOf(((Date) obj).getTime());
    }

    @Override // defpackage.kg, defpackage.og
    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean mo35(Class<?> cls) {
        return Date.class.isAssignableFrom(cls);
    }

    @Override // defpackage.kg
    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Object mo36(Object obj, Type type) {
        return new Date(((Long) obj).longValue());
    }
}
