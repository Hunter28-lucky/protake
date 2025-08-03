package com.polidea.rxandroidble2.internal;

import android.bluetooth.BluetoothDevice;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import defpackage.C4618;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class DeviceModule_ProvideBluetoothDeviceFactory implements InterfaceC3628<BluetoothDevice> {
    private final InterfaceC4461<RxBleAdapterWrapper> adapterWrapperProvider;
    private final InterfaceC4461<String> macAddressProvider;

    public DeviceModule_ProvideBluetoothDeviceFactory(InterfaceC4461<String> interfaceC4461, InterfaceC4461<RxBleAdapterWrapper> interfaceC44612) {
        this.macAddressProvider = interfaceC4461;
        this.adapterWrapperProvider = interfaceC44612;
    }

    public static DeviceModule_ProvideBluetoothDeviceFactory create(InterfaceC4461<String> interfaceC4461, InterfaceC4461<RxBleAdapterWrapper> interfaceC44612) {
        return new DeviceModule_ProvideBluetoothDeviceFactory(interfaceC4461, interfaceC44612);
    }

    public static BluetoothDevice proxyProvideBluetoothDevice(String str, RxBleAdapterWrapper rxBleAdapterWrapper) {
        return (BluetoothDevice) C4618.m14073(DeviceModule.provideBluetoothDevice(str, rxBleAdapterWrapper), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // defpackage.InterfaceC4461
    public BluetoothDevice get() {
        return (BluetoothDevice) C4618.m14073(DeviceModule.provideBluetoothDevice(this.macAddressProvider.get(), this.adapterWrapperProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
