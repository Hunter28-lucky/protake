package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzpk implements zzqf {
    private static final zzpq zza = new zzpi();
    private final zzpq zzb;

    public zzpk() {
        zzpq zzpqVar;
        zzpq[] zzpqVarArr = new zzpq[2];
        zzpqVarArr[0] = zzog.zza();
        try {
            zzpqVar = (zzpq) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzpqVar = zza;
        }
        zzpqVarArr[1] = zzpqVar;
        zzpj zzpjVar = new zzpj(zzpqVarArr);
        zzot.zzf(zzpjVar, "messageInfoFactory");
        this.zzb = zzpjVar;
    }

    private static boolean zzb(zzpp zzppVar) {
        return zzppVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqf
    public final zzqe zza(Class cls) {
        zzqg.zzG(cls);
        zzpp zzppVarZzb = this.zzb.zzb(cls);
        return zzppVarZzb.zzb() ? zzon.class.isAssignableFrom(cls) ? zzpw.zzc(zzqg.zzB(), zzob.zzb(), zzppVarZzb.zza()) : zzpw.zzc(zzqg.zzz(), zzob.zza(), zzppVarZzb.zza()) : zzon.class.isAssignableFrom(cls) ? zzb(zzppVarZzb) ? zzpv.zzk(cls, zzppVarZzb, zzpz.zzb(), zzpg.zzd(), zzqg.zzB(), zzob.zzb(), zzpo.zzb()) : zzpv.zzk(cls, zzppVarZzb, zzpz.zzb(), zzpg.zzd(), zzqg.zzB(), null, zzpo.zzb()) : zzb(zzppVarZzb) ? zzpv.zzk(cls, zzppVarZzb, zzpz.zza(), zzpg.zzc(), zzqg.zzz(), zzob.zza(), zzpo.zza()) : zzpv.zzk(cls, zzppVarZzb, zzpz.zza(), zzpg.zzc(), zzqg.zzA(), null, zzpo.zza());
    }
}
