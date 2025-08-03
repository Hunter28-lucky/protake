package com.mob.pushsdk.impl;

import android.os.SystemClock;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ReceivedMsg implements Serializable {
    public String msgId;
    public long receivedTime = SystemClock.elapsedRealtime();

    public ReceivedMsg(String str) {
        this.msgId = str;
    }

    public boolean isExpired() {
        return this.receivedTime < SystemClock.elapsedRealtime() - 864000000;
    }
}
