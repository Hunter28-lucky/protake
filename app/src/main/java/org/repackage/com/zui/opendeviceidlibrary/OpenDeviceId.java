package org.repackage.com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import org.repackage.com.zui.deviceidservice.IDeviceidInterface;

/* loaded from: classes2.dex */
public class OpenDeviceId {
    private static String c = "OpenDeviceId library";
    private static boolean d = false;
    private IDeviceidInterface b;

    /* renamed from: e, reason: collision with root package name */
    private ServiceConnection f17910e;
    private Context a = null;
    private CallBack f = null;

    public interface CallBack<T> {
        void a(T t, OpenDeviceId openDeviceId);
    }

    private void b(String str) {
        if (d) {
            Log.e(c, str);
        }
    }

    public boolean c() {
        try {
            if (this.b == null) {
                return false;
            }
            a("Device support opendeviceid");
            return this.b.c();
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public int a(Context context, CallBack<String> callBack) {
        if (context != null) {
            this.a = context;
            this.f = callBack;
            this.f17910e = new ServiceConnection() { // from class: org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.1
                @Override // android.content.ServiceConnection
                public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    OpenDeviceId.this.b = IDeviceidInterface.Stub.a(iBinder);
                    if (OpenDeviceId.this.f != null) {
                        OpenDeviceId.this.f.a("Deviceid Service Connected", OpenDeviceId.this);
                    }
                    OpenDeviceId.this.a("Service onServiceConnected");
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    OpenDeviceId.this.b = null;
                    OpenDeviceId.this.a("Service onServiceDisconnected");
                }
            };
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            if (this.a.bindService(intent, this.f17910e, 1)) {
                a("bindService Successful!");
                return 1;
            }
            a("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    public String a() {
        if (this.a != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.a();
                }
                return null;
            } catch (RemoteException e2) {
                b("getOAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (d) {
            Log.i(c, str);
        }
    }
}
