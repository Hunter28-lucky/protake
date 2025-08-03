package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
public final class QueryPurchaseHistoryParams {
    private final String zza;

    /* compiled from: com.android.billingclient:billing@@7.0.0 */
    public static class Builder {
        private String zza;

        private Builder() {
            throw null;
        }

        public /* synthetic */ Builder(zzdg zzdgVar) {
        }

        @NonNull
        public QueryPurchaseHistoryParams build() {
            if (this.zza != null) {
                return new QueryPurchaseHistoryParams(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        @NonNull
        public Builder setProductType(@NonNull String str) {
            this.zza = str;
            return this;
        }
    }

    public /* synthetic */ QueryPurchaseHistoryParams(Builder builder, zzdh zzdhVar) {
        this.zza = builder.zza;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder(null);
    }

    @NonNull
    public final String zza() {
        return this.zza;
    }
}
