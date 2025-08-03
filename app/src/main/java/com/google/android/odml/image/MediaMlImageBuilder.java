package com.google.android.odml.image;

import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.odml:image@@1.0.0-beta1 */
@RequiresApi(19)
/* loaded from: classes2.dex */
public class MediaMlImageBuilder {
    private final Image zza;
    private int zzb = 0;
    private Rect zzc;

    public MediaMlImageBuilder(@NonNull Image image) {
        this.zza = image;
        this.zzc = new Rect(0, 0, image.getWidth(), image.getHeight());
    }

    @NonNull
    public MlImage build() {
        return new MlImage(new zzi(this.zza), this.zzb, this.zzc, 0L, this.zza.getWidth(), this.zza.getHeight());
    }

    @NonNull
    public MediaMlImageBuilder setRotation(int i) {
        MlImage.zzc(i);
        this.zzb = i;
        return this;
    }
}
