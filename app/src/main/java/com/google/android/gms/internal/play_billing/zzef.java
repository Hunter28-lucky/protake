package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import sun.misc.Unsafe;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes2.dex */
final class zzef<T> implements zzeo<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzfp.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzec zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzdq zzl;
    private final zzff zzm;
    private final zzce zzn;
    private final zzei zzo;
    private final zzdx zzp;

    private zzef(int[] iArr, Object[] objArr, int i, int i2, zzec zzecVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzei zzeiVar, zzdq zzdqVar, zzff zzffVar, zzce zzceVar, zzdx zzdxVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzceVar != null && zzceVar.zzf(zzecVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzo = zzeiVar;
        this.zzl = zzdqVar;
        this.zzm = zzffVar;
        this.zzn = zzceVar;
        this.zzg = zzecVar;
        this.zzp = zzdxVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzeo zzeoVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zzeoVarZzv.zze();
                    zzeoVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzeoVarZzv.zze();
                zzeoVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzeoVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzeo zzeoVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zzeoVarZzv.zze();
                    zzeoVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzeoVarZzv.zze();
                zzeoVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzeoVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzfp.zzq(obj, j, (1 << (iZzp >>> 20)) | zzfp.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzfp.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & 1048575;
        if (j != 1048575) {
            return (zzfp.zzc(obj, j) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzfp.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzfp.zzb(obj, j2)) != 0;
            case 2:
                return zzfp.zzd(obj, j2) != 0;
            case 3:
                return zzfp.zzd(obj, j2) != 0;
            case 4:
                return zzfp.zzc(obj, j2) != 0;
            case 5:
                return zzfp.zzd(obj, j2) != 0;
            case 6:
                return zzfp.zzc(obj, j2) != 0;
            case 7:
                return zzfp.zzw(obj, j2);
            case 8:
                Object objZzf = zzfp.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzbq) {
                    return !zzbq.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzfp.zzf(obj, j2) != null;
            case 10:
                return !zzbq.zzb.equals(zzfp.zzf(obj, j2));
            case 11:
                return zzfp.zzc(obj, j2) != 0;
            case 12:
                return zzfp.zzc(obj, j2) != 0;
            case 13:
                return zzfp.zzc(obj, j2) != 0;
            case 14:
                return zzfp.zzd(obj, j2) != 0;
            case 15:
                return zzfp.zzc(obj, j2) != 0;
            case 16:
                return zzfp.zzd(obj, j2) != 0;
            case 17:
                return zzfp.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzI(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzeo zzeoVar) {
        return zzeoVar.zzk(zzfp.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzcs) {
            return ((zzcs) obj).zzw();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzfp.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzfp.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzfx zzfxVar) throws IOException {
        if (obj instanceof String) {
            zzfxVar.zzG(i, (String) obj);
        } else {
            zzfxVar.zzd(i, (zzbq) obj);
        }
    }

    public static zzfg zzd(Object obj) {
        zzcs zzcsVar = (zzcs) obj;
        zzfg zzfgVar = zzcsVar.zzc;
        if (zzfgVar != zzfg.zzc()) {
            return zzfgVar;
        }
        zzfg zzfgVarZzf = zzfg.zzf();
        zzcsVar.zzc = zzfgVarZzf;
        return zzfgVarZzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0282  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.play_billing.zzef zzl(java.lang.Class r33, com.google.android.gms.internal.play_billing.zzdz r34, com.google.android.gms.internal.play_billing.zzei r35, com.google.android.gms.internal.play_billing.zzdq r36, com.google.android.gms.internal.play_billing.zzff r37, com.google.android.gms.internal.play_billing.zzce r38, com.google.android.gms.internal.play_billing.zzdx r39) {
        /*
            Method dump skipped, instructions count: 1030
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzl(java.lang.Class, com.google.android.gms.internal.play_billing.zzdz, com.google.android.gms.internal.play_billing.zzei, com.google.android.gms.internal.play_billing.zzdq, com.google.android.gms.internal.play_billing.zzff, com.google.android.gms.internal.play_billing.zzce, com.google.android.gms.internal.play_billing.zzdx):com.google.android.gms.internal.play_billing.zzef");
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzfp.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzfp.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzfp.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzfp.zzf(obj, j)).longValue();
    }

    private final zzcw zzu(int i) {
        int i2 = i / 3;
        return (zzcw) this.zzd[i2 + i2 + 1];
    }

    private final zzeo zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzeo zzeoVar = (zzeo) objArr[i3];
        if (zzeoVar != null) {
            return zzeoVar;
        }
        zzeo zzeoVarZzb = zzel.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzeoVarZzb;
        return zzeoVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzeo zzeoVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzeoVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzeoVarZzv.zze();
        if (object != null) {
            zzeoVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzeo zzeoVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzeoVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzeoVarZzv.zze();
        if (object != null) {
            zzeoVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:207:0x054e  */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 2194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zza(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int iZzs = zzs(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i6 = iArr[i4];
            long j = i5;
            int iHashCode = 37;
            switch (iZzr) {
                case 0:
                    i = i3 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzfp.zza(obj, j));
                    Charset charset = zzda.zza;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzfp.zzb(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j);
                    Charset charset2 = zzda.zza;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j);
                    Charset charset3 = zzda.zza;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    iFloatToIntBits = zzfp.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j);
                    Charset charset4 = zzda.zza;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    iFloatToIntBits = zzfp.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    iFloatToIntBits = zzda.zza(zzfp.zzw(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    iFloatToIntBits = ((String) zzfp.zzf(obj, j)).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object objZzf = zzfp.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iFloatToIntBits = zzfp.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    iFloatToIntBits = zzfp.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    iFloatToIntBits = zzfp.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    iFloatToIntBits = zzfp.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j);
                    Charset charset5 = zzda.zza;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    iFloatToIntBits = zzfp.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j);
                    Charset charset6 = zzda.zza;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object objZzf2 = zzfp.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i3 = i2 + iHashCode;
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
                    i = i3 * 53;
                    iFloatToIntBits = zzfp.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    iFloatToIntBits = zzfp.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        Charset charset7 = zzda.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        Charset charset8 = zzda.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        Charset charset9 = zzda.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        Charset charset10 = zzda.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzda.zza(zzN(obj, j));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = ((String) zzfp.zzf(obj, j)).hashCode();
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzfp.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzfp.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        Charset charset11 = zzda.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        Charset charset12 = zzda.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzfp.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i3 * 53) + this.zzm.zzd(obj).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzn.zzb(obj).zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:558:0x0cee, code lost:
    
        if (r6 == 1048575) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:559:0x0cf0, code lost:
    
        r33.putInt(r7, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:560:0x0cf6, code lost:
    
        r2 = r0.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:562:0x0cfa, code lost:
    
        if (r2 >= r0.zzk) goto L679;
     */
    /* JADX WARN: Code restructure failed: missing block: B:563:0x0cfc, code lost:
    
        r3 = r0.zzi;
        r5 = r0.zzc;
        r3 = r3[r2];
        r5 = r5[r3];
        r5 = com.google.android.gms.internal.play_billing.zzfp.zzf(r7, r0.zzs(r3) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:564:0x0d0e, code lost:
    
        if (r5 != null) goto L566;
     */
    /* JADX WARN: Code restructure failed: missing block: B:567:0x0d15, code lost:
    
        if (r0.zzu(r3) != null) goto L680;
     */
    /* JADX WARN: Code restructure failed: missing block: B:568:0x0d17, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:569:0x0d1a, code lost:
    
        r5 = (com.google.android.gms.internal.play_billing.zzdw) r5;
        r1 = (com.google.android.gms.internal.play_billing.zzdv) r0.zzw(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:570:0x0d22, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:571:0x0d23, code lost:
    
        if (r8 != 0) goto L577;
     */
    /* JADX WARN: Code restructure failed: missing block: B:573:0x0d27, code lost:
    
        if (r1 != r39) goto L575;
     */
    /* JADX WARN: Code restructure failed: missing block: B:576:0x0d2e, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzdc.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:578:0x0d31, code lost:
    
        if (r1 > r39) goto L581;
     */
    /* JADX WARN: Code restructure failed: missing block: B:579:0x0d33, code lost:
    
        if (r4 != r8) goto L581;
     */
    /* JADX WARN: Code restructure failed: missing block: B:580:0x0d35, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:582:0x0d3a, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzdc.zze();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0a15 A[PHI: r0 r7 r8 r9 r11 r14 r33
      0x0a15: PHI (r0v32 com.google.android.gms.internal.play_billing.zzef<T>) = 
      (r0v1 com.google.android.gms.internal.play_billing.zzef<T>)
      (r0v1 com.google.android.gms.internal.play_billing.zzef<T>)
      (r0v1 com.google.android.gms.internal.play_billing.zzef<T>)
      (r0v1 com.google.android.gms.internal.play_billing.zzef<T>)
      (r0v29 com.google.android.gms.internal.play_billing.zzef<T>)
      (r0v30 com.google.android.gms.internal.play_billing.zzef<T>)
      (r0v1 com.google.android.gms.internal.play_billing.zzef<T>)
     binds: [B:444:0x09ce, B:428:0x0974, B:412:0x0921, B:337:0x07b9, B:254:0x064b, B:288:0x06f0, B:187:0x04ad] A[DONT_GENERATE, DONT_INLINE]
      0x0a15: PHI (r7v29 int) = (r7v6 int), (r7v7 int), (r7v8 int), (r7v13 int), (r7v22 int), (r7v24 int), (r7v33 int) binds: [B:444:0x09ce, B:428:0x0974, B:412:0x0921, B:337:0x07b9, B:254:0x064b, B:288:0x06f0, B:187:0x04ad] A[DONT_GENERATE, DONT_INLINE]
      0x0a15: PHI (r8v116 int) = (r8v53 int), (r8v54 int), (r8v55 int), (r8v84 int), (r8v107 int), (r8v109 int), (r8v120 int) binds: [B:444:0x09ce, B:428:0x0974, B:412:0x0921, B:337:0x07b9, B:254:0x064b, B:288:0x06f0, B:187:0x04ad] A[DONT_GENERATE, DONT_INLINE]
      0x0a15: PHI (r9v79 com.google.android.gms.internal.play_billing.zzbc) = 
      (r9v37 com.google.android.gms.internal.play_billing.zzbc)
      (r9v38 com.google.android.gms.internal.play_billing.zzbc)
      (r9v39 com.google.android.gms.internal.play_billing.zzbc)
      (r9v52 com.google.android.gms.internal.play_billing.zzbc)
      (r9v72 com.google.android.gms.internal.play_billing.zzbc)
      (r9v74 com.google.android.gms.internal.play_billing.zzbc)
      (r9v81 com.google.android.gms.internal.play_billing.zzbc)
     binds: [B:444:0x09ce, B:428:0x0974, B:412:0x0921, B:337:0x07b9, B:254:0x064b, B:288:0x06f0, B:187:0x04ad] A[DONT_GENERATE, DONT_INLINE]
      0x0a15: PHI (r11v34 int) = (r11v13 int), (r11v14 int), (r11v15 int), (r11v17 int), (r11v27 int), (r11v29 int), (r11v37 int) binds: [B:444:0x09ce, B:428:0x0974, B:412:0x0921, B:337:0x07b9, B:254:0x064b, B:288:0x06f0, B:187:0x04ad] A[DONT_GENERATE, DONT_INLINE]
      0x0a15: PHI (r14v44 int) = (r14v18 int), (r14v19 int), (r14v20 int), (r14v22 int), (r14v34 int), (r14v36 int), (r14v46 int) binds: [B:444:0x09ce, B:428:0x0974, B:412:0x0921, B:337:0x07b9, B:254:0x064b, B:288:0x06f0, B:187:0x04ad] A[DONT_GENERATE, DONT_INLINE]
      0x0a15: PHI (r33v32 sun.misc.Unsafe) = 
      (r33v7 sun.misc.Unsafe)
      (r33v8 sun.misc.Unsafe)
      (r33v9 sun.misc.Unsafe)
      (r33v14 sun.misc.Unsafe)
      (r33v25 sun.misc.Unsafe)
      (r33v27 sun.misc.Unsafe)
      (r33v34 sun.misc.Unsafe)
     binds: [B:444:0x09ce, B:428:0x0974, B:412:0x0921, B:337:0x07b9, B:254:0x064b, B:288:0x06f0, B:187:0x04ad] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:538:0x0c70 A[PHI: r4 r10 r12 r30
      0x0c70: PHI (r4v99 int) = 
      (r4v80 int)
      (r4v81 int)
      (r4v82 int)
      (r4v83 int)
      (r4v84 int)
      (r4v85 int)
      (r4v86 int)
      (r4v87 int)
      (r4v92 int)
      (r4v100 int)
     binds: [B:536:0x0c59, B:533:0x0c3b, B:530:0x0c21, B:527:0x0c08, B:524:0x0bee, B:521:0x0bd3, B:514:0x0baf, B:512:0x0ba5, B:497:0x0b62, B:471:0x0a8f] A[DONT_GENERATE, DONT_INLINE]
      0x0c70: PHI (r10v75 int) = 
      (r10v57 int)
      (r10v58 int)
      (r10v59 int)
      (r10v60 int)
      (r10v61 int)
      (r10v62 int)
      (r10v63 int)
      (r10v64 int)
      (r10v69 int)
      (r10v76 int)
     binds: [B:536:0x0c59, B:533:0x0c3b, B:530:0x0c21, B:527:0x0c08, B:524:0x0bee, B:521:0x0bd3, B:514:0x0baf, B:512:0x0ba5, B:497:0x0b62, B:471:0x0a8f] A[DONT_GENERATE, DONT_INLINE]
      0x0c70: PHI (r12v36 int) = 
      (r12v19 int)
      (r12v20 int)
      (r12v21 int)
      (r12v22 int)
      (r12v23 int)
      (r12v24 int)
      (r12v25 int)
      (r12v26 int)
      (r12v30 int)
      (r12v37 int)
     binds: [B:536:0x0c59, B:533:0x0c3b, B:530:0x0c21, B:527:0x0c08, B:524:0x0bee, B:521:0x0bd3, B:514:0x0baf, B:512:0x0ba5, B:497:0x0b62, B:471:0x0a8f] A[DONT_GENERATE, DONT_INLINE]
      0x0c70: PHI (r30v21 int) = 
      (r30v5 int)
      (r30v6 int)
      (r30v7 int)
      (r30v8 int)
      (r30v9 int)
      (r30v10 int)
      (r30v11 int)
      (r30v12 int)
      (r30v17 int)
      (r30v22 int)
     binds: [B:536:0x0c59, B:533:0x0c3b, B:530:0x0c21, B:527:0x0c08, B:524:0x0bee, B:521:0x0bd3, B:514:0x0baf, B:512:0x0ba5, B:497:0x0b62, B:471:0x0a8f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0a18 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:623:0x0c73 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:626:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:667:0x0a2a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:668:0x0c86 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0214  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzc(java.lang.Object r36, byte[] r37, int r38, int r39, int r40, com.google.android.gms.internal.play_billing.zzbc r41) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzbc):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final Object zze() {
        return ((zzcs) this.zzg).zzl();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzf(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = zzL(r8)
            if (r0 != 0) goto L8
            goto L91
        L8:
            boolean r0 = r8 instanceof com.google.android.gms.internal.play_billing.zzcs
            r1 = 0
            if (r0 == 0) goto L1b
            r0 = r8
            com.google.android.gms.internal.play_billing.zzcs r0 = (com.google.android.gms.internal.play_billing.zzcs) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.zzu(r2)
            r0.zza = r1
            r0.zzs()
        L1b:
            int[] r0 = r7.zzc
        L1d:
            int r2 = r0.length
            if (r1 >= r2) goto L83
            int r2 = r7.zzs(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            int r2 = zzr(r2)
            long r3 = (long) r3
            r5 = 9
            if (r2 == r5) goto L6d
            r5 = 60
            if (r2 == r5) goto L55
            r5 = 68
            if (r2 == r5) goto L55
            switch(r2) {
                case 17: goto L6d;
                case 18: goto L4f;
                case 19: goto L4f;
                case 20: goto L4f;
                case 21: goto L4f;
                case 22: goto L4f;
                case 23: goto L4f;
                case 24: goto L4f;
                case 25: goto L4f;
                case 26: goto L4f;
                case 27: goto L4f;
                case 28: goto L4f;
                case 29: goto L4f;
                case 30: goto L4f;
                case 31: goto L4f;
                case 32: goto L4f;
                case 33: goto L4f;
                case 34: goto L4f;
                case 35: goto L4f;
                case 36: goto L4f;
                case 37: goto L4f;
                case 38: goto L4f;
                case 39: goto L4f;
                case 40: goto L4f;
                case 41: goto L4f;
                case 42: goto L4f;
                case 43: goto L4f;
                case 44: goto L4f;
                case 45: goto L4f;
                case 46: goto L4f;
                case 47: goto L4f;
                case 48: goto L4f;
                case 49: goto L4f;
                case 50: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L80
        L3d:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.play_billing.zzef.zzb
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L80
            r6 = r5
            com.google.android.gms.internal.play_billing.zzdw r6 = (com.google.android.gms.internal.play_billing.zzdw) r6
            r6.zzc()
            r2.putObject(r8, r3, r5)
            goto L80
        L4f:
            com.google.android.gms.internal.play_billing.zzdq r2 = r7.zzl
            r2.zza(r8, r3)
            goto L80
        L55:
            int[] r2 = r7.zzc
            r2 = r2[r1]
            boolean r2 = r7.zzM(r8, r2, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.play_billing.zzeo r2 = r7.zzv(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.play_billing.zzef.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzf(r3)
            goto L80
        L6d:
            boolean r2 = r7.zzI(r8, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.play_billing.zzeo r2 = r7.zzv(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.play_billing.zzef.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzf(r3)
        L80:
            int r1 = r1 + 3
            goto L1d
        L83:
            com.google.android.gms.internal.play_billing.zzff r0 = r7.zzm
            r0.zzg(r8)
            boolean r0 = r7.zzh
            if (r0 == 0) goto L91
            com.google.android.gms.internal.play_billing.zzce r0 = r7.zzn
            r0.zzd(r8)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzf(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            int i2 = 1048575 & iZzs;
            int[] iArr = this.zzc;
            int iZzr = zzr(iZzs);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzfp.zzo(obj, j, zzfp.zza(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzI(obj2, i)) {
                        zzfp.zzp(obj, j, zzfp.zzb(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzI(obj2, i)) {
                        zzfp.zzr(obj, j, zzfp.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzI(obj2, i)) {
                        zzfp.zzr(obj, j, zzfp.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzI(obj2, i)) {
                        zzfp.zzq(obj, j, zzfp.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzI(obj2, i)) {
                        zzfp.zzr(obj, j, zzfp.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzI(obj2, i)) {
                        zzfp.zzq(obj, j, zzfp.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzI(obj2, i)) {
                        zzfp.zzm(obj, j, zzfp.zzw(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzI(obj2, i)) {
                        zzfp.zzs(obj, j, zzfp.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzfp.zzs(obj, j, zzfp.zzf(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzI(obj2, i)) {
                        zzfp.zzq(obj, j, zzfp.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzI(obj2, i)) {
                        zzfp.zzq(obj, j, zzfp.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzI(obj2, i)) {
                        zzfp.zzq(obj, j, zzfp.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzI(obj2, i)) {
                        zzfp.zzr(obj, j, zzfp.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzI(obj2, i)) {
                        zzfp.zzq(obj, j, zzfp.zzc(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzI(obj2, i)) {
                        zzfp.zzr(obj, j, zzfp.zzd(obj2, j));
                        zzD(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i);
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
                    this.zzl.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i4 = zzeq.zza;
                    zzfp.zzs(obj, j, zzdx.zza(zzfp.zzf(obj, j), zzfp.zzf(obj2, j)));
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
                    if (zzM(obj2, i3, i)) {
                        zzfp.zzs(obj, j, zzfp.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzfp.zzs(obj, j, zzfp.zzf(obj2, j));
                        zzE(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzeq.zzq(this.zzm, obj, obj2);
        if (this.zzh) {
            zzeq.zzp(this.zzn, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzbc zzbcVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzbcVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r24, com.google.android.gms.internal.play_billing.zzfx r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1912
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzi(java.lang.Object, com.google.android.gms.internal.play_billing.zzfx):void");
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzG;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            long j = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzfp.zza(obj, j)) != Double.doubleToLongBits(zzfp.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzfp.zzb(obj, j)) != Float.floatToIntBits(zzfp.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i) || zzfp.zzd(obj, j) != zzfp.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i) || zzfp.zzd(obj, j) != zzfp.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i) || zzfp.zzc(obj, j) != zzfp.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i) || zzfp.zzd(obj, j) != zzfp.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i) || zzfp.zzc(obj, j) != zzfp.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i) || zzfp.zzw(obj, j) != zzfp.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i) || !zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i) || !zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i) || !zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i) || zzfp.zzc(obj, j) != zzfp.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i) || zzfp.zzc(obj, j) != zzfp.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i) || zzfp.zzc(obj, j) != zzfp.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i) || zzfp.zzd(obj, j) != zzfp.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i) || zzfp.zzc(obj, j) != zzfp.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i) || zzfp.zzd(obj, j) != zzfp.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i) || !zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
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
                    zZzG = zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j));
                    break;
                case 50:
                    zZzG = zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j));
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
                    long jZzp = zzp(i) & 1048575;
                    if (zzfp.zzc(obj, jZzp) != zzfp.zzc(obj2, jZzp) || !zzeq.zzG(zzfp.zzf(obj, j), zzfp.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!zZzG) {
                return false;
            }
        }
        if (!this.zzm.zzd(obj).equals(this.zzm.zzd(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzn.zzb(obj).equals(this.zzn.zzb(obj2));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzk(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzk(java.lang.Object):boolean");
    }
}
