package defpackage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import okhttp3.Protocol;
import okio.Buffer;

/* compiled from: Platform.kt */
/* renamed from: ʧ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2708 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static volatile C2708 f10023;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Logger f10024;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final C2709 f10025;

    /* compiled from: Platform.kt */
    /* renamed from: ʧ$Ϳ, reason: contains not printable characters */
    public static final class C2709 {
        public C2709() {
        }

        public /* synthetic */ C2709(C4184 c4184) {
            this();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final List<String> m9959(List<? extends Protocol> list) {
            C3921.m12667(list, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(C4362.m13522(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Protocol) it.next()).toString());
            }
            return arrayList2;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final byte[] m9960(List<? extends Protocol> list) {
            C3921.m12667(list, "protocols");
            Buffer buffer = new Buffer();
            for (String str : m9959(list)) {
                buffer.writeByte(str.length());
                buffer.writeUtf8(str);
            }
            return buffer.readByteArray();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final C2708 m9961() {
            C3994.f13947.m12859();
            C2708 c2708M12853 = C3988.f13939.m12853();
            if (c2708M12853 == null && (c2708M12853 = C3997.f13950.m12865()) == null) {
                C3921.m12675();
            }
            return c2708M12853;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C2708 m9962() {
            C2625 c2625M9587;
            C2355 c2355M8815;
            C3857 c3857M12295;
            if (m9967() && (c3857M12295 = C3857.f13262.m12295()) != null) {
                return c3857M12295;
            }
            if (m9966() && (c2355M8815 = C2355.f8897.m8815()) != null) {
                return c2355M8815;
            }
            if (m9968() && (c2625M9587 = C2625.f9736.m9587()) != null) {
                return c2625M9587;
            }
            C2478 c2478M9078 = C2478.f9180.m9078();
            if (c2478M9078 != null) {
                return c2478M9078;
            }
            C2708 c2708M10177 = C2831.f10303.m10177();
            return c2708M10177 != null ? c2708M10177 : new C2708();
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C2708 m9963() {
            return m9965() ? m9961() : m9962();
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final C2708 m9964() {
            return C2708.f10023;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final boolean m9965() {
            return C3921.m12662("Dalvik", System.getProperty("java.vm.name"));
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final boolean m9966() {
            Provider provider = Security.getProviders()[0];
            C3921.m12663(provider, "Security.getProviders()[0]");
            return C3921.m12662("BC", provider.getName());
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final boolean m9967() {
            Provider provider = Security.getProviders()[0];
            C3921.m12663(provider, "Security.getProviders()[0]");
            return C3921.m12662("Conscrypt", provider.getName());
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public final boolean m9968() {
            Provider provider = Security.getProviders()[0];
            C3921.m12663(provider, "Security.getProviders()[0]");
            return C3921.m12662("OpenJSSE", provider.getName());
        }
    }

    static {
        C2709 c2709 = new C2709(null);
        f10025 = c2709;
        f10023 = c2709.m9963();
        f10024 = Logger.getLogger(C5121.class.getName());
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static /* synthetic */ void m9947(C2708 c2708, String str, int i, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i2 & 2) != 0) {
            i = 4;
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        c2708.m9955(str, i, th);
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        C3921.m12663(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo9948(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public AbstractC2918 mo9949(X509TrustManager x509TrustManager) {
        C3921.m12667(x509TrustManager, "trustManager");
        return new C5175(mo9950(x509TrustManager));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public q3 mo9950(X509TrustManager x509TrustManager) {
        C3921.m12667(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        C3921.m12663(acceptedIssuers, "trustManager.acceptedIssuers");
        return new C5181((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    /* renamed from: ԫ */
    public void mo8811(SSLSocket sSLSocket, String str, List<Protocol> list) {
        C3921.m12667(sSLSocket, "sslSocket");
        C3921.m12667(list, "protocols");
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void mo9951(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        C3921.m12667(socket, "socket");
        C3921.m12667(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final String m9952() {
        return "OkHttp";
    }

    /* renamed from: Ԯ */
    public String mo8812(SSLSocket sSLSocket) {
        C3921.m12667(sSLSocket, "sslSocket");
        return null;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public Object mo9953(String str) {
        C3921.m12667(str, "closer");
        if (f10024.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean mo9954(String str) {
        C3921.m12667(str, "hostname");
        return true;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m9955(String str, int i, Throwable th) {
        C3921.m12667(str, "message");
        f10024.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void mo9956(String str, Object obj) {
        C3921.m12667(str, "message");
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        m9955(str, 5, (Throwable) obj);
    }

    /* renamed from: ؠ */
    public SSLContext mo8813() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        C3921.m12663(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public SSLSocketFactory mo9957(X509TrustManager x509TrustManager) throws KeyManagementException {
        C3921.m12667(x509TrustManager, "trustManager");
        try {
            SSLContext sSLContextMo8813 = mo8813();
            sSLContextMo8813.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextMo8813.getSocketFactory();
            C3921.m12663(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e2) {
            throw new AssertionError("No System TLS: " + e2, e2);
        }
    }

    /* renamed from: ށ */
    public X509TrustManager mo8814() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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
}
