package defpackage;

import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import defpackage.C4539;
import defpackage.InterfaceC2818;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.text.Regex;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;

/* compiled from: RetryAndFollowUpInterceptor.kt */
/* renamed from: ѭ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2940 implements InterfaceC2818 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C2941 f10653 = new C2941(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C5121 f10654;

    /* compiled from: RetryAndFollowUpInterceptor.kt */
    /* renamed from: ѭ$Ϳ, reason: contains not printable characters */
    public static final class C2941 {
        public C2941() {
        }

        public /* synthetic */ C2941(C4184 c4184) {
            this();
        }
    }

    public C2940(C5121 c5121) {
        C3921.m12667(c5121, "client");
        this.f10654 = c5121;
    }

    @Override // defpackage.InterfaceC2818
    public C4770 intercept(InterfaceC2818.InterfaceC2819 interfaceC2819) throws IOException {
        C3282 c3282M9237;
        C4539 c4539M10339;
        C3921.m12667(interfaceC2819, "chain");
        C3739 c3739 = (C3739) interfaceC2819;
        C4539 c4539M11980 = c3739.m11980();
        C2503 c2503M11976 = c3739.m11976();
        List listM10712 = C3131.m10712();
        C4770 c4770 = null;
        boolean z = true;
        int i = 0;
        while (true) {
            c2503M11976.m9231(c4539M11980, z);
            try {
                if (c2503M11976.isCanceled()) {
                    throw new IOException("Canceled");
                }
                try {
                    C4770 c4770Mo10160 = c3739.mo10160(c4539M11980);
                    if (c4770 != null) {
                        c4770Mo10160 = c4770Mo10160.m14343().m14363(c4770.m14343().m14350(null).m14351()).m14351();
                    }
                    c4770 = c4770Mo10160;
                    c3282M9237 = c2503M11976.m9237();
                    c4539M10339 = m10339(c4770, c3282M9237);
                } catch (IOException e2) {
                    if (!m10341(e2, c2503M11976, c4539M11980, !(e2 instanceof ConnectionShutdownException))) {
                        throw i5.m6277(e2, listM10712);
                    }
                    listM10712 = C2543.m9377(listM10712, e2);
                    c2503M11976.m9232(true);
                    z = false;
                } catch (RouteException e3) {
                    if (!m10341(e3.m7835(), c2503M11976, c4539M11980, false)) {
                        throw i5.m6277(e3.m7834(), listM10712);
                    }
                    listM10712 = C2543.m9377(listM10712, e3.m7834());
                    c2503M11976.m9232(true);
                    z = false;
                }
                if (c4539M10339 == null) {
                    if (c3282M9237 != null && c3282M9237.m10967()) {
                        c2503M11976.m9247();
                    }
                    c2503M11976.m9232(false);
                    return c4770;
                }
                AbstractC2613 abstractC2613M13916 = c4539M10339.m13916();
                if (abstractC2613M13916 != null && abstractC2613M13916.isOneShot()) {
                    c2503M11976.m9232(false);
                    return c4770;
                }
                AbstractC4809 abstractC4809M14330 = c4770.m14330();
                if (abstractC4809M14330 != null) {
                    i5.m6240(abstractC4809M14330);
                }
                i++;
                if (i > 20) {
                    throw new ProtocolException("Too many follow-up requests: " + i);
                }
                c2503M11976.m9232(true);
                c4539M11980 = c4539M10339;
                z = true;
            } catch (Throwable th) {
                c2503M11976.m9232(true);
                throw th;
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C4539 m10338(C4770 c4770, String str) {
        String strM14329;
        C3573 c3573M11542;
        if (!this.f10654.m14964() || (strM14329 = C4770.m14329(c4770, HttpHeaders.HEAD_KEY_LOCATION, null, 2, null)) == null || (c3573M11542 = c4770.m14347().m13925().m11542(strM14329)) == null) {
            return null;
        }
        if (!C3921.m12662(c3573M11542.m11543(), c4770.m14347().m13925().m11543()) && !this.f10654.m14965()) {
            return null;
        }
        C4539.C4540 c4540M13924 = c4770.m14347().m13924();
        if (C3737.m11969(str)) {
            int iM14334 = c4770.m14334();
            C3737 c3737 = C3737.f12943;
            boolean z = c3737.m11973(str) || iM14334 == 308 || iM14334 == 307;
            if (!c3737.m11972(str) || iM14334 == 308 || iM14334 == 307) {
                c4540M13924.m13931(str, z ? c4770.m14347().m13916() : null);
            } else {
                c4540M13924.m13931("GET", null);
            }
            if (!z) {
                c4540M13924.m13933("Transfer-Encoding");
                c4540M13924.m13933(HttpHeaders.HEAD_KEY_CONTENT_LENGTH);
                c4540M13924.m13933(HttpHeaders.HEAD_KEY_CONTENT_TYPE);
            }
        }
        if (!i5.m6237(c4770.m14347().m13925(), c3573M11542)) {
            c4540M13924.m13933("Authorization");
        }
        return c4540M13924.m13934(c3573M11542).m13927();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C4539 m10339(C4770 c4770, C3282 c3282) throws IOException {
        RealConnection realConnectionM10963;
        C4799 c4799M7823 = (c3282 == null || (realConnectionM10963 = c3282.m10963()) == null) ? null : realConnectionM10963.m7823();
        int iM14334 = c4770.m14334();
        String strM13923 = c4770.m14347().m13923();
        if (iM14334 != 307 && iM14334 != 308) {
            if (iM14334 == 401) {
                return this.f10654.m14952().mo14770(c4799M7823, c4770);
            }
            if (iM14334 == 421) {
                AbstractC2613 abstractC2613M13916 = c4770.m14347().m13916();
                if ((abstractC2613M13916 != null && abstractC2613M13916.isOneShot()) || c3282 == null || !c3282.m10966()) {
                    return null;
                }
                c3282.m10963().m7821();
                return c4770.m14347();
            }
            if (iM14334 == 503) {
                C4770 c4770M14344 = c4770.m14344();
                if ((c4770M14344 == null || c4770M14344.m14334() != 503) && m10343(c4770, Integer.MAX_VALUE) == 0) {
                    return c4770.m14347();
                }
                return null;
            }
            if (iM14334 == 407) {
                if (c4799M7823 == null) {
                    C3921.m12675();
                }
                if (c4799M7823.m14512().type() == Proxy.Type.HTTP) {
                    return this.f10654.m14975().mo14770(c4799M7823, c4770);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iM14334 == 408) {
                if (!this.f10654.m14978()) {
                    return null;
                }
                AbstractC2613 abstractC2613M139162 = c4770.m14347().m13916();
                if (abstractC2613M139162 != null && abstractC2613M139162.isOneShot()) {
                    return null;
                }
                C4770 c4770M143442 = c4770.m14344();
                if ((c4770M143442 == null || c4770M143442.m14334() != 408) && m10343(c4770, 0) <= 0) {
                    return c4770.m14347();
                }
                return null;
            }
            switch (iM14334) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return m10338(c4770, strM13923);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m10340(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final boolean m10341(IOException iOException, C2503 c2503, C4539 c4539, boolean z) {
        if (this.f10654.m14978()) {
            return !(z && m10342(iOException, c4539)) && m10340(iOException, z) && c2503.m9245();
        }
        return false;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final boolean m10342(IOException iOException, C4539 c4539) {
        AbstractC2613 abstractC2613M13916 = c4539.m13916();
        return (abstractC2613M13916 != null && abstractC2613M13916.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int m10343(C4770 c4770, int i) throws NumberFormatException {
        String strM14329 = C4770.m14329(c4770, "Retry-After", null, 2, null);
        if (strM14329 == null) {
            return i;
        }
        if (!new Regex("\\d+").m7263(strM14329)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strM14329);
        C3921.m12663(numValueOf, "Integer.valueOf(header)");
        return numValueOf.intValue();
    }
}
