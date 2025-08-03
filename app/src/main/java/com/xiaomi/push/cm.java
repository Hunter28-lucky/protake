package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes2.dex */
public class cm implements fg, fl {
    private Context a;

    public cm(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.fg
    public void a(fp fpVar) {
        cu.b(this.a);
    }

    @Override // com.xiaomi.push.fl
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo5305a(fp fpVar) {
        return true;
    }

    @Override // com.xiaomi.push.fg
    public void a(es esVar) {
        if (esVar != null && esVar.a() == 0 && "PING".equals(esVar.m5455a())) {
            cu.d(this.a);
        } else {
            cu.b(this.a);
        }
    }
}
