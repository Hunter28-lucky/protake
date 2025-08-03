package defpackage;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscribers.BlockingSubscriber;
import io.reactivex.internal.subscribers.BoundedSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableBlockingSubscribe.java */
/* renamed from: ٶ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3497 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T> void m11414(Publisher<? extends T> publisher) {
        C2335 c2335 = new C2335();
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(Functions.m6320(), c2335, c2335, Functions.f6807);
        publisher.subscribe(lambdaSubscriber);
        C2336.m8747(c2335, lambdaSubscriber);
        Throwable th = c2335.f8868;
        if (th != null) {
            throw ExceptionHelper.m7024(th);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T> void m11415(Publisher<? extends T> publisher, InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC2857, "onNext is null");
        C4246.m13353(interfaceC28572, "onError is null");
        C4246.m13353(interfaceC3809, "onComplete is null");
        m11417(publisher, new LambdaSubscriber(interfaceC2857, interfaceC28572, interfaceC3809, Functions.f6807));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T> void m11416(Publisher<? extends T> publisher, InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, int i) {
        C4246.m13353(interfaceC2857, "onNext is null");
        C4246.m13353(interfaceC28572, "onError is null");
        C4246.m13353(interfaceC3809, "onComplete is null");
        C4246.m13354(i, "number > 0 required");
        m11417(publisher, new BoundedSubscriber(interfaceC2857, interfaceC28572, interfaceC3809, Functions.m6316(i), i));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static <T> void m11417(Publisher<? extends T> publisher, Subscriber<? super T> subscriber) {
        Object objPoll;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingSubscriber blockingSubscriber = new BlockingSubscriber(linkedBlockingQueue);
        publisher.subscribe(blockingSubscriber);
        do {
            try {
                if (blockingSubscriber.m7001()) {
                    return;
                }
                objPoll = linkedBlockingQueue.poll();
                if (objPoll == null) {
                    if (blockingSubscriber.m7001()) {
                        return;
                    }
                    C2336.m8748();
                    objPoll = linkedBlockingQueue.take();
                }
                if (blockingSubscriber.m7001() || objPoll == BlockingSubscriber.f7674) {
                    return;
                }
            } catch (InterruptedException e2) {
                blockingSubscriber.cancel();
                subscriber.onError(e2);
                return;
            }
        } while (!NotificationLite.acceptFull(objPoll, subscriber));
    }
}
