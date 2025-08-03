package com.android.billingclient.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
@zzg
@KeepForSdk
/* loaded from: classes.dex */
public final class AlternativeBillingOnlyReportingDetails {
    private final String externalTransactionToken;

    public AlternativeBillingOnlyReportingDetails(String str) throws JSONException {
        this.externalTransactionToken = new JSONObject(str).optString("externalTransactionToken");
    }

    @NonNull
    public String getExternalTransactionToken() {
        return this.externalTransactionToken;
    }
}
