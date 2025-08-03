package com.mob.pushsdk.biz;

import android.text.TextUtils;
import com.mob.guard.MobGuard;
import com.mob.pushsdk.base.PLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class e extends a {
    public static void a(String str, String str2, b bVar) {
        HashMap<String, Object> mapA = a.a();
        mapA.put("rid", str);
        mapA.put("mobile", str2);
        a.a("smsBind", "/smsPush/bind", mapA, bVar);
    }

    public static void b(final b bVar) {
        String strA = d.a();
        if (TextUtils.isEmpty(strA)) {
            new Thread() { // from class: com.mob.pushsdk.biz.e.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(a.i());
                    }
                }
            }.start();
        } else if (bVar != null) {
            bVar.a(strA);
        }
    }

    public static void c(b bVar) {
        a.a("aliasGet", "/alias/get", a.a(), bVar);
    }

    public static void d(b bVar) {
        a.a("tagsGet", "/tags/get", a.a(), bVar);
    }

    public static void c(String[] strArr, b bVar) {
        HashMap<String, Object> mapA = a.a();
        mapA.put("tags", strArr);
        a.a("tagsReplace", "/tags/replace", mapA, bVar);
    }

    public static void d(String[] strArr, b bVar) {
        HashMap<String, Object> mapA = a.a();
        mapA.put("tcpFlag", "1");
        mapA.put("offlineMessageIds", strArr);
        a.a("offlineClick", "/push/offline/click", mapA, bVar);
    }

    public static void a(b bVar) {
        a.a("phoneGet", "/smsPush/get", a.a(), bVar);
    }

    public static Object c(String[] strArr) throws Throwable {
        HashMap<String, Object> mapA = a.a();
        mapA.put("tcpFlag", "1");
        mapA.put("offlineMessageIds", strArr);
        return a.b("offlineAck", "/push/offline/ack", mapA);
    }

    public static Object b(String[] strArr) throws Throwable {
        HashMap<String, Object> mapA = a.a();
        mapA.put("messageIds", strArr);
        mapA.put("tcpFlag", "1");
        return a.b("pushAck", "/push/ack", mapA);
    }

    public static void a(String[] strArr, String str, b bVar) {
        HashMap<String, Object> mapA = a.a();
        mapA.put("workIds", strArr);
        mapA.put("channel", str);
        mapA.put("type", 4);
        a.a("pushReport", "/v3/push/report", mapA, bVar);
    }

    public static void c(String[] strArr, String str, b bVar) {
        a(strArr, str, 3, bVar);
    }

    public static void b(String[] strArr, b bVar) {
        HashMap<String, Object> mapA = a.a();
        mapA.put("messageIds", strArr);
        mapA.put("tcpFlag", "1");
        a.a("pushClick", "/push/click", mapA, bVar);
    }

    public static Object a(String[] strArr) throws Throwable {
        HashMap<String, Object> mapA = a.a();
        mapA.put("messageIds", strArr);
        mapA.put("guardId", MobGuard.getGuardId());
        return a.b("guardAck", "/push/guard/ack", mapA);
    }

    public static void b(String[] strArr, String str, b bVar) {
        HashMap<String, Object> mapA = a.a();
        mapA.put("batchIds", strArr);
        mapA.put("registrationId", str);
        a.a("pushClick", "/push/click", mapA, bVar);
    }

    public static void a(String[] strArr, b bVar) {
        HashMap<String, Object> mapA = a.a();
        mapA.put("messageIds", strArr);
        mapA.put("guardId", MobGuard.getGuardId());
        a.a("guardClick", "/push/guard/click", mapA, bVar);
    }

    public static void a(String str, b bVar) {
        HashMap<String, Object> mapA = a.a();
        mapA.put("alias", str);
        a.a("aliasUpdate", "/alias/update", mapA, bVar);
    }

    public static void a(String[] strArr, int i, b bVar) {
        HashMap<String, Object> mapA = a.a();
        mapA.put("tags", strArr);
        mapA.put("opType", Integer.valueOf(i));
        a.a("tagsUpdate", "/tags/update", mapA, bVar);
    }

    public static String a(String str, String str2, int i, boolean z, boolean z2, boolean z3, String str3, String[] strArr, boolean z4, long j, HashMap<String, String> map) {
        HashMap<String, Object> mapA = a.a();
        mapA.put("plats", new int[]{1});
        mapA.put("registrationIds", new String[]{a.i()});
        mapA.put("content", str2);
        mapA.put("type", 1);
        mapA.put("workType", Integer.valueOf(z4 ? 1 : 0));
        mapA.put("taskTime", Long.valueOf(j));
        if (map != null && !map.isEmpty()) {
            mapA.put("extras", a.a.fromHashMap(map));
        }
        if (!TextUtils.isEmpty(str)) {
            mapA.put("androidTitle", str);
        }
        mapA.put("androidStyle", Integer.valueOf(i));
        mapA.put("androidContent", strArr);
        mapA.put("androidVoice", Boolean.valueOf(z));
        mapA.put("androidShake", Boolean.valueOf(z2));
        mapA.put("androidLight", Boolean.valueOf(z3));
        if (z && !TextUtils.isEmpty(str3)) {
            mapA.put("androidSound", str3);
        }
        try {
            HashMap map2 = (HashMap) a.b("localUpdate", "/local/update", mapA);
            if (map2 != null && map2.containsKey("msgId")) {
                return (String) map2.get("msgId");
            }
            return null;
        } catch (Throwable th) {
            PLog.getInstance().e(th.getMessage(), new Object[0]);
            return null;
        }
    }

    public static void a(int i, int i2, String str, long j) {
        try {
            HashMap<String, Object> mapA = a.a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("curType", i);
            jSONObject.put("lastType", i2);
            jSONObject.put("description", str);
            jSONObject.put("time", j);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            mapA.put("netStates", jSONArray);
            a.a("trackUpload", "/track/upload", mapA, new b());
        } catch (Throwable th) {
            PLog.getInstance().e(th.getMessage(), new Object[0]);
        }
    }

    private static void a(String[] strArr, String str, int i, b bVar) {
        HashMap<String, Object> mapA = a.a();
        mapA.put("workIds", strArr);
        mapA.put("channel", str);
        mapA.put("type", Integer.valueOf(i));
        a.a("pushReport", "/v3/push/report", mapA, bVar);
    }
}
