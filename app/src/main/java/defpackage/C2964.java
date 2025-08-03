package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.C1814;
import java.util.Map;

/* compiled from: GlideContext.java */
/* renamed from: ҟ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2964 extends ContextWrapper {

    /* renamed from: ԯ, reason: contains not printable characters */
    @VisibleForTesting
    public static final n3<?, ?> f10720 = new C3116();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Handler f10721;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC4950 f10722;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Registry f10723;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C2643 f10724;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C3900 f10725;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Map<Class<?>, n3<?, ?>> f10726;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final C1814 f10727;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f10728;

    public C2964(@NonNull Context context, @NonNull InterfaceC4950 interfaceC4950, @NonNull Registry registry, @NonNull C2643 c2643, @NonNull C3900 c3900, @NonNull Map<Class<?>, n3<?, ?>> map, @NonNull C1814 c1814, int i) {
        super(context.getApplicationContext());
        this.f10722 = interfaceC4950;
        this.f10723 = registry;
        this.f10724 = c2643;
        this.f10725 = c3900;
        this.f10726 = map;
        this.f10727 = c1814;
        this.f10728 = i;
        this.f10721 = new Handler(Looper.getMainLooper());
    }

    @NonNull
    /* renamed from: Ϳ, reason: contains not printable characters */
    public <X> q7<ImageView, X> m10371(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f10724.m9748(imageView, cls);
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public InterfaceC4950 m10372() {
        return this.f10722;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public C3900 m10373() {
        return this.f10725;
    }

    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public <T> n3<?, T> m10374(@NonNull Class<T> cls) {
        n3<?, T> n3Var = (n3) this.f10726.get(cls);
        if (n3Var == null) {
            for (Map.Entry<Class<?>, n3<?, ?>> entry : this.f10726.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    n3Var = (n3) entry.getValue();
                }
            }
        }
        return n3Var == null ? (n3<?, T>) f10720 : n3Var;
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public C1814 m10375() {
        return this.f10727;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m10376() {
        return this.f10728;
    }

    @NonNull
    /* renamed from: ԭ, reason: contains not printable characters */
    public Registry m10377() {
        return this.f10723;
    }
}
