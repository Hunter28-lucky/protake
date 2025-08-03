package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.exceptions.BleException;
import defpackage.AbstractC4262;

/* loaded from: classes2.dex */
public interface DisconnectionRouterOutput {
    <T> AbstractC4262<T> asErrorOnlyObservable();

    AbstractC4262<BleException> asValueOnlyObservable();
}
