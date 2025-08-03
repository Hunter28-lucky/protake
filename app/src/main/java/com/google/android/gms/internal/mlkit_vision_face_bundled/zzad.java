package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzad extends zzon implements zzpt {
    private static final zzad zzb;
    private int zze;
    private int zzf;
    private zzos zzg = zzon.zzA();

    static {
        zzad zzadVar = new zzad();
        zzb = zzadVar;
        zzon.zzD(zzad.class, zzadVar);
    }

    private zzad() {
    }

    public static zzad zzb() {
        return zzb;
    }

    public final List zzc() {
        return this.zzg;
    }

    public final int zzd() {
        int iZza = zzac.zza(this.zzf);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzon
    public final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzon.zzC(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zze", "zzf", zzab.zza, "zzg", zzz.class});
        }
        if (i2 == 3) {
            return new zzad();
        }
        zzr zzrVar = null;
        if (i2 == 4) {
            return new zzx(zzrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
