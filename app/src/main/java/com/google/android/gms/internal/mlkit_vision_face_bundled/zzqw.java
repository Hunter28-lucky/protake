package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzqw {
    private static final zzqw zza = new zzqw(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzqw() {
        this(0, new int[8], new Object[8], true);
    }

    private zzqw(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzqw zzc() {
        return zza;
    }

    public static zzqw zzd(zzqw zzqwVar, zzqw zzqwVar2) {
        int i = zzqwVar.zzb + zzqwVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzqwVar.zzc, i);
        System.arraycopy(zzqwVar2.zzc, 0, iArrCopyOf, zzqwVar.zzb, zzqwVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzqwVar.zzd, i);
        System.arraycopy(zzqwVar2.zzd, 0, objArrCopyOf, zzqwVar.zzb, zzqwVar2.zzb);
        return new zzqw(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzqw zze() {
        return new zzqw(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzqw)) {
            return false;
        }
        zzqw zzqwVar = (zzqw) obj;
        int i = this.zzb;
        if (i == zzqwVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzqwVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzqwVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int zza() {
        int iZzD;
        int iZzE;
        int iZzD2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzD3 = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    ((Long) this.zzd[i2]).longValue();
                    iZzD2 = zznt.zzD(i4 << 3) + 8;
                } else if (i5 == 2) {
                    zznl zznlVar = (zznl) this.zzd[i2];
                    int iZzD4 = zznt.zzD(i4 << 3);
                    int iZzd = zznlVar.zzd();
                    iZzD3 += iZzD4 + zznt.zzD(iZzd) + iZzd;
                } else if (i5 == 3) {
                    int iZzC = zznt.zzC(i4);
                    iZzD = iZzC + iZzC;
                    iZzE = ((zzqw) this.zzd[i2]).zza();
                } else {
                    if (i5 != 5) {
                        throw new IllegalStateException(zzov.zza());
                    }
                    ((Integer) this.zzd[i2]).intValue();
                    iZzD2 = zznt.zzD(i4 << 3) + 4;
                }
                iZzD3 += iZzD2;
            } else {
                long jLongValue = ((Long) this.zzd[i2]).longValue();
                iZzD = zznt.zzD(i4 << 3);
                iZzE = zznt.zzE(jLongValue);
            }
            iZzD2 = iZzD + iZzE;
            iZzD3 += iZzD2;
        }
        this.zze = iZzD3;
        return iZzD3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzD = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2];
            zznl zznlVar = (zznl) this.zzd[i2];
            int iZzD2 = zznt.zzD(8);
            int iZzd = zznlVar.zzd();
            iZzD += iZzD2 + iZzD2 + zznt.zzD(16) + zznt.zzD(i3 >>> 3) + zznt.zzD(24) + zznt.zzD(iZzd) + iZzd;
        }
        this.zze = iZzD;
        return iZzD;
    }

    public final void zzf() {
        this.zzf = false;
    }

    public final void zzg(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzpu.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzh(int i, Object obj) {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.zzb;
        int[] iArr = this.zzc;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.zzc = Arrays.copyOf(iArr, i3);
            this.zzd = Arrays.copyOf(this.zzd, i3);
        }
        int[] iArr2 = this.zzc;
        int i4 = this.zzb;
        iArr2[i4] = i;
        this.zzd[i4] = obj;
        this.zzb = i4 + 1;
    }

    public final void zzi(zznu zznuVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zznuVar.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzj(zznu zznuVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    zznuVar.zzt(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zznuVar.zzm(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zznuVar.zzd(i3, (zznl) obj);
                } else if (i4 == 3) {
                    zznuVar.zzF(i3);
                    ((zzqw) obj).zzj(zznuVar);
                    zznuVar.zzh(i3);
                } else {
                    if (i4 != 5) {
                        throw new RuntimeException(zzov.zza());
                    }
                    zznuVar.zzk(i3, ((Integer) obj).intValue());
                }
            }
        }
    }
}
