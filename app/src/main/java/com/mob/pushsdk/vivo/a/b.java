package com.mob.pushsdk.vivo.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mob.pushsdk.vivo.a.a;
import com.mob.pushsdk.vivo.c.d;

/* loaded from: classes2.dex */
public interface b extends IInterface {
    Bundle a(Bundle bundle, com.mob.pushsdk.vivo.a.a aVar) throws RemoteException;

    public static abstract class a extends Binder implements b {

        /* renamed from: com.mob.pushsdk.vivo.a.b$a$a, reason: collision with other inner class name */
        public static class C1901a implements b {
            public static b a;
            private IBinder b;

            public C1901a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.mob.pushsdk.vivo.a.b
            public Bundle a(Bundle bundle, com.mob.pushsdk.vivo.a.a aVar) throws RemoteException {
                Parcel parcelObtain;
                Parcel parcelObtain2;
                try {
                    parcelObtain = Parcel.obtain();
                    try {
                        parcelObtain2 = Parcel.obtain();
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2 = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parcelObtain = null;
                    parcelObtain2 = null;
                }
                try {
                    parcelObtain.writeInterfaceToken("com.vivo.vms.IPCInvoke");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (!this.b.transact(1, parcelObtain, parcelObtain2, 0) && a.a() != null) {
                        return a.a().a(bundle, aVar);
                    }
                    parcelObtain2.readException();
                    Bundle bundle2 = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    if (com.mob.pushsdk.vivo.c.a.b(parcelObtain2)) {
                        parcelObtain2.recycle();
                    }
                    if (com.mob.pushsdk.vivo.c.a.b(parcelObtain)) {
                        parcelObtain.recycle();
                    }
                    return bundle2;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        d.a().a(th);
                        if (com.mob.pushsdk.vivo.c.a.b(parcelObtain2)) {
                            parcelObtain2.recycle();
                        }
                        if (com.mob.pushsdk.vivo.c.a.b(parcelObtain)) {
                            parcelObtain.recycle();
                        }
                        return null;
                    } finally {
                        if (com.mob.pushsdk.vivo.c.a.b(parcelObtain2)) {
                            parcelObtain2.recycle();
                        }
                        if (com.mob.pushsdk.vivo.c.a.b(parcelObtain)) {
                            parcelObtain.recycle();
                        }
                    }
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.vivo.vms.IPCInvoke");
                if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof b)) {
                    return (b) iInterfaceQueryLocalInterface;
                }
                return new C1901a(iBinder);
            } catch (Throwable th) {
                d.a().a(th);
                return null;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            try {
                if (i == 1598968902) {
                    parcel2.writeString("com.vivo.vms.IPCInvoke");
                    return true;
                }
                if (i != 1) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel.enforceInterface("com.vivo.vms.IPCInvoke");
                Bundle bundleA = a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, a.AbstractBinderC1899a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (bundleA == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                bundleA.writeToParcel(parcel2, 1);
                return true;
            } catch (Throwable th) {
                d.a().a(th);
                return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        public static b a() {
            return C1901a.a;
        }
    }
}
