package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzpc extends zzpg {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzpc() {
        super(null);
    }

    public /* synthetic */ zzpc(zzpb zzpbVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzpg
    public final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzrf.zzf(obj, j);
        if (list instanceof zzpa) {
            objUnmodifiableList = ((zzpa) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzqa) && (list instanceof zzos)) {
                zzos zzosVar = (zzos) list;
                if (zzosVar.zzc()) {
                    zzosVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzrf.zzs(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzpg
    public final void zzb(Object obj, Object obj2, long j) {
        zzoz zzozVar;
        List list = (List) zzrf.zzf(obj2, j);
        int size = list.size();
        List listZzd = (List) zzrf.zzf(obj, j);
        if (listZzd.isEmpty()) {
            listZzd = listZzd instanceof zzpa ? new zzoz(size) : ((listZzd instanceof zzqa) && (listZzd instanceof zzos)) ? ((zzos) listZzd).zzd(size) : new ArrayList(size);
            zzrf.zzs(obj, j, listZzd);
        } else {
            if (zza.isAssignableFrom(listZzd.getClass())) {
                ArrayList arrayList = new ArrayList(listZzd.size() + size);
                arrayList.addAll(listZzd);
                zzrf.zzs(obj, j, arrayList);
                zzozVar = arrayList;
            } else if (listZzd instanceof zzra) {
                zzoz zzozVar2 = new zzoz(listZzd.size() + size);
                zzozVar2.addAll(zzozVar2.size(), (zzra) listZzd);
                zzrf.zzs(obj, j, zzozVar2);
                zzozVar = zzozVar2;
            } else if ((listZzd instanceof zzqa) && (listZzd instanceof zzos)) {
                zzos zzosVar = (zzos) listZzd;
                if (!zzosVar.zzc()) {
                    listZzd = zzosVar.zzd(listZzd.size() + size);
                    zzrf.zzs(obj, j, listZzd);
                }
            }
            listZzd = zzozVar;
        }
        int size2 = listZzd.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            listZzd.addAll(list);
        }
        if (size2 > 0) {
            list = listZzd;
        }
        zzrf.zzs(obj, j, list);
    }
}
