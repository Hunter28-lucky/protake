package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
final class zzau implements Callable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ PurchasesResponseListener zzb;
    public final /* synthetic */ BillingClientImpl zzc;

    public zzau(BillingClientImpl billingClientImpl, String str, PurchasesResponseListener purchasesResponseListener) {
        this.zza = str;
        this.zzb = purchasesResponseListener;
        this.zzc = billingClientImpl;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzcz zzczVarZzag = BillingClientImpl.zzag(this.zzc, this.zza, 9);
        if (zzczVarZzag.zzb() != null) {
            this.zzb.onQueryPurchasesResponse(zzczVarZzag.zza(), zzczVarZzag.zzb());
            return null;
        }
        this.zzb.onQueryPurchasesResponse(zzczVarZzag.zza(), com.google.android.gms.internal.play_billing.zzai.zzk());
        return null;
    }
}
