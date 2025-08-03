package defpackage;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingBaseObserver.java */
/* renamed from: ˌ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC2743<T> extends CountDownLatch implements InterfaceC5102<T>, InterfaceC4478 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public T f10074;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Throwable f10075;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC4478 f10076;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public volatile boolean f10077;

    public AbstractC2743() {
        super(1);
    }

    @Override // defpackage.InterfaceC4478
    public final void dispose() {
        this.f10077 = true;
        InterfaceC4478 interfaceC4478 = this.f10076;
        if (interfaceC4478 != null) {
            interfaceC4478.dispose();
        }
    }

    @Override // defpackage.InterfaceC4478
    public final boolean isDisposed() {
        return this.f10077;
    }

    @Override // defpackage.InterfaceC5102
    public final void onComplete() {
        countDown();
    }

    @Override // defpackage.InterfaceC5102
    public final void onSubscribe(InterfaceC4478 interfaceC4478) {
        this.f10076 = interfaceC4478;
        if (this.f10077) {
            interfaceC4478.dispose();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final T m10001() {
        if (getCount() != 0) {
            try {
                C2336.m8748();
                await();
            } catch (InterruptedException e2) {
                dispose();
                throw ExceptionHelper.m7024(e2);
            }
        }
        Throwable th = this.f10075;
        if (th == null) {
            return this.f10074;
        }
        throw ExceptionHelper.m7024(th);
    }
}
