package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.RxBleDevice;
import io.reactivex.disposables.C1972;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class n9 {

    /* renamed from: n9$Ϳ, reason: contains not printable characters */
    public static class C2191 implements InterfaceC5201<BluetoothProfile> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public BluetoothProfile f8049;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public Context f8050;

        /* renamed from: n9$Ϳ$Ϳ, reason: contains not printable characters */
        public class C2192 implements BluetoothProfile.ServiceListener {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ InterfaceC5245 f8051;

            public C2192(InterfaceC5245 interfaceC5245) {
                this.f8051 = interfaceC5245;
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                C2191.this.f8049 = bluetoothProfile;
                this.f8051.onNext(bluetoothProfile);
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceDisconnected(int i) {
            }
        }

        /* renamed from: n9$Ϳ$Ԩ, reason: contains not printable characters */
        public class C2193 implements InterfaceC3809 {
            public C2193() {
            }

            @Override // defpackage.InterfaceC3809
            public void run() {
                C2191 c2191 = C2191.this;
                c2191.m7642(c2191.f8049);
            }
        }

        public C2191(Context context) {
            this.f8050 = context;
        }

        @Override // defpackage.InterfaceC5201
        public void subscribe(@NonNull InterfaceC5245<BluetoothProfile> interfaceC5245) {
            BluetoothAdapter.getDefaultAdapter().getProfileProxy(this.f8050, new C2192(interfaceC5245), 4);
            interfaceC5245.mo6762(C1972.m6301(new C2193()));
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final void m7642(BluetoothProfile bluetoothProfile) {
            BluetoothAdapter.getDefaultAdapter().closeProfileProxy(4, bluetoothProfile);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static AbstractC4262<Long> m7633() {
        return AbstractC4262.interval(0L, 1L, TimeUnit.SECONDS);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static AbstractC4262<RxBleDevice> m7634(Context context, final RxBleClient rxBleClient) {
        return AbstractC4262.create(new C2191(context)).flatMap(new InterfaceC2368() { // from class: e9
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return n9.m7635((BluetoothProfile) obj);
            }
        }, new InterfaceC5247() { // from class: f9
            @Override // defpackage.InterfaceC5247
            public final Object apply(Object obj, Object obj2) {
                return n9.m7636((BluetoothProfile) obj, (Long) obj2);
            }
        }).map(new InterfaceC2368() { // from class: g9
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return n9.m7637(rxBleClient, (List) obj);
            }
        }).flatMap(new InterfaceC2368() { // from class: h9
            @Override // defpackage.InterfaceC2368
            public final Object apply(Object obj) {
                return AbstractC4262.fromIterable((List) obj);
            }
        });
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static /* synthetic */ InterfaceC2856 m7635(BluetoothProfile bluetoothProfile) {
        return m7633();
    }

    @NonNull
    /* renamed from: ԭ, reason: contains not printable characters */
    public static List<BluetoothDevice> m7636(BluetoothProfile bluetoothProfile, Long l) {
        try {
            return bluetoothProfile.getConnectedDevices();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @NonNull
    /* renamed from: Ԯ, reason: contains not printable characters */
    public static List<RxBleDevice> m7637(RxBleClient rxBleClient, List<BluetoothDevice> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<BluetoothDevice> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(rxBleClient.getBleDevice(it.next().getAddress()));
        }
        return arrayList;
    }
}
