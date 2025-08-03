package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class bg {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final ExecutorService f160 = Executors.newSingleThreadExecutor();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Handler f161 = new Handler(Looper.getMainLooper());

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m172(Runnable runnable) {
        f160.execute(runnable);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m173(Runnable runnable) {
        f161.post(runnable);
    }
}
