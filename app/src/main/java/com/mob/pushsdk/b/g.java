package com.mob.pushsdk.b;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.mob.pushsdk.base.PLog;

/* loaded from: classes2.dex */
public class g {
    public static PendingIntent a(Context context, int i, Intent intent, int i2) {
        try {
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    intent.setComponent(new ComponentName(context.getPackageName(), "com.mob.pushsdk.impl.MobPushActivity"));
                    return c(context, i, intent, i2);
                }
            } catch (Throwable th) {
                PLog.getInstance().d(th);
            }
            return b(context, i, intent, i2);
        } catch (Throwable th2) {
            PLog.getInstance().d(th2);
            return null;
        }
    }

    public static PendingIntent b(Context context, int i, Intent intent, int i2) {
        try {
            if (TextUtils.isEmpty(intent.getPackage())) {
                intent.setPackage(context.getPackageName());
            }
            int i3 = i2 | 67108864;
            try {
                return PendingIntent.getBroadcast(context, i, intent, i3);
            } catch (Throwable th) {
                PLog.getInstance().d(th);
                return PendingIntent.getBroadcast(context, i, intent, i3);
            }
        } catch (Throwable th2) {
            PLog.getInstance().d(th2);
            return null;
        }
    }

    public static PendingIntent c(Context context, int i, Intent intent, int i2) {
        try {
            if (TextUtils.isEmpty(intent.getPackage())) {
                intent.setPackage(context.getPackageName());
            }
            int i3 = i2 | 67108864;
            try {
                return PendingIntent.getActivity(context, i, intent, i3);
            } catch (Throwable th) {
                PLog.getInstance().d(th);
                return PendingIntent.getActivity(context, i, intent, i3);
            }
        } catch (Throwable th2) {
            PLog.getInstance().d(th2);
            return null;
        }
    }
}
