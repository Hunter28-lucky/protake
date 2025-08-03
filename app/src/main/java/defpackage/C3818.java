package defpackage;

import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.efs.sdk.base.Constants;
import defpackage.C4539;
import defpackage.C4770;
import defpackage.InterfaceC2818;
import java.io.IOException;
import java.util.List;
import okio.GzipSource;
import okio.Okio;

/* compiled from: BridgeInterceptor.kt */
/* renamed from: ߊ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3818 implements InterfaceC2818 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC2896 f13090;

    public C3818(InterfaceC2896 interfaceC2896) {
        C3921.m12667(interfaceC2896, "cookieJar");
        this.f13090 = interfaceC2896;
    }

    @Override // defpackage.InterfaceC2818
    public C4770 intercept(InterfaceC2818.InterfaceC2819 interfaceC2819) throws IOException {
        AbstractC4809 abstractC4809M14330;
        C3921.m12667(interfaceC2819, "chain");
        C4539 c4539Request = interfaceC2819.request();
        C4539.C4540 c4540M13924 = c4539Request.m13924();
        AbstractC2613 abstractC2613M13916 = c4539Request.m13916();
        if (abstractC2613M13916 != null) {
            C2314 c2314ContentType = abstractC2613M13916.contentType();
            if (c2314ContentType != null) {
                c4540M13924.m13929(HttpHeaders.HEAD_KEY_CONTENT_TYPE, c2314ContentType.toString());
            }
            long jContentLength = abstractC2613M13916.contentLength();
            if (jContentLength != -1) {
                c4540M13924.m13929(HttpHeaders.HEAD_KEY_CONTENT_LENGTH, String.valueOf(jContentLength));
                c4540M13924.m13933("Transfer-Encoding");
            } else {
                c4540M13924.m13929("Transfer-Encoding", "chunked");
                c4540M13924.m13933(HttpHeaders.HEAD_KEY_CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (c4539Request.m13919("Host") == null) {
            c4540M13924.m13929("Host", i5.m6270(c4539Request.m13925(), false, 1, null));
        }
        if (c4539Request.m13919(HttpHeaders.HEAD_KEY_CONNECTION) == null) {
            c4540M13924.m13929(HttpHeaders.HEAD_KEY_CONNECTION, "Keep-Alive");
        }
        if (c4539Request.m13919(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING) == null && c4539Request.m13919("Range") == null) {
            c4540M13924.m13929(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING, Constants.CP_GZIP);
            z = true;
        }
        List<C2632> listLoadForRequest = this.f13090.loadForRequest(c4539Request.m13925());
        if (!listLoadForRequest.isEmpty()) {
            c4540M13924.m13929(HttpHeaders.HEAD_KEY_COOKIE, m12131(listLoadForRequest));
        }
        if (c4539Request.m13919(HttpHeaders.HEAD_KEY_USER_AGENT) == null) {
            c4540M13924.m13929(HttpHeaders.HEAD_KEY_USER_AGENT, "okhttp/4.8.1");
        }
        C4770 c4770Mo10160 = interfaceC2819.mo10160(c4540M13924.m13927());
        C4186.m13209(this.f13090, c4539Request.m13925(), c4770Mo10160.m14339());
        C4770.C4771 c4771M14367 = c4770Mo10160.m14343().m14367(c4539Request);
        if (z && e0.m5967(Constants.CP_GZIP, C4770.m14329(c4770Mo10160, HttpHeaders.HEAD_KEY_CONTENT_ENCODING, null, 2, null), true) && C4186.m13205(c4770Mo10160) && (abstractC4809M14330 = c4770Mo10160.m14330()) != null) {
            GzipSource gzipSource = new GzipSource(abstractC4809M14330.source());
            c4771M14367.m14359(c4770Mo10160.m14339().m15184().m15194(HttpHeaders.HEAD_KEY_CONTENT_ENCODING).m15194(HttpHeaders.HEAD_KEY_CONTENT_LENGTH).m15191());
            c4771M14367.m14350(new C4829(C4770.m14329(c4770Mo10160, HttpHeaders.HEAD_KEY_CONTENT_TYPE, null, 2, null), -1L, Okio.buffer(gzipSource)));
        }
        return c4771M14367.m14351();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String m12131(List<C2632> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                C3131.m10719();
            }
            C2632 c2632 = (C2632) obj;
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(c2632.m9696());
            sb.append('=');
            sb.append(c2632.m9701());
            i = i2;
        }
        String string = sb.toString();
        C3921.m12663(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
