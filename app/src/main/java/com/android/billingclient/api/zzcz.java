package com.android.billingclient.api;

import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes.dex */
public final class zzcz {

    @Nullable
    private final List zza;
    private final BillingResult zzb;

    public zzcz(BillingResult billingResult, @Nullable List list) {
        this.zza = list;
        this.zzb = billingResult;
    }

    public final BillingResult zza() {
        return this.zzb;
    }

    @Nullable
    public final List zzb() {
        return this.zza;
    }
}
