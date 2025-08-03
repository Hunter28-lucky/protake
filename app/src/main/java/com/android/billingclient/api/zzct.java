package com.android.billingclient.api;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
public final class zzct {
    private final String zza;

    @Nullable
    private final String zzb;

    public zzct(JSONObject jSONObject) throws JSONException {
        this.zza = jSONObject.getString("rentalPeriod");
        String strOptString = jSONObject.optString("rentalExpirationPeriod");
        this.zzb = true == strOptString.isEmpty() ? null : strOptString;
    }
}
