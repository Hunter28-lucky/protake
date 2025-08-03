package com.google.mlkit.vision.face.internal;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.mlkit_vision_face.zzjz;
import com.google.android.gms.internal.mlkit_vision_face.zzkb;
import com.google.android.gms.internal.mlkit_vision_face.zzkc;
import com.google.android.gms.internal.mlkit_vision_face.zzko;
import com.google.android.gms.internal.mlkit_vision_face.zzmz;
import com.google.android.gms.internal.mlkit_vision_face.zznc;
import com.google.android.gms.internal.mlkit_vision_face.zznk;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public class FaceDetectorImpl extends MobileVisionBase<List<Face>> implements FaceDetector {

    @VisibleForTesting
    public static final FaceDetectorOptions zzb = new FaceDetectorOptions.Builder().build();

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FaceDetectorImpl(zzh zzhVar, ExecutorSelector executorSelector, FaceDetectorOptions faceDetectorOptions, zzd zzdVar) {
        Executor executorToUse = executorSelector.getExecutorToUse(faceDetectorOptions.zzf());
        zzmz zzmzVarZzb = zznk.zzb(zzj.zzb());
        super(zzhVar, executorToUse);
        zzkc zzkcVar = new zzkc();
        zzkcVar.zze(zzj.zzd() ? zzjz.TYPE_THICK : zzjz.TYPE_THIN);
        zzko zzkoVar = new zzko();
        zzkoVar.zze(zzj.zza(faceDetectorOptions));
        zzkcVar.zzg(zzkoVar.zzi());
        zzmzVarZzb.zzg(zznc.zze(zzkcVar, 1), zzkb.ON_DEVICE_FACE_CREATE);
    }

    @Override // com.google.mlkit.vision.interfaces.Detector
    public final int getDetectorType() {
        return 2;
    }

    @Override // com.google.mlkit.vision.face.FaceDetector
    @NonNull
    public final Task<List<Face>> process(@NonNull MlImage mlImage) {
        return super.processBase(mlImage);
    }

    @Override // com.google.mlkit.vision.face.FaceDetector
    @NonNull
    public final Task<List<Face>> process(@NonNull InputImage inputImage) {
        return super.processBase(inputImage);
    }
}
