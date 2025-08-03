package com.mob.tools.utils;

import android.text.TextUtils;
import com.mob.tools.MobLog;

/* loaded from: classes2.dex */
public abstract class f extends Thread {
    public f(String str) {
        if (TextUtils.isEmpty("M-")) {
            return;
        }
        setName("M-" + str);
    }

    public abstract void a();

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }
}
