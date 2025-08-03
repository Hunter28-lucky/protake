package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public enum zzim implements zzcb {
    UNKNOWN_CONTOURS(0),
    NO_CONTOURS(1),
    ALL_CONTOURS(2);

    private final int zze;

    zzim(int i) {
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzcb
    public final int zza() {
        return this.zze;
    }
}
