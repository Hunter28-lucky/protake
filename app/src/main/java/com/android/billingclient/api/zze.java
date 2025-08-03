package com.android.billingclient.api;

import androidx.annotation.Nullable;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
public final class zze {
    private final String zza;
    private final String zzb;

    @Nullable
    private final String zzc;

    public /* synthetic */ zze(JSONObject jSONObject, zzd zzdVar) {
        this.zza = jSONObject.optString("productId");
        this.zzb = jSONObject.optString("productType");
        String strOptString = jSONObject.optString("offerToken");
        this.zzc = true == strOptString.isEmpty() ? null : strOptString;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zzeVar = (zze) obj;
        return this.zza.equals(zzeVar.zza) && this.zzb.equals(zzeVar.zzb) && Objects.equals(this.zzc, zzeVar.zzc);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb, this.zzc);
    }

    public final String toString() {
        return String.format("{id: %s, type: %s, offer token: %s}", this.zza, this.zzb, this.zzc);
    }
}
