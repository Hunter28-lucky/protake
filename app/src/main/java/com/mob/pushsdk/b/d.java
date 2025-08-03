package com.mob.pushsdk.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.mob.MobSDK;
import com.mob.pushsdk.base.PLog;

/* loaded from: classes2.dex */
public class d {
    private static d a;
    private static int b;

    private d() {
        Context context = MobSDK.getContext();
        try {
            Bundle bundle = context.getPackageManager().getPackageInfo(context.getPackageName(), 128).applicationInfo.metaData;
            if (bundle != null) {
                b = bundle.getInt("com.mob.mobpush.debugLevel");
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public void b(String str) {
        if (b > 1) {
            Log.i("MobPushLogger", "[MobPush]" + str);
        }
    }

    public void c(String str) {
        if (b > 2) {
            Log.w("MobPushLogger", "[MobPush]" + str);
        }
    }

    public void d(String str) {
        if (b >= 4) {
            Log.e("MobPushLogger", "[MobPush]" + str);
        }
    }

    public void a(String str) {
        if (b >= 1) {
            Log.i("MobPushLogger", "[MobPush]" + str);
        }
    }
}
