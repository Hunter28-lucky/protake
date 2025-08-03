package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class zc implements xc {

    /* renamed from: zc$Ԩ, reason: contains not printable characters */
    public static final class ServiceConnectionC2310 implements ServiceConnection {

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean f8787;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final LinkedBlockingQueue<IBinder> f8788;

        public ServiceConnectionC2310() {
            this.f8787 = false;
            this.f8788 = new LinkedBlockingQueue<>();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws InterruptedException {
            try {
                this.f8788.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public IBinder m8671() throws InterruptedException {
            if (this.f8787) {
                throw new IllegalStateException();
            }
            this.f8787 = true;
            return this.f8788.poll(5L, TimeUnit.SECONDS);
        }
    }

    /* renamed from: zc$Ԫ, reason: contains not printable characters */
    public static final class C2311 implements IInterface {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public IBinder f8789;

        public C2311(IBinder iBinder) {
            this.f8789 = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f8789;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public String m8672() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f8789.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    @Override // defpackage.xc
    public String a(Context context) {
        ServiceConnectionC2310 serviceConnectionC2310 = new ServiceConnectionC2310();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, serviceConnectionC2310, 1)) {
            try {
                return new C2311(serviceConnectionC2310.m8671()).m8672();
            } catch (Exception unused) {
            } finally {
                context.unbindService(serviceConnectionC2310);
            }
        }
        return null;
    }
}
