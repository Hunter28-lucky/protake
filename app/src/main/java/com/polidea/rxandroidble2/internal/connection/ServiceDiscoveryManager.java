package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattService;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import defpackage.AbstractC4274;
import defpackage.AbstractC4838;
import defpackage.C4877;
import defpackage.C5190;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC4178;
import defpackage.InterfaceC4478;
import defpackage.k0;
import io.reactivex.internal.functions.Functions;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@ConnectionScope
/* loaded from: classes2.dex */
class ServiceDiscoveryManager {
    public final BluetoothGatt bluetoothGatt;
    private AbstractC4838<RxBleDeviceServices> deviceServicesObservable;
    public final OperationsProvider operationProvider;
    public final ConnectionOperationQueue operationQueue;
    public final k0<TimeoutConfiguration> timeoutBehaviorSubject = C5190.m15160().m7171();
    public boolean hasCachedResults = false;

    public ServiceDiscoveryManager(ConnectionOperationQueue connectionOperationQueue, BluetoothGatt bluetoothGatt, OperationsProvider operationsProvider) {
        this.operationQueue = connectionOperationQueue;
        this.bluetoothGatt = bluetoothGatt;
        this.operationProvider = operationsProvider;
        reset();
    }

    private AbstractC4274<List<BluetoothGattService>> getListOfServicesFromGatt() {
        return AbstractC4838.fromCallable(new Callable<List<BluetoothGattService>>() { // from class: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager.6
            @Override // java.util.concurrent.Callable
            public List<BluetoothGattService> call() {
                return ServiceDiscoveryManager.this.bluetoothGatt.getServices();
            }
        }).filter(new InterfaceC4178<List<BluetoothGattService>>() { // from class: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager.5
            @Override // defpackage.InterfaceC4178
            public boolean test(List<BluetoothGattService> list) {
                return list.size() > 0;
            }
        });
    }

    @NonNull
    private AbstractC4838<TimeoutConfiguration> getTimeoutConfiguration() {
        return this.timeoutBehaviorSubject.firstOrError();
    }

    @NonNull
    private InterfaceC2368<TimeoutConfiguration, AbstractC4838<RxBleDeviceServices>> scheduleActualDiscoveryWithTimeout() {
        return new InterfaceC2368<TimeoutConfiguration, AbstractC4838<RxBleDeviceServices>>() { // from class: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager.7
            @Override // defpackage.InterfaceC2368
            public AbstractC4838<RxBleDeviceServices> apply(TimeoutConfiguration timeoutConfiguration) {
                return ServiceDiscoveryManager.this.operationQueue.queue(ServiceDiscoveryManager.this.operationProvider.provideServiceDiscoveryOperation(timeoutConfiguration.timeout, timeoutConfiguration.timeoutTimeUnit)).firstOrError();
            }
        };
    }

    @NonNull
    private static InterfaceC2368<List<BluetoothGattService>, RxBleDeviceServices> wrapIntoRxBleDeviceServices() {
        return new InterfaceC2368<List<BluetoothGattService>, RxBleDeviceServices>() { // from class: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager.4
            @Override // defpackage.InterfaceC2368
            public RxBleDeviceServices apply(List<BluetoothGattService> list) {
                return new RxBleDeviceServices(list);
            }
        };
    }

    public AbstractC4838<RxBleDeviceServices> getDiscoverServicesSingle(final long j, final TimeUnit timeUnit) {
        return this.hasCachedResults ? this.deviceServicesObservable : this.deviceServicesObservable.doOnSubscribe(new InterfaceC2857<InterfaceC4478>() { // from class: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager.1
            @Override // defpackage.InterfaceC2857
            public void accept(InterfaceC4478 interfaceC4478) {
                ServiceDiscoveryManager.this.timeoutBehaviorSubject.onNext(new TimeoutConfiguration(j, timeUnit, C4877.m14600()));
            }
        });
    }

    public void reset() {
        this.hasCachedResults = false;
        this.deviceServicesObservable = getListOfServicesFromGatt().m13388(wrapIntoRxBleDeviceServices()).m13389(getTimeoutConfiguration().flatMap(scheduleActualDiscoveryWithTimeout())).doOnSuccess(Functions.m6313(new InterfaceC3809() { // from class: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager.3
            @Override // defpackage.InterfaceC3809
            public void run() {
                ServiceDiscoveryManager.this.hasCachedResults = true;
            }
        })).doOnError(Functions.m6313(new InterfaceC3809() { // from class: com.polidea.rxandroidble2.internal.connection.ServiceDiscoveryManager.2
            @Override // defpackage.InterfaceC3809
            public void run() {
                ServiceDiscoveryManager.this.reset();
            }
        })).cache();
    }
}
