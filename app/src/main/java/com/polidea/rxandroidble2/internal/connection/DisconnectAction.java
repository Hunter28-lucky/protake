package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.internal.operations.DisconnectOperation;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import io.reactivex.internal.functions.Functions;

@ConnectionScope
/* loaded from: classes2.dex */
class DisconnectAction implements ConnectionSubscriptionWatcher {
    private final ClientOperationQueue clientOperationQueue;
    private final DisconnectOperation operationDisconnect;

    public DisconnectAction(ClientOperationQueue clientOperationQueue, DisconnectOperation disconnectOperation) {
        this.clientOperationQueue = clientOperationQueue;
        this.operationDisconnect = disconnectOperation;
    }

    @Override // com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher
    public void onConnectionSubscribed() {
    }

    @Override // com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher
    public void onConnectionUnsubscribed() {
        this.clientOperationQueue.queue(this.operationDisconnect).subscribe(Functions.m6320(), Functions.m6320());
    }
}
