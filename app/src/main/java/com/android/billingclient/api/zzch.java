package com.android.billingclient.api;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzgt;
import com.google.android.gms.internal.play_billing.zzgu;
import com.google.android.gms.internal.play_billing.zzhd;
import com.google.android.gms.internal.play_billing.zzhe;
import com.google.android.gms.internal.play_billing.zzhl;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
final class zzch implements zzcc {
    private zzgu zzb;
    private final zzcj zzc;

    public zzch(Context context, zzgu zzguVar) {
        this.zzc = new zzcj(context);
        this.zzb = zzguVar;
    }

    @Override // com.android.billingclient.api.zzcc
    public final void zza(@Nullable zzga zzgaVar) {
        if (zzgaVar == null) {
            return;
        }
        try {
            zzhd zzhdVarZzy = zzhe.zzy();
            zzhdVarZzy.zzn(this.zzb);
            zzhdVarZzy.zzl(zzgaVar);
            this.zzc.zza((zzhe) zzhdVarZzy.zzf());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcc
    public final void zzb(@Nullable zzga zzgaVar, int i) {
        try {
            zzgt zzgtVar = (zzgt) this.zzb.zzi();
            zzgtVar.zzl(i);
            this.zzb = (zzgu) zzgtVar.zzf();
            zza(zzgaVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcc
    public final void zzc(@Nullable zzge zzgeVar) {
        if (zzgeVar == null) {
            return;
        }
        try {
            zzhd zzhdVarZzy = zzhe.zzy();
            zzhdVarZzy.zzn(this.zzb);
            zzhdVarZzy.zzm(zzgeVar);
            this.zzc.zza((zzhe) zzhdVarZzy.zzf());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcc
    public final void zzd(@Nullable zzge zzgeVar, int i) {
        try {
            zzgt zzgtVar = (zzgt) this.zzb.zzi();
            zzgtVar.zzl(i);
            this.zzb = (zzgu) zzgtVar.zzf();
            zzc(zzgeVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzcc
    public final void zze(@Nullable zzhl zzhlVar) {
        if (zzhlVar == null) {
            return;
        }
        try {
            zzhd zzhdVarZzy = zzhe.zzy();
            zzhdVarZzy.zzn(this.zzb);
            zzhdVarZzy.zzo(zzhlVar);
            this.zzc.zza((zzhe) zzhdVarZzy.zzf());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }
}
