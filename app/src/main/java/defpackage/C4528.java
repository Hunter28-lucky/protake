package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* compiled from: ObservableLastSingle.java */
/* renamed from: జ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4528<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f15504;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final T f15505;

    /* compiled from: ObservableLastSingle.java */
    /* renamed from: జ$Ϳ, reason: contains not printable characters */
    public static final class C4529<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f15506;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final T f15507;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f15508;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public T f15509;

        public C4529(InterfaceC4782<? super T> interfaceC4782, T t) {
            this.f15506 = interfaceC4782;
            this.f15507 = t;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15508.dispose();
            this.f15508 = DisposableHelper.DISPOSED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15508 == DisposableHelper.DISPOSED;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f15508 = DisposableHelper.DISPOSED;
            T t = this.f15509;
            if (t != null) {
                this.f15509 = null;
                this.f15506.onSuccess(t);
                return;
            }
            T t2 = this.f15507;
            if (t2 != null) {
                this.f15506.onSuccess(t2);
            } else {
                this.f15506.onError(new NoSuchElementException());
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f15508 = DisposableHelper.DISPOSED;
            this.f15509 = null;
            this.f15506.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f15509 = t;
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15508, interfaceC4478)) {
                this.f15508 = interfaceC4478;
                this.f15506.onSubscribe(this);
            }
        }
    }

    public C4528(InterfaceC2856<T> interfaceC2856, T t) {
        this.f15504 = interfaceC2856;
        this.f15505 = t;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f15504.subscribe(new C4529(interfaceC4782, this.f15505));
    }
}
