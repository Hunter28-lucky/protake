package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzlx {

    @Nullable
    private static zzlw zza;

    public static synchronized zzlm zza(zzlf zzlfVar) {
        if (zza == null) {
            zza = new zzlw(null);
        }
        return (zzlm) zza.get(zzlfVar);
    }

    public static synchronized zzlm zzb(String str) {
        return zza(zzlf.zzd("common").zzd());
    }
}
