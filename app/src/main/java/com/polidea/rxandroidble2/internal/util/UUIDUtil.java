package com.polidea.rxandroidble2.internal.util;

import android.os.ParcelUuid;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Deprecated
/* loaded from: classes2.dex */
public class UUIDUtil {
    public static final ParcelUuid BASE_UUID = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private static final int DATA_TYPE_FLAGS = 1;
    private static final int DATA_TYPE_LOCAL_NAME_COMPLETE = 9;
    private static final int DATA_TYPE_LOCAL_NAME_SHORT = 8;
    private static final int DATA_TYPE_MANUFACTURER_SPECIFIC_DATA = 255;
    private static final int DATA_TYPE_SERVICE_DATA = 22;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_COMPLETE = 7;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_PARTIAL = 6;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_COMPLETE = 3;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_PARTIAL = 2;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_COMPLETE = 5;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_PARTIAL = 4;
    private static final int DATA_TYPE_TX_POWER_LEVEL = 10;
    private static final String UUID_BASE_FORMAT = "%08x-0000-1000-8000-00805f9b34fb";
    public static final int UUID_BYTES_128_BIT = 16;
    public static final int UUID_BYTES_16_BIT = 2;
    public static final int UUID_BYTES_32_BIT = 4;

    private static byte[] extractBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    private static int parseServiceUuid(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(parseUuidFrom(extractBytes(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static ParcelUuid parseUuidFrom(byte[] bArr) {
        long j;
        if (bArr == null) {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException("uuidBytes length invalid - " + length);
        }
        if (length == 16) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(byteBufferOrder.getLong(8), byteBufferOrder.getLong(0)));
        }
        if (length == 2) {
            j = (bArr[0] & ExifInterface.MARKER) + ((bArr[1] & ExifInterface.MARKER) << 8);
        } else {
            j = ((bArr[3] & ExifInterface.MARKER) << 24) + (bArr[0] & ExifInterface.MARKER) + ((bArr[1] & ExifInterface.MARKER) << 8) + ((bArr[2] & ExifInterface.MARKER) << 16);
        }
        ParcelUuid parcelUuid = BASE_UUID;
        return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j << 32), parcelUuid.getUuid().getLeastSignificantBits()));
    }

    public List<UUID> extractUUIDs(byte[] bArr) {
        int i;
        ArrayList arrayList = new ArrayList();
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        while (byteBufferOrder.remaining() > 2 && (i = byteBufferOrder.get() & ExifInterface.MARKER) != 0) {
            switch (byteBufferOrder.get()) {
                case 2:
                case 3:
                    while (i >= 2) {
                        arrayList.add(UUID.fromString(String.format(UUID_BASE_FORMAT, Short.valueOf(byteBufferOrder.getShort()))));
                        i -= 2;
                    }
                    break;
                case 4:
                case 5:
                    while (i >= 4) {
                        arrayList.add(UUID.fromString(String.format(UUID_BASE_FORMAT, Integer.valueOf(byteBufferOrder.getInt()))));
                        i -= 4;
                    }
                    break;
                case 6:
                case 7:
                    while (i >= 16) {
                        arrayList.add(new UUID(byteBufferOrder.getLong(), byteBufferOrder.getLong()));
                        i -= 16;
                    }
                    break;
                default:
                    byteBufferOrder.position(byteBufferOrder.position() + Math.min(i - 1, byteBufferOrder.remaining()));
                    break;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.polidea.rxandroidble2.scan.ScanRecord parseFromBytes(byte[] r15) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.rxandroidble2.internal.util.UUIDUtil.parseFromBytes(byte[]):com.polidea.rxandroidble2.scan.ScanRecord");
    }

    @NonNull
    public Set<UUID> toDistinctSet(@Nullable UUID[] uuidArr) {
        if (uuidArr == null) {
            uuidArr = new UUID[0];
        }
        return new HashSet(Arrays.asList(uuidArr));
    }
}
