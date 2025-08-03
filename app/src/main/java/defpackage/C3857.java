package defpackage;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

/* compiled from: ConscryptPlatform.kt */
/* renamed from: ߟ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3857 extends C2708 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final boolean f13261;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C3858 f13262;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Provider f13263;

    /* compiled from: ConscryptPlatform.kt */
    /* renamed from: ߟ$Ϳ, reason: contains not printable characters */
    public static final class C3858 {
        public C3858() {
        }

        public /* synthetic */ C3858(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final boolean m12294(int i, int i2, int i3) {
            Conscrypt.Version version = Conscrypt.version();
            return version.major() != i ? version.major() > i : version.minor() != i2 ? version.minor() > i2 : version.patch() >= i3;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C3857 m12295() {
            C4184 c4184 = null;
            if (m12296()) {
                return new C3857(c4184);
            }
            return null;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final boolean m12296() {
            return C3857.f13261;
        }
    }

    /* compiled from: ConscryptPlatform.kt */
    /* renamed from: ߟ$Ԩ, reason: contains not printable characters */
    public static final class C3859 implements ConscryptHostnameVerifier {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final C3859 f13264 = new C3859();
    }

    static {
        C3858 c3858 = new C3858(null);
        f13262 = c3858;
        boolean z = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, c3858.getClass().getClassLoader());
            if (Conscrypt.isAvailable()) {
                if (c3858.m12294(2, 1, 0)) {
                    z = true;
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f13261 = z;
    }

    public C3857() {
        Provider providerBuild = Conscrypt.newProviderBuilder().provideTrustManager(true).build();
        C3921.m12663(providerBuild, "Conscrypt.newProviderBui…rustManager(true).build()");
        this.f13263 = providerBuild;
    }

    @Override // defpackage.C2708
    /* renamed from: ԫ */
    public void mo8811(SSLSocket sSLSocket, String str, List<Protocol> list) {
        C3921.m12667(sSLSocket, "sslSocket");
        C3921.m12667(list, "protocols");
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.mo8811(sSLSocket, str, list);
            return;
        }
        Conscrypt.setUseSessionTickets(sSLSocket, true);
        Object[] array = C2708.f10025.m9959(list).toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
    }

    @Override // defpackage.C2708
    /* renamed from: Ԯ */
    public String mo8812(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.mo8812(sSLSocket);
    }

    @Override // defpackage.C2708
    /* renamed from: ؠ */
    public SSLContext mo8813() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f13263);
        C3921.m12663(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // defpackage.C2708
    /* renamed from: ހ */
    public SSLSocketFactory mo9957(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
        C3921.m12667(x509TrustManager, "trustManager");
        SSLContext sSLContextMo8813 = mo8813();
        sSLContextMo8813.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = sSLContextMo8813.getSocketFactory();
        Conscrypt.setUseEngineSocket(socketFactory, true);
        C3921.m12663(socketFactory, "newSSLContext().apply {\n…ineSocket(it, true)\n    }");
        return socketFactory;
    }

    @Override // defpackage.C2708
    /* renamed from: ށ */
    public X509TrustManager mo8814() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        C3921.m12663(trustManagerFactory, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers == null) {
            C3921.m12675();
        }
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager == null) {
                throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            }
            X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
            Conscrypt.setHostnameVerifier(x509TrustManager, C3859.f13264);
            return x509TrustManager;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        C3921.m12663(string, "java.util.Arrays.toString(this)");
        sb.append(string);
        throw new IllegalStateException(sb.toString().toString());
    }

    public /* synthetic */ C3857(C4184 c4184) {
        this();
    }
}
