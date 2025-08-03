package defpackage;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;

/* compiled from: ObservableMapNotification.java */
/* renamed from: က, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5081<T, R> extends AbstractC3414<T, InterfaceC2856<? extends R>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> f16875;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Throwable, ? extends InterfaceC2856<? extends R>> f16876;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Callable<? extends InterfaceC2856<? extends R>> f16877;

    /* compiled from: ObservableMapNotification.java */
    /* renamed from: က$Ϳ, reason: contains not printable characters */
    public static final class C5082<T, R> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super InterfaceC2856<? extends R>> f16878;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> f16879;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super Throwable, ? extends InterfaceC2856<? extends R>> f16880;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final Callable<? extends InterfaceC2856<? extends R>> f16881;

        /* renamed from: ԯ, reason: contains not printable characters */
        public InterfaceC4478 f16882;

        public C5082(InterfaceC5102<? super InterfaceC2856<? extends R>> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, InterfaceC2368<? super Throwable, ? extends InterfaceC2856<? extends R>> interfaceC23682, Callable<? extends InterfaceC2856<? extends R>> callable) {
            this.f16878 = interfaceC5102;
            this.f16879 = interfaceC2368;
            this.f16880 = interfaceC23682;
            this.f16881 = callable;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16882.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16882.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            try {
                this.f16878.onNext((InterfaceC2856) C4246.m13353(this.f16881.call(), "The onComplete ObservableSource returned is null"));
                this.f16878.onComplete();
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f16878.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            try {
                this.f16878.onNext((InterfaceC2856) C4246.m13353(this.f16880.apply(th), "The onError ObservableSource returned is null"));
                this.f16878.onComplete();
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.f16878.onError(new CompositeException(th, th2));
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            try {
                this.f16878.onNext((InterfaceC2856) C4246.m13353(this.f16879.apply(t), "The onNext ObservableSource returned is null"));
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f16878.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f16882, interfaceC4478)) {
                this.f16882 = interfaceC4478;
                this.f16878.onSubscribe(this);
            }
        }
    }

    public C5081(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, InterfaceC2368<? super Throwable, ? extends InterfaceC2856<? extends R>> interfaceC23682, Callable<? extends InterfaceC2856<? extends R>> callable) {
        super(interfaceC2856);
        this.f16875 = interfaceC2368;
        this.f16876 = interfaceC23682;
        this.f16877 = callable;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super InterfaceC2856<? extends R>> interfaceC5102) {
        this.f11778.subscribe(new C5082(interfaceC5102, this.f16875, this.f16876, this.f16877));
    }
}
