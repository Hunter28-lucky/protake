package com.mob.commons.logcollector;

import com.mob.tools.log.LogCollector;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashMap;

@Deprecated
/* loaded from: classes2.dex */
public class DefaultLogsCollector implements LogCollector, PublicMemberKeeper {
    private static DefaultLogsCollector a;
    private final HashMap<String, Integer> b = new HashMap<>();

    private DefaultLogsCollector() {
    }

    public static synchronized DefaultLogsCollector get() {
        if (a == null) {
            a = new DefaultLogsCollector();
        }
        return a;
    }

    public void addSDK(String str, int i) {
        synchronized (this.b) {
            this.b.put(str, Integer.valueOf(i));
        }
    }

    @Override // com.mob.tools.log.LogCollector
    public final void log(String str, int i, int i2, String str2, String str3) {
        Integer num = this.b.get(str);
        if (num == null) {
            num = -1;
        }
        NLog.getInstance(str, num.intValue(), str).log(i, str3, new Object[0]);
    }
}
