package com.zhiyun.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Nullable;
import com.zhiyun.sdk.device.Device;
import defpackage.ab;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class DeviceManager {

    @SuppressLint({"StaticFieldLeak"})
    private static final DeviceManager d = new DeviceManager();
    private ScanCallback b;
    private ab c = new a();
    private List<Device> a = new CopyOnWriteArrayList();

    public enum DeviceType {
        BLE,
        WIFI,
        USB,
        ALL
    }

    public interface ScanCallback {
        void onCallback(Device device);
    }

    public class a implements ab {
        public a() {
        }

        @Override // defpackage.ab
        public void a(Device device) {
            DeviceManager.this.a.add(device);
            if (DeviceManager.this.b != null) {
                DeviceManager.this.b.onCallback(device);
            }
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DeviceType.values().length];
            a = iArr;
            try {
                iArr[DeviceType.BLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DeviceType.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DeviceType.USB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DeviceType.ALL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private DeviceManager() {
    }

    public static DeviceManager getInstance() {
        return d;
    }

    public void cancelScan() {
        com.zhiyun.sdk.a.a(ZYDeviceSDK.getInstance().getContext()).a();
    }

    public Device deviceAt(int i) {
        return this.a.get(i);
    }

    public int getCount() {
        return this.a.size();
    }

    @Nullable
    public Device queryDevice(String str) {
        for (Device device : this.a) {
            if (str != null && str.equals(device.getIdentifier())) {
                return device;
            }
        }
        return null;
    }

    public void scan(DeviceType deviceType) {
        Context context = ZYDeviceSDK.getInstance().getContext();
        int i = b.a[deviceType.ordinal()];
        if (i == 1) {
            com.zhiyun.sdk.a.a(context).a(this.c);
        } else {
            if (i != 4) {
                return;
            }
            com.zhiyun.sdk.a.a(context).a(this.c);
        }
    }

    public void setScanCallback(ScanCallback scanCallback) {
        this.b = scanCallback;
    }
}
