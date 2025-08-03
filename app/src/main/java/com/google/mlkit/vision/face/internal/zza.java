package com.google.mlkit.vision.face.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_face.zzka;
import com.google.android.gms.internal.mlkit_vision_face.zzmz;
import com.google.android.gms.internal.mlkit_vision_face.zznn;
import com.google.android.gms.internal.mlkit_vision_face.zznr;
import com.google.android.gms.internal.mlkit_vision_face.zznt;
import com.google.android.gms.internal.mlkit_vision_face.zznv;
import com.google.android.gms.internal.mlkit_vision_face.zznx;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
final class zza implements zzb {
    private final Context zza;
    private final FaceDetectorOptions zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzmz zzf;

    @Nullable
    private zznv zzg;

    @Nullable
    private zznv zzh;

    public zza(Context context, FaceDetectorOptions faceDetectorOptions, zzmz zzmzVar) {
        this.zza = context;
        this.zzb = faceDetectorOptions;
        this.zzf = zzmzVar;
    }

    public static boolean zzc(Context context) {
        return DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) > 0;
    }

    private final void zzf() throws RemoteException, DynamiteModule.LoadingException {
        if (this.zzb.zzc() != 2) {
            if (this.zzh == null) {
                this.zzh = zzg(new zznr(this.zzb.zze(), this.zzb.zzd(), this.zzb.zzb(), 1, this.zzb.zzg(), this.zzb.zza()));
                return;
            }
            return;
        }
        if (this.zzg == null) {
            this.zzg = zzg(new zznr(this.zzb.zze(), 1, 1, 2, false, this.zzb.zza()));
        }
        if ((this.zzb.zzd() == 2 || this.zzb.zzb() == 2 || this.zzb.zze() == 2) && this.zzh == null) {
            this.zzh = zzg(new zznr(this.zzb.zze(), this.zzb.zzd(), this.zzb.zzb(), 1, this.zzb.zzg(), this.zzb.zza()));
        }
    }

    private final zznv zzg(zznr zznrVar) throws RemoteException, DynamiteModule.LoadingException {
        return this.zzd ? zze(DynamiteModule.PREFER_LOCAL, ModuleDescriptor.MODULE_ID, "com.google.mlkit.vision.face.bundled.internal.ThickFaceDetectorCreator", zznrVar) : zze(DynamiteModule.PREFER_REMOTE, "com.google.android.gms.vision.face", "com.google.android.gms.vision.face.mlkit.FaceDetectorCreator", zznrVar);
    }

    private static List zzh(zznv zznvVar, InputImage inputImage) throws MlKitException {
        if (inputImage.getFormat() == -1) {
            inputImage = InputImage.fromByteBuffer(ImageConvertUtils.getInstance().convertToNv21Buffer(inputImage, false), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees(), 17);
        }
        try {
            List listZzd = zznvVar.zzd(ImageUtils.getInstance().getImageDataWrapper(inputImage), new zznn(inputImage.getFormat(), inputImage.getWidth(), inputImage.getHeight(), CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees()), SystemClock.elapsedRealtime()));
            ArrayList arrayList = new ArrayList();
            Iterator it = listZzd.iterator();
            while (it.hasNext()) {
                arrayList.add(new Face((zznt) it.next(), inputImage.getCoordinatesMatrix()));
            }
            return arrayList;
        } catch (RemoteException e2) {
            throw new MlKitException("Failed to run face detector.", 13, e2);
        }
    }

    @Override // com.google.mlkit.vision.face.internal.zzb
    @WorkerThread
    public final Pair zza(InputImage inputImage) throws MlKitException {
        List listZzh;
        if (this.zzh == null && this.zzg == null) {
            zzd();
        }
        if (!this.zzc) {
            try {
                zznv zznvVar = this.zzh;
                if (zznvVar != null) {
                    zznvVar.zze();
                }
                zznv zznvVar2 = this.zzg;
                if (zznvVar2 != null) {
                    zznvVar2.zze();
                }
                this.zzc = true;
            } catch (RemoteException e2) {
                throw new MlKitException("Failed to init face detector.", 13, e2);
            }
        }
        zznv zznvVar3 = this.zzh;
        List listZzh2 = null;
        if (zznvVar3 != null) {
            listZzh = zzh(zznvVar3, inputImage);
            if (!this.zzb.zzg()) {
                zzh.zzd(listZzh);
            }
        } else {
            listZzh = null;
        }
        zznv zznvVar4 = this.zzg;
        if (zznvVar4 != null) {
            listZzh2 = zzh(zznvVar4, inputImage);
            zzh.zzd(listZzh2);
        }
        return new Pair(listZzh, listZzh2);
    }

    @Override // com.google.mlkit.vision.face.internal.zzb
    @WorkerThread
    public final void zzb() {
        try {
            zznv zznvVar = this.zzh;
            if (zznvVar != null) {
                zznvVar.zzf();
                this.zzh = null;
            }
            zznv zznvVar2 = this.zzg;
            if (zznvVar2 != null) {
                zznvVar2.zzf();
                this.zzg = null;
            }
        } catch (RemoteException e2) {
            Log.e("DecoupledFaceDelegate", "Failed to release face detector.", e2);
        }
        this.zzc = false;
    }

    @Override // com.google.mlkit.vision.face.internal.zzb
    @WorkerThread
    public final boolean zzd() throws MlKitException {
        if (this.zzh != null || this.zzg != null) {
            return this.zzd;
        }
        if (DynamiteModule.getLocalVersion(this.zza, ModuleDescriptor.MODULE_ID) > 0) {
            this.zzd = true;
            try {
                zzf();
            } catch (RemoteException e2) {
                throw new MlKitException("Failed to create thick face detector.", 13, e2);
            } catch (DynamiteModule.LoadingException e3) {
                throw new MlKitException("Failed to load the bundled face module.", 13, e3);
            }
        } else {
            this.zzd = false;
            try {
                zzf();
            } catch (RemoteException e4) {
                zzj.zzc(this.zzf, this.zzd, zzka.OPTIONAL_MODULE_INIT_ERROR);
                throw new MlKitException("Failed to create thin face detector.", 13, e4);
            } catch (DynamiteModule.LoadingException unused) {
                if (!this.zze) {
                    OptionalModuleUtils.requestDownload(this.zza, OptionalModuleUtils.FACE);
                    this.zze = true;
                }
                zzj.zzc(this.zzf, this.zzd, zzka.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new MlKitException("Waiting for the face module to be downloaded. Please wait.", 14);
            }
        }
        zzj.zzc(this.zzf, this.zzd, zzka.NO_ERROR);
        return this.zzd;
    }

    @VisibleForTesting
    public final zznv zze(DynamiteModule.VersionPolicy versionPolicy, String str, String str2, zznr zznrVar) throws RemoteException, DynamiteModule.LoadingException {
        return zznx.zza(DynamiteModule.load(this.zza, versionPolicy, str).instantiate(str2)).zzd(ObjectWrapper.wrap(this.zza), zznrVar);
    }
}
