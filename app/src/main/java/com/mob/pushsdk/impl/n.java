package com.mob.pushsdk.impl;

import com.mob.pushsdk.base.PLog;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public abstract class n extends TimerTask {
    public abstract void a();

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Exception e2) {
            PLog.getInstance().e(e2);
        }
    }
}
