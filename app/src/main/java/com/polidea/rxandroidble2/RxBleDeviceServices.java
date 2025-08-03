package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.exceptions.BleCharacteristicNotFoundException;
import com.polidea.rxandroidble2.exceptions.BleDescriptorNotFoundException;
import com.polidea.rxandroidble2.exceptions.BleServiceNotFoundException;
import defpackage.AbstractC4262;
import defpackage.AbstractC4838;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC4178;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class RxBleDeviceServices {
    public final List<BluetoothGattService> bluetoothGattServices;

    public RxBleDeviceServices(List<BluetoothGattService> list) {
        this.bluetoothGattServices = list;
    }

    public List<BluetoothGattService> getBluetoothGattServices() {
        return this.bluetoothGattServices;
    }

    public AbstractC4838<BluetoothGattCharacteristic> getCharacteristic(@NonNull final UUID uuid) {
        return AbstractC4838.fromCallable(new Callable<BluetoothGattCharacteristic>() { // from class: com.polidea.rxandroidble2.RxBleDeviceServices.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public BluetoothGattCharacteristic call() {
                Iterator<BluetoothGattService> it = RxBleDeviceServices.this.bluetoothGattServices.iterator();
                while (it.hasNext()) {
                    BluetoothGattCharacteristic characteristic = it.next().getCharacteristic(uuid);
                    if (characteristic != null) {
                        return characteristic;
                    }
                }
                throw new BleCharacteristicNotFoundException(uuid);
            }
        });
    }

    public AbstractC4838<BluetoothGattDescriptor> getDescriptor(UUID uuid, final UUID uuid2) {
        return getCharacteristic(uuid).map(new InterfaceC2368<BluetoothGattCharacteristic, BluetoothGattDescriptor>() { // from class: com.polidea.rxandroidble2.RxBleDeviceServices.4
            @Override // defpackage.InterfaceC2368
            public BluetoothGattDescriptor apply(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(uuid2);
                if (descriptor != null) {
                    return descriptor;
                }
                throw new BleDescriptorNotFoundException(uuid2);
            }
        });
    }

    public AbstractC4838<BluetoothGattService> getService(@NonNull final UUID uuid) {
        return AbstractC4262.fromIterable(this.bluetoothGattServices).filter(new InterfaceC4178<BluetoothGattService>() { // from class: com.polidea.rxandroidble2.RxBleDeviceServices.1
            @Override // defpackage.InterfaceC4178
            public boolean test(BluetoothGattService bluetoothGattService) {
                return bluetoothGattService.getUuid().equals(uuid);
            }
        }).firstElement().m13389(AbstractC4838.error(new BleServiceNotFoundException(uuid)));
    }

    public AbstractC4838<BluetoothGattCharacteristic> getCharacteristic(@NonNull UUID uuid, @NonNull final UUID uuid2) {
        return getService(uuid).map(new InterfaceC2368<BluetoothGattService, BluetoothGattCharacteristic>() { // from class: com.polidea.rxandroidble2.RxBleDeviceServices.3
            @Override // defpackage.InterfaceC2368
            public BluetoothGattCharacteristic apply(BluetoothGattService bluetoothGattService) {
                BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid2);
                if (characteristic != null) {
                    return characteristic;
                }
                throw new BleCharacteristicNotFoundException(uuid2);
            }
        });
    }

    public AbstractC4838<BluetoothGattDescriptor> getDescriptor(UUID uuid, final UUID uuid2, final UUID uuid3) {
        return getService(uuid).map(new InterfaceC2368<BluetoothGattService, BluetoothGattCharacteristic>() { // from class: com.polidea.rxandroidble2.RxBleDeviceServices.6
            @Override // defpackage.InterfaceC2368
            public BluetoothGattCharacteristic apply(BluetoothGattService bluetoothGattService) {
                return bluetoothGattService.getCharacteristic(uuid2);
            }
        }).map(new InterfaceC2368<BluetoothGattCharacteristic, BluetoothGattDescriptor>() { // from class: com.polidea.rxandroidble2.RxBleDeviceServices.5
            @Override // defpackage.InterfaceC2368
            public BluetoothGattDescriptor apply(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(uuid3);
                if (descriptor != null) {
                    return descriptor;
                }
                throw new BleDescriptorNotFoundException(uuid3);
            }
        });
    }
}
