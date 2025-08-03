package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.Timeout;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.operations.OperationsProviderImpl;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl;
import com.polidea.rxandroidble2.internal.util.CharacteristicPropertiesParser;
import defpackage.AbstractC4585;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public abstract class ConnectionModule {
    public static final String OPERATION_TIMEOUT = "operation-timeout";

    public static int gattWriteMtuOverhead() {
        return 3;
    }

    public static int minimumMtu() {
        return 23;
    }

    public static BluetoothGatt provideBluetoothGatt(BluetoothGattProvider bluetoothGattProvider) {
        return bluetoothGattProvider.getBluetoothGatt();
    }

    public static CharacteristicPropertiesParser provideCharacteristicPropertiesParser() {
        return new CharacteristicPropertiesParser(1, 2, 4, 8, 16, 32, 64);
    }

    public static IllegalOperationHandler provideIllegalOperationHandler(boolean z, InterfaceC4461<LoggingIllegalOperationHandler> interfaceC4461, InterfaceC4461<ThrowingIllegalOperationHandler> interfaceC44612) {
        return z ? interfaceC4461.get() : interfaceC44612.get();
    }

    public static TimeoutConfiguration providesOperationTimeoutConf(AbstractC4585 abstractC4585, Timeout timeout) {
        return new TimeoutConfiguration(timeout.timeout, timeout.timeUnit, abstractC4585);
    }

    public abstract ConnectionOperationQueue bindConnectionOperationQueue(ConnectionOperationQueueImpl connectionOperationQueueImpl);

    public abstract ConnectionSubscriptionWatcher bindConnectionQueueSubscriptionWatcher(ConnectionOperationQueueImpl connectionOperationQueueImpl);

    public abstract MtuProvider bindCurrentMtuProvider(MtuWatcher mtuWatcher);

    public abstract ConnectionSubscriptionWatcher bindDisconnectActionSubscriptionWatcher(DisconnectAction disconnectAction);

    public abstract DisconnectionRouterInput bindDisconnectionRouterInput(DisconnectionRouter disconnectionRouter);

    public abstract DisconnectionRouterOutput bindDisconnectionRouterOutput(DisconnectionRouter disconnectionRouter);

    public abstract RxBleConnection.LongWriteOperationBuilder bindLongWriteOperationBuilder(LongWriteOperationBuilderImpl longWriteOperationBuilderImpl);

    public abstract ConnectionSubscriptionWatcher bindMtuWatcherSubscriptionWatcher(MtuWatcher mtuWatcher);

    public abstract OperationsProvider bindOperationsProvider(OperationsProviderImpl operationsProviderImpl);

    public abstract RxBleConnection bindRxBleConnection(RxBleConnectionImpl rxBleConnectionImpl);
}
