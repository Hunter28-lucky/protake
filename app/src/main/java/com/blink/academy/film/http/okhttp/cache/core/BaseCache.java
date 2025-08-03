package com.blink.academy.film.http.okhttp.cache.core;

import com.blink.academy.film.http.okhttp.utils.Utils;
import java.lang.reflect.Type;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public abstract class BaseCache {
    private final ReadWriteLock mLock = new ReentrantReadWriteLock();

    public final boolean clear() {
        this.mLock.writeLock().lock();
        try {
            return doClear();
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    public final boolean containsKey(String str) {
        this.mLock.readLock().lock();
        try {
            return doContainsKey(str);
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    public abstract boolean doClear();

    public abstract boolean doContainsKey(String str);

    public abstract <T> T doLoad(Type type, String str);

    public abstract boolean doRemove(String str);

    public abstract <T> boolean doSave(String str, T t);

    public abstract boolean isExpiry(String str, long j);

    public final <T> T load(Type type, String str, long j) {
        Utils.checkNotNull(str, "key == null");
        if (!containsKey(str)) {
            return null;
        }
        if (isExpiry(str, j)) {
            remove(str);
            return null;
        }
        this.mLock.readLock().lock();
        try {
            return (T) doLoad(type, str);
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    public final boolean remove(String str) {
        this.mLock.writeLock().lock();
        try {
            return doRemove(str);
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    public final <T> boolean save(String str, T t) {
        Utils.checkNotNull(str, "key == null");
        if (t == null) {
            return remove(str);
        }
        this.mLock.writeLock().lock();
        try {
            return doSave(str, t);
        } finally {
            this.mLock.writeLock().unlock();
        }
    }
}
