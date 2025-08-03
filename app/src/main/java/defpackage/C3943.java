package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableDebounce.java */
/* renamed from: ࡓ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3943<T, U> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2856<U>> f13585;

    /* compiled from: ObservableDebounce.java */
    /* renamed from: ࡓ$Ϳ, reason: contains not printable characters */
    public static final class C3944<T, U> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f13586;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends InterfaceC2856<U>> f13587;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f13588;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final AtomicReference<InterfaceC4478> f13589 = new AtomicReference<>();

        /* renamed from: ԯ, reason: contains not printable characters */
        public volatile long f13590;

        /* renamed from: ՠ, reason: contains not printable characters */
        public boolean f13591;

        /* compiled from: ObservableDebounce.java */
        /* renamed from: ࡓ$Ϳ$Ϳ, reason: contains not printable characters */
        public static final class C3945<T, U> extends AbstractC5105<U> {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final C3944<T, U> f13592;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final long f13593;

            /* renamed from: ԭ, reason: contains not printable characters */
            public final T f13594;

            /* renamed from: Ԯ, reason: contains not printable characters */
            public boolean f13595;

            /* renamed from: ԯ, reason: contains not printable characters */
            public final AtomicBoolean f13596 = new AtomicBoolean();

            public C3945(C3944<T, U> c3944, long j, T t) {
                this.f13592 = c3944;
                this.f13593 = j;
                this.f13594 = t;
            }

            @Override // defpackage.InterfaceC5102
            public void onComplete() {
                if (this.f13595) {
                    return;
                }
                this.f13595 = true;
                m12718();
            }

            @Override // defpackage.InterfaceC5102
            public void onError(Throwable th) {
                if (this.f13595) {
                    C3671.m11803(th);
                } else {
                    this.f13595 = true;
                    this.f13592.onError(th);
                }
            }

            @Override // defpackage.InterfaceC5102
            public void onNext(U u) {
                if (this.f13595) {
                    return;
                }
                this.f13595 = true;
                dispose();
                m12718();
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m12718() {
                if (this.f13596.compareAndSet(false, true)) {
                    this.f13592.m12717(this.f13593, this.f13594);
                }
            }
        }

        public C3944(InterfaceC5102<? super T> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC2856<U>> interfaceC2368) {
            this.f13586 = interfaceC5102;
            this.f13587 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f13588.dispose();
            DisposableHelper.dispose(this.f13589);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f13588.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f13591) {
                return;
            }
            this.f13591 = true;
            InterfaceC4478 interfaceC4478 = this.f13589.get();
            if (interfaceC4478 != DisposableHelper.DISPOSED) {
                C3945 c3945 = (C3945) interfaceC4478;
                if (c3945 != null) {
                    c3945.m12718();
                }
                DisposableHelper.dispose(this.f13589);
                this.f13586.onComplete();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.f13589);
            this.f13586.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f13591) {
                return;
            }
            long j = this.f13590 + 1;
            this.f13590 = j;
            InterfaceC4478 interfaceC4478 = this.f13589.get();
            if (interfaceC4478 != null) {
                interfaceC4478.dispose();
            }
            try {
                InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.f13587.apply(t), "The ObservableSource supplied is null");
                C3945 c3945 = new C3945(this, j, t);
                if (C4905.m14631(this.f13589, interfaceC4478, c3945)) {
                    interfaceC2856.subscribe(c3945);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                dispose();
                this.f13586.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f13588, interfaceC4478)) {
                this.f13588 = interfaceC4478;
                this.f13586.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m12717(long j, T t) {
            if (j == this.f13590) {
                this.f13586.onNext(t);
            }
        }
    }

    public C3943(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2856<U>> interfaceC2368) {
        super(interfaceC2856);
        this.f13585 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C3944(new C5312(interfaceC5102), this.f13585));
    }
}
