package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zznl {

    @Nullable
    private static zznl zza;

    private zznl() {
    }

    public static synchronized zznl zza() {
        if (zza == null) {
            zza = new zznl();
        }
        return zza;
    }
}
