package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.RxBleConnection;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;

/* loaded from: classes2.dex */
public class NoRetryStrategy implements RxBleConnection.WriteOperationRetryStrategy {
    @Override // com.polidea.rxandroidble2.RxBleConnection.WriteOperationRetryStrategy, defpackage.InterfaceC5298
    public InterfaceC2856<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure> apply(AbstractC4262<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure> abstractC4262) {
        return abstractC4262.flatMap(new InterfaceC2368<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure, AbstractC4262<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure>>() { // from class: com.polidea.rxandroidble2.internal.connection.NoRetryStrategy.1
            @Override // defpackage.InterfaceC2368
            public AbstractC4262<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure> apply(RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure longWriteFailure) {
                return AbstractC4262.error(longWriteFailure.getCause());
            }
        });
    }
}
