package com.polidea.rxandroidble2.internal.connection;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
class ConstantPayloadSizeLimit implements PayloadSizeLimitProvider {
    private final int limit;

    public ConstantPayloadSizeLimit(int i) {
        this.limit = i;
    }

    @Override // com.polidea.rxandroidble2.internal.connection.PayloadSizeLimitProvider
    public int getPayloadSizeLimit() {
        return this.limit;
    }
}
