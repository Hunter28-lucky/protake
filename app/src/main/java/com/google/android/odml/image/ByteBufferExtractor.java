package com.google.android.odml.image;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.odml:image@@1.0.0-beta1 */
/* loaded from: classes2.dex */
public class ByteBufferExtractor {
    private ByteBufferExtractor() {
    }

    @NonNull
    public static ByteBuffer extract(@NonNull MlImage mlImage) {
        zzg zzgVarZza = mlImage.zza();
        if (zzgVarZza.zzb().getStorageType() == 2) {
            return ((zzf) zzgVarZza).zza().asReadOnlyBuffer();
        }
        throw new IllegalArgumentException("Extract ByteBuffer from an MlImage created by objects other than Bytebuffer is not supported");
    }
}
