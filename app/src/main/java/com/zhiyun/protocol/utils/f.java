package com.zhiyun.protocol.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;

/* loaded from: classes2.dex */
public class f {
    public static URL a(String str) {
        return a().getResource(str);
    }

    public static byte[] b(String str) throws IOException {
        URL urlA = a(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (urlA != null) {
            byte[] bArr = new byte[8192];
            InputStream inputStreamOpenStream = null;
            try {
                try {
                    try {
                        inputStreamOpenStream = urlA.openStream();
                        while (true) {
                            int i = inputStreamOpenStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                        inputStreamOpenStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        if (inputStreamOpenStream != null) {
                            inputStreamOpenStream.close();
                        }
                    }
                } catch (Throwable th) {
                    if (inputStreamOpenStream != null) {
                        try {
                            inputStreamOpenStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String c(String str) {
        try {
            return new String(b(str), "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static ClassLoader a() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader != null ? contextClassLoader : f.class.getClassLoader();
    }
}
