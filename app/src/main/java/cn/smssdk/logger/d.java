package cn.smssdk.logger;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.smssdk.net.f;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.e;
import com.mob.MobSDK;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: SMSLogger.java */
/* loaded from: classes.dex */
public class d {
    private static ILoggerEngine b;
    private static HashMap<Integer, Long> c;
    private static d d;
    private Hashon a = new Hashon();

    private d() {
        c = new HashMap<>();
        b = b.a();
    }

    private int c(int i) {
        int i2 = 2;
        if (i != 2) {
            i2 = 3;
            if (i != 3) {
                if (i != 6) {
                    return i != 8 ? -1 : 4;
                }
                return 1;
            }
        }
        return i2;
    }

    private HashMap<String, Object> c() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("appkey", MobSDK.getAppkey());
        map.put("plat", 1);
        map.put("model", a.m().b());
        if (!a.m().g().contains("deviceId")) {
            map.put("deviceId", a.m().a());
        }
        if (!a.m().g().contains("net")) {
            map.put("net", a.m().f());
        }
        if (!a.m().g().contains("operator")) {
            map.put("operator", a.m().l());
        }
        if (!a.m().g().contains("pkg")) {
            map.put("pkg", a.m().i());
        }
        if (!a.m().g().contains("md5")) {
            map.put("md5", a.m().e());
        }
        if (!a.m().g().contains("sdkver")) {
            map.put("sdkver", a.m().k());
        }
        if (!a.m().g().contains("duid")) {
            map.put("duid", a.m().d());
        }
        if (!a.m().g().contains(NotificationCompat.CATEGORY_SYSTEM)) {
            map.put(NotificationCompat.CATEGORY_SYSTEM, Integer.valueOf(a.m().h()));
        }
        if (!a.m().g().contains("romVersion")) {
            map.put("romVersion", a.m().j());
        }
        if (!a.m().g().contains("sdkMode")) {
            map.put("sdkMode", "NORMAL");
        }
        if (!a.m().g().contains("deviceName")) {
            map.put("deviceName", a.m().c());
        }
        return map;
    }

    public static d d() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    private String d(int i) {
        return i != 1 ? (i == 2 || i == 3 || i == 4) ? "code" : "token" : "init";
    }

    private List<c> e() {
        return b.getLogList();
    }

    public long a(int i) {
        if (c.containsKey(Integer.valueOf(i))) {
            return c.get(Integer.valueOf(i)).longValue();
        }
        return 0L;
    }

    public void b(int i) {
        c.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
    }

    public void b() {
        List<c> listE = e();
        if (listE == null || listE.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (c cVar : listE) {
            arrayList.add(a(cVar.c(), cVar.a(), cVar.b(), cVar.d()));
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", arrayList);
        if (f.d().a(map)) {
            a();
            SMSLog.getInstance().d(SMSLog.FORMAT, "SMSLogger", "uploadAllLogs", "Upload SDK LOG Success,delete the LogItem in db");
        }
    }

    public void a(int i, long j, String str) {
        b.insertOneRequestLog(i, j, str);
    }

    public void a() {
        b.deleteAllLogItems();
    }

    public void a(int i, Object obj) {
        long jA = a(i);
        int iC = c(i);
        if (iC != -1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            HashMap<String, Object> mapA = a(obj, jCurrentTimeMillis, jCurrentTimeMillis - jA, iC);
            HashMap<String, Object> map = new HashMap<>();
            ArrayList arrayList = new ArrayList();
            arrayList.add(mapA);
            map.put("list", arrayList);
            if (f.d().a(map)) {
                return;
            }
            a(iC, jCurrentTimeMillis, this.a.fromHashMap(mapA));
            SMSLog.getInstance().d(SMSLog.FORMAT, "SMSLogger", "uploadOrSave", "Upload SDK LOG Faied,So insert into db");
        }
    }

    private HashMap<String, Object> a(Object obj, long j, long j2, int i) {
        HashMap<String, Object> mapC = c();
        mapC.put("type", d(i));
        mapC.put("time", Long.valueOf(j));
        mapC.put("costTime", Long.valueOf(j2));
        mapC.put("method", Integer.valueOf(i));
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            String message = th.getMessage();
            if (!TextUtils.isEmpty(message)) {
                try {
                    JSONObject jSONObject = new JSONObject(message);
                    int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                    if (iOptInt != 615 && i != 1) {
                        mapC.put("innerCode", Integer.valueOf(iOptInt));
                        if (message.contains("detail")) {
                            mapC.put("innerDesc", jSONObject.optString("detail"));
                        } else {
                            mapC.put("innerDesc", "No Message");
                        }
                    } else {
                        mapC.put("innerDesc", e.a(th));
                        mapC.put("innerCode", 615);
                    }
                } catch (Throwable unused) {
                    SMSLog.getInstance().d(SMSLog.FORMAT, "SMSLogger", "prepareListParams", "data: " + obj);
                }
            }
            mapC.put("isError", Boolean.TRUE);
        } else if (obj instanceof String) {
            String str = (String) obj;
            if (str.contains("sdkMode")) {
                return (HashMap) this.a.fromJson(str, HashMap.class);
            }
            mapC.put("innerCode", 200);
            if (str.equals("")) {
                mapC.put("innerDesc", "No message");
            } else {
                mapC.put("innerDesc", str);
            }
        } else {
            mapC.put("isError", Boolean.FALSE);
            String strValueOf = String.valueOf(obj);
            mapC.put("innerCode", 200);
            if (strValueOf.equals("null")) {
                mapC.put("innerDesc", "No message");
            } else {
                mapC.put("innerDesc", strValueOf);
            }
        }
        return mapC;
    }
}
