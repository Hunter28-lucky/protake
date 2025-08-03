package com.google.mlkit.vision.face.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.mlkit_vision_face.zzmz;
import com.google.android.gms.internal.mlkit_vision_face.zznk;
import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.face.FaceDetectorOptions;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zze extends LazyInstanceMap {
    private final MlKitContext zza;

    public zze(MlKitContext mlKitContext) {
        this.zza = mlKitContext;
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        FaceDetectorOptions faceDetectorOptions = (FaceDetectorOptions) obj;
        Context applicationContext = this.zza.getApplicationContext();
        zzmz zzmzVarZzb = zznk.zzb(zzj.zzb());
        return new zzh(zznk.zzb(zzj.zzb()), faceDetectorOptions, (zza.zzc(applicationContext) || GoogleApiAvailabilityLight.getInstance().getApkVersion(applicationContext) >= 204500000) ? new zza(applicationContext, faceDetectorOptions, zzmzVarZzb) : new zzm(applicationContext, faceDetectorOptions, zzmzVarZzb));
    }
}
