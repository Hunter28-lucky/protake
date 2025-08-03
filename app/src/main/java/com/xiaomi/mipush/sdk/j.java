package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class j {
    private static volatile j a;

    /* renamed from: a, reason: collision with other field name */
    private final Context f5530a;

    private j(Context context) {
        this.f5530a = context.getApplicationContext();
    }

    private static j a(Context context) {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j(context);
                }
            }
        }
        return a;
    }

    public static void b(Context context, hc hcVar, Intent intent, boolean z) {
        a(context).a(hcVar, intent, 2, z);
    }

    public static void c(Context context, hc hcVar, Intent intent, boolean z) {
        a(context).a(hcVar, intent, 3, z);
    }

    public static void d(Context context, hc hcVar, Intent intent, boolean z) {
        a(context).a(hcVar, intent, 4, z);
    }

    public static void e(Context context, hc hcVar, Intent intent, boolean z) {
        a(context).a(hcVar, intent, 8, z);
    }

    public static void f(Context context, hc hcVar, Intent intent, boolean z) {
        b bVarM5140a = b.m5140a(context);
        if (TextUtils.isEmpty(bVarM5140a.m5148c()) || TextUtils.isEmpty(bVarM5140a.d())) {
            a(context).a(hcVar, intent, 6, z);
        } else if (bVarM5140a.m5152f()) {
            a(context).a(hcVar, intent, 7, z);
        } else {
            a(context).a(hcVar, intent, 5, z);
        }
    }

    public static void a(Context context, hc hcVar, Intent intent, boolean z) {
        a(context).a(hcVar, intent, 1, z);
    }

    public static void a(Context context, hc hcVar, Intent intent, long j) {
        a(context).a(hcVar, intent, 0, true, j);
    }

    private void a(hc hcVar, Intent intent, int i, boolean z) {
        a(hcVar, intent, i, z, System.currentTimeMillis());
    }

    private void a(hc hcVar, Intent intent, int i, boolean z, long j) {
        if (com.xiaomi.push.j.m5690a(this.f5530a) || !com.xiaomi.push.j.m5689a() || hcVar == null || hcVar.f6123a != gg.SendMessage || hcVar.m5593a() == null || !z) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("click to start activity result:" + String.valueOf(i));
        hf hfVar = new hf(hcVar.m5593a().m5559a(), false);
        hfVar.c(gq.SDK_START_ACTIVITY.f6003a);
        hfVar.b(hcVar.m5594a());
        hfVar.d(hcVar.f6130b);
        HashMap map = new HashMap();
        hfVar.f6142a = map;
        map.put("result", String.valueOf(i));
        hfVar.f6142a.put("time", String.valueOf(j));
        hfVar.f6142a.put("sdk_vc", String.valueOf(BuildConfig.VERSION_CODE));
        if (intent != null) {
            long longExtra = intent.getLongExtra("nca_create_time", 0L);
            if (longExtra > 0) {
                hfVar.f6142a.put("nca_create_time", String.valueOf(longExtra));
            }
            long longExtra2 = intent.getLongExtra("nca_resume_time", 0L);
            if (longExtra2 > 0) {
                hfVar.f6142a.put("nca_resume_time", String.valueOf(longExtra2));
            }
            long longExtra3 = intent.getLongExtra("pmh_handle_time", 0L);
            if (longExtra3 > 0) {
                hfVar.f6142a.put("pmh_handle_time", String.valueOf(longExtra3));
            }
        }
        u.a(this.f5530a).a(hfVar, gg.Notification, false, false, null, true, hcVar.f6130b, hcVar.f6126a, true, false);
    }
}
