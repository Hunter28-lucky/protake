package com.efs.sdk.net.a.a;

import androidx.core.app.NotificationCompat;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.a.a.f;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: classes.dex */
public final class b {
    public Map<String, Long> a = new HashMap();

    public static long a(f.a aVar) {
        try {
            if (aVar.d() != null) {
                return r2.length;
            }
            return 0L;
        } catch (IOException | OutOfMemoryError e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static InputStream a(String str, String str2, String str3, InputStream inputStream) throws IOException {
        Log.i("NetTrace-Interceptor", "save interpret response stream");
        com.efs.sdk.net.a.b bVarA = com.efs.sdk.net.a.a.a().a(str);
        bVarA.h = str2;
        if (str2 != null) {
            if (str2.contains(NotificationCompat.MessagingStyle.Message.KEY_TEXT) || str2.contains("json")) {
                ByteArrayOutputStream byteArrayOutputStreamA = a(inputStream, bVarA, str3);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamA.toByteArray());
                try {
                    byteArrayOutputStreamA.close();
                } catch (IOException e2) {
                    Log.e("NetTrace-Interceptor", "save interpret response stream, e is ".concat(String.valueOf(e2)));
                }
                return byteArrayInputStream;
            }
        }
        bVarA.i = 0L;
        return inputStream;
    }

    private static ByteArrayOutputStream a(InputStream inputStream, com.efs.sdk.net.a.b bVar, String str) throws IOException {
        BufferedReader bufferedReader;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (IOException e2) {
                Log.e("NetTrace-Interceptor", "parse and save body, e is ".concat(String.valueOf(e2)));
            }
        }
        byteArrayOutputStream.flush();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        if (Constants.CP_GZIP.equals(str)) {
            bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(byteArrayInputStream)));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream));
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line + '\n');
        }
        bVar.i = sb.toString().getBytes().length;
        return byteArrayOutputStream;
    }
}
