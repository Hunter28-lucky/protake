package com.blink.academy.film.http.okhttp.cache.stategy;

import com.blink.academy.film.http.okhttp.cache.RxCache;
import com.blink.academy.film.http.okhttp.cache.model.CacheResult;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC4178;
import java.lang.reflect.Type;
import okio.ByteString;

/* loaded from: classes.dex */
public final class CacheAndRemoteDistinctStrategy extends BaseStrategy {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.cache.stategy.CacheAndRemoteDistinctStrategy$Ϳ, reason: contains not printable characters */
    public class C0385<T> implements InterfaceC2368<CacheResult<T>, String> {
        public C0385() {
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public String apply(CacheResult<T> cacheResult) throws Exception {
            return ByteString.of(cacheResult.data.toString().getBytes()).md5().hex();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.cache.stategy.CacheAndRemoteDistinctStrategy$Ԩ, reason: contains not printable characters */
    public class C0386<T> implements InterfaceC4178<CacheResult<T>> {
        public C0386() {
        }

        @Override // defpackage.InterfaceC4178
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public boolean test(CacheResult<T> cacheResult) throws Exception {
            return (cacheResult == null || cacheResult.data == null) ? false : true;
        }
    }

    @Override // com.blink.academy.film.http.okhttp.cache.stategy.IStrategy
    public <T> AbstractC4262<CacheResult<T>> execute(RxCache rxCache, String str, long j, AbstractC4262<T> abstractC4262, Type type) {
        return AbstractC4262.concat(loadCache(rxCache, type, str, j, true), loadRemote(rxCache, str, abstractC4262, false)).filter(new C0386()).distinctUntilChanged(new C0385());
    }
}
