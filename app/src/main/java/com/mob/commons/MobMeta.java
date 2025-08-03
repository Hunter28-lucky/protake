package com.mob.commons;

import android.os.Looper;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;

/* loaded from: classes2.dex */
public class MobMeta implements PublicMemberKeeper {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T get(MobProduct mobProduct, String str, Class<T> cls, T t) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            MobLog.getInstance().w("WARNING: gt mta in main: key = " + str);
            return t;
        }
        try {
            Object objA = n.a(str, cls, mobProduct);
            Object objA2 = objA;
            if (objA == 0) {
                try {
                    objA2 = n.a(str);
                } catch (Throwable th) {
                    th = th;
                    t = objA;
                    MobLog.getInstance().d(th);
                    return t;
                }
            }
            return objA2 == null ? t : objA2;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
