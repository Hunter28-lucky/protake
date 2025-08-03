package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.blink.academy.film.FilmApp;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProtakeFocusDeviceManager.java */
/* renamed from: ڥ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3560 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static C3560 f12376;

    /* renamed from: ԩ, reason: contains not printable characters */
    public HandlerThread f12379;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Handler f12380;

    /* renamed from: ԭ, reason: contains not printable characters */
    public BluetoothLeScanner f12383;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC3564 f12384;

    /* renamed from: ԫ, reason: contains not printable characters */
    public Object f12381 = new Object();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final ScanCallback f12382 = new C3562();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f12377 = m11511();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public List<C4489> f12378 = new ArrayList();

    /* compiled from: ProtakeFocusDeviceManager.java */
    /* renamed from: ڥ$Ϳ, reason: contains not printable characters */
    public class C3561 implements Handler.Callback {
        public C3561() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what == 10001) {
                Message messageObtainMessage = C3560.this.f12380.obtainMessage(10001);
                if (r1.m8144(C3560.this.f12378)) {
                    Iterator it = C3560.this.f12378.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        C4489 c4489 = (C4489) it.next();
                        if (c4489.m13772() != 0 && !c4489.m13774() && System.currentTimeMillis() - c4489.m13772() > 3500) {
                            it.remove();
                            if (C3560.this.f12384 != null) {
                                C3560.this.f12384.mo11518(c4489);
                            }
                            z = true;
                        }
                    }
                    if (z && C3560.this.f12384 != null) {
                        C3560.this.f12384.mo11517();
                    }
                }
                C3560.this.f12380.sendMessageDelayed(messageObtainMessage, 3000L);
            }
            return true;
        }
    }

    /* compiled from: ProtakeFocusDeviceManager.java */
    /* renamed from: ڥ$Ԩ, reason: contains not printable characters */
    public class C3562 extends ScanCallback {
        public C3562() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            byte[] bArr;
            byte b;
            if (scanResult == null || scanResult.getDevice() == null) {
                return;
            }
            SparseArray<byte[]> manufacturerSpecificData = scanResult.getScanRecord().getManufacturerSpecificData();
            for (int i2 = 0; i2 < manufacturerSpecificData.size(); i2++) {
                int iKeyAt = manufacturerSpecificData.keyAt(i2);
                if (C3560.this.f12377) {
                    if (iKeyAt == 20564 && (((b = (bArr = manufacturerSpecificData.get(iKeyAt))[0]) == 17 && bArr[1] == 8) || (b == 8 && bArr[1] == 17))) {
                        C3560.this.m11509(scanResult);
                    }
                } else if (iKeyAt == 21584) {
                    byte[] bArr2 = manufacturerSpecificData.get(iKeyAt);
                    if (bArr2.length == 2 && bArr2[0] == 17 && bArr2[1] == 8) {
                        C3560.this.m11509(scanResult);
                    }
                }
            }
        }
    }

    /* compiled from: ProtakeFocusDeviceManager.java */
    /* renamed from: ڥ$Ԫ, reason: contains not printable characters */
    public class RunnableC3563 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ ScanResult f12387;

        public RunnableC3563(ScanResult scanResult) {
            this.f12387 = scanResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C3560.this.m11510(this.f12387)) {
                return;
            }
            C4489 c4489 = new C4489();
            c4489.m13779(this.f12387);
            C3560.this.f12378.add(c4489);
            if (C3560.this.f12384 != null) {
                C3560.this.f12384.mo11516(c4489);
            }
        }
    }

    /* compiled from: ProtakeFocusDeviceManager.java */
    /* renamed from: ڥ$Ԭ, reason: contains not printable characters */
    public interface InterfaceC3564 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo11516(C4489 c4489);

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo11517();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo11518(C4489 c4489);
    }

    public C3560() {
        Handler handler;
        synchronized (this.f12381) {
            HandlerThread handlerThread = new HandlerThread("LinkEntity");
            this.f12379 = handlerThread;
            handlerThread.setPriority(4);
            this.f12379.start();
            handler = new Handler(this.f12379.getLooper(), new C3561());
            this.f12380 = handler;
        }
        handler.sendEmptyMessage(10001);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static C3560 m11508() {
        if (f12376 == null) {
            synchronized (C3560.class) {
                if (f12376 == null) {
                    f12376 = new C3560();
                }
            }
        }
        return f12376;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m11509(ScanResult scanResult) {
        this.f12380.post(new RunnableC3563(scanResult));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean m11510(ScanResult scanResult) {
        if (!r1.m8144(this.f12378)) {
            return false;
        }
        for (C4489 c4489 : this.f12378) {
            if (scanResult.getDevice().getAddress().equals(c4489.m13773().getDevice().getAddress())) {
                c4489.m13777(System.currentTimeMillis());
                return true;
            }
        }
        return false;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean m11511() {
        return ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m11512() {
        if (r1.m8144(this.f12378)) {
            Iterator<C4489> it = this.f12378.iterator();
            while (it.hasNext()) {
                it.next().m13765(true);
            }
        }
        this.f12378.clear();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m11513(C4489 c4489) {
        if (c4489.m13774()) {
            c4489.m13767();
        } else {
            c4489.m13766();
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m11514(InterfaceC3564 interfaceC3564) {
        this.f12384 = interfaceC3564;
        this.f12383 = BluetoothAdapter.getDefaultAdapter().getBluetoothLeScanner();
        if (Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_SCAN") == 0) {
            this.f12383.startScan(this.f12382);
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m11515() {
        if (this.f12383 != null) {
            if (Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_SCAN") == 0) {
                this.f12383.stopScan(this.f12382);
            }
        }
    }
}
