package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4945;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4905;
import defpackage.InterfaceC2664;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservablePublish<T> extends AbstractC4945<T> implements InterfaceC2664<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f7405;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AtomicReference<C2078<T>> f7406;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2856<T> f7407;

    public static final class InnerDisposable<T> extends AtomicReference<Object> implements InterfaceC4478 {
        private static final long serialVersionUID = -1100270633763673112L;
        public final InterfaceC5102<? super T> child;

        public InnerDisposable(InterfaceC5102<? super T> interfaceC5102) {
            this.child = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((C2078) andSet).m6837(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == this;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6835(C2078<T> c2078) {
            if (compareAndSet(null, c2078)) {
                return;
            }
            c2078.m6837(this);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservablePublish$Ϳ, reason: contains not printable characters */
    public static final class C2078<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԯ, reason: contains not printable characters */
        public static final InnerDisposable[] f7408 = new InnerDisposable[0];

        /* renamed from: ՠ, reason: contains not printable characters */
        public static final InnerDisposable[] f7409 = new InnerDisposable[0];

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AtomicReference<C2078<T>> f7410;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final AtomicReference<InterfaceC4478> f7413 = new AtomicReference<>();

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AtomicReference<InnerDisposable<T>[]> f7411 = new AtomicReference<>(f7408);

        /* renamed from: ԭ, reason: contains not printable characters */
        public final AtomicBoolean f7412 = new AtomicBoolean();

        public C2078(AtomicReference<C2078<T>> atomicReference) {
            this.f7410 = atomicReference;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            AtomicReference<InnerDisposable<T>[]> atomicReference = this.f7411;
            InnerDisposable<T>[] innerDisposableArr = f7409;
            if (atomicReference.getAndSet(innerDisposableArr) != innerDisposableArr) {
                C4905.m14631(this.f7410, this, null);
                DisposableHelper.dispose(this.f7413);
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f7411.get() == f7409;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            C4905.m14631(this.f7410, this, null);
            for (InnerDisposable<T> innerDisposable : this.f7411.getAndSet(f7409)) {
                innerDisposable.child.onComplete();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            C4905.m14631(this.f7410, this, null);
            InnerDisposable<T>[] andSet = this.f7411.getAndSet(f7409);
            if (andSet.length == 0) {
                C3671.m11803(th);
                return;
            }
            for (InnerDisposable<T> innerDisposable : andSet) {
                innerDisposable.child.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            for (InnerDisposable<T> innerDisposable : this.f7411.get()) {
                innerDisposable.child.onNext(t);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.f7413, interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6836(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f7411.get();
                if (innerDisposableArr == f7409) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!C4905.m14631(this.f7411, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6837(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f7411.get();
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
                    if (innerDisposableArr[i2].equals(innerDisposable)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = f7408;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i);
                    System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr3, i, (length - i) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!C4905.m14631(this.f7411, innerDisposableArr, innerDisposableArr2));
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservablePublish$Ԩ, reason: contains not printable characters */
    public static final class C2079<T> implements InterfaceC2856<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AtomicReference<C2078<T>> f7414;

        public C2079(AtomicReference<C2078<T>> atomicReference) {
            this.f7414 = atomicReference;
        }

        @Override // defpackage.InterfaceC2856
        public void subscribe(InterfaceC5102<? super T> interfaceC5102) {
            InnerDisposable innerDisposable = new InnerDisposable(interfaceC5102);
            interfaceC5102.onSubscribe(innerDisposable);
            while (true) {
                C2078<T> c2078 = this.f7414.get();
                if (c2078 == null || c2078.isDisposed()) {
                    C2078<T> c20782 = new C2078<>(this.f7414);
                    if (C4905.m14631(this.f7414, c2078, c20782)) {
                        c2078 = c20782;
                    } else {
                        continue;
                    }
                }
                if (c2078.m6836(innerDisposable)) {
                    innerDisposable.m6835(c2078);
                    return;
                }
            }
        }
    }

    public ObservablePublish(InterfaceC2856<T> interfaceC2856, InterfaceC2856<T> interfaceC28562, AtomicReference<C2078<T>> atomicReference) {
        this.f7407 = interfaceC2856;
        this.f7405 = interfaceC28562;
        this.f7406 = atomicReference;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static <T> AbstractC4945<T> m6832(InterfaceC2856<T> interfaceC2856) {
        AtomicReference atomicReference = new AtomicReference();
        return C3671.m11795(new ObservablePublish(new C2079(atomicReference), interfaceC2856, atomicReference));
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f7407.subscribe(interfaceC5102);
    }

    @Override // defpackage.InterfaceC2664
    /* renamed from: Ϳ, reason: contains not printable characters */
    public InterfaceC2856<T> mo6833() {
        return this.f7405;
    }

    @Override // defpackage.AbstractC4945
    /* renamed from: ԫ, reason: contains not printable characters */
    public void mo6834(InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
        C2078<T> c2078;
        while (true) {
            c2078 = this.f7406.get();
            if (c2078 != null && !c2078.isDisposed()) {
                break;
            }
            C2078<T> c20782 = new C2078<>(this.f7406);
            if (C4905.m14631(this.f7406, c2078, c20782)) {
                c2078 = c20782;
                break;
            }
        }
        boolean z = !c2078.f7412.get() && c2078.f7412.compareAndSet(false, true);
        try {
            interfaceC2857.accept(c2078);
            if (z) {
                this.f7405.subscribe(c2078);
            }
        } catch (Throwable th) {
            C4089.m13026(th);
            throw ExceptionHelper.m7024(th);
        }
    }
}
