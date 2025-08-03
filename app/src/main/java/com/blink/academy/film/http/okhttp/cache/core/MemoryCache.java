package com.blink.academy.film.http.okhttp.cache.core;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class MemoryCache extends BaseCache {
    @Override // com.blink.academy.film.http.okhttp.cache.core.BaseCache
    public boolean doClear() {
        return false;
    }

    @Override // com.blink.academy.film.http.okhttp.cache.core.BaseCache
    public boolean doContainsKey(String str) {
        return false;
    }

    @Override // com.blink.academy.film.http.okhttp.cache.core.BaseCache
    public <T> T doLoad(Type type, String str) {
        return null;
    }

    @Override // com.blink.academy.film.http.okhttp.cache.core.BaseCache
    public boolean doRemove(String str) {
        return false;
    }

    @Override // com.blink.academy.film.http.okhttp.cache.core.BaseCache
    public <T> boolean doSave(String str, T t) {
        return false;
    }

    @Override // com.blink.academy.film.http.okhttp.cache.core.BaseCache
    public boolean isExpiry(String str, long j) {
        return false;
    }
}
