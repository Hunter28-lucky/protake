package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import defpackage.eb;
import defpackage.ua;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap map2;
        String strM8369 = ua.m8369(map, "appchannel", "");
        map2 = new HashMap();
        map2.put("AA1", context.getPackageName());
        eb.m6000();
        map2.put("AA2", eb.m6001(context));
        map2.put("AA3", "APPSecuritySDK-ALIPAYSDK");
        map2.put("AA4", "3.4.0.202206130311");
        map2.put("AA6", strM8369);
        return map2;
    }
}
