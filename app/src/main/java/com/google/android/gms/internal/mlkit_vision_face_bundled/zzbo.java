package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public abstract class zzbo extends zzbh implements Set {

    @CheckForNull
    private transient zzbl zza;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzbv.zza(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzbw iterator();

    public final zzbl zzf() {
        zzbl zzblVar = this.zza;
        if (zzblVar != null) {
            return zzblVar;
        }
        zzbl zzblVarZzg = zzg();
        this.zza = zzblVarZzg;
        return zzblVarZzg;
    }

    public zzbl zzg() {
        return zzbl.zzg(toArray());
    }
}
