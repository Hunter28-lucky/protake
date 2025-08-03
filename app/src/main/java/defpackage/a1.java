package defpackage;

import net.sourceforge.jaad.aac.sbr.SBR;

/* compiled from: TFGrid.java */
/* loaded from: classes2.dex */
public class a1 implements InterfaceC2848 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m1(SBR sbr, int i) {
        int[] iArr = new int[6];
        int i2 = sbr.rate;
        int[] iArr2 = sbr.abs_bord_lead;
        iArr[0] = iArr2[i] * i2;
        int[] iArr3 = sbr.L_E;
        int i3 = iArr3[i];
        int[] iArr4 = sbr.abs_bord_trail;
        iArr[i3] = iArr4[i] * i2;
        int i4 = sbr.bs_frame_class[i];
        if (i4 == 0) {
            int i5 = iArr3[i];
            if (i5 == 2) {
                iArr[1] = i2 * (sbr.numTimeSlots / 2);
            } else if (i5 == 4) {
                int i6 = sbr.numTimeSlots / 4;
                iArr[3] = i2 * 3 * i6;
                iArr[2] = i2 * 2 * i6;
                iArr[1] = i2 * i6;
            }
        } else if (i4 == 1) {
            int i7 = iArr3[i];
            if (i7 > 1) {
                int i8 = iArr4[i];
                for (int i9 = 0; i9 < sbr.L_E[i] - 1; i9++) {
                    int i10 = sbr.bs_rel_bord[i][i9];
                    if (i8 < i10) {
                        return 1;
                    }
                    i8 -= i10;
                    i7--;
                    iArr[i7] = sbr.rate * i8;
                }
            }
        } else if (i4 != 2) {
            if (i4 == 3) {
                if (sbr.bs_num_rel_0[i] != 0) {
                    int i11 = iArr2[i];
                    int i12 = 0;
                    int i13 = 1;
                    while (i12 < sbr.bs_num_rel_0[i]) {
                        i11 += sbr.bs_rel_bord_0[i][i12];
                        int i14 = sbr.rate;
                        if ((i14 * i11) + sbr.tHFAdj > sbr.numTimeSlotsRate + sbr.tHFGen) {
                            return 1;
                        }
                        iArr[i13] = i14 * i11;
                        i12++;
                        i13++;
                    }
                }
                if (sbr.bs_num_rel_1[i] != 0) {
                    int i15 = sbr.L_E[i];
                    int i16 = sbr.abs_bord_trail[i];
                    for (int i17 = 0; i17 < sbr.bs_num_rel_1[i]; i17++) {
                        int i18 = sbr.bs_rel_bord_1[i][i17];
                        if (i16 < i18) {
                            return 1;
                        }
                        i16 -= i18;
                        i15--;
                        iArr[i15] = sbr.rate * i16;
                    }
                }
            }
        } else if (iArr3[i] > 1) {
            int i19 = iArr2[i];
            int i20 = 0;
            int i21 = 1;
            while (i20 < sbr.L_E[i] - 1) {
                i19 += sbr.bs_rel_bord[i][i20];
                int i22 = sbr.rate;
                if ((i22 * i19) + sbr.tHFAdj > sbr.numTimeSlotsRate + sbr.tHFGen) {
                    return 1;
                }
                iArr[i21] = i22 * i19;
                i20++;
                i21++;
            }
        }
        for (int i23 = 0; i23 < 6; i23++) {
            sbr.t_E[i][i23] = iArr[i23];
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
    /* renamed from: Ԩ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m2(net.sourceforge.jaad.aac.sbr.SBR r4, int r5) {
        /*
            int[] r0 = r4.bs_frame_class
            r0 = r0[r5]
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L38
            if (r0 == r3) goto L23
            if (r0 == r1) goto L12
            r1 = 3
            if (r0 == r1) goto L23
            r3 = r2
            goto L3e
        L12:
            int[] r0 = r4.bs_pointer
            r0 = r0[r5]
            if (r0 != 0) goto L19
            goto L3e
        L19:
            if (r0 != r3) goto L20
            int[] r4 = r4.L_E
            r4 = r4[r5]
            goto L35
        L20:
            int r3 = r0 + (-1)
            goto L3e
        L23:
            int[] r0 = r4.bs_pointer
            r0 = r0[r5]
            if (r0 <= r3) goto L31
            int[] r4 = r4.L_E
            r4 = r4[r5]
            int r4 = r4 + r3
            int r3 = r4 - r0
            goto L3e
        L31:
            int[] r4 = r4.L_E
            r4 = r4[r5]
        L35:
            int r3 = r4 + (-1)
            goto L3e
        L38:
            int[] r4 = r4.L_E
            r4 = r4[r5]
            int r3 = r4 / 2
        L3e:
            if (r3 <= 0) goto L41
            r2 = r3
        L41:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a1.m2(net.sourceforge.jaad.aac.sbr.SBR, int):int");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m3(SBR sbr, int i) {
        int[] iArr = sbr.t_Q[i];
        int[] iArr2 = sbr.t_E[i];
        iArr[0] = iArr2[0];
        if (sbr.L_E[i] == 1) {
            iArr[1] = iArr2[1];
            iArr[2] = 0;
            return;
        }
        int iM2 = m2(sbr, i);
        int[] iArr3 = sbr.t_Q[i];
        int[] iArr4 = sbr.t_E[i];
        iArr3[1] = iArr4[iM2];
        iArr3[2] = iArr4[sbr.L_E[i]];
    }
}
