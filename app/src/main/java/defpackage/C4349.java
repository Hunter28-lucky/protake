package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableToList.java */
/* renamed from: ણ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4349<T, U extends Collection<? super T>> extends AbstractC3414<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<U> f14898;

    /* compiled from: ObservableToList.java */
    /* renamed from: ણ$Ϳ, reason: contains not printable characters */
    public static final class C4350<T, U extends Collection<? super T>> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super U> f14899;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f14900;

        /* renamed from: ԭ, reason: contains not printable characters */
        public U f14901;

        public C4350(InterfaceC5102<? super U> interfaceC5102, U u) {
            this.f14899 = interfaceC5102;
            this.f14901 = u;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f14900.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f14900.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            U u = this.f14901;
            this.f14901 = null;
            this.f14899.onNext(u);
            this.f14899.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f14901 = null;
            this.f14899.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f14901.add(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f14900, interfaceC4478)) {
                this.f14900 = interfaceC4478;
                this.f14899.onSubscribe(this);
            }
        }
    }

    public C4349(InterfaceC2856<T> interfaceC2856, int i) {
        super(interfaceC2856);
        this.f14898 = Functions.m6318(i);
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super U> interfaceC5102) {
        try {
            this.f11778.subscribe(new C4350(interfaceC5102, (Collection) C4246.m13353(this.f14898.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC5102);
        }
    }

    public C4349(InterfaceC2856<T> interfaceC2856, Callable<U> callable) {
        super(interfaceC2856);
        this.f14898 = callable;
    }
}
