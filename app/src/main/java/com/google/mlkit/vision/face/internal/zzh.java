package com.google.mlkit.vision.face.internal;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_face.zzdi;
import com.google.android.gms.internal.mlkit_vision_face.zzdj;
import com.google.android.gms.internal.mlkit_vision_face.zzdl;
import com.google.android.gms.internal.mlkit_vision_face.zzjd;
import com.google.android.gms.internal.mlkit_vision_face.zzjm;
import com.google.android.gms.internal.mlkit_vision_face.zzjn;
import com.google.android.gms.internal.mlkit_vision_face.zzjr;
import com.google.android.gms.internal.mlkit_vision_face.zzjz;
import com.google.android.gms.internal.mlkit_vision_face.zzka;
import com.google.android.gms.internal.mlkit_vision_face.zzkb;
import com.google.android.gms.internal.mlkit_vision_face.zzkc;
import com.google.android.gms.internal.mlkit_vision_face.zzko;
import com.google.android.gms.internal.mlkit_vision_face.zzkq;
import com.google.android.gms.internal.mlkit_vision_face.zzmx;
import com.google.android.gms.internal.mlkit_vision_face.zzmz;
import com.google.android.gms.internal.mlkit_vision_face.zznb;
import com.google.android.gms.internal.mlkit_vision_face.zznc;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.BitmapInStreamingChecker;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zzh extends MLTask {

    @VisibleForTesting
    public static final AtomicBoolean zza = new AtomicBoolean(true);
    private static final ImageUtils zzb = ImageUtils.getInstance();
    private final FaceDetectorOptions zzc;
    private final zzmz zzd;
    private final zznb zze;
    private final zzb zzf;
    private boolean zzg;
    private final BitmapInStreamingChecker zzh = new BitmapInStreamingChecker();

    @VisibleForTesting
    public zzh(@NonNull zzmz zzmzVar, @NonNull FaceDetectorOptions faceDetectorOptions, @NonNull zzb zzbVar) {
        Preconditions.checkNotNull(faceDetectorOptions, "FaceDetectorOptions can not be null");
        this.zzc = faceDetectorOptions;
        this.zzd = zzmzVar;
        this.zzf = zzbVar;
        this.zze = zznb.zza(MlKitContext.getInstance().getApplicationContext());
    }

    public static void zzd(@NonNull List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Face) it.next()).zzc(-1);
        }
    }

    @WorkerThread
    private final synchronized void zzg(final zzka zzkaVar, long j, final InputImage inputImage, final int i, final int i2) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zzd.zzc(new zzmx() { // from class: com.google.mlkit.vision.face.internal.zzg
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzmx
            public final zznc zza() {
                return this.zza.zze(jElapsedRealtime, zzkaVar, i, i2, inputImage);
            }
        }, zzkb.ON_DEVICE_FACE_DETECT);
        zzdj zzdjVar = new zzdj();
        zzdjVar.zzc(zzkaVar);
        zzdjVar.zzd(Boolean.valueOf(zza.get()));
        zzdjVar.zza(Integer.valueOf(i));
        zzdjVar.zze(Integer.valueOf(i2));
        zzdjVar.zzb(zzj.zza(this.zzc));
        final zzdl zzdlVarZzf = zzdjVar.zzf();
        final zzf zzfVar = new zzf(this);
        final zzmz zzmzVar = this.zzd;
        final zzkb zzkbVar = zzkb.AGGREGATED_ON_DEVICE_FACE_DETECTION;
        final byte[] bArr = null;
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(zzkbVar, zzdlVarZzf, jElapsedRealtime, zzfVar, bArr) { // from class: com.google.android.gms.internal.mlkit_vision_face.zzmt
            public final /* synthetic */ zzkb zzb;
            public final /* synthetic */ Object zzc;
            public final /* synthetic */ long zzd;
            public final /* synthetic */ com.google.mlkit.vision.face.internal.zzf zze;

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzf(this.zzb, this.zzc, this.zzd, this.zze);
            }
        });
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.zze.zzc(true != this.zzg ? 24303 : 24304, zzkaVar.zza(), jCurrentTimeMillis - jElapsedRealtime, jCurrentTimeMillis);
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    @WorkerThread
    public final synchronized void load() throws MlKitException {
        this.zzg = this.zzf.zzd();
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    @WorkerThread
    public final synchronized void release() {
        this.zzf.zzb();
        zza.set(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010a A[Catch: MlKitException -> 0x0129, all -> 0x0148, TryCatch #1 {, blocks: (B:4:0x0005, B:5:0x000e, B:9:0x0021, B:10:0x002a, B:12:0x002d, B:40:0x0104, B:47:0x0118, B:46:0x0113, B:43:0x010a, B:15:0x003a, B:16:0x0041, B:17:0x004a, B:19:0x0050, B:20:0x005b, B:22:0x0061, B:24:0x006d, B:26:0x0073, B:28:0x0081, B:30:0x00ab, B:32:0x00cf, B:34:0x00de, B:54:0x012e, B:56:0x0136, B:58:0x013b, B:59:0x0147, B:57:0x0139, B:37:0x00f1, B:39:0x00fc), top: B:64:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0113 A[Catch: MlKitException -> 0x0129, all -> 0x0148, TryCatch #1 {, blocks: (B:4:0x0005, B:5:0x000e, B:9:0x0021, B:10:0x002a, B:12:0x002d, B:40:0x0104, B:47:0x0118, B:46:0x0113, B:43:0x010a, B:15:0x003a, B:16:0x0041, B:17:0x004a, B:19:0x0050, B:20:0x005b, B:22:0x0061, B:24:0x006d, B:26:0x0073, B:28:0x0081, B:30:0x00ab, B:32:0x00cf, B:34:0x00de, B:54:0x012e, B:56:0x0136, B:58:0x013b, B:59:0x0147, B:57:0x0139, B:37:0x00f1, B:39:0x00fc), top: B:64:0x0005 }] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.List] */
    @Override // com.google.mlkit.common.sdkinternal.MLTask
    @androidx.annotation.WorkerThread
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List run(@androidx.annotation.NonNull com.google.mlkit.vision.common.InputImage r21) throws com.google.mlkit.common.MlKitException {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.face.internal.zzh.run(com.google.mlkit.vision.common.InputImage):java.util.List");
    }

    public final /* synthetic */ zznc zze(long j, zzka zzkaVar, int i, int i2, InputImage inputImage) {
        zzko zzkoVar = new zzko();
        zzjr zzjrVar = new zzjr();
        zzjrVar.zzc(Long.valueOf(j));
        zzjrVar.zzd(zzkaVar);
        zzjrVar.zze(Boolean.valueOf(zza.get()));
        Boolean bool = Boolean.TRUE;
        zzjrVar.zza(bool);
        zzjrVar.zzb(bool);
        zzkoVar.zzg(zzjrVar.zzf());
        zzkoVar.zze(zzj.zza(this.zzc));
        zzkoVar.zzd(Integer.valueOf(i));
        zzkoVar.zzh(Integer.valueOf(i2));
        ImageUtils imageUtils = zzb;
        int mobileVisionImageFormat = imageUtils.getMobileVisionImageFormat(inputImage);
        int mobileVisionImageSize = imageUtils.getMobileVisionImageSize(inputImage);
        zzjm zzjmVar = new zzjm();
        zzjmVar.zza(mobileVisionImageFormat != -1 ? mobileVisionImageFormat != 35 ? mobileVisionImageFormat != 842094169 ? mobileVisionImageFormat != 16 ? mobileVisionImageFormat != 17 ? zzjn.UNKNOWN_FORMAT : zzjn.NV21 : zzjn.NV16 : zzjn.YV12 : zzjn.YUV_420_888 : zzjn.BITMAP);
        zzjmVar.zzb(Integer.valueOf(mobileVisionImageSize));
        zzkoVar.zzf(zzjmVar.zzd());
        zzkq zzkqVarZzi = zzkoVar.zzi();
        zzkc zzkcVar = new zzkc();
        zzkcVar.zze(this.zzg ? zzjz.TYPE_THICK : zzjz.TYPE_THIN);
        zzkcVar.zzg(zzkqVarZzi);
        return zznc.zzd(zzkcVar);
    }

    public final /* synthetic */ zznc zzf(zzdl zzdlVar, int i, zzjd zzjdVar) {
        zzkc zzkcVar = new zzkc();
        zzkcVar.zze(this.zzg ? zzjz.TYPE_THICK : zzjz.TYPE_THIN);
        zzdi zzdiVar = new zzdi();
        zzdiVar.zza(Integer.valueOf(i));
        zzdiVar.zzc(zzdlVar);
        zzdiVar.zzb(zzjdVar);
        zzkcVar.zzd(zzdiVar.zze());
        return zznc.zzd(zzkcVar);
    }
}
