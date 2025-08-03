package com.mob.pushsdk.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.mob.MobSDK;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.utils.DeviceHelper;

/* loaded from: classes2.dex */
public class ConnectivityReceiver extends BroadcastReceiver {
    private int a = -1;

    private void a(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            if (action != null && action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                String networkType = DeviceHelper.getInstance(context).getNetworkType();
                PLog.getInstance().d("MobPush receiver network " + networkType, new Object[0]);
                int i = NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(networkType) ? 1 : "4G".equalsIgnoreCase(networkType) ? 4 : "3G".equalsIgnoreCase(networkType) ? 3 : "2G".equalsIgnoreCase(networkType) ? 2 : "5G".equalsIgnoreCase(networkType) ? 5 : 0;
                if (i == this.a) {
                    return;
                }
                a(i);
                this.a = i;
            }
        } catch (Throwable th) {
            PLog.getInstance().e(th.toString(), new Object[0]);
        }
    }

    private int b(int i) {
        if (i == 0) {
            return 0;
        }
        if (i != 1) {
            return i != 4 ? 3 : 1;
        }
        return 2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a(context, intent);
    }

    private void a(int i) {
        String str;
        String networkType = DeviceHelper.getInstance(MobSDK.getContext()).getNetworkType();
        if (i == 0) {
            str = "关闭网络";
        } else {
            str = "打开" + networkType;
        }
        com.mob.pushsdk.biz.e.a(b(i), b(this.a), str, System.currentTimeMillis());
        this.a = i;
    }
}
