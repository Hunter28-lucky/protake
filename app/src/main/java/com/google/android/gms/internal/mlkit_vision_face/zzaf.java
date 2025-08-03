package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
final class zzaf extends zzbv {
    public final /* synthetic */ zzah zza;

    public zzaf(zzah zzahVar) {
        this.zza = zzahVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbv, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        Set setEntrySet = this.zza.zza.entrySet();
        setEntrySet.getClass();
        try {
            return setEntrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzag(this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbv, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        entry.getClass();
        zzap.zzm(this.zza.zzb, entry.getKey());
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbv
    public final Map zza() {
        return this.zza;
    }
}
