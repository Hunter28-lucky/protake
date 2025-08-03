package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public abstract class zzoj extends zzon implements zzpt {
    public zzod zzb = zzod.zzd();

    public final zzod zzc() {
        if (this.zzb.zzk()) {
            this.zzb = this.zzb.clone();
        }
        return this.zzb;
    }

    public final Object zze(zznw zznwVar) {
        zzol zzolVar = (zzol) zznwVar;
        if (zzolVar.zza != ((zzon) zzf(6, null, null))) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
        Object objZze = this.zzb.zze(zzolVar.zzd);
        if (objZze == null) {
            return zzolVar.zzb;
        }
        if (zzolVar.zzd.zzc.zza() != zzrm.ENUM) {
            return objZze;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : (List) objZze) {
            if (zzolVar.zzd.zzc.zza() == zzrm.ENUM) {
                zzoq zzoqVar = zzolVar.zzd.zza;
                ((Integer) obj).intValue();
                throw null;
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
