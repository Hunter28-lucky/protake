package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;

/* renamed from: com.xiaomi.push.r, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5341r {
    private static int a;

    /* renamed from: a, reason: collision with other field name */
    private static long f6325a;

    public static int a(Context context) {
        Bundle bundle;
        if (context != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - f6325a) > 86400000) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.android.systemui", 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                        a = bundle.getInt("SupportForPushVersionCode");
                        f6325a = jCurrentTimeMillis;
                    }
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.d("exception occurred in getting systemui support version, exception: " + th);
                }
            }
        }
        return a;
    }

    public static boolean b(Context context) {
        return a(context) >= 3;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5701a(Context context) {
        return a(context) >= 2;
    }
}
