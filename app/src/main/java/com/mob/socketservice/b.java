package com.mob.socketservice;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class b {
    public static PendingIntent a(Context context, int i, Intent intent, int i2) {
        try {
            if (TextUtils.isEmpty(intent.getPackage())) {
                intent.setPackage(context.getPackageName());
            }
            int i3 = i2 | 67108864;
            try {
                return PendingIntent.getBroadcast(context, i, intent, i3);
            } catch (Throwable th) {
                CLog.getInstance().d(th);
                return PendingIntent.getBroadcast(context, i, intent, i3);
            }
        } catch (Throwable th2) {
            CLog.getInstance().d(th2);
            return null;
        }
    }
}
