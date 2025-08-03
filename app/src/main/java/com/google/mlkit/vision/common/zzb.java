package com.google.mlkit.vision.common;

import android.media.Image;

/* compiled from: com.google.mlkit:vision-common@@17.1.0 */
/* loaded from: classes2.dex */
final class zzb {
    private final Image zza;

    public zzb(Image image) {
        this.zza = image;
    }

    public final Image zza() {
        return this.zza;
    }

    public final Image.Plane[] zzb() {
        return this.zza.getPlanes();
    }
}
