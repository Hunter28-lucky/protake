package com.umeng.analytics.vshelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: RealTimeDebugSwitch.java */
/* loaded from: classes2.dex */
public class b implements ar {
    private static final String a = "RealTimeDebugSwitch";
    private static int b;

    @Override // com.umeng.analytics.pro.ar
    public void a() {
    }

    @Override // com.umeng.analytics.pro.ar
    public void a(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.ar
    public void a(Activity activity, Bundle bundle) {
        long jLongValue;
        if (b == 0) {
            Intent intent = activity.getIntent();
            if (intent == null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> intent: " + intent);
                return;
            }
            Uri data = intent.getData();
            if (data == null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> uri: " + data);
                return;
            }
            String scheme = data.getScheme();
            if (scheme == null || !scheme.startsWith("um.")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> scheme: " + scheme);
                return;
            }
            String queryParameter = data.getQueryParameter("debugkey");
            String queryParameter2 = data.getQueryParameter(AnalyticsConfig.DEBUG_MODE_PERIOD);
            if (TextUtils.isEmpty(queryParameter)) {
                return;
            }
            if (TextUtils.isEmpty(queryParameter2)) {
                jLongValue = 0;
            } else {
                try {
                    jLongValue = Long.valueOf(queryParameter2).longValue();
                } catch (Throwable unused) {
                }
            }
            HashMap map = new HashMap();
            map.put("debugkey", queryParameter);
            if (jLongValue < 0) {
                if (!AnalyticsConfig.isRealTimeDebugMode()) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Not currently in RealTimeDebug mode and doing nothing.");
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> call turnOffRealTimeDebug because sendaging < 0");
                AnalyticsConfig.turnOffRealTimeDebug();
                Context applicationContext = activity.getApplicationContext();
                UMWorkDispatch.sendEvent(applicationContext, o.a.F, CoreProtocol.getInstance(applicationContext), null);
                return;
            }
            if (jLongValue <= 0) {
                AnalyticsConfig.turnOnRealTimeDebug(map);
                Context applicationContext2 = activity.getApplicationContext();
                UMWorkDispatch.sendEvent(applicationContext2, o.a.F, CoreProtocol.getInstance(applicationContext2), null);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> turnOnRealTimeDebug[non-persistent] dk: " + queryParameter);
                return;
            }
            AnalyticsConfig.turnOnRealTimeDebug(map);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AnalyticsConfig.RTD_START_TIME, System.currentTimeMillis());
                if (jLongValue < 60) {
                    jLongValue = 60;
                }
                if (jLongValue > 240) {
                    jLongValue = 240;
                }
                jSONObject.put("period", jLongValue);
                jSONObject.put("debugkey", queryParameter);
            } catch (Throwable unused2) {
            }
            Context applicationContext3 = activity.getApplicationContext();
            UMWorkDispatch.sendEvent(applicationContext3, o.a.E, CoreProtocol.getInstance(applicationContext3), jSONObject);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> turnOnRealTimeDebug[persistent] dk: " + queryParameter + "; period: " + jLongValue);
        }
    }

    @Override // com.umeng.analytics.pro.ar
    public void b() {
    }

    @Override // com.umeng.analytics.pro.ar
    public void b(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.ar
    public void b(Activity activity, Bundle bundle) {
    }

    @Override // com.umeng.analytics.pro.ar
    public void c() {
    }

    @Override // com.umeng.analytics.pro.ar
    public void c(Activity activity) {
        b++;
    }

    @Override // com.umeng.analytics.pro.ar
    public void d(Activity activity) {
        b--;
    }

    @Override // com.umeng.analytics.pro.ar
    public void e(Activity activity) {
    }
}
