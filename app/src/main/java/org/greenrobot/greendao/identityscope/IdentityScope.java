package org.greenrobot.greendao.identityscope;

/* loaded from: classes2.dex */
public interface IdentityScope<K, T> {
    void clear();

    T get(K k);

    T getNoLock(K k);

    void lock();

    void put(K k, T t);

    void putNoLock(K k, T t);

    void remove(Iterable<K> iterable);

    void remove(K k);

    void reserveRoom(int i);

    void unlock();
}
