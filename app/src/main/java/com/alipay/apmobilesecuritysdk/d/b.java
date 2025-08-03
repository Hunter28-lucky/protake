package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import defpackage.ua;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap map2;
        map2 = new HashMap();
        String strM8369 = ua.m8369(map, "tid", "");
        String strM83692 = ua.m8369(map, "utdid", "");
        String strM83693 = ua.m8369(map, "userId", "");
        String strM83694 = ua.m8369(map, "appName", "");
        String strM83695 = ua.m8369(map, "appKeyClient", "");
        String strM83696 = ua.m8369(map, "tmxSessionId", "");
        String strF = h.f(context);
        String strM83697 = ua.m8369(map, "sessionId", "");
        map2.put("AC1", strM8369);
        map2.put("AC2", strM83692);
        map2.put("AC3", "");
        map2.put("AC4", strF);
        map2.put("AC5", strM83693);
        map2.put("AC6", strM83696);
        map2.put("AC7", "");
        map2.put("AC8", strM83694);
        map2.put("AC9", strM83695);
        if (ua.m8373(strM83697)) {
            map2.put("AC10", strM83697);
        }
        return map2;
    }
}
