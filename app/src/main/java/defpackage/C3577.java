package defpackage;

import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import defpackage.AbstractC2613;
import defpackage.C2314;
import defpackage.C5207;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* compiled from: MultipartBody.kt */
/* renamed from: ڮ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3577 extends AbstractC2613 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C2314 f12473;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final C2314 f12474;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final C2314 f12475;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final C2314 f12476;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final C2314 f12477;

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final byte[] f12478;

    /* renamed from: ֏, reason: contains not printable characters */
    public static final byte[] f12479;

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final byte[] f12480;

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final C3579 f12481 = new C3579(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C2314 f12482;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public long f12483;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final ByteString f12484;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C2314 f12485;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final List<C3580> f12486;

    /* compiled from: MultipartBody.kt */
    /* renamed from: ڮ$Ԩ, reason: contains not printable characters */
    public static final class C3579 {
        public C3579() {
        }

        public /* synthetic */ C3579(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m11598(StringBuilder sb, String str) {
            C3921.m12667(sb, "$this$appendQuotedString");
            C3921.m12667(str, "key");
            sb.append('\"');
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '\n') {
                    sb.append("%0A");
                } else if (cCharAt == '\r') {
                    sb.append("%0D");
                } else if (cCharAt == '\"') {
                    sb.append("%22");
                } else {
                    sb.append(cCharAt);
                }
            }
            sb.append('\"');
        }
    }

    /* compiled from: MultipartBody.kt */
    /* renamed from: ڮ$Ԫ, reason: contains not printable characters */
    public static final class C3580 {

        /* renamed from: ԩ, reason: contains not printable characters */
        public static final C3581 f12490 = new C3581(null);

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C5207 f12491;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final AbstractC2613 f12492;

        /* compiled from: MultipartBody.kt */
        /* renamed from: ڮ$Ԫ$Ϳ, reason: contains not printable characters */
        public static final class C3581 {
            public C3581() {
            }

            public /* synthetic */ C3581(C4184 c4184) {
                this();
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final C3580 m11603(C5207 c5207, AbstractC2613 abstractC2613) {
                C3921.m12667(abstractC2613, "body");
                C4184 c4184 = null;
                if (!((c5207 != null ? c5207.m15182(HttpHeaders.HEAD_KEY_CONTENT_TYPE) : null) == null)) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
                }
                if ((c5207 != null ? c5207.m15182(HttpHeaders.HEAD_KEY_CONTENT_LENGTH) : null) == null) {
                    return new C3580(c5207, abstractC2613, c4184);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            }

            /* renamed from: Ԩ, reason: contains not printable characters */
            public final C3580 m11604(String str, String str2) {
                C3921.m12667(str, "name");
                C3921.m12667(str2, "value");
                return m11605(str, null, AbstractC2613.C2614.m9555(AbstractC2613.Companion, str2, null, 1, null));
            }

            /* renamed from: ԩ, reason: contains not printable characters */
            public final C3580 m11605(String str, String str2, AbstractC2613 abstractC2613) {
                C3921.m12667(str, "name");
                C3921.m12667(abstractC2613, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                C3579 c3579 = C3577.f12481;
                c3579.m11598(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    c3579.m11598(sb, str2);
                }
                String string = sb.toString();
                C3921.m12663(string, "StringBuilder().apply(builderAction).toString()");
                return m11603(new C5207.C5208().m15190(HttpHeaders.HEAD_KEY_CONTENT_DISPOSITION, string).m15191(), abstractC2613);
            }
        }

        public C3580(C5207 c5207, AbstractC2613 abstractC2613) {
            this.f12491 = c5207;
            this.f12492 = abstractC2613;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final C3580 m11599(String str, String str2) {
            return f12490.m11604(str, str2);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public static final C3580 m11600(String str, String str2, AbstractC2613 abstractC2613) {
            return f12490.m11605(str, str2, abstractC2613);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final AbstractC2613 m11601() {
            return this.f12492;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final C5207 m11602() {
            return this.f12491;
        }

        public /* synthetic */ C3580(C5207 c5207, AbstractC2613 abstractC2613, C4184 c4184) {
            this(c5207, abstractC2613);
        }
    }

    static {
        C2314.C2315 c2315 = C2314.f8797;
        f12473 = c2315.m8688("multipart/mixed");
        f12474 = c2315.m8688("multipart/alternative");
        f12475 = c2315.m8688("multipart/digest");
        f12476 = c2315.m8688("multipart/parallel");
        f12477 = c2315.m8688("multipart/form-data");
        f12478 = new byte[]{(byte) 58, (byte) 32};
        f12479 = new byte[]{(byte) 13, (byte) 10};
        byte b = (byte) 45;
        f12480 = new byte[]{b, b};
    }

    public C3577(ByteString byteString, C2314 c2314, List<C3580> list) {
        C3921.m12667(byteString, "boundaryByteString");
        C3921.m12667(c2314, "type");
        C3921.m12667(list, "parts");
        this.f12484 = byteString;
        this.f12485 = c2314;
        this.f12486 = list;
        this.f12482 = C2314.f8797.m8688(c2314 + "; boundary=" + m11591());
        this.f12483 = -1L;
    }

    @Override // defpackage.AbstractC2613
    public long contentLength() throws IOException {
        long j = this.f12483;
        if (j != -1) {
            return j;
        }
        long jM11593 = m11593(null, true);
        this.f12483 = jM11593;
        return jM11593;
    }

    @Override // defpackage.AbstractC2613
    public C2314 contentType() {
        return this.f12482;
    }

    @Override // defpackage.AbstractC2613
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        C3921.m12667(bufferedSink, "sink");
        m11593(bufferedSink, false);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String m11591() {
        return this.f12484.utf8();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final List<C3580> m11592() {
        return this.f12486;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ԩ, reason: contains not printable characters */
    public final long m11593(BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        if (z) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.f12486.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            C3580 c3580 = this.f12486.get(i);
            C5207 c5207M11602 = c3580.m11602();
            AbstractC2613 abstractC2613M11601 = c3580.m11601();
            if (bufferedSink == null) {
                C3921.m12675();
            }
            bufferedSink.write(f12480);
            bufferedSink.write(this.f12484);
            bufferedSink.write(f12479);
            if (c5207M11602 != null) {
                int size2 = c5207M11602.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    bufferedSink.writeUtf8(c5207M11602.m15183(i2)).write(f12478).writeUtf8(c5207M11602.m15185(i2)).write(f12479);
                }
            }
            C2314 c2314ContentType = abstractC2613M11601.contentType();
            if (c2314ContentType != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(c2314ContentType.toString()).write(f12479);
            }
            long jContentLength = abstractC2613M11601.contentLength();
            if (jContentLength != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(jContentLength).write(f12479);
            } else if (z) {
                if (buffer == 0) {
                    C3921.m12675();
                }
                buffer.clear();
                return -1L;
            }
            byte[] bArr = f12479;
            bufferedSink.write(bArr);
            if (z) {
                j += jContentLength;
            } else {
                abstractC2613M11601.writeTo(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        if (bufferedSink == null) {
            C3921.m12675();
        }
        byte[] bArr2 = f12480;
        bufferedSink.write(bArr2);
        bufferedSink.write(this.f12484);
        bufferedSink.write(bArr2);
        bufferedSink.write(f12479);
        if (!z) {
            return j;
        }
        if (buffer == 0) {
            C3921.m12675();
        }
        long size3 = j + buffer.size();
        buffer.clear();
        return size3;
    }

    /* compiled from: MultipartBody.kt */
    /* renamed from: ڮ$Ϳ, reason: contains not printable characters */
    public static final class C3578 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ByteString f12487;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public C2314 f12488;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final List<C3580> f12489;

        public C3578() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public C3578(String str) {
            C3921.m12667(str, "boundary");
            this.f12487 = ByteString.Companion.encodeUtf8(str);
            this.f12488 = C3577.f12473;
            this.f12489 = new ArrayList();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C3578 m11594(C5207 c5207, AbstractC2613 abstractC2613) {
            C3921.m12667(abstractC2613, "body");
            m11595(C3580.f12490.m11603(c5207, abstractC2613));
            return this;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C3578 m11595(C3580 c3580) {
            C3921.m12667(c3580, "part");
            this.f12489.add(c3580);
            return this;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C3577 m11596() {
            if (!this.f12489.isEmpty()) {
                return new C3577(this.f12487, this.f12488, i5.m6271(this.f12489));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final C3578 m11597(C2314 c2314) {
            C3921.m12667(c2314, "type");
            if (C3921.m12662(c2314.m8687(), "multipart")) {
                this.f12488 = c2314;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + c2314).toString());
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ C3578(String str, int i, C4184 c4184) {
            if ((i & 1) != 0) {
                str = UUID.randomUUID().toString();
                C3921.m12663(str, "UUID.randomUUID().toString()");
            }
            this(str);
        }
    }
}
