package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
final class zzav implements Callable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ PurchaseHistoryResponseListener zzb;
    public final /* synthetic */ BillingClientImpl zzc;

    public zzav(BillingClientImpl billingClientImpl, String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        this.zza = str;
        this.zzb = purchaseHistoryResponseListener;
        this.zzc = billingClientImpl;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbt zzbtVarZzg = BillingClientImpl.zzg(this.zzc, this.zza);
        this.zzb.onPurchaseHistoryResponse(zzbtVarZzg.zza(), zzbtVarZzg.zzb());
        return null;
    }
}
