package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface da extends IInterface {

    /* renamed from: da$Ϳ, reason: contains not printable characters */
    public static abstract class AbstractBinderC1947 extends Binder implements da {

        /* renamed from: da$Ϳ$Ϳ, reason: contains not printable characters */
        public static class C1948 implements da {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public IBinder f6545;

            public C1948(IBinder iBinder) {
                this.f6545 = iBinder;
            }

            @Override // defpackage.da
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.f6545.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6545;
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static da m5924(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof da)) ? new C1948(iBinder) : (da) iInterfaceQueryLocalInterface;
        }
    }

    String a() throws RemoteException;
}
