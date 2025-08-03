package defpackage;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TranscoderRegistry.java */
/* loaded from: classes.dex */
public class z2 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final List<C2308<?, ?>> f8771 = new ArrayList();

    /* compiled from: TranscoderRegistry.java */
    /* renamed from: z2$Ϳ, reason: contains not printable characters */
    public static final class C2308<Z, R> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Class<Z> f8772;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final Class<R> f8773;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final InterfaceC3462<Z, R> f8774;

        public C2308(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull InterfaceC3462<Z, R> interfaceC3462) {
            this.f8772 = cls;
            this.f8773 = cls2;
            this.f8774 = interfaceC3462;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m8643(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f8772.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f8773);
        }
    }

    @NonNull
    /* renamed from: Ϳ, reason: contains not printable characters */
    public synchronized <Z, R> InterfaceC3462<Z, R> m8640(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return m4.m7538();
        }
        for (C2308<?, ?> c2308 : this.f8771) {
            if (c2308.m8643(cls, cls2)) {
                return (InterfaceC3462<Z, R>) c2308.f8774;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized <Z, R> List<Class<R>> m8641(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator<C2308<?, ?>> it = this.f8771.iterator();
        while (it.hasNext()) {
            if (it.next().m8643(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public synchronized <Z, R> void m8642(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull InterfaceC3462<Z, R> interfaceC3462) {
        this.f8771.add(new C2308<>(cls, cls2, interfaceC3462));
    }
}
