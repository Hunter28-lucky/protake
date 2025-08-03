package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzsb extends zzon implements zzpt {
    private static final zzsb zzb;
    private int zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private int zzi = 15000;
    private int zzj;
    private float zzk;

    static {
        zzsb zzsbVar = new zzsb();
        zzb = zzsbVar;
        zzon.zzD(zzsb.class, zzsbVar);
    }

    private zzsb() {
    }

    public final float zzc() {
        return this.zzf;
    }

    public final float zze() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzon
    public final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzon.zzC(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ဌ\u0003\u0005ဌ\u0004\u0006ခ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzry.zza, "zzj", zzsa.zza, "zzk"});
        }
        if (i2 == 3) {
            return new zzsb();
        }
        zzrn zzrnVar = null;
        if (i2 == 4) {
            return new zzrw(zzrnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzh() {
        int iZza = zzrz.zza(this.zzi);
        if (iZza == 0) {
            return 15001;
        }
        return iZza;
    }
}
