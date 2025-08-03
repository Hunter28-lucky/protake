package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes2.dex */
final class zzdm extends zzdq {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzdm() {
        throw null;
    }

    public /* synthetic */ zzdm(zzdl zzdlVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdq
    public final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzfp.zzf(obj, j);
        if (list instanceof zzdk) {
            objUnmodifiableList = ((zzdk) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzek) && (list instanceof zzcz)) {
                zzcz zzczVar = (zzcz) list;
                if (zzczVar.zzc()) {
                    zzczVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzfp.zzs(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzdq
    public final void zzb(Object obj, Object obj2, long j) {
        zzdj zzdjVar;
        List list = (List) zzfp.zzf(obj2, j);
        int size = list.size();
        List listZzd = (List) zzfp.zzf(obj, j);
        if (listZzd.isEmpty()) {
            listZzd = listZzd instanceof zzdk ? new zzdj(size) : ((listZzd instanceof zzek) && (listZzd instanceof zzcz)) ? ((zzcz) listZzd).zzd(size) : new ArrayList(size);
            zzfp.zzs(obj, j, listZzd);
        } else {
            if (zza.isAssignableFrom(listZzd.getClass())) {
                ArrayList arrayList = new ArrayList(listZzd.size() + size);
                arrayList.addAll(listZzd);
                zzfp.zzs(obj, j, arrayList);
                zzdjVar = arrayList;
            } else if (listZzd instanceof zzfk) {
                zzdj zzdjVar2 = new zzdj(listZzd.size() + size);
                zzdjVar2.addAll(zzdjVar2.size(), (zzfk) listZzd);
                zzfp.zzs(obj, j, zzdjVar2);
                zzdjVar = zzdjVar2;
            } else if ((listZzd instanceof zzek) && (listZzd instanceof zzcz)) {
                zzcz zzczVar = (zzcz) listZzd;
                if (!zzczVar.zzc()) {
                    listZzd = zzczVar.zzd(listZzd.size() + size);
                    zzfp.zzs(obj, j, listZzd);
                }
            }
            listZzd = zzdjVar;
        }
        int size2 = listZzd.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            listZzd.addAll(list);
        }
        if (size2 > 0) {
            list = listZzd;
        }
        zzfp.zzs(obj, j, list);
    }
}
