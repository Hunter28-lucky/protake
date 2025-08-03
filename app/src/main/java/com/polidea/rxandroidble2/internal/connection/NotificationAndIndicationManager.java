package com.polidea.rxandroidble2.internal.connection;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.exceptions.BleCannotSetCharacteristicNotificationException;
import com.polidea.rxandroidble2.exceptions.BleConflictingNotificationAlreadySetException;
import com.polidea.rxandroidble2.internal.util.ActiveCharacteristicNotification;
import com.polidea.rxandroidble2.internal.util.CharacteristicChangedEvent;
import com.polidea.rxandroidble2.internal.util.CharacteristicNotificationId;
import com.polidea.rxandroidble2.internal.util.ObservableUtil;
import defpackage.AbstractC2900;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC4178;
import defpackage.InterfaceC5066;
import defpackage.InterfaceC5298;
import io.reactivex.internal.functions.Functions;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

@ConnectionScope
/* loaded from: classes2.dex */
class NotificationAndIndicationManager {
    public static final UUID CLIENT_CHARACTERISTIC_CONFIG_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public final Map<CharacteristicNotificationId, ActiveCharacteristicNotification> activeNotificationObservableMap = new HashMap();
    public final BluetoothGatt bluetoothGatt;
    public final byte[] configDisable;
    public final byte[] configEnableIndication;
    public final byte[] configEnableNotification;
    public final DescriptorWriter descriptorWriter;
    public final RxBleGattCallback gattCallback;

    /* renamed from: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        public static final /* synthetic */ int[] $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode;

        static {
            int[] iArr = new int[NotificationSetupMode.values().length];
            $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode = iArr;
            try {
                iArr[NotificationSetupMode.COMPAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode[NotificationSetupMode.QUICK_SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode[NotificationSetupMode.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public NotificationAndIndicationManager(byte[] bArr, byte[] bArr2, byte[] bArr3, BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, DescriptorWriter descriptorWriter) {
        this.configEnableNotification = bArr;
        this.configEnableIndication = bArr2;
        this.configDisable = bArr3;
        this.bluetoothGatt = bluetoothGatt;
        this.gattCallback = rxBleGattCallback;
        this.descriptorWriter = descriptorWriter;
    }

    @NonNull
    public static AbstractC4262<byte[]> observeOnCharacteristicChangeCallbacks(RxBleGattCallback rxBleGattCallback, final CharacteristicNotificationId characteristicNotificationId) {
        return rxBleGattCallback.getOnCharacteristicChanged().filter(new InterfaceC4178<CharacteristicChangedEvent>() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager.6
            @Override // defpackage.InterfaceC4178
            public boolean test(CharacteristicChangedEvent characteristicChangedEvent) {
                return characteristicChangedEvent.equals(characteristicNotificationId);
            }
        }).map(new InterfaceC2368<CharacteristicChangedEvent, byte[]>() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager.5
            @Override // defpackage.InterfaceC2368
            public byte[] apply(CharacteristicChangedEvent characteristicChangedEvent) {
                return characteristicChangedEvent.data;
            }
        });
    }

    @NonNull
    public static AbstractC2900 setCharacteristicNotification(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final boolean z) {
        return AbstractC2900.m10271(new InterfaceC3809() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager.2
            @Override // defpackage.InterfaceC3809
            public void run() {
                if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z)) {
                    throw new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 1, null);
                }
            }
        });
    }

    @NonNull
    public static InterfaceC5298<AbstractC4262<byte[]>, AbstractC4262<byte[]>> setupModeTransformer(final DescriptorWriter descriptorWriter, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr, final NotificationSetupMode notificationSetupMode) {
        return new InterfaceC5298<AbstractC4262<byte[]>, AbstractC4262<byte[]>>() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager.3
            @Override // defpackage.InterfaceC5298
            public InterfaceC2856<AbstractC4262<byte[]>> apply(AbstractC4262<AbstractC4262<byte[]>> abstractC4262) {
                int i = AnonymousClass8.$SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode[notificationSetupMode.ordinal()];
                if (i == 1) {
                    return abstractC4262;
                }
                if (i != 2) {
                    return NotificationAndIndicationManager.writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter, bArr).m10276(abstractC4262);
                }
                final AbstractC2900 abstractC2900IgnoreElements = NotificationAndIndicationManager.writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter, bArr).m10288().publish().m14715(2).ignoreElements();
                return abstractC4262.mergeWith(abstractC2900IgnoreElements).map(new InterfaceC2368<AbstractC4262<byte[]>, AbstractC4262<byte[]>>() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager.3.1
                    @Override // defpackage.InterfaceC2368
                    public AbstractC4262<byte[]> apply(AbstractC4262<byte[]> abstractC42622) {
                        return abstractC42622.mergeWith(abstractC2900IgnoreElements.m10283());
                    }
                });
            }
        };
    }

    @NonNull
    public static InterfaceC5066 teardownModeTransformer(final DescriptorWriter descriptorWriter, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr, final NotificationSetupMode notificationSetupMode) {
        return new InterfaceC5066() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager.4
            @Override // defpackage.InterfaceC5066
            public AbstractC2900 apply(AbstractC2900 abstractC2900) {
                return notificationSetupMode == NotificationSetupMode.COMPAT ? abstractC2900 : abstractC2900.m10275(NotificationAndIndicationManager.writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter, bArr));
            }
        };
    }

    @NonNull
    public static AbstractC2900 writeClientCharacteristicConfig(final BluetoothGattCharacteristic bluetoothGattCharacteristic, DescriptorWriter descriptorWriter, byte[] bArr) {
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_UUID);
        return descriptor == null ? AbstractC2900.m10270(new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 2, null)) : descriptorWriter.writeDescriptor(descriptor, bArr).m10285(new InterfaceC2368<Throwable, InterfaceC2837>() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager.7
            @Override // defpackage.InterfaceC2368
            public InterfaceC2837 apply(Throwable th) {
                return AbstractC2900.m10270(new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 3, th));
            }
        });
    }

    public AbstractC4262<AbstractC4262<byte[]>> setupServerInitiatedCharacteristicRead(@NonNull final BluetoothGattCharacteristic bluetoothGattCharacteristic, final NotificationSetupMode notificationSetupMode, final boolean z) {
        return AbstractC4262.defer(new Callable<InterfaceC2856<AbstractC4262<byte[]>>>() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager.1
            @Override // java.util.concurrent.Callable
            public InterfaceC2856<AbstractC4262<byte[]>> call() {
                synchronized (NotificationAndIndicationManager.this.activeNotificationObservableMap) {
                    final CharacteristicNotificationId characteristicNotificationId = new CharacteristicNotificationId(bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()));
                    ActiveCharacteristicNotification activeCharacteristicNotification = NotificationAndIndicationManager.this.activeNotificationObservableMap.get(characteristicNotificationId);
                    boolean z2 = true;
                    if (activeCharacteristicNotification == null) {
                        byte[] bArr = z ? NotificationAndIndicationManager.this.configEnableIndication : NotificationAndIndicationManager.this.configEnableNotification;
                        final PublishSubject publishSubjectM7034 = PublishSubject.m7034();
                        AbstractC4262 abstractC4262M14718 = NotificationAndIndicationManager.setCharacteristicNotification(NotificationAndIndicationManager.this.bluetoothGatt, bluetoothGattCharacteristic, true).m10276(ObservableUtil.justOnNext(NotificationAndIndicationManager.observeOnCharacteristicChangeCallbacks(NotificationAndIndicationManager.this.gattCallback, characteristicNotificationId))).compose(NotificationAndIndicationManager.setupModeTransformer(NotificationAndIndicationManager.this.descriptorWriter, bluetoothGattCharacteristic, bArr, notificationSetupMode)).map(new InterfaceC2368<AbstractC4262<byte[]>, AbstractC4262<byte[]>>() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager.1.2
                            @Override // defpackage.InterfaceC2368
                            public AbstractC4262<byte[]> apply(AbstractC4262<byte[]> abstractC4262) {
                                return AbstractC4262.amb(Arrays.asList(publishSubjectM7034.cast(byte[].class), abstractC4262.takeUntil(publishSubjectM7034)));
                            }
                        }).doFinally(new InterfaceC3809() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager.1.1
                            @Override // defpackage.InterfaceC3809
                            @SuppressLint({"CheckResult"})
                            public void run() {
                                publishSubjectM7034.onComplete();
                                synchronized (NotificationAndIndicationManager.this.activeNotificationObservableMap) {
                                    NotificationAndIndicationManager.this.activeNotificationObservableMap.remove(characteristicNotificationId);
                                }
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                AbstractC2900 characteristicNotification = NotificationAndIndicationManager.setCharacteristicNotification(NotificationAndIndicationManager.this.bluetoothGatt, bluetoothGattCharacteristic, false);
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                NotificationAndIndicationManager notificationAndIndicationManager = NotificationAndIndicationManager.this;
                                characteristicNotification.m10277(NotificationAndIndicationManager.teardownModeTransformer(notificationAndIndicationManager.descriptorWriter, bluetoothGattCharacteristic, notificationAndIndicationManager.configDisable, notificationSetupMode)).m10287(Functions.f6798, Functions.m6320());
                            }
                        }).mergeWith(NotificationAndIndicationManager.this.gattCallback.observeDisconnect()).replay(1).m14718();
                        NotificationAndIndicationManager.this.activeNotificationObservableMap.put(characteristicNotificationId, new ActiveCharacteristicNotification(abstractC4262M14718, z));
                        return abstractC4262M14718;
                    }
                    if (activeCharacteristicNotification.isIndication == z) {
                        return activeCharacteristicNotification.notificationObservable;
                    }
                    UUID uuid = bluetoothGattCharacteristic.getUuid();
                    if (z) {
                        z2 = false;
                    }
                    return AbstractC4262.error(new BleConflictingNotificationAlreadySetException(uuid, z2));
                }
            }
        });
    }
}
