package defpackage;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: SafeObserver.java */
/* renamed from: უ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5289<T> implements InterfaceC5102<T>, InterfaceC4478 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC5102<? super T> f17479;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC4478 f17480;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f17481;

    public C5289(InterfaceC5102<? super T> interfaceC5102) {
        this.f17479 = interfaceC5102;
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        this.f17480.dispose();
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return this.f17480.isDisposed();
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        if (this.f17481) {
            return;
        }
        this.f17481 = true;
        if (this.f17480 == null) {
            m15330();
            return;
        }
        try {
            this.f17479.onComplete();
        } catch (Throwable th) {
            C4089.m13026(th);
            C3671.m11803(th);
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        if (this.f17481) {
            C3671.m11803(th);
            return;
        }
        this.f17481 = true;
        if (this.f17480 != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f17479.onError(th);
                return;
            } catch (Throwable th2) {
                C4089.m13026(th2);
                C3671.m11803(new CompositeException(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f17479.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f17479.onError(new CompositeException(th, nullPointerException));
            } catch (Throwable th3) {
                C4089.m13026(th3);
                C3671.m11803(new CompositeException(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            C4089.m13026(th4);
            C3671.m11803(new CompositeException(th, nullPointerException, th4));
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        if (this.f17481) {
            return;
        }
        if (this.f17480 == null) {
            m15331();
            return;
        }
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f17480.dispose();
                onError(nullPointerException);
                return;
            } catch (Throwable th) {
                C4089.m13026(th);
                onError(new CompositeException(nullPointerException, th));
                return;
            }
        }
        try {
            this.f17479.onNext(t);
        } catch (Throwable th2) {
            C4089.m13026(th2);
            try {
                this.f17480.dispose();
                onError(th2);
            } catch (Throwable th3) {
                C4089.m13026(th3);
                onError(new CompositeException(th2, th3));
            }
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        if (DisposableHelper.validate(this.f17480, interfaceC4478)) {
            this.f17480 = interfaceC4478;
            try {
                this.f17479.onSubscribe(this);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f17481 = true;
                try {
                    interfaceC4478.dispose();
                    C3671.m11803(th);
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    C3671.m11803(new CompositeException(th, th2));
                }
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m15330() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f17479.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f17479.onError(nullPointerException);
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            C4089.m13026(th2);
            C3671.m11803(new CompositeException(nullPointerException, th2));
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m15331() {
        this.f17481 = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f17479.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f17479.onError(nullPointerException);
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            C4089.m13026(th2);
            C3671.m11803(new CompositeException(nullPointerException, th2));
        }
    }
}
