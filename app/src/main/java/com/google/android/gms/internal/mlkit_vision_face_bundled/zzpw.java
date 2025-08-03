package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzpw implements zzqe {
    private final zzps zza;
    private final zzqv zzb;
    private final boolean zzc;
    private final zznz zzd;

    private zzpw(zzqv zzqvVar, zznz zznzVar, zzps zzpsVar) {
        this.zzb = zzqvVar;
        this.zzc = zznzVar.zzf(zzpsVar);
        this.zzd = zznzVar;
        this.zza = zzpsVar;
    }

    public static zzpw zzc(zzqv zzqvVar, zznz zznzVar, zzps zzpsVar) {
        return new zzpw(zzqvVar, zznzVar, zzpsVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final int zza(Object obj) {
        zzqv zzqvVar = this.zzb;
        int iZzb = zzqvVar.zzb(zzqvVar.zzc(obj));
        return this.zzc ? iZzb + this.zzd.zzb(obj).zzb() : iZzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final int zzb(Object obj) {
        int iHashCode = this.zzb.zzc(obj).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zzb(obj).zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final Object zze() {
        return this.zza.zzH().zzs();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zze(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final void zzg(Object obj, Object obj2) {
        zzqg.zzF(this.zzb, obj, obj2);
        if (this.zzc) {
            zzqg.zzE(this.zzd, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bf A[EDGE_INSN: B:57:0x00bf->B:33:0x00bf BREAK  A[LOOP:1: B:18:0x0067->B:60:0x0067], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.mlkit_vision_face_bundled.zzmx r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzon r0 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzon) r0
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzqw r1 = r0.zzc
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzqw r2 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzqw.zzc()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzqw r1 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzqw.zze()
            r0.zzc = r1
        L11:
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzoj r11 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzoj) r11
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzod r11 = r11.zzc()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Lca
            int r4 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzmy.zzj(r12, r13, r15)
            int r13 = r15.zza
            r3 = 11
            r5 = 2
            if (r13 == r3) goto L65
            r3 = r13 & 7
            if (r3 != r5) goto L60
            com.google.android.gms.internal.mlkit_vision_face_bundled.zznz r2 = r10.zzd
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzny r3 = r15.zzd
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzps r5 = r10.zza
            int r6 = r13 >>> 3
            java.lang.Object r8 = r2.zzd(r3, r5, r6)
            if (r8 == 0) goto L55
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzqb r13 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzqb.zza()
            r2 = r8
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzol r2 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzol) r2
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzps r3 = r2.zzc
            java.lang.Class r3 = r3.getClass()
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe r13 = r13.zzb(r3)
            int r13 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzmy.zzd(r13, r12, r4, r14, r15)
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzok r2 = r2.zzd
            java.lang.Object r3 = r15.zzc
            r11.zzj(r2, r3)
            goto L5e
        L55:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzmy.zzi(r2, r3, r4, r5, r6, r7)
        L5e:
            r2 = r8
            goto L19
        L60:
            int r13 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzmy.zzn(r13, r12, r4, r14, r15)
            goto L19
        L65:
            r13 = 0
            r3 = r0
        L67:
            if (r4 >= r14) goto Lbf
            int r4 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzmy.zzj(r12, r4, r15)
            int r6 = r15.zza
            r7 = r6 & 7
            int r8 = r6 >>> 3
            if (r8 == r5) goto La3
            r9 = 3
            if (r8 == r9) goto L79
            goto Lb6
        L79:
            if (r2 == 0) goto L98
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzqb r6 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzqb.zza()
            r7 = r2
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzol r7 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzol) r7
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzps r8 = r7.zzc
            java.lang.Class r8 = r8.getClass()
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe r6 = r6.zzb(r8)
            int r4 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzmy.zzd(r6, r12, r4, r14, r15)
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzok r6 = r7.zzd
            java.lang.Object r7 = r15.zzc
            r11.zzj(r6, r7)
            goto L67
        L98:
            if (r7 != r5) goto Lb6
            int r4 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzmy.zza(r12, r4, r15)
            java.lang.Object r3 = r15.zzc
            com.google.android.gms.internal.mlkit_vision_face_bundled.zznl r3 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zznl) r3
            goto L67
        La3:
            if (r7 != 0) goto Lb6
            int r4 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzmy.zzj(r12, r4, r15)
            int r13 = r15.zza
            com.google.android.gms.internal.mlkit_vision_face_bundled.zznz r2 = r10.zzd
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzny r6 = r15.zzd
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzps r7 = r10.zza
            java.lang.Object r2 = r2.zzd(r6, r7, r13)
            goto L67
        Lb6:
            r7 = 12
            if (r6 == r7) goto Lbf
            int r4 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzmy.zzn(r6, r12, r4, r14, r15)
            goto L67
        Lbf:
            if (r3 == 0) goto Lc7
            int r13 = r13 << 3
            r13 = r13 | r5
            r1.zzh(r13, r3)
        Lc7:
            r13 = r4
            goto L19
        Lca:
            if (r13 != r14) goto Lcd
            return
        Lcd:
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzov r11 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzov.zze()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzpw.zzh(java.lang.Object, byte[], int, int, com.google.android.gms.internal.mlkit_vision_face_bundled.zzmx):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final boolean zzi(Object obj, Object obj2) {
        if (!this.zzb.zzc(obj).equals(this.zzb.zzc(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final boolean zzj(Object obj) {
        return this.zzd.zzb(obj).zzl();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final void zzm(Object obj, zznu zznuVar) throws IOException {
        Iterator itZzf = this.zzd.zzb(obj).zzf();
        if (!itZzf.hasNext()) {
            zzqv zzqvVar = this.zzb;
            zzqvVar.zzi(zzqvVar.zzc(obj), zznuVar);
        } else {
            zzoc zzocVar = (zzoc) ((Map.Entry) itZzf.next()).getKey();
            if (zzocVar.zzc() == zzrm.MESSAGE) {
                zzocVar.zze();
            }
            throw new IllegalStateException("Found invalid MessageSet item.");
        }
    }
}
