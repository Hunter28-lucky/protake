package com.mob.pushsdk.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mob.pushsdk.base.PLog;

/* loaded from: classes2.dex */
public class MobPushReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            PLog.getInstance().i("MobPushReceiver receive broadcast " + intent.getAction(), new Object[0]);
        } catch (Throwable th) {
            PLog.getInstance().e("MobPushReceiver receive broadcast " + th.getMessage(), new Object[0]);
        }
    }
}
