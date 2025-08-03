package com.alipay.apmobilesecuritysdk.otherid;

import android.content.Context;
import defpackage.ua;
import defpackage.ye;

/* loaded from: classes.dex */
public class UmidSdkWrapper {
    public static final String UMIDTOKEN_FILE_NAME = "xxxwww_v2";
    public static final String UMIDTOKEN_KEY_NAME = "umidtk";
    public static volatile String cachedUmidToken = "";
    public static volatile boolean initUmidFinished = false;

    public static String compatUmidBug(Context context, String str) {
        if (!ua.m8370(str) && !ua.m8371(str, "000000000000000000000000")) {
            return str;
        }
        String utdid = UtdidWrapper.getUtdid(context);
        if (utdid != null && utdid.contains("?")) {
            utdid = "";
        }
        return ua.m8370(utdid) ? "" : utdid;
    }

    public static synchronized String getSecurityToken(Context context) {
        return cachedUmidToken;
    }

    public static String startUmidTaskSync(Context context, int i) {
        return "";
    }

    public static synchronized void updateLocalUmidToken(Context context, String str) {
        if (ua.m8373(str)) {
            ye.m8632(context, UMIDTOKEN_FILE_NAME, UMIDTOKEN_KEY_NAME, str);
            cachedUmidToken = str;
        }
    }
}
