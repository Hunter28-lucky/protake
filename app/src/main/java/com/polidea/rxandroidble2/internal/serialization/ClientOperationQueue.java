package com.polidea.rxandroidble2.internal.serialization;

import com.polidea.rxandroidble2.internal.operations.Operation;
import defpackage.AbstractC4262;

/* loaded from: classes2.dex */
public interface ClientOperationQueue {
    <T> AbstractC4262<T> queue(Operation<T> operation);
}
