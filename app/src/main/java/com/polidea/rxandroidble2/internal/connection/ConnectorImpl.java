package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.ConnectionSetup;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.connection.ConnectionComponent;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC4478;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class ConnectorImpl implements Connector {
    public final AbstractC4585 callbacksScheduler;
    private final ClientOperationQueue clientOperationQueue;
    public final ConnectionComponent.Builder connectionComponentBuilder;

    public ConnectorImpl(ClientOperationQueue clientOperationQueue, ConnectionComponent.Builder builder, AbstractC4585 abstractC4585) {
        this.clientOperationQueue = clientOperationQueue;
        this.connectionComponentBuilder = builder;
        this.callbacksScheduler = abstractC4585;
    }

    public static AbstractC4262<RxBleConnection> observeDisconnections(ConnectionComponent connectionComponent) {
        return connectionComponent.gattCallback().observeDisconnect();
    }

    public static AbstractC4262<RxBleConnection> obtainRxBleConnection(final ConnectionComponent connectionComponent) {
        return AbstractC4262.fromCallable(new Callable<RxBleConnection>() { // from class: com.polidea.rxandroidble2.internal.connection.ConnectorImpl.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RxBleConnection call() {
                return connectionComponent.rxBleConnection();
            }
        });
    }

    public AbstractC4262<BluetoothGatt> enqueueConnectOperation(ConnectionComponent connectionComponent) {
        return this.clientOperationQueue.queue(connectionComponent.connectOperation());
    }

    @Override // com.polidea.rxandroidble2.internal.connection.Connector
    public AbstractC4262<RxBleConnection> prepareConnection(final ConnectionSetup connectionSetup) {
        return AbstractC4262.defer(new Callable<InterfaceC2856<RxBleConnection>>() { // from class: com.polidea.rxandroidble2.internal.connection.ConnectorImpl.1
            @Override // java.util.concurrent.Callable
            public InterfaceC2856<RxBleConnection> call() {
                ConnectionComponent connectionComponentBuild = ConnectorImpl.this.connectionComponentBuilder.autoConnect(connectionSetup.autoConnect).suppressOperationChecks(connectionSetup.suppressOperationCheck).operationTimeout(connectionSetup.operationTimeout).build();
                final Set<ConnectionSubscriptionWatcher> setConnectionSubscriptionWatchers = connectionComponentBuild.connectionSubscriptionWatchers();
                return ConnectorImpl.obtainRxBleConnection(connectionComponentBuild).mergeWith(ConnectorImpl.observeDisconnections(connectionComponentBuild)).delaySubscription(ConnectorImpl.this.enqueueConnectOperation(connectionComponentBuild)).doOnSubscribe(new InterfaceC2857<InterfaceC4478>() { // from class: com.polidea.rxandroidble2.internal.connection.ConnectorImpl.1.2
                    @Override // defpackage.InterfaceC2857
                    public void accept(InterfaceC4478 interfaceC4478) {
                        Iterator it = setConnectionSubscriptionWatchers.iterator();
                        while (it.hasNext()) {
                            ((ConnectionSubscriptionWatcher) it.next()).onConnectionSubscribed();
                        }
                    }
                }).doFinally(new InterfaceC3809() { // from class: com.polidea.rxandroidble2.internal.connection.ConnectorImpl.1.1
                    @Override // defpackage.InterfaceC3809
                    public void run() {
                        Iterator it = setConnectionSubscriptionWatchers.iterator();
                        while (it.hasNext()) {
                            ((ConnectionSubscriptionWatcher) it.next()).onConnectionUnsubscribed();
                        }
                    }
                }).subscribeOn(ConnectorImpl.this.callbacksScheduler).unsubscribeOn(ConnectorImpl.this.callbacksScheduler);
            }
        });
    }
}
