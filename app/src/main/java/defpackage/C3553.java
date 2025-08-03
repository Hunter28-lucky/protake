package defpackage;

import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import defpackage.C4770;
import defpackage.C5207;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import okhttp3.Protocol;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http2.ErrorCode;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* compiled from: Http2ExchangeCodec.kt */
/* renamed from: ڠ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3553 implements InterfaceC2891 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public volatile C4419 f12362;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Protocol f12363;

    /* renamed from: ԩ, reason: contains not printable characters */
    public volatile boolean f12364;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final RealConnection f12365;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C3739 f12366;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C2426 f12367;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final C3554 f12361 = new C3554(null);

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final List<String> f12359 = i5.m6250("connection", "host", HttpHeaders.HEAD_VALUE_CONNECTION_KEEP_ALIVE, "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final List<String> f12360 = i5.m6250("connection", "host", HttpHeaders.HEAD_VALUE_CONNECTION_KEEP_ALIVE, "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* compiled from: Http2ExchangeCodec.kt */
    /* renamed from: ڠ$Ϳ, reason: contains not printable characters */
    public static final class C3554 {
        public C3554() {
        }

        public /* synthetic */ C3554(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final List<C3168> m11497(C4539 c4539) {
            C3921.m12667(c4539, "request");
            C5207 c5207M13920 = c4539.m13920();
            ArrayList arrayList = new ArrayList(c5207M13920.size() + 4);
            arrayList.add(new C3168(C3168.f11236, c4539.m13923()));
            arrayList.add(new C3168(C3168.f11237, C3941.f13581.m12716(c4539.m13925())));
            String strM13919 = c4539.m13919("Host");
            if (strM13919 != null) {
                arrayList.add(new C3168(C3168.f11239, strM13919));
            }
            arrayList.add(new C3168(C3168.f11238, c4539.m13925().m11543()));
            int size = c5207M13920.size();
            for (int i = 0; i < size; i++) {
                String strM15183 = c5207M13920.m15183(i);
                Locale locale = Locale.US;
                C3921.m12663(locale, "Locale.US");
                if (strM15183 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = strM15183.toLowerCase(locale);
                C3921.m12663(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!C3553.f12359.contains(lowerCase) || (C3921.m12662(lowerCase, "te") && C3921.m12662(c5207M13920.m15185(i), "trailers"))) {
                    arrayList.add(new C3168(lowerCase, c5207M13920.m15185(i)));
                }
            }
            return arrayList;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C4770.C4771 m11498(C5207 c5207, Protocol protocol) throws NumberFormatException, IOException {
            C3921.m12667(c5207, "headerBlock");
            C3921.m12667(protocol, "protocol");
            C5207.C5208 c5208 = new C5207.C5208();
            int size = c5207.size();
            k kVarM7170 = null;
            for (int i = 0; i < size; i++) {
                String strM15183 = c5207.m15183(i);
                String strM15185 = c5207.m15185(i);
                if (C3921.m12662(strM15183, ":status")) {
                    kVarM7170 = k.f7814.m7170("HTTP/1.1 " + strM15185);
                } else if (!C3553.f12360.contains(strM15183)) {
                    c5208.m15189(strM15183, strM15185);
                }
            }
            if (kVarM7170 != null) {
                return new C4770.C4771().m14364(protocol).m14355(kVarM7170.f7816).m14361(kVarM7170.f7817).m14359(c5208.m15191());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    public C3553(C5121 c5121, RealConnection realConnection, C3739 c3739, C2426 c2426) {
        C3921.m12667(c5121, "client");
        C3921.m12667(realConnection, "connection");
        C3921.m12667(c3739, "chain");
        C3921.m12667(c2426, "http2Connection");
        this.f12365 = realConnection;
        this.f12366 = c3739;
        this.f12367 = c2426;
        List<Protocol> listM14973 = c5121.m14973();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f12363 = listM14973.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // defpackage.InterfaceC2891
    public void cancel() {
        this.f12364 = true;
        C4419 c4419 = this.f12362;
        if (c4419 != null) {
            c4419.m13618(ErrorCode.CANCEL);
        }
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: Ϳ */
    public Source mo10252(C4770 c4770) {
        C3921.m12667(c4770, "response");
        C4419 c4419 = this.f12362;
        if (c4419 == null) {
            C3921.m12675();
        }
        return c4419.m13628();
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: Ԩ */
    public void mo10253(C4539 c4539) throws IOException {
        C3921.m12667(c4539, "request");
        if (this.f12362 != null) {
            return;
        }
        this.f12362 = this.f12367.m8955(f12361.m11497(c4539), c4539.m13916() != null);
        if (this.f12364) {
            C4419 c4419 = this.f12362;
            if (c4419 == null) {
                C3921.m12675();
            }
            c4419.m13618(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        C4419 c44192 = this.f12362;
        if (c44192 == null) {
            C3921.m12675();
        }
        Timeout timeoutM13634 = c44192.m13634();
        long jM11979 = this.f12366.m11979();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeoutM13634.timeout(jM11979, timeUnit);
        C4419 c44193 = this.f12362;
        if (c44193 == null) {
            C3921.m12675();
        }
        c44193.m13643().timeout(this.f12366.m11981(), timeUnit);
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: ԩ */
    public void mo10254() throws IOException {
        C4419 c4419 = this.f12362;
        if (c4419 == null) {
            C3921.m12675();
        }
        c4419.m13626().close();
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: Ԫ */
    public long mo10255(C4770 c4770) {
        C3921.m12667(c4770, "response");
        if (C4186.m13205(c4770)) {
            return i5.m6249(c4770);
        }
        return 0L;
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: ԫ */
    public Sink mo10256(C4539 c4539, long j) {
        C3921.m12667(c4539, "request");
        C4419 c4419 = this.f12362;
        if (c4419 == null) {
            C3921.m12675();
        }
        return c4419.m13626();
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: Ԭ */
    public C4770.C4771 mo10257(boolean z) throws IOException, NumberFormatException {
        C4419 c4419 = this.f12362;
        if (c4419 == null) {
            C3921.m12675();
        }
        C4770.C4771 c4771M11498 = f12361.m11498(c4419.m13641(), this.f12363);
        if (z && c4771M11498.m14356() == 100) {
            return null;
        }
        return c4771M11498;
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: ԭ */
    public RealConnection mo10258() {
        return this.f12365;
    }

    @Override // defpackage.InterfaceC2891
    /* renamed from: Ԯ */
    public void mo10259() throws IOException {
        this.f12367.flush();
    }
}
