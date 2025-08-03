package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class NotificationAndIndicationManager_Factory implements InterfaceC3628<NotificationAndIndicationManager> {
    private final InterfaceC4461<BluetoothGatt> bluetoothGattProvider;
    private final InterfaceC4461<byte[]> configDisableProvider;
    private final InterfaceC4461<byte[]> configEnableIndicationProvider;
    private final InterfaceC4461<byte[]> configEnableNotificationProvider;
    private final InterfaceC4461<DescriptorWriter> descriptorWriterProvider;
    private final InterfaceC4461<RxBleGattCallback> gattCallbackProvider;

    public NotificationAndIndicationManager_Factory(InterfaceC4461<byte[]> interfaceC4461, InterfaceC4461<byte[]> interfaceC44612, InterfaceC4461<byte[]> interfaceC44613, InterfaceC4461<BluetoothGatt> interfaceC44614, InterfaceC4461<RxBleGattCallback> interfaceC44615, InterfaceC4461<DescriptorWriter> interfaceC44616) {
        this.configEnableNotificationProvider = interfaceC4461;
        this.configEnableIndicationProvider = interfaceC44612;
        this.configDisableProvider = interfaceC44613;
        this.bluetoothGattProvider = interfaceC44614;
        this.gattCallbackProvider = interfaceC44615;
        this.descriptorWriterProvider = interfaceC44616;
    }

    public static NotificationAndIndicationManager_Factory create(InterfaceC4461<byte[]> interfaceC4461, InterfaceC4461<byte[]> interfaceC44612, InterfaceC4461<byte[]> interfaceC44613, InterfaceC4461<BluetoothGatt> interfaceC44614, InterfaceC4461<RxBleGattCallback> interfaceC44615, InterfaceC4461<DescriptorWriter> interfaceC44616) {
        return new NotificationAndIndicationManager_Factory(interfaceC4461, interfaceC44612, interfaceC44613, interfaceC44614, interfaceC44615, interfaceC44616);
    }

    public static NotificationAndIndicationManager newNotificationAndIndicationManager(byte[] bArr, byte[] bArr2, byte[] bArr3, BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, Object obj) {
        return new NotificationAndIndicationManager(bArr, bArr2, bArr3, bluetoothGatt, rxBleGattCallback, (DescriptorWriter) obj);
    }

    @Override // defpackage.InterfaceC4461
    public NotificationAndIndicationManager get() {
        return new NotificationAndIndicationManager(this.configEnableNotificationProvider.get(), this.configEnableIndicationProvider.get(), this.configDisableProvider.get(), this.bluetoothGattProvider.get(), this.gattCallbackProvider.get(), this.descriptorWriterProvider.get());
    }
}
