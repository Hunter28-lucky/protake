package com.blink.academy.film.http.okhttp.cache.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class CacheResult<T> implements Serializable {
    public T data;
    public boolean isFromCache;

    public CacheResult() {
    }

    public boolean isCache() {
        return this.isFromCache;
    }

    public void setCache(boolean z) {
        this.isFromCache = z;
    }

    public String toString() {
        return "CacheResult{isCache=" + this.isFromCache + ", data=" + this.data + '}';
    }

    public CacheResult(boolean z) {
        this.isFromCache = z;
    }

    public CacheResult(boolean z, T t) {
        this.isFromCache = z;
        this.data = t;
    }
}
