package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.hf;
import com.xiaomi.push.service.aj;

/* loaded from: classes2.dex */
public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        hf hfVar = new hf();
        hfVar.c(gq.VRUpload.f6003a);
        hfVar.b(b.m5140a(context).m5141a());
        hfVar.d(context.getPackageName());
        hfVar.a("data", str);
        hfVar.a(aj.a());
        u.a(context).a((u) hfVar, gg.Notification, (gt) null);
    }
}
