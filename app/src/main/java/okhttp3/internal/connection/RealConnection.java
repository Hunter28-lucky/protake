package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.efs.sdk.base.Constants;
import defpackage.AbstractC3415;
import defpackage.C2426;
import defpackage.C2503;
import defpackage.C2627;
import defpackage.C2708;
import defpackage.C2861;
import defpackage.C3553;
import defpackage.C3573;
import defpackage.C3739;
import defpackage.C3921;
import defpackage.C3972;
import defpackage.C4135;
import defpackage.C4184;
import defpackage.C4419;
import defpackage.C4539;
import defpackage.C4718;
import defpackage.C4770;
import defpackage.C4799;
import defpackage.C4825;
import defpackage.C5121;
import defpackage.C5249;
import defpackage.InterfaceC2891;
import defpackage.InterfaceC5051;
import defpackage.InterfaceC5054;
import defpackage.e0;
import defpackage.i5;
import defpackage.m1;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.TypeCastException;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Timeout;

/* compiled from: RealConnection.kt */
/* loaded from: classes2.dex */
public final class RealConnection extends C2426.AbstractC2430 implements InterfaceC5051 {

    /* renamed from: ޅ, reason: contains not printable characters */
    public static final C2217 f8184 = new C2217(null);

    /* renamed from: ԩ, reason: contains not printable characters */
    public Socket f8185;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Socket f8186;

    /* renamed from: ԫ, reason: contains not printable characters */
    public Handshake f8187;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Protocol f8188;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C2426 f8189;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public BufferedSource f8190;

    /* renamed from: ԯ, reason: contains not printable characters */
    public BufferedSink f8191;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f8192;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f8193;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f8194;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f8195;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f8196;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f8197;

    /* renamed from: ށ, reason: contains not printable characters */
    public final List<Reference<C2503>> f8198;

    /* renamed from: ނ, reason: contains not printable characters */
    public long f8199;

    /* renamed from: ރ, reason: contains not printable characters */
    public final C2861 f8200;

    /* renamed from: ބ, reason: contains not printable characters */
    public final C4799 f8201;

    /* compiled from: RealConnection.kt */
    /* renamed from: okhttp3.internal.connection.RealConnection$Ϳ, reason: contains not printable characters */
    public static final class C2217 {
        public C2217() {
        }

        public /* synthetic */ C2217(C4184 c4184) {
            this();
        }
    }

    public RealConnection(C2861 c2861, C4799 c4799) {
        C3921.m12667(c2861, "connectionPool");
        C3921.m12667(c4799, "route");
        this.f8200 = c2861;
        this.f8201 = c4799;
        this.f8197 = 1;
        this.f8198 = new ArrayList();
        this.f8199 = Long.MAX_VALUE;
    }

    public String toString() {
        Object objM7724;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f8201.m14511().m12820().m11532());
        sb.append(':');
        sb.append(this.f8201.m14511().m12820().m11537());
        sb.append(',');
        sb.append(" proxy=");
        sb.append(this.f8201.m14512());
        sb.append(" hostAddress=");
        sb.append(this.f8201.m14514());
        sb.append(" cipherSuite=");
        Handshake handshake = this.f8187;
        if (handshake == null || (objM7724 = handshake.m7724()) == null) {
            objM7724 = Constants.CP_NONE;
        }
        sb.append(objM7724);
        sb.append(" protocol=");
        sb.append(this.f8188);
        sb.append('}');
        return sb.toString();
    }

    @Override // defpackage.InterfaceC5051
    /* renamed from: Ϳ, reason: contains not printable characters */
    public Protocol mo7798() {
        Protocol protocol = this.f8188;
        if (protocol == null) {
            C3921.m12675();
        }
        return protocol;
    }

    @Override // defpackage.C2426.AbstractC2430
    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized void mo7799(C2426 c2426, C4825 c4825) {
        C3921.m12667(c2426, "connection");
        C3921.m12667(c4825, "settings");
        this.f8197 = c4825.m14555();
    }

    @Override // defpackage.C2426.AbstractC2430
    /* renamed from: ԩ, reason: contains not printable characters */
    public void mo7800(C4419 c4419) throws IOException {
        C3921.m12667(c4419, "stream");
        c4419.m13616(ErrorCode.REFUSED_STREAM, null);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m7801() throws IOException {
        Socket socket = this.f8185;
        if (socket != null) {
            i5.m6241(socket);
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean m7802(C3573 c3573, Handshake handshake) {
        List<Certificate> listM7727 = handshake.m7727();
        if (!listM7727.isEmpty()) {
            C4718 c4718 = C4718.f15983;
            String strM11532 = c3573.m11532();
            Certificate certificate = listM7727.get(0);
            if (certificate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            if (c4718.m14258(strM11532, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014c A[SYNTHETIC] */
    /* renamed from: ԭ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m7803(int r17, int r18, int r19, int r20, boolean r21, defpackage.InterfaceC5054 r22, defpackage.AbstractC3415 r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.m7803(int, int, int, int, boolean, འ, װ):void");
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m7804(C5121 c5121, C4799 c4799, IOException iOException) {
        C3921.m12667(c5121, "client");
        C3921.m12667(c4799, "failedRoute");
        C3921.m12667(iOException, "failure");
        if (c4799.m14512().type() != Proxy.Type.DIRECT) {
            C3972 c3972M14511 = c4799.m14511();
            c3972M14511.m12817().connectFailed(c3972M14511.m12820().m11544(), c4799.m14512().address(), iOException);
        }
        c5121.m14966().m13749(c4799);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m7805(int i, int i2, InterfaceC5054 interfaceC5054, AbstractC3415 abstractC3415) throws IOException {
        Socket socket;
        int i3;
        Proxy proxyM14512 = this.f8201.m14512();
        C3972 c3972M14511 = this.f8201.m14511();
        Proxy.Type type = proxyM14512.type();
        if (type != null && ((i3 = C2627.f9738[type.ordinal()]) == 1 || i3 == 2)) {
            socket = c3972M14511.m12818().createSocket();
            if (socket == null) {
                C3921.m12675();
            }
        } else {
            socket = new Socket(proxyM14512);
        }
        this.f8185 = socket;
        abstractC3415.connectStart(interfaceC5054, this.f8201.m14514(), proxyM14512);
        socket.setSoTimeout(i2);
        try {
            C2708.f10025.m9964().mo9951(socket, this.f8201.m14514(), i);
            try {
                this.f8190 = Okio.buffer(Okio.source(socket));
                this.f8191 = Okio.buffer(Okio.sink(socket));
            } catch (NullPointerException e2) {
                if (C3921.m12662(e2.getMessage(), "throw with null exception")) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f8201.m14514());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x017d A[Catch: all -> 0x0185, TRY_ENTER, TryCatch #0 {all -> 0x0185, blocks: (B:4:0x000d, B:5:0x0010, B:7:0x0029, B:41:0x017d, B:42:0x0184), top: B:49:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029 A[Catch: all -> 0x0185, TRY_LEAVE, TryCatch #0 {all -> 0x0185, blocks: (B:4:0x000d, B:5:0x0010, B:7:0x0029, B:41:0x017d, B:42:0x0184), top: B:49:0x000d }] */
    /* renamed from: ՠ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m7806(defpackage.C4135 r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.m7806(ঀ):void");
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m7807(int i, int i2, int i3, InterfaceC5054 interfaceC5054, AbstractC3415 abstractC3415) throws IOException {
        C4539 c4539M7809 = m7809();
        C3573 c3573M13925 = c4539M7809.m13925();
        for (int i4 = 0; i4 < 21; i4++) {
            m7805(i, i2, interfaceC5054, abstractC3415);
            c4539M7809 = m7808(i2, i3, c4539M7809, c3573M13925);
            if (c4539M7809 == null) {
                return;
            }
            Socket socket = this.f8185;
            if (socket != null) {
                i5.m6241(socket);
            }
            this.f8185 = null;
            this.f8191 = null;
            this.f8190 = null;
            abstractC3415.connectEnd(interfaceC5054, this.f8201.m14514(), this.f8201.m14512(), null);
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final C4539 m7808(int i, int i2, C4539 c4539, C3573 c3573) throws IOException {
        String str = "CONNECT " + i5.m6269(c3573, true) + " HTTP/1.1";
        while (true) {
            BufferedSource bufferedSource = this.f8190;
            if (bufferedSource == null) {
                C3921.m12675();
            }
            BufferedSink bufferedSink = this.f8191;
            if (bufferedSink == null) {
                C3921.m12675();
            }
            C5249 c5249 = new C5249(null, this, bufferedSource, bufferedSink);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            bufferedSource.timeout().timeout(i, timeUnit);
            bufferedSink.timeout().timeout(i2, timeUnit);
            c5249.m15295(c4539.m13920(), str);
            c5249.mo10254();
            C4770.C4771 c4771Mo10257 = c5249.mo10257(false);
            if (c4771Mo10257 == null) {
                C3921.m12675();
            }
            C4770 c4770M14351 = c4771Mo10257.m14367(c4539).m14351();
            c5249.m15294(c4770M14351);
            int iM14334 = c4770M14351.m14334();
            if (iM14334 == 200) {
                if (bufferedSource.getBuffer().exhausted() && bufferedSink.getBuffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iM14334 != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + c4770M14351.m14334());
            }
            C4539 c4539Mo14770 = this.f8201.m14511().m12816().mo14770(this.f8201, c4770M14351);
            if (c4539Mo14770 == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (e0.m5967(HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, C4770.m14329(c4770M14351, HttpHeaders.HEAD_KEY_CONNECTION, null, 2, null), true)) {
                return c4539Mo14770;
            }
            c4539 = c4539Mo14770;
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final C4539 m7809() throws IOException {
        C4539 c4539M13927 = new C4539.C4540().m13934(this.f8201.m14511().m12820()).m13931("CONNECT", null).m13929("Host", i5.m6269(this.f8201.m14511().m12820(), true)).m13929("Proxy-Connection", "Keep-Alive").m13929(HttpHeaders.HEAD_KEY_USER_AGENT, "okhttp/4.8.1").m13927();
        C4539 c4539Mo14770 = this.f8201.m14511().m12816().mo14770(this.f8201, new C4770.C4771().m14367(c4539M13927).m14364(Protocol.HTTP_1_1).m14355(407).m14361("Preemptive Authenticate").m14350(i5.f6765).m14368(-1L).m14365(-1L).m14358("Proxy-Authenticate", "OkHttp-Preemptive").m14351());
        return c4539Mo14770 != null ? c4539Mo14770 : c4539M13927;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m7810(C4135 c4135, int i, InterfaceC5054 interfaceC5054, AbstractC3415 abstractC3415) throws Throwable {
        if (this.f8201.m14511().m12819() != null) {
            abstractC3415.secureConnectStart(interfaceC5054);
            m7806(c4135);
            abstractC3415.secureConnectEnd(interfaceC5054, this.f8187);
            if (this.f8188 == Protocol.HTTP_2) {
                m7828(i);
                return;
            }
            return;
        }
        List<Protocol> listM12814 = this.f8201.m14511().m12814();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!listM12814.contains(protocol)) {
            this.f8186 = this.f8185;
            this.f8188 = Protocol.HTTP_1_1;
        } else {
            this.f8186 = this.f8185;
            this.f8188 = protocol;
            m7828(i);
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final List<Reference<C2503>> m7811() {
        return this.f8198;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final long m7812() {
        return this.f8199;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final boolean m7813() {
        return this.f8192;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final int m7814() {
        return this.f8194;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public Handshake m7815() {
        return this.f8187;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final synchronized void m7816() {
        this.f8195++;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final boolean m7817(C3972 c3972, List<C4799> list) {
        C3921.m12667(c3972, "address");
        if (i5.f6770 && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        if (this.f8198.size() >= this.f8197 || this.f8192 || !this.f8201.m14511().m12812(c3972)) {
            return false;
        }
        if (C3921.m12662(c3972.m12820().m11532(), m7823().m14511().m12820().m11532())) {
            return true;
        }
        if (this.f8189 == null || list == null || !m7824(list) || c3972.m12813() != C4718.f15983 || !m7829(c3972.m12820())) {
            return false;
        }
        try {
            CertificatePinner certificatePinnerM12809 = c3972.m12809();
            if (certificatePinnerM12809 == null) {
                C3921.m12675();
            }
            String strM11532 = c3972.m12820().m11532();
            Handshake handshakeM7815 = m7815();
            if (handshakeM7815 == null) {
                C3921.m12675();
            }
            certificatePinnerM12809.m7711(strM11532, handshakeM7815.m7727());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final boolean m7818(boolean z) {
        long j;
        if (i5.f6770 && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        long jNanoTime = System.nanoTime();
        Socket socket = this.f8185;
        if (socket == null) {
            C3921.m12675();
        }
        Socket socket2 = this.f8186;
        if (socket2 == null) {
            C3921.m12675();
        }
        BufferedSource bufferedSource = this.f8190;
        if (bufferedSource == null) {
            C3921.m12675();
        }
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        C2426 c2426 = this.f8189;
        if (c2426 != null) {
            return c2426.m8953(jNanoTime);
        }
        synchronized (this) {
            j = jNanoTime - this.f8199;
        }
        if (j < 10000000000L || !z) {
            return true;
        }
        return i5.m6260(socket2, bufferedSource);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final boolean m7819() {
        return this.f8189 != null;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final InterfaceC2891 m7820(C5121 c5121, C3739 c3739) throws SocketException {
        C3921.m12667(c5121, "client");
        C3921.m12667(c3739, "chain");
        Socket socket = this.f8186;
        if (socket == null) {
            C3921.m12675();
        }
        BufferedSource bufferedSource = this.f8190;
        if (bufferedSource == null) {
            C3921.m12675();
        }
        BufferedSink bufferedSink = this.f8191;
        if (bufferedSink == null) {
            C3921.m12675();
        }
        C2426 c2426 = this.f8189;
        if (c2426 != null) {
            return new C3553(c5121, this, c3739, c2426);
        }
        socket.setSoTimeout(c3739.m11982());
        Timeout timeout = bufferedSource.timeout();
        long jM11979 = c3739.m11979();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(jM11979, timeUnit);
        bufferedSink.timeout().timeout(c3739.m11981(), timeUnit);
        return new C5249(c5121, this, bufferedSource, bufferedSink);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final synchronized void m7821() {
        this.f8193 = true;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final synchronized void m7822() {
        this.f8192 = true;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public C4799 m7823() {
        return this.f8201;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final boolean m7824(List<C4799> list) {
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C4799 c4799 : list) {
                if (c4799.m14512().type() == Proxy.Type.DIRECT && this.f8201.m14512().type() == Proxy.Type.DIRECT && C3921.m12662(this.f8201.m14514(), c4799.m14514())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final void m7825(long j) {
        this.f8199 = j;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m7826(boolean z) {
        this.f8192 = z;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public Socket m7827() {
        Socket socket = this.f8186;
        if (socket == null) {
            C3921.m12675();
        }
        return socket;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m7828(int i) throws IOException {
        Socket socket = this.f8186;
        if (socket == null) {
            C3921.m12675();
        }
        BufferedSource bufferedSource = this.f8190;
        if (bufferedSource == null) {
            C3921.m12675();
        }
        BufferedSink bufferedSink = this.f8191;
        if (bufferedSink == null) {
            C3921.m12675();
        }
        socket.setSoTimeout(0);
        C2426 c2426M8974 = new C2426.C2428(true, m1.f7970).m8986(socket, this.f8201.m14511().m12820().m11532(), bufferedSource, bufferedSink).m8984(this).m8985(i).m8974();
        this.f8189 = c2426M8974;
        this.f8197 = C2426.f9025.m8987().m14555();
        C2426.m8939(c2426M8974, false, null, 3, null);
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final boolean m7829(C3573 c3573) {
        Handshake handshake;
        if (i5.f6770 && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        C3573 c3573M12820 = this.f8201.m14511().m12820();
        if (c3573.m11537() != c3573M12820.m11537()) {
            return false;
        }
        if (C3921.m12662(c3573.m11532(), c3573M12820.m11532())) {
            return true;
        }
        if (this.f8193 || (handshake = this.f8187) == null) {
            return false;
        }
        if (handshake == null) {
            C3921.m12675();
        }
        return m7802(c3573, handshake);
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final synchronized void m7830(C2503 c2503, IOException iOException) {
        C3921.m12667(c2503, NotificationCompat.CATEGORY_CALL);
        if (iOException instanceof StreamResetException) {
            if (((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                int i = this.f8196 + 1;
                this.f8196 = i;
                if (i > 1) {
                    this.f8192 = true;
                    this.f8194++;
                }
            } else if (((StreamResetException) iOException).errorCode != ErrorCode.CANCEL || !c2503.isCanceled()) {
                this.f8192 = true;
                this.f8194++;
            }
        } else if (!m7819() || (iOException instanceof ConnectionShutdownException)) {
            this.f8192 = true;
            if (this.f8195 == 0) {
                if (iOException != null) {
                    m7804(c2503.m9233(), this.f8201, iOException);
                }
                this.f8194++;
            }
        }
    }
}
