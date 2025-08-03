package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes2.dex */
public class cs implements fe {
    private Context a;

    public cs(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar) {
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar, int i, Exception exc) {
        co.a(this.a, fbVar.mo5479a(), i);
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar, Exception exc) {
    }

    @Override // com.xiaomi.push.fe
    public void b(fb fbVar) {
        co.m5306a(this.a);
    }
}
