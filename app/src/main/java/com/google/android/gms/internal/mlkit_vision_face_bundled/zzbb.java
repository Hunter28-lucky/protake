package com.google.android.gms.internal.mlkit_vision_face_bundled;

import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzbb implements zzba {

    @CheckForNull
    public volatile zzba zza;

    public zzbb(zzba zzbaVar) {
        this.zza = zzbaVar;
    }

    public final String toString() {
        Object obj = this.zza;
        if (obj == null) {
            obj = "<supplier that returned null>";
        }
        String string = obj.toString();
        StringBuilder sb = new StringBuilder(string.length() + 19);
        sb.append("Suppliers.memoize(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }
}
