package com.mob.tools.network;

import android.content.Context;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;
import com.mob.MobSDK;
import com.mob.commons.o;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.EverythingKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileUtils;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* loaded from: classes2.dex */
public class NetworkHelper implements EverythingKeeper {
    public static int connectionTimeout = 0;
    private static boolean followRedirects = true;
    public static int readTimout;
    public boolean instanceFollowRedirects = followRedirects;

    public static class NetworkTimeOut implements PublicMemberKeeper {
        public int connectionTimeout;
        public int readTimout;
    }

    public static class a implements InvocationHandler {
        private Object a;
        private String b;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            if (name.equals(o.a("018$dgJciWdgdjggeddeYiFdk;dSeidhdcfg4dih"))) {
                return null;
            }
            if (!name.equals(o.a("018Edg*ciHdgdjehCi<dhHji,dheidhdcfgSdih"))) {
                if (name.equals(o.a("018>ff]id,ejdgdg'iedihVegfgfgdcHi;dhfg"))) {
                    try {
                        return Array.newInstance(Class.forName(o.a("034$hfdfUjVdfelfgKiYdgdcdhde:d_dieldg=i0dh%dIelhghefehhggIi*dhDdKdefhdedgdf-di")), 0);
                    } catch (Throwable th) {
                        MobLog.getInstance().e(th);
                        return null;
                    }
                }
                if (name.equals("hashCode")) {
                    return Integer.valueOf(hashCode());
                }
                if (name.equals("toString")) {
                    return toString();
                }
                return null;
            }
            Object[] objArr2 = (Object[]) objArr[0];
            String str = (String) objArr[1];
            if (objArr2 == null) {
                throw new IllegalArgumentException("there were no certificates.");
            }
            if (objArr2.length == 1) {
                try {
                    Method declaredMethod = objArr2[0].getClass().getDeclaredMethod(o.a("013@dg*ci5dgdjgfdfedde%h!deNd0di"), new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(objArr2[0], new Object[0]);
                    return null;
                } catch (Throwable th2) {
                    MobLog.getInstance().e(th2);
                    return null;
                }
            }
            if (this.a == null) {
                throw new CertificateException("there were one more certificates but no trust manager found.");
            }
            try {
                Object objNewInstance = Class.forName("android.net.http.X509TrustManagerExtensions").getConstructor(Class.forName(o.a("0309hfdf j]dfdleldk]idGelfgfgedelhghefehheidhdcfgDdIgidfdkdfff4iCdh"))).newInstance(this.a);
                Method declaredMethod2 = objNewInstance.getClass().getDeclaredMethod(o.a("018AdgBci3dgdjeh'iEdh[ji!dheidhdcfg@dih"), Array.newInstance(Class.forName(o.a("0340hfdf^j<dfelfg(i7dgdcdhdeXd^dieldg.iBdh8dKelhghefehhggQiBdhVd<defhdedgdf(di")), 0).getClass(), String.class, String.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(objNewInstance, objArr2, str, this.b);
                return null;
            } catch (Throwable th3) {
                MobLog.getInstance().e(th3);
                return null;
            }
        }

        private a(String str) throws IllegalAccessException, NoSuchMethodException, NoSuchAlgorithmException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            try {
                this.b = str;
                Method declaredMethod = Class.forName(o.a("0330hfdfEj dfdleldk1id<elfgfgedeleidhdcfgZdEgidfdkdfff!iHdhfkdfdg@d'ecdhdi")).getDeclaredMethod(o.a("011Pff;id3egdkfgJdEdfdkdg'i"), String.class);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, o.a("004Ihghefehh"));
                Method method = objInvoke.getClass().getMethod(o.a("004^dedkde?d"), Class.forName(o.a("0223hfdf8j0dfelfgDiGdgdcdhde9dEdielhjDiUdieh3d?ecdh0i")));
                method.setAccessible(true);
                method.invoke(objInvoke, null);
                Method method2 = objInvoke.getClass().getMethod(o.a("016EffHidReidhdcfgKd2gidfdkdfff1i(dhfg"), new Class[0]);
                method2.setAccessible(true);
                Object[] objArr = (Object[]) method2.invoke(objInvoke, new Object[0]);
                if (objArr == null || objArr.length == 0) {
                    throw new NoSuchAlgorithmException("no trust manager found.");
                }
                this.a = objArr[0];
            } catch (Exception e2) {
                MobLog.getInstance().d("failed to initialize the standard trust manager: " + e2.getMessage(), new Object[0]);
                this.a = null;
            }
        }
    }

    @Deprecated
    public static String checkHttpRequestUrl(String str) {
        return NetCommunicator.checkHttpRequestUrl(str);
    }

    private HttpURLConnection getConnection(String str, NetworkTimeOut networkTimeOut) throws Throwable {
        Object staticField;
        boolean z;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        String strA = o.a("012lidc>ec0h,eiecdjHiAdkfg");
        try {
            staticField = ReflectHelper.getInstanceField(httpURLConnection, strA);
        } catch (Throwable unused) {
            staticField = null;
        }
        if (staticField == null) {
            strA = "PERMITTED_USER_METHODS";
            try {
                staticField = ReflectHelper.getStaticField("HttpURLConnection", "PERMITTED_USER_METHODS");
            } catch (Throwable unused2) {
            }
            z = true;
        } else {
            z = false;
        }
        if (staticField != null) {
            String[] strArr = (String[]) staticField;
            String[] strArr2 = new String[strArr.length + 1];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[strArr.length] = o.a("0053ghejeigghd");
            if (z) {
                ReflectHelper.setStaticField("HttpURLConnection", strA, strArr2);
            } else {
                ReflectHelper.setInstanceField(httpURLConnection, strA, strArr2);
            }
        }
        System.setProperty("http.keepAlive", "false");
        if (httpURLConnection instanceof HttpsURLConnection) {
            X509HostnameVerifier x509HostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SSLContext sSLContext = SSLContext.getInstance(o.a("003Jeiekeh"));
            TrustManager[] trustManagerArr = new TrustManager[0];
            try {
                trustManagerArr = new TrustManager[]{(TrustManager) getTrustManager(httpsURLConnection.getURL().getHost())};
            } catch (Throwable th) {
                MobLog.getInstance().e(th);
            }
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(x509HostnameVerifier);
        }
        int i = networkTimeOut == null ? connectionTimeout : networkTimeOut.connectionTimeout;
        if (i > 0) {
            httpURLConnection.setConnectTimeout(i);
        }
        int i2 = networkTimeOut == null ? readTimout : networkTimeOut.readTimout;
        if (i2 > 0) {
            httpURLConnection.setReadTimeout(i2);
        }
        return httpURLConnection;
    }

    @Deprecated
    private HTTPPart getDataPostHttpPart(HttpURLConnection httpURLConnection, String str, byte[] bArr) throws Throwable {
        ByteArrayPart byteArrayPart = new ByteArrayPart();
        byteArrayPart.append(bArr);
        return byteArrayPart;
    }

    @Deprecated
    private HTTPPart getFilePostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2) throws Throwable {
        FileInputStream fileInputStream;
        String string = UUID.randomUUID().toString();
        httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "multipart/form-data; boundary=" + string);
        MultiPart multiPart = new MultiPart();
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            Iterator<KVPair<String>> it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                stringPart.append("--").append(string).append("\r\n");
                stringPart.append("Content-Disposition: form-data; name=\"").append(next.name).append("\"\r\n\r\n");
                stringPart.append(next.value).append("\r\n");
            }
        }
        multiPart.append(stringPart);
        Iterator<KVPair<String>> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            KVPair<String> next2 = it2.next();
            StringPart stringPart2 = new StringPart();
            File file = new File(next2.value);
            stringPart2.append("--").append(string).append("\r\n");
            stringPart2.append("Content-Disposition: form-data; name=\"").append(next2.name).append("\"; filename=\"").append(file.getName()).append("\"\r\n");
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(next2.value);
            if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                if (next2.value.toLowerCase().endsWith("jpg") || next2.value.toLowerCase().endsWith("jpeg")) {
                    contentTypeFor = "image/jpeg";
                } else if (next2.value.toLowerCase().endsWith("png")) {
                    contentTypeFor = "image/png";
                } else if (next2.value.toLowerCase().endsWith("gif")) {
                    contentTypeFor = "image/gif";
                } else {
                    FileInputStream fileInputStream2 = null;
                    try {
                        fileInputStream = new FileInputStream(next2.value);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        contentTypeFor = URLConnection.guessContentTypeFromStream(fileInputStream);
                        FileUtils.closeIO(fileInputStream);
                        if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                            contentTypeFor = "application/octet-stream";
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        FileUtils.closeIO(fileInputStream2);
                        throw th;
                    }
                }
            }
            stringPart2.append("Content-Type: ").append(contentTypeFor).append("\r\n\r\n");
            multiPart.append(stringPart2);
            FilePart filePart = new FilePart();
            filePart.setFile(next2.value);
            multiPart.append(filePart);
            StringPart stringPart3 = new StringPart();
            stringPart3.append("\r\n");
            multiPart.append(stringPart3);
        }
        StringPart stringPart4 = new StringPart();
        stringPart4.append("--").append(string).append("--\r\n");
        multiPart.append(stringPart4);
        return multiPart;
    }

    @Deprecated
    private HTTPPart getTextPostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList) throws Throwable {
        httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_CONTENT_TYPE, o.a("0335dfMeeGeddedgdf=dKdeecdkAg6dlhifdfdfdhifhecdh,l^hidcdhed)i,dkdgecIhih"));
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            stringPart.append(requestParamsToUrl(kvPairsToObjHashMap(arrayList)));
        }
        return stringPart;
    }

    public static Object getTrustManager(String str) throws Throwable {
        Class<?> cls = Class.forName(o.a("030LhfdfHjLdfdleldkDid0elfgfgedelhghefehheidhdcfg6dDgidfdkdfffJiVdh"));
        return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{cls}, new a(str));
    }

    @Deprecated
    private HashMap<String, Object> kvPairsToObjHashMap(ArrayList<KVPair<String>> arrayList) throws Throwable {
        if (arrayList == null) {
            return null;
        }
        HashMap<String, Object> map = new HashMap<>();
        Iterator<KVPair<String>> it = arrayList.iterator();
        while (it.hasNext()) {
            KVPair<String> next = it.next();
            map.put(next.name, next.value);
        }
        return map;
    }

    @Deprecated
    private HashMap<String, String> kvPairsToStrHashMap(ArrayList<KVPair<String>> arrayList) throws Throwable {
        if (arrayList == null) {
            return null;
        }
        HashMap<String, String> map = new HashMap<>();
        Iterator<KVPair<String>> it = arrayList.iterator();
        while (it.hasNext()) {
            KVPair<String> next = it.next();
            map.put(next.name, next.value);
        }
        return map;
    }

    private String requestParamsToUrl(HashMap<String, Object> map) throws Throwable {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String strUrlEncode = Data.urlEncode(entry.getKey(), "utf-8");
            String strUrlEncode2 = entry.getValue() == null ? "" : Data.urlEncode(String.valueOf(entry.getValue()), "utf-8");
            if (sb.length() > 0) {
                sb.append('&');
            }
            sb.append(strUrlEncode);
            sb.append('=');
            sb.append(strUrlEncode2);
        }
        return sb.toString();
    }

    private void setHeader(URLConnection uRLConnection, HashMap<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            uRLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public void download(String str, final OutputStream outputStream, NetworkTimeOut networkTimeOut) throws Throwable {
        final byte[] bArr = new byte[1024];
        rawGet(str, new RawNetworkCallback() { // from class: com.mob.tools.network.NetworkHelper.1
            @Override // com.mob.tools.network.RawNetworkCallback
            public void onResponse(InputStream inputStream) throws Throwable {
                int i = inputStream.read(bArr);
                while (i != -1) {
                    outputStream.write(bArr, 0, i);
                    i = inputStream.read(bArr);
                }
            }
        }, networkTimeOut);
        outputStream.flush();
    }

    public String downloadCache(Context context, String str, String str2, boolean z, NetworkTimeOut networkTimeOut) throws Throwable {
        return downloadCache(context, str, str2, z, networkTimeOut, null);
    }

    @Deprecated
    public String httpGet(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        return httpGetNew(str, kvPairsToObjHashMap(arrayList), kvPairsToStrHashMap(arrayList2), networkTimeOut);
    }

    public String httpGetNew(String str, HashMap<String, Object> map, HashMap<String, String> map2, NetworkTimeOut networkTimeOut) throws Throwable {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader2;
        MobLog.getInstance().d(String.format("hgt: %s", str) + "\n" + String.format("hd: %s", map2), new Object[0]);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (map != null) {
            String strRequestParamsToUrl = requestParamsToUrl(map);
            if (strRequestParamsToUrl.length() > 0) {
                str = str + "?" + strRequestParamsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        setHeader(connection, map2);
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        int responseCode = connection.getResponseCode();
        BufferedReader bufferedReader3 = null;
        if (responseCode != 200) {
            StringBuilder sb = new StringBuilder();
            try {
                inputStreamReader = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
            try {
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    if (sb.length() > 0) {
                        sb.append('\n');
                    }
                    sb.append(line);
                }
                FileUtils.closeIO(bufferedReader, inputStreamReader);
                connection.disconnect();
                HashMap map3 = new HashMap();
                map3.put(o.a("005iTdhdhecdh"), sb.toString());
                map3.put(o.a("0066fg@dSdf>dGdcfg"), Integer.valueOf(responseCode));
                throw new Throwable(HashonHelper.fromHashMap(map3));
            } catch (Throwable th3) {
                th = th3;
                bufferedReader3 = bufferedReader;
                FileUtils.closeIO(bufferedReader3, inputStreamReader);
                throw th;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            inputStreamReader2 = new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8"));
            try {
                bufferedReader2 = new BufferedReader(inputStreamReader2);
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader2 = null;
        }
        try {
            for (String line2 = bufferedReader2.readLine(); line2 != null; line2 = bufferedReader2.readLine()) {
                if (sb2.length() > 0) {
                    sb2.append('\n');
                }
                sb2.append(line2);
            }
            FileUtils.closeIO(bufferedReader2, inputStreamReader2);
            connection.disconnect();
            String string = sb2.toString();
            MobLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            return string;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader3 = bufferedReader2;
            FileUtils.closeIO(bufferedReader3, inputStreamReader2);
            throw th;
        }
    }

    @Deprecated
    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        return httpPostNew(str, kvPairsToObjHashMap(arrayList), kvPairsToStrHashMap(arrayList2), networkTimeOut);
    }

    @Deprecated
    public String httpPostFiles(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, int i, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap map = new HashMap();
        httpPost(str, arrayList, arrayList2, arrayList3, i, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.3
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStreamReader inputStreamReader;
                InputStreamReader inputStreamReader2;
                BufferedReader bufferedReader;
                int responseCode = httpConnection.getResponseCode();
                BufferedReader bufferedReader2 = null;
                if (responseCode == 200 || responseCode < 300) {
                    StringBuilder sb = new StringBuilder();
                    try {
                        inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader);
                            try {
                                for (String line = bufferedReader3.readLine(); line != null; line = bufferedReader3.readLine()) {
                                    if (sb.length() > 0) {
                                        sb.append('\n');
                                    }
                                    sb.append(line);
                                }
                                FileUtils.closeIO(bufferedReader3, inputStreamReader);
                                map.put("resp", sb.toString());
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader3;
                                FileUtils.closeIO(bufferedReader2, inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = null;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        inputStreamReader2 = new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8"));
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader2);
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        try {
                            for (String line2 = bufferedReader.readLine(); line2 != null; line2 = bufferedReader.readLine()) {
                                if (sb2.length() > 0) {
                                    sb2.append('\n');
                                }
                                sb2.append(line2);
                            }
                            FileUtils.closeIO(bufferedReader, inputStreamReader2);
                            HashMap map2 = new HashMap();
                            map2.put(o.a("005iZdhdhecdh"), sb2.toString());
                            map2.put(o.a("006*fgHd=dfQd!dcfg"), Integer.valueOf(responseCode));
                            throw new Throwable(new Hashon().fromHashMap(map2));
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader2 = bufferedReader;
                            FileUtils.closeIO(bufferedReader2, inputStreamReader2);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStreamReader2 = null;
                    }
                }
            }
        }, networkTimeOut);
        return (String) map.get("resp");
    }

    @Deprecated
    public String httpPostFilesChecked(String str, ArrayList<KVPair<String>> arrayList, byte[] bArr, ArrayList<KVPair<String>> arrayList2, int i, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap map = new HashMap();
        httpPost(str, arrayList, bArr, arrayList2, i, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.4
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStreamReader inputStreamReader;
                InputStreamReader inputStreamReader2;
                BufferedReader bufferedReader;
                int responseCode = httpConnection.getResponseCode();
                BufferedReader bufferedReader2 = null;
                if (responseCode == 200 || responseCode < 300) {
                    StringBuilder sb = new StringBuilder();
                    try {
                        inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader);
                            try {
                                for (String line = bufferedReader3.readLine(); line != null; line = bufferedReader3.readLine()) {
                                    if (sb.length() > 0) {
                                        sb.append('\n');
                                    }
                                    sb.append(line);
                                }
                                FileUtils.closeIO(bufferedReader3, inputStreamReader);
                                map.put("resp", sb.toString());
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader3;
                                FileUtils.closeIO(bufferedReader2, inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = null;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        inputStreamReader2 = new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8"));
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader2);
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        try {
                            for (String line2 = bufferedReader.readLine(); line2 != null; line2 = bufferedReader.readLine()) {
                                if (sb2.length() > 0) {
                                    sb2.append('\n');
                                }
                                sb2.append(line2);
                            }
                            FileUtils.closeIO(bufferedReader, inputStreamReader2);
                            HashMap map2 = new HashMap();
                            map2.put(o.a("005i5dhdhecdh"), sb2.toString());
                            map2.put(o.a("006:fg%d2df)d,dcfg"), Integer.valueOf(responseCode));
                            throw new Throwable(new Hashon().fromHashMap(map2));
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader2 = bufferedReader;
                            FileUtils.closeIO(bufferedReader2, inputStreamReader2);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStreamReader2 = null;
                    }
                }
            }
        }, networkTimeOut);
        return (String) map.get("resp");
    }

    public String httpPostNew(String str, HashMap<String, Object> map, HashMap<String, String> map2, NetworkTimeOut networkTimeOut) throws Throwable {
        InputStream inputStream;
        OutputStream outputStream;
        InputStream inputStream2;
        Throwable th;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().d("hpt: " + str + "\nhd: " + map2, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        setHeader(connection, map2);
        connection.setRequestProperty(o.a("010HggecdkdkOi<dgYd1deecdk"), "Keep-Alive");
        connection.setRequestProperty(HttpHeaders.HEAD_KEY_CONTENT_TYPE, o.a("033.df;eeBeddedgdfNdRdeecdk'gUdlhifdfdfdhifhecdh%lRhidcdhedIi,dkdgec1hih"));
        StringPart stringPart = new StringPart();
        if (map != null) {
            stringPart.append(requestParamsToUrl(map));
        }
        connection.setFixedLengthStreamingMode((int) stringPart.b());
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        try {
            outputStream = connection.getOutputStream();
            try {
                inputStream2 = stringPart.toInputStream();
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            outputStream = null;
        }
        try {
            byte[] bArr = new byte[65536];
            for (int i = inputStream2.read(bArr); i > 0; i = inputStream2.read(bArr)) {
                outputStream.write(bArr, 0, i);
            }
            outputStream.flush();
            int responseCode = connection.getResponseCode();
            if (responseCode != 200 && responseCode >= 300) {
                StringBuilder sb = new StringBuilder();
                try {
                    inputStreamReader3 = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
                    try {
                        bufferedReader2 = new BufferedReader(inputStreamReader3);
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader2 = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader2 = null;
                    inputStreamReader3 = null;
                }
                try {
                    for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(line);
                    }
                    FileUtils.closeIO(bufferedReader2, inputStreamReader3);
                    HashMap map3 = new HashMap();
                    map3.put(o.a("005i;dhdhecdh"), sb.toString());
                    map3.put(o.a("006GfgLd9dfAdEdcfg"), Integer.valueOf(responseCode));
                    throw new Throwable(HashonHelper.fromHashMap(map3));
                } catch (Throwable th6) {
                    th = th6;
                    FileUtils.closeIO(bufferedReader2, inputStreamReader3);
                    throw th;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            try {
                inputStreamReader2 = new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8"));
            } catch (Throwable th7) {
                th = th7;
                inputStreamReader = null;
            }
            try {
                BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
                try {
                    for (String line2 = bufferedReader3.readLine(); line2 != null; line2 = bufferedReader3.readLine()) {
                        if (sb2.length() > 0) {
                            sb2.append('\n');
                        }
                        sb2.append(line2);
                    }
                    FileUtils.closeIO(bufferedReader3, inputStreamReader2);
                    String string = sb2.toString();
                    connection.disconnect();
                    FileUtils.closeIO(inputStream2, outputStream);
                    MobLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                    return string;
                } catch (Throwable th8) {
                    th = th8;
                    inputStreamReader = inputStreamReader2;
                    bufferedReader = bufferedReader3;
                    FileUtils.closeIO(bufferedReader, inputStreamReader);
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                inputStreamReader = inputStreamReader2;
                bufferedReader = null;
                FileUtils.closeIO(bufferedReader, inputStreamReader);
                throw th;
            }
        } catch (Throwable th10) {
            th = th10;
            inputStream = inputStream2;
            connection.disconnect();
            FileUtils.closeIO(inputStream, outputStream);
            MobLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            throw th;
        }
    }

    public String httpPostWithBytes(String str, byte[] bArr, HashMap<String, String> map, NetworkTimeOut networkTimeOut) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        OutputStream outputStream;
        ByteArrayInputStream byteArrayInputStream2;
        Throwable th;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader3;
        BufferedReader bufferedReader3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().d("hpt: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        setHeader(connection, map);
        connection.setRequestProperty(o.a("010[ggecdkdk'i-dgBd%deecdk"), "Keep-Alive");
        connection.setRequestProperty(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/octet-stream");
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        try {
            outputStream = connection.getOutputStream();
            try {
                byte[] bytes = MobSDK.getAppkey().getBytes("utf-8");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(bytes.length);
                dataOutputStream.write(bytes);
                dataOutputStream.write(bArr);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            } catch (Throwable th2) {
                th = th2;
                byteArrayInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
            outputStream = null;
        }
        try {
            byte[] bArr2 = new byte[65536];
            for (int i = byteArrayInputStream2.read(bArr2); i > 0; i = byteArrayInputStream2.read(bArr2)) {
                outputStream.write(bArr2, 0, i);
            }
            outputStream.flush();
            int responseCode = connection.getResponseCode();
            if (responseCode != 200 && responseCode >= 300) {
                StringBuilder sb = new StringBuilder();
                try {
                    inputStreamReader3 = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
                    try {
                        bufferedReader3 = new BufferedReader(inputStreamReader3);
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader2 = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader2 = null;
                    inputStreamReader3 = null;
                }
                try {
                    for (String line = bufferedReader3.readLine(); line != null; line = bufferedReader3.readLine()) {
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(line);
                    }
                    FileUtils.closeIO(bufferedReader3, inputStreamReader3);
                    HashMap map2 = new HashMap();
                    map2.put(o.a("005i+dhdhecdh"), sb.toString());
                    map2.put(o.a("006 fg;dRdfAdCdcfg"), Integer.valueOf(responseCode));
                    throw new Throwable(HashonHelper.fromHashMap(map2));
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader2 = bufferedReader3;
                    FileUtils.closeIO(bufferedReader2, inputStreamReader3);
                    throw th;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            try {
                inputStreamReader2 = new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8"));
            } catch (Throwable th7) {
                th = th7;
                inputStreamReader = null;
            }
            try {
                BufferedReader bufferedReader4 = new BufferedReader(inputStreamReader2);
                try {
                    for (String line2 = bufferedReader4.readLine(); line2 != null; line2 = bufferedReader4.readLine()) {
                        if (sb2.length() > 0) {
                            sb2.append('\n');
                        }
                        sb2.append(line2);
                    }
                    FileUtils.closeIO(bufferedReader4, inputStreamReader2);
                    String string = sb2.toString();
                    connection.disconnect();
                    FileUtils.closeIO(byteArrayInputStream2, outputStream);
                    MobLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                    return string;
                } catch (Throwable th8) {
                    th = th8;
                    inputStreamReader = inputStreamReader2;
                    bufferedReader = bufferedReader4;
                    FileUtils.closeIO(bufferedReader, inputStreamReader);
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                inputStreamReader = inputStreamReader2;
                bufferedReader = null;
                FileUtils.closeIO(bufferedReader, inputStreamReader);
                throw th;
            }
        } catch (Throwable th10) {
            th = th10;
            byteArrayInputStream = byteArrayInputStream2;
            connection.disconnect();
            FileUtils.closeIO(byteArrayInputStream, outputStream);
            MobLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            throw th;
        }
    }

    @Deprecated
    public String httpPut(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        return httpPut(str, kvPairsToObjHashMap(arrayList), kVPair, arrayList2, networkTimeOut, null);
    }

    @Deprecated
    public String jsonPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap map = new HashMap();
        jsonPost(str, arrayList, arrayList2, networkTimeOut, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.2
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStreamReader inputStreamReader;
                BufferedReader bufferedReader;
                InputStreamReader inputStreamReader2;
                BufferedReader bufferedReader2;
                int responseCode = httpConnection.getResponseCode();
                BufferedReader bufferedReader3 = null;
                if (responseCode == 200 || responseCode == 201) {
                    StringBuilder sb = new StringBuilder();
                    try {
                        inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8"));
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader = null;
                    }
                    try {
                        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                            if (sb.length() > 0) {
                                sb.append('\n');
                            }
                            sb.append(line);
                        }
                        FileUtils.closeIO(bufferedReader, inputStreamReader);
                        map.put(o.a("003_dh9i>fg"), sb.toString());
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader3 = bufferedReader;
                        FileUtils.closeIO(bufferedReader3, inputStreamReader);
                        throw th;
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                try {
                    inputStreamReader2 = new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8"));
                    try {
                        bufferedReader2 = new BufferedReader(inputStreamReader2);
                    } catch (Throwable th4) {
                        th = th4;
                    }
                    try {
                        for (String line2 = bufferedReader2.readLine(); line2 != null; line2 = bufferedReader2.readLine()) {
                            if (sb2.length() > 0) {
                                sb2.append('\n');
                            }
                            sb2.append(line2);
                        }
                        FileUtils.closeIO(bufferedReader2, inputStreamReader2);
                        HashMap map2 = new HashMap();
                        map2.put(o.a("005i,dhdhecdh"), sb2.toString());
                        map2.put(o.a("006)fgBd7dfBd+dcfg"), Integer.valueOf(responseCode));
                        throw new Throwable(new Hashon().fromHashMap(map2));
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader3 = bufferedReader2;
                        FileUtils.closeIO(bufferedReader3, inputStreamReader2);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStreamReader2 = null;
                }
            }
        });
        if (map.containsKey(o.a("003%dh+i:fg"))) {
            return (String) map.get(o.a("003Cdh?iTfg"));
        }
        return null;
    }

    @Deprecated
    public void rawGet(String str, ArrayList<KVPair<String>> arrayList, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawGet(str, kvPairsToStrHashMap(arrayList), rawNetworkCallback, networkTimeOut);
    }

    @Deprecated
    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawPost(str, arrayList, hTTPPart, 0, httpResponseCallback, networkTimeOut);
    }

    public String downloadCache(Context context, String str, String str2, boolean z, NetworkTimeOut networkTimeOut, FileDownloadListener fileDownloadListener) throws Throwable {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String string;
        String strMD5;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        int i;
        byte[] bArr;
        int i2;
        List<String> list;
        int iLastIndexOf;
        List<String> list2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().i("downloading: " + str);
        if (z) {
            File file = new File(ResHelper.getCachePath(context, str2), Data.MD5(str));
            if (z && file.exists()) {
                MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (fileDownloadListener != null) {
                    fileDownloadListener.onProgress(100, file.length(), file.length());
                }
                return file.getAbsolutePath();
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            if (headerFields == null || (list2 = headerFields.get(HttpHeaders.HEAD_KEY_CONTENT_DISPOSITION)) == null || list2.size() <= 0) {
                string = null;
            } else {
                string = null;
                for (String str3 : list2.get(0).split(";")) {
                    if (str3.trim().startsWith("filename")) {
                        String str4 = str3.split("=")[1];
                        string = (str4.startsWith("\"") && str4.endsWith("\"")) ? str4.substring(1, str4.length() - 1) : str4;
                    }
                }
            }
            if (string == null) {
                strMD5 = Data.MD5(str);
                if (headerFields != null && (list = headerFields.get(HttpHeaders.HEAD_KEY_CONTENT_TYPE)) != null && list.size() > 0) {
                    String str5 = list.get(0);
                    String strTrim = str5 == null ? "" : str5.trim();
                    if (strTrim.startsWith("image/")) {
                        String strSubstring = strTrim.substring(6);
                        StringBuilder sb = new StringBuilder();
                        sb.append(strMD5);
                        sb.append(".");
                        if ("jpeg".equals(strSubstring)) {
                            strSubstring = "jpg";
                        }
                        sb.append(strSubstring);
                        string = sb.toString();
                    } else {
                        int iLastIndexOf2 = str.lastIndexOf(47);
                        String strSubstring2 = iLastIndexOf2 > 0 ? str.substring(iLastIndexOf2 + 1) : null;
                        if (strSubstring2 != null && strSubstring2.length() > 0 && (iLastIndexOf = strSubstring2.lastIndexOf(46)) > 0 && strSubstring2.length() - iLastIndexOf < 10) {
                            string = strMD5 + strSubstring2.substring(iLastIndexOf);
                        }
                    }
                    strMD5 = string;
                }
            } else {
                strMD5 = string;
            }
            File file2 = new File(ResHelper.getCachePath(context, str2), strMD5);
            if (z && file2.exists()) {
                connection.disconnect();
                MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (fileDownloadListener != null) {
                    fileDownloadListener.onProgress(100, file2.length(), file2.length());
                }
                return file2.getAbsolutePath();
            }
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (file2.exists()) {
                file2.delete();
            }
            if (fileDownloadListener != null) {
                try {
                    if (fileDownloadListener.isCanceled()) {
                        if (!file2.exists()) {
                            return null;
                        }
                        file2.delete();
                        return null;
                    }
                } finally {
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
            }
            try {
                inputStream = connection.getInputStream();
                try {
                    int contentLength = connection.getContentLength();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        byte[] bArr2 = new byte[1024];
                        int i3 = inputStream.read(bArr2);
                        int i4 = 0;
                        while (true) {
                            if (i3 <= 0) {
                                fileOutputStream = fileOutputStream2;
                                break;
                            }
                            fileOutputStream2.write(bArr2, 0, i3);
                            int i5 = i4 + i3;
                            if (fileDownloadListener != null) {
                                int i6 = contentLength <= 0 ? 100 : (i5 * 100) / contentLength;
                                fileOutputStream = fileOutputStream2;
                                long j = contentLength;
                                i = contentLength;
                                bArr = bArr2;
                                i2 = i5;
                                try {
                                    fileDownloadListener.onProgress(i6, i5, j);
                                    if (fileDownloadListener.isCanceled()) {
                                        break;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    FileUtils.closeIO(inputStream, fileOutputStream);
                                    throw th;
                                }
                            } else {
                                i = contentLength;
                                bArr = bArr2;
                                i2 = i5;
                                fileOutputStream = fileOutputStream2;
                            }
                            i3 = inputStream.read(bArr);
                            bArr2 = bArr;
                            fileOutputStream2 = fileOutputStream;
                            i4 = i2;
                            contentLength = i;
                        }
                        if (fileDownloadListener != null) {
                            if (fileDownloadListener.isCanceled()) {
                                fileOutputStream.flush();
                                FileUtils.closeIO(inputStream, fileOutputStream);
                                return null;
                            }
                            fileDownloadListener.onProgress(100, file2.length(), file2.length());
                        }
                        fileOutputStream.flush();
                        FileUtils.closeIO(inputStream, fileOutputStream);
                        connection.disconnect();
                        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                        return file2.getAbsolutePath();
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                fileOutputStream = null;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            try {
                inputStreamReader = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    try {
                        for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                            if (sb2.length() > 0) {
                                sb2.append('\n');
                            }
                            sb2.append(line);
                        }
                        FileUtils.closeIO(bufferedReader2, inputStreamReader);
                        connection.disconnect();
                        HashMap map = new HashMap();
                        map.put(o.a("005i]dhdhecdh"), sb2.toString());
                        map.put(o.a("0062fgEdQdf;dDdcfg"), Integer.valueOf(responseCode));
                        throw new Throwable(new Hashon().fromHashMap(map));
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        FileUtils.closeIO(bufferedReader, inputStreamReader);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader = null;
                }
            } catch (Throwable th7) {
                th = th7;
                inputStreamReader = null;
                bufferedReader = null;
            }
        }
    }

    public String httpGet(String str, HashMap<String, Object> map, HashMap<String, String> map2) throws Throwable {
        NetworkTimeOut networkTimeOut = new NetworkTimeOut();
        networkTimeOut.readTimout = 30000;
        networkTimeOut.connectionTimeout = ModuleDescriptor.MODULE_VERSION;
        return httpGetNew(str, map, map2, networkTimeOut);
    }

    @Deprecated
    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, int i, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        HTTPPart textPostHTTPPart;
        OutputStream outputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().i("httpPost: " + str);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setRequestProperty(o.a("010+ggecdkdkXi-dgRdGdeecdk"), "Keep-Alive");
        if (arrayList2 == null || arrayList2.size() <= 0) {
            textPostHTTPPart = getTextPostHTTPPart(connection, str, arrayList);
            connection.setFixedLengthStreamingMode((int) textPostHTTPPart.b());
        } else {
            textPostHTTPPart = getFilePostHTTPPart(connection, str, arrayList, arrayList2);
            if (i >= 0) {
                connection.setChunkedStreamingMode(i);
            }
        }
        if (arrayList3 != null) {
            Iterator<KVPair<String>> it = arrayList3.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        InputStream inputStream = null;
        try {
            outputStream = connection.getOutputStream();
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            inputStream = textPostHTTPPart.toInputStream();
            byte[] bArr = new byte[65536];
            for (int i2 = inputStream.read(bArr); i2 > 0; i2 = inputStream.read(bArr)) {
                outputStream.write(bArr, 0, i2);
            }
            outputStream.flush();
            FileUtils.closeIO(inputStream, outputStream);
            if (httpResponseCallback != null) {
                try {
                    httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                    connection.disconnect();
                } finally {
                }
            }
            MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable th2) {
            th = th2;
            FileUtils.closeIO(inputStream, outputStream);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public String httpPut(String str, HashMap<String, Object> map, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList, NetworkTimeOut networkTimeOut, OnReadListener onReadListener) throws Throwable {
        OutputStream outputStream;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().i("httpPut: " + str);
        if (map != null) {
            String strRequestParamsToUrl = requestParamsToUrl(map);
            if (strRequestParamsToUrl.length() > 0) {
                str = str + "?" + strRequestParamsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestMethod("PUT");
        connection.setRequestProperty(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/octet-stream");
        setHeader(connection, kvPairsToStrHashMap(arrayList));
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        InputStream inputStream2 = null;
        try {
            outputStream = connection.getOutputStream();
            try {
                FilePart filePart = new FilePart();
                if (onReadListener != null) {
                    filePart.setOnReadListener(onReadListener);
                }
                filePart.setFile(kVPair.value);
                inputStream = filePart.toInputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
        try {
            byte[] bArr = new byte[65536];
            for (int i = inputStream.read(bArr); i > 0; i = inputStream.read(bArr)) {
                outputStream.write(bArr, 0, i);
            }
            outputStream.flush();
            FileUtils.closeIO(inputStream, outputStream);
            int responseCode = connection.getResponseCode();
            if (responseCode != 200 && responseCode != 201) {
                StringBuilder sb = new StringBuilder();
                try {
                    inputStreamReader2 = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
                    try {
                        bufferedReader2 = new BufferedReader(inputStreamReader2);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader2 = null;
                }
                try {
                    for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(line);
                    }
                    FileUtils.closeIO(bufferedReader2, inputStreamReader2);
                    HashMap map2 = new HashMap();
                    map2.put(o.a("005i<dhdhecdh"), sb.toString());
                    map2.put(o.a("0069fgId'df:d!dcfg"), Integer.valueOf(responseCode));
                    throw new Throwable(new Hashon().fromHashMap(map2));
                } catch (Throwable th5) {
                    th = th5;
                    inputStream2 = bufferedReader2;
                    FileUtils.closeIO(inputStream2, inputStreamReader2);
                    throw th;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            try {
                inputStreamReader = new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8"));
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
                inputStreamReader = null;
            }
            try {
                for (String line2 = bufferedReader.readLine(); line2 != null; line2 = bufferedReader.readLine()) {
                    if (sb2.length() > 0) {
                        sb2.append('\n');
                    }
                    sb2.append(line2);
                }
                FileUtils.closeIO(bufferedReader, inputStreamReader);
                connection.disconnect();
                String string = sb2.toString();
                MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                return string;
            } catch (Throwable th8) {
                th = th8;
                inputStream2 = bufferedReader;
                FileUtils.closeIO(inputStream2, inputStreamReader);
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            inputStream2 = inputStream;
            FileUtils.closeIO(inputStream2, outputStream);
            throw th;
        }
    }

    @Deprecated
    public void rawGet(String str, ArrayList<KVPair<String>> arrayList, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawGet(str, kvPairsToStrHashMap(arrayList), httpResponseCallback, networkTimeOut);
    }

    @Deprecated
    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, int i, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawPost(str, kvPairsToStrHashMap(arrayList), hTTPPart, 0, httpResponseCallback, networkTimeOut);
    }

    public void rawGet(String str, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawGet(str, new HashMap<>(), rawNetworkCallback, networkTimeOut);
    }

    public void rawPost(String str, HashMap<String, String> map, HTTPPart hTTPPart, int i, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        OutputStream outputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().d("hptr: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        if (i >= 0) {
            connection.setChunkedStreamingMode(0);
        }
        setHeader(connection, map);
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        InputStream inputStream = null;
        try {
            outputStream = connection.getOutputStream();
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            inputStream = hTTPPart.toInputStream();
            byte[] bArr = new byte[65536];
            for (int i2 = inputStream.read(bArr); i2 > 0; i2 = inputStream.read(bArr)) {
                outputStream.write(bArr, 0, i2);
            }
            outputStream.flush();
            FileUtils.closeIO(inputStream, outputStream);
            if (httpResponseCallback != null) {
                try {
                    httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                    connection.disconnect();
                } finally {
                }
            }
            MobLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        } catch (Throwable th2) {
            th = th2;
            FileUtils.closeIO(inputStream, outputStream);
            throw th;
        }
    }

    public void rawGet(String str, HashMap<String, String> map, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().d("rawGet: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        setHeader(connection, map);
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            if (rawNetworkCallback != null) {
                rawNetworkCallback.onResponse(connection.getInputStream());
            }
            connection.disconnect();
            MobLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (Throwable th) {
                th = th;
            }
            try {
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    if (sb.length() > 0) {
                        sb.append('\n');
                    }
                    sb.append(line);
                }
                FileUtils.closeIO(bufferedReader, inputStreamReader);
                connection.disconnect();
                HashMap map2 = new HashMap();
                map2.put(o.a("005iKdhdhecdh"), sb.toString());
                map2.put(o.a("006_fg5d5df[d2dcfg"), Integer.valueOf(responseCode));
                throw new Throwable(HashonHelper.fromHashMap(map2));
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                FileUtils.closeIO(bufferedReader2, inputStreamReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    @Deprecated
    private void jsonPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut, HttpResponseCallback httpResponseCallback) throws Throwable {
        HashMap<String, Object> map = new HashMap<>();
        Iterator<KVPair<String>> it = arrayList.iterator();
        while (it.hasNext()) {
            KVPair<String> next = it.next();
            map.put(next.name, next.value);
        }
        jsonPost(str, map, arrayList2, networkTimeOut, httpResponseCallback);
    }

    @Deprecated
    public void jsonPost(String str, HashMap<String, Object> map, ArrayList<KVPair<String>> arrayList, NetworkTimeOut networkTimeOut, HttpResponseCallback httpResponseCallback) throws Throwable {
        OutputStream outputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().i("jsonPost: " + str);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestProperty("content-type", "application/json");
        if (arrayList != null) {
            Iterator<KVPair<String>> it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        StringPart stringPart = new StringPart();
        if (map != null) {
            stringPart.append(new Hashon().fromHashMap(map));
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        InputStream inputStream = null;
        try {
            outputStream = connection.getOutputStream();
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            inputStream = stringPart.toInputStream();
            byte[] bArr = new byte[65536];
            for (int i = inputStream.read(bArr); i > 0; i = inputStream.read(bArr)) {
                outputStream.write(bArr, 0, i);
            }
            outputStream.flush();
            FileUtils.closeIO(inputStream, outputStream);
            if (httpResponseCallback != null) {
                try {
                    httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                    connection.disconnect();
                } finally {
                }
            }
            MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable th2) {
            th = th2;
            FileUtils.closeIO(inputStream, outputStream);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        OutputStream outputStream;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().i("rawpost: " + str);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        if (arrayList != null) {
            Iterator<KVPair<String>> it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        InputStream inputStream2 = null;
        try {
            outputStream = connection.getOutputStream();
            try {
                inputStream = hTTPPart.toInputStream();
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[65536];
                for (int i = inputStream.read(bArr); i > 0; i = inputStream.read(bArr)) {
                    outputStream.write(bArr, 0, i);
                }
                outputStream.flush();
                FileUtils.closeIO(inputStream, outputStream);
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    if (rawNetworkCallback != null) {
                        InputStream inputStream3 = connection.getInputStream();
                        try {
                            rawNetworkCallback.onResponse(inputStream3);
                            FileUtils.closeIO(inputStream3);
                            connection.disconnect();
                        } finally {
                        }
                    } else {
                        connection.disconnect();
                    }
                    MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                    return;
                }
                StringBuilder sb = new StringBuilder();
                try {
                    inputStreamReader = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                            if (sb.length() > 0) {
                                sb.append('\n');
                            }
                            sb.append(line);
                        }
                        FileUtils.closeIO(bufferedReader, inputStreamReader);
                        connection.disconnect();
                        HashMap map = new HashMap();
                        map.put(o.a("005iGdhdhecdh"), sb.toString());
                        map.put(o.a("006;fg_d^df6d3dcfg"), Integer.valueOf(responseCode));
                        throw new Throwable(new Hashon().fromHashMap(map));
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream2 = bufferedReader;
                        FileUtils.closeIO(inputStream2, inputStreamReader);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream2 = inputStream;
                FileUtils.closeIO(inputStream2, outputStream);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            outputStream = null;
        }
    }

    public void rawGet(String str, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawGet(str, new HashMap<>(), httpResponseCallback, networkTimeOut);
    }

    public void rawGet(String str, HashMap<String, String> map, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().d("rawGet: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        setHeader(connection, map);
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        if (connection.getResponseCode() == 301) {
            rawGet(connection.getHeaderField(o.a("008HekecdgdfEdBdeecdk")), new HashMap<>(), httpResponseCallback, networkTimeOut);
        } else if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            } finally {
            }
        }
        MobLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
    }

    @Deprecated
    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, byte[] bArr, ArrayList<KVPair<String>> arrayList2, int i, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        HTTPPart textPostHTTPPart;
        OutputStream outputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().i("httpPost: " + str);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setRequestProperty(o.a("010Aggecdkdk.i=dg;d@deecdk"), "Keep-Alive");
        if (bArr != null && bArr.length > 0) {
            textPostHTTPPart = getDataPostHttpPart(connection, str, bArr);
            if (i >= 0) {
                connection.setChunkedStreamingMode(i);
            }
        } else {
            textPostHTTPPart = getTextPostHTTPPart(connection, str, arrayList);
            connection.setFixedLengthStreamingMode((int) textPostHTTPPart.b());
        }
        if (arrayList2 != null) {
            Iterator<KVPair<String>> it = arrayList2.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        InputStream inputStream = null;
        try {
            outputStream = connection.getOutputStream();
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            inputStream = textPostHTTPPart.toInputStream();
            byte[] bArr2 = new byte[65536];
            for (int i2 = inputStream.read(bArr2); i2 > 0; i2 = inputStream.read(bArr2)) {
                outputStream.write(bArr2, 0, i2);
            }
            outputStream.flush();
            FileUtils.closeIO(inputStream, outputStream);
            if (httpResponseCallback != null) {
                try {
                    httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                    connection.disconnect();
                } finally {
                }
            }
            MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable th2) {
            th = th2;
            FileUtils.closeIO(inputStream, outputStream);
            throw th;
        }
    }

    @Deprecated
    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, int i, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap map = new HashMap();
        httpPost(str, arrayList, i, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.5
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStreamReader inputStreamReader;
                InputStreamReader inputStreamReader2;
                BufferedReader bufferedReader;
                int responseCode = httpConnection.getResponseCode();
                BufferedReader bufferedReader2 = null;
                if (responseCode == 200 || responseCode < 300) {
                    StringBuilder sb = new StringBuilder();
                    try {
                        inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader);
                            try {
                                for (String line = bufferedReader3.readLine(); line != null; line = bufferedReader3.readLine()) {
                                    if (sb.length() > 0) {
                                        sb.append('\n');
                                    }
                                    sb.append(line);
                                }
                                FileUtils.closeIO(bufferedReader3, inputStreamReader);
                                map.put("resp", sb.toString());
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader3;
                                FileUtils.closeIO(bufferedReader2, inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = null;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        inputStreamReader2 = new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8"));
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader2);
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        try {
                            for (String line2 = bufferedReader.readLine(); line2 != null; line2 = bufferedReader.readLine()) {
                                if (sb2.length() > 0) {
                                    sb2.append('\n');
                                }
                                sb2.append(line2);
                            }
                            FileUtils.closeIO(bufferedReader, inputStreamReader2);
                            HashMap map2 = new HashMap();
                            map2.put(o.a("005iGdhdhecdh"), sb2.toString());
                            map2.put(o.a("006EfgHdJdfQd?dcfg"), Integer.valueOf(responseCode));
                            throw new Throwable(new Hashon().fromHashMap(map2));
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader2 = bufferedReader;
                            FileUtils.closeIO(bufferedReader2, inputStreamReader2);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStreamReader2 = null;
                    }
                }
            }
        }, networkTimeOut);
        return (String) map.get("resp");
    }

    @Deprecated
    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, int i, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        OutputStream outputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().i("httpPost: " + str);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setRequestProperty(o.a("0107ggecdkdkWi[dg0d5deecdk"), "Keep-Alive");
        if (arrayList != null) {
            Iterator<KVPair<String>> it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        StringPart stringPart = new StringPart();
        InputStream inputStream = null;
        stringPart.append(null);
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        try {
            outputStream = connection.getOutputStream();
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            inputStream = stringPart.toInputStream();
            byte[] bArr = new byte[65536];
            for (int i2 = inputStream.read(bArr); i2 > 0; i2 = inputStream.read(bArr)) {
                outputStream.write(bArr, 0, i2);
            }
            outputStream.flush();
            FileUtils.closeIO(inputStream, outputStream);
            if (httpResponseCallback != null) {
                try {
                    httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                    connection.disconnect();
                } finally {
                }
            }
            MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable th2) {
            th = th2;
            FileUtils.closeIO(inputStream, outputStream);
            throw th;
        }
    }
}
