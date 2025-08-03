package defpackage;

/* compiled from: DoubleCheck.java */
/* renamed from: ߍ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3821<T> implements InterfaceC4461<T>, InterfaceC5234<T> {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final Object f13094 = new Object();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public volatile InterfaceC4461<T> f13095;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public volatile Object f13096 = f13094;

    public C3821(InterfaceC4461<T> interfaceC4461) {
        this.f13095 = interfaceC4461;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <P extends InterfaceC4461<T>, T> InterfaceC5234<T> m12132(P p) {
        return p instanceof InterfaceC5234 ? (InterfaceC5234) p : new C3821((InterfaceC4461) C4618.m14072(p));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <P extends InterfaceC4461<T>, T> InterfaceC4461<T> m12133(P p) {
        C4618.m14072(p);
        return p instanceof C3821 ? p : new C3821(p);
    }

    @Override // defpackage.InterfaceC4461
    public T get() {
        T t = (T) this.f13096;
        Object obj = f13094;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.f13096;
                if (t == obj) {
                    t = this.f13095.get();
                    Object obj2 = this.f13096;
                    if (obj2 != obj && obj2 != t) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + t + ". This is likely due to a circular dependency.");
                    }
                    this.f13096 = t;
                    this.f13095 = null;
                }
            }
        }
        return t;
    }
}
