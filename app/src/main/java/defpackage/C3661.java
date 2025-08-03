package defpackage;

import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.google.android.gms.common.internal.ImagesContract;
import defpackage.C2708;
import defpackage.C4539;
import defpackage.C4770;
import defpackage.C5207;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.TypeCastException;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.TlsVersion;
import okhttp3.internal.cache.DiskLruCache;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* compiled from: Cache.kt */
/* renamed from: ܙ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3661 implements Closeable, Flushable {

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final C3664 f12680 = new C3664(null);

    /* renamed from: ԫ, reason: contains not printable characters */
    public final DiskLruCache f12681;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f12682;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f12683;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f12684;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f12685;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f12686;

    /* compiled from: Cache.kt */
    /* renamed from: ܙ$Ϳ, reason: contains not printable characters */
    public static final class C3662 extends AbstractC4809 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final BufferedSource f12687;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final DiskLruCache.C2215 f12688;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final String f12689;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final String f12690;

        /* compiled from: Cache.kt */
        /* renamed from: ܙ$Ϳ$Ϳ, reason: contains not printable characters */
        public static final class C3663 extends ForwardingSource {

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ Source f12692;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C3663(Source source, Source source2) {
                super(source2);
                this.f12692 = source;
            }

            @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                C3662.this.m11763().close();
                super.close();
            }
        }

        public C3662(DiskLruCache.C2215 c2215, String str, String str2) {
            C3921.m12667(c2215, "snapshot");
            this.f12688 = c2215;
            this.f12689 = str;
            this.f12690 = str2;
            Source sourceM7796 = c2215.m7796(1);
            this.f12687 = Okio.buffer(new C3663(sourceM7796, sourceM7796));
        }

        @Override // defpackage.AbstractC4809
        public long contentLength() {
            String str = this.f12690;
            if (str != null) {
                return i5.m6273(str, -1L);
            }
            return -1L;
        }

        @Override // defpackage.AbstractC4809
        public C2314 contentType() {
            String str = this.f12689;
            if (str != null) {
                return C2314.f8797.m8689(str);
            }
            return null;
        }

        @Override // defpackage.AbstractC4809
        public BufferedSource source() {
            return this.f12687;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final DiskLruCache.C2215 m11763() {
            return this.f12688;
        }
    }

    /* compiled from: Cache.kt */
    /* renamed from: ܙ$Ԩ, reason: contains not printable characters */
    public static final class C3664 {
        public C3664() {
        }

        public /* synthetic */ C3664(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final boolean m11764(C4770 c4770) {
            C3921.m12667(c4770, "$this$hasVaryAll");
            return m11767(c4770.m14339()).contains("*");
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final String m11765(C3573 c3573) {
            C3921.m12667(c3573, ImagesContract.URL);
            return ByteString.Companion.encodeUtf8(c3573.toString()).md5().hex();
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final int m11766(BufferedSource bufferedSource) throws IOException {
            C3921.m12667(bufferedSource, "source");
            try {
                long decimalLong = bufferedSource.readDecimalLong();
                String utf8LineStrict = bufferedSource.readUtf8LineStrict();
                if (decimalLong >= 0 && decimalLong <= Integer.MAX_VALUE) {
                    if (!(utf8LineStrict.length() > 0)) {
                        return (int) decimalLong;
                    }
                }
                throw new IOException("expected an int but was \"" + decimalLong + utf8LineStrict + '\"');
            } catch (NumberFormatException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final Set<String> m11767(C5207 c5207) {
            int size = c5207.size();
            TreeSet treeSet = null;
            for (int i = 0; i < size; i++) {
                if (e0.m5967("Vary", c5207.m15183(i), true)) {
                    String strM15185 = c5207.m15185(i);
                    if (treeSet == null) {
                        treeSet = new TreeSet(e0.m5968(t.f8531));
                    }
                    for (String str : StringsKt__StringsKt.m7305(strM15185, new char[]{','}, false, 0, 6, null)) {
                        if (str == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        treeSet.add(StringsKt__StringsKt.m7319(str).toString());
                    }
                }
            }
            return treeSet != null ? treeSet : C5094.m14922();
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C5207 m11768(C5207 c5207, C5207 c52072) {
            Set<String> setM11767 = m11767(c52072);
            if (setM11767.isEmpty()) {
                return i5.f6764;
            }
            C5207.C5208 c5208 = new C5207.C5208();
            int size = c5207.size();
            for (int i = 0; i < size; i++) {
                String strM15183 = c5207.m15183(i);
                if (setM11767.contains(strM15183)) {
                    c5208.m15187(strM15183, c5207.m15185(i));
                }
            }
            return c5208.m15191();
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C5207 m11769(C4770 c4770) {
            C3921.m12667(c4770, "$this$varyHeaders");
            C4770 c4770M14342 = c4770.m14342();
            if (c4770M14342 == null) {
                C3921.m12675();
            }
            return m11768(c4770M14342.m14347().m13920(), c4770.m14339());
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final boolean m11770(C4770 c4770, C5207 c5207, C4539 c4539) {
            C3921.m12667(c4770, "cachedResponse");
            C3921.m12667(c5207, "cachedRequest");
            C3921.m12667(c4539, "newRequest");
            Set<String> setM11767 = m11767(c4770.m14339());
            if ((setM11767 instanceof Collection) && setM11767.isEmpty()) {
                return true;
            }
            for (String str : setM11767) {
                if (!C3921.m12662(c5207.m15186(str), c4539.m13921(str))) {
                    return false;
                }
            }
            return true;
        }
    }

    /* compiled from: Cache.kt */
    /* renamed from: ܙ$Ԭ, reason: contains not printable characters */
    public final class C3667 implements InterfaceC2895 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Sink f12706;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final Sink f12707;

        /* renamed from: ԩ, reason: contains not printable characters */
        public boolean f12708;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final DiskLruCache.Editor f12709;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3661 f12710;

        /* compiled from: Cache.kt */
        /* renamed from: ܙ$Ԭ$Ϳ, reason: contains not printable characters */
        public static final class C3668 extends ForwardingSink {
            public C3668(Sink sink) {
                super(sink);
            }

            @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                synchronized (C3667.this.f12710) {
                    if (C3667.this.m11778()) {
                        return;
                    }
                    C3667.this.m11779(true);
                    C3661 c3661 = C3667.this.f12710;
                    c3661.m11759(c3661.m11755() + 1);
                    super.close();
                    C3667.this.f12709.m7770();
                }
            }
        }

        public C3667(C3661 c3661, DiskLruCache.Editor editor) {
            C3921.m12667(editor, "editor");
            this.f12710 = c3661;
            this.f12709 = editor;
            Sink sinkM7774 = editor.m7774(1);
            this.f12706 = sinkM7774;
            this.f12707 = new C3668(sinkM7774);
        }

        @Override // defpackage.InterfaceC2895
        public void abort() throws IOException {
            synchronized (this.f12710) {
                if (this.f12708) {
                    return;
                }
                this.f12708 = true;
                C3661 c3661 = this.f12710;
                c3661.m11758(c3661.m11754() + 1);
                i5.m6240(this.f12706);
                try {
                    this.f12709.m7769();
                } catch (IOException unused) {
                }
            }
        }

        @Override // defpackage.InterfaceC2895
        /* renamed from: Ϳ */
        public Sink mo10264() {
            return this.f12707;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final boolean m11778() {
            return this.f12708;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final void m11779(boolean z) {
            this.f12708 = z;
        }
    }

    public C3661(File file, long j, InterfaceC2635 interfaceC2635) {
        C3921.m12667(file, "directory");
        C3921.m12667(interfaceC2635, "fileSystem");
        this.f12681 = new DiskLruCache(interfaceC2635, file, 201105, 2, j, m1.f7970);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12681.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f12681.flush();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m11752(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.m7769();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C4770 m11753(C4539 c4539) throws IOException {
        C3921.m12667(c4539, "request");
        try {
            DiskLruCache.C2215 c2215M7751 = this.f12681.m7751(f12680.m11765(c4539.m13925()));
            if (c2215M7751 != null) {
                try {
                    C3665 c3665 = new C3665(c2215M7751.m7796(0));
                    C4770 c4770M11774 = c3665.m11774(c2215M7751);
                    if (c3665.m11772(c4539, c4770M11774)) {
                        return c4770M11774;
                    }
                    AbstractC4809 abstractC4809M14330 = c4770M11774.m14330();
                    if (abstractC4809M14330 != null) {
                        i5.m6240(abstractC4809M14330);
                    }
                    return null;
                } catch (IOException unused) {
                    i5.m6240(c2215M7751);
                }
            }
        } catch (IOException unused2) {
        }
        return null;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int m11754() {
        return this.f12683;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int m11755() {
        return this.f12682;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2895 m11756(C4770 c4770) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        DiskLruCache.Editor editorM7746;
        C3921.m12667(c4770, "response");
        String strM13923 = c4770.m14347().m13923();
        if (C3737.f12943.m11971(c4770.m14347().m13923())) {
            try {
                m11757(c4770.m14347());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!C3921.m12662(strM13923, "GET")) {
            return null;
        }
        C3664 c3664 = f12680;
        if (c3664.m11764(c4770)) {
            return null;
        }
        C3665 c3665 = new C3665(c4770);
        try {
            editorM7746 = DiskLruCache.m7746(this.f12681, c3664.m11765(c4770.m14347().m13925()), 0L, 2, null);
            if (editorM7746 == null) {
                return null;
            }
            try {
                c3665.m11776(editorM7746);
                return new C3667(this, editorM7746);
            } catch (IOException unused2) {
                m11752(editorM7746);
                return null;
            }
        } catch (IOException unused3) {
            editorM7746 = null;
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m11757(C4539 c4539) throws IOException {
        C3921.m12667(c4539, "request");
        this.f12681.m7763(f12680.m11765(c4539.m13925()));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m11758(int i) {
        this.f12683 = i;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m11759(int i) {
        this.f12682 = i;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final synchronized void m11760() {
        this.f12685++;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final synchronized void m11761(C5001 c5001) {
        C3921.m12667(c5001, "cacheStrategy");
        this.f12686++;
        if (c5001.m14789() != null) {
            this.f12684++;
        } else if (c5001.m14788() != null) {
            this.f12685++;
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m11762(C4770 c4770, C4770 c47702) {
        C3921.m12667(c4770, "cached");
        C3921.m12667(c47702, "network");
        C3665 c3665 = new C3665(c47702);
        AbstractC4809 abstractC4809M14330 = c4770.m14330();
        if (abstractC4809M14330 == null) {
            throw new TypeCastException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        }
        DiskLruCache.Editor editorM7795 = null;
        try {
            editorM7795 = ((C3662) abstractC4809M14330).m11763().m7795();
            if (editorM7795 != null) {
                c3665.m11776(editorM7795);
                editorM7795.m7770();
            }
        } catch (IOException unused) {
            m11752(editorM7795);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C3661(File file, long j) {
        this(file, j, InterfaceC2635.f9813);
        C3921.m12667(file, "directory");
    }

    /* compiled from: Cache.kt */
    /* renamed from: ܙ$Ԫ, reason: contains not printable characters */
    public static final class C3665 {

        /* renamed from: ֈ, reason: contains not printable characters */
        public static final String f12693;

        /* renamed from: ֏, reason: contains not printable characters */
        public static final String f12694;

        /* renamed from: ׯ, reason: contains not printable characters */
        public static final C3666 f12695 = new C3666(null);

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final String f12696;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C5207 f12697;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final String f12698;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final Protocol f12699;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int f12700;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final String f12701;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final C5207 f12702;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final Handshake f12703;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final long f12704;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final long f12705;

        /* compiled from: Cache.kt */
        /* renamed from: ܙ$Ԫ$Ϳ, reason: contains not printable characters */
        public static final class C3666 {
            public C3666() {
            }

            public /* synthetic */ C3666(C4184 c4184) {
                this();
            }
        }

        static {
            StringBuilder sb = new StringBuilder();
            C2708.C2709 c2709 = C2708.f10025;
            sb.append(c2709.m9964().m9952());
            sb.append("-Sent-Millis");
            f12693 = sb.toString();
            f12694 = c2709.m9964().m9952() + "-Received-Millis";
        }

        public C3665(Source source) throws IOException {
            C3921.m12667(source, "rawSource");
            try {
                BufferedSource bufferedSourceBuffer = Okio.buffer(source);
                this.f12696 = bufferedSourceBuffer.readUtf8LineStrict();
                this.f12698 = bufferedSourceBuffer.readUtf8LineStrict();
                C5207.C5208 c5208 = new C5207.C5208();
                int iM11766 = C3661.f12680.m11766(bufferedSourceBuffer);
                for (int i = 0; i < iM11766; i++) {
                    c5208.m15188(bufferedSourceBuffer.readUtf8LineStrict());
                }
                this.f12697 = c5208.m15191();
                k kVarM7170 = k.f7814.m7170(bufferedSourceBuffer.readUtf8LineStrict());
                this.f12699 = kVarM7170.f7815;
                this.f12700 = kVarM7170.f7816;
                this.f12701 = kVarM7170.f7817;
                C5207.C5208 c52082 = new C5207.C5208();
                int iM117662 = C3661.f12680.m11766(bufferedSourceBuffer);
                for (int i2 = 0; i2 < iM117662; i2++) {
                    c52082.m15188(bufferedSourceBuffer.readUtf8LineStrict());
                }
                String str = f12693;
                String strM15192 = c52082.m15192(str);
                String str2 = f12694;
                String strM151922 = c52082.m15192(str2);
                c52082.m15194(str);
                c52082.m15194(str2);
                this.f12704 = strM15192 != null ? Long.parseLong(strM15192) : 0L;
                this.f12705 = strM151922 != null ? Long.parseLong(strM151922) : 0L;
                this.f12702 = c52082.m15191();
                if (m11771()) {
                    String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
                    if (utf8LineStrict.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + utf8LineStrict + '\"');
                    }
                    this.f12703 = Handshake.f8108.m7730(!bufferedSourceBuffer.exhausted() ? TlsVersion.f8127.m7737(bufferedSourceBuffer.readUtf8LineStrict()) : TlsVersion.SSL_3_0, C2553.f9551.m9405(bufferedSourceBuffer.readUtf8LineStrict()), m11773(bufferedSourceBuffer), m11773(bufferedSourceBuffer));
                } else {
                    this.f12703 = null;
                }
            } finally {
                source.close();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final boolean m11771() {
            return e0.m5980(this.f12696, "https://", false, 2, null);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean m11772(C4539 c4539, C4770 c4770) {
            C3921.m12667(c4539, "request");
            C3921.m12667(c4770, "response");
            return C3921.m12662(this.f12696, c4539.m13925().toString()) && C3921.m12662(this.f12698, c4539.m13923()) && C3661.f12680.m11770(c4770, this.f12697, c4539);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final List<Certificate> m11773(BufferedSource bufferedSource) throws IOException, CertificateException {
            int iM11766 = C3661.f12680.m11766(bufferedSource);
            if (iM11766 == -1) {
                return C3131.m10712();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(iM11766);
                for (int i = 0; i < iM11766; i++) {
                    String utf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    ByteString byteStringDecodeBase64 = ByteString.Companion.decodeBase64(utf8LineStrict);
                    if (byteStringDecodeBase64 == null) {
                        C3921.m12675();
                    }
                    buffer.write(byteStringDecodeBase64);
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final C4770 m11774(DiskLruCache.C2215 c2215) {
            C3921.m12667(c2215, "snapshot");
            String strM15182 = this.f12702.m15182(HttpHeaders.HEAD_KEY_CONTENT_TYPE);
            String strM151822 = this.f12702.m15182(HttpHeaders.HEAD_KEY_CONTENT_LENGTH);
            return new C4770.C4771().m14367(new C4539.C4540().m13935(this.f12696).m13931(this.f12698, null).m13930(this.f12697).m13927()).m14364(this.f12699).m14355(this.f12700).m14361(this.f12701).m14359(this.f12702).m14350(new C3662(c2215, strM15182, strM151822)).m14357(this.f12703).m14368(this.f12704).m14365(this.f12705).m14351();
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final void m11775(BufferedSink bufferedSink, List<? extends Certificate> list) throws IOException, CertificateEncodingException {
            try {
                bufferedSink.writeDecimalLong(list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    byte[] encoded = list.get(i).getEncoded();
                    ByteString.Companion companion = ByteString.Companion;
                    C3921.m12663(encoded, "bytes");
                    bufferedSink.writeUtf8(ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final void m11776(DiskLruCache.Editor editor) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
            C3921.m12667(editor, "editor");
            BufferedSink bufferedSinkBuffer = Okio.buffer(editor.m7774(0));
            try {
                bufferedSinkBuffer.writeUtf8(this.f12696).writeByte(10);
                bufferedSinkBuffer.writeUtf8(this.f12698).writeByte(10);
                bufferedSinkBuffer.writeDecimalLong(this.f12697.size()).writeByte(10);
                int size = this.f12697.size();
                for (int i = 0; i < size; i++) {
                    bufferedSinkBuffer.writeUtf8(this.f12697.m15183(i)).writeUtf8(": ").writeUtf8(this.f12697.m15185(i)).writeByte(10);
                }
                bufferedSinkBuffer.writeUtf8(new k(this.f12699, this.f12700, this.f12701).toString()).writeByte(10);
                bufferedSinkBuffer.writeDecimalLong(this.f12702.size() + 2).writeByte(10);
                int size2 = this.f12702.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    bufferedSinkBuffer.writeUtf8(this.f12702.m15183(i2)).writeUtf8(": ").writeUtf8(this.f12702.m15185(i2)).writeByte(10);
                }
                bufferedSinkBuffer.writeUtf8(f12693).writeUtf8(": ").writeDecimalLong(this.f12704).writeByte(10);
                bufferedSinkBuffer.writeUtf8(f12694).writeUtf8(": ").writeDecimalLong(this.f12705).writeByte(10);
                if (m11771()) {
                    bufferedSinkBuffer.writeByte(10);
                    Handshake handshake = this.f12703;
                    if (handshake == null) {
                        C3921.m12675();
                    }
                    bufferedSinkBuffer.writeUtf8(handshake.m7724().m9402()).writeByte(10);
                    m11775(bufferedSinkBuffer, this.f12703.m7727());
                    m11775(bufferedSinkBuffer, this.f12703.m7726());
                    bufferedSinkBuffer.writeUtf8(this.f12703.m7728().m7736()).writeByte(10);
                }
                i4 i4Var = i4.f6762;
                C3494.m11412(bufferedSinkBuffer, null);
            } finally {
            }
        }

        public C3665(C4770 c4770) {
            C3921.m12667(c4770, "response");
            this.f12696 = c4770.m14347().m13925().toString();
            this.f12697 = C3661.f12680.m11769(c4770);
            this.f12698 = c4770.m14347().m13923();
            this.f12699 = c4770.m14345();
            this.f12700 = c4770.m14334();
            this.f12701 = c4770.m14341();
            this.f12702 = c4770.m14339();
            this.f12703 = c4770.m14336();
            this.f12704 = c4770.m14348();
            this.f12705 = c4770.m14346();
        }
    }
}
