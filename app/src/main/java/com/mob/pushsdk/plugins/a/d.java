package com.mob.pushsdk.plugins.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobHandlerThread;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class d implements Handler.Callback {
    public int b;
    public int c = 1;
    public Handler a = MobHandlerThread.newHandler(this);
    public b d = new b();

    public void a(int i, Bundle bundle) {
        com.mob.pushsdk.plugins.a aVarB = com.mob.pushsdk.plugins.b.b();
        if (aVarB != null) {
            if ((aVarB instanceof com.mob.pushsdk.plugins.meizu.b) || (aVarB instanceof com.mob.pushsdk.plugins.xiaomi.b)) {
                Message messageObtainMessage = this.a.obtainMessage();
                messageObtainMessage.what = i;
                messageObtainMessage.setData(bundle);
                this.a.sendMessageDelayed(messageObtainMessage, 2000L);
            }
        }
    }

    public abstract void a(List<String> list);

    public abstract void b();

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    public void a(boolean z, List<String> list) {
        if (z) {
            a(list);
        } else {
            b();
        }
    }
}
