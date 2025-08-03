package io.reactivex.internal.util;

import defpackage.InterfaceC2368;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public enum ArrayListSupplier implements Callable<List<Object>>, InterfaceC2368<Object, List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> InterfaceC2368<O, List<T>> asFunction() {
        return INSTANCE;
    }

    @Override // defpackage.InterfaceC2368
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public List<Object> call() throws Exception {
        return new ArrayList();
    }
}
