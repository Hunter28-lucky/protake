package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzlp implements zzld {
    private final zzig zza;
    private zzka zzb = new zzka();

    private zzlp(zzig zzigVar, int i) {
        this.zza = zzigVar;
        zzma.zza();
    }

    public static zzld zzf(zzig zzigVar) {
        return new zzlp(zzigVar, 0);
    }

    public static zzld zzg() {
        return new zzlp(new zzig(), 0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzld
    public final zzld zza(zzif zzifVar) {
        this.zza.zzf(zzifVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzld
    public final zzld zzb(zzim zzimVar) {
        this.zza.zzi(zzimVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzld
    public final zzld zzc(zzka zzkaVar) {
        this.zzb = zzkaVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzld
    public final String zzd() {
        zzkc zzkcVarZzf = this.zza.zzk().zzf();
        return (zzkcVarZzf == null || zzad.zzc(zzkcVarZzf.zzk())) ? "NA" : (String) Preconditions.checkNotNull(zzkcVarZzf.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzld
    public final byte[] zze(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzj(this.zzb.zzm());
        try {
            zzma.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzgq.zza).ignoreNullValues(true).build().encode(this.zza.zzk()).getBytes("utf-8");
            }
            zzii zziiVarZzk = this.zza.zzk();
            zzbn zzbnVar = new zzbn();
            zzgq.zza.configure(zzbnVar);
            return zzbnVar.zza().zza(zziiVarZzk);
        } catch (UnsupportedEncodingException e2) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e2);
        }
    }
}
