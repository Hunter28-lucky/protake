package defpackage;

import java.util.Iterator;

/* compiled from: Iterators.kt */
/* renamed from: ւ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3257 implements Iterator<Boolean>, InterfaceC4947 {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }

    public abstract boolean nextBoolean();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
