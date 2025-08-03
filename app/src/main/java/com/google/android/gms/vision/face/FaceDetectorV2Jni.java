package com.google.android.gms.vision.face;

import android.content.res.AssetManager;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzah;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzas;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzny;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzov;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzp;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public class FaceDetectorV2Jni {
    private final zzny zza;

    public FaceDetectorV2Jni() {
        zzny zznyVarZzb = zzny.zzb();
        this.zza = zznyVarZzb;
        zznyVarZzb.zzd(zzas.zza);
    }

    @Keep
    private native void closeDetectorJni(long j);

    @Keep
    private native byte[] detectFacesImageByteArrayJni(long j, byte[] bArr, byte[] bArr2);

    @Keep
    private native byte[] detectFacesImageByteArrayMultiPlanesJni(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr4);

    @Keep
    private native byte[] detectFacesImageByteBufferJni(long j, ByteBuffer byteBuffer, byte[] bArr);

    @Keep
    private native byte[] detectFacesImageByteBufferMultiPlanesJni(long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr);

    @Keep
    private native long initDetectorJni(byte[] bArr, AssetManager assetManager);

    public final long zza(zzah zzahVar, AssetManager assetManager) {
        Log.v("FaceDetectorV2Jni", "initialize.start()");
        long jInitDetectorJni = initDetectorJni(zzahVar.zzs(), assetManager);
        Log.v("FaceDetectorV2Jni", "initialize.end()");
        return jInitDetectorJni;
    }

    @Nullable
    public final zzaf zzb(long j, byte[] bArr, zzp zzpVar) throws RemoteException {
        Log.v("FaceDetectorV2Jni", "detectFacesImageByteArray.start()");
        zzaf zzafVarZzb = null;
        try {
            byte[] bArrDetectFacesImageByteArrayJni = detectFacesImageByteArrayJni(j, bArr, zzpVar.zzs());
            if (bArrDetectFacesImageByteArrayJni != null && bArrDetectFacesImageByteArrayJni.length > 0) {
                zzafVarZzb = zzaf.zzb(bArrDetectFacesImageByteArrayJni, this.zza);
            }
        } catch (zzov e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            Log.e("FaceDetectorV2Jni", strValueOf.length() != 0 ? "detectFacesImageByteArray failed to parse result: ".concat(strValueOf) : new String("detectFacesImageByteArray failed to parse result: "));
        }
        Log.v("FaceDetectorV2Jni", "detectFacesImageByteArray.end()");
        return zzafVarZzb;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf zzc(long r17, byte[] r19, byte[] r20, byte[] r21, int r22, int r23, int r24, int r25, int r26, int r27, com.google.android.gms.internal.mlkit_vision_face_bundled.zzp r28) {
        /*
            r16 = this;
            java.lang.String r1 = "FaceDetectorV2Jni"
            java.lang.String r0 = "detectFacesImageByteArrayMultiPlanes.start()"
            android.util.Log.v(r1, r0)
            r2 = 0
            byte[] r15 = r28.zzs()     // Catch: com.google.android.gms.internal.mlkit_vision_face_bundled.zzov -> L39
            r3 = r16
            r4 = r17
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r27
            byte[] r0 = r3.detectFacesImageByteArrayMultiPlanesJni(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch: com.google.android.gms.internal.mlkit_vision_face_bundled.zzov -> L39
            if (r0 == 0) goto L36
            int r3 = r0.length     // Catch: com.google.android.gms.internal.mlkit_vision_face_bundled.zzov -> L39
            if (r3 <= 0) goto L36
            r3 = r16
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzny r4 = r3.zza     // Catch: com.google.android.gms.internal.mlkit_vision_face_bundled.zzov -> L34
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf r2 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf.zzb(r0, r4)     // Catch: com.google.android.gms.internal.mlkit_vision_face_bundled.zzov -> L34
            goto L59
        L34:
            r0 = move-exception
            goto L3c
        L36:
            r3 = r16
            goto L59
        L39:
            r0 = move-exception
            r3 = r16
        L3c:
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r4 = "detectFacesImageByteArrayMultiPlanes failed to parse result: "
            int r5 = r0.length()
            if (r5 == 0) goto L51
            java.lang.String r0 = r4.concat(r0)
            goto L56
        L51:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
        L56:
            android.util.Log.e(r1, r0)
        L59:
            java.lang.String r0 = "%s detectFacesImageByteArrayMultiPlanes.end()"
            android.util.Log.v(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.face.FaceDetectorV2Jni.zzc(long, byte[], byte[], byte[], int, int, int, int, int, int, com.google.android.gms.internal.mlkit_vision_face_bundled.zzp):com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf");
    }

    @Nullable
    public final zzaf zzd(long j, ByteBuffer byteBuffer, zzp zzpVar) throws RemoteException {
        Log.v("FaceDetectorV2Jni", "detectFacesImageByteBuffer.start()");
        zzaf zzafVarZzb = null;
        try {
            byte[] bArrDetectFacesImageByteBufferJni = detectFacesImageByteBufferJni(j, byteBuffer, zzpVar.zzs());
            if (bArrDetectFacesImageByteBufferJni != null && bArrDetectFacesImageByteBufferJni.length > 0) {
                zzafVarZzb = zzaf.zzb(bArrDetectFacesImageByteBufferJni, this.zza);
            }
        } catch (zzov e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            Log.e("FaceDetectorV2Jni", strValueOf.length() != 0 ? "detectFacesImageByteBuffer failed to parse result: ".concat(strValueOf) : new String("detectFacesImageByteBuffer failed to parse result: "));
        }
        Log.v("FaceDetectorV2Jni", "%s detectFacesImageByteBuffer.end()");
        return zzafVarZzb;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf zze(long r17, java.nio.ByteBuffer r19, java.nio.ByteBuffer r20, java.nio.ByteBuffer r21, int r22, int r23, int r24, int r25, int r26, int r27, com.google.android.gms.internal.mlkit_vision_face_bundled.zzp r28) {
        /*
            r16 = this;
            java.lang.String r1 = "FaceDetectorV2Jni"
            java.lang.String r0 = "detectFacesImageByteBufferMultiPlanes.start()"
            android.util.Log.v(r1, r0)
            r2 = 0
            byte[] r15 = r28.zzs()     // Catch: com.google.android.gms.internal.mlkit_vision_face_bundled.zzov -> L39
            r3 = r16
            r4 = r17
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r27
            byte[] r0 = r3.detectFacesImageByteBufferMultiPlanesJni(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch: com.google.android.gms.internal.mlkit_vision_face_bundled.zzov -> L39
            if (r0 == 0) goto L36
            int r3 = r0.length     // Catch: com.google.android.gms.internal.mlkit_vision_face_bundled.zzov -> L39
            if (r3 <= 0) goto L36
            r3 = r16
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzny r4 = r3.zza     // Catch: com.google.android.gms.internal.mlkit_vision_face_bundled.zzov -> L34
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf r2 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf.zzb(r0, r4)     // Catch: com.google.android.gms.internal.mlkit_vision_face_bundled.zzov -> L34
            goto L59
        L34:
            r0 = move-exception
            goto L3c
        L36:
            r3 = r16
            goto L59
        L39:
            r0 = move-exception
            r3 = r16
        L3c:
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r4 = "detectFacesImageByteBufferMultiPlanes failed to parse result: "
            int r5 = r0.length()
            if (r5 == 0) goto L51
            java.lang.String r0 = r4.concat(r0)
            goto L56
        L51:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
        L56:
            android.util.Log.e(r1, r0)
        L59:
            java.lang.String r0 = "detectFacesImageByteBuffer.end()"
            android.util.Log.v(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.face.FaceDetectorV2Jni.zze(long, java.nio.ByteBuffer, java.nio.ByteBuffer, java.nio.ByteBuffer, int, int, int, int, int, int, com.google.android.gms.internal.mlkit_vision_face_bundled.zzp):com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf");
    }

    public final void zzf(long j) {
        Log.v("FaceDetectorV2Jni", "closeDetector.start()");
        closeDetectorJni(j);
        Log.v("FaceDetectorV2Jni", "closeDetector.end()");
    }
}
