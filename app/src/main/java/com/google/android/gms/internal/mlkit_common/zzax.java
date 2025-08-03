package com.google.android.gms.internal.mlkit_common;

import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
final class zzax extends zzap {
    public static final zzap zza = new zzax(null, new Object[0], 0);
    public final transient Object[] zzb;
    private final transient int zzc;

    private zzax(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public static zzax zzg(int i, Object[] objArr, zzao zzaoVar) {
        Object obj = objArr[0];
        obj.getClass();
        Object obj2 = objArr[1];
        obj2.getClass();
        zzaf.zza(obj, obj2);
        return new zzax(null, objArr, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    @Override // com.google.android.gms.internal.mlkit_common.zzap, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.zzb
            int r1 = r4.zzc
            r2 = 0
            if (r5 != 0) goto L9
        L7:
            r5 = r2
            goto L1d
        L9:
            r3 = 1
            if (r1 != r3) goto L7
            r1 = 0
            r1 = r0[r1]
            r1.getClass()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L7
            r5 = r0[r3]
            r5.getClass()
        L1d:
            if (r5 != 0) goto L20
            return r2
        L20:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzax.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzap
    public final zzaj zza() {
        return new zzaw(this.zzb, 1, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzap
    public final zzaq zzd() {
        return new zzau(this, this.zzb, 0, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzap
    public final zzaq zze() {
        return new zzav(this, new zzaw(this.zzb, 0, this.zzc));
    }
}
