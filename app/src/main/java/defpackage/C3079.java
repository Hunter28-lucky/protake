package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.C2160;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: CoroutineContext.kt */
/* renamed from: ұ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3079 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final boolean f10948;

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if (r0.equals("on") != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r0.equals("") != false) goto L21;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = defpackage.u0.m8332(r0)
            if (r0 == 0) goto L53
            int r1 = r0.hashCode()
            if (r1 == 0) goto L2a
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L21
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L33
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L33
            r0 = 0
            goto L54
        L21:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L33
            goto L53
        L2a:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L33
            goto L53
        L33:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L53:
            r0 = 1
        L54:
            defpackage.C3079.f10948 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C3079.<clinit>():void");
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final CoroutineDispatcher m10649() {
        return f10948 ? C4085.f14213 : C2160.f7923;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String m10650(CoroutineContext coroutineContext) {
        return null;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final CoroutineContext m10651(InterfaceC3539 interfaceC3539, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextPlus = interfaceC3539.getCoroutineContext().plus(coroutineContext);
        return (coroutineContextPlus == C2888.m10243() || coroutineContextPlus.get(InterfaceC3235.f11395) != null) ? coroutineContextPlus : coroutineContextPlus.plus(C2888.m10243());
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final f4<?> m10652(InterfaceC4472 interfaceC4472) {
        while (!(interfaceC4472 instanceof C3657) && (interfaceC4472 = interfaceC4472.getCallerFrame()) != null) {
            if (interfaceC4472 instanceof f4) {
                return (f4) interfaceC4472;
            }
        }
        return null;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final f4<?> m10653(InterfaceC4355<?> interfaceC4355, CoroutineContext coroutineContext, Object obj) {
        if (!(interfaceC4355 instanceof InterfaceC4472)) {
            return null;
        }
        if (!(coroutineContext.get(h4.f6722) != null)) {
            return null;
        }
        f4<?> f4VarM10652 = m10652((InterfaceC4472) interfaceC4355);
        if (f4VarM10652 != null) {
            f4VarM10652.m6051(coroutineContext, obj);
        }
        return f4VarM10652;
    }
}
