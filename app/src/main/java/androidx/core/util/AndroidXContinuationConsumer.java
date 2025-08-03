package androidx.core.util;

import defpackage.C3921;
import defpackage.InterfaceC4355;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;

/* compiled from: AndroidXConsumer.kt */
/* loaded from: classes.dex */
final class AndroidXContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    private final InterfaceC4355<T> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidXContinuationConsumer(InterfaceC4355<? super T> interfaceC4355) {
        super(false);
        C3921.m12666(interfaceC4355, "continuation");
        this.continuation = interfaceC4355;
    }

    @Override // androidx.core.util.Consumer
    public void accept(T t) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(Result.m7211(t));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
