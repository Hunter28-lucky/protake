package com.vivo.push.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.mob.MobSDK;
import com.mob.pushsdk.vivo.c.a;
import com.mob.pushsdk.vivo.c.d;
import com.mob.pushsdk.vivo.c.e;
import com.mob.tools.utils.DH;

/* loaded from: classes2.dex */
public class CommandClientService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        e.a(new Runnable() { // from class: com.vivo.push.sdk.service.CommandClientService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (a.b(intent) && a.b(intent.getExtras())) {
                        Intent intent2 = new Intent("com.vivo.pushclient.action.RECEIVE");
                        intent2.setPackage(DH.SyncMtd.getPackageName());
                        intent2.putExtras(intent.getExtras());
                        MobSDK.getContext().sendBroadcast(intent2);
                    }
                } catch (Throwable th) {
                    d.a().b(th);
                }
            }
        });
        return 2;
    }
}
