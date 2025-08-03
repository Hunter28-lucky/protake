package defpackage;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.ScanResult;
import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.FilmApp;
import java.util.Iterator;

/* compiled from: ProtakeDevice.java */
/* renamed from: ஸ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4489 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public ScanResult f15396;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public BluetoothDevice f15397;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f15398;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f15400;

    /* renamed from: ԭ, reason: contains not printable characters */
    public BluetoothGatt f15402;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC4492 f15403;

    /* renamed from: ԯ, reason: contains not printable characters */
    public long f15404;

    /* renamed from: ՠ, reason: contains not printable characters */
    public InterfaceC4491 f15405;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f15401 = false;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public BluetoothGattCallback f15399 = new C4490();

    /* compiled from: ProtakeDevice.java */
    /* renamed from: ஸ$Ϳ, reason: contains not printable characters */
    public class C4490 extends BluetoothGattCallback {
        public C4490() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) throws NumberFormatException {
            String str;
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (value == null || value.length <= 0) {
                return;
            }
            String strM13763 = C4489.m13763(value);
            if (r1.m8143(strM13763) && strM13763.length() == 16) {
                String hexString = Integer.toHexString(C4489.m13764(value, value.length - 1));
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                boolean zEqualsIgnoreCase = strM13763.substring(14, 16).equalsIgnoreCase(hexString);
                String strSubstring = strM13763.substring(0, 4);
                if (Integer.parseInt(strSubstring) != 5054 || !zEqualsIgnoreCase) {
                    C4638.m14099("slimBlue2", "block by check");
                    return;
                }
                String strSubstring2 = strM13763.substring(6, 8);
                String strSubstring3 = strM13763.substring(8, 12);
                String strSubstring4 = strM13763.substring(12, 14);
                String strSubstring5 = strSubstring3.substring(0, 2);
                String strSubstring6 = strSubstring3.substring(2, 4);
                if (Integer.parseInt(strSubstring5, 16) > Integer.parseInt(strSubstring6, 16)) {
                    str = strSubstring6 + strSubstring5;
                } else {
                    str = strSubstring5 + strSubstring6;
                }
                int iM13771 = C4489.this.m13771(strSubstring2);
                int iM13770 = C4489.this.m13770(strSubstring4);
                int i = Integer.parseInt(str, 16);
                if (iM13771 == 1003 || iM13771 == 1004) {
                    iM13770 = Integer.parseInt(strSubstring4);
                    if (i != 0) {
                        C4567.m14006().m14022(i);
                    }
                }
                if (C4489.this.f15405 != null && iM13771 != 0 && iM13770 != 0) {
                    C4489.this.f15405.mo13780(iM13771, iM13770, i, strM13763);
                }
                C4638.m14099("slimBlue", "origin:" + strM13763 + " headStr:" + strSubstring + " keyStr:" + strSubstring2 + " eventStr:" + strSubstring4 + " resStr:" + str + " resValue:" + i + " eventType:" + iM13770);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            if ("be086de8-4924-47dd-a3d2-78ba3eb00002".equalsIgnoreCase(bluetoothGattCharacteristic.getUuid().toString())) {
                byte[] value = bluetoothGattCharacteristic.getValue();
                String strM13763 = value != null ? C4489.m13763(value) : "";
                if (!r1.m8143(strM13763) || strM13763.length() < 4) {
                    return;
                }
                String strSubstring = strM13763.substring(0, 2);
                if (Integer.parseInt(strSubstring, 16) > 1 && C4489.this.f15403 != null) {
                    C4489.this.f15403.mo13782();
                }
                C4638.m14099("slimBlue", "s:" + strM13763 + " subString:" + strSubstring);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            BluetoothDevice device = bluetoothGatt.getDevice();
            C4638.m14099("slimBlue", String.format("onConnectionStateChange:%s,%s,%s,%s", device.getName(), device.getAddress(), Integer.valueOf(i), Integer.valueOf(i2)));
            if (C4489.this.f15403 != null && (i == 0 || i2 == 0)) {
                C4489.this.f15403.mo13781(i2);
            }
            if (i != 0 || i2 != 2) {
                C4489.this.f15400 = false;
                C4489.this.f15404 = System.currentTimeMillis();
            } else {
                C4489.this.f15400 = true;
                bluetoothGatt.discoverServices();
                C4489.this.f15404 = System.currentTimeMillis();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            BluetoothGattCharacteristic characteristic = bluetoothGattDescriptor.getCharacteristic();
            if (characteristic != null && "be086de8-4924-47dd-a3d2-78ba3eb00001".equals(characteristic.getUuid().toString()) && C4489.this.f15401) {
                C4489.this.m13775();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                Iterator<BluetoothGattService> it = bluetoothGatt.getServices().iterator();
                while (it.hasNext()) {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : it.next().getCharacteristics()) {
                        if ("be086de8-4924-47dd-a3d2-78ba3eb00001".equals(bluetoothGattCharacteristic.getUuid().toString())) {
                            C4489.this.f15401 = true;
                            C4489.this.f15402.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                            BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptors().get(0);
                            bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                            C4489.this.f15402.writeDescriptor(bluetoothGattDescriptor);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: ProtakeDevice.java */
    /* renamed from: ஸ$Ԩ, reason: contains not printable characters */
    public interface InterfaceC4491 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo13780(int i, int i2, int i3, String str);
    }

    /* compiled from: ProtakeDevice.java */
    /* renamed from: ஸ$Ԫ, reason: contains not printable characters */
    public interface InterfaceC4492 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo13781(int i);

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo13782();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static String m13763(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & ExifInterface.MARKER);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static int m13764(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 + bArr[i3]) & 255;
        }
        return 255 - i2;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m13765(boolean z) {
        if (this.f15402 != null) {
            this.f15404 = System.currentTimeMillis();
            this.f15402.disconnect();
            if (z) {
                this.f15402.close();
            }
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m13766() {
        m13765(true);
        this.f15402 = this.f15397.connectGatt(FilmApp.m405(), false, this.f15399);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m13767() {
        m13765(false);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public BluetoothDevice m13768() {
        return this.f15397;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public String m13769() {
        return this.f15398;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final int m13770(String str) {
        if ("03".equalsIgnoreCase(str)) {
            return 2002;
        }
        if ("01".equalsIgnoreCase(str)) {
            return 2000;
        }
        return "00".equalsIgnoreCase(str) ? 2001 : 0;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final int m13771(String str) {
        if ("00".equalsIgnoreCase(str)) {
            return 1003;
        }
        if ("01".equalsIgnoreCase(str)) {
            return 1004;
        }
        if ("0a".equalsIgnoreCase(str)) {
            return 1000;
        }
        if ("0b".equalsIgnoreCase(str)) {
            return 1001;
        }
        return "0c".equalsIgnoreCase(str) ? 1002 : 0;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public long m13772() {
        return this.f15404;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public ScanResult m13773() {
        return this.f15396;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public boolean m13774() {
        return this.f15400;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m13775() {
        this.f15401 = false;
        BluetoothGatt bluetoothGatt = this.f15402;
        if (bluetoothGatt == null || !r1.m8144(bluetoothGatt.getServices())) {
            return;
        }
        Iterator<BluetoothGattService> it = this.f15402.getServices().iterator();
        while (it.hasNext()) {
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : it.next().getCharacteristics()) {
                if ("be086de8-4924-47dd-a3d2-78ba3eb00002".equalsIgnoreCase(bluetoothGattCharacteristic.getUuid().toString())) {
                    this.f15402.readCharacteristic(bluetoothGattCharacteristic);
                }
            }
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m13776(InterfaceC4491 interfaceC4491) {
        this.f15405 = interfaceC4491;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m13777(long j) {
        this.f15404 = j;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m13778(InterfaceC4492 interfaceC4492) {
        this.f15403 = interfaceC4492;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m13779(ScanResult scanResult) {
        this.f15396 = scanResult;
        this.f15397 = scanResult.getDevice();
        this.f15398 = scanResult.getScanRecord().getDeviceName();
    }
}
