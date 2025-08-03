package okhttp3;

import com.xiaomi.mipush.sdk.Constants;
import defpackage.AbstractC2918;
import defpackage.C2543;
import defpackage.C3131;
import defpackage.C3921;
import defpackage.C4184;
import defpackage.C4362;
import defpackage.InterfaceC4090;
import defpackage.e0;
import defpackage.u3;
import io.jsonwebtoken.JwtParser;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.TypeCastException;
import kotlin.text.StringsKt__StringsKt;
import okio.ByteString;

/* compiled from: CertificatePinner.kt */
/* loaded from: classes2.dex */
public final class CertificatePinner {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Set<C2209> f8102;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final AbstractC2918 f8103;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final C2208 f8101 = new C2208(null);

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final CertificatePinner f8100 = new C2207().m7717();

    /* compiled from: CertificatePinner.kt */
    /* renamed from: okhttp3.CertificatePinner$Ϳ, reason: contains not printable characters */
    public static final class C2207 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final List<C2209> f8104 = new ArrayList();

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final CertificatePinner m7717() {
            return new CertificatePinner(C2543.m9385(this.f8104), null, 2, 0 == true ? 1 : 0);
        }
    }

    /* compiled from: CertificatePinner.kt */
    /* renamed from: okhttp3.CertificatePinner$Ԩ, reason: contains not printable characters */
    public static final class C2208 {
        public C2208() {
        }

        public /* synthetic */ C2208(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final String m7718(Certificate certificate) {
            C3921.m12667(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            return "sha256/" + m7720((X509Certificate) certificate).base64();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final ByteString m7719(X509Certificate x509Certificate) {
            C3921.m12667(x509Certificate, "$this$sha1Hash");
            ByteString.Companion companion = ByteString.Companion;
            PublicKey publicKey = x509Certificate.getPublicKey();
            C3921.m12663(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            C3921.m12663(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha1();
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final ByteString m7720(X509Certificate x509Certificate) {
            C3921.m12667(x509Certificate, "$this$sha256Hash");
            ByteString.Companion companion = ByteString.Companion;
            PublicKey publicKey = x509Certificate.getPublicKey();
            C3921.m12663(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            C3921.m12663(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha256();
        }
    }

    /* compiled from: CertificatePinner.kt */
    /* renamed from: okhttp3.CertificatePinner$Ԫ, reason: contains not printable characters */
    public static final class C2209 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final String f8105;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final String f8106;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final ByteString f8107;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C2209)) {
                return false;
            }
            C2209 c2209 = (C2209) obj;
            return ((C3921.m12662(this.f8105, c2209.f8105) ^ true) || (C3921.m12662(this.f8106, c2209.f8106) ^ true) || (C3921.m12662(this.f8107, c2209.f8107) ^ true)) ? false : true;
        }

        public int hashCode() {
            return (((this.f8105.hashCode() * 31) + this.f8106.hashCode()) * 31) + this.f8107.hashCode();
        }

        public String toString() {
            return this.f8106 + '/' + this.f8107.base64();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ByteString m7721() {
            return this.f8107;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final String m7722() {
            return this.f8106;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final boolean m7723(String str) {
            C3921.m12667(str, "hostname");
            if (e0.m5980(this.f8105, "**.", false, 2, null)) {
                int length = this.f8105.length() - 3;
                int length2 = str.length() - length;
                if (!e0.m5971(str, str.length() - length, this.f8105, 3, length, false, 16, null)) {
                    return false;
                }
                if (length2 != 0 && str.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                if (!e0.m5980(this.f8105, "*.", false, 2, null)) {
                    return C3921.m12662(str, this.f8105);
                }
                int length3 = this.f8105.length() - 1;
                int length4 = str.length() - length3;
                if (!e0.m5971(str, str.length() - length3, this.f8105, 1, length3, false, 16, null) || StringsKt__StringsKt.m7290(str, JwtParser.SEPARATOR_CHAR, length4 - 1, false, 4, null) != -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public CertificatePinner(Set<C2209> set, AbstractC2918 abstractC2918) {
        C3921.m12667(set, "pins");
        this.f8102 = set;
        this.f8103 = abstractC2918;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (C3921.m12662(certificatePinner.f8102, this.f8102) && C3921.m12662(certificatePinner.f8103, this.f8103)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (1517 + this.f8102.hashCode()) * 41;
        AbstractC2918 abstractC2918 = this.f8103;
        return iHashCode + (abstractC2918 != null ? abstractC2918.hashCode() : 0);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m7711(final String str, final List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        C3921.m12667(str, "hostname");
        C3921.m12667(list, "peerCertificates");
        m7712(str, new InterfaceC4090<List<? extends X509Certificate>>() { // from class: okhttp3.CertificatePinner$check$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // defpackage.InterfaceC4090
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public final List<X509Certificate> invoke() {
                List<Certificate> listMo10311;
                AbstractC2918 abstractC2918M7714 = this.this$0.m7714();
                if (abstractC2918M7714 == null || (listMo10311 = abstractC2918M7714.mo10311(list, str)) == null) {
                    listMo10311 = list;
                }
                ArrayList arrayList = new ArrayList(C4362.m13522(listMo10311, 10));
                for (Certificate certificate : listMo10311) {
                    if (certificate == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    arrayList.add((X509Certificate) certificate);
                }
                return arrayList;
            }
        });
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m7712(String str, InterfaceC4090<? extends List<? extends X509Certificate>> interfaceC4090) throws SSLPeerUnverifiedException {
        C3921.m12667(str, "hostname");
        C3921.m12667(interfaceC4090, "cleanedPeerCertificatesFn");
        List<C2209> listM7713 = m7713(str);
        if (listM7713.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = interfaceC4090.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            ByteString byteStringM7720 = null;
            ByteString byteStringM7719 = null;
            for (C2209 c2209 : listM7713) {
                String strM7722 = c2209.m7722();
                int iHashCode = strM7722.hashCode();
                if (iHashCode != -903629273) {
                    if (iHashCode != 3528965 || !strM7722.equals("sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + c2209.m7722());
                    }
                    if (byteStringM7719 == null) {
                        byteStringM7719 = f8101.m7719(x509Certificate);
                    }
                    if (C3921.m12662(c2209.m7721(), byteStringM7719)) {
                        return;
                    }
                } else {
                    if (!strM7722.equals("sha256")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + c2209.m7722());
                    }
                    if (byteStringM7720 == null) {
                        byteStringM7720 = f8101.m7720(x509Certificate);
                    }
                    if (C3921.m12662(c2209.m7721(), byteStringM7720)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sb.append("\n    ");
            sb.append(f8101.m7718(x509Certificate2));
            sb.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            C3921.m12663(subjectDN, "element.subjectDN");
            sb.append(subjectDN.getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(Constants.COLON_SEPARATOR);
        for (C2209 c22092 : listM7713) {
            sb.append("\n    ");
            sb.append(c22092);
        }
        String string = sb.toString();
        C3921.m12663(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final List<C2209> m7713(String str) {
        C3921.m12667(str, "hostname");
        Set<C2209> set = this.f8102;
        List<C2209> listM10712 = C3131.m10712();
        for (Object obj : set) {
            if (((C2209) obj).m7723(str)) {
                if (listM10712.isEmpty()) {
                    listM10712 = new ArrayList<>();
                }
                u3.m8338(listM10712).add(obj);
            }
        }
        return listM10712;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final AbstractC2918 m7714() {
        return this.f8103;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final CertificatePinner m7715(AbstractC2918 abstractC2918) {
        C3921.m12667(abstractC2918, "certificateChainCleaner");
        return C3921.m12662(this.f8103, abstractC2918) ? this : new CertificatePinner(this.f8102, abstractC2918);
    }

    public /* synthetic */ CertificatePinner(Set set, AbstractC2918 abstractC2918, int i, C4184 c4184) {
        this(set, (i & 2) != 0 ? null : abstractC2918);
    }
}
