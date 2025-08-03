package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.annotation.Nullable;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzgj;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
final class zzay extends ResultReceiver {
    public final /* synthetic */ ExternalOfferInformationDialogListener zza;
    public final /* synthetic */ BillingClientImpl zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzay(BillingClientImpl billingClientImpl, Handler handler, ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        super(handler);
        this.zza = externalOfferInformationDialogListener;
        this.zzb = billingClientImpl;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, @Nullable Bundle bundle) {
        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
        builderNewBuilder.setResponseCode(i);
        if (i != 0) {
            if (bundle == null) {
                BillingClientImpl billingClientImpl = this.zzb;
                BillingResult billingResult = zzce.zzj;
                billingClientImpl.zzap(zzcb.zza(97, 25, billingResult));
                this.zza.onExternalOfferInformationDialogResponse(billingResult);
                return;
            }
            builderNewBuilder.setDebugMessage(com.google.android.gms.internal.play_billing.zzb.zzg(bundle, "BillingClient"));
            int i2 = bundle.getInt("INTERNAL_LOG_ERROR_REASON");
            this.zzb.zzap(zzcb.zzb(i2 != 0 ? zzgj.zza(i2) : 23, 25, builderNewBuilder.build(), bundle.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS")));
        }
        this.zza.onExternalOfferInformationDialogResponse(builderNewBuilder.build());
    }
}
