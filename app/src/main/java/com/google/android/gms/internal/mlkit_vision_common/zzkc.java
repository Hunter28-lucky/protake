package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.Nullable;

/* compiled from: com.google.mlkit:vision-common@@17.1.0 */
/* loaded from: classes2.dex */
public final class zzkc {

    @Nullable
    private static zzkb zza;

    public static synchronized zzjt zza(zzjn zzjnVar) {
        if (zza == null) {
            zza = new zzkb(null);
        }
        return (zzjt) zza.get(zzjnVar);
    }

    public static synchronized zzjt zzb(String str) {
        return zza(zzjn.zzd("vision-common").zzd());
    }
}
