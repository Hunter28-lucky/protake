package com.xiaomi.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.push.hx;
import com.xiaomi.push.ih;

/* loaded from: classes2.dex */
public class hq {
    public static <T extends hr<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new hw(new hx.a()).a(t);
        } catch (hv e2) {
            com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", e2);
            return null;
        }
    }

    public static <T extends hr<T, ?>> void a(T t, byte[] bArr) {
        if (bArr != null) {
            new hu(new ih.a(true, true, bArr.length)).a(t, bArr);
            return;
        }
        throw new hv("the message byte is empty.");
    }

    public static short a(Context context, hc hcVar) {
        gt gtVarM5593a = hcVar.m5593a();
        return m5660a(context, hcVar.f6130b, (gtVarM5593a == null || gtVarM5593a.m5560a() == null) ? null : gtVarM5593a.m5560a().get("channel_id"));
    }

    public static short a(Context context, String str) {
        return m5660a(context, str, (String) null);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static short m5660a(Context context, String str, String str2) {
        return (short) (g.a(context, str, false).a() + 0 + (ae.b(context) ? 4 : 0) + (ae.a(context) ? 8 : 0) + (com.xiaomi.push.service.af.m5745a(context) ? 16 : 0) + a(context, str, str2));
    }

    private static int a(Context context, String str, String str2) {
        com.xiaomi.push.service.af afVarA;
        NotificationChannel notificationChannelM5747a;
        if (Build.VERSION.SDK_INT < 26 || context == null || TextUtils.isEmpty(str) || (afVarA = com.xiaomi.push.service.af.a(context, str)) == null || (notificationChannelM5747a = afVarA.m5747a(afVarA.m5750a(str2))) == null) {
            return 0;
        }
        return notificationChannelM5747a.getImportance() != 0 ? 32 : 64;
    }
}
