package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: ఐ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4510 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m13836(String str) {
        StringBuilder sb = new StringBuilder();
        long length = str.length();
        for (int i = 0; i < length; i++) {
            sb.append((char) (str.charAt(i) - (i % C3557.f12369[4])));
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.InputStream] */
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m13837(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2;
        IOException e2;
        try {
            try {
                str = C4079.m13017().getAssets().open(str);
            } catch (IOException e3) {
                byteArrayOutputStream2 = null;
                e2 = e3;
                str = 0;
            } catch (Throwable th2) {
                byteArrayOutputStream = null;
                th = th2;
                str = 0;
            }
            try {
                byteArrayOutputStream2 = new ByteArrayOutputStream();
            } catch (IOException e4) {
                byteArrayOutputStream2 = null;
                e2 = e4;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
                if (str != 0) {
                    try {
                        str.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        throw th;
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = str.read(bArr, 0, 1024);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr, 0, i);
                }
                String strM13836 = m13836(new String(byteArrayOutputStream2.toByteArray(), C4625.m14082("GzsrQmg=")));
                try {
                    str.close();
                    byteArrayOutputStream2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return strM13836;
            } catch (IOException e7) {
                e2 = e7;
                e2.printStackTrace();
                if (str != 0) {
                    try {
                        str.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                        return "";
                    }
                }
                if (byteArrayOutputStream2 == null) {
                    return "";
                }
                byteArrayOutputStream2.close();
                return "";
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
