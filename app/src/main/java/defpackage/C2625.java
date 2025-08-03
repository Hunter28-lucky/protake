package defpackage;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import okhttp3.Protocol;
import org.openjsse.javax.net.ssl.SSLParameters;
import org.openjsse.net.ssl.OpenJSSE;

/* compiled from: OpenJSSEPlatform.kt */
/* renamed from: ɷ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2625 extends C2708 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final boolean f9735;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C2626 f9736;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Provider f9737;

    /* compiled from: OpenJSSEPlatform.kt */
    /* renamed from: ɷ$Ϳ, reason: contains not printable characters */
    public static final class C2626 {
        public C2626() {
        }

        public /* synthetic */ C2626(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2625 m9587() {
            C4184 c4184 = null;
            if (m9588()) {
                return new C2625(c4184);
            }
            return null;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean m9588() {
            return C2625.f9735;
        }
    }

    static {
        C2626 c2626 = new C2626(null);
        f9736 = c2626;
        boolean z = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, c2626.getClass().getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        f9735 = z;
    }

    public C2625() {
        this.f9737 = new OpenJSSE();
    }

    @Override // defpackage.C2708
    /* renamed from: ԫ */
    public void mo8811(SSLSocket sSLSocket, String str, List<Protocol> list) {
        C3921.m12667(sSLSocket, "sslSocket");
        C3921.m12667(list, "protocols");
        if (!(sSLSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            super.mo8811(sSLSocket, str, list);
            return;
        }
        org.openjsse.javax.net.ssl.SSLSocket sSLSocket2 = (org.openjsse.javax.net.ssl.SSLSocket) sSLSocket;
        SSLParameters sSLParameters = sSLSocket2.getSSLParameters();
        if (sSLParameters instanceof SSLParameters) {
            SSLParameters sSLParameters2 = sSLParameters;
            Object[] array = C2708.f10025.m9959(list).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sSLParameters2.setApplicationProtocols((String[]) array);
            sSLSocket2.setSSLParameters(sSLParameters);
        }
    }

    @Override // defpackage.C2708
    /* renamed from: Ԯ */
    public String mo8812(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        if (!(sSLSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            return super.mo8812(sSLSocket);
        }
        String applicationProtocol = ((org.openjsse.javax.net.ssl.SSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null || C3921.m12662(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // defpackage.C2708
    /* renamed from: ؠ */
    public SSLContext mo8813() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.f9737);
        C3921.m12663(sSLContext, "SSLContext.getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override // defpackage.C2708
    /* renamed from: ށ */
    public X509TrustManager mo8814() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f9737);
        trustManagerFactory.init((KeyStore) null);
        C3921.m12663(trustManagerFactory, "factory");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers == null) {
            C3921.m12675();
        }
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        C3921.m12663(string, "java.util.Arrays.toString(this)");
        sb.append(string);
        throw new IllegalStateException(sb.toString().toString());
    }

    public /* synthetic */ C2625(C4184 c4184) {
        this();
    }
}
