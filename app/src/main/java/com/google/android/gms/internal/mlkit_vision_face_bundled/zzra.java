package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzra extends AbstractList implements RandomAccess, zzpa {
    private final zzpa zza;

    public zzra(zzpa zzpaVar) {
        this.zza = zzpaVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzoz) this.zza).get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzqz(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new zzqy(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzpa
    public final zzpa zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzpa
    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzpa
    public final List zzh() {
        return this.zza.zzh();
    }
}
