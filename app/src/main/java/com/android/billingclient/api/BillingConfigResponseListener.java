package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
@zzi
/* loaded from: classes.dex */
public interface BillingConfigResponseListener {
    void onBillingConfigResponse(@NonNull BillingResult billingResult, @Nullable BillingConfig billingConfig);
}
