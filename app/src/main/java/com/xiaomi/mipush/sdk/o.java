package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.blink.academy.film.stream.FinderManager;
import com.xiaomi.push.af;
import com.xiaomi.push.gg;
import com.xiaomi.push.gm;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.gy;
import com.xiaomi.push.hf;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ai;

/* loaded from: classes2.dex */
public class o extends af.a {
    private Context a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f5534a = false;

    public o(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.af.a
    /* renamed from: a */
    public String mo5248a() {
        return "2";
    }

    @Override // java.lang.Runnable
    public void run() {
        ah ahVarA = ah.a(this.a);
        gy gyVar = new gy();
        if (this.f5534a) {
            gyVar.a(0);
            gyVar.b(0);
        } else {
            gyVar.a(ai.a(ahVarA, gm.MISC_CONFIG));
            gyVar.b(ai.a(ahVarA, gm.PLUGIN_CONFIG));
        }
        hf hfVar = new hf(FinderManager.MACHINE_NOT_VALID, false);
        hfVar.c(gq.DailyCheckClientConfig.f6003a);
        hfVar.a(hq.a(gyVar));
        com.xiaomi.channel.commonutils.logger.b.b("OcVersionCheckJob", "-->check version: checkMessage=", gyVar);
        u.a(this.a).a((u) hfVar, gg.Notification, (gt) null);
    }
}
