package defpackage;

/* compiled from: QueueDrainObserver.java */
/* renamed from: ഘ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC4701<T, U, V> extends C2830 implements InterfaceC5102<T>, InterfaceC3556<U, V> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5102<? super V> f15958;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2475<U> f15959;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public volatile boolean f15960;

    /* renamed from: ԯ, reason: contains not printable characters */
    public volatile boolean f15961;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Throwable f15962;

    public AbstractC4701(InterfaceC5102<? super V> interfaceC5102, InterfaceC2475<U> interfaceC2475) {
        this.f15958 = interfaceC5102;
        this.f15959 = interfaceC2475;
    }

    @Override // defpackage.InterfaceC3556
    /* renamed from: Ϳ */
    public final boolean mo11499() {
        return this.f15961;
    }

    @Override // defpackage.InterfaceC3556
    /* renamed from: Ԩ */
    public final boolean mo11500() {
        return this.f15960;
    }

    @Override // defpackage.InterfaceC3556
    /* renamed from: ԩ */
    public final Throwable mo11501() {
        return this.f15962;
    }

    @Override // defpackage.InterfaceC3556
    /* renamed from: Ԫ */
    public final int mo11502(int i) {
        return this.f15545.addAndGet(i);
    }

    /* renamed from: ԫ */
    public void mo10684(InterfaceC5102<? super V> interfaceC5102, U u) {
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean m14234() {
        return this.f15545.getAndIncrement() == 0;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean m14235() {
        return this.f15545.get() == 0 && this.f15545.compareAndSet(0, 1);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m14236(U u, boolean z, InterfaceC4478 interfaceC4478) {
        InterfaceC5102<? super V> interfaceC5102 = this.f15958;
        InterfaceC2475<U> interfaceC2475 = this.f15959;
        if (this.f15545.get() == 0 && this.f15545.compareAndSet(0, 1)) {
            mo10684(interfaceC5102, u);
            if (mo11502(-1) == 0) {
                return;
            }
        } else {
            interfaceC2475.offer(u);
            if (!m14234()) {
                return;
            }
        }
        C5263.m15305(interfaceC2475, interfaceC5102, z, interfaceC4478, this);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m14237(U u, boolean z, InterfaceC4478 interfaceC4478) {
        InterfaceC5102<? super V> interfaceC5102 = this.f15958;
        InterfaceC2475<U> interfaceC2475 = this.f15959;
        if (this.f15545.get() != 0 || !this.f15545.compareAndSet(0, 1)) {
            interfaceC2475.offer(u);
            if (!m14234()) {
                return;
            }
        } else if (interfaceC2475.isEmpty()) {
            mo10684(interfaceC5102, u);
            if (mo11502(-1) == 0) {
                return;
            }
        } else {
            interfaceC2475.offer(u);
        }
        C5263.m15305(interfaceC2475, interfaceC5102, z, interfaceC4478, this);
    }
}
