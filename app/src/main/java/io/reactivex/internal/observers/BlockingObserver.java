package io.reactivex.internal.observers;

import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class BlockingObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T>, InterfaceC4478 {
    private static final long serialVersionUID = -4875965440900746268L;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Object f6840 = new Object();
    public final Queue<Object> queue;

    public BlockingObserver(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.queue.offer(f6840);
        }
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        this.queue.offer(NotificationLite.error(th));
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        this.queue.offer(NotificationLite.next(t));
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        DisposableHelper.setOnce(this, interfaceC4478);
    }
}
