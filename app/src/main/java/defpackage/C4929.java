package defpackage;

import android.util.Base64;
import com.google.zxing.qrcode.encoder.Encoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;

/* compiled from: CompressUtils.java */
/* renamed from: โ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4929 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int f16618 = 2;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String f16619 = "utf-8";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m14660(String str) throws IOException {
        int i = f16618;
        if (i == 1) {
            if (str == null || str.length() <= 0) {
                return str;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes(f16619));
            gZIPOutputStream.close();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toString(Encoder.DEFAULT_BYTE_MODE_ENCODING);
        }
        if (i != 2) {
            return str;
        }
        Deflater deflater = new Deflater(9);
        deflater.setInput(str.getBytes());
        deflater.finish();
        byte[] bArr = new byte[256];
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(256);
        while (!deflater.finished()) {
            byteArrayOutputStream2.write(bArr, 0, deflater.deflate(bArr));
        }
        deflater.end();
        return new String(Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 1).getBytes(), f16619);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m14661(String str) throws IOException {
        if (str != null && str.length() > 0) {
            try {
                int i = f16618;
                if (i == 1) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(str.getBytes(Encoder.DEFAULT_BYTE_MODE_ENCODING)));
                    byte[] bArr = new byte[256];
                    while (true) {
                        int i2 = gZIPInputStream.read(bArr);
                        if (i2 < 0) {
                            return byteArrayOutputStream.toString(f16619);
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                } else if (i == 2) {
                    byte[] bArrDecode = Base64.decode(str, 1);
                    Inflater inflater = new Inflater();
                    inflater.setInput(bArrDecode);
                    byte[] bArr2 = new byte[256];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(256);
                    while (!inflater.finished()) {
                        try {
                            try {
                                byteArrayOutputStream2.write(bArr2, 0, inflater.inflate(bArr2));
                            } catch (DataFormatException e2) {
                                e2.printStackTrace();
                                inflater.end();
                                return null;
                            }
                        } catch (Throwable th) {
                            inflater.end();
                            throw th;
                        }
                    }
                    inflater.end();
                    return byteArrayOutputStream2.toString();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return str;
    }
}
