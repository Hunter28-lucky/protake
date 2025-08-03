package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
@zzh
/* loaded from: classes.dex */
public interface ExternalOfferReportingDetailsListener {
    void onExternalOfferReportingDetailsResponse(@NonNull BillingResult billingResult, @Nullable ExternalOfferReportingDetails externalOfferReportingDetails);
}
