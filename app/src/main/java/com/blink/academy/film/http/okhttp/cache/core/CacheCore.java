package com.blink.academy.film.http.okhttp.cache.core;

import com.blink.academy.film.http.okhttp.utils.Utils;
import defpackage.C4638;
import java.lang.reflect.Type;
import okio.ByteString;

/* loaded from: classes.dex */
public class CacheCore {
    private LruDiskCache disk;

    public CacheCore(LruDiskCache lruDiskCache) {
        this.disk = (LruDiskCache) Utils.checkNotNull(lruDiskCache, "disk==null");
    }

    public synchronized boolean clear() {
        LruDiskCache lruDiskCache = this.disk;
        if (lruDiskCache == null) {
            return false;
        }
        return lruDiskCache.clear();
    }

    public synchronized boolean containsKey(String str) {
        String strHex = ByteString.of(str.getBytes()).md5().hex();
        C4638.m14098("containsCache  key=" + strHex);
        LruDiskCache lruDiskCache = this.disk;
        if (lruDiskCache != null) {
            if (lruDiskCache.containsKey(strHex)) {
                return true;
            }
        }
        return false;
    }

    public synchronized <T> T load(Type type, String str, long j) {
        String strHex = ByteString.of(str.getBytes()).md5().hex();
        C4638.m14098("loadCache  key=" + strHex);
        LruDiskCache lruDiskCache = this.disk;
        if (lruDiskCache != null) {
            T t = (T) lruDiskCache.load(type, strHex, j);
            if (t != null) {
                return t;
            }
        }
        return null;
    }

    public synchronized boolean remove(String str) {
        String strHex = ByteString.of(str.getBytes()).md5().hex();
        C4638.m14098("removeCache  key=" + strHex);
        LruDiskCache lruDiskCache = this.disk;
        if (lruDiskCache == null) {
            return true;
        }
        return lruDiskCache.remove(strHex);
    }

    public synchronized <T> boolean save(String str, T t) {
        String strHex;
        strHex = ByteString.of(str.getBytes()).md5().hex();
        C4638.m14098("saveCache  key=" + strHex);
        return this.disk.save(strHex, t);
    }
}
