package com.polidea.rxandroidble2.internal.operations;

import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble2.internal.Priority;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import defpackage.AbstractC4262;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public interface Operation<T> extends Comparable<Operation<?>> {
    Priority definedPriority();

    AbstractC4262<T> run(QueueReleaseInterface queueReleaseInterface);
}
