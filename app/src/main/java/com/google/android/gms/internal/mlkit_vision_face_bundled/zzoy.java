package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public class zzoy {
    private static final zzny zzb = zzny.zza();
    public volatile zzps zza;
    private volatile zznl zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzoy)) {
            return false;
        }
        zzoy zzoyVar = (zzoy) obj;
        zzps zzpsVar = this.zza;
        zzps zzpsVar2 = zzoyVar.zza;
        if (zzpsVar == null && zzpsVar2 == null) {
            return zzb().equals(zzoyVar.zzb());
        }
        if (zzpsVar != null && zzpsVar2 != null) {
            return zzpsVar.equals(zzpsVar2);
        }
        if (zzpsVar != null) {
            zzoyVar.zzc(zzpsVar.zzt());
            return zzpsVar.equals(zzoyVar.zza);
        }
        zzc(zzpsVar2.zzt());
        return this.zza.equals(zzpsVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzni) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzu();
        }
        return 0;
    }

    public final zznl zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zznl.zzb;
            } else {
                this.zzc = this.zza.zzq();
            }
            return this.zzc;
        }
    }

    public final void zzc(zzps zzpsVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzpsVar;
                    this.zzc = zznl.zzb;
                } catch (zzov unused) {
                    this.zza = zzpsVar;
                    this.zzc = zznl.zzb;
                }
            }
        }
    }
}
