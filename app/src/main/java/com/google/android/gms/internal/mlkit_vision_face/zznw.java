package com.google.android.gms.internal.mlkit_vision_face;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zznw extends zza implements zzny {
    public zznw(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzny
    public final zznv zzd(IObjectWrapper iObjectWrapper, zznr zznrVar) throws RemoteException {
        zznv zznvVar;
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, iObjectWrapper);
        zzc.zza(parcelZza, zznrVar);
        Parcel parcelZzb = zzb(1, parcelZza);
        IBinder strongBinder = parcelZzb.readStrongBinder();
        if (strongBinder == null) {
            zznvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.mlkit.vision.face.aidls.IFaceDetector");
            zznvVar = iInterfaceQueryLocalInterface instanceof zznv ? (zznv) iInterfaceQueryLocalInterface : new zznv(strongBinder);
        }
        parcelZzb.recycle();
        return zznvVar;
    }
}
