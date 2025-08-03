package com.google.mlkit.vision.face.bundled.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzag;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzah;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzai;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzaj;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzan;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzao;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzaq;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzar;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzd;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzmd;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzmh;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzml;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzo;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzp;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzs;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzt;
import com.google.android.gms.vision.face.FaceDetectorV2Jni;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zza extends zzml {
    private final Context zza;
    private final zzah zzb;
    private final FaceDetectorV2Jni zzc;
    private long zzd = -1;

    public zza(Context context, zzmh zzmhVar, FaceDetectorV2Jni faceDetectorV2Jni) {
        this.zza = context;
        boolean z = false;
        boolean z2 = zzmhVar.zzc() == 2;
        zzaq zzaqVarZza = zzar.zza();
        zzaqVarZza.zzb("models_bundled");
        zzar zzarVar = (zzar) zzaqVarZza.zzq();
        int iZze = zzmhVar.zze();
        zzai zzaiVarZza = zzaj.zza();
        zzaq zzaqVarZza2 = zzar.zza();
        zzaqVarZza2.zzb("models_bundled");
        zzaqVarZza2.zza(iZze == 2 ? "fssd_medium_8bit_v5.tflite" : "fssd_25_8bit_v2.tflite");
        zzaiVarZza.zzc((zzar) zzaqVarZza2.zzq());
        zzaq zzaqVarZza3 = zzar.zza();
        zzaqVarZza3.zzb("models_bundled");
        zzaqVarZza3.zza(iZze == 2 ? "fssd_medium_8bit_gray_v5.tflite" : "fssd_25_8bit_gray_v2.tflite");
        zzaiVarZza.zzb((zzar) zzaqVarZza3.zzq());
        zzaq zzaqVarZza4 = zzar.zza();
        zzaqVarZza4.zzb("models_bundled");
        zzaqVarZza4.zza(iZze == 2 ? "fssd_anchors_v5.pb" : "fssd_anchors_v2.pb");
        zzaiVarZza.zza((zzar) zzaqVarZza4.zzq());
        zzaiVarZza.zzd(zzarVar);
        zzaj zzajVar = (zzaj) zzaiVarZza.zzq();
        zzag zzagVarZza = zzah.zza();
        zzagVarZza.zzd(zzajVar);
        zzs zzsVarZza = zzt.zza();
        zzsVarZza.zza(zzarVar);
        zzsVarZza.zzb(zzarVar);
        zzagVarZza.zza(zzsVarZza);
        zzan zzanVarZza = zzao.zza();
        zzanVarZza.zzb(zzarVar);
        zzanVarZza.zzc(zzarVar);
        zzanVarZza.zzd(zzarVar);
        zzanVarZza.zza(zzarVar);
        zzagVarZza.zze(zzanVarZza);
        zzagVarZza.zzg(z2);
        if (!z2 && zzmhVar.zzf()) {
            z = true;
        }
        zzagVarZza.zzb(z);
        zzagVarZza.zzf(zzmhVar.zza());
        zzagVarZza.zzh(true);
        if (z2) {
            zzagVarZza.zzk(4);
            zzagVarZza.zzj(4);
        } else {
            int iZze2 = zzmhVar.zze();
            if (iZze2 == 1) {
                zzagVarZza.zzk(2);
            } else if (iZze2 == 2) {
                zzagVarZza.zzk(3);
            }
            int iZzd = zzmhVar.zzd();
            if (iZzd == 1) {
                zzagVarZza.zzj(2);
            } else if (iZzd == 2) {
                zzagVarZza.zzj(3);
            }
            int iZzb = zzmhVar.zzb();
            if (iZzb == 1) {
                zzagVarZza.zzi(2);
            } else if (iZzb == 2) {
                zzagVarZza.zzi(3);
            }
        }
        this.zzb = (zzah) zzagVarZza.zzq();
        this.zzc = faceDetectorV2Jni;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List zze(com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf r29) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.face.bundled.internal.zza.zze(com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf):java.util.List");
    }

    private static int zzf(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 2;
        }
        StringBuilder sb = new StringBuilder(40);
        sb.append("Unsupported rotation degree: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    private final List zzg(ByteBuffer byteBuffer, zzmd zzmdVar, int i) throws RemoteException {
        zzaf zzafVarZzb;
        zzo zzoVarZza = zzp.zza();
        zzoVarZza.zzc(zzmdVar.zzd());
        zzoVarZza.zza(zzmdVar.zza());
        zzoVarZza.zze(zzf(zzmdVar.zzc()));
        zzoVarZza.zzd(i);
        if (zzmdVar.zze() > 0) {
            zzoVarZza.zzb(zzmdVar.zze() * 1000);
        }
        zzp zzpVar = (zzp) zzoVarZza.zzq();
        if (byteBuffer.isDirect()) {
            zzafVarZzb = this.zzc.zzd(this.zzd, byteBuffer, zzpVar);
        } else if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            zzafVarZzb = this.zzc.zzb(this.zzd, byteBuffer.array(), zzpVar);
        } else {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            zzafVarZzb = this.zzc.zzb(this.zzd, bArr, zzpVar);
        }
        return zzafVarZzb != null ? zze(zzafVarZzb) : new ArrayList();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmm
    public final List zzb(IObjectWrapper iObjectWrapper, zzmd zzmdVar) throws RemoteException {
        zzaf zzafVarZzc;
        int iZzb = zzmdVar.zzb();
        if (iZzb == -1) {
            return zzg(zzd.zza((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), true), zzmdVar, 2);
        }
        if (iZzb == 17) {
            return zzg((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzmdVar, 2);
        }
        if (iZzb != 35) {
            if (iZzb == 842094169) {
                return zzg((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzmdVar, 7);
            }
            int iZzb2 = zzmdVar.zzb();
            int i = Build.VERSION.SDK_INT;
            StringBuilder sb = new StringBuilder(55);
            sb.append("Unsupported image format ");
            sb.append(iZzb2);
            sb.append(" at API ");
            sb.append(i);
            String string = sb.toString();
            Log.e("ThickFaceDetector", string);
            throw new RemoteException(string);
        }
        Image.Plane[] planes = ((Image) ObjectWrapper.unwrap(iObjectWrapper)).getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();
        ByteBuffer buffer2 = planes[1].getBuffer();
        ByteBuffer buffer3 = planes[2].getBuffer();
        zzo zzoVarZza = zzp.zza();
        zzoVarZza.zzc(zzmdVar.zzd());
        zzoVarZza.zza(zzmdVar.zza());
        zzoVarZza.zze(zzf(zzmdVar.zzc()));
        if (zzmdVar.zze() > 0) {
            zzoVarZza.zzb(zzmdVar.zze() * 1000);
        }
        zzp zzpVar = (zzp) zzoVarZza.zzq();
        if (buffer.isDirect()) {
            zzafVarZzc = this.zzc.zze(this.zzd, buffer, buffer2, buffer3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzpVar);
        } else if (buffer.hasArray() && buffer.arrayOffset() == 0) {
            zzafVarZzc = this.zzc.zzc(this.zzd, buffer.array(), buffer2.array(), buffer3.array(), planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzpVar);
        } else {
            byte[] bArr = new byte[buffer.remaining()];
            buffer.get(bArr);
            byte[] bArr2 = new byte[buffer2.remaining()];
            buffer.get(bArr);
            byte[] bArr3 = new byte[buffer3.remaining()];
            buffer.get(bArr);
            zzafVarZzc = this.zzc.zzc(this.zzd, bArr, bArr2, bArr3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzpVar);
        }
        return zzafVarZzc != null ? zze(zzafVarZzc) : new ArrayList();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmm
    public final void zzc() {
        this.zzd = this.zzc.zza(this.zzb, this.zza.getAssets());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmm
    public final void zzd() {
        long j = this.zzd;
        if (j > 0) {
            this.zzc.zzf(j);
            this.zzd = -1L;
        }
    }
}
