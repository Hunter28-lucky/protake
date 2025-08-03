package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import defpackage.C4770;
import defpackage.C5001;
import defpackage.C5207;
import defpackage.InterfaceC2818;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* compiled from: CacheInterceptor.kt */
/* renamed from: ɿ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2638 implements InterfaceC2818 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C2639 f9816 = new C2639(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C3661 f9817;

    /* compiled from: CacheInterceptor.kt */
    /* renamed from: ɿ$Ϳ, reason: contains not printable characters */
    public static final class C2639 {
        public C2639() {
        }

        public /* synthetic */ C2639(C4184 c4184) {
            this();
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C5207 m9732(C5207 c5207, C5207 c52072) {
            C5207.C5208 c5208 = new C5207.C5208();
            int size = c5207.size();
            for (int i = 0; i < size; i++) {
                String strM15183 = c5207.m15183(i);
                String strM15185 = c5207.m15185(i);
                if ((!e0.m5967("Warning", strM15183, true) || !e0.m5980(strM15185, "1", false, 2, null)) && (m9733(strM15183) || !m9734(strM15183) || c52072.m15182(strM15183) == null)) {
                    c5208.m15189(strM15183, strM15185);
                }
            }
            int size2 = c52072.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String strM151832 = c52072.m15183(i2);
                if (!m9733(strM151832) && m9734(strM151832)) {
                    c5208.m15189(strM151832, c52072.m15185(i2));
                }
            }
            return c5208.m15191();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final boolean m9733(String str) {
            return e0.m5967(HttpHeaders.HEAD_KEY_CONTENT_LENGTH, str, true) || e0.m5967(HttpHeaders.HEAD_KEY_CONTENT_ENCODING, str, true) || e0.m5967(HttpHeaders.HEAD_KEY_CONTENT_TYPE, str, true);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final boolean m9734(String str) {
            return (e0.m5967(HttpHeaders.HEAD_KEY_CONNECTION, str, true) || e0.m5967("Keep-Alive", str, true) || e0.m5967("Proxy-Authenticate", str, true) || e0.m5967("Proxy-Authorization", str, true) || e0.m5967("TE", str, true) || e0.m5967("Trailers", str, true) || e0.m5967("Transfer-Encoding", str, true) || e0.m5967("Upgrade", str, true)) ? false : true;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C4770 m9735(C4770 c4770) {
            return (c4770 != null ? c4770.m14330() : null) != null ? c4770.m14343().m14350(null).m14351() : c4770;
        }
    }

    /* compiled from: CacheInterceptor.kt */
    /* renamed from: ɿ$Ԩ, reason: contains not printable characters */
    public static final class C2640 implements Source {

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean f9818;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ BufferedSource f9819;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC2895 f9820;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ BufferedSink f9821;

        public C2640(BufferedSource bufferedSource, InterfaceC2895 interfaceC2895, BufferedSink bufferedSink) {
            this.f9819 = bufferedSource;
            this.f9820 = interfaceC2895;
            this.f9821 = bufferedSink;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f9818 && !i5.m6246(this, 100, TimeUnit.MILLISECONDS)) {
                this.f9818 = true;
                this.f9820.abort();
            }
            this.f9819.close();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            C3921.m12667(buffer, "sink");
            try {
                long j2 = this.f9819.read(buffer, j);
                if (j2 != -1) {
                    buffer.copyTo(this.f9821.getBuffer(), buffer.size() - j2, j2);
                    this.f9821.emitCompleteSegments();
                    return j2;
                }
                if (!this.f9818) {
                    this.f9818 = true;
                    this.f9821.close();
                }
                return -1L;
            } catch (IOException e2) {
                if (!this.f9818) {
                    this.f9818 = true;
                    this.f9820.abort();
                }
                throw e2;
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.f9819.timeout();
        }
    }

    public C2638(C3661 c3661) {
        this.f9817 = c3661;
    }

    @Override // defpackage.InterfaceC2818
    public C4770 intercept(InterfaceC2818.InterfaceC2819 interfaceC2819) throws IOException {
        AbstractC3415 abstractC3415M9235;
        AbstractC4809 abstractC4809M14330;
        AbstractC4809 abstractC4809M143302;
        C3921.m12667(interfaceC2819, "chain");
        InterfaceC5054 interfaceC5054Call = interfaceC2819.call();
        C3661 c3661 = this.f9817;
        C4770 c4770M11753 = c3661 != null ? c3661.m11753(interfaceC2819.request()) : null;
        C5001 c5001M14792 = new C5001.C5003(System.currentTimeMillis(), interfaceC2819.request(), c4770M11753).m14792();
        C4539 c4539M14789 = c5001M14792.m14789();
        C4770 c4770M14788 = c5001M14792.m14788();
        C3661 c36612 = this.f9817;
        if (c36612 != null) {
            c36612.m11761(c5001M14792);
        }
        C2503 c2503 = (C2503) (interfaceC5054Call instanceof C2503 ? interfaceC5054Call : null);
        if (c2503 == null || (abstractC3415M9235 = c2503.m9235()) == null) {
            abstractC3415M9235 = AbstractC3415.NONE;
        }
        if (c4770M11753 != null && c4770M14788 == null && (abstractC4809M143302 = c4770M11753.m14330()) != null) {
            i5.m6240(abstractC4809M143302);
        }
        if (c4539M14789 == null && c4770M14788 == null) {
            C4770 c4770M14351 = new C4770.C4771().m14367(interfaceC2819.request()).m14364(Protocol.HTTP_1_1).m14355(TypedValues.PositionType.TYPE_PERCENT_HEIGHT).m14361("Unsatisfiable Request (only-if-cached)").m14350(i5.f6765).m14368(-1L).m14365(System.currentTimeMillis()).m14351();
            abstractC3415M9235.satisfactionFailure(interfaceC5054Call, c4770M14351);
            return c4770M14351;
        }
        if (c4539M14789 == null) {
            if (c4770M14788 == null) {
                C3921.m12675();
            }
            C4770 c4770M143512 = c4770M14788.m14343().m14352(f9816.m9735(c4770M14788)).m14351();
            abstractC3415M9235.cacheHit(interfaceC5054Call, c4770M143512);
            return c4770M143512;
        }
        if (c4770M14788 != null) {
            abstractC3415M9235.cacheConditionalHit(interfaceC5054Call, c4770M14788);
        } else if (this.f9817 != null) {
            abstractC3415M9235.cacheMiss(interfaceC5054Call);
        }
        try {
            C4770 c4770Mo10160 = interfaceC2819.mo10160(c4539M14789);
            if (c4770Mo10160 == null && c4770M11753 != null && abstractC4809M14330 != null) {
            }
            if (c4770M14788 != null) {
                if (c4770Mo10160 != null && c4770Mo10160.m14334() == 304) {
                    C4770.C4771 c4771M14343 = c4770M14788.m14343();
                    C2639 c2639 = f9816;
                    C4770 c4770M143513 = c4771M14343.m14359(c2639.m9732(c4770M14788.m14339(), c4770Mo10160.m14339())).m14368(c4770Mo10160.m14348()).m14365(c4770Mo10160.m14346()).m14352(c2639.m9735(c4770M14788)).m14362(c2639.m9735(c4770Mo10160)).m14351();
                    AbstractC4809 abstractC4809M143303 = c4770Mo10160.m14330();
                    if (abstractC4809M143303 == null) {
                        C3921.m12675();
                    }
                    abstractC4809M143303.close();
                    C3661 c36613 = this.f9817;
                    if (c36613 == null) {
                        C3921.m12675();
                    }
                    c36613.m11760();
                    this.f9817.m11762(c4770M14788, c4770M143513);
                    abstractC3415M9235.cacheHit(interfaceC5054Call, c4770M143513);
                    return c4770M143513;
                }
                AbstractC4809 abstractC4809M143304 = c4770M14788.m14330();
                if (abstractC4809M143304 != null) {
                    i5.m6240(abstractC4809M143304);
                }
            }
            if (c4770Mo10160 == null) {
                C3921.m12675();
            }
            C4770.C4771 c4771M143432 = c4770Mo10160.m14343();
            C2639 c26392 = f9816;
            C4770 c4770M143514 = c4771M143432.m14352(c26392.m9735(c4770M14788)).m14362(c26392.m9735(c4770Mo10160)).m14351();
            if (this.f9817 != null) {
                if (C4186.m13205(c4770M143514) && C5001.f16754.m14790(c4770M143514, c4539M14789)) {
                    C4770 c4770M9729 = m9729(this.f9817.m11756(c4770M143514), c4770M143514);
                    if (c4770M14788 != null) {
                        abstractC3415M9235.cacheMiss(interfaceC5054Call);
                    }
                    return c4770M9729;
                }
                if (C3737.f12943.m11971(c4539M14789.m13923())) {
                    try {
                        this.f9817.m11757(c4539M14789);
                    } catch (IOException unused) {
                    }
                }
            }
            return c4770M143514;
        } finally {
            if (c4770M11753 != null && (abstractC4809M14330 = c4770M11753.m14330()) != null) {
                i5.m6240(abstractC4809M14330);
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C4770 m9729(InterfaceC2895 interfaceC2895, C4770 c4770) throws IOException {
        if (interfaceC2895 == null) {
            return c4770;
        }
        Sink sinkMo10264 = interfaceC2895.mo10264();
        AbstractC4809 abstractC4809M14330 = c4770.m14330();
        if (abstractC4809M14330 == null) {
            C3921.m12675();
        }
        C2640 c2640 = new C2640(abstractC4809M14330.source(), interfaceC2895, Okio.buffer(sinkMo10264));
        return c4770.m14343().m14350(new C4829(C4770.m14329(c4770, HttpHeaders.HEAD_KEY_CONTENT_TYPE, null, 2, null), c4770.m14330().contentLength(), Okio.buffer(c2640))).m14351();
    }
}
