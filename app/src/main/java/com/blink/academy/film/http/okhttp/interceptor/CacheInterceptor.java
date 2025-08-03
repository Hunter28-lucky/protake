package com.blink.academy.film.http.okhttp.interceptor;

import android.content.Context;
import android.text.TextUtils;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import defpackage.C4638;
import defpackage.C4770;
import defpackage.InterfaceC2818;
import java.io.IOException;

/* loaded from: classes.dex */
public class CacheInterceptor implements InterfaceC2818 {
    public static final int maxStale = 259200;
    public static final int maxStaleOnline = 60;
    public String cacheControlValue_Offline;
    public String cacheControlValue_Online;
    public Context context;

    public CacheInterceptor(Context context) {
        this(context, String.format("max-age=%d", 60));
    }

    @Override // defpackage.InterfaceC2818
    public C4770 intercept(InterfaceC2818.InterfaceC2819 interfaceC2819) throws IOException {
        C4770 c4770Mo10160 = interfaceC2819.mo10160(interfaceC2819.request());
        String strM14337 = c4770Mo10160.m14337(HttpHeaders.HEAD_KEY_CACHE_CONTROL);
        C4638.m14100("60s load cache:" + strM14337);
        return (TextUtils.isEmpty(strM14337) || strM14337.contains("no-store") || strM14337.contains("no-cache") || strM14337.contains("must-revalidate") || strM14337.contains("max-age") || strM14337.contains("max-stale")) ? c4770Mo10160.m14343().m14366(HttpHeaders.HEAD_KEY_PRAGMA).m14366(HttpHeaders.HEAD_KEY_CACHE_CONTROL).m14358(HttpHeaders.HEAD_KEY_CACHE_CONTROL, "public, max-age=259200").m14351() : c4770Mo10160;
    }

    public CacheInterceptor(Context context, String str) {
        this(context, str, String.format("max-age=%d", Integer.valueOf(maxStale)));
    }

    public CacheInterceptor(Context context, String str, String str2) {
        this.context = context;
        this.cacheControlValue_Offline = str;
        this.cacheControlValue_Online = str2;
    }
}
