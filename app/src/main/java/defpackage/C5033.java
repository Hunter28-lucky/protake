package defpackage;

import androidx.annotation.NonNull;
import defpackage.InterfaceC2866;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry.java */
/* renamed from: ཎ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5033 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final InterfaceC2866.InterfaceC2867<?> f16809 = new C5034();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Map<Class<?>, InterfaceC2866.InterfaceC2867<?>> f16810 = new HashMap();

    /* compiled from: DataRewinderRegistry.java */
    /* renamed from: ཎ$Ϳ, reason: contains not printable characters */
    public class C5034 implements InterfaceC2866.InterfaceC2867<Object> {
        @Override // defpackage.InterfaceC2866.InterfaceC2867
        @NonNull
        /* renamed from: Ϳ */
        public Class<Object> mo9069() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // defpackage.InterfaceC2866.InterfaceC2867
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC2866<Object> mo9070(@NonNull Object obj) {
            return new C5035(obj);
        }
    }

    /* compiled from: DataRewinderRegistry.java */
    /* renamed from: ཎ$Ԩ, reason: contains not printable characters */
    public static final class C5035 implements InterfaceC2866<Object> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Object f16811;

        public C5035(@NonNull Object obj) {
            this.f16811 = obj;
        }

        @Override // defpackage.InterfaceC2866
        @NonNull
        /* renamed from: Ϳ */
        public Object mo9066() {
            return this.f16811;
        }

        @Override // defpackage.InterfaceC2866
        /* renamed from: Ԩ */
        public void mo9067() {
        }
    }

    @NonNull
    /* renamed from: Ϳ, reason: contains not printable characters */
    public synchronized <T> InterfaceC2866<T> m14837(@NonNull T t) {
        InterfaceC2866.InterfaceC2867<?> interfaceC2867;
        C4513.m13867(t);
        interfaceC2867 = this.f16810.get(t.getClass());
        if (interfaceC2867 == null) {
            Iterator<InterfaceC2866.InterfaceC2867<?>> it = this.f16810.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                InterfaceC2866.InterfaceC2867<?> next = it.next();
                if (next.mo9069().isAssignableFrom(t.getClass())) {
                    interfaceC2867 = next;
                    break;
                }
            }
        }
        if (interfaceC2867 == null) {
            interfaceC2867 = f16809;
        }
        return (InterfaceC2866<T>) interfaceC2867.mo9070(t);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized void m14838(@NonNull InterfaceC2866.InterfaceC2867<?> interfaceC2867) {
        this.f16810.put(interfaceC2867.mo9069(), interfaceC2867);
    }
}
