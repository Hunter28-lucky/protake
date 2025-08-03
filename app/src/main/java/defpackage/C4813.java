package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* compiled from: ObservableElementAtSingle.java */
/* renamed from: ට, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4813<T> extends AbstractC4838<T> implements InterfaceC2325<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f16296;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f16297;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final T f16298;

    /* compiled from: ObservableElementAtSingle.java */
    /* renamed from: ට$Ϳ, reason: contains not printable characters */
    public static final class C4814<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f16299;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f16300;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final T f16301;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public InterfaceC4478 f16302;

        /* renamed from: ԯ, reason: contains not printable characters */
        public long f16303;

        /* renamed from: ՠ, reason: contains not printable characters */
        public boolean f16304;

        public C4814(InterfaceC4782<? super T> interfaceC4782, long j, T t) {
            this.f16299 = interfaceC4782;
            this.f16300 = j;
            this.f16301 = t;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16302.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16302.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f16304) {
                return;
            }
            this.f16304 = true;
            T t = this.f16301;
            if (t != null) {
                this.f16299.onSuccess(t);
            } else {
                this.f16299.onError(new NoSuchElementException());
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f16304) {
                C3671.m11803(th);
            } else {
                this.f16304 = true;
                this.f16299.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f16304) {
                return;
            }
            long j = this.f16303;
            if (j != this.f16300) {
                this.f16303 = j + 1;
                return;
            }
            this.f16304 = true;
            this.f16302.dispose();
            this.f16299.onSuccess(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f16302, interfaceC4478)) {
                this.f16302 = interfaceC4478;
                this.f16299.onSubscribe(this);
            }
        }
    }

    public C4813(InterfaceC2856<T> interfaceC2856, long j, T t) {
        this.f16296 = interfaceC2856;
        this.f16297 = j;
        this.f16298 = t;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f16296.subscribe(new C4814(interfaceC4782, this.f16297, this.f16298));
    }

    @Override // defpackage.InterfaceC2325
    /* renamed from: Ϳ */
    public AbstractC4262<T> mo6779() {
        return C3671.m11798(new C4616(this.f16296, this.f16297, this.f16298, true));
    }
}
