package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class cl {

    /* renamed from: a, reason: collision with other field name */
    private static final List<String> f5675a = Arrays.asList(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY, "002", "003", "004", "005");
    private static Boolean a = null;

    public static void a(String str, String str2) {
    }

    public static boolean a(Context context) {
        if (a == null) {
            try {
                if (!j.m5690a(context)) {
                    a = Boolean.FALSE;
                }
                String strM5808a = com.xiaomi.push.service.q.m5808a(context);
                if (TextUtils.isEmpty(strM5808a) || strM5808a.length() < 3) {
                    a = Boolean.FALSE;
                } else {
                    a = Boolean.valueOf(f5675a.contains(strM5808a.substring(strM5808a.length() - 3)));
                }
                a("Sampling statistical connection quality: " + a);
            } catch (Throwable th) {
                a = Boolean.FALSE;
                com.xiaomi.channel.commonutils.logger.b.c("Push-ConnectionQualityStatsHelper", "Determine sampling switch error: " + th);
            }
        }
        return a.booleanValue();
    }

    public static void a(String str) {
        a("Push-ConnectionQualityStatsHelper", str);
    }
}
