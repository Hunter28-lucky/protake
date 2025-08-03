package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import defpackage.da;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class dg implements xc {

    /* renamed from: dg$Ԩ, reason: contains not printable characters */
    public static final class ServiceConnectionC1954 implements ServiceConnection {

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean f6577;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final LinkedBlockingQueue<IBinder> f6578;

        public ServiceConnectionC1954() {
            this.f6577 = false;
            this.f6578 = new LinkedBlockingQueue<>();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws InterruptedException {
            try {
                this.f6578.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public IBinder m5945() throws InterruptedException {
            if (this.f6577) {
                throw new IllegalStateException();
            }
            this.f6577 = true;
            return this.f6578.poll(5L, TimeUnit.SECONDS);
        }
    }

    @Override // defpackage.xc
    public String a(Context context) {
        ServiceConnectionC1954 serviceConnectionC1954 = new ServiceConnectionC1954();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, serviceConnectionC1954, 1)) {
            try {
                return da.AbstractBinderC1947.m5924(serviceConnectionC1954.m5945()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(serviceConnectionC1954);
            }
        }
        return null;
    }
}
