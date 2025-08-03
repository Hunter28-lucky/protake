package defpackage;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ObservableBlockingSubscribe.java */
/* renamed from: ܫ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3693 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T> void m11840(InterfaceC2856<? extends T> interfaceC2856) {
        C2335 c2335 = new C2335();
        LambdaObserver lambdaObserver = new LambdaObserver(Functions.m6320(), c2335, c2335, Functions.m6320());
        interfaceC2856.subscribe(lambdaObserver);
        C2336.m8747(c2335, lambdaObserver);
        Throwable th = c2335.f8868;
        if (th != null) {
            throw ExceptionHelper.m7024(th);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T> void m11841(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC2857, "onNext is null");
        C4246.m13353(interfaceC28572, "onError is null");
        C4246.m13353(interfaceC3809, "onComplete is null");
        m11842(interfaceC2856, new LambdaObserver(interfaceC2857, interfaceC28572, interfaceC3809, Functions.m6320()));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T> void m11842(InterfaceC2856<? extends T> interfaceC2856, InterfaceC5102<? super T> interfaceC5102) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
        interfaceC5102.onSubscribe(blockingObserver);
        interfaceC2856.subscribe(blockingObserver);
        while (!blockingObserver.isDisposed()) {
            Object objPoll = linkedBlockingQueue.poll();
            if (objPoll == null) {
                try {
                    objPoll = linkedBlockingQueue.take();
                } catch (InterruptedException e2) {
                    blockingObserver.dispose();
                    interfaceC5102.onError(e2);
                    return;
                }
            }
            if (blockingObserver.isDisposed() || objPoll == BlockingObserver.f6840 || NotificationLite.acceptFull(objPoll, interfaceC5102)) {
                return;
            }
        }
    }
}
