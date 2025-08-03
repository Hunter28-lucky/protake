package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
public interface PurchasesResponseListener {
    void onQueryPurchasesResponse(@NonNull BillingResult billingResult, @NonNull List<Purchase> list);
}
