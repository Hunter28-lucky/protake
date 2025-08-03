package com.android.billingclient.api;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
@zzi
/* loaded from: classes.dex */
public final class BillingConfig {
    private final String countryCode;
    private final String jsonString;
    private final JSONObject parsedJson;

    public BillingConfig(String str) throws JSONException {
        this.jsonString = str;
        JSONObject jSONObject = new JSONObject(str);
        this.parsedJson = jSONObject;
        this.countryCode = jSONObject.optString("countryCode");
    }

    @NonNull
    public String getCountryCode() {
        return this.countryCode;
    }
}
