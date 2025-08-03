package com.android.billingclient.api;

import androidx.annotation.Nullable;
import com.android.billingclient.api.ProductDetails;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
public final class zzcv {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;

    @Nullable
    private final ProductDetails.PricingPhase zzf;

    public zzcv(JSONObject jSONObject) throws JSONException {
        this.zza = jSONObject.getString("productId");
        this.zzb = jSONObject.optString("title");
        this.zzc = jSONObject.optString("name");
        this.zzd = jSONObject.optString("description");
        this.zze = jSONObject.optString("basePlanId");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("pricingPhase");
        this.zzf = jSONObjectOptJSONObject == null ? null : new ProductDetails.PricingPhase(jSONObjectOptJSONObject);
    }
}
