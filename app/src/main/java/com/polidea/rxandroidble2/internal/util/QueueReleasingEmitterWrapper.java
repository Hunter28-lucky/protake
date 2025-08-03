package com.polidea.rxandroidble2.internal.util;

import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import defpackage.InterfaceC2672;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5245;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class QueueReleasingEmitterWrapper<T> implements InterfaceC5102<T>, InterfaceC2672 {
    private final InterfaceC5245<T> emitter;
    private final AtomicBoolean isEmitterCanceled = new AtomicBoolean(false);
    private final QueueReleaseInterface queueReleaseInterface;

    public QueueReleasingEmitterWrapper(InterfaceC5245<T> interfaceC5245, QueueReleaseInterface queueReleaseInterface) {
        this.emitter = interfaceC5245;
        this.queueReleaseInterface = queueReleaseInterface;
        interfaceC5245.mo6763(this);
    }

    @Override // defpackage.InterfaceC2672
    public synchronized void cancel() {
        this.isEmitterCanceled.set(true);
    }

    public synchronized boolean isWrappedEmitterUnsubscribed() {
        return this.isEmitterCanceled.get();
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        this.queueReleaseInterface.release();
        this.emitter.onComplete();
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        this.queueReleaseInterface.release();
        this.emitter.mo6761(th);
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        this.emitter.onNext(t);
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
    }
}
