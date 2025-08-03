package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import com.polidea.rxandroidble2.exceptions.BleGattCannotStartException;
import com.polidea.rxandroidble2.exceptions.BleGattCharacteristicException;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.connection.PayloadSizeLimitProvider;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import com.polidea.rxandroidble2.internal.util.ByteAssociation;
import com.polidea.rxandroidble2.internal.util.DisposableUtil;
import com.polidea.rxandroidble2.internal.util.QueueReleasingEmitterWrapper;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.AbstractC5105;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC4178;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5201;
import defpackage.InterfaceC5245;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes2.dex */
public class CharacteristicLongWriteOperation extends QueueOperation<byte[]> {
    private final PayloadSizeLimitProvider batchSizeProvider;
    private final BluetoothGatt bluetoothGatt;
    private final BluetoothGattCharacteristic bluetoothGattCharacteristic;
    private final AbstractC4585 bluetoothInteractionScheduler;
    public final byte[] bytesToWrite;
    private final RxBleGattCallback rxBleGattCallback;
    private byte[] tempBatchArray;
    private final TimeoutConfiguration timeoutConfiguration;
    private final RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy;
    private final RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy;

    public interface IntSupplier {
        int get();
    }

    public CharacteristicLongWriteOperation(BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, AbstractC4585 abstractC4585, TimeoutConfiguration timeoutConfiguration, BluetoothGattCharacteristic bluetoothGattCharacteristic, PayloadSizeLimitProvider payloadSizeLimitProvider, RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy, RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy, byte[] bArr) {
        this.bluetoothGatt = bluetoothGatt;
        this.rxBleGattCallback = rxBleGattCallback;
        this.bluetoothInteractionScheduler = abstractC4585;
        this.timeoutConfiguration = timeoutConfiguration;
        this.bluetoothGattCharacteristic = bluetoothGattCharacteristic;
        this.batchSizeProvider = payloadSizeLimitProvider;
        this.writeOperationAckStrategy = writeOperationAckStrategy;
        this.writeOperationRetryStrategy = writeOperationRetryStrategy;
        this.bytesToWrite = bArr;
    }

    public static InterfaceC2368<AbstractC4262<?>, InterfaceC2856<?>> bufferIsNotEmptyAndOperationHasBeenAcknowledgedAndNotUnsubscribed(final RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy, final ByteBuffer byteBuffer, final QueueReleasingEmitterWrapper<byte[]> queueReleasingEmitterWrapper) {
        return new InterfaceC2368<AbstractC4262<?>, InterfaceC2856<?>>() { // from class: com.polidea.rxandroidble2.internal.operations.CharacteristicLongWriteOperation.5
            @NonNull
            private InterfaceC2368<Object, Boolean> bufferIsNotEmpty(final ByteBuffer byteBuffer2) {
                return new InterfaceC2368<Object, Boolean>() { // from class: com.polidea.rxandroidble2.internal.operations.CharacteristicLongWriteOperation.5.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // defpackage.InterfaceC2368
                    public Boolean apply(Object obj) {
                        return Boolean.valueOf(byteBuffer2.hasRemaining());
                    }
                };
            }

            @NonNull
            private InterfaceC4178<Object> notUnsubscribed(final QueueReleasingEmitterWrapper<byte[]> queueReleasingEmitterWrapper2) {
                return new InterfaceC4178<Object>() { // from class: com.polidea.rxandroidble2.internal.operations.CharacteristicLongWriteOperation.5.3
                    @Override // defpackage.InterfaceC4178
                    public boolean test(Object obj) {
                        return !queueReleasingEmitterWrapper2.isWrappedEmitterUnsubscribed();
                    }
                };
            }

            @Override // defpackage.InterfaceC2368
            public InterfaceC2856<?> apply(AbstractC4262<?> abstractC4262) {
                return abstractC4262.takeWhile(notUnsubscribed(queueReleasingEmitterWrapper)).map(bufferIsNotEmpty(byteBuffer)).compose(writeOperationAckStrategy).takeWhile(new InterfaceC4178<Boolean>() { // from class: com.polidea.rxandroidble2.internal.operations.CharacteristicLongWriteOperation.5.1
                    @Override // defpackage.InterfaceC4178
                    public boolean test(Boolean bool) {
                        return bool.booleanValue();
                    }
                });
            }
        };
    }

    private static InterfaceC2368<AbstractC4262<Throwable>, InterfaceC2856<?>> errorIsRetryableAndAccordingTo(final RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy, final ByteBuffer byteBuffer, final int i, final IntSupplier intSupplier) {
        return new InterfaceC2368<AbstractC4262<Throwable>, InterfaceC2856<?>>() { // from class: com.polidea.rxandroidble2.internal.operations.CharacteristicLongWriteOperation.6
            @NonNull
            private InterfaceC2857<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure> repositionByteBufferForRetry() {
                return new InterfaceC2857<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure>() { // from class: com.polidea.rxandroidble2.internal.operations.CharacteristicLongWriteOperation.6.2
                    @Override // defpackage.InterfaceC2857
                    public void accept(RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure longWriteFailure) {
                        int batchIndex = longWriteFailure.getBatchIndex();
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        byteBuffer.position(batchIndex * i);
                    }
                };
            }

            @NonNull
            private InterfaceC2368<Throwable, AbstractC4262<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure>> toLongWriteFailureOrError() {
                return new InterfaceC2368<Throwable, AbstractC4262<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure>>() { // from class: com.polidea.rxandroidble2.internal.operations.CharacteristicLongWriteOperation.6.1
                    @Override // defpackage.InterfaceC2368
                    public AbstractC4262<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure> apply(Throwable th) {
                        return ((th instanceof BleGattCharacteristicException) || (th instanceof BleGattCannotStartException)) ? AbstractC4262.just(new RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure(intSupplier.get(), (BleGattException) th)) : AbstractC4262.error(th);
                    }
                };
            }

            @Override // defpackage.InterfaceC2368
            public InterfaceC2856<?> apply(AbstractC4262<Throwable> abstractC4262) {
                return abstractC4262.flatMap(toLongWriteFailureOrError()).doOnNext(repositionByteBufferForRetry()).compose(writeOperationRetryStrategy);
            }
        };
    }

    @NonNull
    private AbstractC4262<ByteAssociation<UUID>> writeBatchAndObserve(final int i, final ByteBuffer byteBuffer, final IntSupplier intSupplier) {
        final AbstractC4262<ByteAssociation<UUID>> onCharacteristicWrite = this.rxBleGattCallback.getOnCharacteristicWrite();
        return AbstractC4262.create(new InterfaceC5201<ByteAssociation<UUID>>() { // from class: com.polidea.rxandroidble2.internal.operations.CharacteristicLongWriteOperation.3
            @Override // defpackage.InterfaceC5201
            public void subscribe(InterfaceC5245<ByteAssociation<UUID>> interfaceC5245) {
                interfaceC5245.mo6762((AbstractC5105) onCharacteristicWrite.subscribeWith(DisposableUtil.disposableObserverFromEmitter(interfaceC5245)));
                try {
                    CharacteristicLongWriteOperation.this.writeData(CharacteristicLongWriteOperation.this.getNextBatch(byteBuffer, i), intSupplier);
                } catch (Throwable th) {
                    interfaceC5245.onError(th);
                }
            }
        });
    }

    private static InterfaceC4178<ByteAssociation<UUID>> writeResponseForMatchingCharacteristic(final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return new InterfaceC4178<ByteAssociation<UUID>>() { // from class: com.polidea.rxandroidble2.internal.operations.CharacteristicLongWriteOperation.4
            @Override // defpackage.InterfaceC4178
            public boolean test(ByteAssociation<UUID> byteAssociation) {
                return byteAssociation.first.equals(bluetoothGattCharacteristic.getUuid());
            }
        };
    }

    public byte[] getNextBatch(ByteBuffer byteBuffer, int i) {
        int iMin = Math.min(byteBuffer.remaining(), i);
        byte[] bArr = this.tempBatchArray;
        if (bArr == null || bArr.length != iMin) {
            this.tempBatchArray = new byte[iMin];
        }
        byteBuffer.get(this.tempBatchArray);
        return this.tempBatchArray;
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public void protectedRun(InterfaceC5245<byte[]> interfaceC5245, QueueReleaseInterface queueReleaseInterface) {
        final int payloadSizeLimit = this.batchSizeProvider.getPayloadSizeLimit();
        if (payloadSizeLimit <= 0) {
            throw new IllegalArgumentException("batchSizeProvider value must be greater than zero (now: " + payloadSizeLimit + ")");
        }
        AbstractC4262 abstractC4262Error = AbstractC4262.error(new BleGattCallbackTimeoutException(this.bluetoothGatt, BleGattOperationType.CHARACTERISTIC_LONG_WRITE));
        final ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.bytesToWrite);
        final QueueReleasingEmitterWrapper queueReleasingEmitterWrapper = new QueueReleasingEmitterWrapper(interfaceC5245, queueReleaseInterface);
        IntSupplier intSupplier = new IntSupplier() { // from class: com.polidea.rxandroidble2.internal.operations.CharacteristicLongWriteOperation.1
            @Override // com.polidea.rxandroidble2.internal.operations.CharacteristicLongWriteOperation.IntSupplier
            public int get() {
                return ((int) Math.ceil(byteBufferWrap.position() / payloadSizeLimit)) - 1;
            }
        };
        AbstractC4262<ByteAssociation<UUID>> abstractC4262Take = writeBatchAndObserve(payloadSizeLimit, byteBufferWrap, intSupplier).subscribeOn(this.bluetoothInteractionScheduler).filter(writeResponseForMatchingCharacteristic(this.bluetoothGattCharacteristic)).take(1L);
        TimeoutConfiguration timeoutConfiguration = this.timeoutConfiguration;
        abstractC4262Take.timeout(timeoutConfiguration.timeout, timeoutConfiguration.timeoutTimeUnit, timeoutConfiguration.timeoutScheduler, abstractC4262Error).repeatWhen(bufferIsNotEmptyAndOperationHasBeenAcknowledgedAndNotUnsubscribed(this.writeOperationAckStrategy, byteBufferWrap, queueReleasingEmitterWrapper)).retryWhen(errorIsRetryableAndAccordingTo(this.writeOperationRetryStrategy, byteBufferWrap, payloadSizeLimit, intSupplier)).subscribe(new InterfaceC5102<ByteAssociation<UUID>>() { // from class: com.polidea.rxandroidble2.internal.operations.CharacteristicLongWriteOperation.2
            @Override // defpackage.InterfaceC5102
            public void onComplete() {
                queueReleasingEmitterWrapper.onNext(CharacteristicLongWriteOperation.this.bytesToWrite);
                queueReleasingEmitterWrapper.onComplete();
            }

            @Override // defpackage.InterfaceC5102
            public void onError(Throwable th) {
                queueReleasingEmitterWrapper.onError(th);
            }

            @Override // defpackage.InterfaceC5102
            public void onNext(ByteAssociation<UUID> byteAssociation) {
            }

            @Override // defpackage.InterfaceC5102
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
            }
        });
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public BleException provideException(DeadObjectException deadObjectException) {
        return new BleDisconnectedException(deadObjectException, this.bluetoothGatt.getDevice().getAddress(), -1);
    }

    public String toString() {
        return "CharacteristicLongWriteOperation{" + LoggerUtil.commonMacMessage(this.bluetoothGatt) + ", characteristic=" + LoggerUtil.wrap(this.bluetoothGattCharacteristic, false) + ", maxBatchSize=" + this.batchSizeProvider.getPayloadSizeLimit() + '}';
    }

    public void writeData(byte[] bArr, IntSupplier intSupplier) {
        if (RxBleLog.isAtLeast(3)) {
            RxBleLog.d("Writing batch #%04d: %s", Integer.valueOf(intSupplier.get()), LoggerUtil.bytesToHex(bArr));
        }
        this.bluetoothGattCharacteristic.setValue(bArr);
        if (!this.bluetoothGatt.writeCharacteristic(this.bluetoothGattCharacteristic)) {
            throw new BleGattCannotStartException(this.bluetoothGatt, BleGattOperationType.CHARACTERISTIC_LONG_WRITE);
        }
    }
}
