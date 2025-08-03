package com.blink.academy.film.http.okhttp.func;

import com.blink.academy.film.http.okhttp.cache.model.CacheResult;
import defpackage.InterfaceC2368;

/* loaded from: classes.dex */
public class CacheResultFunc<T> implements InterfaceC2368<CacheResult<T>, T> {
    @Override // defpackage.InterfaceC2368
    public T apply(CacheResult<T> cacheResult) throws Exception {
        return cacheResult.data;
    }
}
