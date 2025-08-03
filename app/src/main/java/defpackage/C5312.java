package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;

/* compiled from: SerializedObserver.java */
/* renamed from: ჶ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5312<T> implements InterfaceC5102<T>, InterfaceC4478 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC5102<? super T> f17576;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean f17577;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC4478 f17578;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f17579;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C4741<Object> f17580;

    /* renamed from: ՠ, reason: contains not printable characters */
    public volatile boolean f17581;

    public C5312(InterfaceC5102<? super T> interfaceC5102) {
        this(interfaceC5102, false);
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        this.f17578.dispose();
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return this.f17578.isDisposed();
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        if (this.f17581) {
            return;
        }
        synchronized (this) {
            if (this.f17581) {
                return;
            }
            if (!this.f17579) {
                this.f17581 = true;
                this.f17579 = true;
                this.f17576.onComplete();
            } else {
                C4741<Object> c4741 = this.f17580;
                if (c4741 == null) {
                    c4741 = new C4741<>(4);
                    this.f17580 = c4741;
                }
                c4741.m14282(NotificationLite.complete());
            }
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        if (this.f17581) {
            C3671.m11803(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f17581) {
                if (this.f17579) {
                    this.f17581 = true;
                    C4741<Object> c4741 = this.f17580;
                    if (c4741 == null) {
                        c4741 = new C4741<>(4);
                        this.f17580 = c4741;
                    }
                    Object objError = NotificationLite.error(th);
                    if (this.f17577) {
                        c4741.m14282(objError);
                    } else {
                        c4741.m14284(objError);
                    }
                    return;
                }
                this.f17581 = true;
                this.f17579 = true;
                z = false;
            }
            if (z) {
                C3671.m11803(th);
            } else {
                this.f17576.onError(th);
            }
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        if (this.f17581) {
            return;
        }
        if (t == null) {
            this.f17578.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f17581) {
                return;
            }
            if (!this.f17579) {
                this.f17579 = true;
                this.f17576.onNext(t);
                m15365();
            } else {
                C4741<Object> c4741 = this.f17580;
                if (c4741 == null) {
                    c4741 = new C4741<>(4);
                    this.f17580 = c4741;
                }
                c4741.m14282(NotificationLite.next(t));
            }
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        if (DisposableHelper.validate(this.f17578, interfaceC4478)) {
            this.f17578 = interfaceC4478;
            this.f17576.onSubscribe(this);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m15365() {
        C4741<Object> c4741;
        do {
            synchronized (this) {
                c4741 = this.f17580;
                if (c4741 == null) {
                    this.f17579 = false;
                    return;
                }
                this.f17580 = null;
            }
        } while (!c4741.m14280(this.f17576));
    }

    public C5312(InterfaceC5102<? super T> interfaceC5102, boolean z) {
        this.f17576 = interfaceC5102;
        this.f17577 = z;
    }
}
