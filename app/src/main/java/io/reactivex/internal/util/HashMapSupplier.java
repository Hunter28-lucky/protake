package io.reactivex.internal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public enum HashMapSupplier implements Callable<Map<Object, Object>> {
    INSTANCE;

    public static <K, V> Callable<Map<K, V>> asCallable() {
        return INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Map<Object, Object> call() throws Exception {
        return new HashMap();
    }
}
