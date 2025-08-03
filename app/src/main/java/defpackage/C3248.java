package defpackage;

import io.jsonwebtoken.JwtParser;
import java.util.Iterator;

/* compiled from: Sequences.kt */
/* renamed from: յ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3248<T> implements InterfaceC4590<T>, InterfaceC2473<T> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4590<T> f11417;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int f11418;

    /* compiled from: Sequences.kt */
    /* renamed from: յ$Ϳ, reason: contains not printable characters */
    public static final class C3249 implements Iterator<T>, InterfaceC4947 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Iterator<T> f11419;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public int f11420;

        public C3249(C3248<T> c3248) {
            this.f11419 = c3248.f11417.iterator();
            this.f11420 = c3248.f11418;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            m10916();
            return this.f11419.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            m10916();
            return this.f11419.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m10916() {
            while (this.f11420 > 0 && this.f11419.hasNext()) {
                this.f11419.next();
                this.f11420--;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3248(InterfaceC4590<? extends T> interfaceC4590, int i) {
        C3921.m12666(interfaceC4590, "sequence");
        this.f11417 = interfaceC4590;
        this.f11418 = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + JwtParser.SEPARATOR_CHAR).toString());
    }

    @Override // defpackage.InterfaceC4590
    public Iterator<T> iterator() {
        return new C3249(this);
    }

    @Override // defpackage.InterfaceC2473
    /* renamed from: Ϳ */
    public InterfaceC4590<T> mo9073(int i) {
        int i2 = this.f11418 + i;
        return i2 < 0 ? new C3248(this, i) : new C3248(this.f11417, i2);
    }
}
