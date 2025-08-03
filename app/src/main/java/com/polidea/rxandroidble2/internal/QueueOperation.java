package com.polidea.rxandroidble2.internal;

import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.internal.operations.Operation;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import defpackage.AbstractC4262;
import defpackage.InterfaceC5201;
import defpackage.InterfaceC5245;

/* loaded from: classes2.dex */
public abstract class QueueOperation<T> implements Operation<T> {
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull Operation<?> operation) {
        return compareTo2((Operation) operation);
    }

    @Override // com.polidea.rxandroidble2.internal.operations.Operation
    public Priority definedPriority() {
        return Priority.NORMAL;
    }

    public abstract void protectedRun(InterfaceC5245<T> interfaceC5245, QueueReleaseInterface queueReleaseInterface) throws Throwable;

    public abstract BleException provideException(DeadObjectException deadObjectException);

    @Override // com.polidea.rxandroidble2.internal.operations.Operation
    public final AbstractC4262<T> run(final QueueReleaseInterface queueReleaseInterface) {
        return AbstractC4262.create(new InterfaceC5201<T>() { // from class: com.polidea.rxandroidble2.internal.QueueOperation.1
            @Override // defpackage.InterfaceC5201
            public void subscribe(InterfaceC5245<T> interfaceC5245) {
                try {
                    QueueOperation.this.protectedRun(interfaceC5245, queueReleaseInterface);
                } catch (DeadObjectException e2) {
                    interfaceC5245.mo6761(QueueOperation.this.provideException(e2));
                    RxBleLog.e(e2, "QueueOperation terminated with a DeadObjectException", new Object[0]);
                } catch (Throwable th) {
                    interfaceC5245.mo6761(th);
                    RxBleLog.e(th, "QueueOperation terminated with an unexpected exception", new Object[0]);
                }
            }
        });
    }

    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NonNull Operation operation) {
        return operation.definedPriority().priority - definedPriority().priority;
    }
}
