package com.blink.academy.film.http.okhttp.interceptor;

import android.content.Context;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.blink.academy.film.http.okhttp.utils.Utils;
import defpackage.C2789;
import defpackage.C4539;
import defpackage.C4638;
import defpackage.C4770;
import defpackage.InterfaceC2818;
import java.io.IOException;

/* loaded from: classes.dex */
public class CacheInterceptorOffline extends CacheInterceptor {
    public CacheInterceptorOffline(Context context) {
        super(context);
    }

    @Override // com.blink.academy.film.http.okhttp.interceptor.CacheInterceptor, defpackage.InterfaceC2818
    public C4770 intercept(InterfaceC2818.InterfaceC2819 interfaceC2819) throws IOException {
        C4539 c4539Request = interfaceC2819.request();
        if (Utils.isNetworkAvailable(this.context)) {
            return interfaceC2819.mo10160(c4539Request);
        }
        C4638.m14103(" no network load cache:" + c4539Request.m13917().toString());
        return interfaceC2819.mo10160(c4539Request.m13924().m13928(C2789.f10161).m13927()).m14343().m14366(HttpHeaders.HEAD_KEY_PRAGMA).m14366(HttpHeaders.HEAD_KEY_CACHE_CONTROL).m14358(HttpHeaders.HEAD_KEY_CACHE_CONTROL, "public, only-if-cached, " + this.cacheControlValue_Offline).m14351();
    }

    public CacheInterceptorOffline(Context context, String str) {
        super(context, str);
    }

    public CacheInterceptorOffline(Context context, String str, String str2) {
        super(context, str, str2);
    }
}
