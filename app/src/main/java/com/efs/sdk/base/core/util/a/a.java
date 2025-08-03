package com.efs.sdk.base.core.util.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.http.IHttpUtil;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class a implements IHttpUtil {

    /* renamed from: com.efs.sdk.base.core.util.a.a$a, reason: collision with other inner class name */
    public static class C1845a {
        private static final a a = new a(0);
    }

    private a() {
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        return C1845a.a;
    }

    private static void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                com.efs.sdk.base.core.util.b.a(httpURLConnection.getInputStream());
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final HttpResponse get(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnectionA;
        HttpResponse httpResponse = new HttpResponse();
        int i = 0;
        while (true) {
            if (i >= 3) {
                break;
            }
            httpURLConnectionA = null;
            try {
                try {
                    httpURLConnectionA = a(str, map);
                    httpURLConnectionA.setRequestMethod("GET");
                    httpURLConnectionA.setInstanceFollowRedirects(true);
                    httpURLConnectionA.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE);
                    httpURLConnectionA.connect();
                    httpResponse = a(httpURLConnectionA);
                    b(httpURLConnectionA);
                    break;
                } catch (SocketTimeoutException e2) {
                    httpResponse.setHttpCode(-3);
                    Log.e("efs.util.http", "post file '" + str + "' error", e2);
                } catch (UnknownHostException e3) {
                    httpResponse.setHttpCode(-2);
                    Log.e("efs.util.http", "get request '" + str + "' error， maybe network is disconnect", e3);
                }
            } finally {
                try {
                    b(httpURLConnectionA);
                } catch (Throwable th) {
                    b(httpURLConnectionA);
                }
            }
            b(httpURLConnectionA);
        }
        httpResponse.setReqUrl(str);
        return httpResponse;
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final HttpResponse post(@NonNull String str, @Nullable Map<String, String> map, @NonNull File file) {
        return a(str, map, file, null);
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final HttpResponse postAsFile(String str, Map<String, String> map, byte[] bArr) {
        return a(str, map, null, bArr);
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(ModuleDescriptor.MODULE_VERSION);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        if (map == null) {
            map = Collections.emptyMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return httpURLConnection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.net.HttpURLConnection] */
    @Override // com.efs.sdk.base.http.IHttpUtil
    @NonNull
    public final HttpResponse post(@NonNull String str, @Nullable Map<String, String> map, @NonNull byte[] bArr) {
        HttpResponse httpResponse = new HttpResponse();
        OutputStream outputStream = null;
        try {
            try {
                map = a(str, map);
            } catch (SocketTimeoutException e2) {
                e = e2;
                map = 0;
            } catch (UnknownHostException e3) {
                e = e3;
                map = 0;
            } catch (Throwable th) {
                th = th;
                map = 0;
            }
            try {
                map.setRequestMethod("POST");
                map.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE);
                outputStream = map.getOutputStream();
                outputStream.write(bArr);
                httpResponse = a(map);
            } catch (SocketTimeoutException e4) {
                e = e4;
                httpResponse.setHttpCode(-3);
                Log.e("efs.util.http", "post file '" + str + "' error", e);
                map = map;
                httpResponse.setReqUrl(str);
                return httpResponse;
            } catch (UnknownHostException e5) {
                e = e5;
                httpResponse.setHttpCode(-2);
                Log.e("efs.util.http", "post data to '" + str + "' error， maybe network is disconnect", e);
                map = map;
                httpResponse.setReqUrl(str);
                return httpResponse;
            } catch (Throwable th2) {
                th = th2;
                Log.e("efs.util.http", "post data '" + str + "' error", th);
                map = map;
                httpResponse.setReqUrl(str);
                return httpResponse;
            }
            httpResponse.setReqUrl(str);
            return httpResponse;
        } finally {
            com.efs.sdk.base.core.util.b.a(outputStream);
            b(map);
        }
    }

    private static HttpResponse a(HttpURLConnection httpURLConnection) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream;
        HttpResponse httpResponse = new HttpResponse();
        if (httpURLConnection == null) {
            return httpResponse;
        }
        try {
            httpResponse.setHttpCode(httpURLConnection.getResponseCode());
            inputStream = httpURLConnection.getInputStream();
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                while (true) {
                    try {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            Log.e("efs.util.http", "get response error", th);
                            return httpResponse;
                        } finally {
                            com.efs.sdk.base.core.util.b.a(inputStream);
                            com.efs.sdk.base.core.util.b.a(byteArrayOutputStream);
                        }
                    }
                }
                httpResponse.data = byteArrayOutputStream.toString();
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            inputStream = null;
        }
        return httpResponse;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @NonNull
    private static HttpResponse a(@NonNull String str, @Nullable Map<String, String> map, @Nullable File file, @Nullable byte[] bArr) {
        FileInputStream fileInputStream;
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        FileInputStream fileInputStream4;
        HttpResponse httpResponse = new HttpResponse();
        HttpURLConnection httpURLConnection = null;
         = null;
         = null;
         = null;
        ?? r4 = null;
        httpURLConnection = null;
        httpURLConnection = null;
        httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnectionA = a(str, map);
                try {
                    httpURLConnectionA.setRequestMethod("POST");
                    httpURLConnectionA.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE);
                    httpURLConnectionA.setRequestProperty(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "multipart/form-data;boundary=----WebKitFormBoundaryP0Rfzlf32iRoMhmb");
                    outputStream = httpURLConnectionA.getOutputStream();
                    try {
                        dataOutputStream = new DataOutputStream(outputStream);
                        try {
                            dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb\r\n");
                            if (bArr == 0) {
                                if (file != null && file.exists()) {
                                    dataOutputStream.writeBytes("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
                                    dataOutputStream.writeBytes("\r\n");
                                    fileInputStream4 = new FileInputStream(file);
                                    try {
                                        byte[] bArr2 = new byte[4096];
                                        while (true) {
                                            int i = fileInputStream4.read(bArr2);
                                            if (i == -1) {
                                                break;
                                            }
                                            dataOutputStream.write(bArr2, 0, i);
                                        }
                                        r4 = fileInputStream4;
                                    } catch (SocketTimeoutException e2) {
                                        e = e2;
                                        httpURLConnection = httpURLConnectionA;
                                        fileInputStream3 = fileInputStream4;
                                        httpResponse.setHttpCode(-3);
                                        Log.e("efs.util.http", "post file '" + str + "' error", e);
                                        bArr = fileInputStream3;
                                        httpResponse.setReqUrl(str);
                                        return httpResponse;
                                    } catch (UnknownHostException e3) {
                                        e = e3;
                                        httpURLConnection = httpURLConnectionA;
                                        fileInputStream2 = fileInputStream4;
                                        httpResponse.setHttpCode(-2);
                                        Log.e("efs.util.http", "post file '" + str + "' error， maybe network is disconnect", e);
                                        bArr = fileInputStream2;
                                        httpResponse.setReqUrl(str);
                                        return httpResponse;
                                    } catch (Throwable th) {
                                        th = th;
                                        httpURLConnection = httpURLConnectionA;
                                        fileInputStream = fileInputStream4;
                                        Log.e("efs.util.http", "post file '" + str + "' error", th);
                                        bArr = fileInputStream;
                                        httpResponse.setReqUrl(str);
                                        return httpResponse;
                                    }
                                }
                                b(httpURLConnectionA);
                                com.efs.sdk.base.core.util.b.a(outputStream);
                                com.efs.sdk.base.core.util.b.a(dataOutputStream);
                                com.efs.sdk.base.core.util.b.a((Closeable) null);
                                return httpResponse;
                            }
                            dataOutputStream.writeBytes("Content-Disposition: form-data;name=\"file\";filename=\"f\"\r\n");
                            dataOutputStream.writeBytes("\r\n");
                            dataOutputStream.write(bArr, 0, bArr.length);
                            dataOutputStream.writeBytes("\r\n");
                            dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb--\r\n");
                            httpResponse = a(httpURLConnectionA);
                            b(httpURLConnectionA);
                            com.efs.sdk.base.core.util.b.a(outputStream);
                            com.efs.sdk.base.core.util.b.a(dataOutputStream);
                            com.efs.sdk.base.core.util.b.a((Closeable) r4);
                        } catch (SocketTimeoutException e4) {
                            e = e4;
                            fileInputStream4 = r4;
                        } catch (UnknownHostException e5) {
                            e = e5;
                            fileInputStream4 = r4;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream4 = r4;
                        }
                    } catch (SocketTimeoutException e6) {
                        e = e6;
                        fileInputStream4 = null;
                        dataOutputStream = null;
                    } catch (UnknownHostException e7) {
                        e = e7;
                        fileInputStream4 = null;
                        dataOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream4 = null;
                        dataOutputStream = null;
                    }
                } catch (SocketTimeoutException e8) {
                    e = e8;
                    fileInputStream4 = null;
                    outputStream = null;
                    dataOutputStream = null;
                } catch (UnknownHostException e9) {
                    e = e9;
                    fileInputStream4 = null;
                    outputStream = null;
                    dataOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream4 = null;
                    outputStream = null;
                    dataOutputStream = null;
                }
            } catch (SocketTimeoutException e10) {
                e = e10;
                fileInputStream3 = null;
                outputStream = null;
                dataOutputStream = null;
            } catch (UnknownHostException e11) {
                e = e11;
                fileInputStream2 = null;
                outputStream = null;
                dataOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                outputStream = null;
                dataOutputStream = null;
            }
            httpResponse.setReqUrl(str);
            return httpResponse;
        } finally {
            b(httpURLConnection);
            com.efs.sdk.base.core.util.b.a(outputStream);
            com.efs.sdk.base.core.util.b.a(dataOutputStream);
            com.efs.sdk.base.core.util.b.a((Closeable) bArr);
        }
    }
}
