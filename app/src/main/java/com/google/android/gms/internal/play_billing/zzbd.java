package com.google.android.gms.internal.play_billing;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cb;
import java.io.IOException;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes2.dex */
final class zzbd {
    public static int zza(byte[] bArr, int i, zzbc zzbcVar) throws zzdc {
        int iZzh = zzh(bArr, i, zzbcVar);
        int i2 = zzbcVar.zza;
        if (i2 < 0) {
            throw zzdc.zzd();
        }
        if (i2 > bArr.length - iZzh) {
            throw zzdc.zzg();
        }
        if (i2 == 0) {
            zzbcVar.zzc = zzbq.zzb;
            return iZzh;
        }
        zzbcVar.zzc = zzbq.zzl(bArr, iZzh, i2);
        return iZzh + i2;
    }

    public static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & ExifInterface.MARKER;
        int i3 = bArr[i + 1] & ExifInterface.MARKER;
        int i4 = bArr[i + 2] & ExifInterface.MARKER;
        return ((bArr[i + 3] & ExifInterface.MARKER) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public static int zzc(zzeo zzeoVar, byte[] bArr, int i, int i2, int i3, zzbc zzbcVar) throws IOException {
        Object objZze = zzeoVar.zze();
        int iZzl = zzl(objZze, zzeoVar, bArr, i, i2, i3, zzbcVar);
        zzeoVar.zzf(objZze);
        zzbcVar.zzc = objZze;
        return iZzl;
    }

    public static int zzd(zzeo zzeoVar, byte[] bArr, int i, int i2, zzbc zzbcVar) throws IOException {
        Object objZze = zzeoVar.zze();
        int iZzm = zzm(objZze, zzeoVar, bArr, i, i2, zzbcVar);
        zzeoVar.zzf(objZze);
        zzbcVar.zzc = objZze;
        return iZzm;
    }

    public static int zze(zzeo zzeoVar, int i, byte[] bArr, int i2, int i3, zzcz zzczVar, zzbc zzbcVar) throws IOException {
        int iZzd = zzd(zzeoVar, bArr, i2, i3, zzbcVar);
        zzczVar.add(zzbcVar.zzc);
        while (iZzd < i3) {
            int iZzh = zzh(bArr, iZzd, zzbcVar);
            if (i != zzbcVar.zza) {
                break;
            }
            iZzd = zzd(zzeoVar, bArr, iZzh, i3, zzbcVar);
            zzczVar.add(zzbcVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i, zzcz zzczVar, zzbc zzbcVar) throws IOException {
        zzct zzctVar = (zzct) zzczVar;
        int iZzh = zzh(bArr, i, zzbcVar);
        int i2 = zzbcVar.zza + iZzh;
        while (iZzh < i2) {
            iZzh = zzh(bArr, iZzh, zzbcVar);
            zzctVar.zzg(zzbcVar.zza);
        }
        if (iZzh == i2) {
            return iZzh;
        }
        throw zzdc.zzg();
    }

    public static int zzg(int i, byte[] bArr, int i2, int i3, zzfg zzfgVar, zzbc zzbcVar) throws zzdc {
        if ((i >>> 3) == 0) {
            throw zzdc.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzk = zzk(bArr, i2, zzbcVar);
            zzfgVar.zzj(i, Long.valueOf(zzbcVar.zzb));
            return iZzk;
        }
        if (i4 == 1) {
            zzfgVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzh = zzh(bArr, i2, zzbcVar);
            int i5 = zzbcVar.zza;
            if (i5 < 0) {
                throw zzdc.zzd();
            }
            if (i5 > bArr.length - iZzh) {
                throw zzdc.zzg();
            }
            if (i5 == 0) {
                zzfgVar.zzj(i, zzbq.zzb);
            } else {
                zzfgVar.zzj(i, zzbq.zzl(bArr, iZzh, i5));
            }
            return iZzh + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzdc.zzb();
            }
            zzfgVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzfg zzfgVarZzf = zzfg.zzf();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzh2 = zzh(bArr, i2, zzbcVar);
            int i8 = zzbcVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = iZzh2;
                break;
            }
            int iZzg = zzg(i7, bArr, iZzh2, i3, zzfgVarZzf, zzbcVar);
            i7 = i8;
            i2 = iZzg;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzdc.zze();
        }
        zzfgVar.zzj(i, zzfgVarZzf);
        return i2;
    }

    public static int zzh(byte[] bArr, int i, zzbc zzbcVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzbcVar);
        }
        zzbcVar.zza = b;
        return i2;
    }

    public static int zzi(int i, byte[] bArr, int i2, zzbc zzbcVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzbcVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzbcVar.zza = i5 | (b2 << cb.l);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzbcVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzbcVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzbcVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zzj(int i, byte[] bArr, int i2, int i3, zzcz zzczVar, zzbc zzbcVar) {
        zzct zzctVar = (zzct) zzczVar;
        int iZzh = zzh(bArr, i2, zzbcVar);
        zzctVar.zzg(zzbcVar.zza);
        while (iZzh < i3) {
            int iZzh2 = zzh(bArr, iZzh, zzbcVar);
            if (i != zzbcVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzbcVar);
            zzctVar.zzg(zzbcVar.zza);
        }
        return iZzh;
    }

    public static int zzk(byte[] bArr, int i, zzbc zzbcVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzbcVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= (b2 & Byte.MAX_VALUE) << i4;
            i3 = i5;
            b = b2;
        }
        zzbcVar.zzb = j2;
        return i3;
    }

    public static int zzl(Object obj, zzeo zzeoVar, byte[] bArr, int i, int i2, int i3, zzbc zzbcVar) throws IOException {
        int iZzc = ((zzef) zzeoVar).zzc(obj, bArr, i, i2, i3, zzbcVar);
        zzbcVar.zzc = obj;
        return iZzc;
    }

    public static int zzm(Object obj, zzeo zzeoVar, byte[] bArr, int i, int i2, zzbc zzbcVar) throws IOException {
        int iZzi = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzi = zzi(i3, bArr, iZzi, zzbcVar);
            i3 = zzbcVar.zza;
        }
        int i4 = iZzi;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzdc.zzg();
        }
        int i5 = i3 + i4;
        zzeoVar.zzh(obj, bArr, i4, i5, zzbcVar);
        zzbcVar.zzc = obj;
        return i5;
    }

    public static long zzn(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }
}
