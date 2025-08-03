package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SequencesJVM.kt */
/* renamed from: ܝ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3672<T> implements InterfaceC4590<T> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final AtomicReference<InterfaceC4590<T>> f12746;

    public C3672(InterfaceC4590<? extends T> interfaceC4590) {
        C3921.m12666(interfaceC4590, "sequence");
        this.f12746 = new AtomicReference<>(interfaceC4590);
    }

    @Override // defpackage.InterfaceC4590
    public Iterator<T> iterator() {
        InterfaceC4590<T> andSet = this.f12746.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
