package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableToListSingle.java */
/* renamed from: Ɖ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2410<T, U extends Collection<? super T>> extends AbstractC4838<U> implements InterfaceC2325<U> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f8989;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<U> f8990;

    /* compiled from: ObservableToListSingle.java */
    /* renamed from: Ɖ$Ϳ, reason: contains not printable characters */
    public static final class C2411<T, U extends Collection<? super T>> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super U> f8991;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public U f8992;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f8993;

        public C2411(InterfaceC4782<? super U> interfaceC4782, U u) {
            this.f8991 = interfaceC4782;
            this.f8992 = u;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f8993.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f8993.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            U u = this.f8992;
            this.f8992 = null;
            this.f8991.onSuccess(u);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f8992 = null;
            this.f8991.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f8992.add(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f8993, interfaceC4478)) {
                this.f8993 = interfaceC4478;
                this.f8991.onSubscribe(this);
            }
        }
    }

    public C2410(InterfaceC2856<T> interfaceC2856, int i) {
        this.f8989 = interfaceC2856;
        this.f8990 = Functions.m6318(i);
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super U> interfaceC4782) {
        try {
            this.f8989.subscribe(new C2411(interfaceC4782, (Collection) C4246.m13353(this.f8990.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC4782);
        }
    }

    @Override // defpackage.InterfaceC2325
    /* renamed from: Ϳ */
    public AbstractC4262<U> mo6779() {
        return C3671.m11798(new C4349(this.f8989, this.f8990));
    }

    public C2410(InterfaceC2856<T> interfaceC2856, Callable<U> callable) {
        this.f8989 = interfaceC2856;
        this.f8990 = callable;
    }
}
