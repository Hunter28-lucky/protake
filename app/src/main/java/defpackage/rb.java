package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import defpackage.oa;

/* loaded from: classes.dex */
public class rb {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String f8476 = "OpenDeviceId library";

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean f8477 = false;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public oa f8479;

    /* renamed from: ԩ, reason: contains not printable characters */
    public ServiceConnection f8480;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Context f8478 = null;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public InterfaceC2257 f8481 = null;

    /* renamed from: rb$Ϳ, reason: contains not printable characters */
    public class ServiceConnectionC2256 implements ServiceConnection {
        public ServiceConnectionC2256() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            rb.this.f8479 = oa.AbstractBinderC2205.m7706(iBinder);
            if (rb.this.f8481 != null) {
                rb.this.f8481.m8167("Deviceid Service Connected", rb.this);
            }
            rb.this.m8165("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            rb.this.f8479 = null;
            rb.this.m8165("Service onServiceDisconnected");
        }
    }

    /* renamed from: rb$Ԩ, reason: contains not printable characters */
    public interface InterfaceC2257<T> {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void m8167(T t, rb rbVar);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int m8162(Context context, InterfaceC2257<String> interfaceC2257) {
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f8478 = context;
        this.f8481 = interfaceC2257;
        this.f8480 = new ServiceConnectionC2256();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f8478.bindService(intent, this.f8480, 1)) {
            m8165("bindService Successful!");
            return 1;
        }
        m8165("bindService Failed!");
        return -1;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m8163(String str) {
        if (f8477) {
            Log.e(f8476, str);
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String m8164() {
        if (this.f8478 == null) {
            m8163("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            oa oaVar = this.f8479;
            if (oaVar != null) {
                return oaVar.a();
            }
            return null;
        } catch (RemoteException e2) {
            m8163("getOAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m8165(String str) {
        if (f8477) {
            Log.i(f8476, str);
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean m8166() {
        try {
            if (this.f8479 == null) {
                return false;
            }
            m8165("Device support opendeviceid");
            return this.f8479.c();
        } catch (RemoteException unused) {
            m8163("isSupport error, RemoteException!");
            return false;
        }
    }
}
