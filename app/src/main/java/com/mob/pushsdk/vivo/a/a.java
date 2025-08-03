package com.mob.pushsdk.vivo.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mob.pushsdk.vivo.c.d;

/* loaded from: classes2.dex */
public interface a extends IInterface {
    void a(Bundle bundle) throws RemoteException;

    /* renamed from: com.mob.pushsdk.vivo.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC1899a extends Binder implements a {

        /* renamed from: com.mob.pushsdk.vivo.a.a$a$a, reason: collision with other inner class name */
        public static class C1900a implements a {
            public static a a;
            private IBinder b;

            public C1900a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.mob.pushsdk.vivo.a.a
            public void a(Bundle bundle) throws Throwable {
                Parcel parcelObtain;
                Parcel parcel = null;
                try {
                    parcelObtain = Parcel.obtain();
                } catch (Throwable th) {
                    th = th;
                    parcelObtain = null;
                }
                try {
                    Parcel parcelObtain2 = Parcel.obtain();
                    parcelObtain.writeInterfaceToken("com.vivo.vms.IPCCallback");
                    if (!this.b.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC1899a.a() != null) {
                        AbstractBinderC1899a.a().a(bundle);
                        if (com.mob.pushsdk.vivo.c.a.b(parcelObtain2)) {
                            parcelObtain2.recycle();
                        }
                        if (com.mob.pushsdk.vivo.c.a.b(parcelObtain)) {
                            parcelObtain.recycle();
                            return;
                        }
                        return;
                    }
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        bundle.readFromParcel(parcelObtain2);
                    }
                    if (com.mob.pushsdk.vivo.c.a.b(parcelObtain2)) {
                        parcelObtain2.recycle();
                    }
                    if (com.mob.pushsdk.vivo.c.a.b(parcelObtain)) {
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (com.mob.pushsdk.vivo.c.a.b(null)) {
                        parcel.recycle();
                    }
                    if (com.mob.pushsdk.vivo.c.a.b(parcelObtain)) {
                        parcelObtain.recycle();
                    }
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.vivo.vms.IPCCallback");
                if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof a)) {
                    return (a) iInterfaceQueryLocalInterface;
                }
                return new C1900a(iBinder);
            } catch (Throwable th) {
                d.a().a(th);
                return null;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            try {
                if (i == 1598968902) {
                    parcel2.writeString("com.vivo.vms.IPCCallback");
                    return true;
                }
                if (i != 1) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel.enforceInterface("com.vivo.vms.IPCCallback");
                Bundle bundle = new Bundle();
                a(bundle);
                parcel2.writeNoException();
                parcel2.writeInt(1);
                bundle.writeToParcel(parcel2, 1);
                return true;
            } catch (Throwable th) {
                d.a().a(th);
                return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        public static a a() {
            return C1900a.a;
        }
    }
}
