package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zznc {
    private final zzkc zza;
    private zzlr zzb = new zzlr();
    private final int zzc;

    private zznc(zzkc zzkcVar, int i) {
        this.zza = zzkcVar;
        zznl.zza();
        this.zzc = i;
    }

    public static zznc zzd(zzkc zzkcVar) {
        return new zznc(zzkcVar, 0);
    }

    public static zznc zze(zzkc zzkcVar, int i) {
        return new zznc(zzkcVar, 1);
    }

    public final int zza() {
        return this.zzc;
    }

    public final String zzb() {
        zzlt zzltVarZzf = this.zza.zzj().zzf();
        return (zzltVarZzf == null || zzac.zzb(zzltVarZzf.zzk())) ? "NA" : (String) Preconditions.checkNotNull(zzltVarZzf.zzk());
    }

    public final byte[] zzc(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzi(this.zzb.zzm());
        try {
            zznl.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzif.zza).ignoreNullValues(true).build().encode(this.zza.zzj()).getBytes("utf-8");
            }
            zzke zzkeVarZzj = this.zza.zzj();
            zzcy zzcyVar = new zzcy();
            zzif.zza.configure(zzcyVar);
            return zzcyVar.zza().zza(zzkeVarZzj);
        } catch (UnsupportedEncodingException e2) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e2);
        }
    }

    public final zznc zzf(zzkb zzkbVar) {
        this.zza.zzf(zzkbVar);
        return this;
    }

    public final zznc zzg(zzlr zzlrVar) {
        this.zzb = zzlrVar;
        return this;
    }
}
