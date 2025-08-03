package com.polidea.rxandroidble2.internal.serialization;

import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.operations.Operation;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC5201;
import defpackage.InterfaceC5245;
import io.reactivex.disposables.C1972;

/* loaded from: classes2.dex */
public class ClientOperationQueueImpl implements ClientOperationQueue {
    public final OperationPriorityFifoBlockingQueue queue = new OperationPriorityFifoBlockingQueue();

    public ClientOperationQueueImpl(final AbstractC4585 abstractC4585) {
        new Thread(new Runnable() { // from class: com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        FIFORunnableEntry<?> fIFORunnableEntryTake = ClientOperationQueueImpl.this.queue.take();
                        Operation<?> operation = fIFORunnableEntryTake.operation;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        LoggerUtil.logOperationStarted(operation);
                        LoggerUtil.logOperationRunning(operation);
                        QueueSemaphore queueSemaphore = new QueueSemaphore();
                        fIFORunnableEntryTake.run(queueSemaphore, abstractC4585);
                        queueSemaphore.awaitRelease();
                        LoggerUtil.logOperationFinished(operation, jCurrentTimeMillis, System.currentTimeMillis());
                    } catch (InterruptedException e2) {
                        RxBleLog.e(e2, "Error while processing client operation queue", new Object[0]);
                    }
                }
            }
        }).start();
    }

    @Override // com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public <T> AbstractC4262<T> queue(final Operation<T> operation) {
        return AbstractC4262.create(new InterfaceC5201<T>() { // from class: com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl.2
            @Override // defpackage.InterfaceC5201
            public void subscribe(InterfaceC5245<T> interfaceC5245) {
                final FIFORunnableEntry fIFORunnableEntry = new FIFORunnableEntry(operation, interfaceC5245);
                interfaceC5245.mo6762(C1972.m6301(new InterfaceC3809() { // from class: com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl.2.1
                    @Override // defpackage.InterfaceC3809
                    public void run() {
                        if (ClientOperationQueueImpl.this.queue.remove(fIFORunnableEntry)) {
                            LoggerUtil.logOperationRemoved(operation);
                        }
                    }
                }));
                LoggerUtil.logOperationQueued(operation);
                ClientOperationQueueImpl.this.queue.add(fIFORunnableEntry);
            }
        });
    }
}
