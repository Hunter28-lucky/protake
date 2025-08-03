package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.mlkit:vision-common@@17.1.0 */
/* loaded from: classes2.dex */
public final class zzju {
    private final zzha zza;
    private zzil zzb = new zzil();

    private zzju(zzha zzhaVar, int i) {
        this.zza = zzhaVar;
        zzkg.zza();
    }

    public static zzju zzc(zzha zzhaVar) {
        return new zzju(zzhaVar, 0);
    }

    public final String zza() {
        zzin zzinVarZzc = this.zza.zzf().zzc();
        return (zzinVarZzc == null || zzg.zzb(zzinVarZzc.zzk())) ? "NA" : (String) Preconditions.checkNotNull(zzinVarZzc.zzk());
    }

    public final byte[] zzb(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zze(this.zzb.zzm());
        try {
            zzkg.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzfo.zza).ignoreNullValues(true).build().encode(this.zza.zzf()).getBytes("utf-8");
            }
            zzhc zzhcVarZzf = this.zza.zzf();
            zzal zzalVar = new zzal();
            zzfo.zza.configure(zzalVar);
            return zzalVar.zza().zza(zzhcVarZzf);
        } catch (UnsupportedEncodingException e2) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e2);
        }
    }

    public final zzju zzd(zzgz zzgzVar) {
        this.zza.zzc(zzgzVar);
        return this;
    }

    public final zzju zze(zzil zzilVar) {
        this.zzb = zzilVar;
        return this;
    }
}
