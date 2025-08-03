package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices;
import defpackage.AbstractC4585;
import defpackage.AbstractC4838;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3951;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ServiceDiscoveryOperation extends SingleResponseOperation<RxBleDeviceServices> {
    public final LoggerUtilBluetoothServices bleServicesLogger;
    public final BluetoothGatt bluetoothGatt;

    /* renamed from: com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation$2, reason: invalid class name */
    public class AnonymousClass2 implements Callable<InterfaceC3951<? extends RxBleDeviceServices>> {
        public final /* synthetic */ BluetoothGatt val$bluetoothGatt;
        public final /* synthetic */ AbstractC4585 val$timeoutScheduler;

        public AnonymousClass2(BluetoothGatt bluetoothGatt, AbstractC4585 abstractC4585) {
            this.val$bluetoothGatt = bluetoothGatt;
            this.val$timeoutScheduler = abstractC4585;
        }

        @Override // java.util.concurrent.Callable
        public InterfaceC3951<? extends RxBleDeviceServices> call() {
            return this.val$bluetoothGatt.getServices().size() == 0 ? AbstractC4838.error(new BleGattCallbackTimeoutException(this.val$bluetoothGatt, BleGattOperationType.SERVICE_DISCOVERY)) : AbstractC4838.timer(5L, TimeUnit.SECONDS, this.val$timeoutScheduler).flatMap(new InterfaceC2368<Long, AbstractC4838<RxBleDeviceServices>>() { // from class: com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation.2.1
                @Override // defpackage.InterfaceC2368
                public AbstractC4838<RxBleDeviceServices> apply(Long l) {
                    return AbstractC4838.fromCallable(new Callable<RxBleDeviceServices>() { // from class: com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation.2.1.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.concurrent.Callable
                        public RxBleDeviceServices call() {
                            return new RxBleDeviceServices(AnonymousClass2.this.val$bluetoothGatt.getServices());
                        }
                    });
                }
            });
        }
    }

    public ServiceDiscoveryOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, LoggerUtilBluetoothServices loggerUtilBluetoothServices, TimeoutConfiguration timeoutConfiguration) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.SERVICE_DISCOVERY, timeoutConfiguration);
        this.bluetoothGatt = bluetoothGatt;
        this.bleServicesLogger = loggerUtilBluetoothServices;
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public AbstractC4838<RxBleDeviceServices> getCallback(RxBleGattCallback rxBleGattCallback) {
        return rxBleGattCallback.getOnServicesDiscovered().firstOrError().doOnSuccess(new InterfaceC2857<RxBleDeviceServices>() { // from class: com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation.1
            @Override // defpackage.InterfaceC2857
            public void accept(RxBleDeviceServices rxBleDeviceServices) {
                ServiceDiscoveryOperation serviceDiscoveryOperation = ServiceDiscoveryOperation.this;
                serviceDiscoveryOperation.bleServicesLogger.log(rxBleDeviceServices, serviceDiscoveryOperation.bluetoothGatt.getDevice());
            }
        });
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public boolean startOperation(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.discoverServices();
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    @NonNull
    public AbstractC4838<RxBleDeviceServices> timeoutFallbackProcedure(BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, AbstractC4585 abstractC4585) {
        return AbstractC4838.defer(new AnonymousClass2(bluetoothGatt, abstractC4585));
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public String toString() {
        return "ServiceDiscoveryOperation{" + super.toString() + '}';
    }
}
