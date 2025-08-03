package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: CoolpadDeviceIdSupplier.java */
/* loaded from: classes2.dex */
public class ab implements z {
    private static final String a = "Coolpad";
    private static final String b = "com.coolpad.deviceidsupport";
    private static final String c = "com.coolpad.deviceidsupport.DeviceIdService";
    private static a d;
    private CountDownLatch f;
    private Context g;

    /* renamed from: e, reason: collision with root package name */
    private String f17752e = "";
    private final ServiceConnection h = new ServiceConnection() { // from class: com.umeng.analytics.pro.ab.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = ab.d = a.AbstractBinderC1918a.a(iBinder);
                ab.this.f17752e = ab.d.b(ab.this.g.getPackageName());
                Log.d(ab.a, "onServiceConnected: oaid = " + ab.this.f17752e);
            } catch (RemoteException | NullPointerException e2) {
                Log.e(ab.a, "onServiceConnected failed e=" + e2.getMessage());
            }
            ab.this.f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(ab.a, "onServiceDisconnected");
            a unused = ab.d = null;
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(b, c));
            if (context.bindService(intent, this.h, 1)) {
                return;
            }
            Log.e(a, "bindService return false");
        } catch (Throwable th) {
            Log.e(a, "bindService failed. e=" + th.getMessage());
            this.f.countDown();
        }
    }

    private void c(Context context) {
        try {
            Log.d(a, "call unbindService.");
            context.unbindService(this.h);
        } catch (Throwable th) {
            Log.e(a, "unbindService failed. e=" + th.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.g = context.getApplicationContext();
        this.f = new CountDownLatch(1);
        try {
            b(context);
            if (!this.f.await(500L, TimeUnit.MILLISECONDS)) {
                Log.e(a, "getOAID time-out");
            }
            return this.f17752e;
        } catch (InterruptedException e2) {
            Log.e(a, "getOAID interrupted. e=" + e2.getMessage());
            return null;
        } finally {
            c(context);
        }
    }
}
