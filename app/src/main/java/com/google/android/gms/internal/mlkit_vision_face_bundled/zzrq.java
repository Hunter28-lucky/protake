package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzrq extends zzon implements zzpt {
    private static final zzrq zzb;
    private int zze;
    private int zzf;
    private String zzg = "";
    private float zzh;
    private float zzi;

    static {
        zzrq zzrqVar = new zzrq();
        zzb = zzrqVar;
        zzon.zzD(zzrq.class, zzrqVar);
    }

    private zzrq() {
    }

    public final float zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzon
    public final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzon.zzC(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"zze", "zzf", zzrp.zza, "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzrq();
        }
        zzrn zzrnVar = null;
        if (i2 == 4) {
            return new zzro(zzrnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final String zzg() {
        return this.zzg;
    }
}
