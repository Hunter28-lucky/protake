package defpackage;

import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: RouteDatabase.kt */
/* renamed from: ஷ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4488 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Set<C4799> f15395 = new LinkedHashSet();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final synchronized void m13748(C4799 c4799) {
        C3921.m12667(c4799, "route");
        this.f15395.remove(c4799);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final synchronized void m13749(C4799 c4799) {
        C3921.m12667(c4799, "failedRoute");
        this.f15395.add(c4799);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final synchronized boolean m13750(C4799 c4799) {
        C3921.m12667(c4799, "route");
        return this.f15395.contains(c4799);
    }
}
