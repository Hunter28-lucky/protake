package defpackage;

import java.util.Iterator;

/* compiled from: Iterators.kt */
/* renamed from: ฝ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC4899 implements Iterator<Long>, InterfaceC4947 {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Long next() {
        return Long.valueOf(nextLong());
    }

    public abstract long nextLong();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
