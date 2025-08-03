package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry.java */
/* renamed from: ƈ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2408 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final List<C2409<?>> f8986 = new ArrayList();

    /* compiled from: EncoderRegistry.java */
    /* renamed from: ƈ$Ϳ, reason: contains not printable characters */
    public static final class C2409<T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Class<T> f8987;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final InterfaceC3823<T> f8988;

        public C2409(@NonNull Class<T> cls, @NonNull InterfaceC3823<T> interfaceC3823) {
            this.f8987 = cls;
            this.f8988 = interfaceC3823;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m8902(@NonNull Class<?> cls) {
            return this.f8987.isAssignableFrom(cls);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public synchronized <T> void m8900(@NonNull Class<T> cls, @NonNull InterfaceC3823<T> interfaceC3823) {
        this.f8986.add(new C2409<>(cls, interfaceC3823));
    }

    @Nullable
    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized <T> InterfaceC3823<T> m8901(@NonNull Class<T> cls) {
        for (C2409<?> c2409 : this.f8986) {
            if (c2409.m8902(cls)) {
                return (InterfaceC3823<T>) c2409.f8988;
            }
        }
        return null;
    }
}
