package retrofit2;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import defpackage.AbstractC2613;
import defpackage.C2314;
import defpackage.C3135;
import defpackage.C3573;
import defpackage.C3577;
import defpackage.C4539;
import defpackage.C5207;
import java.io.IOException;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSink;

/* loaded from: classes2.dex */
final class RequestBuilder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final C3573 baseUrl;

    @Nullable
    private AbstractC2613 body;

    @Nullable
    private C2314 contentType;

    @Nullable
    private C3135.C3136 formBuilder;
    private final boolean hasBody;
    private final String method;

    @Nullable
    private C3577.C3578 multipartBuilder;

    @Nullable
    private String relativeUrl;
    private final C4539.C4540 requestBuilder;

    @Nullable
    private C3573.C3574 urlBuilder;

    public static class ContentTypeOverridingRequestBody extends AbstractC2613 {
        private final C2314 contentType;
        private final AbstractC2613 delegate;

        public ContentTypeOverridingRequestBody(AbstractC2613 abstractC2613, C2314 c2314) {
            this.delegate = abstractC2613;
            this.contentType = c2314;
        }

        @Override // defpackage.AbstractC2613
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // defpackage.AbstractC2613
        public C2314 contentType() {
            return this.contentType;
        }

        @Override // defpackage.AbstractC2613
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.delegate.writeTo(bufferedSink);
        }
    }

    public RequestBuilder(String str, C3573 c3573, @Nullable String str2, @Nullable C5207 c5207, @Nullable C2314 c2314, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = c3573;
        this.relativeUrl = str2;
        C4539.C4540 c4540 = new C4539.C4540();
        this.requestBuilder = c4540;
        this.contentType = c2314;
        this.hasBody = z;
        if (c5207 != null) {
            c4540.m13930(c5207);
        }
        if (z2) {
            this.formBuilder = new C3135.C3136();
        } else if (z3) {
            C3577.C3578 c3578 = new C3577.C3578();
            this.multipartBuilder = c3578;
            c3578.m11597(C3577.f12477);
        }
    }

    private static String canonicalizeForPath(String str, boolean z) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) != -1 || (!z && (iCodePointAt == 47 || iCodePointAt == 37))) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, iCharCount);
                canonicalizeForPath(buffer, str, iCharCount, length, z);
                return buffer.readUtf8();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    public void addFormField(String str, String str2, boolean z) {
        if (z) {
            this.formBuilder.m10731(str, str2);
        } else {
            this.formBuilder.m10730(str, str2);
        }
    }

    public void addHeader(String str, String str2) {
        if (!HttpHeaders.HEAD_KEY_CONTENT_TYPE.equalsIgnoreCase(str)) {
            this.requestBuilder.m13926(str, str2);
            return;
        }
        C2314 c2314M8683 = C2314.m8683(str2);
        if (c2314M8683 != null) {
            this.contentType = c2314M8683;
            return;
        }
        throw new IllegalArgumentException("Malformed content type: " + str2);
    }

    public void addPart(C5207 c5207, AbstractC2613 abstractC2613) {
        this.multipartBuilder.m11594(c5207, abstractC2613);
    }

    public void addPathParam(String str, String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 == null) {
            throw new AssertionError();
        }
        this.relativeUrl = str3.replace("{" + str + "}", canonicalizeForPath(str2, z));
    }

    public void addQueryParam(String str, @Nullable String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            C3573.C3574 c3574M11535 = this.baseUrl.m11535(str3);
            this.urlBuilder = c3574M11535;
            if (c3574M11535 == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
            this.relativeUrl = null;
        }
        if (z) {
            this.urlBuilder.m11546(str, str2);
        } else {
            this.urlBuilder.m11547(str, str2);
        }
    }

    public C4539 build() {
        C3573 c3573M11542;
        C3573.C3574 c3574 = this.urlBuilder;
        if (c3574 != null) {
            c3573M11542 = c3574.m11548();
        } else {
            c3573M11542 = this.baseUrl.m11542(this.relativeUrl);
            if (c3573M11542 == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        AbstractC2613 contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            C3135.C3136 c3136 = this.formBuilder;
            if (c3136 != null) {
                contentTypeOverridingRequestBody = c3136.m10732();
            } else {
                C3577.C3578 c3578 = this.multipartBuilder;
                if (c3578 != null) {
                    contentTypeOverridingRequestBody = c3578.m11596();
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = AbstractC2613.create((C2314) null, new byte[0]);
                }
            }
        }
        C2314 c2314 = this.contentType;
        if (c2314 != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, c2314);
            } else {
                this.requestBuilder.m13926(HttpHeaders.HEAD_KEY_CONTENT_TYPE, c2314.toString());
            }
        }
        return this.requestBuilder.m13934(c3573M11542).m13931(this.method, contentTypeOverridingRequestBody).m13927();
    }

    public void setBody(AbstractC2613 abstractC2613) {
        this.body = abstractC2613;
    }

    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    public void addPart(C3577.C3580 c3580) {
        this.multipartBuilder.m11595(c3580);
    }

    private static void canonicalizeForPath(Buffer buffer, String str, int i, int i2, boolean z) {
        Buffer buffer2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt >= 32 && iCodePointAt < 127 && PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) == -1 && (z || (iCodePointAt != 47 && iCodePointAt != 37))) {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(iCodePointAt);
                    while (!buffer2.exhausted()) {
                        int i3 = buffer2.readByte() & ExifInterface.MARKER;
                        buffer.writeByte(37);
                        char[] cArr = HEX_DIGITS;
                        buffer.writeByte((int) cArr[(i3 >> 4) & 15]);
                        buffer.writeByte((int) cArr[i3 & 15]);
                    }
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }
}
