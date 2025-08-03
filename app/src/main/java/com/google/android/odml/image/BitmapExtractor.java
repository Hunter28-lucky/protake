package com.google.android.odml.image;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: com.google.android.odml:image@@1.0.0-beta1 */
/* loaded from: classes2.dex */
public final class BitmapExtractor {
    private BitmapExtractor() {
    }

    @NonNull
    public static Bitmap extract(@NonNull MlImage mlImage) {
        zzg zzgVarZza = mlImage.zza();
        if (zzgVarZza.zzb().getStorageType() == 1) {
            return ((zze) zzgVarZza).zza();
        }
        throw new IllegalArgumentException("Extracting Bitmap from an MlImage created by objects other than Bitmap is not supported");
    }
}
