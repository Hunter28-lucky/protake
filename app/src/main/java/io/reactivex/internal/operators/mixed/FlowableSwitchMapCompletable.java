package io.reactivex.internal.operators.mixed;

import defpackage.AbstractC2900;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSwitchMapCompletable<T> extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f7240;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2837> f7241;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7242;

    public static final class SwitchMapCompletableObserver<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ֏, reason: contains not printable characters */
        public static final SwitchMapInnerObserver f7243 = new SwitchMapInnerObserver(null);

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5053 f7244;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends InterfaceC2837> f7245;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final boolean f7246;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final AtomicThrowable f7247 = new AtomicThrowable();

        /* renamed from: ԯ, reason: contains not printable characters */
        public final AtomicReference<SwitchMapInnerObserver> f7248 = new AtomicReference<>();

        /* renamed from: ՠ, reason: contains not printable characters */
        public volatile boolean f7249;

        /* renamed from: ֈ, reason: contains not printable characters */
        public Subscription f7250;

        public static final class SwitchMapInnerObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5053 {
            private static final long serialVersionUID = -8003404460084760287L;
            public final SwitchMapCompletableObserver<?> parent;

            public SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.parent = switchMapCompletableObserver;
            }

            @Override // defpackage.InterfaceC5053
            public void onComplete() {
                this.parent.m6691(this);
            }

            @Override // defpackage.InterfaceC5053
            public void onError(Throwable th) {
                this.parent.m6692(this, th);
            }

            @Override // defpackage.InterfaceC5053
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m6693() {
                DisposableHelper.dispose(this);
            }
        }

        public SwitchMapCompletableObserver(InterfaceC5053 interfaceC5053, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z) {
            this.f7244 = interfaceC5053;
            this.f7245 = interfaceC2368;
            this.f7246 = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f7250.cancel();
            m6690();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f7248.get() == f7243;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f7249 = true;
            if (this.f7248.get() == null) {
                Throwable thM7019 = this.f7247.m7019();
                if (thM7019 == null) {
                    this.f7244.onComplete();
                } else {
                    this.f7244.onError(thM7019);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f7247.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.f7246) {
                onComplete();
                return;
            }
            m6690();
            Throwable thM7019 = this.f7247.m7019();
            if (thM7019 != ExceptionHelper.f7687) {
                this.f7244.onError(thM7019);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                InterfaceC2837 interfaceC2837 = (InterfaceC2837) C4246.m13353(this.f7245.apply(t), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.f7248.get();
                    if (switchMapInnerObserver == f7243) {
                        return;
                    }
                } while (!C4905.m14631(this.f7248, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.m6693();
                }
                interfaceC2837.mo10180(switchMapInnerObserver2);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f7250.cancel();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f7250, subscription)) {
                this.f7250 = subscription;
                this.f7244.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6690() {
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.f7248;
            SwitchMapInnerObserver switchMapInnerObserver = f7243;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet == null || andSet == switchMapInnerObserver) {
                return;
            }
            andSet.m6693();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6691(SwitchMapInnerObserver switchMapInnerObserver) {
            if (C4905.m14631(this.f7248, switchMapInnerObserver, null) && this.f7249) {
                Throwable thM7019 = this.f7247.m7019();
                if (thM7019 == null) {
                    this.f7244.onComplete();
                } else {
                    this.f7244.onError(thM7019);
                }
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6692(SwitchMapInnerObserver switchMapInnerObserver, Throwable th) {
            if (!C4905.m14631(this.f7248, switchMapInnerObserver, null) || !this.f7247.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.f7246) {
                if (this.f7249) {
                    this.f7244.onError(this.f7247.m7019());
                    return;
                }
                return;
            }
            dispose();
            Throwable thM7019 = this.f7247.m7019();
            if (thM7019 != ExceptionHelper.f7687) {
                this.f7244.onError(thM7019);
            }
        }
    }

    public FlowableSwitchMapCompletable(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z) {
        this.f7240 = abstractC3630;
        this.f7241 = interfaceC2368;
        this.f7242 = z;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        this.f7240.subscribe((InterfaceC3899) new SwitchMapCompletableObserver(interfaceC5053, this.f7241, this.f7242));
    }
}
