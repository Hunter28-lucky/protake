package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzt extends zzon implements zzpt {
    private static final zzt zzb;
    private int zze;
    private zzar zzf;
    private zzar zzg;

    static {
        zzt zztVar = new zzt();
        zzb = zztVar;
        zzon.zzD(zzt.class, zztVar);
    }

    private zzt() {
    }

    public static zzs zza() {
        return (zzs) zzb.zzw();
    }

    public static /* synthetic */ void zzc(zzt zztVar, zzar zzarVar) {
        zzarVar.getClass();
        zztVar.zzf = zzarVar;
        zztVar.zze |= 1;
    }

    public static /* synthetic */ void zzd(zzt zztVar, zzar zzarVar) {
        zzarVar.getClass();
        zztVar.zzg = zzarVar;
        zztVar.zze |= 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzon
    public final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzon.zzC(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzt();
        }
        zzr zzrVar = null;
        if (i2 == 4) {
            return new zzs(zzrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
