package com.mob.socketservice;

import com.mob.commons.logcollector.DefaultLogsCollector;
import com.mob.tools.log.NLog;

/* loaded from: classes2.dex */
public class CLog {
    private static NLog logger;
    public static String sdkTag = MobConnect.sdkTag;
    private static Object object = new Object();

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
        defaultLogsCollector.addSDK(sdkTag, MobConnect.SDK_VERSION_CODE);
        NLog nLog = NLog.getInstance(sdkTag);
        logger = nLog;
        nLog.setCollector(defaultLogsCollector);
        return logger;
    }
}
