package com.mob.pushsdk.vivo.c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class e {
    private static final ExecutorService a = Executors.newSingleThreadExecutor();

    public static <T extends Runnable> void a(T t) {
        try {
            a.execute(t);
        } catch (Throwable th) {
            d.a().b(th);
        }
    }
}
