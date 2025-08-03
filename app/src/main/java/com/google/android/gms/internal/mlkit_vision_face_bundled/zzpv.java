package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzpv<T> implements zzqe<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzrf.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzps zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzpg zzm;
    private final zzqv zzn;
    private final zznz zzo;
    private final zzpy zzp;
    private final zzpn zzq;

    private zzpv(int[] iArr, Object[] objArr, int i, int i2, zzps zzpsVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzpy zzpyVar, zzpg zzpgVar, zzqv zzqvVar, zznz zznzVar, zzpn zzpnVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = z;
        boolean z3 = false;
        if (zznzVar != null && zznzVar.zzf(zzpsVar)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzp = zzpyVar;
        this.zzm = zzpgVar;
        this.zzn = zzqvVar;
        this.zzo = zznzVar;
        this.zzg = zzpsVar;
        this.zzq = zzpnVar;
    }

    private static int zzA(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzB(int i) {
        return this.zzc[i + 1];
    }

    private static long zzC(Object obj, long j) {
        return ((Long) zzrf.zzf(obj, j)).longValue();
    }

    private final zzor zzD(int i) {
        int i2 = i / 3;
        return (zzor) this.zzd[i2 + i2 + 1];
    }

    private final zzqe zzE(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzqe zzqeVar = (zzqe) this.zzd[i3];
        if (zzqeVar != null) {
            return zzqeVar;
        }
        zzqe zzqeVarZzb = zzqb.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzqeVarZzb;
        return zzqeVarZzb;
    }

    private final Object zzF(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzG(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzH(Object obj, Object obj2, int i) {
        long jZzB = zzB(i) & 1048575;
        if (zzM(obj2, i)) {
            Object objZzf = zzrf.zzf(obj, jZzB);
            Object objZzf2 = zzrf.zzf(obj2, jZzB);
            if (objZzf != null && objZzf2 != null) {
                zzrf.zzs(obj, jZzB, zzot.zzg(objZzf, objZzf2));
                zzJ(obj, i);
            } else if (objZzf2 != null) {
                zzrf.zzs(obj, jZzB, objZzf2);
                zzJ(obj, i);
            }
        }
    }

    private final void zzI(Object obj, Object obj2, int i) {
        int iZzB = zzB(i);
        int i2 = this.zzc[i];
        long j = iZzB & 1048575;
        if (zzP(obj2, i2, i)) {
            Object objZzf = zzP(obj, i2, i) ? zzrf.zzf(obj, j) : null;
            Object objZzf2 = zzrf.zzf(obj2, j);
            if (objZzf != null && objZzf2 != null) {
                zzrf.zzs(obj, j, zzot.zzg(objZzf, objZzf2));
                zzK(obj, i2, i);
            } else if (objZzf2 != null) {
                zzrf.zzs(obj, j, objZzf2);
                zzK(obj, i2, i);
            }
        }
    }

    private final void zzJ(Object obj, int i) {
        int iZzy = zzy(i);
        long j = 1048575 & iZzy;
        if (j == 1048575) {
            return;
        }
        zzrf.zzq(obj, j, (1 << (iZzy >>> 20)) | zzrf.zzc(obj, j));
    }

    private final void zzK(Object obj, int i, int i2) {
        zzrf.zzq(obj, zzy(i2) & 1048575, i);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzM(obj, i) == zzM(obj2, i);
    }

    private final boolean zzM(Object obj, int i) {
        int iZzy = zzy(i);
        long j = iZzy & 1048575;
        if (j != 1048575) {
            return (zzrf.zzc(obj, j) & (1 << (iZzy >>> 20))) != 0;
        }
        int iZzB = zzB(i);
        long j2 = iZzB & 1048575;
        switch (zzA(iZzB)) {
            case 0:
                return Double.doubleToRawLongBits(zzrf.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzrf.zzb(obj, j2)) != 0;
            case 2:
                return zzrf.zzd(obj, j2) != 0;
            case 3:
                return zzrf.zzd(obj, j2) != 0;
            case 4:
                return zzrf.zzc(obj, j2) != 0;
            case 5:
                return zzrf.zzd(obj, j2) != 0;
            case 6:
                return zzrf.zzc(obj, j2) != 0;
            case 7:
                return zzrf.zzw(obj, j2);
            case 8:
                Object objZzf = zzrf.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zznl) {
                    return !zznl.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzrf.zzf(obj, j2) != null;
            case 10:
                return !zznl.zzb.equals(zzrf.zzf(obj, j2));
            case 11:
                return zzrf.zzc(obj, j2) != 0;
            case 12:
                return zzrf.zzc(obj, j2) != 0;
            case 13:
                return zzrf.zzc(obj, j2) != 0;
            case 14:
                return zzrf.zzd(obj, j2) != 0;
            case 15:
                return zzrf.zzc(obj, j2) != 0;
            case 16:
                return zzrf.zzd(obj, j2) != 0;
            case 17:
                return zzrf.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzN(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzM(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzO(Object obj, int i, zzqe zzqeVar) {
        return zzqeVar.zzj(zzrf.zzf(obj, i & 1048575));
    }

    private final boolean zzP(Object obj, int i, int i2) {
        return zzrf.zzc(obj, (long) (zzy(i2) & 1048575)) == i;
    }

    private static boolean zzQ(Object obj, long j) {
        return ((Boolean) zzrf.zzf(obj, j)).booleanValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzR(java.lang.Object r17, com.google.android.gms.internal.mlkit_vision_face_bundled.zznu r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzpv.zzR(java.lang.Object, com.google.android.gms.internal.mlkit_vision_face_bundled.zznu):void");
    }

    private final void zzS(zznu zznuVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private static final void zzT(int i, Object obj, zznu zznuVar) throws IOException {
        if (obj instanceof String) {
            zznuVar.zzG(i, (String) obj);
        } else {
            zznuVar.zzd(i, (zznl) obj);
        }
    }

    public static zzqw zzd(Object obj) {
        zzon zzonVar = (zzon) obj;
        zzqw zzqwVar = zzonVar.zzc;
        if (zzqwVar != zzqw.zzc()) {
            return zzqwVar;
        }
        zzqw zzqwVarZze = zzqw.zze();
        zzonVar.zzc = zzqwVarZze;
        return zzqwVarZze;
    }

    public static zzpv zzk(Class cls, zzpp zzppVar, zzpy zzpyVar, zzpg zzpgVar, zzqv zzqvVar, zznz zznzVar, zzpn zzpnVar) {
        if (zzppVar instanceof zzqd) {
            return zzl((zzqd) zzppVar, zzpyVar, zzpgVar, zzqvVar, zznzVar, zzpnVar);
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0379  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.mlkit_vision_face_bundled.zzpv zzl(com.google.android.gms.internal.mlkit_vision_face_bundled.zzqd r34, com.google.android.gms.internal.mlkit_vision_face_bundled.zzpy r35, com.google.android.gms.internal.mlkit_vision_face_bundled.zzpg r36, com.google.android.gms.internal.mlkit_vision_face_bundled.zzqv r37, com.google.android.gms.internal.mlkit_vision_face_bundled.zznz r38, com.google.android.gms.internal.mlkit_vision_face_bundled.zzpn r39) {
        /*
            Method dump skipped, instructions count: 1016
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzpv.zzl(com.google.android.gms.internal.mlkit_vision_face_bundled.zzqd, com.google.android.gms.internal.mlkit_vision_face_bundled.zzpy, com.google.android.gms.internal.mlkit_vision_face_bundled.zzpg, com.google.android.gms.internal.mlkit_vision_face_bundled.zzqv, com.google.android.gms.internal.mlkit_vision_face_bundled.zznz, com.google.android.gms.internal.mlkit_vision_face_bundled.zzpn):com.google.android.gms.internal.mlkit_vision_face_bundled.zzpv");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzrf.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzrf.zzf(obj, j)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzp(Object obj) {
        int i;
        int iZzD;
        int iZzD2;
        int iZzD3;
        int iZzE;
        int iZzD4;
        int iZzx;
        int iZzD5;
        int iZzD6;
        int iZzd;
        int iZzD7;
        int i2;
        int iZzu;
        boolean z;
        int iZzd2;
        int iZzi;
        int iZzC;
        int iZzD8;
        int iZzD9;
        int iZzD10;
        int iZzD11;
        int iZzD12;
        int iZzE2;
        int iZzD13;
        int iZzd3;
        int iZzD14;
        int i3;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int iZzD15 = 0;
        int i7 = 0;
        while (i6 < this.zzc.length) {
            int iZzB = zzB(i6);
            int[] iArr = this.zzc;
            int i8 = iArr[i6];
            int iZzA = zzA(iZzB);
            if (iZzA <= 17) {
                int i9 = iArr[i6 + 2];
                int i10 = i9 & i4;
                i = 1 << (i9 >>> 20);
                if (i10 != i5) {
                    i7 = unsafe.getInt(obj, i10);
                    i5 = i10;
                }
            } else {
                i = 0;
            }
            long j = iZzB & i4;
            switch (iZzA) {
                case 0:
                    if ((i7 & i) != 0) {
                        iZzD = zznt.zzD(i8 << 3);
                        iZzD5 = iZzD + 8;
                        iZzD15 += iZzD5;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i7 & i) != 0) {
                        iZzD2 = zznt.zzD(i8 << 3);
                        iZzD5 = iZzD2 + 4;
                        iZzD15 += iZzD5;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i7 & i) != 0) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzD3 = zznt.zzD(i8 << 3);
                        iZzE = zznt.zzE(j2);
                        iZzD15 += iZzD3 + iZzE;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i7 & i) != 0) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzD3 = zznt.zzD(i8 << 3);
                        iZzE = zznt.zzE(j3);
                        iZzD15 += iZzD3 + iZzE;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i7 & i) != 0) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzD4 = zznt.zzD(i8 << 3);
                        iZzx = zznt.zzx(i11);
                        i2 = iZzD4 + iZzx;
                        iZzD15 += i2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i7 & i) != 0) {
                        iZzD = zznt.zzD(i8 << 3);
                        iZzD5 = iZzD + 8;
                        iZzD15 += iZzD5;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i7 & i) != 0) {
                        iZzD2 = zznt.zzD(i8 << 3);
                        iZzD5 = iZzD2 + 4;
                        iZzD15 += iZzD5;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i7 & i) != 0) {
                        iZzD5 = zznt.zzD(i8 << 3) + 1;
                        iZzD15 += iZzD5;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i7 & i) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zznl) {
                            iZzD6 = zznt.zzD(i8 << 3);
                            iZzd = ((zznl) object).zzd();
                            iZzD7 = zznt.zzD(iZzd);
                            i2 = iZzD6 + iZzD7 + iZzd;
                            iZzD15 += i2;
                            break;
                        } else {
                            iZzD4 = zznt.zzD(i8 << 3);
                            iZzx = zznt.zzB((String) object);
                            i2 = iZzD4 + iZzx;
                            iZzD15 += i2;
                        }
                    }
                case 9:
                    if ((i7 & i) != 0) {
                        iZzD5 = zzqg.zzo(i8, unsafe.getObject(obj, j), zzE(i6));
                        iZzD15 += iZzD5;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i7 & i) != 0) {
                        zznl zznlVar = (zznl) unsafe.getObject(obj, j);
                        iZzD6 = zznt.zzD(i8 << 3);
                        iZzd = zznlVar.zzd();
                        iZzD7 = zznt.zzD(iZzd);
                        i2 = iZzD6 + iZzD7 + iZzd;
                        iZzD15 += i2;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i7 & i) != 0) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzD4 = zznt.zzD(i8 << 3);
                        iZzx = zznt.zzD(i12);
                        i2 = iZzD4 + iZzx;
                        iZzD15 += i2;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i7 & i) != 0) {
                        int i13 = unsafe.getInt(obj, j);
                        iZzD4 = zznt.zzD(i8 << 3);
                        iZzx = zznt.zzx(i13);
                        i2 = iZzD4 + iZzx;
                        iZzD15 += i2;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i7 & i) != 0) {
                        iZzD2 = zznt.zzD(i8 << 3);
                        iZzD5 = iZzD2 + 4;
                        iZzD15 += iZzD5;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i7 & i) != 0) {
                        iZzD = zznt.zzD(i8 << 3);
                        iZzD5 = iZzD + 8;
                        iZzD15 += iZzD5;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i7 & i) != 0) {
                        int i14 = unsafe.getInt(obj, j);
                        iZzD4 = zznt.zzD(i8 << 3);
                        iZzx = zznt.zzD((i14 >> 31) ^ (i14 + i14));
                        i2 = iZzD4 + iZzx;
                        iZzD15 += i2;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i & i7) != 0) {
                        long j4 = unsafe.getLong(obj, j);
                        iZzD15 += zznt.zzD(i8 << 3) + zznt.zzE((j4 >> 63) ^ (j4 + j4));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i7 & i) != 0) {
                        iZzD5 = zznt.zzv(i8, (zzps) unsafe.getObject(obj, j), zzE(i6));
                        iZzD15 += iZzD5;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iZzD5 = zzqg.zzh(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 19:
                    iZzD5 = zzqg.zzf(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 20:
                    iZzD5 = zzqg.zzm(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 21:
                    iZzD5 = zzqg.zzx(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 22:
                    iZzD5 = zzqg.zzk(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 23:
                    iZzD5 = zzqg.zzh(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 24:
                    iZzD5 = zzqg.zzf(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 25:
                    iZzD5 = zzqg.zza(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzD5;
                    break;
                case 26:
                    iZzu = zzqg.zzu(i8, (List) unsafe.getObject(obj, j));
                    iZzD15 += iZzu;
                    break;
                case 27:
                    iZzu = zzqg.zzp(i8, (List) unsafe.getObject(obj, j), zzE(i6));
                    iZzD15 += iZzu;
                    break;
                case 28:
                    iZzu = zzqg.zzc(i8, (List) unsafe.getObject(obj, j));
                    iZzD15 += iZzu;
                    break;
                case 29:
                    iZzu = zzqg.zzv(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzu;
                    break;
                case 30:
                    z = false;
                    iZzd2 = zzqg.zzd(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzd2;
                    break;
                case 31:
                    z = false;
                    iZzd2 = zzqg.zzf(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzd2;
                    break;
                case 32:
                    z = false;
                    iZzd2 = zzqg.zzh(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzd2;
                    break;
                case 33:
                    z = false;
                    iZzd2 = zzqg.zzq(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzd2;
                    break;
                case 34:
                    z = false;
                    iZzd2 = zzqg.zzs(i8, (List) unsafe.getObject(obj, j), false);
                    iZzD15 += iZzd2;
                    break;
                case 35:
                    iZzi = zzqg.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 36:
                    iZzi = zzqg.zzg((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 37:
                    iZzi = zzqg.zzn((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 38:
                    iZzi = zzqg.zzy((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 39:
                    iZzi = zzqg.zzl((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 40:
                    iZzi = zzqg.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 41:
                    iZzi = zzqg.zzg((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 42:
                    iZzi = zzqg.zzb((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 43:
                    iZzi = zzqg.zzw((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 44:
                    iZzi = zzqg.zze((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 45:
                    iZzi = zzqg.zzg((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 46:
                    iZzi = zzqg.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 47:
                    iZzi = zzqg.zzr((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 48:
                    iZzi = zzqg.zzt((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzC = zznt.zzC(i8);
                        iZzD8 = zznt.zzD(iZzi);
                        iZzD9 = iZzC + iZzD8;
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 49:
                    iZzu = zzqg.zzj(i8, (List) unsafe.getObject(obj, j), zzE(i6));
                    iZzD15 += iZzu;
                    break;
                case 50:
                    zzpn.zza(i8, unsafe.getObject(obj, j), zzF(i6));
                    break;
                case 51:
                    if (zzP(obj, i8, i6)) {
                        iZzD10 = zznt.zzD(i8 << 3);
                        iZzu = iZzD10 + 8;
                        iZzD15 += iZzu;
                    }
                    break;
                case 52:
                    if (zzP(obj, i8, i6)) {
                        iZzD11 = zznt.zzD(i8 << 3);
                        iZzu = iZzD11 + 4;
                        iZzD15 += iZzu;
                    }
                    break;
                case 53:
                    if (zzP(obj, i8, i6)) {
                        long jZzC = zzC(obj, j);
                        iZzD12 = zznt.zzD(i8 << 3);
                        iZzE2 = zznt.zzE(jZzC);
                        iZzD15 += iZzD12 + iZzE2;
                    }
                    break;
                case 54:
                    if (zzP(obj, i8, i6)) {
                        long jZzC2 = zzC(obj, j);
                        iZzD12 = zznt.zzD(i8 << 3);
                        iZzE2 = zznt.zzE(jZzC2);
                        iZzD15 += iZzD12 + iZzE2;
                    }
                    break;
                case 55:
                    if (zzP(obj, i8, i6)) {
                        int iZzr = zzr(obj, j);
                        iZzD9 = zznt.zzD(i8 << 3);
                        iZzi = zznt.zzx(iZzr);
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 56:
                    if (zzP(obj, i8, i6)) {
                        iZzD10 = zznt.zzD(i8 << 3);
                        iZzu = iZzD10 + 8;
                        iZzD15 += iZzu;
                    }
                    break;
                case 57:
                    if (zzP(obj, i8, i6)) {
                        iZzD11 = zznt.zzD(i8 << 3);
                        iZzu = iZzD11 + 4;
                        iZzD15 += iZzu;
                    }
                    break;
                case 58:
                    if (zzP(obj, i8, i6)) {
                        iZzu = zznt.zzD(i8 << 3) + 1;
                        iZzD15 += iZzu;
                    }
                    break;
                case 59:
                    if (zzP(obj, i8, i6)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zznl) {
                            iZzD13 = zznt.zzD(i8 << 3);
                            iZzd3 = ((zznl) object2).zzd();
                            iZzD14 = zznt.zzD(iZzd3);
                            i3 = iZzD13 + iZzD14 + iZzd3;
                            iZzD15 += i3;
                        } else {
                            iZzD9 = zznt.zzD(i8 << 3);
                            iZzi = zznt.zzB((String) object2);
                            i3 = iZzD9 + iZzi;
                            iZzD15 += i3;
                        }
                    }
                    break;
                case 60:
                    if (zzP(obj, i8, i6)) {
                        iZzu = zzqg.zzo(i8, unsafe.getObject(obj, j), zzE(i6));
                        iZzD15 += iZzu;
                    }
                    break;
                case 61:
                    if (zzP(obj, i8, i6)) {
                        zznl zznlVar2 = (zznl) unsafe.getObject(obj, j);
                        iZzD13 = zznt.zzD(i8 << 3);
                        iZzd3 = zznlVar2.zzd();
                        iZzD14 = zznt.zzD(iZzd3);
                        i3 = iZzD13 + iZzD14 + iZzd3;
                        iZzD15 += i3;
                    }
                    break;
                case 62:
                    if (zzP(obj, i8, i6)) {
                        int iZzr2 = zzr(obj, j);
                        iZzD9 = zznt.zzD(i8 << 3);
                        iZzi = zznt.zzD(iZzr2);
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 63:
                    if (zzP(obj, i8, i6)) {
                        int iZzr3 = zzr(obj, j);
                        iZzD9 = zznt.zzD(i8 << 3);
                        iZzi = zznt.zzx(iZzr3);
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 64:
                    if (zzP(obj, i8, i6)) {
                        iZzD11 = zznt.zzD(i8 << 3);
                        iZzu = iZzD11 + 4;
                        iZzD15 += iZzu;
                    }
                    break;
                case 65:
                    if (zzP(obj, i8, i6)) {
                        iZzD10 = zznt.zzD(i8 << 3);
                        iZzu = iZzD10 + 8;
                        iZzD15 += iZzu;
                    }
                    break;
                case 66:
                    if (zzP(obj, i8, i6)) {
                        int iZzr4 = zzr(obj, j);
                        iZzD9 = zznt.zzD(i8 << 3);
                        iZzi = zznt.zzD((iZzr4 >> 31) ^ (iZzr4 + iZzr4));
                        i3 = iZzD9 + iZzi;
                        iZzD15 += i3;
                    }
                    break;
                case 67:
                    if (zzP(obj, i8, i6)) {
                        long jZzC3 = zzC(obj, j);
                        iZzD15 += zznt.zzD(i8 << 3) + zznt.zzE((jZzC3 >> 63) ^ (jZzC3 + jZzC3));
                    }
                    break;
                case 68:
                    if (zzP(obj, i8, i6)) {
                        iZzu = zznt.zzv(i8, (zzps) unsafe.getObject(obj, j), zzE(i6));
                        iZzD15 += iZzu;
                    }
                    break;
            }
            i6 += 3;
            i4 = 1048575;
        }
        int iZza = 0;
        zzqv zzqvVar = this.zzn;
        int iZza2 = iZzD15 + zzqvVar.zza(zzqvVar.zzc(obj));
        if (!this.zzh) {
            return iZza2;
        }
        zzod zzodVarZzb = this.zzo.zzb(obj);
        for (int i15 = 0; i15 < zzodVarZzb.zza.zzb(); i15++) {
            Map.Entry entryZzg = zzodVarZzb.zza.zzg(i15);
            iZza += zzod.zza((zzoc) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : zzodVarZzb.zza.zzc()) {
            iZza += zzod.zza((zzoc) entry.getKey(), entry.getValue());
        }
        return iZza2 + iZza;
    }

    private final int zzq(Object obj) {
        int iZzD;
        int iZzD2;
        int iZzD3;
        int iZzE;
        int iZzD4;
        int iZzx;
        int iZzD5;
        int iZzD6;
        int iZzd;
        int iZzD7;
        int iZzo;
        int iZzC;
        int iZzD8;
        int i;
        Unsafe unsafe = zzb;
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int iZzB = zzB(i3);
            int iZzA = zzA(iZzB);
            int i4 = this.zzc[i3];
            long j = iZzB & 1048575;
            if (iZzA >= zzoe.zzJ.zza() && iZzA <= zzoe.zzW.zza()) {
                int i5 = this.zzc[i3 + 2];
            }
            switch (iZzA) {
                case 0:
                    if (zzM(obj, i3)) {
                        iZzD = zznt.zzD(i4 << 3);
                        iZzo = iZzD + 8;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzM(obj, i3)) {
                        iZzD2 = zznt.zzD(i4 << 3);
                        iZzo = iZzD2 + 4;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzM(obj, i3)) {
                        long jZzd = zzrf.zzd(obj, j);
                        iZzD3 = zznt.zzD(i4 << 3);
                        iZzE = zznt.zzE(jZzd);
                        i2 += iZzD3 + iZzE;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzM(obj, i3)) {
                        long jZzd2 = zzrf.zzd(obj, j);
                        iZzD3 = zznt.zzD(i4 << 3);
                        iZzE = zznt.zzE(jZzd2);
                        i2 += iZzD3 + iZzE;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzM(obj, i3)) {
                        int iZzc = zzrf.zzc(obj, j);
                        iZzD4 = zznt.zzD(i4 << 3);
                        iZzx = zznt.zzx(iZzc);
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzM(obj, i3)) {
                        iZzD = zznt.zzD(i4 << 3);
                        iZzo = iZzD + 8;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzM(obj, i3)) {
                        iZzD2 = zznt.zzD(i4 << 3);
                        iZzo = iZzD2 + 4;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzM(obj, i3)) {
                        iZzD5 = zznt.zzD(i4 << 3);
                        iZzo = iZzD5 + 1;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zzM(obj, i3)) {
                        break;
                    } else {
                        Object objZzf = zzrf.zzf(obj, j);
                        if (objZzf instanceof zznl) {
                            iZzD6 = zznt.zzD(i4 << 3);
                            iZzd = ((zznl) objZzf).zzd();
                            iZzD7 = zznt.zzD(iZzd);
                            i = iZzD6 + iZzD7 + iZzd;
                            i2 += i;
                            break;
                        } else {
                            iZzD4 = zznt.zzD(i4 << 3);
                            iZzx = zznt.zzB((String) objZzf);
                            i = iZzD4 + iZzx;
                            i2 += i;
                        }
                    }
                case 9:
                    if (zzM(obj, i3)) {
                        iZzo = zzqg.zzo(i4, zzrf.zzf(obj, j), zzE(i3));
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzM(obj, i3)) {
                        zznl zznlVar = (zznl) zzrf.zzf(obj, j);
                        iZzD6 = zznt.zzD(i4 << 3);
                        iZzd = zznlVar.zzd();
                        iZzD7 = zznt.zzD(iZzd);
                        i = iZzD6 + iZzD7 + iZzd;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzM(obj, i3)) {
                        int iZzc2 = zzrf.zzc(obj, j);
                        iZzD4 = zznt.zzD(i4 << 3);
                        iZzx = zznt.zzD(iZzc2);
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzM(obj, i3)) {
                        int iZzc3 = zzrf.zzc(obj, j);
                        iZzD4 = zznt.zzD(i4 << 3);
                        iZzx = zznt.zzx(iZzc3);
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzM(obj, i3)) {
                        iZzD2 = zznt.zzD(i4 << 3);
                        iZzo = iZzD2 + 4;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzM(obj, i3)) {
                        iZzD = zznt.zzD(i4 << 3);
                        iZzo = iZzD + 8;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzM(obj, i3)) {
                        int iZzc4 = zzrf.zzc(obj, j);
                        iZzD4 = zznt.zzD(i4 << 3);
                        iZzx = zznt.zzD((iZzc4 >> 31) ^ (iZzc4 + iZzc4));
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzM(obj, i3)) {
                        long jZzd3 = zzrf.zzd(obj, j);
                        iZzD4 = zznt.zzD(i4 << 3);
                        iZzx = zznt.zzE((jZzd3 >> 63) ^ (jZzd3 + jZzd3));
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzM(obj, i3)) {
                        iZzo = zznt.zzv(i4, (zzps) zzrf.zzf(obj, j), zzE(i3));
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iZzo = zzqg.zzh(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 19:
                    iZzo = zzqg.zzf(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 20:
                    iZzo = zzqg.zzm(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 21:
                    iZzo = zzqg.zzx(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 22:
                    iZzo = zzqg.zzk(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 23:
                    iZzo = zzqg.zzh(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 24:
                    iZzo = zzqg.zzf(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 25:
                    iZzo = zzqg.zza(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 26:
                    iZzo = zzqg.zzu(i4, (List) zzrf.zzf(obj, j));
                    i2 += iZzo;
                    break;
                case 27:
                    iZzo = zzqg.zzp(i4, (List) zzrf.zzf(obj, j), zzE(i3));
                    i2 += iZzo;
                    break;
                case 28:
                    iZzo = zzqg.zzc(i4, (List) zzrf.zzf(obj, j));
                    i2 += iZzo;
                    break;
                case 29:
                    iZzo = zzqg.zzv(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 30:
                    iZzo = zzqg.zzd(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 31:
                    iZzo = zzqg.zzf(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 32:
                    iZzo = zzqg.zzh(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 33:
                    iZzo = zzqg.zzq(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 34:
                    iZzo = zzqg.zzs(i4, (List) zzrf.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 35:
                    iZzx = zzqg.zzi((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    iZzx = zzqg.zzg((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    iZzx = zzqg.zzn((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    iZzx = zzqg.zzy((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    iZzx = zzqg.zzl((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    iZzx = zzqg.zzi((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    iZzx = zzqg.zzg((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    iZzx = zzqg.zzb((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    iZzx = zzqg.zzw((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    iZzx = zzqg.zze((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    iZzx = zzqg.zzg((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    iZzx = zzqg.zzi((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    iZzx = zzqg.zzr((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    iZzx = zzqg.zzt((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzC = zznt.zzC(i4);
                        iZzD8 = zznt.zzD(iZzx);
                        iZzD4 = iZzC + iZzD8;
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    iZzo = zzqg.zzj(i4, (List) zzrf.zzf(obj, j), zzE(i3));
                    i2 += iZzo;
                    break;
                case 50:
                    zzpn.zza(i4, zzrf.zzf(obj, j), zzF(i3));
                    break;
                case 51:
                    if (zzP(obj, i4, i3)) {
                        iZzD = zznt.zzD(i4 << 3);
                        iZzo = iZzD + 8;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzP(obj, i4, i3)) {
                        iZzD2 = zznt.zzD(i4 << 3);
                        iZzo = iZzD2 + 4;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzP(obj, i4, i3)) {
                        long jZzC = zzC(obj, j);
                        iZzD3 = zznt.zzD(i4 << 3);
                        iZzE = zznt.zzE(jZzC);
                        i2 += iZzD3 + iZzE;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzP(obj, i4, i3)) {
                        long jZzC2 = zzC(obj, j);
                        iZzD3 = zznt.zzD(i4 << 3);
                        iZzE = zznt.zzE(jZzC2);
                        i2 += iZzD3 + iZzE;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzP(obj, i4, i3)) {
                        int iZzr = zzr(obj, j);
                        iZzD4 = zznt.zzD(i4 << 3);
                        iZzx = zznt.zzx(iZzr);
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzP(obj, i4, i3)) {
                        iZzD = zznt.zzD(i4 << 3);
                        iZzo = iZzD + 8;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzP(obj, i4, i3)) {
                        iZzD2 = zznt.zzD(i4 << 3);
                        iZzo = iZzD2 + 4;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzP(obj, i4, i3)) {
                        iZzD5 = zznt.zzD(i4 << 3);
                        iZzo = iZzD5 + 1;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zzP(obj, i4, i3)) {
                        break;
                    } else {
                        Object objZzf2 = zzrf.zzf(obj, j);
                        if (objZzf2 instanceof zznl) {
                            iZzD6 = zznt.zzD(i4 << 3);
                            iZzd = ((zznl) objZzf2).zzd();
                            iZzD7 = zznt.zzD(iZzd);
                            i = iZzD6 + iZzD7 + iZzd;
                            i2 += i;
                            break;
                        } else {
                            iZzD4 = zznt.zzD(i4 << 3);
                            iZzx = zznt.zzB((String) objZzf2);
                            i = iZzD4 + iZzx;
                            i2 += i;
                        }
                    }
                case 60:
                    if (zzP(obj, i4, i3)) {
                        iZzo = zzqg.zzo(i4, zzrf.zzf(obj, j), zzE(i3));
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzP(obj, i4, i3)) {
                        zznl zznlVar2 = (zznl) zzrf.zzf(obj, j);
                        iZzD6 = zznt.zzD(i4 << 3);
                        iZzd = zznlVar2.zzd();
                        iZzD7 = zznt.zzD(iZzd);
                        i = iZzD6 + iZzD7 + iZzd;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzP(obj, i4, i3)) {
                        int iZzr2 = zzr(obj, j);
                        iZzD4 = zznt.zzD(i4 << 3);
                        iZzx = zznt.zzD(iZzr2);
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzP(obj, i4, i3)) {
                        int iZzr3 = zzr(obj, j);
                        iZzD4 = zznt.zzD(i4 << 3);
                        iZzx = zznt.zzx(iZzr3);
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzP(obj, i4, i3)) {
                        iZzD2 = zznt.zzD(i4 << 3);
                        iZzo = iZzD2 + 4;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzP(obj, i4, i3)) {
                        iZzD = zznt.zzD(i4 << 3);
                        iZzo = iZzD + 8;
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzP(obj, i4, i3)) {
                        int iZzr4 = zzr(obj, j);
                        iZzD4 = zznt.zzD(i4 << 3);
                        iZzx = zznt.zzD((iZzr4 >> 31) ^ (iZzr4 + iZzr4));
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzP(obj, i4, i3)) {
                        long jZzC3 = zzC(obj, j);
                        iZzD4 = zznt.zzD(i4 << 3);
                        iZzx = zznt.zzE((jZzC3 >> 63) ^ (jZzC3 + jZzC3));
                        i = iZzD4 + iZzx;
                        i2 += i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzP(obj, i4, i3)) {
                        iZzo = zznt.zzv(i4, (zzps) zzrf.zzf(obj, j), zzE(i3));
                        i2 += iZzo;
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzqv zzqvVar = this.zzn;
        return i2 + zzqvVar.zza(zzqvVar.zzc(obj));
    }

    private static int zzr(Object obj, long j) {
        return ((Integer) zzrf.zzf(obj, j)).intValue();
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzmx zzmxVar) throws IOException {
        Unsafe unsafe = zzb;
        Object objZzF = zzF(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzpm) object).zze()) {
            zzpm zzpmVarZzb = zzpm.zza().zzb();
            zzpn.zzb(zzpmVarZzb, object);
            unsafe.putObject(obj, j, zzpmVarZzb);
        }
        throw null;
    }

    private final int zzt(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzmx zzmxVar) throws IOException {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzmy.zzo(bArr, i))));
                    unsafe.putInt(obj, j2, i4);
                    return i + 8;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzmy.zzb(bArr, i))));
                    unsafe.putInt(obj, j2, i4);
                    return i + 4;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int iZzm = zzmy.zzm(bArr, i, zzmxVar);
                    unsafe.putObject(obj, j, Long.valueOf(zzmxVar.zzb));
                    unsafe.putInt(obj, j2, i4);
                    return iZzm;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int iZzj = zzmy.zzj(bArr, i, zzmxVar);
                    unsafe.putObject(obj, j, Integer.valueOf(zzmxVar.zza));
                    unsafe.putInt(obj, j2, i4);
                    return iZzj;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Long.valueOf(zzmy.zzo(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 8;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Integer.valueOf(zzmy.zzb(bArr, i)));
                    unsafe.putInt(obj, j2, i4);
                    return i + 4;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int iZzm2 = zzmy.zzm(bArr, i, zzmxVar);
                    unsafe.putObject(obj, j, Boolean.valueOf(zzmxVar.zzb != 0));
                    unsafe.putInt(obj, j2, i4);
                    return iZzm2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int iZzj2 = zzmy.zzj(bArr, i, zzmxVar);
                    int i9 = zzmxVar.zza;
                    if (i9 == 0) {
                        unsafe.putObject(obj, j, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !zzrk.zzf(bArr, iZzj2, iZzj2 + i9)) {
                            throw zzov.zzc();
                        }
                        unsafe.putObject(obj, j, new String(bArr, iZzj2, i9, zzot.zzb));
                        iZzj2 += i9;
                    }
                    unsafe.putInt(obj, j2, i4);
                    return iZzj2;
                }
                break;
            case 60:
                if (i5 == 2) {
                    int iZzd = zzmy.zzd(zzE(i8), bArr, i, i2, zzmxVar);
                    Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    if (object == null) {
                        unsafe.putObject(obj, j, zzmxVar.zzc);
                    } else {
                        unsafe.putObject(obj, j, zzot.zzg(object, zzmxVar.zzc));
                    }
                    unsafe.putInt(obj, j2, i4);
                    return iZzd;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int iZza = zzmy.zza(bArr, i, zzmxVar);
                    unsafe.putObject(obj, j, zzmxVar.zzc);
                    unsafe.putInt(obj, j2, i4);
                    return iZza;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int iZzj3 = zzmy.zzj(bArr, i, zzmxVar);
                    int i10 = zzmxVar.zza;
                    zzor zzorVarZzD = zzD(i8);
                    if (zzorVarZzD == null || zzorVarZzD.zza(i10)) {
                        unsafe.putObject(obj, j, Integer.valueOf(i10));
                        unsafe.putInt(obj, j2, i4);
                    } else {
                        zzd(obj).zzh(i3, Long.valueOf(i10));
                    }
                    return iZzj3;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int iZzj4 = zzmy.zzj(bArr, i, zzmxVar);
                    unsafe.putObject(obj, j, Integer.valueOf(zznp.zzb(zzmxVar.zza)));
                    unsafe.putInt(obj, j2, i4);
                    return iZzj4;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int iZzm3 = zzmy.zzm(bArr, i, zzmxVar);
                    unsafe.putObject(obj, j, Long.valueOf(zznp.zzc(zzmxVar.zzb)));
                    unsafe.putInt(obj, j2, i4);
                    return iZzm3;
                }
                break;
            case 68:
                if (i5 == 3) {
                    int iZzc = zzmy.zzc(zzE(i8), bArr, i, i2, (i3 & (-8)) | 4, zzmxVar);
                    Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj, j, zzmxVar.zzc);
                    } else {
                        unsafe.putObject(obj, j, zzot.zzg(object2, zzmxVar.zzc));
                    }
                    unsafe.putInt(obj, j2, i4);
                    return iZzc;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x02d9, code lost:
    
        if (r0 != r5) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02db, code lost:
    
        r15 = r31;
        r14 = r32;
        r12 = r33;
        r13 = r35;
        r11 = r36;
        r10 = r19;
        r1 = r20;
        r2 = r23;
        r6 = r26;
        r7 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02f1, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0322, code lost:
    
        if (r0 != r15) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0345, code lost:
    
        if (r0 != r15) goto L102;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x008f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v9, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzu(java.lang.Object r32, byte[] r33, int r34, int r35, com.google.android.gms.internal.mlkit_vision_face_bundled.zzmx r36) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 944
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzpv.zzu(java.lang.Object, byte[], int, int, com.google.android.gms.internal.mlkit_vision_face_bundled.zzmx):int");
    }

    private final int zzv(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzmx zzmxVar) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzj;
        int iZzj2 = i;
        Unsafe unsafe = zzb;
        zzos zzosVarZzd = (zzos) unsafe.getObject(obj, j2);
        if (!zzosVarZzd.zzc()) {
            int size = zzosVarZzd.size();
            zzosVarZzd = zzosVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, zzosVarZzd);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zznv zznvVar = (zznv) zzosVarZzd;
                    int iZzj3 = zzmy.zzj(bArr, iZzj2, zzmxVar);
                    int i12 = zzmxVar.zza + iZzj3;
                    while (iZzj3 < i12) {
                        zznvVar.zze(Double.longBitsToDouble(zzmy.zzo(bArr, iZzj3)));
                        iZzj3 += 8;
                    }
                    if (iZzj3 == i12) {
                        return iZzj3;
                    }
                    throw zzov.zzg();
                }
                if (i5 == 1) {
                    zznv zznvVar2 = (zznv) zzosVarZzd;
                    zznvVar2.zze(Double.longBitsToDouble(zzmy.zzo(bArr, i)));
                    while (true) {
                        i8 = iZzj2 + 8;
                        if (i8 < i2) {
                            iZzj2 = zzmy.zzj(bArr, i8, zzmxVar);
                            if (i3 == zzmxVar.zza) {
                                zznvVar2.zze(Double.longBitsToDouble(zzmy.zzo(bArr, iZzj2)));
                            }
                        }
                    }
                    return i8;
                }
                return iZzj2;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzof zzofVar = (zzof) zzosVarZzd;
                    int iZzj4 = zzmy.zzj(bArr, iZzj2, zzmxVar);
                    int i13 = zzmxVar.zza + iZzj4;
                    while (iZzj4 < i13) {
                        zzofVar.zze(Float.intBitsToFloat(zzmy.zzb(bArr, iZzj4)));
                        iZzj4 += 4;
                    }
                    if (iZzj4 == i13) {
                        return iZzj4;
                    }
                    throw zzov.zzg();
                }
                if (i5 == 5) {
                    zzof zzofVar2 = (zzof) zzosVarZzd;
                    zzofVar2.zze(Float.intBitsToFloat(zzmy.zzb(bArr, i)));
                    while (true) {
                        i9 = iZzj2 + 4;
                        if (i9 < i2) {
                            iZzj2 = zzmy.zzj(bArr, i9, zzmxVar);
                            if (i3 == zzmxVar.zza) {
                                zzofVar2.zze(Float.intBitsToFloat(zzmy.zzb(bArr, iZzj2)));
                            }
                        }
                    }
                    return i9;
                }
                return iZzj2;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzph zzphVar = (zzph) zzosVarZzd;
                    int iZzj5 = zzmy.zzj(bArr, iZzj2, zzmxVar);
                    int i14 = zzmxVar.zza + iZzj5;
                    while (iZzj5 < i14) {
                        iZzj5 = zzmy.zzm(bArr, iZzj5, zzmxVar);
                        zzphVar.zzf(zzmxVar.zzb);
                    }
                    if (iZzj5 == i14) {
                        return iZzj5;
                    }
                    throw zzov.zzg();
                }
                if (i5 == 0) {
                    zzph zzphVar2 = (zzph) zzosVarZzd;
                    int iZzm = zzmy.zzm(bArr, iZzj2, zzmxVar);
                    zzphVar2.zzf(zzmxVar.zzb);
                    while (iZzm < i2) {
                        int iZzj6 = zzmy.zzj(bArr, iZzm, zzmxVar);
                        if (i3 != zzmxVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzmy.zzm(bArr, iZzj6, zzmxVar);
                        zzphVar2.zzf(zzmxVar.zzb);
                    }
                    return iZzm;
                }
                return iZzj2;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzmy.zzf(bArr, iZzj2, zzosVarZzd, zzmxVar);
                }
                if (i5 == 0) {
                    return zzmy.zzl(i3, bArr, i, i2, zzosVarZzd, zzmxVar);
                }
                return iZzj2;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzph zzphVar3 = (zzph) zzosVarZzd;
                    int iZzj7 = zzmy.zzj(bArr, iZzj2, zzmxVar);
                    int i15 = zzmxVar.zza + iZzj7;
                    while (iZzj7 < i15) {
                        zzphVar3.zzf(zzmy.zzo(bArr, iZzj7));
                        iZzj7 += 8;
                    }
                    if (iZzj7 == i15) {
                        return iZzj7;
                    }
                    throw zzov.zzg();
                }
                if (i5 == 1) {
                    zzph zzphVar4 = (zzph) zzosVarZzd;
                    zzphVar4.zzf(zzmy.zzo(bArr, i));
                    while (true) {
                        i10 = iZzj2 + 8;
                        if (i10 < i2) {
                            iZzj2 = zzmy.zzj(bArr, i10, zzmxVar);
                            if (i3 == zzmxVar.zza) {
                                zzphVar4.zzf(zzmy.zzo(bArr, iZzj2));
                            }
                        }
                    }
                    return i10;
                }
                return iZzj2;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzoo zzooVar = (zzoo) zzosVarZzd;
                    int iZzj8 = zzmy.zzj(bArr, iZzj2, zzmxVar);
                    int i16 = zzmxVar.zza + iZzj8;
                    while (iZzj8 < i16) {
                        zzooVar.zzf(zzmy.zzb(bArr, iZzj8));
                        iZzj8 += 4;
                    }
                    if (iZzj8 == i16) {
                        return iZzj8;
                    }
                    throw zzov.zzg();
                }
                if (i5 == 5) {
                    zzoo zzooVar2 = (zzoo) zzosVarZzd;
                    zzooVar2.zzf(zzmy.zzb(bArr, i));
                    while (true) {
                        i11 = iZzj2 + 4;
                        if (i11 < i2) {
                            iZzj2 = zzmy.zzj(bArr, i11, zzmxVar);
                            if (i3 == zzmxVar.zza) {
                                zzooVar2.zzf(zzmy.zzb(bArr, iZzj2));
                            }
                        }
                    }
                    return i11;
                }
                return iZzj2;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzmz zzmzVar = (zzmz) zzosVarZzd;
                    iZzj = zzmy.zzj(bArr, iZzj2, zzmxVar);
                    int i17 = zzmxVar.zza + iZzj;
                    while (iZzj < i17) {
                        iZzj = zzmy.zzm(bArr, iZzj, zzmxVar);
                        zzmzVar.zze(zzmxVar.zzb != 0);
                    }
                    if (iZzj != i17) {
                        throw zzov.zzg();
                    }
                    return iZzj;
                }
                if (i5 == 0) {
                    zzmz zzmzVar2 = (zzmz) zzosVarZzd;
                    int iZzm2 = zzmy.zzm(bArr, iZzj2, zzmxVar);
                    zzmzVar2.zze(zzmxVar.zzb != 0);
                    while (iZzm2 < i2) {
                        int iZzj9 = zzmy.zzj(bArr, iZzm2, zzmxVar);
                        if (i3 != zzmxVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzmy.zzm(bArr, iZzj9, zzmxVar);
                        zzmzVar2.zze(zzmxVar.zzb != 0);
                    }
                    return iZzm2;
                }
                return iZzj2;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZzj10 = zzmy.zzj(bArr, iZzj2, zzmxVar);
                        int i18 = zzmxVar.zza;
                        if (i18 < 0) {
                            throw zzov.zzd();
                        }
                        if (i18 == 0) {
                            zzosVarZzd.add("");
                        } else {
                            zzosVarZzd.add(new String(bArr, iZzj10, i18, zzot.zzb));
                            iZzj10 += i18;
                        }
                        while (iZzj10 < i2) {
                            int iZzj11 = zzmy.zzj(bArr, iZzj10, zzmxVar);
                            if (i3 != zzmxVar.zza) {
                                return iZzj10;
                            }
                            iZzj10 = zzmy.zzj(bArr, iZzj11, zzmxVar);
                            int i19 = zzmxVar.zza;
                            if (i19 < 0) {
                                throw zzov.zzd();
                            }
                            if (i19 == 0) {
                                zzosVarZzd.add("");
                            } else {
                                zzosVarZzd.add(new String(bArr, iZzj10, i19, zzot.zzb));
                                iZzj10 += i19;
                            }
                        }
                        return iZzj10;
                    }
                    int iZzj12 = zzmy.zzj(bArr, iZzj2, zzmxVar);
                    int i20 = zzmxVar.zza;
                    if (i20 < 0) {
                        throw zzov.zzd();
                    }
                    if (i20 == 0) {
                        zzosVarZzd.add("");
                    } else {
                        int i21 = iZzj12 + i20;
                        if (!zzrk.zzf(bArr, iZzj12, i21)) {
                            throw zzov.zzc();
                        }
                        zzosVarZzd.add(new String(bArr, iZzj12, i20, zzot.zzb));
                        iZzj12 = i21;
                    }
                    while (iZzj12 < i2) {
                        int iZzj13 = zzmy.zzj(bArr, iZzj12, zzmxVar);
                        if (i3 != zzmxVar.zza) {
                            return iZzj12;
                        }
                        iZzj12 = zzmy.zzj(bArr, iZzj13, zzmxVar);
                        int i22 = zzmxVar.zza;
                        if (i22 < 0) {
                            throw zzov.zzd();
                        }
                        if (i22 == 0) {
                            zzosVarZzd.add("");
                        } else {
                            int i23 = iZzj12 + i22;
                            if (!zzrk.zzf(bArr, iZzj12, i23)) {
                                throw zzov.zzc();
                            }
                            zzosVarZzd.add(new String(bArr, iZzj12, i22, zzot.zzb));
                            iZzj12 = i23;
                        }
                    }
                    return iZzj12;
                }
                return iZzj2;
            case 27:
                if (i5 == 2) {
                    return zzmy.zze(zzE(i6), i3, bArr, i, i2, zzosVarZzd, zzmxVar);
                }
                return iZzj2;
            case 28:
                if (i5 == 2) {
                    int iZzj14 = zzmy.zzj(bArr, iZzj2, zzmxVar);
                    int i24 = zzmxVar.zza;
                    if (i24 < 0) {
                        throw zzov.zzd();
                    }
                    if (i24 > bArr.length - iZzj14) {
                        throw zzov.zzg();
                    }
                    if (i24 == 0) {
                        zzosVarZzd.add(zznl.zzb);
                    } else {
                        zzosVarZzd.add(zznl.zzl(bArr, iZzj14, i24));
                        iZzj14 += i24;
                    }
                    while (iZzj14 < i2) {
                        int iZzj15 = zzmy.zzj(bArr, iZzj14, zzmxVar);
                        if (i3 != zzmxVar.zza) {
                            return iZzj14;
                        }
                        iZzj14 = zzmy.zzj(bArr, iZzj15, zzmxVar);
                        int i25 = zzmxVar.zza;
                        if (i25 < 0) {
                            throw zzov.zzd();
                        }
                        if (i25 > bArr.length - iZzj14) {
                            throw zzov.zzg();
                        }
                        if (i25 == 0) {
                            zzosVarZzd.add(zznl.zzb);
                        } else {
                            zzosVarZzd.add(zznl.zzl(bArr, iZzj14, i25));
                            iZzj14 += i25;
                        }
                    }
                    return iZzj14;
                }
                return iZzj2;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZzj = zzmy.zzl(i3, bArr, i, i2, zzosVarZzd, zzmxVar);
                    }
                    return iZzj2;
                }
                iZzj = zzmy.zzf(bArr, iZzj2, zzosVarZzd, zzmxVar);
                zzon zzonVar = (zzon) obj;
                zzqw zzqwVar = zzonVar.zzc;
                if (zzqwVar == zzqw.zzc()) {
                    zzqwVar = null;
                }
                Object objZzC = zzqg.zzC(i4, zzosVarZzd, zzD(i6), zzqwVar, this.zzn);
                if (objZzC != null) {
                    zzonVar.zzc = (zzqw) objZzC;
                    return iZzj;
                }
                return iZzj;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzoo zzooVar3 = (zzoo) zzosVarZzd;
                    int iZzj16 = zzmy.zzj(bArr, iZzj2, zzmxVar);
                    int i26 = zzmxVar.zza + iZzj16;
                    while (iZzj16 < i26) {
                        iZzj16 = zzmy.zzj(bArr, iZzj16, zzmxVar);
                        zzooVar3.zzf(zznp.zzb(zzmxVar.zza));
                    }
                    if (iZzj16 == i26) {
                        return iZzj16;
                    }
                    throw zzov.zzg();
                }
                if (i5 == 0) {
                    zzoo zzooVar4 = (zzoo) zzosVarZzd;
                    int iZzj17 = zzmy.zzj(bArr, iZzj2, zzmxVar);
                    zzooVar4.zzf(zznp.zzb(zzmxVar.zza));
                    while (iZzj17 < i2) {
                        int iZzj18 = zzmy.zzj(bArr, iZzj17, zzmxVar);
                        if (i3 != zzmxVar.zza) {
                            return iZzj17;
                        }
                        iZzj17 = zzmy.zzj(bArr, iZzj18, zzmxVar);
                        zzooVar4.zzf(zznp.zzb(zzmxVar.zza));
                    }
                    return iZzj17;
                }
                return iZzj2;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzph zzphVar5 = (zzph) zzosVarZzd;
                    int iZzj19 = zzmy.zzj(bArr, iZzj2, zzmxVar);
                    int i27 = zzmxVar.zza + iZzj19;
                    while (iZzj19 < i27) {
                        iZzj19 = zzmy.zzm(bArr, iZzj19, zzmxVar);
                        zzphVar5.zzf(zznp.zzc(zzmxVar.zzb));
                    }
                    if (iZzj19 == i27) {
                        return iZzj19;
                    }
                    throw zzov.zzg();
                }
                if (i5 == 0) {
                    zzph zzphVar6 = (zzph) zzosVarZzd;
                    int iZzm3 = zzmy.zzm(bArr, iZzj2, zzmxVar);
                    zzphVar6.zzf(zznp.zzc(zzmxVar.zzb));
                    while (iZzm3 < i2) {
                        int iZzj20 = zzmy.zzj(bArr, iZzm3, zzmxVar);
                        if (i3 != zzmxVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzmy.zzm(bArr, iZzj20, zzmxVar);
                        zzphVar6.zzf(zznp.zzc(zzmxVar.zzb));
                    }
                    return iZzm3;
                }
                return iZzj2;
            default:
                if (i5 == 3) {
                    zzqe zzqeVarZzE = zzE(i6);
                    int i28 = (i3 & (-8)) | 4;
                    int iZzc = zzmy.zzc(zzqeVarZzE, bArr, i, i2, i28, zzmxVar);
                    zzosVarZzd.add(zzmxVar.zzc);
                    while (iZzc < i2) {
                        int iZzj21 = zzmy.zzj(bArr, iZzc, zzmxVar);
                        if (i3 != zzmxVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzmy.zzc(zzqeVarZzE, bArr, iZzj21, i2, i28, zzmxVar);
                        zzosVarZzd.add(zzmxVar.zzc);
                    }
                    return iZzc;
                }
                return iZzj2;
        }
    }

    private final int zzw(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, 0);
    }

    private final int zzx(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, i2);
    }

    private final int zzy(int i) {
        return this.zzc[i + 2];
    }

    private final int zzz(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final int zza(Object obj) {
        return this.zzi ? zzq(obj) : zzp(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final int zzb(Object obj) {
        int i;
        int iZzc;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzB = zzB(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzB;
            int iHashCode = 37;
            switch (zzA(iZzB)) {
                case 0:
                    i = i2 * 53;
                    iZzc = zzot.zzc(Double.doubleToLongBits(zzrf.zza(obj, j)));
                    i2 = i + iZzc;
                    break;
                case 1:
                    i = i2 * 53;
                    iZzc = Float.floatToIntBits(zzrf.zzb(obj, j));
                    i2 = i + iZzc;
                    break;
                case 2:
                    i = i2 * 53;
                    iZzc = zzot.zzc(zzrf.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 3:
                    i = i2 * 53;
                    iZzc = zzot.zzc(zzrf.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 4:
                    i = i2 * 53;
                    iZzc = zzrf.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 5:
                    i = i2 * 53;
                    iZzc = zzot.zzc(zzrf.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 6:
                    i = i2 * 53;
                    iZzc = zzrf.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 7:
                    i = i2 * 53;
                    iZzc = zzot.zza(zzrf.zzw(obj, j));
                    i2 = i + iZzc;
                    break;
                case 8:
                    i = i2 * 53;
                    iZzc = ((String) zzrf.zzf(obj, j)).hashCode();
                    i2 = i + iZzc;
                    break;
                case 9:
                    Object objZzf = zzrf.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZzc = zzrf.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 11:
                    i = i2 * 53;
                    iZzc = zzrf.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 12:
                    i = i2 * 53;
                    iZzc = zzrf.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 13:
                    i = i2 * 53;
                    iZzc = zzrf.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 14:
                    i = i2 * 53;
                    iZzc = zzot.zzc(zzrf.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 15:
                    i = i2 * 53;
                    iZzc = zzrf.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 16:
                    i = i2 * 53;
                    iZzc = zzot.zzc(zzrf.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 17:
                    Object objZzf2 = zzrf.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZzc = zzrf.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 50:
                    i = i2 * 53;
                    iZzc = zzrf.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 51:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzot.zzc(Double.doubleToLongBits(zzn(obj, j)));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = Float.floatToIntBits(zzo(obj, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzot.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzot.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzot.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzot.zza(zzQ(obj, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = ((String) zzrf.zzf(obj, j)).hashCode();
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzrf.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzrf.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzot.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzot.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzP(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzrf.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzn.zzc(obj).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzo.zzb(obj).zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:181:0x05b1, code lost:
    
        if (r2 == r3) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x05b3, code lost:
    
        r29.putInt(r13, r2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x05b9, code lost:
    
        r2 = r9.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x05bd, code lost:
    
        if (r2 >= r9.zzl) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x05bf, code lost:
    
        r4 = r9.zzj[r2];
        r5 = r9.zzc[r4];
        r5 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzrf.zzf(r13, r9.zzB(r4) & r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x05d1, code lost:
    
        if (r5 != null) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x05d8, code lost:
    
        if (r9.zzD(r4) != null) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x05da, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x05dd, code lost:
    
        r5 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzpm) r5;
        r0 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzpl) r9.zzF(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x05e5, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x05e6, code lost:
    
        if (r7 != 0) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x05e8, code lost:
    
        if (r0 != r6) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x05ef, code lost:
    
        throw com.google.android.gms.internal.mlkit_vision_face_bundled.zzov.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x05f0, code lost:
    
        if (r0 > r6) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x05f2, code lost:
    
        if (r1 != r7) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x05f4, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x05f9, code lost:
    
        throw com.google.android.gms.internal.mlkit_vision_face_bundled.zzov.zze();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzc(java.lang.Object r31, byte[] r32, int r33, int r34, int r35, com.google.android.gms.internal.mlkit_vision_face_bundled.zzmx r36) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzpv.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_face_bundled.zzmx):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final Object zze() {
        return ((zzon) this.zzg).zzf(4, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final void zzf(Object obj) {
        int i;
        int i2 = this.zzk;
        while (true) {
            i = this.zzl;
            if (i2 >= i) {
                break;
            }
            long jZzB = zzB(this.zzj[i2]) & 1048575;
            Object objZzf = zzrf.zzf(obj, jZzB);
            if (objZzf != null) {
                ((zzpm) objZzf).zzc();
                zzrf.zzs(obj, jZzB, objZzf);
            }
            i2++;
        }
        int length = this.zzj.length;
        while (i < length) {
            this.zzm.zza(obj, this.zzj[i]);
            i++;
        }
        this.zzn.zzg(obj);
        if (this.zzh) {
            this.zzo.zze(obj);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final void zzg(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzB = zzB(i);
            long j = 1048575 & iZzB;
            int i2 = this.zzc[i];
            switch (zzA(iZzB)) {
                case 0:
                    if (zzM(obj2, i)) {
                        zzrf.zzo(obj, j, zzrf.zza(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzM(obj2, i)) {
                        zzrf.zzp(obj, j, zzrf.zzb(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzM(obj2, i)) {
                        zzrf.zzr(obj, j, zzrf.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzM(obj2, i)) {
                        zzrf.zzr(obj, j, zzrf.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzM(obj2, i)) {
                        zzrf.zzq(obj, j, zzrf.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzM(obj2, i)) {
                        zzrf.zzr(obj, j, zzrf.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzM(obj2, i)) {
                        zzrf.zzq(obj, j, zzrf.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzM(obj2, i)) {
                        zzrf.zzm(obj, j, zzrf.zzw(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzM(obj2, i)) {
                        zzrf.zzs(obj, j, zzrf.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzH(obj, obj2, i);
                    break;
                case 10:
                    if (zzM(obj2, i)) {
                        zzrf.zzs(obj, j, zzrf.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzM(obj2, i)) {
                        zzrf.zzq(obj, j, zzrf.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzM(obj2, i)) {
                        zzrf.zzq(obj, j, zzrf.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzM(obj2, i)) {
                        zzrf.zzq(obj, j, zzrf.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzM(obj2, i)) {
                        zzrf.zzr(obj, j, zzrf.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzM(obj2, i)) {
                        zzrf.zzq(obj, j, zzrf.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzM(obj2, i)) {
                        zzrf.zzr(obj, j, zzrf.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzH(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzb(obj, obj2, j);
                    break;
                case 50:
                    zzqg.zzI(this.zzq, obj, obj2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzP(obj2, i2, i)) {
                        zzrf.zzs(obj, j, zzrf.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzI(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzP(obj2, i2, i)) {
                        zzrf.zzs(obj, j, zzrf.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzI(obj, obj2, i);
                    break;
            }
        }
        zzqg.zzF(this.zzn, obj, obj2);
        if (this.zzh) {
            zzqg.zzE(this.zzo, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzmx zzmxVar) throws IOException {
        if (this.zzi) {
            zzu(obj, bArr, i, i2, zzmxVar);
        } else {
            zzc(obj, bArr, i, i2, 0, zzmxVar);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    public final boolean zzi(Object obj, Object obj2) {
        boolean zZzH;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzB = zzB(i);
            long j = iZzB & 1048575;
            switch (zzA(iZzB)) {
                case 0:
                    if (!zzL(obj, obj2, i) || Double.doubleToLongBits(zzrf.zza(obj, j)) != Double.doubleToLongBits(zzrf.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i) || Float.floatToIntBits(zzrf.zzb(obj, j)) != Float.floatToIntBits(zzrf.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i) || zzrf.zzd(obj, j) != zzrf.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i) || zzrf.zzd(obj, j) != zzrf.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i) || zzrf.zzc(obj, j) != zzrf.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i) || zzrf.zzd(obj, j) != zzrf.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i) || zzrf.zzc(obj, j) != zzrf.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i) || zzrf.zzw(obj, j) != zzrf.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i) || !zzqg.zzH(zzrf.zzf(obj, j), zzrf.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i) || !zzqg.zzH(zzrf.zzf(obj, j), zzrf.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i) || !zzqg.zzH(zzrf.zzf(obj, j), zzrf.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i) || zzrf.zzc(obj, j) != zzrf.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i) || zzrf.zzc(obj, j) != zzrf.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i) || zzrf.zzc(obj, j) != zzrf.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i) || zzrf.zzd(obj, j) != zzrf.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i) || zzrf.zzc(obj, j) != zzrf.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i) || zzrf.zzd(obj, j) != zzrf.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i) || !zzqg.zzH(zzrf.zzf(obj, j), zzrf.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzH = zzqg.zzH(zzrf.zzf(obj, j), zzrf.zzf(obj2, j));
                    break;
                case 50:
                    zZzH = zzqg.zzH(zzrf.zzf(obj, j), zzrf.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzy = zzy(i) & 1048575;
                    if (zzrf.zzc(obj, jZzy) != zzrf.zzc(obj2, jZzy) || !zzqg.zzH(zzrf.zzf(obj, j), zzrf.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!zZzH) {
                return false;
            }
        }
        if (!this.zzn.zzc(obj).equals(this.zzn.zzc(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzo.zzb(obj).equals(this.zzo.zzb(obj2));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzj(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzpv.zzj(java.lang.Object):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0503 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzm(java.lang.Object r13, com.google.android.gms.internal.mlkit_vision_face_bundled.zznu r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzpv.zzm(java.lang.Object, com.google.android.gms.internal.mlkit_vision_face_bundled.zznu):void");
    }
}
