package com.blink.academy.film.http.okhttp.cache.core;

import com.blink.academy.film.http.okhttp.cache.converter.IDiskConverter;
import com.blink.academy.film.http.okhttp.utils.Utils;
import com.jakewharton.disklrucache.DiskLruCache;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class LruDiskCache extends BaseCache {
    private IDiskConverter mDiskConverter;
    private DiskLruCache mDiskLruCache;

    public LruDiskCache(IDiskConverter iDiskConverter, File file, int i, long j) {
        this.mDiskConverter = (IDiskConverter) Utils.checkNotNull(iDiskConverter, "diskConverter ==null");
        try {
            this.mDiskLruCache = DiskLruCache.open(file, i, 1, j);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private boolean isCacheDataFailure(File file, long j) {
        return file.exists() && System.currentTimeMillis() - file.lastModified() > j * 1000;
    }

    @Override // com.blink.academy.film.http.okhttp.cache.core.BaseCache
    public boolean doClear() {
        try {
            this.mDiskLruCache.delete();
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.blink.academy.film.http.okhttp.cache.core.BaseCache
    public boolean doContainsKey(String str) {
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache == null) {
            return false;
        }
        try {
            return diskLruCache.get(str) != null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.blink.academy.film.http.okhttp.cache.core.BaseCache
    public <T> T doLoad(Type type, String str) {
        DiskLruCache.Editor editorEdit;
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache == null) {
            return null;
        }
        try {
            editorEdit = diskLruCache.edit(str);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (editorEdit == null) {
            return null;
        }
        InputStream inputStreamNewInputStream = editorEdit.newInputStream(0);
        if (inputStreamNewInputStream == null) {
            editorEdit.abort();
            return null;
        }
        T t = (T) this.mDiskConverter.load(inputStreamNewInputStream, type);
        Utils.close(inputStreamNewInputStream);
        editorEdit.commit();
        return t;
    }

    @Override // com.blink.academy.film.http.okhttp.cache.core.BaseCache
    public boolean doRemove(String str) {
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache == null) {
            return false;
        }
        try {
            return diskLruCache.remove(str);
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.blink.academy.film.http.okhttp.cache.core.BaseCache
    public <T> boolean doSave(String str, T t) {
        DiskLruCache.Editor editorEdit;
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache == null) {
            return false;
        }
        try {
            editorEdit = diskLruCache.edit(str);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (editorEdit == null) {
            return false;
        }
        OutputStream outputStreamNewOutputStream = editorEdit.newOutputStream(0);
        if (outputStreamNewOutputStream == null) {
            editorEdit.abort();
            return false;
        }
        boolean zWriter = this.mDiskConverter.writer(outputStreamNewOutputStream, t);
        Utils.close(outputStreamNewOutputStream);
        editorEdit.commit();
        return zWriter;
    }

    @Override // com.blink.academy.film.http.okhttp.cache.core.BaseCache
    public boolean isExpiry(String str, long j) {
        if (this.mDiskLruCache != null && j > -1) {
            if (isCacheDataFailure(new File(this.mDiskLruCache.getDirectory(), str + ".0"), j)) {
                return true;
            }
        }
        return false;
    }
}
