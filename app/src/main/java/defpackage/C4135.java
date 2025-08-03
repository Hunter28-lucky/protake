package defpackage;

import com.blink.academy.film.support.stream.ts.TsConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpecSelector.kt */
/* renamed from: ঀ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4135 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f14329;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f14330;

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f14331;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final List<C5027> f14332;

    public C4135(List<C5027> list) {
        C3921.m12667(list, "connectionSpecs");
        this.f14332 = list;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C5027 m13105(SSLSocket sSLSocket) throws IOException, CloneNotSupportedException {
        C5027 c5027;
        C3921.m12667(sSLSocket, "sslSocket");
        int i = this.f14329;
        int size = this.f14332.size();
        while (true) {
            if (i >= size) {
                c5027 = null;
                break;
            }
            c5027 = this.f14332.get(i);
            if (c5027.m14824(sSLSocket)) {
                this.f14329 = i + 1;
                break;
            }
            i++;
        }
        if (c5027 != null) {
            this.f14330 = m13107(sSLSocket);
            c5027.m14822(sSLSocket, this.f14331);
            return c5027;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f14331);
        sb.append(',');
        sb.append(" modes=");
        sb.append(this.f14332);
        sb.append(',');
        sb.append(" supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        if (enabledProtocols == null) {
            C3921.m12675();
        }
        String string = Arrays.toString(enabledProtocols);
        C3921.m12663(string, "java.util.Arrays.toString(this)");
        sb.append(string);
        throw new UnknownServiceException(sb.toString());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean m13106(IOException iOException) {
        C3921.m12667(iOException, TsConstants.kLinkParam_machine);
        this.f14331 = true;
        return (!this.f14330 || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException) || ((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) || !(iOException instanceof SSLException)) ? false : true;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m13107(SSLSocket sSLSocket) {
        int size = this.f14332.size();
        for (int i = this.f14329; i < size; i++) {
            if (this.f14332.get(i).m14824(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
