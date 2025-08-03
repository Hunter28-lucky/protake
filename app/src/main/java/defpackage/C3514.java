package defpackage;

import java.lang.reflect.InvocationTargetException;

/* compiled from: JDK7PlatformImplementations.kt */
/* renamed from: څ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3514 extends C4104 {

    /* compiled from: JDK7PlatformImplementations.kt */
    /* renamed from: څ$Ϳ, reason: contains not printable characters */
    public static final class C3515 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final C3515 f12288 = new C3515();

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final Integer f12289;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null) {
                if (num2.intValue() > 0) {
                    num = num2;
                }
            }
            f12289 = num;
        }
    }

    @Override // defpackage.C4104
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo11461(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C3921.m12666(th, "cause");
        C3921.m12666(th2, "exception");
        if (m11462(19)) {
            th.addSuppressed(th2);
        } else {
            super.mo11461(th, th2);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m11462(int i) {
        Integer num = C3515.f12289;
        return num == null || num.intValue() >= i;
    }
}
