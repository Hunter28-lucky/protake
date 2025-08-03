package com.mob.pushsdk.plugins.a;

import android.os.Message;
import com.mob.pushsdk.base.PLog;
import java.util.List;

/* loaded from: classes2.dex */
public class c extends d {

    /* renamed from: e, reason: collision with root package name */
    private static c f17702e;

    private c() {
    }

    public static synchronized c a() {
        if (f17702e == null) {
            f17702e = new c();
        }
        return f17702e;
    }

    @Override // com.mob.pushsdk.plugins.a.d
    public void b() {
        if (this.c >= 2) {
            PLog.getInstance().d("MobPush plugin action " + this.d.a() + " second fail, don't try again!!!", new Object[0]);
            return;
        }
        PLog.getInstance().d("MobPush plugin action " + this.d.a() + "fail, retry!!!", new Object[0]);
        int iA = this.d.a();
        if (iA == 3002) {
            this.d.b();
        } else if (iA == 3004) {
            this.d.c();
        }
        this.c++;
    }

    @Override // com.mob.pushsdk.plugins.a.d, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        this.d.a(message.getData().getString("new"));
        int i = message.what;
        this.b = i;
        if (i == 3002) {
            this.d.b();
            return false;
        }
        if (i != 3004) {
            return false;
        }
        this.d.c();
        return false;
    }

    @Override // com.mob.pushsdk.plugins.a.d
    public void a(List<String> list) {
        this.c = 1;
        this.d.a();
    }
}
