package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzp extends zzon implements zzpt {
    private static final zzp zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private boolean zzj;
    private long zzk;
    private String zzl = "";

    static {
        zzp zzpVar = new zzp();
        zzb = zzpVar;
        zzon.zzD(zzp.class, zzpVar);
    }

    private zzp() {
    }

    public static zzo zza() {
        return (zzo) zzb.zzw();
    }

    public static /* synthetic */ void zzc(zzp zzpVar, int i) {
        zzpVar.zze |= 1;
        zzpVar.zzf = i;
    }

    public static /* synthetic */ void zzd(zzp zzpVar, long j) {
        zzpVar.zze |= 32;
        zzpVar.zzk = j;
    }

    public static /* synthetic */ void zze(zzp zzpVar, int i) {
        zzpVar.zze |= 2;
        zzpVar.zzg = i;
    }

    public static /* synthetic */ void zzg(zzp zzpVar, int i) {
        zzpVar.zzh = i - 1;
        zzpVar.zze |= 4;
    }

    public static /* synthetic */ void zzh(zzp zzpVar, int i) {
        zzpVar.zzi = i - 1;
        zzpVar.zze |= 8;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzon
    public final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzon.zzC(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ဂ\u0005\u0007ဈ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", zzm.zza, "zzi", zzq.zza, "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzp();
        }
        zzn zznVar = null;
        if (i2 == 4) {
            return new zzo(zznVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
