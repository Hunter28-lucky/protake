package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzog implements zzpq {
    private static final zzog zza = new zzog();

    private zzog() {
    }

    public static zzog zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzpq
    public final zzpp zzb(Class cls) {
        if (!zzon.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (zzpp) zzon.zzy(cls.asSubclass(zzon.class)).zzf(3, null, null);
        } catch (Exception e2) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzpq
    public final boolean zzc(Class cls) {
        return zzon.class.isAssignableFrom(cls);
    }
}
