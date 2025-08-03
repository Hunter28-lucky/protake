package com.mob.commons;

import com.mob.tools.proguard.PublicMemberKeeper;

@Deprecated
/* loaded from: classes2.dex */
public class ForbThrowable extends Throwable implements PublicMemberKeeper {
    public static final int CODE_NO_GMS = 900;
    private int code;

    public ForbThrowable() {
        super("Service is forbidden currently");
    }

    public static ForbThrowable obtainGpThrowable() {
        return new ForbThrowable(900, "Service unavailable due to Google Play Services is unavailable!");
    }

    public ForbThrowable(String str) {
        super(str);
    }

    public ForbThrowable(int i, String str) {
        this(str);
        this.code = i;
    }
}
