package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableBufferBoundarySupplier.java */
/* renamed from: ਲ਼, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4275<T, U extends Collection<? super T>, B> extends AbstractC3414<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<? extends InterfaceC2856<B>> f14649;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Callable<U> f14650;

    /* compiled from: ObservableBufferBoundarySupplier.java */
    /* renamed from: ਲ਼$Ϳ, reason: contains not printable characters */
    public static final class C4276<T, U extends Collection<? super T>, B> extends AbstractC5105<B> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C4277<T, U, B> f14651;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f14652;

        public C4276(C4277<T, U, B> c4277) {
            this.f14651 = c4277;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f14652) {
                return;
            }
            this.f14652 = true;
            this.f14651.m13393();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f14652) {
                C3671.m11803(th);
            } else {
                this.f14652 = true;
                this.f14651.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(B b) {
            if (this.f14652) {
                return;
            }
            this.f14652 = true;
            dispose();
            this.f14651.m13393();
        }
    }

    /* compiled from: ObservableBufferBoundarySupplier.java */
    /* renamed from: ਲ਼$Ԩ, reason: contains not printable characters */
    public static final class C4277<T, U extends Collection<? super T>, B> extends AbstractC4701<T, U, U> implements InterfaceC4478 {

        /* renamed from: ֈ, reason: contains not printable characters */
        public final Callable<U> f14653;

        /* renamed from: ֏, reason: contains not printable characters */
        public final Callable<? extends InterfaceC2856<B>> f14654;

        /* renamed from: ׯ, reason: contains not printable characters */
        public InterfaceC4478 f14655;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final AtomicReference<InterfaceC4478> f14656;

        /* renamed from: ހ, reason: contains not printable characters */
        public U f14657;

        public C4277(InterfaceC5102<? super U> interfaceC5102, Callable<U> callable, Callable<? extends InterfaceC2856<B>> callable2) {
            super(interfaceC5102, new MpscLinkedQueue());
            this.f14656 = new AtomicReference<>();
            this.f14653 = callable;
            this.f14654 = callable2;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.f15960) {
                return;
            }
            this.f15960 = true;
            this.f14655.dispose();
            m13392();
            if (m14234()) {
                this.f15959.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15960;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            synchronized (this) {
                U u = this.f14657;
                if (u == null) {
                    return;
                }
                this.f14657 = null;
                this.f15959.offer(u);
                this.f15961 = true;
                if (m14234()) {
                    C5263.m15305(this.f15959, this.f15958, false, this, this);
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            dispose();
            this.f15958.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f14657;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f14655, interfaceC4478)) {
                this.f14655 = interfaceC4478;
                InterfaceC5102<? super V> interfaceC5102 = this.f15958;
                try {
                    this.f14657 = (U) C4246.m13353(this.f14653.call(), "The buffer supplied is null");
                    try {
                        InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.f14654.call(), "The boundary ObservableSource supplied is null");
                        C4276 c4276 = new C4276(this);
                        this.f14656.set(c4276);
                        interfaceC5102.onSubscribe(this);
                        if (this.f15960) {
                            return;
                        }
                        interfaceC2856.subscribe(c4276);
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.f15960 = true;
                        interfaceC4478.dispose();
                        EmptyDisposable.error(th, interfaceC5102);
                    }
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    this.f15960 = true;
                    interfaceC4478.dispose();
                    EmptyDisposable.error(th2, interfaceC5102);
                }
            }
        }

        @Override // defpackage.AbstractC4701, defpackage.InterfaceC3556
        /* renamed from: ՠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo10684(InterfaceC5102<? super U> interfaceC5102, U u) {
            this.f15958.onNext(u);
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public void m13392() {
            DisposableHelper.dispose(this.f14656);
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public void m13393() {
            try {
                U u = (U) C4246.m13353(this.f14653.call(), "The buffer supplied is null");
                try {
                    InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.f14654.call(), "The boundary ObservableSource supplied is null");
                    C4276 c4276 = new C4276(this);
                    if (DisposableHelper.replace(this.f14656, c4276)) {
                        synchronized (this) {
                            U u2 = this.f14657;
                            if (u2 == null) {
                                return;
                            }
                            this.f14657 = u;
                            interfaceC2856.subscribe(c4276);
                            m14236(u2, false, this);
                        }
                    }
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.f15960 = true;
                    this.f14655.dispose();
                    this.f15958.onError(th);
                }
            } catch (Throwable th2) {
                C4089.m13026(th2);
                dispose();
                this.f15958.onError(th2);
            }
        }
    }

    public C4275(InterfaceC2856<T> interfaceC2856, Callable<? extends InterfaceC2856<B>> callable, Callable<U> callable2) {
        super(interfaceC2856);
        this.f14649 = callable;
        this.f14650 = callable2;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super U> interfaceC5102) {
        this.f11778.subscribe(new C4277(new C5312(interfaceC5102), this.f14650, this.f14649));
    }
}
