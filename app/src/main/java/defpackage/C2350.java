package defpackage;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingMultiObserver.java */
/* renamed from: ĺ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2350<T> extends CountDownLatch implements InterfaceC4782<T>, InterfaceC5053, InterfaceC5216<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public T f8888;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Throwable f8889;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC4478 f8890;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public volatile boolean f8891;

    public C2350() {
        super(1);
    }

    @Override // defpackage.InterfaceC5053
    public void onComplete() {
        countDown();
    }

    @Override // defpackage.InterfaceC4782
    public void onError(Throwable th) {
        this.f8889 = th;
        countDown();
    }

    @Override // defpackage.InterfaceC4782
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        this.f8890 = interfaceC4478;
        if (this.f8891) {
            interfaceC4478.dispose();
        }
    }

    @Override // defpackage.InterfaceC4782
    public void onSuccess(T t) {
        this.f8888 = t;
        countDown();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public T m8797() throws InterruptedException {
        if (getCount() != 0) {
            try {
                C2336.m8748();
                await();
            } catch (InterruptedException e2) {
                m8798();
                throw ExceptionHelper.m7024(e2);
            }
        }
        Throwable th = this.f8889;
        if (th == null) {
            return this.f8888;
        }
        throw ExceptionHelper.m7024(th);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m8798() {
        this.f8891 = true;
        InterfaceC4478 interfaceC4478 = this.f8890;
        if (interfaceC4478 != null) {
            interfaceC4478.dispose();
        }
    }
}
