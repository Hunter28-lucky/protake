package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.InvocationTargetException;
import kotlin.Result;

/* compiled from: HandlerDispatcher.kt */
/* renamed from: א, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3266 {
    private static volatile Choreographer choreographer;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final AbstractC4213 f11450;

    static {
        Object objM7211;
        try {
            Result.C2137 c2137 = Result.f7828;
            objM7211 = Result.m7211(new C3277(m10935(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            Result.C2137 c21372 = Result.f7828;
            objM7211 = Result.m7211(C4817.m14541(th));
        }
        f11450 = (AbstractC4213) (Result.m7215(objM7211) ? null : objM7211);
    }

    @VisibleForTesting
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final Handler m10935(Looper looper, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!z) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (objInvoke != null) {
            return (Handler) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }
}
