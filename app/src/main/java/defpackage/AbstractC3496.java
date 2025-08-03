package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;

/* compiled from: BlockingBaseSubscriber.java */
/* renamed from: ٵ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3496<T> extends CountDownLatch implements InterfaceC3899<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public T f12248;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Throwable f12249;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Subscription f12250;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public volatile boolean f12251;

    public AbstractC3496() {
        super(1);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        countDown();
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f12250, subscription)) {
            this.f12250 = subscription;
            if (this.f12251) {
                return;
            }
            subscription.request(Long.MAX_VALUE);
            if (this.f12251) {
                this.f12250 = SubscriptionHelper.CANCELLED;
                subscription.cancel();
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final T m11413() throws InterruptedException {
        if (getCount() != 0) {
            try {
                C2336.m8748();
                await();
            } catch (InterruptedException e2) {
                Subscription subscription = this.f12250;
                this.f12250 = SubscriptionHelper.CANCELLED;
                if (subscription != null) {
                    subscription.cancel();
                }
                throw ExceptionHelper.m7024(e2);
            }
        }
        Throwable th = this.f12249;
        if (th == null) {
            return this.f12248;
        }
        throw ExceptionHelper.m7024(th);
    }
}
