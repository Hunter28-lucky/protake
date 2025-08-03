package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.dg;
import com.xiaomi.push.gg;
import com.xiaomi.push.gt;
import com.xiaomi.push.hf;

/* loaded from: classes2.dex */
public class i implements dg {
    private Context a;

    public i(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.dg
    public String a() {
        return b.m5140a(this.a).d();
    }

    @Override // com.xiaomi.push.dg
    public void a(hf hfVar, gg ggVar, gt gtVar) {
        u.a(this.a).a((u) hfVar, ggVar, gtVar);
    }
}
