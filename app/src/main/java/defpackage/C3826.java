package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.flowable.FlowableCollect;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

/* compiled from: FlowableCollectSingle.java */
/* renamed from: ߒ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3826<T, U> extends AbstractC4838<U> implements InterfaceC2583<U> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f13100;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<? extends U> f13101;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5246<? super U, ? super T> f13102;

    /* compiled from: FlowableCollectSingle.java */
    /* renamed from: ߒ$Ϳ, reason: contains not printable characters */
    public static final class C3827<T, U> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super U> f13103;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5246<? super U, ? super T> f13104;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final U f13105;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public Subscription f13106;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f13107;

        public C3827(InterfaceC4782<? super U> interfaceC4782, U u, InterfaceC5246<? super U, ? super T> interfaceC5246) {
            this.f13103 = interfaceC4782;
            this.f13104 = interfaceC5246;
            this.f13105 = u;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f13106.cancel();
            this.f13106 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f13106 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f13107) {
                return;
            }
            this.f13107 = true;
            this.f13106 = SubscriptionHelper.CANCELLED;
            this.f13103.onSuccess(this.f13105);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f13107) {
                C3671.m11803(th);
                return;
            }
            this.f13107 = true;
            this.f13106 = SubscriptionHelper.CANCELLED;
            this.f13103.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f13107) {
                return;
            }
            try {
                this.f13104.accept(this.f13105, t);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f13106.cancel();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f13106, subscription)) {
                this.f13106 = subscription;
                this.f13103.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C3826(AbstractC3630<T> abstractC3630, Callable<? extends U> callable, InterfaceC5246<? super U, ? super T> interfaceC5246) {
        this.f13100 = abstractC3630;
        this.f13101 = callable;
        this.f13102 = interfaceC5246;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super U> interfaceC4782) {
        try {
            this.f13100.subscribe((InterfaceC3899) new C3827(interfaceC4782, C4246.m13353(this.f13101.call(), "The initialSupplier returned a null value"), this.f13102));
        } catch (Throwable th) {
            EmptyDisposable.error(th, interfaceC4782);
        }
    }

    @Override // defpackage.InterfaceC2583
    /* renamed from: ԩ */
    public AbstractC3630<U> mo6444() {
        return C3671.m11796(new FlowableCollect(this.f13100, this.f13101, this.f13102));
    }
}
