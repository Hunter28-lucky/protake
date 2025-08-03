package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzbs extends zzbo {
    private final transient zzbn zza;
    private final transient zzbl zzb;

    public zzbs(zzbn zzbnVar, zzbl zzblVar) {
        this.zza = zzbnVar;
        this.zzb = zzblVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbh, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbo, com.google.android.gms.internal.mlkit_vision_face_bundled.zzbh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbh
    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbo, com.google.android.gms.internal.mlkit_vision_face_bundled.zzbh
    /* renamed from: zzd */
    public final zzbw iterator() {
        return this.zzb.listIterator(0);
    }
}
