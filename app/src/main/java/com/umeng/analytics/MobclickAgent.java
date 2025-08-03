package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.umeng.analytics.pro.j;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.umcrash.UMCrash;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MobclickAgent {

    public enum EScenarioType {
        E_UM_NORMAL(0),
        E_UM_GAME(1);

        private int a;

        EScenarioType(int i) {
            this.a = i;
        }

        public int toValue() {
            return this.a;
        }
    }

    public enum PageMode {
        AUTO,
        MANUAL,
        LEGACY_AUTO,
        LEGACY_MANUAL
    }

    public static void clearPreProperties(Context context) {
        getAgent().g(context);
    }

    public static void disable() {
        AnalyticsConfig.enable = false;
    }

    private static void disableExceptionCatch() {
        b.a().a(false);
        AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    }

    public static void enableEncrypt(boolean z) {
    }

    public static b getAgent() {
        return b.a();
    }

    public static JSONObject getPreProperties(Context context) {
        return getAgent().h(context);
    }

    private static void init(Context context) {
        b.a().a(context);
    }

    public static void onEvent(Context context, String str) {
        b.a().a(context, str, (String) null, -1L, 1);
    }

    public static void onEventObject(Context context, String str, Map<String, Object> map) {
        if (map == null) {
            UMLog.aq(j.a, 0, "\\|");
        } else {
            b.a().a(context, str, map, -1L);
        }
    }

    public static void onEventValue(Context context, String str, Map<String, String> map, int i) {
        HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put("__ct__", Integer.valueOf(i));
        b.a().a(context, str, map2, -1L);
    }

    private static void onGKVEvent(Context context, String str, HashMap<String, Object> map) {
        b.a().a(context, str, map);
    }

    public static void onKillProcess(Context context) {
        b.a().d(context);
    }

    public static void onPageEnd(String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.D, 0, "\\|");
        } else {
            b.a().b(str);
        }
    }

    public static void onPageStart(String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.C, 0, "\\|");
        } else {
            b.a().a(str);
        }
    }

    public static void onPause(Context context) {
        b.a().c(context);
    }

    public static void onProfileSignIn(String str) {
        onProfileSignIn("_adhoc", str);
    }

    public static void onProfileSignOff() {
        b.a().j();
    }

    public static void onResume(Context context) {
        if (context == null) {
            UMLog.aq(j.n, 0, "\\|");
        } else {
            b.a().b(context);
        }
    }

    public static void registerPreProperties(Context context, JSONObject jSONObject) {
        getAgent().a(context, jSONObject);
    }

    public static void reportError(Context context, String str) {
        try {
            EfsReporter efsReporter = UMCrash.sReporter;
            Method declaredMethod = UMCrash.class.getDeclaredMethod("generateCustomLog", String.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(UMCrash.class, str, "DEFAULT");
            }
        } catch (Throwable unused) {
        }
    }

    public static void setCatchUncaughtExceptions(boolean z) {
        b.a().a(z);
    }

    public static void setCheckDevice(boolean z) {
    }

    public static void setDebugMode(boolean z) {
    }

    public static void setFirstLaunchEvent(Context context, List<String> list) {
        getAgent().a(context, list);
    }

    private static void setGameScenarioType(Context context) {
        b.a().a(context, EScenarioType.E_UM_GAME);
    }

    public static void setLatencyWindow(long j) {
    }

    public static void setLocation(double d, double d2) {
        b.a().a(d, d2);
    }

    public static void setOpenGLContext(GL10 gl10) {
        b.a().a(gl10);
    }

    public static void setPageCollectionMode(PageMode pageMode) {
        UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION = pageMode;
    }

    public static void setScenarioType(Context context, EScenarioType eScenarioType) {
    }

    public static void setSecret(Context context, String str) {
        b.a().c(context, str);
    }

    public static void setSessionContinueMillis(long j) {
        if (j <= 30000) {
            j = 30000;
        }
        b.a().a(j);
    }

    private static void setSysListener(ISysListener iSysListener) {
        b.a().a(iSysListener);
    }

    public static void unregisterPreProperty(Context context, String str) {
        getAgent().f(context, str);
    }

    public static void onEvent(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.aq(j.k, 0, "\\|");
        } else {
            b.a().a(context, str, str2, -1L, 1);
        }
    }

    public static void onProfileSignIn(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.aq(j.t, 0, "\\|");
            return;
        }
        if (str2.length() > 64) {
            UMLog.aq(j.u, 0, "\\|");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            b.a().a("_adhoc", str2);
        } else if (str.length() > 32) {
            UMLog.aq(j.v, 0, "\\|");
        } else {
            b.a().a(str, str2);
        }
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        if (map == null) {
            UMLog.aq(j.a, 0, "\\|");
        } else {
            b.a().a(context, str, new HashMap(map), -1L);
        }
    }

    public static void reportError(Context context, Throwable th) {
        try {
            EfsReporter efsReporter = UMCrash.sReporter;
            Method declaredMethod = UMCrash.class.getDeclaredMethod("generateCustomLog", Throwable.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(UMCrash.class, th, "DEFAULT");
            }
        } catch (Throwable unused) {
        }
    }
}
