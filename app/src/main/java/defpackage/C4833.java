package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* compiled from: SingleFromPublisher.java */
/* renamed from: ඳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4833<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<? extends T> f16336;

    /* compiled from: SingleFromPublisher.java */
    /* renamed from: ඳ$Ϳ, reason: contains not printable characters */
    public static final class C4834<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f16337;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Subscription f16338;

        /* renamed from: ԭ, reason: contains not printable characters */
        public T f16339;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f16340;

        /* renamed from: ԯ, reason: contains not printable characters */
        public volatile boolean f16341;

        public C4834(InterfaceC4782<? super T> interfaceC4782) {
            this.f16337 = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16341 = true;
            this.f16338.cancel();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16341;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f16340) {
                return;
            }
            this.f16340 = true;
            T t = this.f16339;
            this.f16339 = null;
            if (t == null) {
                this.f16337.onError(new NoSuchElementException("The source Publisher is empty"));
            } else {
                this.f16337.onSuccess(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f16340) {
                C3671.m11803(th);
                return;
            }
            this.f16340 = true;
            this.f16339 = null;
            this.f16337.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f16340) {
                return;
            }
            if (this.f16339 == null) {
                this.f16339 = t;
                return;
            }
            this.f16338.cancel();
            this.f16340 = true;
            this.f16339 = null;
            this.f16337.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16338, subscription)) {
                this.f16338 = subscription;
                this.f16337.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C4833(Publisher<? extends T> publisher) {
        this.f16336 = publisher;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f16336.subscribe(new C4834(interfaceC4782));
    }
}
