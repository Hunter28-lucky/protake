package defpackage;

import defpackage.C4453;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import okhttp3.Protocol;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* compiled from: BouncyCastleSocketAdapter.kt */
/* renamed from: ŀ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2357 implements InterfaceC4233 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C2359 f8900 = new C2359(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C4453.InterfaceC4454 f8899 = new C2358();

    /* compiled from: BouncyCastleSocketAdapter.kt */
    /* renamed from: ŀ$Ϳ, reason: contains not printable characters */
    public static final class C2358 implements C4453.InterfaceC4454 {
        @Override // defpackage.C4453.InterfaceC4454
        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean mo8822(SSLSocket sSLSocket) {
            C3921.m12667(sSLSocket, "sslSocket");
            return C2355.f8897.m8816() && (sSLSocket instanceof BCSSLSocket);
        }

        @Override // defpackage.C4453.InterfaceC4454
        /* renamed from: Ԩ, reason: contains not printable characters */
        public InterfaceC4233 mo8823(SSLSocket sSLSocket) {
            C3921.m12667(sSLSocket, "sslSocket");
            return new C2357();
        }
    }

    /* compiled from: BouncyCastleSocketAdapter.kt */
    /* renamed from: ŀ$Ԩ, reason: contains not printable characters */
    public static final class C2359 {
        public C2359() {
        }

        public /* synthetic */ C2359(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C4453.InterfaceC4454 m8824() {
            return C2357.f8899;
        }
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean mo8818(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        return sSLSocket instanceof BCSSLSocket;
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean mo8819() {
        return C2355.f8897.m8816();
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: ԩ, reason: contains not printable characters */
    public String mo8820(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null || C3921.m12662(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ԫ, reason: contains not printable characters */
    public void mo8821(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        C3921.m12667(sSLSocket, "sslSocket");
        C3921.m12667(list, "protocols");
        if (mo8818(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            C3921.m12663(parameters, "sslParameters");
            Object[] array = C2708.f10025.m9959(list).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            parameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(parameters);
        }
    }
}
