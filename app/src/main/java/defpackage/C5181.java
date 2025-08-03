package defpackage;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* compiled from: BasicTrustRootIndex.kt */
/* renamed from: ၼ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5181 implements q3 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Map<X500Principal, Set<X509Certificate>> f17150;

    public C5181(X509Certificate... x509CertificateArr) {
        C3921.m12667(x509CertificateArr, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            C3921.m12663(subjectX500Principal, "caCert.subjectX500Principal");
            Object linkedHashSet = linkedHashMap.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, linkedHashSet);
            }
            ((Set) linkedHashSet).add(x509Certificate);
        }
        this.f17150 = linkedHashMap;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C5181) && C3921.m12662(((C5181) obj).f17150, this.f17150));
    }

    public int hashCode() {
        return this.f17150.hashCode();
    }

    @Override // defpackage.q3
    /* renamed from: Ϳ */
    public X509Certificate mo7997(X509Certificate x509Certificate) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        boolean z;
        C3921.m12667(x509Certificate, "cert");
        Set<X509Certificate> set = this.f17150.get(x509Certificate.getIssuerX500Principal());
        Object obj = null;
        if (set == null) {
            return null;
        }
        Iterator<T> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            try {
                x509Certificate.verify(((X509Certificate) next).getPublicKey());
                z = true;
            } catch (Exception unused) {
                z = false;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        return (X509Certificate) obj;
    }
}
