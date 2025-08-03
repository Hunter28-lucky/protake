package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
class zzni extends zznh {
    public final byte[] zza;

    public zzni(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznl
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zznl) || zzd() != ((zznl) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzni)) {
            return obj.equals(this);
        }
        zzni zzniVar = (zzni) obj;
        int iZzk = zzk();
        int iZzk2 = zzniVar.zzk();
        if (iZzk != 0 && iZzk2 != 0 && iZzk != iZzk2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzniVar.zzd()) {
            int iZzd2 = zzd();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(iZzd);
            sb.append(iZzd2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (iZzd > zzniVar.zzd()) {
            int iZzd3 = zzniVar.zzd();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(iZzd);
            sb2.append(", ");
            sb2.append(iZzd3);
            throw new IllegalArgumentException(sb2.toString());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzniVar.zza;
        zzniVar.zzc();
        int i = 0;
        int i2 = 0;
        while (i < iZzd) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznl
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznl
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznl
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznl
    public final int zze(int i, int i2, int i3) {
        return zzot.zzd(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznl
    public final zznl zzf(int i, int i2) {
        int iZzj = zznl.zzj(0, i2, zzd());
        return iZzj == 0 ? zznl.zzb : new zznf(this.zza, 0, iZzj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznl
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznl
    public final void zzh(zzna zznaVar) throws IOException {
        ((zznq) zznaVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zznl
    public final boolean zzi() {
        return zzrk.zzf(this.zza, 0, zzd());
    }
}
