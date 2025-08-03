package defpackage;

import defpackage.C3573;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.CertificatePinner;
import okhttp3.Protocol;

/* compiled from: Address.kt */
/* renamed from: ࢨ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3972 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C3573 f13892;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final List<Protocol> f13893;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final List<C5027> f13894;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final InterfaceC3113 f13895;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final SocketFactory f13896;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final SSLSocketFactory f13897;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final HostnameVerifier f13898;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final CertificatePinner f13899;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC5130 f13900;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final Proxy f13901;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final ProxySelector f13902;

    public C3972(String str, int i, InterfaceC3113 interfaceC3113, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, InterfaceC5130 interfaceC5130, Proxy proxy, List<? extends Protocol> list, List<C5027> list2, ProxySelector proxySelector) {
        C3921.m12667(str, "uriHost");
        C3921.m12667(interfaceC3113, "dns");
        C3921.m12667(socketFactory, "socketFactory");
        C3921.m12667(interfaceC5130, "proxyAuthenticator");
        C3921.m12667(list, "protocols");
        C3921.m12667(list2, "connectionSpecs");
        C3921.m12667(proxySelector, "proxySelector");
        this.f13895 = interfaceC3113;
        this.f13896 = socketFactory;
        this.f13897 = sSLSocketFactory;
        this.f13898 = hostnameVerifier;
        this.f13899 = certificatePinner;
        this.f13900 = interfaceC5130;
        this.f13901 = proxy;
        this.f13902 = proxySelector;
        this.f13892 = new C3573.C3574().m11562(sSLSocketFactory != null ? "https" : "http").m11552(str).m11558(i).m11548();
        this.f13893 = i5.m6271(list);
        this.f13894 = i5.m6271(list2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C3972) {
            C3972 c3972 = (C3972) obj;
            if (C3921.m12662(this.f13892, c3972.f13892) && m12812(c3972)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f13892.hashCode()) * 31) + this.f13895.hashCode()) * 31) + this.f13900.hashCode()) * 31) + this.f13893.hashCode()) * 31) + this.f13894.hashCode()) * 31) + this.f13902.hashCode()) * 31) + Objects.hashCode(this.f13901)) * 31) + Objects.hashCode(this.f13897)) * 31) + Objects.hashCode(this.f13898)) * 31) + Objects.hashCode(this.f13899);
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f13892.m11532());
        sb2.append(':');
        sb2.append(this.f13892.m11537());
        sb2.append(", ");
        if (this.f13901 != null) {
            sb = new StringBuilder();
            sb.append("proxy=");
            obj = this.f13901;
        } else {
            sb = new StringBuilder();
            sb.append("proxySelector=");
            obj = this.f13902;
        }
        sb.append(obj);
        sb2.append(sb.toString());
        sb2.append("}");
        return sb2.toString();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final CertificatePinner m12809() {
        return this.f13899;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final List<C5027> m12810() {
        return this.f13894;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC3113 m12811() {
        return this.f13895;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final boolean m12812(C3972 c3972) {
        C3921.m12667(c3972, "that");
        return C3921.m12662(this.f13895, c3972.f13895) && C3921.m12662(this.f13900, c3972.f13900) && C3921.m12662(this.f13893, c3972.f13893) && C3921.m12662(this.f13894, c3972.f13894) && C3921.m12662(this.f13902, c3972.f13902) && C3921.m12662(this.f13901, c3972.f13901) && C3921.m12662(this.f13897, c3972.f13897) && C3921.m12662(this.f13898, c3972.f13898) && C3921.m12662(this.f13899, c3972.f13899) && this.f13892.m11537() == c3972.f13892.m11537();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final HostnameVerifier m12813() {
        return this.f13898;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final List<Protocol> m12814() {
        return this.f13893;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Proxy m12815() {
        return this.f13901;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC5130 m12816() {
        return this.f13900;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final ProxySelector m12817() {
        return this.f13902;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final SocketFactory m12818() {
        return this.f13896;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final SSLSocketFactory m12819() {
        return this.f13897;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final C3573 m12820() {
        return this.f13892;
    }
}
