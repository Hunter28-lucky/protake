package com.polidea.rxandroidble2;

import androidx.annotation.IntRange;

/* loaded from: classes2.dex */
public interface ConnectionParameters {
    @IntRange(from = 6, to = 3200)
    int getConnectionInterval();

    @IntRange(from = 0, to = 499)
    int getSlaveLatency();

    @IntRange(from = 10, to = 3200)
    int getSupervisionTimeout();
}
