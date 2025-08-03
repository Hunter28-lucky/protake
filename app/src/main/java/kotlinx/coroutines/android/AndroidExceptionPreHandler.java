package kotlinx.coroutines.android;

import android.os.Build;
import androidx.annotation.Keep;
import defpackage.AbstractC3174;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: AndroidExceptionPreHandler.kt */
@Keep
/* loaded from: classes2.dex */
public final class AndroidExceptionPreHandler extends AbstractC3174 implements CoroutineExceptionHandler {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.f7854);
        this._preHandler = this;
    }

    private final Method preHandler() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            boolean z = false;
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    z = true;
                }
            }
            if (z) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        if (Build.VERSION.SDK_INT >= 28) {
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
            return;
        }
        Method methodPreHandler = preHandler();
        Object objInvoke = methodPreHandler == null ? null : methodPreHandler.invoke(null, new Object[0]);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = objInvoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) objInvoke : null;
        if (uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(threadCurrentThread, th);
    }
}
