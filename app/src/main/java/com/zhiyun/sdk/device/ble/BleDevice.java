package com.zhiyun.sdk.device.ble;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.util.Log;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDevice;
import com.zhiyun.sdk.device.Device;
import com.zhiyun.sdk.device.ble.BleDevice;
import defpackage.AbstractC4262;
import defpackage.AbstractC4838;
import defpackage.C2527;
import defpackage.C2760;
import defpackage.C4000;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2857;
import defpackage.ub;
import java.util.UUID;

/* loaded from: classes2.dex */
public abstract class BleDevice extends Device {
    private final C2527 d = new C2527();

    /* renamed from: e, reason: collision with root package name */
    private final RxBleDevice f17905e;
    private final ub f;
    private int g;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RxBleConnection.RxBleConnectionState.values().length];
            a = iArr;
            try {
                iArr[RxBleConnection.RxBleConnectionState.CONNECTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RxBleConnection.RxBleConnectionState.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RxBleConnection.RxBleConnectionState.DISCONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RxBleConnection.RxBleConnectionState.DISCONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BleDevice(RxBleDevice rxBleDevice) {
        this.f17905e = rxBleDevice;
        a();
        this.f = new ub(rxBleDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RxBleConnection a(RxBleConnection rxBleConnection, Integer num) {
        return rxBleConnection;
    }

    @SuppressLint({"CheckResult"})
    private void a() {
        this.f17905e.observeConnectionStateChanges().doOnNext(new InterfaceC2857() { // from class: ʼ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                this.f10053.a((RxBleConnection.RxBleConnectionState) obj);
            }
        }).map(new InterfaceC2368() { // from class: ˤ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return Integer.valueOf(this.f10094.b((RxBleConnection.RxBleConnectionState) obj));
            }
        }).observeOn(C4000.m12867()).subscribe(new InterfaceC2857() { // from class: ˡ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                this.f10093.b(((Integer) obj).intValue());
            }
        }, new C2760(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbstractC4262<RxBleConnection> b(final RxBleConnection rxBleConnection) {
        return rxBleConnection.requestMtu(RxBleConnection.GATT_MTU_MAXIMUM).onErrorReturnItem(21).toObservable().map(new InterfaceC2368() { // from class: ʴ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return BleDevice.a(rxBleConnection, (Integer) obj);
            }
        });
    }

    public void c(int i) {
    }

    @Override // com.zhiyun.sdk.device.Device
    public void connect() {
        connect(false);
    }

    @Override // com.zhiyun.sdk.device.Device
    public void disconnect() {
        this.f.m8388();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BleDevice) {
            return this.f17905e.equals(((BleDevice) obj).f17905e);
        }
        return false;
    }

    @Override // com.zhiyun.sdk.device.Device
    public String getIdentifier() {
        return this.f17905e.getMacAddress();
    }

    @Override // com.zhiyun.sdk.device.Device
    public String getModelName() {
        return this.f17905e.getName();
    }

    @Override // com.zhiyun.sdk.device.Device
    public int getRSSI() {
        return this.g;
    }

    public int hashCode() {
        return this.f17905e.hashCode();
    }

    @Override // com.zhiyun.sdk.device.Device
    public boolean isConnected() {
        return this.f17905e.getConnectionState() == RxBleConnection.RxBleConnectionState.CONNECTED;
    }

    @Override // com.zhiyun.sdk.device.Device
    public String marketingName() {
        return this.f17905e.getName();
    }

    public void setRssi(int i) {
        this.g = i;
    }

    public AbstractC4262<byte[]> setupNotification(UUID uuid) {
        return this.f.m8385(uuid);
    }

    public AbstractC4838<byte[]> writeCharacteristic(UUID uuid, byte[] bArr) {
        return this.f.m8387(uuid, bArr);
    }

    public void connect(boolean z) {
        this.d.mo9333(this.f.m8386(z, 5000L).flatMap(new InterfaceC2368() { // from class: ʿ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return this.f10061.b((RxBleConnection) obj);
            }
        }).subscribe(new InterfaceC2857() { // from class: ʹ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                this.f10048.a((RxBleConnection) obj);
            }
        }, new C2760(this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(RxBleConnection.RxBleConnectionState rxBleConnectionState) {
        int i = a.a[rxBleConnectionState.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return 0;
                }
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RxBleConnection.RxBleConnectionState rxBleConnectionState) {
        if (rxBleConnectionState == RxBleConnection.RxBleConnectionState.CONNECTED) {
            SystemClock.sleep(1000L);
        }
    }

    public void b(int i) {
        Log.d("BleDevice", "doConnectionStateChanged: " + i);
        if (i != 1 && i != 2 && i != 3) {
            this.d.m9336();
        }
        c(i);
        a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RxBleConnection rxBleConnection) {
        Log.d("BleDevice", "onConnectionFinished: ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Throwable th) {
        th.printStackTrace();
    }
}
