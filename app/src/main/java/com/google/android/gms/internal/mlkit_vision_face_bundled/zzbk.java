package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzbk extends zzbl {
    public final transient int zza;
    public final transient int zzb;
    public final /* synthetic */ zzbl zzc;

    public zzbk(zzbl zzblVar, int i, int i2) {
        this.zzc = zzblVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzay.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbl, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbh
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbh
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbh
    @CheckForNull
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbl
    /* renamed from: zzf */
    public final zzbl subList(int i, int i2) {
        zzay.zzc(i, i2, this.zzb);
        zzbl zzblVar = this.zzc;
        int i3 = this.zza;
        return zzblVar.subList(i + i3, i2 + i3);
    }
}
