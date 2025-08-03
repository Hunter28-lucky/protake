package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzka {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private zzan zze;
    private String zzf;
    private Boolean zzg;
    private Boolean zzh;
    private Boolean zzi;
    private Integer zzj;
    private Integer zzk;

    public final zzka zzb(String str) {
        this.zza = str;
        return this;
    }

    public final zzka zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zzka zzd(Integer num) {
        this.zzj = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzka zze(Boolean bool) {
        this.zzg = bool;
        return this;
    }

    public final zzka zzf(Boolean bool) {
        this.zzi = bool;
        return this;
    }

    public final zzka zzg(Boolean bool) {
        this.zzh = bool;
        return this;
    }

    public final zzka zzh(zzan zzanVar) {
        this.zze = zzanVar;
        return this;
    }

    public final zzka zzi(String str) {
        this.zzf = str;
        return this;
    }

    public final zzka zzj(String str) {
        this.zzc = str;
        return this;
    }

    public final zzka zzk(Integer num) {
        this.zzk = num;
        return this;
    }

    public final zzka zzl(String str) {
        this.zzd = str;
        return this;
    }

    public final zzkc zzm() {
        return new zzkc(this, null);
    }
}
