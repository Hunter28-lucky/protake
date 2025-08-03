package com.google.android.gms.internal.play_billing;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes2.dex */
final class zzat extends zzal {
    public static final zzal zza = new zzat(null, new Object[0], 0);
    public final transient Object[] zzb;

    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzat(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    public static zzat zzg(int i, Object[] objArr, zzak zzakVar) {
        short[] sArr;
        char c;
        char c2;
        byte[] bArr;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return (zzat) zza;
        }
        Object obj = null;
        int i3 = 1;
        if (i2 == 1) {
            Object obj2 = objArrCopyOf[0];
            Objects.requireNonNull(obj2);
            Object obj3 = objArrCopyOf[1];
            Objects.requireNonNull(obj3);
            zzad.zza(obj2, obj3);
            return new zzat(null, objArrCopyOf, 1);
        }
        zzaa.zzb(i2, objArrCopyOf.length >> 1, "index");
        int iMax = Math.max(i2, 2);
        int i4 = 1073741824;
        if (iMax < 751619276) {
            int iHighestOneBit = Integer.highestOneBit(iMax - 1);
            i4 = iHighestOneBit + iHighestOneBit;
            while (i4 * 0.7d < iMax) {
                i4 += i4;
            }
        } else if (iMax >= 1073741824) {
            throw new IllegalArgumentException("collection too large");
        }
        if (i2 == 1) {
            Object obj4 = objArrCopyOf[0];
            Objects.requireNonNull(obj4);
            Object obj5 = objArrCopyOf[1];
            Objects.requireNonNull(obj5);
            zzad.zza(obj4, obj5);
            i2 = 1;
            c = 1;
            c2 = 2;
        } else {
            int i5 = i4 - 1;
            char c3 = 65535;
            if (i4 <= 128) {
                byte[] bArr2 = new byte[i4];
                Arrays.fill(bArr2, (byte) -1);
                int i6 = 0;
                int i7 = 0;
                while (i6 < i2) {
                    int i8 = i7 + i7;
                    int i9 = i6 + i6;
                    Object obj6 = objArrCopyOf[i9];
                    Objects.requireNonNull(obj6);
                    Object obj7 = objArrCopyOf[i9 ^ i3];
                    Objects.requireNonNull(obj7);
                    zzad.zza(obj6, obj7);
                    int iZza = zzae.zza(obj6.hashCode());
                    while (true) {
                        int i10 = iZza & i5;
                        int i11 = bArr2[i10] & ExifInterface.MARKER;
                        if (i11 == 255) {
                            bArr2[i10] = (byte) i8;
                            if (i7 < i6) {
                                objArrCopyOf[i8] = obj6;
                                objArrCopyOf[i8 ^ 1] = obj7;
                            }
                            i7++;
                        } else {
                            if (obj6.equals(objArrCopyOf[i11])) {
                                int i12 = i11 ^ 1;
                                Object obj8 = objArrCopyOf[i12];
                                Objects.requireNonNull(obj8);
                                zzaj zzajVar = new zzaj(obj6, obj7, obj8);
                                objArrCopyOf[i12] = obj7;
                                obj = zzajVar;
                                break;
                            }
                            iZza = i10 + 1;
                        }
                    }
                    i6++;
                    i3 = 1;
                }
                if (i7 == i2) {
                    bArr = bArr2;
                } else {
                    bArr = new Object[]{bArr2, Integer.valueOf(i7), obj};
                    c2 = 2;
                    c = 1;
                    obj = bArr;
                }
            } else if (i4 <= 32768) {
                sArr = new short[i4];
                Arrays.fill(sArr, (short) -1);
                int i13 = 0;
                for (int i14 = 0; i14 < i2; i14++) {
                    int i15 = i13 + i13;
                    int i16 = i14 + i14;
                    Object obj9 = objArrCopyOf[i16];
                    Objects.requireNonNull(obj9);
                    Object obj10 = objArrCopyOf[i16 ^ 1];
                    Objects.requireNonNull(obj10);
                    zzad.zza(obj9, obj10);
                    int iZza2 = zzae.zza(obj9.hashCode());
                    while (true) {
                        int i17 = iZza2 & i5;
                        char c4 = (char) sArr[i17];
                        if (c4 == 65535) {
                            sArr[i17] = (short) i15;
                            if (i13 < i14) {
                                objArrCopyOf[i15] = obj9;
                                objArrCopyOf[i15 ^ 1] = obj10;
                            }
                            i13++;
                        } else {
                            if (obj9.equals(objArrCopyOf[c4])) {
                                int i18 = c4 ^ 1;
                                Object obj11 = objArrCopyOf[i18];
                                Objects.requireNonNull(obj11);
                                zzaj zzajVar2 = new zzaj(obj9, obj10, obj11);
                                objArrCopyOf[i18] = obj10;
                                obj = zzajVar2;
                                break;
                            }
                            iZza2 = i17 + 1;
                        }
                    }
                }
                if (i13 != i2) {
                    c2 = 2;
                    obj = new Object[]{sArr, Integer.valueOf(i13), obj};
                    c = 1;
                }
                bArr = sArr;
            } else {
                int i19 = 1;
                sArr = new int[i4];
                Arrays.fill((int[]) sArr, -1);
                int i20 = 0;
                int i21 = 0;
                while (i20 < i2) {
                    int i22 = i21 + i21;
                    int i23 = i20 + i20;
                    Object obj12 = objArrCopyOf[i23];
                    Objects.requireNonNull(obj12);
                    Object obj13 = objArrCopyOf[i23 ^ i19];
                    Objects.requireNonNull(obj13);
                    zzad.zza(obj12, obj13);
                    int iZza3 = zzae.zza(obj12.hashCode());
                    while (true) {
                        int i24 = iZza3 & i5;
                        ?? r15 = sArr[i24];
                        if (r15 == c3) {
                            sArr[i24] = i22;
                            if (i21 < i20) {
                                objArrCopyOf[i22] = obj12;
                                objArrCopyOf[i22 ^ 1] = obj13;
                            }
                            i21++;
                        } else {
                            if (obj12.equals(objArrCopyOf[r15])) {
                                int i25 = r15 ^ 1;
                                Object obj14 = objArrCopyOf[i25];
                                Objects.requireNonNull(obj14);
                                zzaj zzajVar3 = new zzaj(obj12, obj13, obj14);
                                objArrCopyOf[i25] = obj13;
                                obj = zzajVar3;
                                break;
                            }
                            iZza3 = i24 + 1;
                            c3 = 65535;
                        }
                    }
                    i20++;
                    i19 = 1;
                    c3 = 65535;
                }
                if (i21 != i2) {
                    c = 1;
                    c2 = 2;
                    obj = new Object[]{sArr, Integer.valueOf(i21), obj};
                }
                bArr = sArr;
            }
            c2 = 2;
            c = 1;
            obj = bArr;
        }
        boolean z = obj instanceof Object[];
        Object obj15 = obj;
        if (z) {
            Object[] objArr2 = (Object[]) obj;
            zzaj zzajVar4 = (zzaj) objArr2[c2];
            if (zzakVar == null) {
                throw zzajVar4.zza();
            }
            zzakVar.zzc = zzajVar4;
            Object obj16 = objArr2[0];
            int iIntValue = ((Integer) objArr2[c]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            obj15 = obj16;
            i2 = iIntValue;
        }
        return new zzat(obj15, objArrCopyOf, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[EDGE_INSN: B:44:0x0003->B:4:0x0003 BREAK  A[LOOP:0: B:16:0x0038->B:22:0x004e], EDGE_INSN: B:46:0x0003->B:4:0x0003 BREAK  A[LOOP:1: B:26:0x0063->B:32:0x007a], EDGE_INSN: B:48:0x0003->B:4:0x0003 BREAK  A[LOOP:2: B:34:0x0089->B:43:0x00a0]] */
    @Override // com.google.android.gms.internal.play_billing.zzal, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L6
        L3:
            r10 = r0
            goto L9c
        L6:
            int r1 = r9.zzd
            java.lang.Object[] r2 = r9.zzb
            r3 = 1
            if (r1 != r3) goto L20
            r1 = 0
            r1 = r2[r1]
            java.util.Objects.requireNonNull(r1)
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L3
            r10 = r2[r3]
            java.util.Objects.requireNonNull(r10)
            goto L9c
        L20:
            java.lang.Object r1 = r9.zzc
            if (r1 != 0) goto L25
            goto L3
        L25:
            boolean r4 = r1 instanceof byte[]
            r5 = -1
            if (r4 == 0) goto L51
            r4 = r1
            byte[] r4 = (byte[]) r4
            int r1 = r4.length
            int r6 = r1 + (-1)
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.play_billing.zzae.zza(r1)
        L38:
            r1 = r1 & r6
            r5 = r4[r1]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L41
            goto L3
        L41:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L4e
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9c
        L4e:
            int r1 = r1 + 1
            goto L38
        L51:
            boolean r4 = r1 instanceof short[]
            if (r4 == 0) goto L7d
            r4 = r1
            short[] r4 = (short[]) r4
            int r1 = r4.length
            int r6 = r1 + (-1)
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.play_billing.zzae.zza(r1)
        L63:
            r1 = r1 & r6
            short r5 = r4[r1]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L6d
            goto L3
        L6d:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7a
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L9c
        L7a:
            int r1 = r1 + 1
            goto L63
        L7d:
            int[] r1 = (int[]) r1
            int r4 = r1.length
            int r4 = r4 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.play_billing.zzae.zza(r6)
        L89:
            r6 = r6 & r4
            r7 = r1[r6]
            if (r7 != r5) goto L90
            goto L3
        L90:
            r8 = r2[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La0
            r10 = r7 ^ 1
            r10 = r2[r10]
        L9c:
            if (r10 != 0) goto L9f
            return r0
        L9f:
            return r10
        La0:
            int r6 = r6 + 1
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzat.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzal
    public final zzaf zza() {
        return new zzas(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzal
    public final zzam zzd() {
        return new zzaq(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzal
    public final zzam zze() {
        return new zzar(this, new zzas(this.zzb, 0, this.zzd));
    }
}
