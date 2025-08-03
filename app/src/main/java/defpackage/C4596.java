package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: ಇ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4596 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static byte[] m14054(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                try {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    break;
                } catch (IOException e3) {
                }
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static byte[] m14055(String str) {
        try {
            return m14054(C4079.m13017().getAssets().open(str));
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m14056(String str) {
        try {
            return C4510.m13837(str);
        } catch (Exception unused) {
            return "";
        }
    }
}
