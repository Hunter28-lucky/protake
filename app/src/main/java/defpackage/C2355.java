package defpackage;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
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
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/* compiled from: BouncyCastlePlatform.kt */
/* renamed from: ľ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2355 extends C2708 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final boolean f8896;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C2356 f8897;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Provider f8898;

    /* compiled from: BouncyCastlePlatform.kt */
    /* renamed from: ľ$Ϳ, reason: contains not printable characters */
    public static final class C2356 {
        public C2356() {
        }

        public /* synthetic */ C2356(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2355 m8815() {
            C4184 c4184 = null;
            if (m8816()) {
                return new C2355(c4184);
            }
            return null;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean m8816() {
            return C2355.f8896;
        }
    }

    static {
        C2356 c2356 = new C2356(null);
        f8897 = c2356;
        boolean z = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, c2356.getClass().getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        f8896 = z;
    }

    public C2355() {
        this.f8898 = new BouncyCastleJsseProvider();
    }

    @Override // defpackage.C2708
    /* renamed from: ԫ, reason: contains not printable characters */
    public void mo8811(SSLSocket sSLSocket, String str, List<Protocol> list) {
        C3921.m12667(sSLSocket, "sslSocket");
        C3921.m12667(list, "protocols");
        if (!(sSLSocket instanceof BCSSLSocket)) {
            super.mo8811(sSLSocket, str, list);
            return;
        }
        BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
        BCSSLParameters parameters = bCSSLSocket.getParameters();
        List<String> listM9959 = C2708.f10025.m9959(list);
        C3921.m12663(parameters, "sslParameters");
        Object[] array = listM9959.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        parameters.setApplicationProtocols((String[]) array);
        bCSSLSocket.setParameters(parameters);
    }

    @Override // defpackage.C2708
    /* renamed from: Ԯ, reason: contains not printable characters */
    public String mo8812(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        if (!(sSLSocket instanceof BCSSLSocket)) {
            return super.mo8812(sSLSocket);
        }
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null || C3921.m12662(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // defpackage.C2708
    /* renamed from: ؠ, reason: contains not printable characters */
    public SSLContext mo8813() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f8898);
        C3921.m12663(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // defpackage.C2708
    /* renamed from: ށ, reason: contains not printable characters */
    public X509TrustManager mo8814() throws NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
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

    public /* synthetic */ C2355(C4184 c4184) {
        this();
    }
}
