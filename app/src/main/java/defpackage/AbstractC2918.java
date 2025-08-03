package defpackage;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* compiled from: CertificateChainCleaner.kt */
/* renamed from: ѓ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC2918 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C2919 f10624 = new C2919(null);

    /* compiled from: CertificateChainCleaner.kt */
    /* renamed from: ѓ$Ϳ, reason: contains not printable characters */
    public static final class C2919 {
        public C2919() {
        }

        public /* synthetic */ C2919(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final AbstractC2918 m10312(X509TrustManager x509TrustManager) {
            C3921.m12667(x509TrustManager, "trustManager");
            return C2708.f10025.m9964().mo9949(x509TrustManager);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public abstract List<Certificate> mo10311(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException;
}
