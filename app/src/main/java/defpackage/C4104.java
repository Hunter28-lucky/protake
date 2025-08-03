package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.random.Random;

/* compiled from: PlatformImplementations.kt */
/* renamed from: ख़, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4104 {

    /* compiled from: PlatformImplementations.kt */
    /* renamed from: ख़$Ϳ, reason: contains not printable characters */
    public static final class C4105 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final C4105 f14252 = new C4105();

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final Method f14253;

        /* renamed from: ԩ, reason: contains not printable characters */
        public static final Method f14254;

        /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
        static {
            /*
                ख़$Ϳ r0 = new ख़$Ϳ
                r0.<init>()
                defpackage.C4104.C4105.f14252 = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                defpackage.C3921.m12665(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = r3
            L15:
                r5 = 0
                if (r4 >= r2) goto L42
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = defpackage.C3921.m12662(r7, r8)
                if (r7 == 0) goto L3b
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                defpackage.C3921.m12665(r7, r8)
                java.lang.Object r7 = defpackage.C4962.m14745(r7)
                boolean r7 = defpackage.C3921.m12662(r7, r0)
                if (r7 == 0) goto L3b
                r7 = 1
                goto L3c
            L3b:
                r7 = r3
            L3c:
                if (r7 == 0) goto L3f
                goto L43
            L3f:
                int r4 = r4 + 1
                goto L15
            L42:
                r6 = r5
            L43:
                defpackage.C4104.C4105.f14253 = r6
                int r0 = r1.length
            L46:
                if (r3 >= r0) goto L5b
                r2 = r1[r3]
                java.lang.String r4 = r2.getName()
                java.lang.String r6 = "getSuppressed"
                boolean r4 = defpackage.C3921.m12662(r4, r6)
                if (r4 == 0) goto L58
                r5 = r2
                goto L5b
            L58:
                int r3 = r3 + 1
                goto L46
            L5b:
                defpackage.C4104.C4105.f14254 = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C4104.C4105.<clinit>():void");
        }
    }

    /* renamed from: Ϳ */
    public void mo11461(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C3921.m12666(th, "cause");
        C3921.m12666(th2, "exception");
        Method method = C4105.f14253;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    /* renamed from: Ԩ */
    public Random mo10778() {
        return new C3635();
    }
}
