package io.reactivex.disposables;

/* loaded from: classes2.dex */
final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    public RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo6296(Runnable runnable) {
        runnable.run();
    }
}
