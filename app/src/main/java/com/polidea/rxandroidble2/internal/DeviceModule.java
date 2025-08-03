package com.polidea.rxandroidble2.internal;

import android.bluetooth.BluetoothDevice;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;
import com.polidea.rxandroidble2.internal.connection.Connector;
import com.polidea.rxandroidble2.internal.connection.ConnectorImpl;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import defpackage.AbstractC4585;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class DeviceModule {
    public static final String CONNECT_TIMEOUT = "connect-timeout";
    private static final int DEFAULT_CONNECT_TIMEOUT = 35;
    private static final int DEFAULT_DISCONNECT_TIMEOUT = 10;
    private static final int DEFAULT_OPERATION_TIMEOUT = 30;
    public static final String DISCONNECT_TIMEOUT = "disconnect-timeout";
    public static final String MAC_ADDRESS = "mac-address";
    public static final String OPERATION_TIMEOUT = "operation-timeout";

    public static BluetoothDevice provideBluetoothDevice(String str, RxBleAdapterWrapper rxBleAdapterWrapper) {
        return rxBleAdapterWrapper.getRemoteDevice(str);
    }

    @DeviceScope
    public static ConnectionStateChangeListener provideConnectionStateChangeListener(final BehaviorRelay<RxBleConnection.RxBleConnectionState> behaviorRelay) {
        return new ConnectionStateChangeListener() { // from class: com.polidea.rxandroidble2.internal.DeviceModule.1
            @Override // com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener
            public void onConnectionStateChange(RxBleConnection.RxBleConnectionState rxBleConnectionState) {
                behaviorRelay.accept(rxBleConnectionState);
            }
        };
    }

    @DeviceScope
    public static BehaviorRelay<RxBleConnection.RxBleConnectionState> provideConnectionStateRelay() {
        return BehaviorRelay.createDefault(RxBleConnection.RxBleConnectionState.DISCONNECTED);
    }

    public static TimeoutConfiguration providesConnectTimeoutConf(AbstractC4585 abstractC4585) {
        return new TimeoutConfiguration(35L, TimeUnit.SECONDS, abstractC4585);
    }

    public static TimeoutConfiguration providesDisconnectTimeoutConf(AbstractC4585 abstractC4585) {
        return new TimeoutConfiguration(10L, TimeUnit.SECONDS, abstractC4585);
    }

    public abstract Connector bindConnector(ConnectorImpl connectorImpl);

    public abstract RxBleDevice bindDevice(RxBleDeviceImpl rxBleDeviceImpl);
}
