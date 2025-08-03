package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
final class zzal extends zzae {
    private final zzan zza;

    public zzal(zzan zzanVar, int i) {
        super(zzanVar.size(), i);
        this.zza = zzanVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzae
    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
