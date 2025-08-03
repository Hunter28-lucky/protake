package com.blink.academy.film.stream;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.efs.sdk.base.core.util.NetworkUtil;
import defpackage.C4638;
import defpackage.n;

/* loaded from: classes.dex */
public class WifiReceiver extends BroadcastReceiver {
    private static final String TAG = "wifiReceiver";
    private boolean first = true;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.wifi.RSSI_CHANGED")) {
            C4638.m14104(TAG, "wifi信号强度变化");
        }
        if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo.getState().equals(NetworkInfo.State.DISCONNECTED)) {
                C4638.m14104(TAG, "wifi断开");
                FinderManager.getInstance().onNetClose();
                this.first = false;
            } else if (networkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
                C4638.m14104(TAG, "连接到网络 " + ((WifiManager) context.getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo().getSSID());
                FinderManager.getInstance().restartNSDServer();
                if (!this.first) {
                    n.m7588().m7596(null);
                    n.m7588().m7594(null);
                }
                this.first = false;
            }
        }
        if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            int intExtra = intent.getIntExtra("wifi_state", 1);
            if (intExtra == 1) {
                C4638.m14104(TAG, "系统关闭wifi");
                FinderManager.getInstance().onNetClose();
            } else if (intExtra == 3) {
                C4638.m14104(TAG, "系统开启wifi");
            }
        }
    }
}
