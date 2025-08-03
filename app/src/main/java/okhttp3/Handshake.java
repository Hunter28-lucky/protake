package okhttp3;

import defpackage.C2553;
import defpackage.C3131;
import defpackage.C3921;
import defpackage.C4184;
import defpackage.C4362;
import defpackage.InterfaceC4090;
import defpackage.InterfaceC4870;
import defpackage.i5;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.C2146;

/* compiled from: Handshake.kt */
/* loaded from: classes2.dex */
public final class Handshake {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Companion f8108 = new Companion(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4870 f8109;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final TlsVersion f8110;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C2553 f8111;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final List<Certificate> f8112;

    /* compiled from: Handshake.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Handshake m7729(SSLSession sSLSession) throws IOException {
            final List<Certificate> listM10712;
            C3921.m12667(sSLSession, "$this$handshake");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            int iHashCode = cipherSuite.hashCode();
            if (iHashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : iHashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            C2553 c2553M9405 = C2553.f9551.m9405(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            if (C3921.m12662("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion tlsVersionM7737 = TlsVersion.f8127.m7737(protocol);
            try {
                listM10712 = m7731(sSLSession.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                listM10712 = C3131.m10712();
            }
            return new Handshake(tlsVersionM7737, c2553M9405, m7731(sSLSession.getLocalCertificates()), new InterfaceC4090<List<? extends Certificate>>() { // from class: okhttp3.Handshake$Companion$handshake$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // defpackage.InterfaceC4090
                /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
                public final List<Certificate> invoke() {
                    return listM10712;
                }
            });
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final Handshake m7730(TlsVersion tlsVersion, C2553 c2553, List<? extends Certificate> list, List<? extends Certificate> list2) {
            C3921.m12667(tlsVersion, "tlsVersion");
            C3921.m12667(c2553, "cipherSuite");
            C3921.m12667(list, "peerCertificates");
            C3921.m12667(list2, "localCertificates");
            final List listM6271 = i5.m6271(list);
            return new Handshake(tlsVersion, c2553, i5.m6271(list2), new InterfaceC4090<List<? extends Certificate>>() { // from class: okhttp3.Handshake$Companion$get$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // defpackage.InterfaceC4090
                /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
                public final List<Certificate> invoke() {
                    return listM6271;
                }
            });
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final List<Certificate> m7731(Certificate[] certificateArr) {
            return certificateArr != null ? i5.m6250((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length)) : C3131.m10712();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(TlsVersion tlsVersion, C2553 c2553, List<? extends Certificate> list, final InterfaceC4090<? extends List<? extends Certificate>> interfaceC4090) {
        C3921.m12667(tlsVersion, "tlsVersion");
        C3921.m12667(c2553, "cipherSuite");
        C3921.m12667(list, "localCertificates");
        C3921.m12667(interfaceC4090, "peerCertificatesFn");
        this.f8110 = tlsVersion;
        this.f8111 = c2553;
        this.f8112 = list;
        this.f8109 = C2146.m7323(new InterfaceC4090<List<? extends Certificate>>() { // from class: okhttp3.Handshake$peerCertificates$2
            {
                super(0);
            }

            @Override // defpackage.InterfaceC4090
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public final List<Certificate> invoke() {
                try {
                    return (List) interfaceC4090.invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return C3131.m10712();
                }
            }
        });
    }

    public boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.f8110 == this.f8110 && C3921.m12662(handshake.f8111, this.f8111) && C3921.m12662(handshake.m7727(), m7727()) && C3921.m12662(handshake.f8112, this.f8112)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f8110.hashCode()) * 31) + this.f8111.hashCode()) * 31) + m7727().hashCode()) * 31) + this.f8112.hashCode();
    }

    public String toString() {
        List<Certificate> listM7727 = m7727();
        ArrayList arrayList = new ArrayList(C4362.m13522(listM7727, 10));
        Iterator<T> it = listM7727.iterator();
        while (it.hasNext()) {
            arrayList.add(m7725((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{");
        sb.append("tlsVersion=");
        sb.append(this.f8110);
        sb.append(' ');
        sb.append("cipherSuite=");
        sb.append(this.f8111);
        sb.append(' ');
        sb.append("peerCertificates=");
        sb.append(string);
        sb.append(' ');
        sb.append("localCertificates=");
        List<Certificate> list = this.f8112;
        ArrayList arrayList2 = new ArrayList(C4362.m13522(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(m7725((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C2553 m7724() {
        return this.f8111;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m7725(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        C3921.m12663(type, "type");
        return type;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final List<Certificate> m7726() {
        return this.f8112;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final List<Certificate> m7727() {
        return (List) this.f8109.getValue();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final TlsVersion m7728() {
        return this.f8110;
    }
}
