package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzob {
    private static final zznz zza = new zzoa();
    private static final zznz zzb;

    static {
        zznz zznzVar;
        try {
            zznzVar = (zznz) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zznzVar = null;
        }
        zzb = zznzVar;
    }

    public static zznz zza() {
        zznz zznzVar = zzb;
        if (zznzVar != null) {
            return zznzVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zznz zzb() {
        return zza;
    }
}
