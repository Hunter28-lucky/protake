package com.mob.pushsdk.impl;

import android.util.Log;
import com.mob.MobSDK;
import com.mob.pushsdk.base.PLog;

/* loaded from: classes2.dex */
public class a {
    private static volatile boolean a = false;

    public static boolean a(int i, long j, int i2) {
        return a(i, j, i2, true);
    }

    public static boolean a(int i, long j, int i2, boolean z) {
        long j2 = i;
        int i3 = (int) (j / j2);
        boolean zA = a();
        while (!zA && i3 > 0) {
            if (a) {
                if (!z) {
                    return false;
                }
                Log.e("MobPush", "MobPush init failed, Auth ban");
                return false;
            }
            i3--;
            if (i2 > 0) {
                i2--;
            } else if (z) {
                Log.e("MobPush", "MobPush initialization is waiting for the method MobSDK.submitPolicyGrantResult() invoked");
            }
            try {
                Thread.sleep(j2);
            } catch (Throwable th) {
                PLog.getInstance().d(th);
            }
            zA = a();
        }
        if (!zA && z) {
            Log.e("MobPush", "MobPush init failed. Please invoke method MobSDK.submitPolicyGrantResult()");
        }
        return zA;
    }

    public static boolean a() {
        try {
            int iIsAuth = MobSDK.isAuth();
            PLog.getInstance().d("MobPush MobSDK isAuth code:" + iIsAuth, new Object[0]);
            a = false;
            if (iIsAuth != 0) {
                if (iIsAuth == 1 || iIsAuth == 2) {
                    return true;
                }
                a = true;
            }
            return false;
        } catch (Throwable th) {
            PLog.getInstance().e(th);
            return true;
        }
    }
}
