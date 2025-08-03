package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4945;
import defpackage.C4089;
import defpackage.C4905;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4503;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservablePublishAlt<T> extends AbstractC4945<T> implements InterfaceC4503 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f7415;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AtomicReference<PublishConnection<T>> f7416 = new AtomicReference<>();

    public static final class InnerDisposable<T> extends AtomicReference<PublishConnection<T>> implements InterfaceC4478 {
        private static final long serialVersionUID = 7463222674719692880L;
        public final InterfaceC5102<? super T> downstream;

        public InnerDisposable(InterfaceC5102<? super T> interfaceC5102, PublishConnection<T> publishConnection) {
            this.downstream = interfaceC5102;
            lazySet(publishConnection);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            PublishConnection<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.m6839(this);
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == null;
        }
    }

    public static final class PublishConnection<T> extends AtomicReference<InnerDisposable<T>[]> implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -3251430252873581268L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final InnerDisposable[] f7417 = new InnerDisposable[0];

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final InnerDisposable[] f7418 = new InnerDisposable[0];
        public final AtomicReference<PublishConnection<T>> current;
        public Throwable error;
        public final AtomicBoolean connect = new AtomicBoolean();
        public final AtomicReference<InterfaceC4478> upstream = new AtomicReference<>();

        public PublishConnection(AtomicReference<PublishConnection<T>> atomicReference) {
            this.current = atomicReference;
            lazySet(f7417);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            getAndSet(f7418);
            C4905.m14631(this.current, this, null);
            DisposableHelper.dispose(this.upstream);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == f7418;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable<T> innerDisposable : getAndSet(f7418)) {
                innerDisposable.downstream.onComplete();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.error = th;
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable<T> innerDisposable : getAndSet(f7418)) {
                innerDisposable.downstream.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            for (InnerDisposable<T> innerDisposable : get()) {
                innerDisposable.downstream.onNext(t);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.upstream, interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6838(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = get();
                if (innerDisposableArr == f7418) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6839(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerDisposableArr[i2] == innerDisposable) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                innerDisposableArr2 = f7417;
                if (length != 1) {
                    innerDisposableArr2 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, i);
                    System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr2, i, (length - i) - 1);
                }
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
        }
    }

    public ObservablePublishAlt(InterfaceC2856<T> interfaceC2856) {
        this.f7415 = interfaceC2856;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.f7416.get();
            if (publishConnection != null) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.f7416);
            if (C4905.m14631(this.f7416, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        InnerDisposable<T> innerDisposable = new InnerDisposable<>(interfaceC5102, publishConnection);
        interfaceC5102.onSubscribe(innerDisposable);
        if (publishConnection.m6838(innerDisposable)) {
            if (innerDisposable.isDisposed()) {
                publishConnection.m6839(innerDisposable);
            }
        } else {
            Throwable th = publishConnection.error;
            if (th != null) {
                interfaceC5102.onError(th);
            } else {
                interfaceC5102.onComplete();
            }
        }
    }

    @Override // defpackage.InterfaceC4503
    /* renamed from: ԩ */
    public void mo6557(InterfaceC4478 interfaceC4478) {
        C4905.m14631(this.f7416, (PublishConnection) interfaceC4478, null);
    }

    @Override // defpackage.AbstractC4945
    /* renamed from: ԫ */
    public void mo6834(InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.f7416.get();
            if (publishConnection != null && !publishConnection.isDisposed()) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.f7416);
            if (C4905.m14631(this.f7416, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        boolean z = !publishConnection.connect.get() && publishConnection.connect.compareAndSet(false, true);
        try {
            interfaceC2857.accept(publishConnection);
            if (z) {
                this.f7415.subscribe(publishConnection);
            }
        } catch (Throwable th) {
            C4089.m13026(th);
            throw ExceptionHelper.m7024(th);
        }
    }
}
