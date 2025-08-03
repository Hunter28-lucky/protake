package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* compiled from: ObservableElementAt.java */
/* renamed from: ಚ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4616<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f15728;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final T f15729;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean f15730;

    /* compiled from: ObservableElementAt.java */
    /* renamed from: ಚ$Ϳ, reason: contains not printable characters */
    public static final class C4617<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f15731;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f15732;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final T f15733;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final boolean f15734;

        /* renamed from: ԯ, reason: contains not printable characters */
        public InterfaceC4478 f15735;

        /* renamed from: ՠ, reason: contains not printable characters */
        public long f15736;

        /* renamed from: ֈ, reason: contains not printable characters */
        public boolean f15737;

        public C4617(InterfaceC5102<? super T> interfaceC5102, long j, T t, boolean z) {
            this.f15731 = interfaceC5102;
            this.f15732 = j;
            this.f15733 = t;
            this.f15734 = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15735.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15735.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f15737) {
                return;
            }
            this.f15737 = true;
            T t = this.f15733;
            if (t == null && this.f15734) {
                this.f15731.onError(new NoSuchElementException());
                return;
            }
            if (t != null) {
                this.f15731.onNext(t);
            }
            this.f15731.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f15737) {
                C3671.m11803(th);
            } else {
                this.f15737 = true;
                this.f15731.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f15737) {
                return;
            }
            long j = this.f15736;
            if (j != this.f15732) {
                this.f15736 = j + 1;
                return;
            }
            this.f15737 = true;
            this.f15735.dispose();
            this.f15731.onNext(t);
            this.f15731.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15735, interfaceC4478)) {
                this.f15735 = interfaceC4478;
                this.f15731.onSubscribe(this);
            }
        }
    }

    public C4616(InterfaceC2856<T> interfaceC2856, long j, T t, boolean z) {
        super(interfaceC2856);
        this.f15728 = j;
        this.f15729 = t;
        this.f15730 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C4617(interfaceC5102, this.f15728, this.f15729, this.f15730));
    }
}
