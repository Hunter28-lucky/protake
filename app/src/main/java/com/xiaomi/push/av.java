package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.SystemClock;
import android.text.TextUtils;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class av {
    private static final AtomicReference<a<aw>> a = new AtomicReference<>(a());

    /* renamed from: a, reason: collision with other field name */
    public static final Pattern f5603a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    public static class a<T> extends FutureTask<T> {
        private long a;

        public a(Callable<T> callable) {
            super(callable);
        }

        public boolean a() {
            return j.m5690a(s.m5702a()) || (isDone() && Math.abs(SystemClock.elapsedRealtime() - this.a) > 1800000);
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            this.a = SystemClock.elapsedRealtime();
            super.run();
        }
    }

    public static final class b extends FilterInputStream {
        private boolean a;

        public b(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int i3;
            if (!this.a && (i3 = super.read(bArr, i, i2)) != -1) {
                return i3;
            }
            this.a = true;
            return -1;
        }
    }

    public static class c {
        public int a;

        /* renamed from: a, reason: collision with other field name */
        public Map<String, String> f5604a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.a), this.f5604a.toString());
        }
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    public static void b() {
        a.set(a());
    }

    public static boolean c(Context context) {
        aw awVarM5209a = m5209a();
        return awVarM5209a != null && awVarM5209a.m5220a();
    }

    public static boolean d(Context context) {
        aw awVarM5209a = m5209a();
        return awVarM5209a != null && 1 == awVarM5209a.a();
    }

    public static boolean e(Context context) {
        aw awVarM5210a = m5210a(context);
        return awVarM5210a != null && awVarM5210a.a() == 0 && 20 == awVarM5210a.b();
    }

    public static boolean f(Context context) {
        aw awVarM5210a = m5210a(context);
        return awVarM5210a != null && awVarM5210a.a() == 0 && 13 == awVarM5210a.b();
    }

    public static boolean g(Context context) {
        aw awVarM5210a = m5210a(context);
        if (awVarM5210a == null || awVarM5210a.a() != 0) {
            return false;
        }
        String strM5221b = awVarM5210a.m5221b();
        if (!"TD-SCDMA".equalsIgnoreCase(strM5221b) && !"CDMA2000".equalsIgnoreCase(strM5221b) && !"WCDMA".equalsIgnoreCase(strM5221b)) {
            switch (awVarM5210a.b()) {
            }
            return false;
        }
        return true;
    }

    public static boolean h(Context context) {
        aw awVarM5210a = m5210a(context);
        if (awVarM5210a == null || awVarM5210a.a() != 0) {
            return false;
        }
        int iB = awVarM5210a.b();
        return iB == 1 || iB == 2 || iB == 4 || iB == 7 || iB == 11;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m5215a() {
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r3) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r3.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r1 = 0
            if (r0 == 0) goto L1c
            android.net.Network r2 = r0.getActiveNetwork()     // Catch: java.lang.Exception -> L1c
            android.net.NetworkCapabilities r0 = r0.getNetworkCapabilities(r2)     // Catch: java.lang.Exception -> L1c
            if (r0 == 0) goto L1c
            r2 = 16
            boolean r0 = r0.hasCapability(r2)     // Catch: java.lang.Exception -> L1c
            goto L1d
        L1c:
            r0 = r1
        L1d:
            if (r0 == 0) goto L26
            boolean r3 = c(r3)
            if (r3 == 0) goto L26
            r1 = 1
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.av.b(android.content.Context):boolean");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Object m5211a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkRequest networkRequestBuild;
        ConnectivityManager.NetworkCallback networkCallback;
        if (context == null) {
            context = s.m5702a();
        }
        ConnectivityManager.NetworkCallback networkCallback2 = null;
        if (context == null || j.m5690a(context)) {
            return null;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            networkRequestBuild = new NetworkRequest.Builder().build();
            networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.xiaomi.push.av.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    av.b();
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    super.onLost(network);
                    av.b();
                }
            };
        } catch (Throwable th) {
            th = th;
        }
        try {
            connectivityManager.registerNetworkCallback(networkRequestBuild, networkCallback);
            return networkCallback;
        } catch (Throwable th2) {
            th = th2;
            networkCallback2 = networkCallback;
            com.xiaomi.channel.commonutils.logger.b.m5113a("exception occurred in adding network callback :" + th);
            return networkCallback2;
        }
    }

    public static void a(Context context, Object obj) {
        if (context == null || obj == null) {
            return;
        }
        try {
            if (obj instanceof ConnectivityManager.NetworkCallback) {
                ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) obj);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("exception occurred in removing network callback :" + th);
        }
    }

    private static a<aw> a() {
        return new a<>(new Callable<aw>() { // from class: com.xiaomi.push.av.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public aw call() {
                NetworkInfo activeNetworkInfo;
                Context contextM5702a = s.m5702a();
                if (contextM5702a == null) {
                    return null;
                }
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) contextM5702a.getSystemService("connectivity");
                    if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                        return null;
                    }
                    return new aw(activeNetworkInfo);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    /* renamed from: a, reason: collision with other method in class */
    public static aw m5209a() {
        AtomicReference<a<aw>> atomicReference = a;
        a<aw> aVarA = atomicReference.get();
        if (aVarA != null) {
            try {
                if (aVarA.a()) {
                    aVarA = a();
                    atomicReference.set(aVarA);
                }
                if (!aVarA.isDone()) {
                    aVarA.run();
                }
                return aVarA.get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, c cVar) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException(com.umeng.analytics.pro.d.R);
        }
        if (url != null) {
            URL url2 = !z ? new URL(a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection httpURLConnectionM5213a = m5213a(context, url2);
                httpURLConnectionM5213a.setConnectTimeout(ModuleDescriptor.MODULE_VERSION);
                httpURLConnectionM5213a.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    httpURLConnectionM5213a.setRequestProperty(HttpHeaders.HEAD_KEY_USER_AGENT, str);
                }
                if (str2 != null) {
                    httpURLConnectionM5213a.setRequestProperty(HttpHeaders.HEAD_KEY_COOKIE, str2);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        httpURLConnectionM5213a.setRequestProperty(str3, map.get(str3));
                    }
                }
                if (cVar != null && (url.getProtocol().equals("http") || url.getProtocol().equals("https"))) {
                    cVar.a = httpURLConnectionM5213a.getResponseCode();
                    if (cVar.f5604a == null) {
                        cVar.f5604a = new HashMap();
                    }
                    int i = 0;
                    while (true) {
                        String headerFieldKey = httpURLConnectionM5213a.getHeaderFieldKey(i);
                        String headerField = httpURLConnectionM5213a.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                            cVar.f5604a.put(headerFieldKey, headerField);
                        }
                        i++;
                    }
                }
                return new b(httpURLConnectionM5213a.getInputStream());
            } catch (IOException e2) {
                throw new IOException("IOException:" + e2.getClass().getSimpleName());
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        }
        throw new IllegalArgumentException(ImagesContract.URL);
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, Platform.UTF_8, null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) throws Throwable {
        InputStream inputStreamA;
        try {
            inputStreamA = a(context, url, z, str, str3);
        } catch (Throwable th) {
            th = th;
            inputStreamA = null;
        }
        try {
            StringBuilder sb = new StringBuilder(1024);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamA, str2));
            char[] cArr = new char[4096];
            while (true) {
                int i = bufferedReader.read(cArr);
                if (-1 != i) {
                    sb.append(cArr, 0, i);
                } else {
                    x.a((Closeable) inputStreamA);
                    return sb.toString();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            x.a((Closeable) inputStreamA);
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, bb.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String str, Map<String, String> map, File file, String str2) throws IOException {
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(ModuleDescriptor.MODULE_VERSION);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, "Keep-Alive");
                httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
                dataOutputStream.writeBytes("\r\n");
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, i);
                        dataOutputStream.flush();
                    }
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.flush();
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                stringBuffer.append(line);
                            } else {
                                String string = stringBuffer.toString();
                                x.a((Closeable) fileInputStream);
                                x.a(bufferedReader);
                                return string;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            throw new IOException("IOException:" + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e4) {
                e = e4;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            x.a((Closeable) null);
            x.a((Closeable) file);
            throw th4;
        }
    }

    public static int a(Context context) {
        aw awVarM5209a = m5209a();
        if (awVarM5209a == null) {
            return -1;
        }
        return awVarM5209a.a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static HttpURLConnection m5213a(Context context, URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5216a(Context context) {
        return a(context) >= 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static aw m5210a(Context context) {
        return m5209a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m5212a(Context context) {
        if (d(context)) {
            return NetworkUtil.NETWORK_TYPE_WIFI;
        }
        aw awVarM5209a = m5209a();
        if (awVarM5209a == null) {
            return "";
        }
        return (awVarM5209a.m5219a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + awVarM5209a.m5221b()).toLowerCase();
    }

    public static at a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static at a(Context context, String str, String str2, Map<String, String> map, String str3) throws IOException {
        boolean zEqualsIgnoreCase;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        at atVar = new at();
        try {
            try {
                try {
                    HttpURLConnection httpURLConnectionM5213a = m5213a(context, m5214a(str));
                    httpURLConnectionM5213a.setConnectTimeout(ModuleDescriptor.MODULE_VERSION);
                    httpURLConnectionM5213a.setReadTimeout(15000);
                    String str4 = str2;
                    if (str2 == 0) {
                        str4 = "GET";
                    }
                    httpURLConnectionM5213a.setRequestMethod(str4);
                    int i = 0;
                    if (map != null) {
                        zEqualsIgnoreCase = com.efs.sdk.base.Constants.CP_GZIP.equalsIgnoreCase(map.get(HttpHeaders.HEAD_KEY_CONTENT_ENCODING));
                        for (String str5 : map.keySet()) {
                            httpURLConnectionM5213a.setRequestProperty(str5, map.get(str5));
                        }
                    } else {
                        zEqualsIgnoreCase = false;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        httpURLConnectionM5213a.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        if (zEqualsIgnoreCase) {
                            outputStream = new GZIPOutputStream(httpURLConnectionM5213a.getOutputStream());
                        } else {
                            outputStream = httpURLConnectionM5213a.getOutputStream();
                        }
                        try {
                            outputStream.write(bytes, 0, bytes.length);
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            throw new IOException("err while request " + str + Constants.COLON_SEPARATOR + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                    atVar.a = httpURLConnectionM5213a.getResponseCode();
                    com.xiaomi.channel.commonutils.logger.b.m5113a("Http POST Response Code: " + atVar.a);
                    while (true) {
                        String headerFieldKey = httpURLConnectionM5213a.getHeaderFieldKey(i);
                        String headerField = httpURLConnectionM5213a.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException unused) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnectionM5213a.getErrorStream())));
                            }
                        } else {
                            atVar.f5602a.put(headerFieldKey, headerField);
                            i = i + 1 + 1;
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new b(httpURLConnectionM5213a.getInputStream())));
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        String property = System.getProperty("line.separator");
                        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                            stringBuffer.append(line);
                            stringBuffer.append(property);
                        }
                        atVar.f5601a = stringBuffer.toString();
                        bufferedReader.close();
                        x.a((Closeable) null);
                        x.a((Closeable) null);
                        return atVar;
                    } catch (IOException e3) {
                        e = e3;
                        throw new IOException("err while request " + str + Constants.COLON_SEPARATOR + e.getClass().getSimpleName());
                    } catch (Throwable th2) {
                        th = th2;
                        throw new IOException(th.getMessage());
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th4) {
            x.a((Closeable) null);
            x.a((Closeable) str2);
            throw th4;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), Platform.UTF_8));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), Platform.UTF_8));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("Failed to convert from params map to string: " + e2);
                    com.xiaomi.channel.commonutils.logger.b.m5113a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    private static URL m5214a(String str) {
        return new URL(str);
    }
}
