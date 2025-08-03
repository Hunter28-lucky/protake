package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.bx;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class bq implements Runnable {
    private String a;

    /* renamed from: a, reason: collision with other field name */
    private WeakReference<Context> f5632a;

    public bq(String str, WeakReference<Context> weakReference) {
        this.a = str;
        this.f5632a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f5632a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (cb.a(this.a) <= bp.f5630a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        bt btVarA = bt.a(this.a);
        bs bsVarA = bs.a(this.a);
        btVarA.a(bsVarA);
        bsVarA.a(br.a(context, this.a, 1000));
        bx.a(context).a((bx.a) btVarA);
    }
}
