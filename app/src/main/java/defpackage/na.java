package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface na extends IInterface {

    /* renamed from: na$Ϳ, reason: contains not printable characters */
    public static abstract class AbstractBinderC2194 extends Binder implements na {

        /* renamed from: na$Ϳ$Ϳ, reason: contains not printable characters */
        public static class C2195 implements na {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public IBinder f8054;

            public C2195(IBinder iBinder) {
                this.f8054 = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8054;
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public String m7644(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f8054.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static na m7643(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof na)) ? new C2195(iBinder) : (na) iInterfaceQueryLocalInterface;
        }
    }
}
