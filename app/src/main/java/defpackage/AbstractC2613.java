package defpackage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* compiled from: RequestBody.kt */
/* renamed from: ɯ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC2613 {
    public static final C2614 Companion = new C2614(null);

    /* compiled from: RequestBody.kt */
    /* renamed from: ɯ$Ϳ, reason: contains not printable characters */
    public static final class C2614 {

        /* compiled from: RequestBody.kt */
        /* renamed from: ɯ$Ϳ$Ϳ, reason: contains not printable characters */
        public static final class C2615 extends AbstractC2613 {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ File f9720;

            /* renamed from: Ԩ, reason: contains not printable characters */
            public final /* synthetic */ C2314 f9721;

            public C2615(File file, C2314 c2314) {
                this.f9720 = file;
                this.f9721 = c2314;
            }

            @Override // defpackage.AbstractC2613
            public long contentLength() {
                return this.f9720.length();
            }

            @Override // defpackage.AbstractC2613
            public C2314 contentType() {
                return this.f9721;
            }

            @Override // defpackage.AbstractC2613
            public void writeTo(BufferedSink bufferedSink) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                C3921.m12667(bufferedSink, "sink");
                Source source = Okio.source(this.f9720);
                try {
                    bufferedSink.writeAll(source);
                    C3494.m11412(source, null);
                } finally {
                }
            }
        }

        /* compiled from: RequestBody.kt */
        /* renamed from: ɯ$Ϳ$Ԩ, reason: contains not printable characters */
        public static final class C2616 extends AbstractC2613 {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ ByteString f9722;

            /* renamed from: Ԩ, reason: contains not printable characters */
            public final /* synthetic */ C2314 f9723;

            public C2616(ByteString byteString, C2314 c2314) {
                this.f9722 = byteString;
                this.f9723 = c2314;
            }

            @Override // defpackage.AbstractC2613
            public long contentLength() {
                return this.f9722.size();
            }

            @Override // defpackage.AbstractC2613
            public C2314 contentType() {
                return this.f9723;
            }

            @Override // defpackage.AbstractC2613
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                C3921.m12667(bufferedSink, "sink");
                bufferedSink.write(this.f9722);
            }
        }

        /* compiled from: RequestBody.kt */
        /* renamed from: ɯ$Ϳ$Ԫ, reason: contains not printable characters */
        public static final class C2617 extends AbstractC2613 {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ byte[] f9724;

            /* renamed from: Ԩ, reason: contains not printable characters */
            public final /* synthetic */ C2314 f9725;

            /* renamed from: ԩ, reason: contains not printable characters */
            public final /* synthetic */ int f9726;

            /* renamed from: Ԫ, reason: contains not printable characters */
            public final /* synthetic */ int f9727;

            public C2617(byte[] bArr, C2314 c2314, int i, int i2) {
                this.f9724 = bArr;
                this.f9725 = c2314;
                this.f9726 = i;
                this.f9727 = i2;
            }

            @Override // defpackage.AbstractC2613
            public long contentLength() {
                return this.f9726;
            }

            @Override // defpackage.AbstractC2613
            public C2314 contentType() {
                return this.f9725;
            }

            @Override // defpackage.AbstractC2613
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                C3921.m12667(bufferedSink, "sink");
                bufferedSink.write(this.f9724, this.f9727, this.f9726);
            }
        }

        public C2614() {
        }

        public /* synthetic */ C2614(C4184 c4184) {
            this();
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public static /* synthetic */ AbstractC2613 m9554(C2614 c2614, C2314 c2314, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return c2614.m9560(c2314, bArr, i, i2);
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public static /* synthetic */ AbstractC2613 m9555(C2614 c2614, String str, C2314 c2314, int i, Object obj) {
            if ((i & 1) != 0) {
                c2314 = null;
            }
            return c2614.m9562(str, c2314);
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public static /* synthetic */ AbstractC2613 m9556(C2614 c2614, byte[] bArr, C2314 c2314, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                c2314 = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return c2614.m9564(bArr, c2314, i, i2);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final AbstractC2613 m9557(C2314 c2314, File file) {
            C3921.m12667(file, "file");
            return m9561(file, c2314);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final AbstractC2613 m9558(C2314 c2314, String str) {
            C3921.m12667(str, "content");
            return m9562(str, c2314);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final AbstractC2613 m9559(C2314 c2314, ByteString byteString) {
            C3921.m12667(byteString, "content");
            return m9563(byteString, c2314);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final AbstractC2613 m9560(C2314 c2314, byte[] bArr, int i, int i2) {
            C3921.m12667(bArr, "content");
            return m9564(bArr, c2314, i, i2);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC2613 m9561(File file, C2314 c2314) {
            C3921.m12667(file, "$this$asRequestBody");
            return new C2615(file, c2314);
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AbstractC2613 m9562(String str, C2314 c2314) {
            C3921.m12667(str, "$this$toRequestBody");
            Charset charset = C5241.f17365;
            if (c2314 != null) {
                Charset charsetM8682 = C2314.m8682(c2314, null, 1, null);
                if (charsetM8682 == null) {
                    c2314 = C2314.f8797.m8689(c2314 + "; charset=utf-8");
                } else {
                    charset = charsetM8682;
                }
            }
            byte[] bytes = str.getBytes(charset);
            C3921.m12663(bytes, "(this as java.lang.String).getBytes(charset)");
            return m9564(bytes, c2314, 0, bytes.length);
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final AbstractC2613 m9563(ByteString byteString, C2314 c2314) {
            C3921.m12667(byteString, "$this$toRequestBody");
            return new C2616(byteString, c2314);
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final AbstractC2613 m9564(byte[] bArr, C2314 c2314, int i, int i2) {
            C3921.m12667(bArr, "$this$toRequestBody");
            i5.m6239(bArr.length, i, i2);
            return new C2617(bArr, c2314, i2, i);
        }
    }

    public static final AbstractC2613 create(File file, C2314 c2314) {
        return Companion.m9561(file, c2314);
    }

    public static final AbstractC2613 create(String str, C2314 c2314) {
        return Companion.m9562(str, c2314);
    }

    public static final AbstractC2613 create(ByteString byteString, C2314 c2314) {
        return Companion.m9563(byteString, c2314);
    }

    public static final AbstractC2613 create(C2314 c2314, File file) {
        return Companion.m9557(c2314, file);
    }

    public static final AbstractC2613 create(C2314 c2314, String str) {
        return Companion.m9558(c2314, str);
    }

    public static final AbstractC2613 create(C2314 c2314, ByteString byteString) {
        return Companion.m9559(c2314, byteString);
    }

    public static final AbstractC2613 create(C2314 c2314, byte[] bArr) {
        return C2614.m9554(Companion, c2314, bArr, 0, 0, 12, null);
    }

    public static final AbstractC2613 create(C2314 c2314, byte[] bArr, int i) {
        return C2614.m9554(Companion, c2314, bArr, i, 0, 8, null);
    }

    public static final AbstractC2613 create(C2314 c2314, byte[] bArr, int i, int i2) {
        return Companion.m9560(c2314, bArr, i, i2);
    }

    public static final AbstractC2613 create(byte[] bArr) {
        return C2614.m9556(Companion, bArr, null, 0, 0, 7, null);
    }

    public static final AbstractC2613 create(byte[] bArr, C2314 c2314) {
        return C2614.m9556(Companion, bArr, c2314, 0, 0, 6, null);
    }

    public static final AbstractC2613 create(byte[] bArr, C2314 c2314, int i) {
        return C2614.m9556(Companion, bArr, c2314, i, 0, 4, null);
    }

    public static final AbstractC2613 create(byte[] bArr, C2314 c2314, int i, int i2) {
        return Companion.m9564(bArr, c2314, i, i2);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract C2314 contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;
}
