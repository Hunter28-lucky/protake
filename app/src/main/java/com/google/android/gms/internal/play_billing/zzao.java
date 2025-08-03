package com.google.android.gms.internal.play_billing;

import java.util.Objects;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes2.dex */
final class zzao extends zzai {
    public static final zzai zza = new zzao(new Object[0], 0);
    public final transient Object[] zzb;
    private final transient int zzc;

    public zzao(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzaa.zza(i, this.zzc, "index");
        Object obj = this.zzb[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzai, com.google.android.gms.internal.play_billing.zzaf
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    public final Object[] zzg() {
        return this.zzb;
    }
}
