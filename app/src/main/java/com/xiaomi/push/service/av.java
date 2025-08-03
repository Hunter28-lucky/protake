package com.xiaomi.push.service;

import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.http.okhttp.utils.HttpUtil;
import com.blink.academy.film.support.stream.ts.TsConstants;
import com.umeng.analytics.pro.cb;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class av {
    private static RSAPublicKey a;

    /* renamed from: a, reason: collision with other field name */
    private static final byte[] f6419a;

    static {
        byte[] bArr = {48, -127, -97, 48, cb.k, 6, 9, ExifInterface.START_CODE, -122, 72, -122, -9, cb.k, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -109, -38, -114, 26, -72, 78, cb.n, 70, -90, 113, -30, TsConstants.ACESType_h265, 85, -3, -43, 123, 61, -98, 4, -16, 67, 19, -90, -73, -5, -89, TsConstants.ACESType_h265, 44, -27, 59, -123, 72, -73, -48, 49, cb.k, cb.n, 50, -27, -82, 18, -28, 84, 0, -41, cb.n, 69, ExifInterface.MARKER_EOI, 7, 82, 56, 79, -37, 40, 85, 107, 98, 33, 123, -34, -49, 111, -11, 49, 28, 117, -74, 114, -122, -29, -84, 82, 22, -122, ExifInterface.START_CODE, -40, -79, 18, -116, -42, 101, -70, 44, 11, 62, -49, -3, -22, -2, 66, 90, -116, -75, -99, 34, 121, 69, 10, -81, -57, 89, -23, -36, -60, -81, 67, -114, 10, 79, 100, 29, 47, -24, 110, -66, -7, 87, cb.n, -125, -91, -43, -103, 67, -20, 41, 117, -37, -11, 2, 3, 1, 0, 1};
        f6419a = bArr;
        try {
            a = (RSAPublicKey) KeyFactory.getInstance(HttpUtil.RSA).generatePublic(new X509EncodedKeySpec(bArr));
        } catch (Throwable unused) {
            com.xiaomi.channel.commonutils.logger.b.d("rsa key pair init failure!!!");
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, a);
            return Base64.encodeToString(a(cipher, 1, str.getBytes(Platform.UTF_8), a.getModulus().bitLength()), 2);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] a(Cipher cipher, int i, byte[] bArr, int i2) throws BadPaddingException, IllegalBlockSizeException {
        int i3;
        byte[] bArrDoFinal;
        if (cipher == null || bArr == null) {
            return null;
        }
        if (i == 2) {
            i3 = i2 / 8;
        } else {
            i3 = (i2 / 8) - 11;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i4 = 0;
            int i5 = 0;
            while (bArr.length > i4) {
                if (bArr.length - i4 > i3) {
                    bArrDoFinal = cipher.doFinal(bArr, i4, i3);
                } else {
                    bArrDoFinal = cipher.doFinal(bArr, i4, bArr.length - i4);
                }
                byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                i5++;
                i4 = i5 * i3;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
