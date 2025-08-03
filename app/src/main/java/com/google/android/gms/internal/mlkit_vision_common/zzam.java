package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.ObjectEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.mlkit:vision-common@@17.1.0 */
/* loaded from: classes2.dex */
public final class zzam {
    private final Map zza;
    private final Map zzb;
    private final ObjectEncoder zzc;

    public zzam(Map map, Map map2, ObjectEncoder objectEncoder) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = objectEncoder;
    }

    @NonNull
    public final byte[] zza(@NonNull Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new zzaj(byteArrayOutputStream, this.zza, this.zzb, this.zzc).zzf(obj);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
