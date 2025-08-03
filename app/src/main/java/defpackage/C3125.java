package defpackage;

import io.reactivex.internal.operators.flowable.FlowableElementAt;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

/* compiled from: FlowableElementAtSingle.java */
/* renamed from: Ӱ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3125<T> extends AbstractC4838<T> implements InterfaceC2583<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f11117;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f11118;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final T f11119;

    /* compiled from: FlowableElementAtSingle.java */
    /* renamed from: Ӱ$Ϳ, reason: contains not printable characters */
    public static final class C3126<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f11120;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f11121;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final T f11122;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public Subscription f11123;

        /* renamed from: ԯ, reason: contains not printable characters */
        public long f11124;

        /* renamed from: ՠ, reason: contains not printable characters */
        public boolean f11125;

        public C3126(InterfaceC4782<? super T> interfaceC4782, long j, T t) {
            this.f11120 = interfaceC4782;
            this.f11121 = j;
            this.f11122 = t;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f11123.cancel();
            this.f11123 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11123 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f11123 = SubscriptionHelper.CANCELLED;
            if (this.f11125) {
                return;
            }
            this.f11125 = true;
            T t = this.f11122;
            if (t != null) {
                this.f11120.onSuccess(t);
            } else {
                this.f11120.onError(new NoSuchElementException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f11125) {
                C3671.m11803(th);
                return;
            }
            this.f11125 = true;
            this.f11123 = SubscriptionHelper.CANCELLED;
            this.f11120.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f11125) {
                return;
            }
            long j = this.f11124;
            if (j != this.f11121) {
                this.f11124 = j + 1;
                return;
            }
            this.f11125 = true;
            this.f11123.cancel();
            this.f11123 = SubscriptionHelper.CANCELLED;
            this.f11120.onSuccess(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f11123, subscription)) {
                this.f11123 = subscription;
                this.f11120.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C3125(AbstractC3630<T> abstractC3630, long j, T t) {
        this.f11117 = abstractC3630;
        this.f11118 = j;
        this.f11119 = t;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f11117.subscribe((InterfaceC3899) new C3126(interfaceC4782, this.f11118, this.f11119));
    }

    @Override // defpackage.InterfaceC2583
    /* renamed from: ԩ */
    public AbstractC3630<T> mo6444() {
        return C3671.m11796(new FlowableElementAt(this.f11117, this.f11118, this.f11119, true));
    }
}
