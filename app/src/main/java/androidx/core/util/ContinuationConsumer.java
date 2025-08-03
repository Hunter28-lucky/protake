package androidx.core.util;

import androidx.annotation.RequiresApi;
import defpackage.C3921;
import defpackage.InterfaceC4355;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;

/* compiled from: Consumer.kt */
@RequiresApi(24)
/* loaded from: classes.dex */
final class ContinuationConsumer<T> extends AtomicBoolean implements java.util.function.Consumer<T> {
    private final InterfaceC4355<T> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationConsumer(InterfaceC4355<? super T> interfaceC4355) {
        super(false);
        C3921.m12666(interfaceC4355, "continuation");
        this.continuation = interfaceC4355;
    }

    @Override // java.util.function.Consumer
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
