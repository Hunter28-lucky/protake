package kotlin;

import defpackage.C3921;
import defpackage.C4184;
import defpackage.InterfaceC4090;
import defpackage.InterfaceC4870;
import defpackage.e4;
import java.io.Serializable;

/* compiled from: LazyJVM.kt */
/* loaded from: classes2.dex */
final class SynchronizedLazyImpl<T> implements InterfaceC4870<T>, Serializable {
    private volatile Object _value;
    private InterfaceC4090<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(InterfaceC4090<? extends T> interfaceC4090, Object obj) {
        C3921.m12666(interfaceC4090, "initializer");
        this.initializer = interfaceC4090;
        this._value = e4.f6602;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // defpackage.InterfaceC4870
    public T getValue() {
        T tInvoke;
        T t = (T) this._value;
        e4 e4Var = e4.f6602;
        if (t != e4Var) {
            return t;
        }
        synchronized (this.lock) {
            tInvoke = (T) this._value;
            if (tInvoke == e4Var) {
                InterfaceC4090<? extends T> interfaceC4090 = this.initializer;
                C3921.m12664(interfaceC4090);
                tInvoke = interfaceC4090.invoke();
                this._value = tInvoke;
                this.initializer = null;
            }
        }
        return tInvoke;
    }

    public String toString() {
        return m7219() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m7219() {
        return this._value != e4.f6602;
    }

    public /* synthetic */ SynchronizedLazyImpl(InterfaceC4090 interfaceC4090, Object obj, int i, C4184 c4184) {
        this(interfaceC4090, (i & 2) != 0 ? null : obj);
    }
}
