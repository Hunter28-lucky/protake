package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzsf extends zzon implements zzpt {
    private static final zzsf zzb;
    private byte zzf = 2;
    private zzos zze = zzon.zzA();

    static {
        zzsf zzsfVar = new zzsf();
        zzb = zzsfVar;
        zzon.zzD(zzsf.class, zzsfVar);
    }

    private zzsf() {
    }

    public static zzsf zze() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzon
    public final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzf);
        }
        if (i2 == 2) {
            return zzon.zzC(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zze", zzsc.class});
        }
        if (i2 == 3) {
            return new zzsf();
        }
        zzsd zzsdVar = null;
        if (i2 == 4) {
            return new zzse(zzsdVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final List zzg() {
        return this.zze;
    }
}
