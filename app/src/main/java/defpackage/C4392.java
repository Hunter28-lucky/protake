package defpackage;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableDoOnEach.java */
/* renamed from: ଊ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4392<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super T> f15103;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super Throwable> f15104;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC3809 f15105;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC3809 f15106;

    /* compiled from: ObservableDoOnEach.java */
    /* renamed from: ଊ$Ϳ, reason: contains not printable characters */
    public static final class C4393<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f15107;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2857<? super T> f15108;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final InterfaceC2857<? super Throwable> f15109;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final InterfaceC3809 f15110;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final InterfaceC3809 f15111;

        /* renamed from: ՠ, reason: contains not printable characters */
        public InterfaceC4478 f15112;

        /* renamed from: ֈ, reason: contains not printable characters */
        public boolean f15113;

        public C4393(InterfaceC5102<? super T> interfaceC5102, InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, InterfaceC3809 interfaceC38092) {
            this.f15107 = interfaceC5102;
            this.f15108 = interfaceC2857;
            this.f15109 = interfaceC28572;
            this.f15110 = interfaceC3809;
            this.f15111 = interfaceC38092;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15112.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15112.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f15113) {
                return;
            }
            try {
                this.f15110.run();
                this.f15113 = true;
                this.f15107.onComplete();
                try {
                    this.f15111.run();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    C3671.m11803(th);
                }
            } catch (Throwable th2) {
                C4089.m13026(th2);
                onError(th2);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f15113) {
                C3671.m11803(th);
                return;
            }
            this.f15113 = true;
            try {
                this.f15109.accept(th);
            } catch (Throwable th2) {
                C4089.m13026(th2);
                th = new CompositeException(th, th2);
            }
            this.f15107.onError(th);
            try {
                this.f15111.run();
            } catch (Throwable th3) {
                C4089.m13026(th3);
                C3671.m11803(th3);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f15113) {
                return;
            }
            try {
                this.f15108.accept(t);
                this.f15107.onNext(t);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f15112.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15112, interfaceC4478)) {
                this.f15112 = interfaceC4478;
                this.f15107.onSubscribe(this);
            }
        }
    }

    public C4392(InterfaceC2856<T> interfaceC2856, InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, InterfaceC3809 interfaceC38092) {
        super(interfaceC2856);
        this.f15103 = interfaceC2857;
        this.f15104 = interfaceC28572;
        this.f15105 = interfaceC3809;
        this.f15106 = interfaceC38092;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C4393(interfaceC5102, this.f15103, this.f15104, this.f15105, this.f15106));
    }
}
