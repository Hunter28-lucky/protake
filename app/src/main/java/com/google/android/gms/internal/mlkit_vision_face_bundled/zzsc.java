package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzsc extends zzoj {
    private static final zzsc zze;
    private int zzf;
    private zzrs zzg;
    private float zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private float zzm;
    private long zzp;
    private long zzq;
    private long zzr;
    private float zzs;
    private byte zzt = 2;
    private zzos zzh = zzon.zzA();
    private zzos zzn = zzon.zzA();
    private zzos zzo = zzon.zzA();

    static {
        zzsc zzscVar = new zzsc();
        zze = zzscVar;
        zzon.zzD(zzsc.class, zzscVar);
    }

    private zzsc() {
    }

    public static zzsc zzn() {
        return zze;
    }

    public final List zzF() {
        return this.zzh;
    }

    public final boolean zzG() {
        return (this.zzf & 2) != 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzon
    public final Object zzf(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzt);
        }
        if (i2 == 2) {
            return zzon.zzC(zze, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0003\u0000\u0001ဉ\u0000\u0002\u001b\u0003ခ\u0001\u0004ခ\u0002\u0005ခ\u0003\u0006ခ\u0004\u0007\u001b\b\u001b\tဃ\u0007\nခ\t\u000bဃ\b\fဃ\u0006\rခ\u0005", new Object[]{"zzf", "zzg", "zzh", zzsb.class, "zzi", "zzj", "zzk", "zzl", "zzn", zzrv.class, "zzo", zzrq.class, "zzq", "zzs", "zzr", "zzp", "zzm"});
        }
        if (i2 == 3) {
            return new zzsc();
        }
        zzrn zzrnVar = null;
        if (i2 == 4) {
            return new zzrt(zzrnVar);
        }
        if (i2 == 5) {
            return zze;
        }
        this.zzt = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final float zzg() {
        return this.zzi;
    }

    public final float zzh() {
        return this.zzk;
    }

    public final float zzi() {
        return this.zzj;
    }

    public final float zzj() {
        return this.zzl;
    }

    public final long zzk() {
        return this.zzq;
    }

    public final zzrs zzl() {
        zzrs zzrsVar = this.zzg;
        return zzrsVar == null ? zzrs.zzj() : zzrsVar;
    }

    public final List zzo() {
        return this.zzo;
    }
}
