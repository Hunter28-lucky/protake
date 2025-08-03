package com.polidea.rxandroidble2.internal.connection;

import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble2.RxBleConnection;

@ConnectionScope
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
class MtuBasedPayloadSizeLimit implements PayloadSizeLimitProvider {
    private final int gattWriteMtuOverhead;
    private final RxBleConnection rxBleConnection;

    public MtuBasedPayloadSizeLimit(RxBleConnection rxBleConnection, int i) {
        this.rxBleConnection = rxBleConnection;
        this.gattWriteMtuOverhead = i;
    }

    @Override // com.polidea.rxandroidble2.internal.connection.PayloadSizeLimitProvider
    public int getPayloadSizeLimit() {
        return this.rxBleConnection.getMtu() - this.gattWriteMtuOverhead;
    }
}
