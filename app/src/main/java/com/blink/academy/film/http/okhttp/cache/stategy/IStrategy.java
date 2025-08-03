package com.blink.academy.film.http.okhttp.cache.stategy;

import com.blink.academy.film.http.okhttp.cache.RxCache;
import com.blink.academy.film.http.okhttp.cache.model.CacheResult;
import defpackage.AbstractC4262;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public interface IStrategy {
    <T> AbstractC4262<CacheResult<T>> execute(RxCache rxCache, String str, long j, AbstractC4262<T> abstractC4262, Type type);
}
