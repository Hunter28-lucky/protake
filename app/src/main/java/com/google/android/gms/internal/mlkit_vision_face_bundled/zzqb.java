package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzqb {
    private static final zzqb zza = new zzqb();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzqf zzb = new zzpk();

    private zzqb() {
    }

    public static zzqb zza() {
        return zza;
    }

    public final zzqe zzb(Class cls) {
        zzot.zzf(cls, "messageType");
        zzqe zzqeVarZza = (zzqe) this.zzc.get(cls);
        if (zzqeVarZza == null) {
            zzqeVarZza = this.zzb.zza(cls);
            zzot.zzf(cls, "messageType");
            zzot.zzf(zzqeVarZza, "schema");
            zzqe zzqeVar = (zzqe) this.zzc.putIfAbsent(cls, zzqeVarZza);
            if (zzqeVar != null) {
                return zzqeVar;
            }
        }
        return zzqeVarZza;
    }
}
