package com.google.mlkit.vision.face.bundled.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzmh;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzmm;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzmo;
import com.google.android.gms.vision.face.FaceDetectorV2Jni;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
@KeepForSdk
@DynamiteApi
/* loaded from: classes2.dex */
public class ThickFaceDetectorCreator extends zzmo {
    static {
        System.loadLibrary("face_detector_v2_jni");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmp
    public zzmm newFaceDetector(IObjectWrapper iObjectWrapper, zzmh zzmhVar) throws RemoteException {
        return new zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzmhVar, new FaceDetectorV2Jni());
    }
}
