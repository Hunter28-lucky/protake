package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzaj extends zzon implements zzpt {
    private static final zzaj zzb;
    private int zze;
    private zzar zzf;
    private zzar zzg;
    private zzar zzh;
    private zzar zzi;

    static {
        zzaj zzajVar = new zzaj();
        zzb = zzajVar;
        zzon.zzD(zzaj.class, zzajVar);
    }

    private zzaj() {
    }

    public static zzai zza() {
        return (zzai) zzb.zzw();
    }

    public static /* synthetic */ void zzc(zzaj zzajVar, zzar zzarVar) {
        zzarVar.getClass();
        zzajVar.zzf = zzarVar;
        zzajVar.zze |= 1;
    }

    public static /* synthetic */ void zzd(zzaj zzajVar, zzar zzarVar) {
        zzarVar.getClass();
        zzajVar.zzg = zzarVar;
        zzajVar.zze |= 2;
    }

    public static /* synthetic */ void zze(zzaj zzajVar, zzar zzarVar) {
        zzarVar.getClass();
        zzajVar.zzh = zzarVar;
        zzajVar.zze |= 4;
    }

    public static /* synthetic */ void zzg(zzaj zzajVar, zzar zzarVar) {
        zzarVar.getClass();
        zzajVar.zzi = zzarVar;
        zzajVar.zze |= 8;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzon
    public final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzon.zzC(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzaj();
        }
        zzr zzrVar = null;
        if (i2 == 4) {
            return new zzai(zzrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
