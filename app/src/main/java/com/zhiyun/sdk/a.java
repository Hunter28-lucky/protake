package com.zhiyun.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanRecord;
import com.polidea.rxandroidble2.scan.ScanResult;
import com.polidea.rxandroidble2.scan.ScanSettings;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.sdk.device.ble.BleDevice;
import com.zhiyun.sdk.device.ble.BleStabilizer;
import com.zhiyun.sdk.util.BTUtil;
import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC4178;
import defpackage.InterfaceC4478;
import defpackage.ab;
import defpackage.n9;
import io.reactivex.exceptions.UndeliverableException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
class a {

    /* renamed from: e, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static a f17904e;
    private final Context a;
    private final RxBleClient b;
    private final Map<String, BleDevice> c = new HashMap();
    private InterfaceC4478 d;

    private a(Context context) {
        this.a = context;
        this.b = RxBleClient.create(context);
        C3671.m11812(new InterfaceC2857() { // from class: com.zhiyun.sdk.ֈ
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                a.a((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Throwable th) {
        if (!(th instanceof UndeliverableException) || !(th.getCause() instanceof BleException)) {
            throw new RuntimeException("Unexpected Throwable in RxJavaPlugins error handler", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BleDevice b(ScanResult scanResult) {
        RxBleDevice bleDevice = scanResult.getBleDevice();
        BleDevice bleDevice2 = this.c.get(bleDevice.getMacAddress());
        if (bleDevice2 == null) {
            BleStabilizer bleStabilizer = new BleStabilizer(bleDevice, a(scanResult.getScanRecord()));
            this.c.put(bleDevice.getMacAddress(), bleStabilizer);
            bleDevice2 = bleStabilizer;
        }
        bleDevice2.setRssi(scanResult.getRssi());
        return bleDevice2;
    }

    public static a a(Context context) {
        if (f17904e == null) {
            synchronized (a.class) {
                if (f17904e == null) {
                    f17904e = new a(context);
                }
            }
        }
        return f17904e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BleDevice b(Pair pair) {
        return new BleStabilizer((RxBleDevice) pair.first, (Model) pair.second);
    }

    private boolean b() {
        return this.d != null;
    }

    private static Model a(ScanRecord scanRecord) {
        try {
            byte[] bArrValueAt = scanRecord.getManufacturerSpecificData().valueAt(0);
            Model modelFrom = Model.from((bArrValueAt[1] << 8) | bArrValueAt[0]);
            if (modelFrom != Model.UNKNOWN) {
                return modelFrom;
            }
            return Model.from(bArrValueAt[1] | (bArrValueAt[0] << 8));
        } catch (Exception unused) {
            return Model.UNKNOWN;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ScanResult scanResult) {
        return scanResult.getScanRecord().getManufacturerSpecificData(1289) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<RxBleDevice, Model> a(RxBleDevice rxBleDevice) {
        if (TextUtils.isEmpty(rxBleDevice.getName())) {
            return Pair.create(rxBleDevice, null);
        }
        String lowerCase = rxBleDevice.getName().toLowerCase();
        for (Model model : Model.values()) {
            if (!TextUtils.isEmpty(model.hidName) && lowerCase.startsWith(model.hidName)) {
                return Pair.create(rxBleDevice, model);
            }
        }
        return Pair.create(rxBleDevice, null);
    }

    public void a(final ab abVar) {
        if (b() || !BTUtil.isSupportBle()) {
            return;
        }
        final ScanSettings scanSettingsBuild = new ScanSettings.Builder().setScanMode(1).build();
        AbstractC4262 abstractC4262Merge = AbstractC4262.merge(n9.m7634(this.a, this.b).map(new InterfaceC2368() { // from class: com.zhiyun.sdk.Ԫ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return this.f6519.a((RxBleDevice) obj);
            }
        }).filter(new InterfaceC4178() { // from class: com.zhiyun.sdk.Ԭ
            @Override // defpackage.InterfaceC4178
            public final boolean test(Object obj) {
                return a.a((Pair) obj);
            }
        }).map(new InterfaceC2368() { // from class: com.zhiyun.sdk.Ԯ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return a.b((Pair) obj);
            }
        }), this.b.observeStateChanges().startWith((AbstractC4262<RxBleClient.State>) this.b.getState()).switchMap(new InterfaceC2368() { // from class: com.zhiyun.sdk.ՠ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return this.f6520.a(scanSettingsBuild, (RxBleClient.State) obj);
            }
        }));
        Objects.requireNonNull(abVar);
        this.d = abstractC4262Merge.subscribe(new InterfaceC2857() { // from class: i9
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                abVar.a((BleDevice) obj);
            }
        }, new InterfaceC2857() { // from class: j9
            @Override // defpackage.InterfaceC2857
            public final void accept(Object obj) {
                db.m5931((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(Pair pair) {
        return pair.second != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ InterfaceC2856 a(ScanSettings scanSettings, RxBleClient.State state) {
        return this.b.scanBleDevices(scanSettings, new ScanFilter[0]).filter(new InterfaceC4178() { // from class: com.zhiyun.sdk.Ϳ
            @Override // defpackage.InterfaceC4178
            public final boolean test(Object obj) {
                return this.f6517.a((ScanResult) obj);
            }
        }).map(new InterfaceC2368() { // from class: com.zhiyun.sdk.Ԩ
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return this.f6518.b((ScanResult) obj);
            }
        });
    }

    public void a() {
        InterfaceC4478 interfaceC4478 = this.d;
        if (interfaceC4478 != null) {
            interfaceC4478.dispose();
            this.d = null;
        }
    }
}
