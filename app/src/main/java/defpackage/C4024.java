package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever.java */
/* renamed from: आ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4024 implements Handler.Callback {

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final InterfaceC4026 f13975 = new C4025();

    /* renamed from: ԫ, reason: contains not printable characters */
    public volatile C4226 f13976;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Handler f13979;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC4026 f13980;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @VisibleForTesting
    public final Map<FragmentManager, FragmentC4557> f13977 = new HashMap();

    /* renamed from: ԭ, reason: contains not printable characters */
    @VisibleForTesting
    public final Map<androidx.fragment.app.FragmentManager, q0> f13978 = new HashMap();

    /* renamed from: ՠ, reason: contains not printable characters */
    public final ArrayMap<View, Fragment> f13981 = new ArrayMap<>();

    /* renamed from: ֈ, reason: contains not printable characters */
    public final ArrayMap<View, android.app.Fragment> f13982 = new ArrayMap<>();

    /* renamed from: ֏, reason: contains not printable characters */
    public final Bundle f13983 = new Bundle();

    /* compiled from: RequestManagerRetriever.java */
    /* renamed from: आ$Ϳ, reason: contains not printable characters */
    public class C4025 implements InterfaceC4026 {
        @Override // defpackage.C4024.InterfaceC4026
        @NonNull
        /* renamed from: Ϳ, reason: contains not printable characters */
        public C4226 mo12910(@NonNull ComponentCallbacks2C3498 componentCallbacks2C3498, @NonNull InterfaceC4970 interfaceC4970, @NonNull InterfaceC4598 interfaceC4598, @NonNull Context context) {
            return new C4226(componentCallbacks2C3498, interfaceC4970, interfaceC4598, context);
        }
    }

    /* compiled from: RequestManagerRetriever.java */
    /* renamed from: आ$Ԩ, reason: contains not printable characters */
    public interface InterfaceC4026 {
        @NonNull
        /* renamed from: Ϳ */
        C4226 mo12910(@NonNull ComponentCallbacks2C3498 componentCallbacks2C3498, @NonNull InterfaceC4970 interfaceC4970, @NonNull InterfaceC4598 interfaceC4598, @NonNull Context context);
    }

    public C4024(@Nullable InterfaceC4026 interfaceC4026) {
        this.f13980 = interfaceC4026 == null ? f13975 : interfaceC4026;
        this.f13979 = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m12898(@NonNull Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static boolean m12899(Activity activity) {
        return !activity.isFinishing();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object objRemove;
        Object obj2;
        int i = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i == 1) {
            obj = (FragmentManager) message.obj;
            objRemove = this.f13977.remove(obj);
        } else {
            if (i != 2) {
                z = false;
                obj2 = null;
                if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            objRemove = this.f13978.remove(obj);
        }
        Object obj4 = obj;
        obj3 = objRemove;
        obj2 = obj4;
        if (z) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }

    @NonNull
    @Deprecated
    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C4226 m12900(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        FragmentC4557 fragmentC4557M12906 = m12906(fragmentManager, fragment, z);
        C4226 c4226M13977 = fragmentC4557M12906.m13977();
        if (c4226M13977 != null) {
            return c4226M13977;
        }
        C4226 c4226Mo12910 = this.f13980.mo12910(ComponentCallbacks2C3498.m11419(context), fragmentC4557M12906.m13975(), fragmentC4557M12906.m13978(), context);
        fragmentC4557M12906.m13982(c4226Mo12910);
        return c4226Mo12910;
    }

    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public C4226 m12901(@NonNull Activity activity) {
        if (j5.m7098()) {
            return m12902(activity.getApplicationContext());
        }
        m12898(activity);
        return m12900(activity, activity.getFragmentManager(), null, m12899(activity));
    }

    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public C4226 m12902(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (j5.m7099() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return m12903((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return m12901((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return m12902(((ContextWrapper) context).getBaseContext());
            }
        }
        return m12904(context);
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public C4226 m12903(@NonNull FragmentActivity fragmentActivity) {
        if (j5.m7098()) {
            return m12902(fragmentActivity.getApplicationContext());
        }
        m12898(fragmentActivity);
        return m12909(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, m12899(fragmentActivity));
    }

    @NonNull
    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C4226 m12904(@NonNull Context context) {
        if (this.f13976 == null) {
            synchronized (this) {
                if (this.f13976 == null) {
                    this.f13976 = this.f13980.mo12910(ComponentCallbacks2C3498.m11419(context.getApplicationContext()), new C4746(), new C5093(), context.getApplicationContext());
                }
            }
        }
        return this.f13976;
    }

    @NonNull
    @Deprecated
    /* renamed from: ԭ, reason: contains not printable characters */
    public FragmentC4557 m12905(Activity activity) {
        return m12906(activity.getFragmentManager(), null, m12899(activity));
    }

    @NonNull
    /* renamed from: Ԯ, reason: contains not printable characters */
    public final FragmentC4557 m12906(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        FragmentC4557 fragmentC4557 = (FragmentC4557) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (fragmentC4557 == null && (fragmentC4557 = this.f13977.get(fragmentManager)) == null) {
            fragmentC4557 = new FragmentC4557();
            fragmentC4557.m13981(fragment);
            if (z) {
                fragmentC4557.m13975().m12324();
            }
            this.f13977.put(fragmentManager, fragmentC4557);
            fragmentManager.beginTransaction().add(fragmentC4557, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f13979.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return fragmentC4557;
    }

    @NonNull
    /* renamed from: ԯ, reason: contains not printable characters */
    public q0 m12907(FragmentActivity fragmentActivity) {
        return m12908(fragmentActivity.getSupportFragmentManager(), null, m12899(fragmentActivity));
    }

    @NonNull
    /* renamed from: ՠ, reason: contains not printable characters */
    public final q0 m12908(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        q0 q0Var = (q0) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (q0Var == null && (q0Var = this.f13978.get(fragmentManager)) == null) {
            q0Var = new q0();
            q0Var.m7993(fragment);
            if (z) {
                q0Var.m7987().m12324();
            }
            this.f13978.put(fragmentManager, q0Var);
            fragmentManager.beginTransaction().add(q0Var, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f13979.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return q0Var;
    }

    @NonNull
    /* renamed from: ֏, reason: contains not printable characters */
    public final C4226 m12909(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        q0 q0VarM12908 = m12908(fragmentManager, fragment, z);
        C4226 c4226M7989 = q0VarM12908.m7989();
        if (c4226M7989 != null) {
            return c4226M7989;
        }
        C4226 c4226Mo12910 = this.f13980.mo12910(ComponentCallbacks2C3498.m11419(context), q0VarM12908.m7987(), q0VarM12908.m7990(), context);
        q0VarM12908.m7994(c4226Mo12910);
        return c4226Mo12910;
    }
}
