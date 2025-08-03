package com.mob.tools;

import com.mob.MobSDK;
import com.mob.commons.j;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.EverythingKeeper;

/* loaded from: classes2.dex */
public class MobLog implements EverythingKeeper {
    public static synchronized NLog getInstance() {
        return NLog.getInstance("MobSDK", MobSDK.SDK_VERSION_CODE, j.a("009j7cadacj1b(cacacbde"));
    }
}
