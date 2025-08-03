package defpackage;

import android.net.http.X509TrustManagerExtensions;
import com.blink.academy.film.http.okhttp.utils.HttpUtil;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;

/* compiled from: AndroidCertificateChainCleaner.kt */
/* renamed from: ࢴ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3992 extends AbstractC2918 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final C3993 f13942 = new C3993(null);

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final X509TrustManager f13943;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final X509TrustManagerExtensions f13944;

    /* compiled from: AndroidCertificateChainCleaner.kt */
    /* renamed from: ࢴ$Ϳ, reason: contains not printable characters */
    public static final class C3993 {
        public C3993() {
        }

        public /* synthetic */ C3993(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C3992 m12857(X509TrustManager x509TrustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            C3921.m12667(x509TrustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions != null) {
                return new C3992(x509TrustManager, x509TrustManagerExtensions);
            }
            return null;
        }
    }

    public C3992(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        C3921.m12667(x509TrustManager, "trustManager");
        C3921.m12667(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f13943 = x509TrustManager;
        this.f13944 = x509TrustManagerExtensions;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C3992) && ((C3992) obj).f13943 == this.f13943;
    }

    public int hashCode() {
        return System.identityHashCode(this.f13943);
    }

    @Override // defpackage.AbstractC2918
    /* renamed from: Ϳ */
    public List<Certificate> mo10311(List<? extends Certificate> list, String str) throws CertificateException, SSLPeerUnverifiedException {
        C3921.m12667(list, "chain");
        C3921.m12667(str, "hostname");
        Object[] array = list.toArray(new X509Certificate[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        try {
            List<X509Certificate> listCheckServerTrusted = this.f13944.checkServerTrusted((X509Certificate[]) array, HttpUtil.RSA, str);
            C3921.m12663(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e2) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
            sSLPeerUnverifiedException.initCause(e2);
            throw sSLPeerUnverifiedException;
        }
    }
}
