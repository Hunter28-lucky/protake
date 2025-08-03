package defpackage;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* compiled from: Route.kt */
/* renamed from: ඞ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4799 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C3972 f16271;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Proxy f16272;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InetSocketAddress f16273;

    public C4799(C3972 c3972, Proxy proxy, InetSocketAddress inetSocketAddress) {
        C3921.m12667(c3972, "address");
        C3921.m12667(proxy, "proxy");
        C3921.m12667(inetSocketAddress, "socketAddress");
        this.f16271 = c3972;
        this.f16272 = proxy;
        this.f16273 = inetSocketAddress;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C4799) {
            C4799 c4799 = (C4799) obj;
            if (C3921.m12662(c4799.f16271, this.f16271) && C3921.m12662(c4799.f16272, this.f16272) && C3921.m12662(c4799.f16273, this.f16273)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f16271.hashCode()) * 31) + this.f16272.hashCode()) * 31) + this.f16273.hashCode();
    }

    public String toString() {
        return "Route{" + this.f16273 + '}';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C3972 m14511() {
        return this.f16271;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Proxy m14512() {
        return this.f16272;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m14513() {
        return this.f16271.m12819() != null && this.f16272.type() == Proxy.Type.HTTP;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final InetSocketAddress m14514() {
        return this.f16273;
    }
}
