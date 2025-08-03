package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface oa extends IInterface {

    /* renamed from: oa$Ϳ, reason: contains not printable characters */
    public static abstract class AbstractBinderC2205 extends Binder implements oa {

        /* renamed from: oa$Ϳ$Ϳ, reason: contains not printable characters */
        public static class C2206 implements oa {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public IBinder f8096;

            public C2206(IBinder iBinder) {
                this.f8096 = iBinder;
            }

            @Override // defpackage.oa
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f8096.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8096;
            }

            @Override // defpackage.oa
            public boolean c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f8096.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static oa m7706(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof oa)) ? new C2206(iBinder) : (oa) iInterfaceQueryLocalInterface;
        }
    }

    String a() throws RemoteException;

    boolean c() throws RemoteException;
}
