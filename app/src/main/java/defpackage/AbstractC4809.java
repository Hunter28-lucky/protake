package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* compiled from: ResponseBody.kt */
/* renamed from: ඦ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC4809 implements Closeable {
    public static final C4811 Companion = new C4811(null);
    private Reader reader;

    /* compiled from: ResponseBody.kt */
    /* renamed from: ඦ$Ϳ, reason: contains not printable characters */
    public static final class C4810 extends Reader {

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean f16289;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Reader f16290;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final BufferedSource f16291;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final Charset f16292;

        public C4810(BufferedSource bufferedSource, Charset charset) {
            C3921.m12667(bufferedSource, "source");
            C3921.m12667(charset, "charset");
            this.f16291 = bufferedSource;
            this.f16292 = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f16289 = true;
            Reader reader = this.f16290;
            if (reader != null) {
                reader.close();
            } else {
                this.f16291.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            C3921.m12667(cArr, "cbuf");
            if (this.f16289) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.f16290;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.f16291.inputStream(), i5.m6262(this.f16291, this.f16292));
                this.f16290 = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i, i2);
        }
    }

    /* compiled from: ResponseBody.kt */
    /* renamed from: ඦ$Ԩ, reason: contains not printable characters */
    public static final class C4811 {

        /* compiled from: ResponseBody.kt */
        /* renamed from: ඦ$Ԩ$Ϳ, reason: contains not printable characters */
        public static final class C4812 extends AbstractC4809 {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ BufferedSource f16293;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ C2314 f16294;

            /* renamed from: ԭ, reason: contains not printable characters */
            public final /* synthetic */ long f16295;

            public C4812(BufferedSource bufferedSource, C2314 c2314, long j) {
                this.f16293 = bufferedSource;
                this.f16294 = c2314;
                this.f16295 = j;
            }

            @Override // defpackage.AbstractC4809
            public long contentLength() {
                return this.f16295;
            }

            @Override // defpackage.AbstractC4809
            public C2314 contentType() {
                return this.f16294;
            }

            @Override // defpackage.AbstractC4809
            public BufferedSource source() {
                return this.f16293;
            }
        }

        public C4811() {
        }

        public /* synthetic */ C4811(C4184 c4184) {
            this();
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public static /* synthetic */ AbstractC4809 m14531(C4811 c4811, byte[] bArr, C2314 c2314, int i, Object obj) {
            if ((i & 1) != 0) {
                c2314 = null;
            }
            return c4811.m14539(bArr, c2314);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final AbstractC4809 m14532(C2314 c2314, long j, BufferedSource bufferedSource) {
            C3921.m12667(bufferedSource, "content");
            return m14537(bufferedSource, c2314, j);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final AbstractC4809 m14533(C2314 c2314, String str) {
            C3921.m12667(str, "content");
            return m14536(str, c2314);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final AbstractC4809 m14534(C2314 c2314, ByteString byteString) {
            C3921.m12667(byteString, "content");
            return m14538(byteString, c2314);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final AbstractC4809 m14535(C2314 c2314, byte[] bArr) {
            C3921.m12667(bArr, "content");
            return m14539(bArr, c2314);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC4809 m14536(String str, C2314 c2314) {
            C3921.m12667(str, "$this$toResponseBody");
            Charset charset = C5241.f17365;
            if (c2314 != null) {
                Charset charsetM8682 = C2314.m8682(c2314, null, 1, null);
                if (charsetM8682 == null) {
                    c2314 = C2314.f8797.m8689(c2314 + "; charset=utf-8");
                } else {
                    charset = charsetM8682;
                }
            }
            Buffer bufferWriteString = new Buffer().writeString(str, charset);
            return m14537(bufferWriteString, c2314, bufferWriteString.size());
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AbstractC4809 m14537(BufferedSource bufferedSource, C2314 c2314, long j) {
            C3921.m12667(bufferedSource, "$this$asResponseBody");
            return new C4812(bufferedSource, c2314, j);
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final AbstractC4809 m14538(ByteString byteString, C2314 c2314) {
            C3921.m12667(byteString, "$this$toResponseBody");
            return m14537(new Buffer().write(byteString), c2314, byteString.size());
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final AbstractC4809 m14539(byte[] bArr, C2314 c2314) {
            C3921.m12667(bArr, "$this$toResponseBody");
            return m14537(new Buffer().write(bArr), c2314, bArr.length);
        }
    }

    private final Charset charset() {
        Charset charsetM8684;
        C2314 c2314ContentType = contentType();
        return (c2314ContentType == null || (charsetM8684 = c2314ContentType.m8684(C5241.f17365)) == null) ? C5241.f17365 : charsetM8684;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    private final <T> T consumeSource(InterfaceC2392<? super BufferedSource, ? extends T> interfaceC2392, InterfaceC2392<? super T, Integer> interfaceC23922) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        long jContentLength = contentLength();
        if (jContentLength > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        BufferedSource bufferedSourceSource = source();
        try {
            T tInvoke = interfaceC2392.invoke(bufferedSourceSource);
            C2679.m9826(1);
            C3494.m11412(bufferedSourceSource, null);
            C2679.m9825(1);
            int iIntValue = interfaceC23922.invoke(tInvoke).intValue();
            if (jContentLength == -1 || jContentLength == iIntValue) {
                return tInvoke;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iIntValue + ") disagree");
        } finally {
        }
    }

    public static final AbstractC4809 create(String str, C2314 c2314) {
        return Companion.m14536(str, c2314);
    }

    public static final AbstractC4809 create(BufferedSource bufferedSource, C2314 c2314, long j) {
        return Companion.m14537(bufferedSource, c2314, j);
    }

    public static final AbstractC4809 create(ByteString byteString, C2314 c2314) {
        return Companion.m14538(byteString, c2314);
    }

    public static final AbstractC4809 create(C2314 c2314, long j, BufferedSource bufferedSource) {
        return Companion.m14532(c2314, j, bufferedSource);
    }

    public static final AbstractC4809 create(C2314 c2314, String str) {
        return Companion.m14533(c2314, str);
    }

    public static final AbstractC4809 create(C2314 c2314, ByteString byteString) {
        return Companion.m14534(c2314, byteString);
    }

    public static final AbstractC4809 create(C2314 c2314, byte[] bArr) {
        return Companion.m14535(c2314, bArr);
    }

    public static final AbstractC4809 create(byte[] bArr, C2314 c2314) {
        return Companion.m14539(bArr, c2314);
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final ByteString byteString() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        long jContentLength = contentLength();
        if (jContentLength > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        BufferedSource bufferedSourceSource = source();
        try {
            ByteString byteString = bufferedSourceSource.readByteString();
            C3494.m11412(bufferedSourceSource, null);
            int size = byteString.size();
            if (jContentLength == -1 || jContentLength == size) {
                return byteString;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + size + ") disagree");
        } finally {
        }
    }

    public final byte[] bytes() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        long jContentLength = contentLength();
        if (jContentLength > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        BufferedSource bufferedSourceSource = source();
        try {
            byte[] byteArray = bufferedSourceSource.readByteArray();
            C3494.m11412(bufferedSourceSource, null);
            int length = byteArray.length;
            if (jContentLength == -1 || jContentLength == length) {
                return byteArray;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
        } finally {
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        C4810 c4810 = new C4810(source(), charset());
        this.reader = c4810;
        return c4810;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        i5.m6240(source());
    }

    public abstract long contentLength();

    public abstract C2314 contentType();

    public abstract BufferedSource source();

    public final String string() throws IOException {
        BufferedSource bufferedSourceSource = source();
        try {
            String string = bufferedSourceSource.readString(i5.m6262(bufferedSourceSource, charset()));
            C3494.m11412(bufferedSourceSource, null);
            return string;
        } finally {
        }
    }
}
