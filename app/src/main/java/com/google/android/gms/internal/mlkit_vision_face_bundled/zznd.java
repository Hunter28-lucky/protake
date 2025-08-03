package com.google.android.gms.internal.mlkit_vision_face_bundled;

import androidx.exifinterface.media.ExifInterface;
import java.util.Comparator;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zznd implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zznl zznlVar = (zznl) obj;
        zznl zznlVar2 = (zznl) obj2;
        zznb zznbVar = new zznb(zznlVar);
        zznb zznbVar2 = new zznb(zznlVar2);
        while (zznbVar.hasNext() && zznbVar2.hasNext()) {
            int iZza = zznc.zza(zznbVar.zza() & ExifInterface.MARKER, zznbVar2.zza() & ExifInterface.MARKER);
            if (iZza != 0) {
                return iZza;
            }
        }
        return zznc.zza(zznlVar.zzd(), zznlVar2.zzd());
    }
}
