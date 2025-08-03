package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.polidea.rxandroidble2.ConnectionParameters;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleCustomOperation;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.internal.Priority;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import com.polidea.rxandroidble2.internal.util.ByteAssociation;
import com.polidea.rxandroidble2.internal.util.QueueReleasingEmitterWrapper;
import defpackage.AbstractC2900;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.AbstractC4838;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4461;
import defpackage.InterfaceC5245;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@ConnectionScope
/* loaded from: classes2.dex */
public class RxBleConnectionImpl implements RxBleConnection {
    public final BluetoothGatt bluetoothGatt;
    public final AbstractC4585 callbackScheduler;
    private final DescriptorWriter descriptorWriter;
    public final RxBleGattCallback gattCallback;
    private final IllegalOperationChecker illegalOperationChecker;
    private final InterfaceC4461<RxBleConnection.LongWriteOperationBuilder> longWriteOperationBuilderProvider;
    private final MtuProvider mtuProvider;
    private final NotificationAndIndicationManager notificationIndicationManager;
    private final ConnectionOperationQueue operationQueue;
    private final OperationsProvider operationsProvider;
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    public RxBleConnectionImpl(ConnectionOperationQueue connectionOperationQueue, RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, ServiceDiscoveryManager serviceDiscoveryManager, NotificationAndIndicationManager notificationAndIndicationManager, MtuProvider mtuProvider, DescriptorWriter descriptorWriter, OperationsProvider operationsProvider, InterfaceC4461<RxBleConnection.LongWriteOperationBuilder> interfaceC4461, AbstractC4585 abstractC4585, IllegalOperationChecker illegalOperationChecker) {
        this.operationQueue = connectionOperationQueue;
        this.gattCallback = rxBleGattCallback;
        this.bluetoothGatt = bluetoothGatt;
        this.serviceDiscoveryManager = serviceDiscoveryManager;
        this.notificationIndicationManager = notificationAndIndicationManager;
        this.mtuProvider = mtuProvider;
        this.descriptorWriter = descriptorWriter;
        this.operationsProvider = operationsProvider;
        this.longWriteOperationBuilderProvider = interfaceC4461;
        this.callbackScheduler = abstractC4585;
        this.illegalOperationChecker = illegalOperationChecker;
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public RxBleConnection.LongWriteOperationBuilder createNewLongWriteBuilder() {
        return this.longWriteOperationBuilderProvider.get();
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4838<RxBleDeviceServices> discoverServices() {
        return this.serviceDiscoveryManager.getDiscoverServicesSingle(20L, TimeUnit.SECONDS);
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    @Deprecated
    public AbstractC4838<BluetoothGattCharacteristic> getCharacteristic(@NonNull final UUID uuid) {
        return discoverServices().flatMap(new InterfaceC2368<RxBleDeviceServices, AbstractC4838<? extends BluetoothGattCharacteristic>>() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.1
            @Override // defpackage.InterfaceC2368
            public AbstractC4838<? extends BluetoothGattCharacteristic> apply(RxBleDeviceServices rxBleDeviceServices) {
                return rxBleDeviceServices.getCharacteristic(uuid);
            }
        });
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public int getMtu() {
        return this.mtuProvider.getMtu();
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4262<ConnectionParameters> observeConnectionParametersUpdates() {
        return this.gattCallback.getConnectionParametersUpdates();
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public <T> AbstractC4262<T> queue(@NonNull RxBleCustomOperation<T> rxBleCustomOperation) {
        return queue(rxBleCustomOperation, Priority.NORMAL);
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4838<byte[]> readCharacteristic(@NonNull UUID uuid) {
        return getCharacteristic(uuid).flatMap(new InterfaceC2368<BluetoothGattCharacteristic, InterfaceC3951<? extends byte[]>>() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.4
            @Override // defpackage.InterfaceC2368
            public InterfaceC3951<? extends byte[]> apply(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                return RxBleConnectionImpl.this.readCharacteristic(bluetoothGattCharacteristic);
            }
        });
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4838<byte[]> readDescriptor(@NonNull final UUID uuid, @NonNull final UUID uuid2, @NonNull final UUID uuid3) {
        return discoverServices().flatMap(new InterfaceC2368<RxBleDeviceServices, InterfaceC3951<BluetoothGattDescriptor>>() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.7
            @Override // defpackage.InterfaceC2368
            public InterfaceC3951<BluetoothGattDescriptor> apply(RxBleDeviceServices rxBleDeviceServices) {
                return rxBleDeviceServices.getDescriptor(uuid, uuid2, uuid3);
            }
        }).flatMap(new InterfaceC2368<BluetoothGattDescriptor, InterfaceC3951<byte[]>>() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.6
            @Override // defpackage.InterfaceC2368
            public InterfaceC3951<byte[]> apply(BluetoothGattDescriptor bluetoothGattDescriptor) {
                return RxBleConnectionImpl.this.readDescriptor(bluetoothGattDescriptor);
            }
        });
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4838<Integer> readRssi() {
        return this.operationQueue.queue(this.operationsProvider.provideRssiReadOperation()).firstOrError();
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    @RequiresApi(21)
    public AbstractC2900 requestConnectionPriority(int i, long j, @NonNull TimeUnit timeUnit) {
        if (i == 2 || i == 0 || i == 1) {
            return j <= 0 ? AbstractC2900.m10270(new IllegalArgumentException("Delay must be bigger than 0")) : this.operationQueue.queue(this.operationsProvider.provideConnectionPriorityChangeOperation(i, j, timeUnit)).ignoreElements();
        }
        return AbstractC2900.m10270(new IllegalArgumentException("Connection priority must have valid value from BluetoothGatt (received " + i + ")"));
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    @RequiresApi(21)
    public AbstractC4838<Integer> requestMtu(int i) {
        return this.operationQueue.queue(this.operationsProvider.provideMtuChangeOperation(i)).firstOrError();
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4262<AbstractC4262<byte[]>> setupIndication(@NonNull UUID uuid) {
        return setupIndication(uuid, NotificationSetupMode.DEFAULT);
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4262<AbstractC4262<byte[]>> setupNotification(@NonNull UUID uuid) {
        return setupNotification(uuid, NotificationSetupMode.DEFAULT);
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4838<byte[]> writeCharacteristic(@NonNull UUID uuid, @NonNull final byte[] bArr) {
        return getCharacteristic(uuid).flatMap(new InterfaceC2368<BluetoothGattCharacteristic, InterfaceC3951<? extends byte[]>>() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.5
            @Override // defpackage.InterfaceC2368
            public InterfaceC3951<? extends byte[]> apply(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                return RxBleConnectionImpl.this.writeCharacteristic(bluetoothGattCharacteristic, bArr);
            }
        });
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC2900 writeDescriptor(@NonNull final UUID uuid, @NonNull final UUID uuid2, @NonNull final UUID uuid3, @NonNull final byte[] bArr) {
        return discoverServices().flatMap(new InterfaceC2368<RxBleDeviceServices, InterfaceC3951<BluetoothGattDescriptor>>() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.10
            @Override // defpackage.InterfaceC2368
            public InterfaceC3951<BluetoothGattDescriptor> apply(RxBleDeviceServices rxBleDeviceServices) {
                return rxBleDeviceServices.getDescriptor(uuid, uuid2, uuid3);
            }
        }).flatMapCompletable(new InterfaceC2368<BluetoothGattDescriptor, InterfaceC2837>() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.9
            @Override // defpackage.InterfaceC2368
            public InterfaceC2837 apply(BluetoothGattDescriptor bluetoothGattDescriptor) {
                return RxBleConnectionImpl.this.writeDescriptor(bluetoothGattDescriptor, bArr);
            }
        });
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4838<RxBleDeviceServices> discoverServices(long j, @NonNull TimeUnit timeUnit) {
        return this.serviceDiscoveryManager.getDiscoverServicesSingle(j, timeUnit);
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public <T> AbstractC4262<T> queue(@NonNull final RxBleCustomOperation<T> rxBleCustomOperation, @NonNull final Priority priority) {
        return this.operationQueue.queue(new QueueOperation<T>() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.11
            private InterfaceC3809 clearNativeCallbackReferenceAction() {
                return new InterfaceC3809() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.11.1
                    @Override // defpackage.InterfaceC3809
                    public void run() {
                        RxBleConnectionImpl.this.gattCallback.setNativeCallback(null);
                        RxBleConnectionImpl.this.gattCallback.setHiddenNativeCallback(null);
                    }
                };
            }

            @Override // com.polidea.rxandroidble2.internal.QueueOperation, com.polidea.rxandroidble2.internal.operations.Operation
            public Priority definedPriority() {
                return priority;
            }

            @Override // com.polidea.rxandroidble2.internal.QueueOperation
            public void protectedRun(InterfaceC5245<T> interfaceC5245, QueueReleaseInterface queueReleaseInterface) throws Throwable {
                try {
                    RxBleCustomOperation rxBleCustomOperation2 = rxBleCustomOperation;
                    RxBleConnectionImpl rxBleConnectionImpl = RxBleConnectionImpl.this;
                    AbstractC4262<T> abstractC4262AsObservable = rxBleCustomOperation2.asObservable(rxBleConnectionImpl.bluetoothGatt, rxBleConnectionImpl.gattCallback, rxBleConnectionImpl.callbackScheduler);
                    if (abstractC4262AsObservable == null) {
                        queueReleaseInterface.release();
                        throw new IllegalArgumentException("The custom operation asObservable method must return a non-null observable");
                    }
                    abstractC4262AsObservable.doOnTerminate(clearNativeCallbackReferenceAction()).subscribe(new QueueReleasingEmitterWrapper(interfaceC5245, queueReleaseInterface));
                } catch (Throwable th) {
                    queueReleaseInterface.release();
                    throw th;
                }
            }

            @Override // com.polidea.rxandroidble2.internal.QueueOperation
            public BleException provideException(DeadObjectException deadObjectException) {
                return new BleDisconnectedException(deadObjectException, RxBleConnectionImpl.this.bluetoothGatt.getDevice().getAddress(), -1);
            }
        });
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4262<AbstractC4262<byte[]>> setupIndication(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return setupIndication(bluetoothGattCharacteristic, NotificationSetupMode.DEFAULT);
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4262<AbstractC4262<byte[]>> setupNotification(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return setupNotification(bluetoothGattCharacteristic, NotificationSetupMode.DEFAULT);
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4838<byte[]> readCharacteristic(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return this.illegalOperationChecker.checkAnyPropertyMatches(bluetoothGattCharacteristic, 2).m10276(this.operationQueue.queue(this.operationsProvider.provideReadCharacteristic(bluetoothGattCharacteristic))).firstOrError();
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4262<AbstractC4262<byte[]>> setupIndication(@NonNull UUID uuid, @NonNull final NotificationSetupMode notificationSetupMode) {
        return getCharacteristic(uuid).flatMapObservable(new InterfaceC2368<BluetoothGattCharacteristic, InterfaceC2856<? extends AbstractC4262<byte[]>>>() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.3
            @Override // defpackage.InterfaceC2368
            public AbstractC4262<? extends AbstractC4262<byte[]>> apply(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                return RxBleConnectionImpl.this.setupIndication(bluetoothGattCharacteristic, notificationSetupMode);
            }
        });
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4262<AbstractC4262<byte[]>> setupNotification(@NonNull UUID uuid, @NonNull final NotificationSetupMode notificationSetupMode) {
        return getCharacteristic(uuid).flatMapObservable(new InterfaceC2368<BluetoothGattCharacteristic, InterfaceC2856<? extends AbstractC4262<byte[]>>>() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.2
            @Override // defpackage.InterfaceC2368
            public AbstractC4262<? extends AbstractC4262<byte[]>> apply(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                return RxBleConnectionImpl.this.setupNotification(bluetoothGattCharacteristic, notificationSetupMode);
            }
        });
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4838<byte[]> writeCharacteristic(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) {
        return this.illegalOperationChecker.checkAnyPropertyMatches(bluetoothGattCharacteristic, 76).m10276(this.operationQueue.queue(this.operationsProvider.provideWriteCharacteristic(bluetoothGattCharacteristic, bArr))).firstOrError();
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4838<byte[]> readDescriptor(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor) {
        return this.operationQueue.queue(this.operationsProvider.provideReadDescriptor(bluetoothGattDescriptor)).firstOrError().map(new InterfaceC2368<ByteAssociation<BluetoothGattDescriptor>, byte[]>() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleConnectionImpl.8
            @Override // defpackage.InterfaceC2368
            public byte[] apply(ByteAssociation<BluetoothGattDescriptor> byteAssociation) {
                return byteAssociation.second;
            }
        });
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC2900 writeDescriptor(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor, @NonNull byte[] bArr) {
        return this.descriptorWriter.writeDescriptor(bluetoothGattDescriptor, bArr);
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4262<AbstractC4262<byte[]>> setupIndication(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull NotificationSetupMode notificationSetupMode) {
        return this.illegalOperationChecker.checkAnyPropertyMatches(bluetoothGattCharacteristic, 32).m10276(this.notificationIndicationManager.setupServerInitiatedCharacteristicRead(bluetoothGattCharacteristic, notificationSetupMode, true));
    }

    @Override // com.polidea.rxandroidble2.RxBleConnection
    public AbstractC4262<AbstractC4262<byte[]>> setupNotification(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull NotificationSetupMode notificationSetupMode) {
        return this.illegalOperationChecker.checkAnyPropertyMatches(bluetoothGattCharacteristic, 16).m10276(this.notificationIndicationManager.setupServerInitiatedCharacteristicRead(bluetoothGattCharacteristic, notificationSetupMode, false));
    }
}
