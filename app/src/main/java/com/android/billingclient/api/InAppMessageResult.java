package com.android.billingclient.api;

import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
public final class InAppMessageResult {
    private final int zza;

    @Nullable
    private final String zzb;

    /* compiled from: com.android.billingclient:billing@@7.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InAppMessageResponseCode {
        public static final int NO_ACTION_NEEDED = 0;
        public static final int SUBSCRIPTION_STATUS_UPDATED = 1;
    }

    public InAppMessageResult(int i, @Nullable String str) {
        this.zza = i;
        this.zzb = str;
    }

    @Nullable
    public String getPurchaseToken() {
        return this.zzb;
    }

    public int getResponseCode() {
        return this.zza;
    }
}
