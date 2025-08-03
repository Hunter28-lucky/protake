package defpackage;

import java.util.Iterator;

/* compiled from: Iterators.kt */
/* renamed from: ķ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC2348 implements Iterator<Integer>, InterfaceC4947 {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(nextInt());
    }

    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}
