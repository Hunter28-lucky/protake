package defpackage;

import com.blink.academy.film.FilmApp;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: AssetsUtils.java */
/* renamed from: ໞ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5015 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static byte[] m14801(String str) {
        try {
            return m14803(FilmApp.m405().getAssets().open(str));
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static byte[] m14802(String str) {
        try {
            return m14803(new FileInputStream(str));
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static byte[] m14803(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                try {
                    try {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    inputStream.close();
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        inputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
