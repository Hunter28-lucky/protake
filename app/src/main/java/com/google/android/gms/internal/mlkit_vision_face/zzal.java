package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
class zzal implements Iterator {
    public final Iterator zza;
    public final Collection zzb;
    public final /* synthetic */ zzam zzc;

    public zzal(zzam zzamVar) {
        this.zzc = zzamVar;
        Collection collection = zzamVar.zzb;
        this.zzb = collection;
        this.zza = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public zzal(zzam zzamVar, Iterator it) {
        this.zzc = zzamVar;
        this.zzb = zzamVar.zzb;
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
        zzap.zze(this.zzc.zze);
        this.zzc.zzc();
    }

    final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
