package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableGenerate.java */
/* renamed from: ჹ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5319<T, S> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<S> f17600;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5247<S, InterfaceC3487<T>, S> f17601;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super S> f17602;

    /* compiled from: ObservableGenerate.java */
    /* renamed from: ჹ$Ϳ, reason: contains not printable characters */
    public static final class C5320<T, S> implements InterfaceC3487<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f17603;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5247<S, ? super InterfaceC3487<T>, S> f17604;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final InterfaceC2857<? super S> f17605;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public S f17606;

        /* renamed from: ԯ, reason: contains not printable characters */
        public volatile boolean f17607;

        /* renamed from: ՠ, reason: contains not printable characters */
        public boolean f17608;

        /* renamed from: ֈ, reason: contains not printable characters */
        public boolean f17609;

        public C5320(InterfaceC5102<? super T> interfaceC5102, InterfaceC5247<S, ? super InterfaceC3487<T>, S> interfaceC5247, InterfaceC2857<? super S> interfaceC2857, S s) {
            this.f17603 = interfaceC5102;
            this.f17604 = interfaceC5247;
            this.f17605 = interfaceC2857;
            this.f17606 = s;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f17607 = true;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f17607;
        }

        @Override // defpackage.InterfaceC3487
        public void onComplete() {
            if (this.f17608) {
                return;
            }
            this.f17608 = true;
            this.f17603.onComplete();
        }

        @Override // defpackage.InterfaceC3487
        public void onError(Throwable th) {
            if (this.f17608) {
                C3671.m11803(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f17608 = true;
            this.f17603.onError(th);
        }

        @Override // defpackage.InterfaceC3487
        public void onNext(T t) {
            if (this.f17608) {
                return;
            }
            if (this.f17609) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f17609 = true;
                this.f17603.onNext(t);
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final void m15371(S s) {
            try {
                this.f17605.accept(s);
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(th);
            }
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m15372() {
            S sApply = this.f17606;
            if (this.f17607) {
                this.f17606 = null;
                m15371(sApply);
                return;
            }
            InterfaceC5247<S, ? super InterfaceC3487<T>, S> interfaceC5247 = this.f17604;
            while (!this.f17607) {
                this.f17609 = false;
                try {
                    sApply = interfaceC5247.apply(sApply, this);
                    if (this.f17608) {
                        this.f17607 = true;
                        this.f17606 = null;
                        m15371(sApply);
                        return;
                    }
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.f17606 = null;
                    this.f17607 = true;
                    onError(th);
                    m15371(sApply);
                    return;
                }
            }
            this.f17606 = null;
            m15371(sApply);
        }
    }

    public C5319(Callable<S> callable, InterfaceC5247<S, InterfaceC3487<T>, S> interfaceC5247, InterfaceC2857<? super S> interfaceC2857) {
        this.f17600 = callable;
        this.f17601 = interfaceC5247;
        this.f17602 = interfaceC2857;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        try {
            C5320 c5320 = new C5320(interfaceC5102, this.f17601, this.f17602, this.f17600.call());
            interfaceC5102.onSubscribe(c5320);
            c5320.m15372();
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC5102);
        }
    }
}
