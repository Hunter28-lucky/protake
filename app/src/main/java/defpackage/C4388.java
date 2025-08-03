package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

/* compiled from: ObservableFromIterable.java */
/* renamed from: ଇ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4388<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Iterable<? extends T> f15094;

    /* compiled from: ObservableFromIterable.java */
    /* renamed from: ଇ$Ϳ, reason: contains not printable characters */
    public static final class C4389<T> extends AbstractC5180<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f15095;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Iterator<? extends T> f15096;

        /* renamed from: ԭ, reason: contains not printable characters */
        public volatile boolean f15097;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f15098;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f15099;

        /* renamed from: ՠ, reason: contains not printable characters */
        public boolean f15100;

        public C4389(InterfaceC5102<? super T> interfaceC5102, Iterator<? extends T> it) {
            this.f15095 = interfaceC5102;
            this.f15096 = it;
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.f15099 = true;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15097 = true;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15097;
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return this.f15099;
        }

        @Override // defpackage.InterfaceC4851
        public T poll() {
            if (this.f15099) {
                return null;
            }
            if (!this.f15100) {
                this.f15100 = true;
            } else if (!this.f15096.hasNext()) {
                this.f15099 = true;
                return null;
            }
            return (T) C4246.m13353(this.f15096.next(), "The iterator returned a null value");
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m13582() {
            while (!isDisposed()) {
                try {
                    this.f15095.onNext(C4246.m13353(this.f15096.next(), "The iterator returned a null value"));
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.f15096.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.f15095.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.f15095.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    this.f15095.onError(th2);
                    return;
                }
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f15098 = true;
            return 1;
        }
    }

    public C4388(Iterable<? extends T> iterable) {
        this.f15094 = iterable;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        try {
            Iterator<? extends T> it = this.f15094.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(interfaceC5102);
                    return;
                }
                C4389 c4389 = new C4389(interfaceC5102, it);
                interfaceC5102.onSubscribe(c4389);
                if (c4389.f15098) {
                    return;
                }
                c4389.m13582();
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
