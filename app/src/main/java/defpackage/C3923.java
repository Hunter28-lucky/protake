package defpackage;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.blink.academy.film.FilmApp;
import defpackage.C3273;
import java.io.IOException;

/* compiled from: BtClient.java */
/* renamed from: ࡅ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3923 extends C3273 {

    /* compiled from: BtClient.java */
    /* renamed from: ࡅ$Ϳ, reason: contains not printable characters */
    public class RunnableC3924 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ BluetoothSocket f13550;

        public RunnableC3924(BluetoothSocket bluetoothSocket) {
            this.f13550 = bluetoothSocket;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            C3923.this.m10948(this.f13550, null);
        }
    }

    public C3923(C3273.InterfaceC3276 interfaceC3276) {
        super(interfaceC3276);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m12682(BluetoothDevice bluetoothDevice) {
        m10946();
        m10943();
        try {
            if (Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                C3180.f11259.execute(new RunnableC3924(bluetoothDevice.createRfcommSocketToServiceRecord(C3273.f11457)));
            }
        } catch (Throwable unused) {
            mo10945();
        }
    }
}
