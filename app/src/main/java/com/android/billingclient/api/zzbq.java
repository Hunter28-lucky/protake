package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
final class zzbq extends com.google.android.gms.internal.play_billing.zzo {
    public final ExternalOfferAvailabilityListener zza;
    public final zzcc zzb;
    public final int zzc;

    public /* synthetic */ zzbq(ExternalOfferAvailabilityListener externalOfferAvailabilityListener, zzcc zzccVar, int i, zzbp zzbpVar) {
        this.zza = externalOfferAvailabilityListener;
        this.zzb = zzccVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzp
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            zzcc zzccVar = this.zzb;
            BillingResult billingResult = zzce.zzj;
            zzccVar.zzb(zzcb.zza(92, 23, billingResult), this.zzc);
            this.zza.onExternalOfferAvailabilityResponse(billingResult);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle, "BillingClient");
        BillingResult billingResultZza = zzce.zza(iZzb, com.google.android.gms.internal.play_billing.zzb.zzg(bundle, "BillingClient"));
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "isExternalOfferAvailableAsync() failed. Response code: " + iZzb);
            this.zzb.zzb(zzcb.zza(23, 23, billingResultZza), this.zzc);
        }
        this.zza.onExternalOfferAvailabilityResponse(billingResultZza);
    }
}
