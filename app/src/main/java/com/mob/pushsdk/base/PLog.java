package com.mob.pushsdk.base;

import com.mob.commons.logcollector.DefaultLogsCollector;
import com.mob.tools.log.NLog;

/* loaded from: classes2.dex */
public class PLog {
    public static final int SDK_VERSION_CODE;
    public static final String SDK_VERSION_NAME = "3.3.9";
    private static NLog logger = null;
    private static Object object = new Object();
    public static String sdkTag = "MOBPUSH";

    static {
        String[] strArrSplit = "3.3.9".split("\\.");
        int length = strArrSplit.length;
        if (length > 3) {
            length = 3;
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i = (i * 100) + Integer.parseInt(strArrSplit[i2]);
        }
        SDK_VERSION_CODE = i;
    }

    public static NLog getInstance() {
        if (logger == null) {
            synchronized (object) {
                if (logger == null) {
                    prepare();
                }
            }
        }
        return logger;
    }

    public static NLog prepare() {
        DefaultLogsCollector defaultLogsCollector = DefaultLogsCollector.get();
        defaultLogsCollector.addSDK(sdkTag, SDK_VERSION_CODE);
        NLog nLog = NLog.getInstance(sdkTag);
        logger = nLog;
        nLog.setCollector(defaultLogsCollector);
        return logger;
    }
}
