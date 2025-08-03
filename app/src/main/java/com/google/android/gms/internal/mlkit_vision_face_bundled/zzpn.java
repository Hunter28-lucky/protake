package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzpn {
    public static final int zza(int i, Object obj, Object obj2) {
        zzpm zzpmVar = (zzpm) obj;
        if (zzpmVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzpmVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzpm zzpmVarZzb = (zzpm) obj;
        zzpm zzpmVar = (zzpm) obj2;
        if (!zzpmVar.isEmpty()) {
            if (!zzpmVarZzb.zze()) {
                zzpmVarZzb = zzpmVarZzb.zzb();
            }
            zzpmVarZzb.zzd(zzpmVar);
        }
        return zzpmVarZzb;
    }
}
