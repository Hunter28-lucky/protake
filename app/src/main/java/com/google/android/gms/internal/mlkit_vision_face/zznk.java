package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zznk {

    @Nullable
    private static zznj zza;

    public static synchronized zzmz zza(zzmq zzmqVar) {
        if (zza == null) {
            zza = new zznj(null);
        }
        return (zzmz) zza.get(zzmqVar);
    }

    public static synchronized zzmz zzb(String str) {
        return zza(zzmq.zzd(str).zzd());
    }
}
