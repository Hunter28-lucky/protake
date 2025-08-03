package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.ConnectionSetup;
import com.polidea.rxandroidble2.RxBleConnection;
import defpackage.AbstractC4262;

/* loaded from: classes2.dex */
public interface Connector {
    AbstractC4262<RxBleConnection> prepareConnection(ConnectionSetup connectionSetup);
}
