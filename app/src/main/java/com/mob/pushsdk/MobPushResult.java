package com.mob.pushsdk;

import com.mob.tools.proguard.ClassKeeper;

/* loaded from: classes2.dex */
public class MobPushResult implements ClassKeeper {
    public int code;
    public String msg;

    public MobPushResult(int i, String str) {
        this.code = i;
        this.msg = str;
    }
}
