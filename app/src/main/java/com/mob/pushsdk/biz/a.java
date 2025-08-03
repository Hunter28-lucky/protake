package com.mob.pushsdk.biz;

import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ImagesContract;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.MOBPUSH;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.guard.MobGuard;
import com.mob.pushsdk.MobPush;
import com.mob.pushsdk.b.h;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.plugins.a.f;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.umeng.analytics.pro.am;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

/* loaded from: classes2.dex */
public class a {
    public static String b;
    public static InterfaceC1894a c;
    public static HashMap<String, Object> d;

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f17693e;
    private static long i;
    private static String j;
    private static HashMap<String, Object> k;
    private static MobCommunicator l;
    public static final Hashon a = new Hashon();
    private static final Object f = new Object();
    private static final Object g = new Object();
    private static final Object h = new Object();
    private static boolean m = false;

    /* renamed from: com.mob.pushsdk.biz.a$a, reason: collision with other inner class name */
    public interface InterfaceC1894a {
        HashMap<String, Object> a();
    }

    static {
        l();
        f17693e = k();
        c = new InterfaceC1894a() { // from class: com.mob.pushsdk.biz.a.1
            @Override // com.mob.pushsdk.biz.a.InterfaceC1894a
            public HashMap<String, Object> a() {
                try {
                    HashMap<String, Object> mapA = a.a();
                    mapA.put("aeskey", new String(a.e(), "utf-8"));
                    DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
                    mapA.put("apppkg", deviceHelper.getPackageName());
                    String strA = d.a();
                    if (!TextUtils.isEmpty(strA)) {
                        mapA.put("regId", strA);
                    }
                    Location location = deviceHelper.getLocation(0, 0, true);
                    if (location != null) {
                        mapA.put("accuracy", Float.valueOf(location.getAccuracy()));
                        mapA.put("latitude", Double.valueOf(location.getLatitude()));
                        mapA.put("longitude", Double.valueOf(location.getLongitude()));
                    }
                    com.mob.pushsdk.plugins.a aVarB = com.mob.pushsdk.plugins.b.b();
                    String strF = d.f();
                    if (!TextUtils.isEmpty(strF)) {
                        com.mob.pushsdk.b.d.a().a("request channelUser success:" + strF);
                        mapA.put("channel", strF.toLowerCase(Locale.ROOT));
                    } else if (aVarB != null) {
                        mapA.put("channel", aVarB.getName().toLowerCase(Locale.ROOT));
                    } else {
                        mapA.put("channel", MobPush.Channels.MOB);
                    }
                    if (h.a().e()) {
                        mapA.put("openPush", 1);
                    } else {
                        mapA.put("openPush", 0);
                    }
                    String strE = d.e();
                    if (!TextUtils.isEmpty(strF) || (aVarB != null && !TextUtils.isEmpty(strE))) {
                        com.mob.pushsdk.b.d.a().a("request deviceToken success:" + strE);
                        mapA.put("deviceToken", strE);
                        mapA.put("deviceTokenNew", Integer.valueOf(strE.equals(d.d()) ? 0 : 1));
                    }
                    if (f.a()) {
                        String guardId = MobGuard.getGuardId();
                        PLog.getInstance().d("bind guardId:" + guardId, new Object[0]);
                        if (!TextUtils.isEmpty(guardId)) {
                            mapA.put("guardId", guardId);
                        }
                    }
                    mapA.put("logicPush", Integer.valueOf(d.h() ? 0 : 1));
                    mapA.put("tcpFlag", "1");
                    Object objA = a.a("v3/bind", "/v3/bind", mapA);
                    if (objA == null) {
                        return null;
                    }
                    HashMap<String, Object> map = (HashMap) objA;
                    String str = (String) map.get("registrationId");
                    String str2 = (String) map.get("token");
                    PLog.getInstance().d("registrationId:" + str + ",token:" + str2, new Object[0]);
                    if (!TextUtils.isEmpty(str)) {
                        d.a(str);
                    }
                    if (strE != null) {
                        d.b(strE);
                    }
                    return map;
                } catch (Throwable th) {
                    PLog.getInstance().e("MobPush getToken Throwable: " + th, new Object[0]);
                    return null;
                }
            }
        };
    }

    public static Object b() throws Throwable {
        DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        h hVarA = h.a();
        HashMap<String, Object> mapA = a();
        mapA.put("imei", deviceHelper.getIMEI());
        mapA.put("serialNo", deviceHelper.getSerialno());
        mapA.put(am.P, deviceHelper.getCarrier());
        mapA.put("model", deviceHelper.getModel());
        mapA.put("factory", deviceHelper.getManufacturer());
        mapA.put("networkType", deviceHelper.getNetworkType());
        mapA.put("sysver", deviceHelper.getOSVersionName());
        com.mob.pushsdk.plugins.a aVarB = com.mob.pushsdk.plugins.b.b();
        if (aVarB != null) {
            mapA.put("channel", aVarB.getName().toLowerCase(Locale.ROOT));
        } else {
            mapA.put("channel", MobPush.Channels.MOB);
        }
        mapA.put("uiver", h.b());
        if (hVarA.e()) {
            mapA.put("openPush", 1);
        } else {
            mapA.put("openPush", 0);
        }
        Object objA = a("conf", "/conf", mapA);
        if (objA == null) {
            return new HashMap();
        }
        HashMap map = (HashMap) objA;
        ArrayList<HashMap> arrayList = (ArrayList) map.get("urls");
        if (arrayList != null && arrayList.size() > 0) {
            HashMap map2 = new HashMap();
            for (HashMap map3 : arrayList) {
                map2.put((String) map3.get("enName"), map3);
            }
            map.put("actions", map2);
        }
        map.remove("urls");
        PLog.getInstance().d("conf:" + map, new Object[0]);
        return map;
    }

    public static String c() {
        synchronized (f) {
            if (j == null) {
                j = DeviceAuthorizer.authorize(new MOBPUSH());
            }
        }
        return j;
    }

    public static synchronized MobCommunicator d() {
        if (l == null) {
            l = new MobCommunicator(1024, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f", "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1");
        }
        return l;
    }

    public static byte[] e() {
        return f17693e;
    }

    public static void f() {
        PLog.getInstance().d("MobPush BaseProtocols requestTokenAsync", new Object[0]);
        new Thread(new Runnable() { // from class: com.mob.pushsdk.biz.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.a(true);
            }
        }).start();
    }

    public static HashMap<String, Object> g() {
        PLog.getInstance().d("MobPush BaseProtocols requestTokenSync", new Object[0]);
        return a(false);
    }

    public static boolean h() {
        PLog.getInstance().d("MobPush requestNetToken", new Object[0]);
        String strE = d.e();
        if (com.mob.pushsdk.plugins.b.b() != null && TextUtils.isEmpty(strE)) {
            int i2 = ((int) 3000) / 500;
            while (TextUtils.isEmpty(strE) && i2 > 0) {
                i2--;
                try {
                    Thread.sleep(500L);
                } catch (Throwable th) {
                    PLog.getInstance().e(th);
                }
                strE = d.e();
                PLog.getInstance().d("MobPush requestNetToken wait deviceToken:" + strE + ",maxCount:" + i2, new Object[0]);
            }
        }
        HashMap<String, Object> mapA = c.a();
        k = mapA;
        return (mapA == null || mapA.isEmpty()) ? false : true;
    }

    public static String i() {
        HashMap<String, Object> map = k;
        String str = map != null ? (String) map.get("registrationId") : null;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        a(false);
        HashMap<String, Object> map2 = k;
        return map2 != null ? (String) map2.get("registrationId") : str;
    }

    public static HashMap<String, Object> j() {
        HashMap<String, Object> map;
        synchronized (h) {
            if (d == null) {
                try {
                    File file = new File(MobSDK.getContext().getCacheDir(), ".pconfig");
                    HashMap<String, Object> map2 = null;
                    if (file.exists() && ((map2 = (HashMap) ResHelper.readObjectFromFile(file.getPath())) == null || map2.isEmpty())) {
                        file.delete();
                    }
                    if (map2 == null || map2.isEmpty()) {
                        HashMap map3 = (HashMap) b();
                        if (map3 != null && !map3.isEmpty()) {
                            map3.put("localSaveTime", Long.valueOf(System.currentTimeMillis()));
                            ResHelper.saveObjectToFile(file.getPath(), map3);
                            d = map2;
                        }
                    } else {
                        if (System.currentTimeMillis() - ((Long) ResHelper.forceCast(map2.get("localSaveTime"), 0L)).longValue() > 3600000 && (map = (HashMap) b()) != null && !map.isEmpty()) {
                            map.put("localSaveTime", Long.valueOf(System.currentTimeMillis()));
                            ResHelper.saveObjectToFile(file.getPath(), map);
                            map2 = map;
                        }
                        d = map2;
                    }
                } catch (Throwable th) {
                    PLog.getInstance().d(th);
                }
            }
        }
        return d;
    }

    public static byte[] k() {
        String strByteToHex;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            try {
                dataOutputStream.writeLong(new Random().nextLong());
                strByteToHex = Data.byteToHex(byteArrayOutputStream.toByteArray());
            } catch (Throwable th) {
                try {
                    PLog.getInstance().d(th);
                    dataOutputStream.close();
                } finally {
                    try {
                        dataOutputStream.close();
                    } catch (Throwable th2) {
                        PLog.getInstance().d(th2);
                    }
                }
            }
        } catch (Throwable th3) {
            PLog.getInstance().d(th3);
        }
        if (strByteToHex.length() == 16) {
            return strByteToHex.getBytes();
        }
        dataOutputStream.close();
        return "ar1xcsbglilzpjs5".getBytes();
    }

    private static void l() {
        try {
            PLog.getInstance().d("checkServiceUrl domain:" + d.c(), new Object[0]);
            if (d.c() == 1) {
                b = MobSDK.checkRequestUrl("http://abroad.sdk.push.mob.com");
            } else {
                b = MobSDK.checkRequestUrl("http://sdk.push.mob.com");
            }
            PLog.getInstance().d("checkServiceUrl:" + b, new Object[0]);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static HashMap<String, Object> a() {
        DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        HashMap<String, Object> map = new HashMap<>();
        map.put("appkey", MobSDK.getAppkey());
        map.put("appver", Integer.valueOf(deviceHelper.getAppVersion()));
        map.put("platVersion", deviceHelper.getOSVersionName());
        map.put("apppkg", MobSDK.getContext().getPackageName());
        map.put("sdkver", Integer.valueOf(MobPush.SDK_VERSION_CODE));
        map.put("duid", c());
        map.put("product", 1);
        map.put("plat", 1);
        String strA = d.a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("registrationId", strA);
        }
        return map;
    }

    public static HashMap<String, Object> a(boolean z) {
        synchronized (g) {
            if (z) {
                if (SystemClock.elapsedRealtime() - i > 20000) {
                    k = null;
                }
                if (k == null && !h()) {
                    i = SystemClock.currentThreadTimeMillis();
                }
            } else if (k == null) {
                i = SystemClock.currentThreadTimeMillis();
            }
        }
        return k;
    }

    public static Object a(String str, String str2, HashMap<String, Object> map) throws Throwable {
        map.put("duid", c());
        return b(str, map, str2, false);
    }

    public static void a(final String str, final String str2, final HashMap<String, Object> map, final b bVar) {
        new Thread() { // from class: com.mob.pushsdk.biz.a.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                a.a(false);
                map.put("duid", a.c());
                Object objB = a.b(str, map, str2, false);
                b bVar2 = bVar;
                if (bVar2 == null) {
                    return;
                }
                if (objB instanceof Throwable) {
                    bVar2.a((Throwable) objB);
                } else {
                    bVar2.a(objB);
                }
            }
        }.start();
    }

    public static Object b(String str, String str2, HashMap<String, Object> map) throws Throwable {
        a(false);
        map.put("duid", c());
        Object objB = b(str, map, str2, false);
        if (objB instanceof Throwable) {
            throw ((Throwable) objB);
        }
        return objB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object b(String str, HashMap<String, Object> map, String str2, boolean z) {
        HashMap map2;
        String strCheckHttpRequestUrl;
        if (m) {
            return new Throwable("Invalid appkey");
        }
        if (MobSDK.isForb()) {
            return new Throwable("Mob Service forbidden");
        }
        String str3 = map.get("appkey") == null ? "" : (String) map.get("appkey");
        if (str3 != null && str3.length() > 4) {
            l();
            String str4 = b + str2;
            try {
                if (!"conf".equals(str)) {
                    j();
                }
                HashMap<String, Object> map3 = d;
                if (map3 != null && (map2 = (HashMap) ((HashMap) map3.get("actions")).get(str)) != null) {
                    String str5 = (String) map2.get(ImagesContract.URL);
                    String str6 = (String) map2.get("action");
                    if (((Integer) ResHelper.forceCast(map2.get(NotificationCompat.CATEGORY_STATUS), 1)).intValue() == 1) {
                        try {
                            strCheckHttpRequestUrl = MobSDK.checkRequestUrl(str5);
                        } catch (Throwable unused) {
                            strCheckHttpRequestUrl = NetworkHelper.checkHttpRequestUrl(str5);
                        }
                        str4 = strCheckHttpRequestUrl + str6;
                    }
                }
                Object objRequestSynchronized = d().requestSynchronized(map, str4, z);
                if (m) {
                    m = false;
                }
                return objRequestSynchronized;
            } catch (Throwable th) {
                PLog.getInstance().e("请求异常 >>>" + str4 + " ---error:" + th, new Object[0]);
                if (th instanceof MobCommunicator.NetworkError) {
                    HashMap mapFromJson = a.fromJson(th.getMessage());
                    int iIntValue = ((Integer) ResHelper.forceCast(mapFromJson.get("httpStatus"), -1)).intValue();
                    int iIntValue2 = ((Integer) ResHelper.forceCast(mapFromJson.get(NotificationCompat.CATEGORY_STATUS), -1)).intValue();
                    if (iIntValue != -1) {
                        if (iIntValue2 == 4006 || iIntValue2 == 4007) {
                            a(true);
                            return b(str, map, str2, false);
                        }
                        if (iIntValue2 != 4312 && iIntValue2 != 4310 && iIntValue2 != 4311) {
                            return th;
                        }
                        m = true;
                        return th;
                    }
                }
                return th;
            }
        }
        com.mob.pushsdk.b.d.a().d("MobPush Init Failed Invalid AppKey:" + str3);
        return new Throwable("MobPush Init Failed Invalid AppKey:" + str3);
    }
}
