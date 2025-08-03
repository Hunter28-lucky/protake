package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
final class zzkz extends zzlf {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    public /* synthetic */ zzkz(String str, boolean z, int i, zzky zzkyVar) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzlf) {
            zzlf zzlfVar = (zzlf) obj;
            if (this.zza.equals(zzlfVar.zzb()) && this.zzb == zzlfVar.zzc() && this.zzc == zzlfVar.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        String str = this.zza;
        boolean z = this.zzb;
        int i = this.zzc;
        StringBuilder sb = new StringBuilder(str.length() + 84);
        sb.append("MLKitLoggingOptions{libraryName=");
        sb.append(str);
        sb.append(", enableFirelog=");
        sb.append(z);
        sb.append(", firelogEventType=");
        sb.append(i);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlf
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlf
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzlf
    public final boolean zzc() {
        return this.zzb;
    }
}
