package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzny {
    public static final zzny zza = new zzny(true);
    private static volatile boolean zzb = false;
    private static volatile zzny zzc;
    private final Map zzd;

    public zzny() {
        this.zzd = new HashMap();
    }

    public static zzny zza() {
        zzny zznyVar = zzc;
        if (zznyVar == null) {
            synchronized (zzny.class) {
                zznyVar = zzc;
                if (zznyVar == null) {
                    zznyVar = zza;
                    zzc = zznyVar;
                }
            }
        }
        return zznyVar;
    }

    public static zzny zzb() {
        return new zzny();
    }

    public final zzol zzc(zzps zzpsVar, int i) {
        return (zzol) this.zzd.get(new zznx(zzpsVar, i));
    }

    public final void zzd(zzol zzolVar) {
        this.zzd.put(new zznx(zzolVar.zza, 202056002), zzolVar);
    }

    public zzny(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
