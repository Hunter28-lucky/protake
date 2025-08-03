package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import defpackage.C3921;
import defpackage.C4184;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public class ViewModelProvider {
    private final Factory factory;
    private final ViewModelStore store;

    /* compiled from: ViewModelProvider.kt */
    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static final Companion Companion = new Companion(null);
        public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
        private static AndroidViewModelFactory sInstance;
        private final Application application;

        /* compiled from: ViewModelProvider.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(C4184 c4184) {
                this();
            }

            public final Factory defaultFactory$lifecycle_viewmodel_release(ViewModelStoreOwner viewModelStoreOwner) {
                C3921.m12666(viewModelStoreOwner, "owner");
                if (!(viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory)) {
                    return NewInstanceFactory.Companion.getInstance();
                }
                Factory defaultViewModelProviderFactory = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory();
                C3921.m12665(defaultViewModelProviderFactory, "owner.defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }

            public final AndroidViewModelFactory getInstance(Application application) {
                C3921.m12666(application, "application");
                if (AndroidViewModelFactory.sInstance == null) {
                    AndroidViewModelFactory.sInstance = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory androidViewModelFactory = AndroidViewModelFactory.sInstance;
                C3921.m12664(androidViewModelFactory);
                return androidViewModelFactory;
            }
        }

        public AndroidViewModelFactory(Application application) {
            C3921.m12666(application, "application");
            this.application = application;
        }

        public static final AndroidViewModelFactory getInstance(Application application) {
            return Companion.getInstance(application);
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            C3921.m12666(cls, "modelClass");
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return (T) super.create(cls);
            }
            try {
                T tNewInstance = cls.getConstructor(Application.class).newInstance(this.application);
                C3921.m12665(tNewInstance, "{\n                try {\n…          }\n            }");
                return tNewInstance;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(C3921.m12673("Cannot create an instance of ", cls), e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(C3921.m12673("Cannot create an instance of ", cls), e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException(C3921.m12673("Cannot create an instance of ", cls), e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException(C3921.m12673("Cannot create an instance of ", cls), e5);
            }
        }
    }

    /* compiled from: ViewModelProvider.kt */
    public interface Factory {
        <T extends ViewModel> T create(Class<T> cls);
    }

    /* compiled from: ViewModelProvider.kt */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static abstract class KeyedFactory extends OnRequeryFactory implements Factory {
        public <T extends ViewModel> T create(Class<T> cls) {
            C3921.m12666(cls, "modelClass");
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementations of KeyedFactory");
        }

        public abstract <T extends ViewModel> T create(String str, Class<T> cls);
    }

    /* compiled from: ViewModelProvider.kt */
    public static class NewInstanceFactory implements Factory {
        public static final Companion Companion = new Companion(null);
        private static NewInstanceFactory sInstance;

        /* compiled from: ViewModelProvider.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(C4184 c4184) {
                this();
            }

            public static /* synthetic */ void getInstance$annotations() {
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory.sInstance == null) {
                    NewInstanceFactory.sInstance = new NewInstanceFactory();
                }
                NewInstanceFactory newInstanceFactory = NewInstanceFactory.sInstance;
                C3921.m12664(newInstanceFactory);
                return newInstanceFactory;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls) throws IllegalAccessException, InstantiationException {
            C3921.m12666(cls, "modelClass");
            try {
                T tNewInstance = cls.newInstance();
                C3921.m12665(tNewInstance, "{\n                modelC…wInstance()\n            }");
                return tNewInstance;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(C3921.m12673("Cannot create an instance of ", cls), e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(C3921.m12673("Cannot create an instance of ", cls), e3);
            }
        }
    }

    /* compiled from: ViewModelProvider.kt */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class OnRequeryFactory {
        public void onRequery(ViewModel viewModel) {
            C3921.m12666(viewModel, "viewModel");
        }
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        C3921.m12666(viewModelStore, "store");
        C3921.m12666(factory, "factory");
        this.store = viewModelStore;
        this.factory = factory;
    }

    @MainThread
    public <T extends ViewModel> T get(Class<T> cls) {
        C3921.m12666(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) get(C3921.m12673("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner) {
        C3921.m12666(viewModelStoreOwner, "owner");
        ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
        C3921.m12665(viewModelStore, "owner.viewModelStore");
        this(viewModelStore, AndroidViewModelFactory.Companion.defaultFactory$lifecycle_viewmodel_release(viewModelStoreOwner));
    }

    @MainThread
    public <T extends ViewModel> T get(String str, Class<T> cls) {
        T t;
        C3921.m12666(str, "key");
        C3921.m12666(cls, "modelClass");
        T t2 = (T) this.store.get(str);
        if (cls.isInstance(t2)) {
            Object obj = this.factory;
            OnRequeryFactory onRequeryFactory = obj instanceof OnRequeryFactory ? (OnRequeryFactory) obj : null;
            if (onRequeryFactory != null) {
                C3921.m12665(t2, "viewModel");
                onRequeryFactory.onRequery(t2);
            }
            if (t2 != null) {
                return t2;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        }
        Factory factory = this.factory;
        if (factory instanceof KeyedFactory) {
            t = (T) ((KeyedFactory) factory).create(str, cls);
        } else {
            t = (T) factory.create(cls);
        }
        this.store.put(str, t);
        C3921.m12665(t, "viewModel");
        return t;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner, Factory factory) {
        C3921.m12666(viewModelStoreOwner, "owner");
        C3921.m12666(factory, "factory");
        ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
        C3921.m12665(viewModelStore, "owner.viewModelStore");
        this(viewModelStore, factory);
    }
}
