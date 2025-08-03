package defpackage;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import okhttp3.Protocol;

/* compiled from: Android10SocketAdapter.kt */
@SuppressLint({"NewApi"})
/* renamed from: ࢳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3990 implements InterfaceC4233 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C3991 f13941 = new C3991(null);

    /* compiled from: Android10SocketAdapter.kt */
    /* renamed from: ࢳ$Ϳ, reason: contains not printable characters */
    public static final class C3991 {
        public C3991() {
        }

        public /* synthetic */ C3991(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC4233 m12855() {
            if (m12856()) {
                return new C3990();
            }
            return null;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean m12856() {
            return C2708.f10025.m9965() && Build.VERSION.SDK_INT >= 29;
        }
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ϳ */
    public boolean mo8818(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // defpackage.InterfaceC4233
    /* renamed from: Ԩ */
    public boolean mo8819() {
        return f13941.m12856();
    }

    @Override // defpackage.InterfaceC4233
    @SuppressLint({"NewApi"})
    /* renamed from: ԩ */
    public String mo8820(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || C3921.m12662(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // defpackage.InterfaceC4233
    @SuppressLint({"NewApi"})
    /* renamed from: Ԫ */
    public void mo8821(SSLSocket sSLSocket, String str, List<? extends Protocol> list) throws IOException {
        C3921.m12667(sSLSocket, "sslSocket");
        C3921.m12667(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            C3921.m12663(sSLParameters, "sslParameters");
            Object[] array = C2708.f10025.m9959(list).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sSLParameters.setApplicationProtocols((String[]) array);
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e2) {
            throw new IOException("Android internal error", e2);
        }
    }
}
