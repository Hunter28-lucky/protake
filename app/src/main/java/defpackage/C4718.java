package defpackage;

import com.umeng.analytics.pro.d;
import io.jsonwebtoken.JwtParser;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.TypeCastException;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: OkHostnameVerifier.kt */
/* renamed from: ത, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4718 implements HostnameVerifier {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C4718 f15983 = new C4718();

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        C3921.m12667(str, "host");
        C3921.m12667(sSLSession, d.aw);
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            if (certificate != null) {
                return m14258(str, (X509Certificate) certificate);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final List<String> m14256(X509Certificate x509Certificate) {
        C3921.m12667(x509Certificate, "certificate");
        return C2543.m9376(m14257(x509Certificate, 7), m14257(x509Certificate, 2));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final List<String> m14257(X509Certificate x509Certificate, int i) throws CertificateParsingException {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return C3131.m10712();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && !(!C3921.m12662(list.get(0), Integer.valueOf(i))) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return C3131.m10712();
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m14258(String str, X509Certificate x509Certificate) {
        C3921.m12667(str, "host");
        C3921.m12667(x509Certificate, "certificate");
        return i5.m6236(str) ? m14261(str, x509Certificate) : m14260(str, x509Certificate);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final boolean m14259(String str, String str2) {
        if (!(str == null || str.length() == 0) && !e0.m5980(str, ".", false, 2, null) && !e0.m5966(str, "..", false, 2, null)) {
            if (!(str2 == null || str2.length() == 0) && !e0.m5980(str2, ".", false, 2, null) && !e0.m5966(str2, "..", false, 2, null)) {
                if (!e0.m5966(str, ".", false, 2, null)) {
                    str = str + ".";
                }
                String str3 = str;
                if (!e0.m5966(str2, ".", false, 2, null)) {
                    str2 = str2 + ".";
                }
                Locale locale = Locale.US;
                C3921.m12663(locale, "Locale.US");
                if (str2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = str2.toLowerCase(locale);
                C3921.m12663(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!StringsKt__StringsKt.m7275(lowerCase, "*", false, 2, null)) {
                    return C3921.m12662(str3, lowerCase);
                }
                if (!e0.m5980(lowerCase, "*.", false, 2, null) || StringsKt__StringsKt.m7285(lowerCase, '*', 1, false, 4, null) != -1 || str3.length() < lowerCase.length() || C3921.m12662("*.", lowerCase)) {
                    return false;
                }
                String strSubstring = lowerCase.substring(1);
                C3921.m12663(strSubstring, "(this as java.lang.String).substring(startIndex)");
                if (!e0.m5966(str3, strSubstring, false, 2, null)) {
                    return false;
                }
                int length = str3.length() - strSubstring.length();
                return length <= 0 || StringsKt__StringsKt.m7290(str3, JwtParser.SEPARATOR_CHAR, length + (-1), false, 4, null) == -1;
            }
        }
        return false;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final boolean m14260(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        Locale locale = Locale.US;
        C3921.m12663(locale, "Locale.US");
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        C3921.m12663(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        List<String> listM14257 = m14257(x509Certificate, 2);
        if ((listM14257 instanceof Collection) && listM14257.isEmpty()) {
            return false;
        }
        Iterator<T> it = listM14257.iterator();
        while (it.hasNext()) {
            if (f15983.m14259(lowerCase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean m14261(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        String strM13710 = C4446.m13710(str);
        List<String> listM14257 = m14257(x509Certificate, 7);
        if ((listM14257 instanceof Collection) && listM14257.isEmpty()) {
            return false;
        }
        Iterator<T> it = listM14257.iterator();
        while (it.hasNext()) {
            if (C3921.m12662(strM13710, C4446.m13710((String) it.next()))) {
                return true;
            }
        }
        return false;
    }
}
