package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.Nullable;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
final class zzo {
    private final Context zza;
    private final PurchasesUpdatedListener zzb;
    private final zzc zzc;
    private final UserChoiceBillingListener zzd;
    private final zzcc zze;
    private final zzn zzf = new zzn(this, true);
    private final zzn zzg = new zzn(this, false);
    private boolean zzh;

    public zzo(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzck zzckVar, zzc zzcVar, UserChoiceBillingListener userChoiceBillingListener, zzcc zzccVar) {
        this.zza = context;
        this.zzb = purchasesUpdatedListener;
        this.zzc = zzcVar;
        this.zzd = userChoiceBillingListener;
        this.zze = zzccVar;
    }

    @Nullable
    public final PurchasesUpdatedListener zzd() {
        return this.zzb;
    }

    public final void zzf() {
        this.zzf.zzc(this.zza);
        this.zzg.zzc(this.zza);
    }

    public final void zzg(boolean z) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.zzh = z;
        this.zzg.zza(this.zza, intentFilter2);
        if (this.zzh) {
            this.zzf.zzb(this.zza, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
        } else {
            this.zzf.zza(this.zza, intentFilter);
        }
    }
}
