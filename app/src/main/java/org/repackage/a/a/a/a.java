package org.repackage.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IOpenID.java */
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* compiled from: IOpenID.java */
    /* renamed from: org.repackage.a.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC2223a extends Binder implements a {

        /* compiled from: IOpenID.java */
        /* renamed from: org.repackage.a.a.a.a$a$a, reason: collision with other inner class name */
        public static class C2224a implements a {
            public IBinder a;

            public C2224a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C2224a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
