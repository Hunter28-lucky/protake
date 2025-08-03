package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public class COSPushHelper {
    private static long a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static volatile boolean f5487a = false;

    public static void convertMessage(Intent intent) {
        f.a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = a;
            if (j <= 0 || j + Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL <= jElapsedRealtime) {
                a = jElapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f5487a;
    }

    public static boolean hasNetwork(Context context) {
        return f.m5163a(context);
    }

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager abstractPushManagerA = e.a(context).a(d.ASSEMBLE_PUSH_COS);
        if (abstractPushManagerA != null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("ASSEMBLE_PUSH :  register cos when network change!");
            abstractPushManagerA.register();
        }
    }

    public static synchronized void setNeedRegister(boolean z) {
        f5487a = z;
    }

    public static void uploadToken(Context context, String str) {
        f.m5162a(context, d.ASSEMBLE_PUSH_COS, str);
    }
}
