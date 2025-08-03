package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.CallAdapter;

/* loaded from: classes2.dex */
class Platform {
    private static final Platform PLATFORM = findPlatform();

    public static class Android extends Platform {

        public static class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }

        @Override // retrofit2.Platform
        public CallAdapter.Factory defaultCallAdapterFactory(@Nullable Executor executor) {
            if (executor != null) {
                return new ExecutorCallAdapterFactory(executor);
            }
            throw new AssertionError();
        }

        @Override // retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }
    }

    @IgnoreJRERequirement
    public static class Java8 extends Platform {
        @Override // retrofit2.Platform
        public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }

        @Override // retrofit2.Platform
        public boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }
    }

    private static Platform findPlatform() throws ClassNotFoundException {
        try {
            try {
                Class.forName("android.os.Build");
                return new Android();
            } catch (ClassNotFoundException unused) {
                Class.forName("java.util.Optional");
                return new Java8();
            }
        } catch (ClassNotFoundException unused2) {
            return new Platform();
        }
    }

    public static Platform get() {
        return PLATFORM;
    }

    public CallAdapter.Factory defaultCallAdapterFactory(@Nullable Executor executor) {
        return executor != null ? new ExecutorCallAdapterFactory(executor) : DefaultCallAdapterFactory.INSTANCE;
    }

    @Nullable
    public Executor defaultCallbackExecutor() {
        return null;
    }

    @Nullable
    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    public boolean isDefaultMethod(Method method) {
        return false;
    }
}
