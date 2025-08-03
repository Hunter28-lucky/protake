package defpackage;

import defpackage.C4741;
import io.reactivex.internal.util.NotificationLite;

/* compiled from: SerializedSubject.java */
/* renamed from: ɱ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2619<T> extends k0<T> implements C4741.InterfaceC4742<Object> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final k0<T> f9729;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f9730;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C4741<Object> f9731;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public volatile boolean f9732;

    public C2619(k0<T> k0Var) {
        this.f9729 = k0Var;
    }

    public void emitLoop() {
        C4741<Object> c4741;
        while (true) {
            synchronized (this) {
                c4741 = this.f9731;
                if (c4741 == null) {
                    this.f9730 = false;
                    return;
                }
                this.f9731 = null;
            }
            c4741.m14283(this);
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        if (this.f9732) {
            return;
        }
        synchronized (this) {
            if (this.f9732) {
                return;
            }
            this.f9732 = true;
            if (!this.f9730) {
                this.f9730 = true;
                this.f9729.onComplete();
                return;
            }
            C4741<Object> c4741 = this.f9731;
            if (c4741 == null) {
                c4741 = new C4741<>(4);
                this.f9731 = c4741;
            }
            c4741.m14282(NotificationLite.complete());
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        if (this.f9732) {
            C3671.m11803(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f9732) {
                this.f9732 = true;
                if (this.f9730) {
                    C4741<Object> c4741 = this.f9731;
                    if (c4741 == null) {
                        c4741 = new C4741<>(4);
                        this.f9731 = c4741;
                    }
                    c4741.m14284(NotificationLite.error(th));
                    return;
                }
                this.f9730 = true;
                z = false;
            }
            if (z) {
                C3671.m11803(th);
            } else {
                this.f9729.onError(th);
            }
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        if (this.f9732) {
            return;
        }
        synchronized (this) {
            if (this.f9732) {
                return;
            }
            if (!this.f9730) {
                this.f9730 = true;
                this.f9729.onNext(t);
                emitLoop();
            } else {
                C4741<Object> c4741 = this.f9731;
                if (c4741 == null) {
                    c4741 = new C4741<>(4);
                    this.f9731 = c4741;
                }
                c4741.m14282(NotificationLite.next(t));
            }
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        boolean z = true;
        if (!this.f9732) {
            synchronized (this) {
                if (!this.f9732) {
                    if (this.f9730) {
                        C4741<Object> c4741 = this.f9731;
                        if (c4741 == null) {
                            c4741 = new C4741<>(4);
                            this.f9731 = c4741;
                        }
                        c4741.m14282(NotificationLite.disposable(interfaceC4478));
                        return;
                    }
                    this.f9730 = true;
                    z = false;
                }
            }
        }
        if (z) {
            interfaceC4478.dispose();
        } else {
            this.f9729.onSubscribe(interfaceC4478);
            emitLoop();
        }
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f9729.subscribe(interfaceC5102);
    }

    @Override // defpackage.C4741.InterfaceC4742, defpackage.InterfaceC4178
    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.f9729);
    }
}
