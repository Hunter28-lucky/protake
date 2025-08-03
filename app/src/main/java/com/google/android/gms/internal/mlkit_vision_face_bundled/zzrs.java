package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzrs extends zzon implements zzpt {
    private static final zzrs zzb;
    private int zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;

    static {
        zzrs zzrsVar = new zzrs();
        zzb = zzrsVar;
        zzon.zzD(zzrs.class, zzrsVar);
    }

    private zzrs() {
    }

    public static zzrs zzj() {
        return zzb;
    }

    public final float zzc() {
        return this.zzf;
    }

    public final float zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzon
    public final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzon.zzC(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzrs();
        }
        zzrn zzrnVar = null;
        if (i2 == 4) {
            return new zzrr(zzrnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final float zzg() {
        return this.zzg;
    }

    public final float zzh() {
        return this.zzi;
    }
}
