package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Build;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.blink.academy.film.FilmApp;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* compiled from: BtBase.java */
/* renamed from: ז, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3273 {

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final UUID f11457 = UUID.fromString("db958b6c-55ac-41e4-bf98-3997a49243a1");

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final String f11458 = FilmApp.m402().getFilesDir().getAbsolutePath() + "/bluetooth/";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public BluetoothSocket f11459;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public DataOutputStream f11460;

    /* renamed from: ԩ, reason: contains not printable characters */
    public InterfaceC3276 f11461;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean f11462;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f11463;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Handler f11464 = new Handler();

    /* compiled from: BtBase.java */
    /* renamed from: ז$Ϳ, reason: contains not printable characters */
    public class RunnableC3274 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f11465;

        public RunnableC3274(String str) {
            this.f11465 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(this.f11465);
                File file = new File(this.f11465);
                C3273.this.f11460.writeInt(1);
                C3273.this.f11460.writeUTF(file.getName());
                C3273.this.f11460.writeLong(file.length());
                byte[] bArr = new byte[4096];
                C3273.this.m10949(2, "正在发送文件(" + this.f11465 + "),请稍后...");
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        C3273.this.f11460.write(bArr, 0, i);
                    }
                }
                C3273.this.f11460.flush();
                C3273.this.m10949(3, "文件发送完成.");
            } catch (Throwable unused) {
                C3273.this.m10949(0, null);
            }
            C3273.this.f11463 = false;
        }
    }

    /* compiled from: BtBase.java */
    /* renamed from: ז$Ԩ, reason: contains not printable characters */
    public class RunnableC3275 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f11467;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ Object f11468;

        public RunnableC3275(int i, Object obj) {
            this.f11467 = i;
            this.f11468 = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (C3273.this.f11461 != null) {
                    C3273.this.f11461.mo2285(this.f11467, this.f11468);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: BtBase.java */
    /* renamed from: ז$Ԫ, reason: contains not printable characters */
    public interface InterfaceC3276 {
        /* renamed from: Ԩ */
        void mo2285(int i, Object obj);
    }

    public C3273(InterfaceC3276 interfaceC3276) {
        this.f11461 = interfaceC3276;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m10943() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if ((Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(FilmApp.m405(), "android.permission.BLUETOOTH_SCAN") == 0) && defaultAdapter != null && defaultAdapter.isDiscovering()) {
            defaultAdapter.cancelDiscovery();
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean m10944() {
        if (!this.f11463) {
            return false;
        }
        C4638.m14101("正在发送其它数据,请稍后再发...", 0);
        return true;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void mo10945() {
        m10946();
        m10949(0, null);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m10946() {
        try {
            this.f11462 = false;
            BluetoothSocket bluetoothSocket = this.f11459;
            if (bluetoothSocket != null) {
                bluetoothSocket.close();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean m10947(BluetoothDevice bluetoothDevice) {
        BluetoothSocket bluetoothSocket = this.f11459;
        boolean z = bluetoothSocket != null && bluetoothSocket.isConnected();
        return bluetoothDevice == null ? z : z && this.f11459.getRemoteDevice().equals(bluetoothDevice);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m10948(BluetoothSocket bluetoothSocket, BluetoothServerSocket bluetoothServerSocket) throws IOException {
        if (bluetoothSocket != null) {
            this.f11459 = bluetoothSocket;
        }
        this.f11462 = true;
        while (this.f11462) {
            if (bluetoothServerSocket != null) {
                try {
                    bluetoothSocket = bluetoothServerSocket.accept();
                    this.f11459 = bluetoothSocket;
                } catch (Throwable unused) {
                    if (bluetoothServerSocket != null) {
                        try {
                            bluetoothSocket.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        m10949(0, null);
                    } else {
                        mo10945();
                    }
                }
            }
            if (!this.f11459.isConnected() && Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_CONNECT") != 0) {
                return;
            }
            this.f11459.connect();
            m10949(1, this.f11459.getRemoteDevice());
            this.f11460 = new DataOutputStream(this.f11459.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(this.f11459.getInputStream());
            int i = dataInputStream.readInt();
            if (i == 0) {
                m10949(2, "接收短消息：" + dataInputStream.readUTF());
            } else if (i == 1) {
                String str = f11458;
                C3180.m10803(str);
                String utf = dataInputStream.readUTF();
                long j = dataInputStream.readLong();
                long j2 = 0;
                byte[] bArr = new byte[4096];
                FileOutputStream fileOutputStream = new FileOutputStream(str + utf);
                m10949(2, "正在接收文件,请稍后...");
                do {
                    int i2 = dataInputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i2);
                    j2 += i2;
                } while (j2 < j);
                m10949(3, "文件接收完成");
            }
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m10949(int i, Object obj) {
        this.f11464.post(new RunnableC3275(i, obj));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m10950(String str) {
        if (m10944()) {
            return;
        }
        this.f11463 = true;
        C3180.f11259.execute(new RunnableC3274(str));
    }
}
