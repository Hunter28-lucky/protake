package defpackage;

import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* compiled from: DeferredSocketAdapter.kt */
/* renamed from: ஈ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4453 implements InterfaceC4233 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public InterfaceC4233 f15334;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC4454 f15335;

    /* compiled from: DeferredSocketAdapter.kt */
    /* renamed from: ஈ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC4454 {
        /* renamed from: Ϳ */
        boolean mo8822(SSLSocket sSLSocket);

        /* renamed from: Ԩ */
        InterfaceC4233 mo8823(SSLSocket sSLSocket);
    }

    public C4453(InterfaceC4454 interfaceC4454) {
        C3921.m12667(interfaceC4454, "socketAdapterFactory");
        this.f15335 = interfaceC4454;
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ϳ */
    public boolean mo8818(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        return this.f15335.mo8822(sSLSocket);
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ԩ */
    public boolean mo8819() {
        return true;
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: ԩ */
    public String mo8820(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        InterfaceC4233 interfaceC4233M13719 = m13719(sSLSocket);
        if (interfaceC4233M13719 != null) {
            return interfaceC4233M13719.mo8820(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ԫ */
    public void mo8821(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        C3921.m12667(sSLSocket, "sslSocket");
        C3921.m12667(list, "protocols");
        InterfaceC4233 interfaceC4233M13719 = m13719(sSLSocket);
        if (interfaceC4233M13719 != null) {
            interfaceC4233M13719.mo8821(sSLSocket, str, list);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final synchronized InterfaceC4233 m13719(SSLSocket sSLSocket) {
        if (this.f15334 == null && this.f15335.mo8822(sSLSocket)) {
            this.f15334 = this.f15335.mo8823(sSLSocket);
        }
        return this.f15334;
    }
}
