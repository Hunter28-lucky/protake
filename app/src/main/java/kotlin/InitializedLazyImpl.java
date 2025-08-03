package kotlin;

import defpackage.InterfaceC4870;
import java.io.Serializable;

/* compiled from: Lazy.kt */
/* loaded from: classes2.dex */
public final class InitializedLazyImpl<T> implements InterfaceC4870<T>, Serializable {
    private final T value;

    public InitializedLazyImpl(T t) {
        this.value = t;
    }

    @Override // defpackage.InterfaceC4870
    public T getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
