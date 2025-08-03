package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* compiled from: ObservableSingleSingle.java */
/* renamed from: ࠀ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3876<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<? extends T> f13337;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final T f13338;

    /* compiled from: ObservableSingleSingle.java */
    /* renamed from: ࠀ$Ϳ, reason: contains not printable characters */
    public static final class C3877<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f13339;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final T f13340;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f13341;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public T f13342;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f13343;

        public C3877(InterfaceC4782<? super T> interfaceC4782, T t) {
            this.f13339 = interfaceC4782;
            this.f13340 = t;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f13341.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f13341.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f13343) {
                return;
            }
            this.f13343 = true;
            T t = this.f13342;
            this.f13342 = null;
            if (t == null) {
                t = this.f13340;
            }
            if (t != null) {
                this.f13339.onSuccess(t);
            } else {
                this.f13339.onError(new NoSuchElementException());
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f13343) {
                C3671.m11803(th);
            } else {
                this.f13343 = true;
                this.f13339.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f13343) {
                return;
            }
            if (this.f13342 == null) {
                this.f13342 = t;
                return;
            }
            this.f13343 = true;
            this.f13341.dispose();
            this.f13339.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f13341, interfaceC4478)) {
                this.f13341 = interfaceC4478;
                this.f13339.onSubscribe(this);
            }
        }
    }

    public C3876(InterfaceC2856<? extends T> interfaceC2856, T t) {
        this.f13337 = interfaceC2856;
        this.f13338 = t;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f13337.subscribe(new C3877(interfaceC4782, this.f13338));
    }
}
