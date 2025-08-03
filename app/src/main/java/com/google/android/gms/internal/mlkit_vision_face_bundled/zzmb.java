package com.google.android.gms.internal.mlkit_vision_face_bundled;

import androidx.annotation.Nullable;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzmb {

    @Nullable
    private static zzmb zza;

    private zzmb() {
    }

    public static synchronized zzmb zza() {
        if (zza == null) {
            zza = new zzmb();
        }
        return zza;
    }
}
