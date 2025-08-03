package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Sequences.kt */
/* renamed from: ט, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3278<T> implements InterfaceC4590<T> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4090<T> f11474;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC2392<T, T> f11475;

    /* compiled from: Sequences.kt */
    /* renamed from: ט$Ϳ, reason: contains not printable characters */
    public static final class C3279 implements Iterator<T>, InterfaceC4947 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public T f11476;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public int f11477 = -2;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ C3278<T> f11478;

        public C3279(C3278<T> c3278) {
            this.f11478 = c3278;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f11477 < 0) {
                m10955();
            }
            return this.f11477 == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f11477 < 0) {
                m10955();
            }
            if (this.f11477 == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f11476;
            if (t == null) {
                throw new NullPointerException("null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            }
            this.f11477 = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m10955() {
            T t;
            if (this.f11477 == -2) {
                t = (T) this.f11478.f11474.invoke();
            } else {
                InterfaceC2392 interfaceC2392 = this.f11478.f11475;
                T t2 = this.f11476;
                C3921.m12664(t2);
                t = (T) interfaceC2392.invoke(t2);
            }
            this.f11476 = t;
            this.f11477 = t == null ? 0 : 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3278(InterfaceC4090<? extends T> interfaceC4090, InterfaceC2392<? super T, ? extends T> interfaceC2392) {
        C3921.m12666(interfaceC4090, "getInitialValue");
        C3921.m12666(interfaceC2392, "getNextValue");
        this.f11474 = interfaceC4090;
        this.f11475 = interfaceC2392;
    }

    @Override // defpackage.InterfaceC4590
    public Iterator<T> iterator() {
        return new C3279(this);
    }
}
