package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
@zzk
/* loaded from: classes.dex */
public final class PendingPurchasesParams {
    private final boolean enableOneTimeProducts;
    private final boolean enablePrepaidPlans;

    /* compiled from: com.android.billingclient:billing@@7.0.0 */
    @zzk
    public static final class Builder {
        private boolean enableOneTimeProducts;
        private boolean enablePrepaidPlans;

        private Builder() {
        }

        @NonNull
        public PendingPurchasesParams build() {
            if (this.enableOneTimeProducts) {
                return new PendingPurchasesParams(true, this.enablePrepaidPlans);
            }
            throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
        }

        @NonNull
        public Builder enableOneTimeProducts() {
            this.enableOneTimeProducts = true;
            return this;
        }

        @NonNull
        public Builder enablePrepaidPlans() {
            this.enablePrepaidPlans = true;
            return this;
        }
    }

    private PendingPurchasesParams(boolean z, boolean z2) {
        this.enableOneTimeProducts = z;
        this.enablePrepaidPlans = z2;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean isEnabledForOneTimeProducts() {
        return this.enableOneTimeProducts;
    }

    public boolean isEnabledForPrepaidPlans() {
        return this.enablePrepaidPlans;
    }
}
