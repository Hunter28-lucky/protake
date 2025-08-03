package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry.java */
/* renamed from: œ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2371 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final List<C2372<?>> f8921 = new ArrayList();

    /* compiled from: ResourceEncoderRegistry.java */
    /* renamed from: œ$Ϳ, reason: contains not printable characters */
    public static final class C2372<T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Class<T> f8922;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final InterfaceC4797<T> f8923;

        public C2372(@NonNull Class<T> cls, @NonNull InterfaceC4797<T> interfaceC4797) {
            this.f8922 = cls;
            this.f8923 = interfaceC4797;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m8839(@NonNull Class<?> cls) {
            return this.f8922.isAssignableFrom(cls);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public synchronized <Z> void m8837(@NonNull Class<Z> cls, @NonNull InterfaceC4797<Z> interfaceC4797) {
        this.f8921.add(new C2372<>(cls, interfaceC4797));
    }

    @Nullable
    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized <Z> InterfaceC4797<Z> m8838(@NonNull Class<Z> cls) {
        int size = this.f8921.size();
        for (int i = 0; i < size; i++) {
            C2372<?> c2372 = this.f8921.get(i);
            if (c2372.m8839(cls)) {
                return (InterfaceC4797<Z>) c2372.f8923;
            }
        }
        return null;
    }
}
