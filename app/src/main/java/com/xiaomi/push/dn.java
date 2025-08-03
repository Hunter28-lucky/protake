package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class dn extends dm {
    public dn(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.dm
    public gi a() {
        return gi.Storage;
    }

    @Override // com.xiaomi.push.af.a
    /* renamed from: a */
    public String mo5248a() {
        return "23";
    }

    @Override // com.xiaomi.push.dm
    public String b() {
        return "ram:" + i.m5678a() + Constants.ACCEPT_TIME_SEPARATOR_SP + "rom:" + i.m5683b() + "|ramOriginal:" + i.c() + Constants.ACCEPT_TIME_SEPARATOR_SP + "romOriginal:" + i.d();
    }
}
