package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.zxing.qrcode.encoder.Encoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.jcodec.platform.Platform;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzot {
    public static final Charset zza = Charset.forName("US-ASCII");
    public static final Charset zzb = Charset.forName(Platform.UTF_8);
    public static final Charset zzc = Charset.forName(Encoder.DEFAULT_BYTE_MODE_ENCODING);
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zznp zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i = zznp.zza;
        zznn zznnVar = new zznn(bArr, 0, 0, false, null);
        try {
            zznnVar.zza(0);
            zzf = zznnVar;
        } catch (zzov e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        int iZzd = zzd(length, bArr, 0, length);
        if (iZzd == 0) {
            return 1;
        }
        return iZzd;
    }

    public static int zzc(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zzd(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static Object zze(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object zzf(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static Object zzg(Object obj, Object obj2) {
        return ((zzps) obj).zzI().zzn((zzps) obj2).zzs();
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, zzb);
    }

    public static boolean zzi(zzps zzpsVar) {
        if (!(zzpsVar instanceof zzmu)) {
            return false;
        }
        throw null;
    }

    public static boolean zzj(byte[] bArr) {
        return zzrk.zze(bArr);
    }
}
