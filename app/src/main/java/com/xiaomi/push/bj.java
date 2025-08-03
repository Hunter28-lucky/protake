package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.af;

/* loaded from: classes2.dex */
public class bj extends af.a {
    private Context a;

    public bj(Context context) {
        this.a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.a).m5122a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.af.a
    /* renamed from: a, reason: collision with other method in class */
    public String mo5248a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.a).m5124b();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }
}
