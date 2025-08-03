package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes2.dex */
public class cn implements fg, fl {
    private Context a;

    public cn(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.fg
    public void a(fp fpVar) {
        cu.a(this.a);
    }

    @Override // com.xiaomi.push.fl
    /* renamed from: a */
    public boolean mo5305a(fp fpVar) {
        return true;
    }

    @Override // com.xiaomi.push.fg
    public void a(es esVar) {
        if (esVar != null && esVar.a() == 0 && "PING".equals(esVar.m5455a())) {
            cu.c(this.a);
        } else {
            cu.a(this.a);
        }
    }
}
