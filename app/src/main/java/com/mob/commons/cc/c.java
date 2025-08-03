package com.mob.commons.cc;

import com.mob.tools.network.NetCommunicator;
import com.mob.tools.network.NetworkHelper;
import java.io.OutputStream;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class c implements r<c> {
    private static final NetworkHelper a = new NetworkHelper();

    public static String a(String str, HashMap<String, Object> map, HashMap<String, String> map2) throws Throwable {
        return a.httpGet(str, map, map2);
    }

    public static String a(String str, HashMap<String, Object> map, HashMap<String, String> map2, NetworkHelper.NetworkTimeOut networkTimeOut) throws Throwable {
        return a.httpPostNew(str, map, map2, networkTimeOut);
    }

    public static String a(String str, byte[] bArr, HashMap<String, String> map, NetworkHelper.NetworkTimeOut networkTimeOut) throws Throwable {
        return a.httpPostWithBytes(str, bArr, map, networkTimeOut);
    }

    public static void a(String str, OutputStream outputStream, NetworkHelper.NetworkTimeOut networkTimeOut) throws Throwable {
        a.download(str, outputStream, networkTimeOut);
    }

    public static <T> T a(NetCommunicator netCommunicator, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z) throws Throwable {
        return (T) netCommunicator.requestSynchronized(false, map, map2, str, z);
    }

    @Override // com.mob.commons.cc.r
    public boolean a(c cVar, Class<c> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if ("hGet".equals(str)) {
            try {
                objArr2[0] = a((String) objArr[0], (HashMap<String, Object>) objArr[1], (HashMap<String, String>) objArr[2]);
            } catch (Throwable th) {
                thArr[0] = th;
                objArr2[0] = null;
            }
            return true;
        }
        if ("pst".equals(str)) {
            try {
                objArr2[0] = a((String) objArr[0], (HashMap<String, Object>) objArr[1], (HashMap<String, String>) objArr[2], (NetworkHelper.NetworkTimeOut) objArr[3]);
            } catch (Throwable th2) {
                thArr[0] = th2;
                objArr2[0] = null;
            }
            return true;
        }
        if ("postWithBytes".equals(str)) {
            try {
                objArr2[0] = a((String) objArr[0], (byte[]) objArr[1], (HashMap<String, String>) objArr[2], (NetworkHelper.NetworkTimeOut) objArr[3]);
            } catch (Throwable th3) {
                thArr[0] = th3;
                objArr2[0] = null;
            }
            return true;
        }
        if ("download".equals(str)) {
            try {
                a((String) objArr[0], (OutputStream) objArr[1], (NetworkHelper.NetworkTimeOut) objArr[2]);
            } catch (Throwable th4) {
                thArr[0] = th4;
                objArr2[0] = null;
            }
            return true;
        }
        if (!com.mob.commons.o.a("0079dhYik'ehdidkdg").equals(str)) {
            return false;
        }
        try {
            objArr2[0] = a((NetCommunicator) objArr[0], (HashMap) objArr[1], (HashMap) objArr[2], (String) objArr[3], ((Boolean) objArr[4]).booleanValue());
        } catch (Throwable th5) {
            thArr[0] = th5;
            objArr2[0] = null;
        }
        return true;
    }
}
