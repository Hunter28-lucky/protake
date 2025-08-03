package com.polidea.rxandroidble2.internal.serialization;

import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.operations.Operation;
import defpackage.AbstractC4585;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5245;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
class FIFORunnableEntry<T> implements Comparable<FIFORunnableEntry> {
    private static final AtomicLong SEQUENCE = new AtomicLong(0);
    public final Operation<T> operation;
    public final InterfaceC5245<T> operationResultObserver;
    private final long seqNum = SEQUENCE.getAndIncrement();

    public FIFORunnableEntry(Operation<T> operation, InterfaceC5245<T> interfaceC5245) {
        this.operation = operation;
        this.operationResultObserver = interfaceC5245;
    }

    public void run(final QueueSemaphore queueSemaphore, final AbstractC4585 abstractC4585) {
        if (!this.operationResultObserver.isDisposed()) {
            abstractC4585.mo6987(new Runnable() { // from class: com.polidea.rxandroidble2.internal.serialization.FIFORunnableEntry.1
                @Override // java.lang.Runnable
                public void run() {
                    FIFORunnableEntry.this.operation.run(queueSemaphore).unsubscribeOn(abstractC4585).subscribe(new InterfaceC5102<T>() { // from class: com.polidea.rxandroidble2.internal.serialization.FIFORunnableEntry.1.1
                        @Override // defpackage.InterfaceC5102
                        public void onComplete() {
                            FIFORunnableEntry.this.operationResultObserver.onComplete();
                        }

                        @Override // defpackage.InterfaceC5102
                        public void onError(Throwable th) {
                            FIFORunnableEntry.this.operationResultObserver.mo6761(th);
                        }

                        @Override // defpackage.InterfaceC5102
                        public void onNext(T t) {
                            FIFORunnableEntry.this.operationResultObserver.onNext(t);
                        }

                        @Override // defpackage.InterfaceC5102
                        public void onSubscribe(InterfaceC4478 interfaceC4478) {
                            FIFORunnableEntry.this.operationResultObserver.mo6762(interfaceC4478);
                        }
                    });
                }
            });
        } else {
            LoggerUtil.logOperationSkippedBecauseDisposedWhenAboutToRun(this.operation);
            queueSemaphore.release();
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull FIFORunnableEntry fIFORunnableEntry) {
        int iCompareTo = this.operation.compareTo(fIFORunnableEntry.operation);
        if (iCompareTo != 0 || fIFORunnableEntry.operation == this.operation) {
            return iCompareTo;
        }
        return this.seqNum < fIFORunnableEntry.seqNum ? -1 : 1;
    }
}
