package defpackage;

import kotlin.random.Random;

/* compiled from: JDK8PlatformImplementations.kt */
/* renamed from: ԧ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3170 extends C3514 {

    /* compiled from: JDK8PlatformImplementations.kt */
    /* renamed from: ԧ$Ϳ, reason: contains not printable characters */
    public static final class C3171 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final C3171 f11244 = new C3171();

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final Integer f11245;

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
            f11245 = num;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    private final boolean m10777(int i) {
        Integer num = C3171.f11245;
        return num == null || num.intValue() >= i;
    }

    @Override // defpackage.C4104
    /* renamed from: Ԩ, reason: contains not printable characters */
    public Random mo10778() {
        return m10777(24) ? new C4245() : super.mo10778();
    }
}
