package com.efs.sdk.base.core.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import java.io.File;

/* loaded from: classes.dex */
public final class c extends Handler implements Runnable {
    public boolean a;

    public static class a {
        private static final c a = new c(0);
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public static c a() {
        return a.a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 2) {
            WorkThreadUtil.submit(this);
            return;
        }
        Log.w("efs.cache", "disk listener not support command: " + message.what);
    }

    @Override // java.lang.Runnable
    public final void run() throws NumberFormatException {
        com.efs.sdk.base.core.b.a unused = a.b.a;
        File fileF = com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (fileF.exists()) {
            for (File file : com.efs.sdk.base.core.util.b.d(fileF)) {
                if (com.efs.sdk.base.core.b.a.a(file.getName())) {
                    com.efs.sdk.base.core.b.a.c(file);
                }
            }
        }
        com.efs.sdk.base.core.config.a.c cVarA = com.efs.sdk.base.core.config.a.c.a();
        String str = cVarA.d.f.containsKey("disk_bytes") ? cVarA.d.f.get("disk_bytes") : "4194304";
        long j = Long.parseLong(TextUtils.isEmpty(str) ? "4194304" : str);
        long jC = com.efs.sdk.base.core.util.b.c(com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid())) + com.efs.sdk.base.core.util.b.c(com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
        boolean z = jC < j;
        this.a = z;
        if (!z) {
            Log.w("efs.cache", "Cache Limited! curr " + jC + "byte, max " + j + " byte.");
        }
        sendEmptyMessageDelayed(2, 600000L);
    }

    private c() {
        super(com.efs.sdk.base.core.util.concurrent.a.a.getLooper());
        this.a = true;
        sendEmptyMessageDelayed(2, 60000L);
    }
}
