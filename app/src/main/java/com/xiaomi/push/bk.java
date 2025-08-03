package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.af;

/* loaded from: classes2.dex */
public class bk extends af.a {
    private Context a;

    public bk(Context context) {
        this.a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.a).m5122a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.af.a
    /* renamed from: a */
    public String mo5248a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.a).c();
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to send perf data. " + e2);
        }
    }
}
