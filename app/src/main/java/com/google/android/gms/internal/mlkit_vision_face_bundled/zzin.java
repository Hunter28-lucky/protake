package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public enum zzin implements zzcb {
    UNKNOWN_LANDMARKS(0),
    NO_LANDMARKS(1),
    ALL_LANDMARKS(2);

    private final int zze;

    zzin(int i) {
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzcb
    public final int zza() {
        return this.zze;
    }
}
