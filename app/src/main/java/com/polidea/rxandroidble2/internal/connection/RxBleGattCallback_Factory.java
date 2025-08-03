package com.polidea.rxandroidble2.internal.connection;

import defpackage.AbstractC4585;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class RxBleGattCallback_Factory implements InterfaceC3628<RxBleGattCallback> {
    private final InterfaceC4461<BluetoothGattProvider> bluetoothGattProvider;
    private final InterfaceC4461<AbstractC4585> callbackSchedulerProvider;
    private final InterfaceC4461<DisconnectionRouter> disconnectionRouterProvider;
    private final InterfaceC4461<NativeCallbackDispatcher> nativeCallbackDispatcherProvider;

    public RxBleGattCallback_Factory(InterfaceC4461<AbstractC4585> interfaceC4461, InterfaceC4461<BluetoothGattProvider> interfaceC44612, InterfaceC4461<DisconnectionRouter> interfaceC44613, InterfaceC4461<NativeCallbackDispatcher> interfaceC44614) {
        this.callbackSchedulerProvider = interfaceC4461;
        this.bluetoothGattProvider = interfaceC44612;
        this.disconnectionRouterProvider = interfaceC44613;
        this.nativeCallbackDispatcherProvider = interfaceC44614;
    }

    public static RxBleGattCallback_Factory create(InterfaceC4461<AbstractC4585> interfaceC4461, InterfaceC4461<BluetoothGattProvider> interfaceC44612, InterfaceC4461<DisconnectionRouter> interfaceC44613, InterfaceC4461<NativeCallbackDispatcher> interfaceC44614) {
        return new RxBleGattCallback_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614);
    }

    public static RxBleGattCallback newRxBleGattCallback(AbstractC4585 abstractC4585, BluetoothGattProvider bluetoothGattProvider, Object obj, Object obj2) {
        return new RxBleGattCallback(abstractC4585, bluetoothGattProvider, (DisconnectionRouter) obj, (NativeCallbackDispatcher) obj2);
    }

    @Override // defpackage.InterfaceC4461
    public RxBleGattCallback get() {
        return new RxBleGattCallback(this.callbackSchedulerProvider.get(), this.bluetoothGattProvider.get(), this.disconnectionRouterProvider.get(), this.nativeCallbackDispatcherProvider.get());
    }
}
