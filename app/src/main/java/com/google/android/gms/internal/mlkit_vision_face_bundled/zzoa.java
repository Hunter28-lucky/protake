package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzoa extends zznz {
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznz
    public final int zza(Map.Entry entry) {
        return 202056002;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznz
    public final zzod zzb(Object obj) {
        return ((zzoj) obj).zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznz
    public final zzod zzc(Object obj) {
        return ((zzoj) obj).zzc();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznz
    public final Object zzd(zzny zznyVar, zzps zzpsVar, int i) {
        return zznyVar.zzc(zzpsVar, i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznz
    public final void zze(Object obj) {
        ((zzoj) obj).zzb.zzh();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznz
    public final boolean zzf(zzps zzpsVar) {
        return zzpsVar instanceof zzoj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznz
    public final void zzg(zznu zznuVar, Map.Entry entry) throws IOException {
        zzok zzokVar = (zzok) entry.getKey();
        zzrl zzrlVar = zzrl.zza;
        switch (zzokVar.zzc.ordinal()) {
            case 0:
                zzqg.zzL(202056002, (List) entry.getValue(), zznuVar, false);
                break;
            case 1:
                zzqg.zzP(202056002, (List) entry.getValue(), zznuVar, false);
                break;
            case 2:
                zzqg.zzS(202056002, (List) entry.getValue(), zznuVar, false);
                break;
            case 3:
                zzqg.zzaa(202056002, (List) entry.getValue(), zznuVar, false);
                break;
            case 4:
                zzqg.zzR(202056002, (List) entry.getValue(), zznuVar, false);
                break;
            case 5:
                zzqg.zzO(202056002, (List) entry.getValue(), zznuVar, false);
                break;
            case 6:
                zzqg.zzN(202056002, (List) entry.getValue(), zznuVar, false);
                break;
            case 7:
                zzqg.zzJ(202056002, (List) entry.getValue(), zznuVar, false);
                break;
            case 8:
                zzqg.zzY(202056002, (List) entry.getValue(), zznuVar);
                break;
            case 9:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    zzqg.zzQ(202056002, (List) entry.getValue(), zznuVar, zzqb.zza().zzb(list.get(0).getClass()));
                    break;
                }
                break;
            case 10:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    zzqg.zzT(202056002, (List) entry.getValue(), zznuVar, zzqb.zza().zzb(list2.get(0).getClass()));
                    break;
                }
                break;
            case 11:
                zzqg.zzK(202056002, (List) entry.getValue(), zznuVar);
                break;
            case 12:
                zzqg.zzZ(202056002, (List) entry.getValue(), zznuVar, false);
                break;
            case 13:
                zzqg.zzR(202056002, (List) entry.getValue(), zznuVar, false);
                break;
            case 14:
                zzqg.zzU(202056002, (List) entry.getValue(), zznuVar, false);
                break;
            case 15:
                zzqg.zzV(202056002, (List) entry.getValue(), zznuVar, false);
                break;
            case 16:
                zzqg.zzW(202056002, (List) entry.getValue(), zznuVar, false);
                break;
            case 17:
                zzqg.zzX(202056002, (List) entry.getValue(), zznuVar, false);
                break;
        }
    }
}
