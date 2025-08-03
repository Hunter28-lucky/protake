package com.google.android.gms.internal.mlkit_vision_face_bundled;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cb;
import java.io.IOException;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzmy {
    public static int zza(byte[] bArr, int i, zzmx zzmxVar) throws zzov {
        int iZzj = zzj(bArr, i, zzmxVar);
        int i2 = zzmxVar.zza;
        if (i2 < 0) {
            throw zzov.zzd();
        }
        if (i2 > bArr.length - iZzj) {
            throw zzov.zzg();
        }
        if (i2 == 0) {
            zzmxVar.zzc = zznl.zzb;
            return iZzj;
        }
        zzmxVar.zzc = zznl.zzl(bArr, iZzj, i2);
        return iZzj + i2;
    }

    public static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & ExifInterface.MARKER) << 24) | (bArr[i] & ExifInterface.MARKER) | ((bArr[i + 1] & ExifInterface.MARKER) << 8) | ((bArr[i + 2] & ExifInterface.MARKER) << 16);
    }

    public static int zzc(zzqe zzqeVar, byte[] bArr, int i, int i2, int i3, zzmx zzmxVar) throws IOException {
        zzpv zzpvVar = (zzpv) zzqeVar;
        Object objZze = zzpvVar.zze();
        int iZzc = zzpvVar.zzc(objZze, bArr, i, i2, i3, zzmxVar);
        zzpvVar.zzf(objZze);
        zzmxVar.zzc = objZze;
        return iZzc;
    }

    public static int zzd(zzqe zzqeVar, byte[] bArr, int i, int i2, zzmx zzmxVar) throws IOException {
        int iZzk = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzk = zzk(i3, bArr, iZzk, zzmxVar);
            i3 = zzmxVar.zza;
        }
        int i4 = iZzk;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzov.zzg();
        }
        Object objZze = zzqeVar.zze();
        int i5 = i3 + i4;
        zzqeVar.zzh(objZze, bArr, i4, i5, zzmxVar);
        zzqeVar.zzf(objZze);
        zzmxVar.zzc = objZze;
        return i5;
    }

    public static int zze(zzqe zzqeVar, int i, byte[] bArr, int i2, int i3, zzos zzosVar, zzmx zzmxVar) throws IOException {
        int iZzd = zzd(zzqeVar, bArr, i2, i3, zzmxVar);
        zzosVar.add(zzmxVar.zzc);
        while (iZzd < i3) {
            int iZzj = zzj(bArr, iZzd, zzmxVar);
            if (i != zzmxVar.zza) {
                break;
            }
            iZzd = zzd(zzqeVar, bArr, iZzj, i3, zzmxVar);
            zzosVar.add(zzmxVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i, zzos zzosVar, zzmx zzmxVar) throws IOException {
        zzoo zzooVar = (zzoo) zzosVar;
        int iZzj = zzj(bArr, i, zzmxVar);
        int i2 = zzmxVar.zza + iZzj;
        while (iZzj < i2) {
            iZzj = zzj(bArr, iZzj, zzmxVar);
            zzooVar.zzf(zzmxVar.zza);
        }
        if (iZzj == i2) {
            return iZzj;
        }
        throw zzov.zzg();
    }

    public static int zzg(byte[] bArr, int i, zzmx zzmxVar) throws zzov {
        int iZzj = zzj(bArr, i, zzmxVar);
        int i2 = zzmxVar.zza;
        if (i2 < 0) {
            throw zzov.zzd();
        }
        if (i2 == 0) {
            zzmxVar.zzc = "";
            return iZzj;
        }
        zzmxVar.zzc = new String(bArr, iZzj, i2, zzot.zzb);
        return iZzj + i2;
    }

    public static int zzh(byte[] bArr, int i, zzmx zzmxVar) throws zzov {
        int iZzj = zzj(bArr, i, zzmxVar);
        int i2 = zzmxVar.zza;
        if (i2 < 0) {
            throw zzov.zzd();
        }
        if (i2 == 0) {
            zzmxVar.zzc = "";
            return iZzj;
        }
        zzmxVar.zzc = zzrk.zzd(bArr, iZzj, i2);
        return iZzj + i2;
    }

    public static int zzi(int i, byte[] bArr, int i2, int i3, zzqw zzqwVar, zzmx zzmxVar) throws zzov {
        if ((i >>> 3) == 0) {
            throw zzov.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzm = zzm(bArr, i2, zzmxVar);
            zzqwVar.zzh(i, Long.valueOf(zzmxVar.zzb));
            return iZzm;
        }
        if (i4 == 1) {
            zzqwVar.zzh(i, Long.valueOf(zzo(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzj = zzj(bArr, i2, zzmxVar);
            int i5 = zzmxVar.zza;
            if (i5 < 0) {
                throw zzov.zzd();
            }
            if (i5 > bArr.length - iZzj) {
                throw zzov.zzg();
            }
            if (i5 == 0) {
                zzqwVar.zzh(i, zznl.zzb);
            } else {
                zzqwVar.zzh(i, zznl.zzl(bArr, iZzj, i5));
            }
            return iZzj + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzov.zzb();
            }
            zzqwVar.zzh(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzqw zzqwVarZze = zzqw.zze();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzj2 = zzj(bArr, i2, zzmxVar);
            int i8 = zzmxVar.zza;
            if (i8 == i6) {
                i7 = i8;
                i2 = iZzj2;
                break;
            }
            i7 = i8;
            i2 = zzi(i8, bArr, iZzj2, i3, zzqwVarZze, zzmxVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzov.zze();
        }
        zzqwVar.zzh(i, zzqwVarZze);
        return i2;
    }

    public static int zzj(byte[] bArr, int i, zzmx zzmxVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzmxVar);
        }
        zzmxVar.zza = b;
        return i2;
    }

    public static int zzk(int i, byte[] bArr, int i2, zzmx zzmxVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzmxVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzmxVar.zza = i5 | (b2 << cb.l);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzmxVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzmxVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzmxVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zzl(int i, byte[] bArr, int i2, int i3, zzos zzosVar, zzmx zzmxVar) {
        zzoo zzooVar = (zzoo) zzosVar;
        int iZzj = zzj(bArr, i2, zzmxVar);
        zzooVar.zzf(zzmxVar.zza);
        while (iZzj < i3) {
            int iZzj2 = zzj(bArr, iZzj, zzmxVar);
            if (i != zzmxVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zzmxVar);
            zzooVar.zzf(zzmxVar.zza);
        }
        return iZzj;
    }

    public static int zzm(byte[] bArr, int i, zzmx zzmxVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzmxVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        zzmxVar.zzb = j2;
        return i3;
    }

    public static int zzn(int i, byte[] bArr, int i2, int i3, zzmx zzmxVar) throws zzov {
        if ((i >>> 3) == 0) {
            throw zzov.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzm(bArr, i2, zzmxVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzj(bArr, i2, zzmxVar) + zzmxVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzov.zzb();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzj(bArr, i2, zzmxVar);
            i6 = zzmxVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzn(i6, bArr, i2, i3, zzmxVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzov.zze();
        }
        return i2;
    }

    public static long zzo(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }
}
