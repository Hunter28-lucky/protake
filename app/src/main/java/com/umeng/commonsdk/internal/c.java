package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.ao;
import com.umeng.analytics.pro.ap;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.umzid.ZIDManager;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: UMInternalDataProtocol.java */
/* loaded from: classes2.dex */
public class c implements UMLogDataProtocol {
    public static final String a = "um_policy_grant";
    public static final String b = "preInitInvokedFlag";
    public static final String c = "policyGrantInvokedFlag";
    public static final String d = "policyGrantResult";
    private static int f = 1;
    private static final String g = "info";
    private static final String h = "stat";
    private static Class<?> i = null;
    private static Method j = null;
    private static Method k = null;
    private static Method l = null;
    private static boolean m = false;

    /* renamed from: e, reason: collision with root package name */
    private Context f17801e;

    static {
        c();
    }

    public c(Context context) {
        if (context != null) {
            this.f17801e = context.getApplicationContext();
        }
    }

    public static String b() {
        Method method;
        Class<?> cls = i;
        if (cls == null || (method = j) == null || l == null) {
            return "";
        }
        try {
            Object objInvoke = method.invoke(cls, new Object[0]);
            return objInvoke != null ? (String) l.invoke(objInvoke, new Object[0]) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void c() {
        try {
            i = ZIDManager.class;
            Method declaredMethod = ZIDManager.class.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod != null) {
                j = declaredMethod;
            }
            Method declaredMethod2 = i.getDeclaredMethod("getZID", Context.class);
            if (declaredMethod2 != null) {
                k = declaredMethod2;
            }
            Method declaredMethod3 = i.getDeclaredMethod("getSDKVersion", new Class[0]);
            if (declaredMethod3 != null) {
                l = declaredMethod3;
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        ao aoVarA = ao.a(this.f17801e);
        ap apVarA = aoVarA.a(aq.c);
        if (apVarA != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = apVarA.a;
                String str2 = apVarA.b;
                JSONObject jSONObjectA = new com.umeng.commonsdk.statistics.b().a(this.f17801e.getApplicationContext(), new JSONObject(apVarA.c), new JSONObject(apVarA.d), apVarA.f17757e, str2, apVarA.f);
                if (jSONObjectA == null || !jSONObjectA.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                }
                aoVarA.a(aq.c, str);
                aoVarA.b();
            } catch (Throwable unused) {
            }
        }
    }

    private void e() {
        if (m) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                return;
            }
            m = false;
        } else if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            m = true;
            a(this.f17801e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                    if (TextUtils.isEmpty(str)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = c.this.f17801e.getSharedPreferences(h.a, 0);
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                            editorEdit.putString(h.b, str);
                            editorEdit.commit();
                        }
                    } catch (Throwable unused) {
                    }
                    UMWorkDispatch.sendEvent(c.this.f17801e, a.w, b.a(c.this.f17801e).a(), null);
                }
            });
        }
    }

    private void f() {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.f17801e);
            f++;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (c.this.f17801e != null) {
                        UMWorkDispatch.sendEvent(c.this.f17801e, a.x, b.a(c.this.f17801e).a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            c(this.f17801e);
        }
    }

    private void g() {
        if (f <= 0) {
            h();
            f(this.f17801e);
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.f17801e)) {
            g(this.f17801e);
            com.umeng.commonsdk.a.a(this.f17801e);
            Context context = this.f17801e;
            UMWorkDispatch.sendEvent(context, o.a.y, CoreProtocol.getInstance(context), null);
            Context context2 = this.f17801e;
            UMWorkDispatch.sendEvent(context2, a.t, b.a(context2).a(), null);
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0255  */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void workEvent(java.lang.Object r13, int r14) throws org.json.JSONException, java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 1148
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.workEvent(java.lang.Object, int):void");
    }

    public String a() {
        Method method;
        Class<?> cls = i;
        if (cls == null || (method = j) == null || k == null) {
            return "";
        }
        try {
            Object objInvoke = method.invoke(cls, new Object[0]);
            return objInvoke != null ? (String) k.invoke(objInvoke, this.f17801e) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private void b(Context context) {
        try {
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, am.g, "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(am.g), strImprintProperty);
            JSONObject jSONObjectBuildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.SILENT_HEART_BEAT);
            if (jSONObjectBuildSilentEnvelopeWithExtHeader != null && jSONObjectBuildSilentEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private static void g(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + aq.l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(am.x), AnalyticsConstants.SDK_TYPE);
            JSONObject jSONObjectBuildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (jSONObjectBuildZeroEnvelopeWithExtHeader != null && jSONObjectBuildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Context context) {
        long jLongValue;
        long jLongValue2;
        if (context == null) {
            return;
        }
        String strA = com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE, "debugkey");
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        String strA2 = com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_START_TIME);
        String strA3 = com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE, "period");
        if (TextUtils.isEmpty(strA2)) {
            jLongValue = 0;
        } else {
            try {
                jLongValue = Long.valueOf(strA2).longValue();
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(strA3)) {
            jLongValue2 = 0;
        } else {
            try {
                jLongValue2 = Long.valueOf(strA3).longValue();
            } catch (Throwable unused2) {
            }
        }
        if (jLongValue == 0 || jLongValue2 == 0) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据");
            com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE);
            return;
        }
        if (System.currentTimeMillis() - jLongValue > jLongValue2 * 60 * 1000) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。");
            com.umeng.common.b.a(context, AnalyticsConfig.RTD_SP_FILE);
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                AnalyticsConfig.turnOffRealTimeDebug();
                return;
            }
            return;
        }
        HashMap map = new HashMap();
        map.put("debugkey", strA);
        if (AnalyticsConfig.isRealTimeDebugMode()) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。");
        AnalyticsConfig.turnOnRealTimeDebug(map);
    }

    private static void c(final Context context) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String strA = aa.a(context);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(strA) && sharedPreferences != null) {
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(h.c, (jCurrentTimeMillis2 - jCurrentTimeMillis) + "");
                        editorEdit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                        editorEdit2.putString(h.b, strA);
                        editorEdit2.commit();
                    }
                    UMConfigureImpl.removeInterruptFlag();
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    private void f(Context context) {
        Object objInvoke;
        Method declaredMethod;
        Context applicationContext = context.getApplicationContext();
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> clsA = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = clsA.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (objInvoke = declaredMethod2.invoke(clsA, new Object[0])) == null || (declaredMethod = clsA.getDeclaredMethod("init", Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(objInvoke, applicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String strA = aa.a(applicationContext);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(strA);
                }
            }
        }).start();
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static void d(final Context context) {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
                        if (sharedPreferences == null || sharedPreferences.getString(h.b, "").equalsIgnoreCase(str)) {
                            return;
                        }
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(h.b, str);
                        editorEdit.commit();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
