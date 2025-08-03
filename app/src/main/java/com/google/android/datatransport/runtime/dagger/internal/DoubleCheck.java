package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import defpackage.InterfaceC4815;

/* loaded from: classes.dex */
public final class DoubleCheck<T> implements InterfaceC4815<T>, Lazy<T> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile InterfaceC4815<T> provider;

    private DoubleCheck(InterfaceC4815<T> interfaceC4815) {
        this.provider = interfaceC4815;
    }

    public static <P extends InterfaceC4815<T>, T> Lazy<T> lazy(P p) {
        return p instanceof Lazy ? (Lazy) p : new DoubleCheck((InterfaceC4815) Preconditions.checkNotNull(p));
    }

    public static <P extends InterfaceC4815<T>, T> InterfaceC4815<T> provider(P p) {
        Preconditions.checkNotNull(p);
        return p instanceof DoubleCheck ? p : new DoubleCheck(p);
    }

    public static Object reentrantCheck(Object obj, Object obj2) {
        if (!((obj == UNINITIALIZED || (obj instanceof MemoizedSentinel)) ? false : true) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // defpackage.InterfaceC4815
    public T get() {
        T t = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.instance;
                if (t == obj) {
                    t = this.provider.get();
                    this.instance = reentrantCheck(this.instance, t);
                    this.provider = null;
                }
            }
        }
        return t;
    }
}
