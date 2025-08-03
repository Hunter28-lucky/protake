package cn.smssdk.utils;

import com.mob.commons.logcollector.LogsCollector;
import com.mob.tools.log.NLog;

/* loaded from: classes.dex */
public class SMSLog extends NLog {
    public static final String FORMAT = "[SMSSDK][%s][%s] %s";
    public static final String FORMAT_SIMPLE = "[SMSSDK] %s";

    private SMSLog() {
        NLog.setCollector("SMSSDK", new LogsCollector(this) { // from class: cn.smssdk.utils.SMSLog.1
            @Override // com.mob.commons.logcollector.LogsCollector
            public String getSDKTag() {
                return "SMSSDK";
            }

            @Override // com.mob.commons.logcollector.LogsCollector
            public int getSDKVersion() {
                return a.f17624e;
            }
        });
    }

    public static NLog getInstance() {
        return NLog.getInstanceForSDK("SMSSDK", true);
    }

    public static NLog prepare() {
        return new SMSLog();
    }
}
