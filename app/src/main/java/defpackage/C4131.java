package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.blink.academy.film.FilmApp;
import defpackage.C3273;

/* compiled from: BtServer.java */
/* renamed from: ॽ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4131 extends C3273 {

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final String f14310 = "ॽ";

    /* renamed from: ԯ, reason: contains not printable characters */
    public BluetoothServerSocket f14311;

    /* compiled from: BtServer.java */
    /* renamed from: ॽ$Ϳ, reason: contains not printable characters */
    public class RunnableC4132 implements Runnable {
        public RunnableC4132() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C4131 c4131 = C4131.this;
                c4131.m10948(null, c4131.f14311);
            } catch (Throwable unused) {
                C4131.this.mo10945();
            }
        }
    }

    public C4131(C3273.InterfaceC3276 interfaceC3276) {
        super(interfaceC3276);
        m13104();
    }

    @Override // defpackage.C3273
    /* renamed from: ԭ */
    public void mo10945() {
        super.mo10945();
        try {
            this.f14311.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m13104() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                this.f14311 = defaultAdapter.listenUsingRfcommWithServiceRecord(f14310, C3273.f11457);
                C3180.f11259.execute(new RunnableC4132());
            }
        } catch (Throwable unused) {
            mo10945();
        }
    }
}
