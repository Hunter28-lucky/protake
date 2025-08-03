package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
public final class QueryPurchasesParams {
    private final String zza;

    /* compiled from: com.android.billingclient:billing@@7.0.0 */
    public static class Builder {
        private String zza;

        private Builder() {
            throw null;
        }

        public /* synthetic */ Builder(zzdi zzdiVar) {
        }

        @NonNull
        public QueryPurchasesParams build() {
            if (this.zza != null) {
                return new QueryPurchasesParams(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        @NonNull
        public Builder setProductType(@NonNull String str) {
            this.zza = str;
            return this;
        }
    }

    public /* synthetic */ QueryPurchasesParams(Builder builder, zzdj zzdjVar) {
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
