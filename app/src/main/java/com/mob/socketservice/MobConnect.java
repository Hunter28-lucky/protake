package com.mob.socketservice;

import android.content.Context;
import com.mob.socketservice.ConnectManager;
import com.mob.tools.proguard.ClassKeeper;

/* loaded from: classes2.dex */
public class MobConnect implements ClassKeeper {
    public static final int SDK_VERSION_CODE;
    private static final String SDK_VERSION_NAME = "3.2.8";
    public static String sdkTag = "MOBCONNECT";

    static {
        String[] strArrSplit = SDK_VERSION_NAME.split("\\.");
        int length = strArrSplit.length;
        if (length > 3) {
            length = 3;
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i = (i * 100) + Integer.parseInt(strArrSplit[i2]);
        }
        SDK_VERSION_CODE = i;
        init();
    }

    public static void bindService(Context context, ServiceMessageData serviceMessageData, ConnectManager.ServiceConnectionListener serviceConnectionListener) {
        ConnectManager.getInstance().bindService(context, serviceMessageData, serviceConnectionListener);
    }

    public static void checkTcpStatus() {
        ConnectManager.getInstance().checkTcpStatus();
    }

    public static void guardAck(int i, String str) {
        ConnectManager.getInstance().sendGuardAck(i, str);
    }

    public static void init() {
    }

    public static boolean reconnect(ServiceMessageData serviceMessageData) {
        d.d();
        return ConnectManager.getInstance().reconnect(serviceMessageData);
    }
}
