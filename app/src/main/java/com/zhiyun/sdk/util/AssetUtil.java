package com.zhiyun.sdk.util;

import android.content.Context;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class AssetUtil {
    private static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Nullable
    public static String load(Context context, String str) throws Throwable {
        InputStream inputStreamOpen;
        InputStream inputStream = null;
        if (context == null) {
            return null;
        }
        try {
            inputStreamOpen = context.getAssets().open(str);
        } catch (IOException e2) {
            e = e2;
            inputStreamOpen = null;
        } catch (Throwable th) {
            th = th;
            a(inputStream);
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[inputStreamOpen.available()];
                String str2 = new String(bArr, 0, inputStreamOpen.read(bArr));
                a(inputStreamOpen);
                return str2;
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStreamOpen;
                a(inputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            a(inputStreamOpen);
            return null;
        }
    }
}
