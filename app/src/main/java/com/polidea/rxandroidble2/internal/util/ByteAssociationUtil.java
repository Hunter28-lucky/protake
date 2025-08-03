package com.polidea.rxandroidble2.internal.util;

import android.bluetooth.BluetoothGattDescriptor;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC4178;
import java.util.UUID;

/* loaded from: classes2.dex */
public class ByteAssociationUtil {
    private ByteAssociationUtil() {
    }

    public static InterfaceC4178<? super ByteAssociation<UUID>> characteristicUUIDPredicate(final UUID uuid) {
        return new InterfaceC4178<ByteAssociation<UUID>>() { // from class: com.polidea.rxandroidble2.internal.util.ByteAssociationUtil.1
            @Override // defpackage.InterfaceC4178
            public boolean test(ByteAssociation<UUID> byteAssociation) {
                return byteAssociation.first.equals(uuid);
            }
        };
    }

    public static InterfaceC4178<? super ByteAssociation<BluetoothGattDescriptor>> descriptorPredicate(final BluetoothGattDescriptor bluetoothGattDescriptor) {
        return new InterfaceC4178<ByteAssociation<BluetoothGattDescriptor>>() { // from class: com.polidea.rxandroidble2.internal.util.ByteAssociationUtil.3
            @Override // defpackage.InterfaceC4178
            public boolean test(ByteAssociation<BluetoothGattDescriptor> byteAssociation) {
                return byteAssociation.first.equals(bluetoothGattDescriptor);
            }
        };
    }

    public static InterfaceC2368<ByteAssociation<?>, byte[]> getBytesFromAssociation() {
        return new InterfaceC2368<ByteAssociation<?>, byte[]>() { // from class: com.polidea.rxandroidble2.internal.util.ByteAssociationUtil.2
            @Override // defpackage.InterfaceC2368
            public byte[] apply(ByteAssociation<?> byteAssociation) {
                return byteAssociation.second;
            }
        };
    }
}
