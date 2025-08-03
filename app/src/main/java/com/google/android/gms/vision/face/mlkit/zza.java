package com.google.android.gms.vision.face.mlkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
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
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzj;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzlu;
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
    private static final GmsLogger zza = new GmsLogger("FaceDetector", "");
    private final Context zzb;
    private final zzmh zzc;
    private final zzah zzd;
    private final FaceDetectorV2Jni zze;
    private final zzb zzf;
    private final zzlu zzg;
    private long zzh = -1;

    public zza(Context context, zzmh zzmhVar, FaceDetectorV2Jni faceDetectorV2Jni, zzb zzbVar) {
        this.zzb = context;
        this.zzc = zzmhVar;
        boolean z = false;
        boolean z2 = zzmhVar.zzc() == 2;
        zzaq zzaqVarZza = zzar.zza();
        zzaqVarZza.zzb("models");
        zzar zzarVar = (zzar) zzaqVarZza.zzq();
        zzag zzagVarZza = zzah.zza();
        zzai zzaiVarZza = zzaj.zza();
        zzaiVarZza.zzc(zzarVar);
        zzaiVarZza.zzb(zzarVar);
        zzaiVarZza.zzd(zzarVar);
        zzagVarZza.zzc(zzaiVarZza);
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
            int iZze = zzmhVar.zze();
            if (iZze == 1) {
                zzagVarZza.zzk(2);
            } else if (iZze == 2) {
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
        this.zzd = (zzah) zzagVarZza.zzq();
        this.zze = faceDetectorV2Jni;
        this.zzf = zzbVar;
        this.zzg = zzlu.zza(context);
        zzj.zza(context);
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.face.mlkit.zza.zze(com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf):java.util.List");
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
            zzafVarZzb = this.zze.zzd(this.zzh, byteBuffer, zzpVar);
        } else if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            zzafVarZzb = this.zze.zzb(this.zzh, byteBuffer.array(), zzpVar);
        } else {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            zzafVarZzb = this.zze.zzb(this.zzh, bArr, zzpVar);
        }
        return zzafVarZzb != null ? zze(zzafVarZzb) : new ArrayList();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmm
    public final List zzb(IObjectWrapper iObjectWrapper, zzmd zzmdVar) throws RemoteException {
        List listZzg;
        zzaf zzafVarZzc;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iZzb = zzmdVar.zzb();
        if (iZzb == -1) {
            listZzg = zzg(com.google.android.gms.internal.mlkit_vision_face_bundled.zzd.zza((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), true), zzmdVar, 2);
        } else if (iZzb == 17) {
            listZzg = zzg((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzmdVar, 2);
        } else if (iZzb == 35) {
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
                zzafVarZzc = this.zze.zze(this.zzh, buffer, buffer2, buffer3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzpVar);
            } else if (buffer.hasArray() && buffer.arrayOffset() == 0) {
                zzafVarZzc = this.zze.zzc(this.zzh, buffer.array(), buffer2.array(), buffer3.array(), planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzpVar);
            } else {
                byte[] bArr = new byte[buffer.remaining()];
                buffer.get(bArr);
                byte[] bArr2 = new byte[buffer2.remaining()];
                buffer.get(bArr);
                byte[] bArr3 = new byte[buffer3.remaining()];
                buffer.get(bArr);
                zzafVarZzc = this.zze.zzc(this.zzh, bArr, bArr2, bArr3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzpVar);
            }
            listZzg = zzafVarZzc != null ? zze(zzafVarZzc) : new ArrayList();
        } else {
            if (iZzb != 842094169) {
                int iZzb2 = zzmdVar.zzb();
                int i = Build.VERSION.SDK_INT;
                StringBuilder sb = new StringBuilder(55);
                sb.append("Unsupported image format ");
                sb.append(iZzb2);
                sb.append(" at API ");
                sb.append(i);
                String string = sb.toString();
                Log.e("FaceDetector", string);
                this.zzg.zzc(25503, 1, jCurrentTimeMillis, System.currentTimeMillis());
                throw zze.zza(string);
            }
            listZzg = zzg((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzmdVar, 7);
        }
        List list = listZzg;
        this.zzf.zza(this.zzc, zzmdVar, list, SystemClock.elapsedRealtime() - jElapsedRealtime);
        this.zzg.zzc(25503, 0, jCurrentTimeMillis, System.currentTimeMillis());
        return list;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmm
    public final void zzc() {
        this.zzh = this.zze.zza(this.zzd, this.zzb.getAssets());
        this.zzf.zzc(this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmm
    public final void zzd() {
        long j = this.zzh;
        if (j > 0) {
            this.zze.zzf(j);
            this.zzh = -1L;
        }
    }
}
