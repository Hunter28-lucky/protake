package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.flowable.FlowableToList;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ArrayListSupplier;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

/* compiled from: FlowableToListSingle.java */
/* renamed from: ب, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3431<T, U extends Collection<? super T>> extends AbstractC4838<U> implements InterfaceC2583<U> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f11790;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<U> f11791;

    /* compiled from: FlowableToListSingle.java */
    /* renamed from: ب$Ϳ, reason: contains not printable characters */
    public static final class C3432<T, U extends Collection<? super T>> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super U> f11792;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Subscription f11793;

        /* renamed from: ԭ, reason: contains not printable characters */
        public U f11794;

        public C3432(InterfaceC4782<? super U> interfaceC4782, U u) {
            this.f11792 = interfaceC4782;
            this.f11794 = u;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f11793.cancel();
            this.f11793 = SubscriptionHelper.CANCELLED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11793 == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f11793 = SubscriptionHelper.CANCELLED;
            this.f11792.onSuccess(this.f11794);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f11794 = null;
            this.f11793 = SubscriptionHelper.CANCELLED;
            this.f11792.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f11794.add(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f11793, subscription)) {
                this.f11793 = subscription;
                this.f11792.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C3431(AbstractC3630<T> abstractC3630) {
        this(abstractC3630, ArrayListSupplier.asCallable());
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super U> interfaceC4782) {
        try {
            this.f11790.subscribe((InterfaceC3899) new C3432(interfaceC4782, (Collection) C4246.m13353(this.f11791.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC4782);
        }
    }

    @Override // defpackage.InterfaceC2583
    /* renamed from: ԩ */
    public AbstractC3630<U> mo6444() {
        return C3671.m11796(new FlowableToList(this.f11790, this.f11791));
    }

    public C3431(AbstractC3630<T> abstractC3630, Callable<U> callable) {
        this.f11790 = abstractC3630;
        this.f11791 = callable;
    }
}
