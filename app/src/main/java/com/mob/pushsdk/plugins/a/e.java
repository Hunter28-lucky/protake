package com.mob.pushsdk.plugins.a;

import android.os.Message;
import com.mob.pushsdk.base.PLog;
import java.util.List;

/* loaded from: classes2.dex */
public class e extends d {

    /* renamed from: e, reason: collision with root package name */
    private static e f17703e;

    private e() {
    }

    public static synchronized e a() {
        if (f17703e == null) {
            f17703e = new e();
        }
        return f17703e;
    }

    @Override // com.mob.pushsdk.plugins.a.d
    public void b() {
        if (this.c >= 2) {
            PLog.getInstance().d("MobPush plugin action " + this.d.a() + " second fail, don't try again!!!", new Object[0]);
            return;
        }
        PLog.getInstance().d("MobPush plugin action " + this.d.a() + "fail, retry!!!", new Object[0]);
        int iA = this.d.a();
        if (iA == 3005) {
            this.d.d();
        } else if (iA == 3007) {
            this.d.e();
        } else if (iA == 3008) {
            this.d.f();
        }
        this.c++;
    }

    @Override // com.mob.pushsdk.plugins.a.d, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        this.d.a(message.getData().getString("new"));
        int i = message.what;
        this.b = i;
        if (i == 3005) {
            this.d.d();
            return false;
        }
        if (i == 3007) {
            this.d.e();
            return false;
        }
        if (i != 3008) {
            return false;
        }
        this.d.f();
        return false;
    }

    @Override // com.mob.pushsdk.plugins.a.d
    public void a(List<String> list) {
        this.c = 1;
        this.d.a();
    }
}
