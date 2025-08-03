package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzma {

    @Nullable
    private static zzma zza;

    private zzma() {
    }

    public static synchronized zzma zza() {
        if (zza == null) {
            zza = new zzma();
        }
        return zza;
    }

    public static void zzb() {
        zzlz.zza();
    }
}
