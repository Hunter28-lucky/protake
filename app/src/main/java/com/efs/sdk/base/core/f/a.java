package com.efs.sdk.base.core.f;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.controller.ControllerCenter;

/* loaded from: classes.dex */
public abstract class a extends Handler {
    public ControllerCenter a;

    public a() {
        super(com.efs.sdk.base.core.util.concurrent.a.a.getLooper());
        sendEmptyMessageDelayed(0, 60000L);
    }

    public abstract void a();

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        a();
        sendEmptyMessageDelayed(0, 60000L);
    }
}
