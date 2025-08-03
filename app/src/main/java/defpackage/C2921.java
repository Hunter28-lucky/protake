package defpackage;

import java.lang.reflect.Field;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* compiled from: DebugMetadata.kt */
/* renamed from: ѕ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2921 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final void m10314(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final InterfaceC3540 m10315(BaseContinuationImpl baseContinuationImpl) {
        return (InterfaceC3540) baseContinuationImpl.getClass().getAnnotation(InterfaceC3540.class);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final int m10316(BaseContinuationImpl baseContinuationImpl) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final StackTraceElement m10317(BaseContinuationImpl baseContinuationImpl) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        String strC;
        C3921.m12666(baseContinuationImpl, "<this>");
        InterfaceC3540 interfaceC3540M10315 = m10315(baseContinuationImpl);
        if (interfaceC3540M10315 == null) {
            return null;
        }
        m10314(1, interfaceC3540M10315.v());
        int iM10316 = m10316(baseContinuationImpl);
        int i = iM10316 < 0 ? -1 : interfaceC3540M10315.l()[iM10316];
        String strM12713 = C3938.f13575.m12713(baseContinuationImpl);
        if (strM12713 == null) {
            strC = interfaceC3540M10315.c();
        } else {
            strC = strM12713 + '/' + interfaceC3540M10315.c();
        }
        return new StackTraceElement(strC, interfaceC3540M10315.m(), interfaceC3540M10315.f(), i);
    }
}
