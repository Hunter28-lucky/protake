package defpackage;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import defpackage.C2380;

/* compiled from: LockedResource.java */
/* renamed from: ߝ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3854<Z> implements InterfaceC4536<Z>, C2380.InterfaceC2386 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final Pools.Pool<C3854<?>> f13256 = C2380.m8868(20, new C3855());

    /* renamed from: ԫ, reason: contains not printable characters */
    public final i f13257 = i.m6228();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC4536<Z> f13258;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f13259;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f13260;

    /* compiled from: LockedResource.java */
    /* renamed from: ߝ$Ϳ, reason: contains not printable characters */
    public class C3855 implements C2380.InterfaceC2384<C3854<?>> {
        @Override // defpackage.C2380.InterfaceC2384
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public C3854<?> mo4957() {
            return new C3854<>();
        }
    }

    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static <Z> C3854<Z> m12287(InterfaceC4536<Z> interfaceC4536) {
        C3854<Z> c3854 = (C3854) C4513.m13867(f13256.acquire());
        c3854.m12288(interfaceC4536);
        return c3854;
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    public Z get() {
        return this.f13258.get();
    }

    @Override // defpackage.InterfaceC4536
    public synchronized void recycle() {
        this.f13257.mo6230();
        this.f13260 = true;
        if (!this.f13259) {
            this.f13258.recycle();
            m12289();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m12288(InterfaceC4536<Z> interfaceC4536) {
        this.f13260 = false;
        this.f13259 = true;
        this.f13258 = interfaceC4536;
    }

    @Override // defpackage.InterfaceC4536
    /* renamed from: Ԩ */
    public int mo4977() {
        return this.f13258.mo4977();
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    /* renamed from: ԩ */
    public Class<Z> mo4978() {
        return this.f13258.mo4978();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m12289() {
        this.f13258 = null;
        f13256.release(this);
    }

    @Override // defpackage.C2380.InterfaceC2386
    @NonNull
    /* renamed from: Ԭ */
    public i mo4858() {
        return this.f13257;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public synchronized void m12290() {
        this.f13257.mo6230();
        if (!this.f13259) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f13259 = false;
        if (this.f13260) {
            recycle();
        }
    }
}
