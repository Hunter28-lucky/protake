package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.RxBleConnection;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2856;

/* loaded from: classes2.dex */
public class ImmediateSerializedBatchAckStrategy implements RxBleConnection.WriteOperationAckStrategy {
    @Override // com.polidea.rxandroidble2.RxBleConnection.WriteOperationAckStrategy, defpackage.InterfaceC5298
    public InterfaceC2856<Boolean> apply(AbstractC4262<Boolean> abstractC4262) {
        return abstractC4262;
    }
}
