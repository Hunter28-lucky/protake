package defpackage;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.TypeCastException;

/* compiled from: BasicCertificateChainCleaner.kt */
/* renamed from: ၷ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5175 extends AbstractC2918 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final C5176 f17133 = new C5176(null);

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final q3 f17134;

    /* compiled from: BasicCertificateChainCleaner.kt */
    /* renamed from: ၷ$Ϳ, reason: contains not printable characters */
    public static final class C5176 {
        public C5176() {
        }

        public /* synthetic */ C5176(C4184 c4184) {
            this();
        }
    }

    public C5175(q3 q3Var) {
        C3921.m12667(q3Var, "trustRootIndex");
        this.f17134 = q3Var;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C5175) && C3921.m12662(((C5175) obj).f17134, this.f17134);
    }

    public int hashCode() {
        return this.f17134.hashCode();
    }

    @Override // defpackage.AbstractC2918
    /* renamed from: Ϳ */
    public List<Certificate> mo10311(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        C3921.m12667(list, "chain");
        C3921.m12667(str, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        Object objRemoveFirst = arrayDeque.removeFirst();
        C3921.m12663(objRemoveFirst, "queue.removeFirst()");
        arrayList.add(objRemoveFirst);
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate x509Certificate = (X509Certificate) obj;
            X509Certificate x509CertificateMo7997 = this.f17134.mo7997(x509Certificate);
            if (x509CertificateMo7997 == null) {
                Iterator it = arrayDeque.iterator();
                C3921.m12663(it, "queue.iterator()");
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (m15117(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
            if (arrayList.size() > 1 || (!C3921.m12662(x509Certificate, x509CertificateMo7997))) {
                arrayList.add(x509CertificateMo7997);
            }
            if (m15117(x509CertificateMo7997, x509CertificateMo7997)) {
                return arrayList;
            }
            z = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean m15117(X509Certificate x509Certificate, X509Certificate x509Certificate2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        if (!C3921.m12662(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
