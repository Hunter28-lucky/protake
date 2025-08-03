package com.mob.pushsdk.impl;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.mob.MobSDK;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.utils.ReflectHelper;

/* loaded from: classes2.dex */
public class d {

    public static class a {
        private static final d a = new d();
    }

    public static d a() {
        return a.a;
    }

    public void b() {
        j.a().b();
        l.a().b();
    }

    private d() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            ReflectHelper.invokeInstanceMethod(MobSDK.getContext(), "registerReceiver", new Object[]{new ConnectivityReceiver(), intentFilter}, new Class[]{BroadcastReceiver.class, IntentFilter.class});
        } catch (Throwable th) {
            PLog.getInstance().e(th.toString(), new Object[0]);
        }
    }
}
