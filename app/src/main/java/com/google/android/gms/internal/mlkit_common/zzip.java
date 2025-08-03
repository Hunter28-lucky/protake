package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public enum zzip implements zzbh {
    SOURCE_UNKNOWN(0),
    APP_ASSET(1),
    LOCAL(2),
    CLOUD(3),
    SDK_BUILT_IN(4),
    URI(5);

    private final int zzh;

    zzip(int i) {
        this.zzh = i;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzbh
    public final int zza() {
        return this.zzh;
    }
}
