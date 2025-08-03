package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import com.polidea.rxandroidble2.internal.Priority;
import defpackage.AbstractC2900;
import defpackage.AbstractC4262;
import defpackage.AbstractC4838;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC5298;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public interface RxBleConnection {
    public static final int GATT_MTU_MAXIMUM = 517;
    public static final int GATT_MTU_MINIMUM = 23;
    public static final int GATT_READ_MTU_OVERHEAD = 1;
    public static final int GATT_WRITE_MTU_OVERHEAD = 3;

    @RequiresApi(21)
    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionPriority {
    }

    @Deprecated
    public interface Connector {
        AbstractC4838<RxBleConnection> prepareConnection(boolean z);
    }

    public interface LongWriteOperationBuilder {
        AbstractC4262<byte[]> build();

        LongWriteOperationBuilder setBytes(@NonNull byte[] bArr);

        LongWriteOperationBuilder setCharacteristic(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic);

        LongWriteOperationBuilder setCharacteristicUuid(@NonNull UUID uuid);

        LongWriteOperationBuilder setMaxBatchSize(@IntRange(from = 1, to = 514) int i);

        LongWriteOperationBuilder setWriteOperationAckStrategy(@NonNull WriteOperationAckStrategy writeOperationAckStrategy);

        LongWriteOperationBuilder setWriteOperationRetryStrategy(@NonNull WriteOperationRetryStrategy writeOperationRetryStrategy);
    }

    public enum RxBleConnectionState {
        CONNECTING("CONNECTING"),
        CONNECTED("CONNECTED"),
        DISCONNECTED("DISCONNECTED"),
        DISCONNECTING("DISCONNECTING");

        private final String description;

        RxBleConnectionState(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "RxBleConnectionState{" + this.description + '}';
        }
    }

    public interface WriteOperationAckStrategy extends InterfaceC5298<Boolean, Boolean> {
        @Override // defpackage.InterfaceC5298
        /* synthetic */ InterfaceC2856<Boolean> apply(AbstractC4262<Boolean> abstractC4262);
    }

    public interface WriteOperationRetryStrategy extends InterfaceC5298<LongWriteFailure, LongWriteFailure> {

        public static class LongWriteFailure {
            public final int batchIndex;
            public final BleGattException cause;

            public LongWriteFailure(int i, BleGattException bleGattException) {
                this.batchIndex = i;
                this.cause = bleGattException;
            }

            public int getBatchIndex() {
                return this.batchIndex;
            }

            public BleGattException getCause() {
                return this.cause;
            }
        }

        @Override // defpackage.InterfaceC5298
        /* synthetic */ InterfaceC2856<LongWriteFailure> apply(AbstractC4262<LongWriteFailure> abstractC4262);
    }

    LongWriteOperationBuilder createNewLongWriteBuilder();

    AbstractC4838<RxBleDeviceServices> discoverServices();

    AbstractC4838<RxBleDeviceServices> discoverServices(@IntRange(from = 1) long j, @NonNull TimeUnit timeUnit);

    @Deprecated
    AbstractC4838<BluetoothGattCharacteristic> getCharacteristic(@NonNull UUID uuid);

    int getMtu();

    @RequiresApi(26)
    AbstractC4262<ConnectionParameters> observeConnectionParametersUpdates();

    <T> AbstractC4262<T> queue(@NonNull RxBleCustomOperation<T> rxBleCustomOperation);

    <T> AbstractC4262<T> queue(@NonNull RxBleCustomOperation<T> rxBleCustomOperation, Priority priority);

    AbstractC4838<byte[]> readCharacteristic(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic);

    AbstractC4838<byte[]> readCharacteristic(@NonNull UUID uuid);

    AbstractC4838<byte[]> readDescriptor(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor);

    AbstractC4838<byte[]> readDescriptor(@NonNull UUID uuid, @NonNull UUID uuid2, @NonNull UUID uuid3);

    AbstractC4838<Integer> readRssi();

    @RequiresApi(21)
    AbstractC2900 requestConnectionPriority(int i, @IntRange(from = 1) long j, @NonNull TimeUnit timeUnit);

    @RequiresApi(21)
    AbstractC4838<Integer> requestMtu(@IntRange(from = 23, to = 517) int i);

    AbstractC4262<AbstractC4262<byte[]>> setupIndication(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic);

    AbstractC4262<AbstractC4262<byte[]>> setupIndication(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull NotificationSetupMode notificationSetupMode);

    AbstractC4262<AbstractC4262<byte[]>> setupIndication(@NonNull UUID uuid);

    AbstractC4262<AbstractC4262<byte[]>> setupIndication(@NonNull UUID uuid, @NonNull NotificationSetupMode notificationSetupMode);

    AbstractC4262<AbstractC4262<byte[]>> setupNotification(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic);

    AbstractC4262<AbstractC4262<byte[]>> setupNotification(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull NotificationSetupMode notificationSetupMode);

    AbstractC4262<AbstractC4262<byte[]>> setupNotification(@NonNull UUID uuid);

    AbstractC4262<AbstractC4262<byte[]>> setupNotification(@NonNull UUID uuid, @NonNull NotificationSetupMode notificationSetupMode);

    AbstractC4838<byte[]> writeCharacteristic(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr);

    AbstractC4838<byte[]> writeCharacteristic(@NonNull UUID uuid, @NonNull byte[] bArr);

    AbstractC2900 writeDescriptor(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor, @NonNull byte[] bArr);

    AbstractC2900 writeDescriptor(@NonNull UUID uuid, @NonNull UUID uuid2, @NonNull UUID uuid3, @NonNull byte[] bArr);
}
