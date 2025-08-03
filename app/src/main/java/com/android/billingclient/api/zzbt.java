package com.android.billingclient.api;

import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
final class zzbt {
    private final List zza;
    private final BillingResult zzb;

    public zzbt(BillingResult billingResult, @Nullable List list) {
        this.zza = list;
        this.zzb = billingResult;
    }

    public final BillingResult zza() {
        return this.zzb;
    }

    public final List zzb() {
        return this.zza;
    }
}
