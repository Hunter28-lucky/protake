package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zznb extends zzne {
    public final /* synthetic */ zznl zza;
    private int zzb = 0;
    private final int zzc;

    public zznb(zznl zznlVar) {
        this.zza = zznlVar;
        this.zzc = zznlVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzng
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
