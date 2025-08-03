package com.polidea.rxandroidble2.internal.operations;

import defpackage.AbstractC4585;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class TimeoutConfiguration {
    public final long timeout;
    public final AbstractC4585 timeoutScheduler;
    public final TimeUnit timeoutTimeUnit;

    public TimeoutConfiguration(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        this.timeout = j;
        this.timeoutTimeUnit = timeUnit;
        this.timeoutScheduler = abstractC4585;
    }

    public String toString() {
        return "{value=" + this.timeout + ", timeUnit=" + this.timeoutTimeUnit + '}';
    }
}
