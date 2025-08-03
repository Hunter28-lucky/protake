package com.google.android.gms.internal.play_billing;

import com.google.zxing.qrcode.encoder.Encoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.jcodec.platform.Platform;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes2.dex */
public final class zzda {
    public static final Charset zza = Charset.forName("US-ASCII");
    public static final Charset zzb = Charset.forName(Platform.UTF_8);
    public static final Charset zzc = Charset.forName(Encoder.DEFAULT_BYTE_MODE_ENCODING);
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzbu zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i = zzbu.zza;
        zzbs zzbsVar = new zzbs(bArr, 0, 0, false, null);
        try {
            zzbsVar.zza(0);
            zzf = zzbsVar;
        } catch (zzdc e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzb(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static Object zzc(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }

    public static String zzd(byte[] bArr) {
        return new String(bArr, zzb);
    }
}
