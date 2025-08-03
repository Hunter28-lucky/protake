package defpackage;

import defpackage.AbstractC4585;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableDelay.java */
/* renamed from: я, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2912<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f10609;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f10610;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f10611;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f10612;

    /* compiled from: FlowableDelay.java */
    /* renamed from: я$Ϳ, reason: contains not printable characters */
    public static final class C2913<T> implements InterfaceC3899<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f10613;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f10614;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final TimeUnit f10615;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final AbstractC4585.AbstractC4588 f10616;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final boolean f10617;

        /* renamed from: ՠ, reason: contains not printable characters */
        public Subscription f10618;

        /* compiled from: FlowableDelay.java */
        /* renamed from: я$Ϳ$Ϳ, reason: contains not printable characters */
        public final class RunnableC2914 implements Runnable {
            public RunnableC2914() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    C2913.this.f10613.onComplete();
                } finally {
                    C2913.this.f10616.dispose();
                }
            }
        }

        /* compiled from: FlowableDelay.java */
        /* renamed from: я$Ϳ$Ԩ, reason: contains not printable characters */
        public final class RunnableC2915 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final Throwable f10620;

            public RunnableC2915(Throwable th) {
                this.f10620 = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    C2913.this.f10613.onError(this.f10620);
                } finally {
                    C2913.this.f10616.dispose();
                }
            }
        }

        /* compiled from: FlowableDelay.java */
        /* renamed from: я$Ϳ$Ԫ, reason: contains not printable characters */
        public final class RunnableC2916 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final T f10622;

            public RunnableC2916(T t) {
                this.f10622 = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                C2913.this.f10613.onNext(this.f10622);
            }
        }

        public C2913(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588, boolean z) {
            this.f10613 = subscriber;
            this.f10614 = j;
            this.f10615 = timeUnit;
            this.f10616 = abstractC4588;
            this.f10617 = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f10618.cancel();
            this.f10616.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f10616.mo6991(new RunnableC2914(), this.f10614, this.f10615);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f10616.mo6991(new RunnableC2915(th), this.f10617 ? this.f10614 : 0L, this.f10615);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f10616.mo6991(new RunnableC2916(t), this.f10614, this.f10615);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f10618, subscription)) {
                this.f10618 = subscription;
                this.f10613.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f10618.request(j);
        }
    }

    public C2912(AbstractC3630<T> abstractC3630, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        super(abstractC3630);
        this.f10609 = j;
        this.f10610 = timeUnit;
        this.f10611 = abstractC4585;
        this.f10612 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C2913(this.f10612 ? subscriber : new C4056(subscriber), this.f10609, this.f10610, this.f10611.mo6986(), this.f10612));
    }
}
