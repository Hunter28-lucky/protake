package com.blink.academy.film.http.okhttp.interceptor;

import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.efs.sdk.base.Constants;
import defpackage.AbstractC2613;
import defpackage.C2314;
import defpackage.C4539;
import defpackage.C4770;
import defpackage.InterfaceC2818;
import java.io.IOException;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* loaded from: classes.dex */
public class GzipRequestInterceptor implements InterfaceC2818 {

    /* renamed from: com.blink.academy.film.http.okhttp.interceptor.GzipRequestInterceptor$Ϳ, reason: contains not printable characters */
    public class C0395 extends AbstractC2613 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC2613 f956;

        public C0395(AbstractC2613 abstractC2613) {
            this.f956 = abstractC2613;
        }

        @Override // defpackage.AbstractC2613
        public long contentLength() {
            return -1L;
        }

        @Override // defpackage.AbstractC2613
        public C2314 contentType() {
            return this.f956.contentType();
        }

        @Override // defpackage.AbstractC2613
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            BufferedSink bufferedSinkBuffer = Okio.buffer(new GzipSink(bufferedSink));
            this.f956.writeTo(bufferedSinkBuffer);
            bufferedSinkBuffer.close();
        }
    }

    private AbstractC2613 gzip(AbstractC2613 abstractC2613) {
        return new C0395(abstractC2613);
    }

    @Override // defpackage.InterfaceC2818
    public C4770 intercept(InterfaceC2818.InterfaceC2819 interfaceC2819) throws IOException {
        C4539 c4539Request = interfaceC2819.request();
        return (c4539Request.m13916() == null || c4539Request.m13919(HttpHeaders.HEAD_KEY_CONTENT_ENCODING) != null) ? interfaceC2819.mo10160(c4539Request) : interfaceC2819.mo10160(c4539Request.m13924().m13929(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING, Constants.CP_GZIP).m13931(c4539Request.m13923(), gzip(c4539Request.m13916())).m13927());
    }
}
