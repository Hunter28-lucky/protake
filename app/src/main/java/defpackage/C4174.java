package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;

/* compiled from: ObservableFlattenIterable.java */
/* renamed from: জ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4174<T, R> extends AbstractC3414<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Iterable<? extends R>> f14434;

    /* compiled from: ObservableFlattenIterable.java */
    /* renamed from: জ$Ϳ, reason: contains not printable characters */
    public static final class C4175<T, R> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super R> f14435;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends Iterable<? extends R>> f14436;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f14437;

        public C4175(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super T, ? extends Iterable<? extends R>> interfaceC2368) {
            this.f14435 = interfaceC5102;
            this.f14436 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f14437.dispose();
            this.f14437 = DisposableHelper.DISPOSED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f14437.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            InterfaceC4478 interfaceC4478 = this.f14437;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 == disposableHelper) {
                return;
            }
            this.f14437 = disposableHelper;
            this.f14435.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            InterfaceC4478 interfaceC4478 = this.f14437;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 == disposableHelper) {
                C3671.m11803(th);
            } else {
                this.f14437 = disposableHelper;
                this.f14435.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f14437 == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                Iterator<? extends R> it = this.f14436.apply(t).iterator();
                InterfaceC5102<? super R> interfaceC5102 = this.f14435;
                while (it.hasNext()) {
                    try {
                        try {
                            interfaceC5102.onNext((Object) C4246.m13353(it.next(), "The iterator returned a null value"));
                        } catch (Throwable th) {
                            C4089.m13026(th);
                            this.f14437.dispose();
                            onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        C4089.m13026(th2);
                        this.f14437.dispose();
                        onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                C4089.m13026(th3);
                this.f14437.dispose();
                onError(th3);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f14437, interfaceC4478)) {
                this.f14437 = interfaceC4478;
                this.f14435.onSubscribe(this);
            }
        }
    }

    public C4174(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, ? extends Iterable<? extends R>> interfaceC2368) {
        super(interfaceC2856);
        this.f14434 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        this.f11778.subscribe(new C4175(interfaceC5102, this.f14434));
    }
}
