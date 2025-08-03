package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
final class zzbg extends com.google.android.gms.internal.play_billing.zze {
    public final ExternalOfferReportingDetailsListener zza;
    public final zzcc zzb;
    public final int zzc;

    public /* synthetic */ zzbg(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, zzcc zzccVar, int i, zzbf zzbfVar) {
        this.zza = externalOfferReportingDetailsListener;
        this.zzb = zzccVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzf
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            zzcc zzccVar = this.zzb;
            BillingResult billingResult = zzce.zzj;
            zzccVar.zzb(zzcb.zza(95, 24, billingResult), this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(billingResult, null);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle, "BillingClient");
        BillingResult billingResultZza = zzce.zza(iZzb, com.google.android.gms.internal.play_billing.zzb.zzg(bundle, "BillingClient"));
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "createExternalOfferReportingDetailsAsync() failed. Response code: " + iZzb);
            this.zzb.zzb(zzcb.zza(23, 24, billingResultZza), this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(billingResultZza, null);
            return;
        }
        try {
            this.zza.onExternalOfferReportingDetailsResponse(billingResultZza, new ExternalOfferReportingDetails(bundle.getString("CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS")));
        } catch (JSONException e2) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingClient", "Error when parsing invalid external offer reporting details. \n Exception: ", e2);
            zzcc zzccVar2 = this.zzb;
            BillingResult billingResult2 = zzce.zzj;
            zzccVar2.zzb(zzcb.zza(104, 24, billingResult2), this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(billingResult2, null);
        }
    }
}
