package com.mob.pushsdk.impl;

import android.os.Handler;
import android.os.Message;
import com.mob.pushsdk.base.PLog;

/* loaded from: classes2.dex */
public abstract class f implements Handler.Callback {
    public abstract boolean a(Message message);

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            return a(message);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
            return false;
        }
    }
}
