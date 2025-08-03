package defpackage;

import java.util.Iterator;

/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public final class c3<T, R> implements InterfaceC4590<R> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4590<T> f162;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC2392<T, R> f163;

    /* compiled from: Sequences.kt */
    /* renamed from: c3$Ϳ, reason: contains not printable characters */
    public static final class C0050 implements Iterator<R>, InterfaceC4947 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Iterator<T> f164;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ c3<T, R> f165;

        public C0050(c3<T, R> c3Var) {
            this.f165 = c3Var;
            this.f164 = c3Var.f162.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f164.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) this.f165.f163.invoke(this.f164.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c3(InterfaceC4590<? extends T> interfaceC4590, InterfaceC2392<? super T, ? extends R> interfaceC2392) {
        C3921.m12666(interfaceC4590, "sequence");
        C3921.m12666(interfaceC2392, "transformer");
        this.f162 = interfaceC4590;
        this.f163 = interfaceC2392;
    }

    @Override // defpackage.InterfaceC4590
    public Iterator<R> iterator() {
        return new C0050(this);
    }
}
