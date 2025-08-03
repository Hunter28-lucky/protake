package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public abstract class zzmo extends zzb implements zzmp {
    public zzmo() {
        super("com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
    }

    public static zzmp asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
        return iInterfaceQueryLocalInterface instanceof zzmp ? (zzmp) iInterfaceQueryLocalInterface : new zzmn(iBinder);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzmm zzmmVarNewFaceDetector = newFaceDetector(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzmh) zzc.zza(parcel, zzmh.CREATOR));
        parcel2.writeNoException();
        zzc.zzb(parcel2, zzmmVarNewFaceDetector);
        return true;
    }
}
