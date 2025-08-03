package com.blink.academy.film.http.okhttp.interceptor;

import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import defpackage.C4539;
import defpackage.C4638;
import defpackage.C4770;
import defpackage.InterfaceC2818;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class HeadersInterceptor implements InterfaceC2818 {
    private HttpHeaders headers;

    public HeadersInterceptor(HttpHeaders httpHeaders) {
        this.headers = httpHeaders;
    }

    @Override // defpackage.InterfaceC2818
    public C4770 intercept(InterfaceC2818.InterfaceC2819 interfaceC2819) throws IOException {
        C4539.C4540 c4540M13924 = interfaceC2819.request().m13924();
        if (this.headers.headersMap.isEmpty()) {
            return interfaceC2819.mo10160(c4540M13924.m13927());
        }
        try {
            for (Map.Entry<String, String> entry : this.headers.headersMap.entrySet()) {
                c4540M13924.m13929(entry.getKey(), entry.getValue()).m13927();
            }
        } catch (Exception e2) {
            C4638.m14100(e2);
        }
        return interfaceC2819.mo10160(c4540M13924.m13927());
    }
}
