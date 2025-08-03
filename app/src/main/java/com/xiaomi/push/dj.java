package com.xiaomi.push;

import android.content.Context;
import android.os.Build;

/* loaded from: classes2.dex */
public class dj {
    public static byte[] a(String str, byte[] bArr) {
        byte[] bArrM5226a = az.m5226a(str);
        try {
            a(bArrM5226a);
            return h.a(bArrM5226a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] bArrM5226a = az.m5226a(str);
        try {
            a(bArrM5226a);
            return h.b(bArrM5226a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j) {
        if (com.xiaomi.push.service.ah.a(context).a(gl.DCJobMutualSwitch.a(), false)) {
            return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !ad.a(context, str, j);
        }
        return false;
    }
}
