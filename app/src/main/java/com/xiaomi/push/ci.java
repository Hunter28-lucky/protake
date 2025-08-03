package com.xiaomi.push;

import android.content.Context;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ci {
    private int a;

    public ci(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public abstract String a(Context context, String str, List<au> list);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5304a(Context context, String str, List<au> list) {
        return true;
    }
}
