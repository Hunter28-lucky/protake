package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Iterator;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzqz implements Iterator {
    public final Iterator zza;
    public final /* synthetic */ zzra zzb;

    public zzqz(zzra zzraVar) {
        this.zzb = zzraVar;
        this.zza = zzraVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
