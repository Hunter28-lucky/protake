package com.blink.academy.film.http.okhttp.cache.stategy;

import com.blink.academy.film.http.okhttp.cache.RxCache;
import com.blink.academy.film.http.okhttp.cache.model.CacheResult;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2368;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class NoStrategy implements IStrategy {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.cache.stategy.NoStrategy$Ϳ, reason: contains not printable characters */
    public class C0388<T> implements InterfaceC2368<T, CacheResult<T>> {
        public C0388() {
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public CacheResult<T> apply(T t) throws Exception {
            return new CacheResult<>(false, t);
        }
    }

    @Override // com.blink.academy.film.http.okhttp.cache.stategy.IStrategy
    public <T> AbstractC4262<CacheResult<T>> execute(RxCache rxCache, String str, long j, AbstractC4262<T> abstractC4262, Type type) {
        return (AbstractC4262<CacheResult<T>>) abstractC4262.map(new C0388());
    }
}
