package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.ew;

/* loaded from: classes2.dex */
class et {
    private static final boolean a = Log.isLoggable("BCompressed", 3);

    public static byte[] a(es esVar, byte[] bArr) {
        try {
            byte[] bArrA = ew.a.a(bArr);
            if (a) {
                com.xiaomi.channel.commonutils.logger.b.m5114a("BCompressed", "decompress " + bArr.length + " to " + bArrA.length + " for " + esVar);
                if (esVar.f5868a == 1) {
                    com.xiaomi.channel.commonutils.logger.b.m5114a("BCompressed", "decompress not support upStream");
                }
            }
            return bArrA;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5114a("BCompressed", "decompress error " + e2);
            return bArr;
        }
    }
}
