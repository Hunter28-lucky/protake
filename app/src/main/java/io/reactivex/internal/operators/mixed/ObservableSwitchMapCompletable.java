package io.reactivex.internal.operators.mixed;

import defpackage.AbstractC2900;
import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4053;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableSwitchMapCompletable<T> extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4262<T> f7271;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2837> f7272;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7273;

    public static final class SwitchMapCompletableObserver<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ֏, reason: contains not printable characters */
        public static final SwitchMapInnerObserver f7274 = new SwitchMapInnerObserver(null);

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5053 f7275;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends InterfaceC2837> f7276;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final boolean f7277;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final AtomicThrowable f7278 = new AtomicThrowable();

        /* renamed from: ԯ, reason: contains not printable characters */
        public final AtomicReference<SwitchMapInnerObserver> f7279 = new AtomicReference<>();

        /* renamed from: ՠ, reason: contains not printable characters */
        public volatile boolean f7280;

        /* renamed from: ֈ, reason: contains not printable characters */
        public InterfaceC4478 f7281;

        public static final class SwitchMapInnerObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5053 {
            private static final long serialVersionUID = -8003404460084760287L;
            public final SwitchMapCompletableObserver<?> parent;

            public SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.parent = switchMapCompletableObserver;
            }

            @Override // defpackage.InterfaceC5053
            public void onComplete() {
                this.parent.m6717(this);
            }

            @Override // defpackage.InterfaceC5053
            public void onError(Throwable th) {
                this.parent.m6718(this, th);
            }

            @Override // defpackage.InterfaceC5053
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m6719() {
                DisposableHelper.dispose(this);
            }
        }

        public SwitchMapCompletableObserver(InterfaceC5053 interfaceC5053, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z) {
            this.f7275 = interfaceC5053;
            this.f7276 = interfaceC2368;
            this.f7277 = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f7281.dispose();
            m6716();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f7279.get() == f7274;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f7280 = true;
            if (this.f7279.get() == null) {
                Throwable thM7019 = this.f7278.m7019();
                if (thM7019 == null) {
                    this.f7275.onComplete();
                } else {
                    this.f7275.onError(thM7019);
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!this.f7278.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.f7277) {
                onComplete();
                return;
            }
            m6716();
            Throwable thM7019 = this.f7278.m7019();
            if (thM7019 != ExceptionHelper.f7687) {
                this.f7275.onError(thM7019);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                InterfaceC2837 interfaceC2837 = (InterfaceC2837) C4246.m13353(this.f7276.apply(t), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.f7279.get();
                    if (switchMapInnerObserver == f7274) {
                        return;
                    }
                } while (!C4905.m14631(this.f7279, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.m6719();
                }
                interfaceC2837.mo10180(switchMapInnerObserver2);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f7281.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f7281, interfaceC4478)) {
                this.f7281 = interfaceC4478;
                this.f7275.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6716() {
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.f7279;
            SwitchMapInnerObserver switchMapInnerObserver = f7274;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet == null || andSet == switchMapInnerObserver) {
                return;
            }
            andSet.m6719();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6717(SwitchMapInnerObserver switchMapInnerObserver) {
            if (C4905.m14631(this.f7279, switchMapInnerObserver, null) && this.f7280) {
                Throwable thM7019 = this.f7278.m7019();
                if (thM7019 == null) {
                    this.f7275.onComplete();
                } else {
                    this.f7275.onError(thM7019);
                }
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6718(SwitchMapInnerObserver switchMapInnerObserver, Throwable th) {
            if (!C4905.m14631(this.f7279, switchMapInnerObserver, null) || !this.f7278.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.f7277) {
                if (this.f7280) {
                    this.f7275.onError(this.f7278.m7019());
                    return;
                }
                return;
            }
            dispose();
            Throwable thM7019 = this.f7278.m7019();
            if (thM7019 != ExceptionHelper.f7687) {
                this.f7275.onError(thM7019);
            }
        }
    }

    public ObservableSwitchMapCompletable(AbstractC4262<T> abstractC4262, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z) {
        this.f7271 = abstractC4262;
        this.f7272 = interfaceC2368;
        this.f7273 = z;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        if (C4053.m12972(this.f7271, this.f7272, interfaceC5053)) {
            return;
        }
        this.f7271.subscribe(new SwitchMapCompletableObserver(interfaceC5053, this.f7272, this.f7273));
    }
}
