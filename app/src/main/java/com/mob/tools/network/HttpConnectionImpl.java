package com.mob.tools.network;

import com.mob.commons.n;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ReflectHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes2.dex */
public class HttpConnectionImpl implements HttpConnection {
    private Object a;

    static {
        try {
            ReflectHelper.importClass("org.apache.http.HttpResponse");
            ReflectHelper.importClass("org.apache.http.Header");
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public HttpConnectionImpl(Object obj) {
        this.a = obj;
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getErrorStream() throws IOException {
        return getInputStream();
    }

    @Override // com.mob.tools.network.HttpConnection
    public Map<String, List<String>> getHeaderFields() throws IOException {
        try {
            HashMap map = new HashMap();
            Object objInvokeInstanceMethod = ReflectHelper.invokeInstanceMethod(this.a, "getAllHeaders", new Object[0]);
            if (objInvokeInstanceMethod != null) {
                int iIntValue = ((Integer) ReflectHelper.getInstanceField(objInvokeInstanceMethod, n.b("006Idc9h)cjee+cb"))).intValue();
                Object[] objArr = new Object[iIntValue];
                System.arraycopy(objInvokeInstanceMethod, 0, objArr, 0, iIntValue);
                for (int i = 0; i < iIntValue; i++) {
                    Object obj = objArr[i];
                    String str = (String) ReflectHelper.invokeInstanceMethod(obj, n.b("007^eeVhcCdece.kh"), new Object[0]);
                    String str2 = (String) ReflectHelper.invokeInstanceMethod(obj, "getValue", new Object[0]);
                    if (str2 == null) {
                        str2 = "";
                    }
                    map.put(str, Arrays.asList(str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
                }
            }
            return map;
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getInputStream() throws IOException {
        try {
            return (InputStream) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(this.a, "getEntity", new Object[0]), "getContent", new Object[0]);
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    @Override // com.mob.tools.network.HttpConnection
    public int getResponseCode() throws IOException {
        try {
            return ((Integer) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(this.a, "getStatusLine", new Object[0]), "getStatusCode", new Object[0])).intValue();
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
