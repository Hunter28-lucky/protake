package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.ObjectEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zzcz {
    private final Map zza;
    private final Map zzb;
    private final ObjectEncoder zzc;

    public zzcz(Map map, Map map2, ObjectEncoder objectEncoder) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = objectEncoder;
    }

    @NonNull
    public final byte[] zza(@NonNull Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new zzcw(byteArrayOutputStream, this.zza, this.zzb, this.zzc).zzf(obj);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
