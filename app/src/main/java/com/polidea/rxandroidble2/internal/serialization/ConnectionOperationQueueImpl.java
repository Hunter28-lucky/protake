package com.polidea.rxandroidble2.internal.serialization;

import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.connection.ConnectionScope;
import com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher;
import com.polidea.rxandroidble2.internal.connection.DisconnectionRouterOutput;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.operations.Operation;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.AbstractC5105;
import defpackage.InterfaceC2672;
import defpackage.InterfaceC5201;
import defpackage.InterfaceC5245;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@ConnectionScope
/* loaded from: classes2.dex */
public class ConnectionOperationQueueImpl implements ConnectionOperationQueue, ConnectionSubscriptionWatcher {
    private final String deviceMacAddress;
    private final DisconnectionRouterOutput disconnectionRouterOutput;
    private AbstractC5105<BleException> disconnectionThrowableSubscription;
    private final Future<?> runnableFuture;
    public final OperationPriorityFifoBlockingQueue queue = new OperationPriorityFifoBlockingQueue();
    public volatile boolean shouldRun = true;
    private BleException disconnectionException = null;

    public ConnectionOperationQueueImpl(final String str, DisconnectionRouterOutput disconnectionRouterOutput, ExecutorService executorService, final AbstractC4585 abstractC4585) {
        this.deviceMacAddress = str;
        this.disconnectionRouterOutput = disconnectionRouterOutput;
        this.runnableFuture = executorService.submit(new Runnable() { // from class: com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl.1
            @Override // java.lang.Runnable
            public void run() {
                while (ConnectionOperationQueueImpl.this.shouldRun) {
                    try {
                        FIFORunnableEntry<?> fIFORunnableEntryTake = ConnectionOperationQueueImpl.this.queue.take();
                        Operation<?> operation = fIFORunnableEntryTake.operation;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        LoggerUtil.logOperationStarted(operation);
                        LoggerUtil.logOperationRunning(operation);
                        QueueSemaphore queueSemaphore = new QueueSemaphore();
                        fIFORunnableEntryTake.run(queueSemaphore, abstractC4585);
                        queueSemaphore.awaitRelease();
                        LoggerUtil.logOperationFinished(operation, jCurrentTimeMillis, System.currentTimeMillis());
                    } catch (InterruptedException e2) {
                        synchronized (ConnectionOperationQueueImpl.this) {
                            if (!ConnectionOperationQueueImpl.this.shouldRun) {
                                break;
                            } else {
                                RxBleLog.e(e2, "Error while processing connection operation queue", new Object[0]);
                            }
                        }
                    }
                }
                ConnectionOperationQueueImpl.this.flushQueue();
                RxBleLog.v("Terminated (%s)", LoggerUtil.commonMacMessage(str));
            }
        });
    }

    public synchronized void flushQueue() {
        while (!this.queue.isEmpty()) {
            this.queue.takeNow().operationResultObserver.mo6761(this.disconnectionException);
        }
    }

    @Override // com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher
    public void onConnectionSubscribed() {
        this.disconnectionThrowableSubscription = (AbstractC5105) this.disconnectionRouterOutput.asValueOnlyObservable().subscribeWith(new AbstractC5105<BleException>() { // from class: com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl.3
            @Override // defpackage.InterfaceC5102
            public void onComplete() {
            }

            @Override // defpackage.InterfaceC5102
            public void onError(Throwable th) {
            }

            @Override // defpackage.InterfaceC5102
            public void onNext(BleException bleException) {
                ConnectionOperationQueueImpl.this.terminate(bleException);
            }
        });
    }

    @Override // com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher
    public void onConnectionUnsubscribed() {
        this.disconnectionThrowableSubscription.dispose();
        this.disconnectionThrowableSubscription = null;
        terminate(new BleDisconnectedException(this.deviceMacAddress, -1));
    }

    @Override // com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public synchronized <T> AbstractC4262<T> queue(final Operation<T> operation) {
        if (this.shouldRun) {
            return AbstractC4262.create(new InterfaceC5201<T>() { // from class: com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl.2
                @Override // defpackage.InterfaceC5201
                public void subscribe(InterfaceC5245<T> interfaceC5245) {
                    final FIFORunnableEntry fIFORunnableEntry = new FIFORunnableEntry(operation, interfaceC5245);
                    interfaceC5245.mo6763(new InterfaceC2672() { // from class: com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl.2.1
                        @Override // defpackage.InterfaceC2672
                        public void cancel() {
                            if (ConnectionOperationQueueImpl.this.queue.remove(fIFORunnableEntry)) {
                                LoggerUtil.logOperationRemoved(operation);
                            }
                        }
                    });
                    LoggerUtil.logOperationQueued(operation);
                    ConnectionOperationQueueImpl.this.queue.add(fIFORunnableEntry);
                }
            });
        }
        return AbstractC4262.error(this.disconnectionException);
    }

    @Override // com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue
    public synchronized void terminate(BleException bleException) {
        if (this.disconnectionException != null) {
            return;
        }
        RxBleLog.d(bleException, "Connection operations queue to be terminated (%s)", LoggerUtil.commonMacMessage(this.deviceMacAddress));
        this.shouldRun = false;
        this.disconnectionException = bleException;
        this.runnableFuture.cancel(true);
    }
}
