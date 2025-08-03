package defpackage;

/* compiled from: InstanceFactory.java */
/* renamed from: ѣ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2935<T> implements InterfaceC3628<T>, InterfaceC5234<T> {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C2935<Object> f10645 = new C2935<>(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final T f10646;

    public C2935(T t) {
        this.f10646 = t;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T> InterfaceC3628<T> m10335(T t) {
        return new C2935(C4618.m14073(t, "instance cannot be null"));
    }

    @Override // defpackage.InterfaceC4461
    public T get() {
        return this.f10646;
    }
}
