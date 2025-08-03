package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import defpackage.ua;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SecurityClientMobile {
    public static synchronized String GetApdid(Context context, Map<String, String> map) {
        HashMap map2 = new HashMap();
        map2.put("utdid", ua.m8369(map, "utdid", ""));
        map2.put("tid", ua.m8369(map, "tid", ""));
        map2.put("userId", ua.m8369(map, "userId", ""));
        APSecuritySdk.getInstance(context).initToken(0, map2, null);
        return a.a(context);
    }
}
