package defpackage;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;

/* compiled from: ObservableOnErrorNext.java */
/* renamed from: ఙ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4522<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Throwable, ? extends InterfaceC2856<? extends T>> f15479;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f15480;

    /* compiled from: ObservableOnErrorNext.java */
    /* renamed from: ఙ$Ϳ, reason: contains not printable characters */
    public static final class C4523<T> implements InterfaceC5102<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f15481;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super Throwable, ? extends InterfaceC2856<? extends T>> f15482;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final boolean f15483;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final SequentialDisposable f15484 = new SequentialDisposable();

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f15485;

        /* renamed from: ՠ, reason: contains not printable characters */
        public boolean f15486;

        public C4523(InterfaceC5102<? super T> interfaceC5102, InterfaceC2368<? super Throwable, ? extends InterfaceC2856<? extends T>> interfaceC2368, boolean z) {
            this.f15481 = interfaceC5102;
            this.f15482 = interfaceC2368;
            this.f15483 = z;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f15486) {
                return;
            }
            this.f15486 = true;
            this.f15485 = true;
            this.f15481.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f15485) {
                if (this.f15486) {
                    C3671.m11803(th);
                    return;
                } else {
                    this.f15481.onError(th);
                    return;
                }
            }
            this.f15485 = true;
            if (this.f15483 && !(th instanceof Exception)) {
                this.f15481.onError(th);
                return;
            }
            try {
                InterfaceC2856<? extends T> interfaceC2856Apply = this.f15482.apply(th);
                if (interfaceC2856Apply != null) {
                    interfaceC2856Apply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th);
                this.f15481.onError(nullPointerException);
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.f15481.onError(new CompositeException(th, th2));
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f15486) {
                return;
            }
            this.f15481.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f15484.m6311(interfaceC4478);
        }
    }

    public C4522(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super Throwable, ? extends InterfaceC2856<? extends T>> interfaceC2368, boolean z) {
        super(interfaceC2856);
        this.f15479 = interfaceC2368;
        this.f15480 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        C4523 c4523 = new C4523(interfaceC5102, this.f15479, this.f15480);
        interfaceC5102.onSubscribe(c4523.f15484);
        this.f11778.subscribe(c4523);
    }
}
