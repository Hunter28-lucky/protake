package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

/* compiled from: ObservableZipIterable.java */
/* renamed from: ڦ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3565<T, U, V> extends AbstractC4262<V> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4262<? extends T> f12389;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Iterable<U> f12390;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5247<? super T, ? super U, ? extends V> f12391;

    /* compiled from: ObservableZipIterable.java */
    /* renamed from: ڦ$Ϳ, reason: contains not printable characters */
    public static final class C3566<T, U, V> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super V> f12392;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Iterator<U> f12393;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final InterfaceC5247<? super T, ? super U, ? extends V> f12394;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public InterfaceC4478 f12395;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f12396;

        public C3566(InterfaceC5102<? super V> interfaceC5102, Iterator<U> it, InterfaceC5247<? super T, ? super U, ? extends V> interfaceC5247) {
            this.f12392 = interfaceC5102;
            this.f12393 = it;
            this.f12394 = interfaceC5247;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f12395.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f12395.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f12396) {
                return;
            }
            this.f12396 = true;
            this.f12392.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f12396) {
                C3671.m11803(th);
            } else {
                this.f12396 = true;
                this.f12392.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f12396) {
                return;
            }
            try {
                try {
                    this.f12392.onNext(C4246.m13353(this.f12394.apply(t, C4246.m13353(this.f12393.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f12393.hasNext()) {
                            return;
                        }
                        this.f12396 = true;
                        this.f12395.dispose();
                        this.f12392.onComplete();
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        m11519(th);
                    }
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    m11519(th2);
                }
            } catch (Throwable th3) {
                C4089.m13026(th3);
                m11519(th3);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f12395, interfaceC4478)) {
                this.f12395 = interfaceC4478;
                this.f12392.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m11519(Throwable th) {
            this.f12396 = true;
            this.f12395.dispose();
            this.f12392.onError(th);
        }
    }

    public C3565(AbstractC4262<? extends T> abstractC4262, Iterable<U> iterable, InterfaceC5247<? super T, ? super U, ? extends V> interfaceC5247) {
        this.f12389 = abstractC4262;
        this.f12390 = iterable;
        this.f12391 = interfaceC5247;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super V> interfaceC5102) {
        try {
            Iterator it = (Iterator) C4246.m13353(this.f12390.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.f12389.subscribe(new C3566(interfaceC5102, it, this.f12391));
                } else {
                    EmptyDisposable.complete(interfaceC5102);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                EmptyDisposable.error(th, interfaceC5102);
            }
        } catch (Throwable th2) {
            C4089.m13026(th2);
            EmptyDisposable.error(th2, interfaceC5102);
        }
    }
}
