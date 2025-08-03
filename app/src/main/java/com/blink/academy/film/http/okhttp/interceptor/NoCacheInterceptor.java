package com.blink.academy.film.http.okhttp.interceptor;

import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import defpackage.C4770;
import defpackage.InterfaceC2818;
import java.io.IOException;

/* loaded from: classes.dex */
public class NoCacheInterceptor implements InterfaceC2818 {
    @Override // defpackage.InterfaceC2818
    public C4770 intercept(InterfaceC2818.InterfaceC2819 interfaceC2819) throws IOException {
        return interfaceC2819.mo10160(interfaceC2819.request().m13924().m13929(HttpHeaders.HEAD_KEY_CACHE_CONTROL, "no-cache").m13927()).m14343().m14358(HttpHeaders.HEAD_KEY_CACHE_CONTROL, "no-cache").m14351();
    }
}
