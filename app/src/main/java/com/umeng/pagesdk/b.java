package com.umeng.pagesdk;

import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {
    private static Map<String, Map> a = new HashMap();
    private static a b;

    private static void a(String str) throws JSONException {
        Map map;
        if (TextUtils.isEmpty(str) || (map = a.get(str)) == null || (r0 = map.entrySet().iterator()) == null) {
            return;
        }
        JSONArray jSONArray = null;
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null) {
                String str2 = (String) entry.getKey();
                Long[] lArr = (Long[]) entry.getValue();
                if (!TextUtils.isEmpty(str2) && lArr != null && lArr.length >= 2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("mN", str2);
                        jSONObject.put("mBT", lArr[0]);
                        jSONObject.put("mET", lArr[1]);
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        if (jSONArray != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("pN", str);
                jSONObject2.put("pL", jSONArray);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            EfsJSONLog efsJSONLog = new EfsJSONLog("pageperf");
            efsJSONLog.put("page", jSONObject2);
            EfsReporter reporter = PageManger.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog);
            }
        }
    }

    public static void a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageBegin. parameter null!");
                return;
            }
            return;
        }
        if (!PageManger.isInit()) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageBegin. not init!");
                return;
            }
            return;
        }
        PageConfigManger pageConfigManger = PageManger.getPageConfigManger();
        if (pageConfigManger == null || !pageConfigManger.enableTracer()) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageBegin. not rate!");
                return;
            }
            return;
        }
        if (z) {
            str2 = "UM_".concat(String.valueOf(str2));
        }
        if (!a.containsKey(str)) {
            if (str2.equals("UM_onCreate")) {
                if (PageManger.isDebug) {
                    Log.i("PageManger-PageTrace", "tracePageBegin. begin add onCreate. " + str2 + " - " + str);
                }
                Long[] lArr = new Long[2];
                lArr[0] = Long.valueOf(System.currentTimeMillis());
                HashMap map = new HashMap();
                map.put(str2, lArr);
                a.put(str, map);
                a aVar = b;
                if (aVar != null) {
                    aVar.b();
                    a aVar2 = b;
                    aVar2.j = str;
                    aVar2.a();
                    return;
                }
                a aVar3 = new a(PageManger.getApplicationContext());
                b = aVar3;
                aVar3.j = str;
                aVar3.a();
                return;
            }
            return;
        }
        Map map2 = a.get(str);
        if (map2 == null) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageBegin. methodMap null!");
                return;
            }
            return;
        }
        if (map2.containsKey(str2)) {
            return;
        }
        if (PageManger.isDebug) {
            Log.i("PageManger-PageTrace", "tracePageBegin. begin add method. " + str2 + " - " + str);
        }
        if (z || map2.size() <= 6) {
            Long[] lArr2 = new Long[2];
            lArr2[0] = Long.valueOf(System.currentTimeMillis());
            map2.put(str2, lArr2);
        } else if (PageManger.isDebug) {
            Log.e("PageManger-PageTrace", "tracePageBegin. user trace number of transfinite. " + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str);
        }
    }

    public static void b(String str, String str2, boolean z) throws JSONException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageEnd. parameter null!");
                return;
            }
            return;
        }
        if (!PageManger.isInit()) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageEnd. not init!");
                return;
            }
            return;
        }
        PageConfigManger pageConfigManger = PageManger.getPageConfigManger();
        if (pageConfigManger == null || !pageConfigManger.enableTracer()) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageEnd. not rate!");
                return;
            }
            return;
        }
        if (z) {
            str2 = "UM_".concat(String.valueOf(str2));
        }
        if (!a.containsKey(str)) {
            if (str2.equals("UM_onPause")) {
                if (PageManger.isDebug) {
                    Log.i("PageManger-PageTrace", "tracePageEnd. onPause stop fps. ".concat(String.valueOf(str)));
                }
                a aVar = b;
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            return;
        }
        Map map = a.get(str);
        if (map == null) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageEnd. " + str + " is null in pageMap!");
                return;
            }
            return;
        }
        if (!map.containsKey(str2)) {
            if (PageManger.isDebug) {
                Log.e("PageManger-PageTrace", "tracePageEnd. " + str2 + " non-exist in " + str + " map!");
                return;
            }
            return;
        }
        Long[] lArr = (Long[]) map.get(str2);
        if (lArr.length >= 2) {
            lArr[1] = Long.valueOf(System.currentTimeMillis());
        }
        if (str2.equals("UM_onResume")) {
            if (PageManger.isDebug) {
                Log.i("PageManger-PageTrace", "tracePageEnd. onResume save data. ".concat(String.valueOf(str)));
            }
            a(str);
            if (TextUtils.isEmpty(str) || !a.containsKey(str)) {
                return;
            }
            a.remove(str);
            return;
        }
        if (str2.equals("UM_onPause")) {
            if (PageManger.isDebug) {
                Log.i("PageManger-PageTrace", "tracePageEnd. onPause stop fps. ".concat(String.valueOf(str)));
            }
            a aVar2 = b;
            if (aVar2 != null) {
                aVar2.b();
                b = null;
            }
        }
    }
}
