package com.efs.sdk.net;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import defpackage.AbstractC2613;
import defpackage.C2314;
import defpackage.C4539;
import defpackage.C5121;
import defpackage.InterfaceC3428;
import java.util.Map;

/* loaded from: classes.dex */
public class NetManager {
    private static final String TAG = "OkHttpManager";
    private static NetConfigManager mNetConfigManager;
    private static EfsReporter mReporter;

    public static void get(String str, InterfaceC3428 interfaceC3428) {
        new C5121.C5122().m14991(OkHttpListener.get()).m14985(new OkHttpInterceptor()).m14986().mo14869(new C4539.C4540().m13935(str).m13927()).mo9226(interfaceC3428);
    }

    public static NetConfigManager getNetConfigManager() {
        return mNetConfigManager;
    }

    public static EfsReporter getReporter() {
        return mReporter;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            Log.e(TAG, "init net manager error! parameter is null!");
        } else {
            mReporter = efsReporter;
            mNetConfigManager = new NetConfigManager(context, efsReporter);
        }
    }

    public static void post(String str, Map<String, Object> map, InterfaceC3428 interfaceC3428) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : map.keySet()) {
            sb.append(str2);
            sb.append("=");
            sb.append(map.get(str2));
            sb.append("&");
        }
        new C5121.C5122().m14991(OkHttpListener.get()).m14985(new OkHttpInterceptor()).m14986().mo14869(new C4539.C4540().m13935(str).m13932(AbstractC2613.create(C2314.m8683("application/x-www-form-urlencoded"), sb.toString())).m13927()).mo9226(interfaceC3428);
    }
}
