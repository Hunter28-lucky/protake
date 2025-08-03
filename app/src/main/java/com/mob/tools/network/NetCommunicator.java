package com.mob.tools.network;

import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.C5340r;
import com.mob.commons.MobProduct;
import com.mob.commons.e;
import com.mob.commons.n;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.a.c;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.MobRSA;
import com.mob.tools.utils.UIHandler;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public final class NetCommunicator implements PublicMemberKeeper {
    public static final String KEY_DUID_PREVIOUS = "duidPrevious";
    public static final String KEY_IS_MODIFIED = "isModified";
    private BigInteger c;
    private BigInteger d;

    /* renamed from: e, reason: collision with root package name */
    private MobRSA f17719e;
    private NetworkHelper.NetworkTimeOut g;
    private ThreadPoolExecutor h;
    public static final String KEY_DUID = n.b("004g2cbcd8g");
    private static final ThreadPoolExecutor a = new ThreadPoolExecutor(3, 20, 60, TimeUnit.SECONDS, new LinkedBlockingDeque());
    private SecureRandom b = new SecureRandom();
    private NetworkHelper f = new NetworkHelper();

    public static class Callback<T> implements PublicMemberKeeper {
        public void onResultError(Throwable th) {
        }

        public void onResultOk(T t) {
        }
    }

    public static class NetworkError extends Exception implements PublicMemberKeeper {
        private static final long serialVersionUID = -8447657431687664787L;

        public NetworkError(String str) {
            super(str);
        }
    }

    public NetCommunicator(int i, String str, String str2) {
        this.f17719e = new MobRSA(i);
        this.c = new BigInteger(str, 16);
        this.d = new BigInteger(str2, 16);
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        this.g = networkTimeOut;
        networkTimeOut.readTimout = 30000;
        networkTimeOut.connectionTimeout = 5000;
        this.h = a;
    }

    public static String checkHttpRequestUrl(String str) {
        return C5340r.b(str);
    }

    public static String dynamicModifyUrl(String str) {
        return C5340r.a(str);
    }

    public static HashMap<String, String> getCommonDefaultHeaders() throws Throwable {
        HashMap<String, String> map = new HashMap<>();
        map.put(n.b("003=ci+h>ch"), MobSDK.getAppkey());
        map.put(n.b("013Fddef-hAcgghdf=ghTcj*cRcd_cWch"), v.c());
        map.put(n.b("004k_dbcd_g"), c.a(MobSDK.getContext()).b().aY());
        return map;
    }

    public static synchronized String getDUID(MobProduct mobProduct) {
        return e.a(mobProduct);
    }

    public static synchronized HashMap<String, Object> getDUIDWithModifyInfo(MobProduct mobProduct) {
        return e.b(mobProduct);
    }

    public static String getSDKDomain(String str, String str2) {
        return com.mob.commons.c.a(str, str2);
    }

    public static boolean initSDKDM(HashMap<String, List<String>> map) {
        return com.mob.commons.c.a(map);
    }

    public void addTcpIntercept(String str) {
    }

    public void removeTcpIntercept(String str) {
    }

    public <T> void request(HashMap<String, Object> map, String str, boolean z, Callback<T> callback) {
        request(true, null, map, str, z, callback);
    }

    public <T> T requestSynchronized(HashMap<String, Object> map, String str, boolean z) throws Throwable {
        return (T) requestSynchronized((HashMap<String, String>) null, map, str, z);
    }

    public String requestSynchronizedGet(String str, HashMap<String, Object> map, HashMap<String, String> map2) throws Throwable {
        return this.f.httpGetNew(str, map, map2, this.g);
    }

    public void setThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        this.h = threadPoolExecutor;
    }

    public <T> void request(HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z, Callback<T> callback) {
        request(true, map, map2, str, z, callback);
    }

    public <T> T requestSynchronized(HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z) throws Throwable {
        return (T) requestSynchronized(true, map, map2, str, z);
    }

    private byte[] a(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new GZIPOutputStream(byteArrayOutputStream));
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public <T> void request(final boolean z, final HashMap<String, String> map, final HashMap<String, Object> map2, final String str, final boolean z2, final Callback<T> callback) {
        this.h.execute(new com.mob.tools.utils.e() { // from class: com.mob.tools.network.NetCommunicator.1
            @Override // com.mob.tools.utils.e
            public void a() {
                try {
                    final Object objRequestSynchronized = NetCommunicator.this.requestSynchronized(z, map, map2, str, z2);
                    if (callback != null) {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.tools.network.NetCommunicator.1.1
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                callback.onResultOk(objRequestSynchronized);
                                return false;
                            }
                        });
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                    if (callback != null) {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.tools.network.NetCommunicator.1.2
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                callback.onResultError(th);
                                return false;
                            }
                        });
                    }
                }
            }
        });
    }

    public <T> T requestSynchronized(String str, String str2, boolean z) throws Throwable {
        return (T) requestSynchronized((HashMap<String, String>) null, str, str2, z);
    }

    public <T> T requestSynchronized(HashMap<String, String> map, String str, String str2, boolean z) throws Throwable {
        return (T) requestSynchronized(true, map, str, str2, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0004  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T requestSynchronized(boolean r9, java.util.HashMap<java.lang.String, java.lang.String> r10, java.util.HashMap<java.lang.String, java.lang.Object> r11, java.lang.String r12, boolean r13) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "{}"
            if (r11 != 0) goto L6
        L4:
            r5 = r0
            goto L12
        L6:
            java.lang.String r11 = com.mob.tools.utils.HashonHelper.fromHashMap(r11)
            int r1 = r11.length()
            if (r1 != 0) goto L11
            goto L4
        L11:
            r5 = r11
        L12:
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            r7 = r13
            java.lang.Object r9 = r2.requestSynchronized(r3, r4, r5, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetCommunicator.requestSynchronized(boolean, java.util.HashMap, java.util.HashMap, java.lang.String, boolean):java.lang.Object");
    }

    public <T> T requestSynchronized(boolean z, HashMap<String, String> map, String str, String str2, boolean z2) throws Throwable {
        byte[] bArrA = a();
        String strA = a(bArrA, str, z2);
        HashMap<String, String> mapA = a(z, map, str, strA.getBytes("utf-8").length);
        String[] strArr = new String[1];
        HttpResponseCallback httpResponseCallbackA = a(bArrA, strArr);
        StringPart stringPart = new StringPart();
        stringPart.append(strA);
        MobLog.getInstance().d(">>>  request(" + str2 + "): " + str + "\nheader = " + mapA.toString(), new Object[0]);
        this.f.rawPost(str2, mapA, stringPart, -1, httpResponseCallbackA, this.g);
        if (strArr[0] == null) {
            return null;
        }
        MobLog.getInstance().d(">>> response(" + str2 + "): " + strArr[0], new Object[0]);
        return (T) a(strArr[0]);
    }

    private byte[] a() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeLong(this.b.nextLong());
        dataOutputStream.writeLong(this.b.nextLong());
        dataOutputStream.flush();
        dataOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private String a(byte[] bArr, String str, boolean z) throws Throwable {
        byte[] bytes = str.getBytes("utf-8");
        if (z) {
            bytes = a(bytes);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        byte[] bArrEncode = this.f17719e.encode(bArr, this.c, this.d);
        dataOutputStream.writeInt(bArrEncode.length);
        dataOutputStream.write(bArrEncode);
        byte[] bArrAES128Encode = Data.AES128Encode(bArr, bytes);
        dataOutputStream.writeInt(bArrAES128Encode.length);
        dataOutputStream.write(bArrAES128Encode);
        dataOutputStream.flush();
        dataOutputStream.close();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    private HashMap<String, String> a(boolean z, HashMap<String, String> map, String str, int i) throws Throwable {
        HashMap<String, String> mapA = z ? a(str, i) : null;
        if (mapA == null) {
            mapA = new HashMap<>();
        }
        if (map != null) {
            mapA.putAll(map);
        }
        return mapA;
    }

    private HashMap<String, String> a(String str, int i) throws Throwable {
        HashMap<String, String> commonDefaultHeaders = getCommonDefaultHeaders();
        commonDefaultHeaders.put(n.b("004Defcdeecj"), Data.MD5(str + MobSDK.getAppSecret()));
        commonDefaultHeaders.put(n.b("003^ciLhRch"), MobSDK.getAppkey());
        commonDefaultHeaders.put(n.b("014+ffdbcjYchMcjVc^ghdjShScjeeMcb"), String.valueOf(i));
        return commonDefaultHeaders;
    }

    private HttpResponseCallback a(final byte[] bArr, final String[] strArr) {
        return new HttpResponseCallback() { // from class: com.mob.tools.network.NetCommunicator.2
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                int responseCode = httpConnection.getResponseCode();
                InputStream inputStream = responseCode == 200 ? httpConnection.getInputStream() : httpConnection.getErrorStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[1024];
                for (int i = inputStream.read(bArr2); i != -1; i = inputStream.read(bArr2)) {
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
                inputStream.close();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (responseCode != 200) {
                    HashMap mapFromJson = HashonHelper.fromJson(new String(byteArray, "utf-8"));
                    mapFromJson.put(n.b("010bccd.dgYcOce:cEcbef"), Integer.valueOf(responseCode));
                    throw new NetworkError(HashonHelper.fromHashMap(mapFromJson));
                }
                long jA = NetCommunicator.this.a(httpConnection);
                if (jA != -1 && jA == byteArray.length) {
                    strArr[0] = NetCommunicator.this.a(bArr, byteArray);
                    return;
                }
                HashMap map = new HashMap();
                map.put(n.b("010bccd-dg)c.ceTc;cbef"), Integer.valueOf(responseCode));
                map.put(n.b("006.efOc ceNcHcbef"), -2);
                map.put(n.b("005hYcgcgdbcg"), "Illegal content length");
                throw new NetworkError(HashonHelper.fromHashMap(map));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(HttpConnection httpConnection) throws Throwable {
        List<String> listA = a(httpConnection, n.b("014!ffdbcj.ch2cjPcGghdjHh*cjee$cb"));
        if (listA == null || listA.size() <= 0) {
            return -1L;
        }
        return Long.parseLong(listA.get(0));
    }

    private List<String> a(HttpConnection httpConnection, String str) throws Throwable {
        Map<String, List<String>> headerFields = httpConnection.getHeaderFields();
        if (headerFields == null || headerFields.isEmpty()) {
            return null;
        }
        for (String str2 : headerFields.keySet()) {
            if (str2 != null && str2.equals(str)) {
                return headerFields.get(str2);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(byte[] bArr, byte[] bArr2) throws Throwable {
        return new String(Data.AES128Decode(bArr, Base64.decode(bArr2, 2)), "utf-8");
    }

    private Object a(String str) throws Throwable {
        if (str != null) {
            HashMap mapFromJson = HashonHelper.fromJson(str.trim());
            if (!mapFromJson.isEmpty()) {
                Object obj = mapFromJson.get(n.b("003_cg1h'ef"));
                return obj == null ? mapFromJson.get(n.b("004g:ceRcOce")) : obj;
            }
            HashMap map = new HashMap();
            map.put(n.b("006Ref!cZceKc]cbef"), -1);
            map.put(n.b("005h?cgcgdbcg"), "RS is empty");
            throw new NetworkError(HashonHelper.fromHashMap(map));
        }
        HashMap map2 = new HashMap();
        map2.put(n.b("006UefKcMceCc)cbef"), -1);
        map2.put(n.b("005hGcgcgdbcg"), "RS is empty");
        throw new NetworkError(HashonHelper.fromHashMap(map2));
    }
}
