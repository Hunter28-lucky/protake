package defpackage;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* compiled from: SingleDelay.java */
/* renamed from: ఘ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4518<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f15467;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f15468;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f15469;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f15470;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f15471;

    /* compiled from: SingleDelay.java */
    /* renamed from: ఘ$Ϳ, reason: contains not printable characters */
    public final class C4519 implements InterfaceC4782<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final SequentialDisposable f15472;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f15473;

        /* compiled from: SingleDelay.java */
        /* renamed from: ఘ$Ϳ$Ϳ, reason: contains not printable characters */
        public final class RunnableC4520 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final Throwable f15475;

            public RunnableC4520(Throwable th) {
                this.f15475 = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                C4519.this.f15473.onError(this.f15475);
            }
        }

        /* compiled from: SingleDelay.java */
        /* renamed from: ఘ$Ϳ$Ԩ, reason: contains not printable characters */
        public final class RunnableC4521 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final T f15477;

            public RunnableC4521(T t) {
                this.f15477 = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                C4519.this.f15473.onSuccess(this.f15477);
            }
        }

        public C4519(SequentialDisposable sequentialDisposable, InterfaceC4782<? super T> interfaceC4782) {
            this.f15472 = sequentialDisposable;
            this.f15473 = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            SequentialDisposable sequentialDisposable = this.f15472;
            AbstractC4585 abstractC4585 = C4518.this.f15470;
            RunnableC4520 runnableC4520 = new RunnableC4520(th);
            C4518 c4518 = C4518.this;
            sequentialDisposable.m6311(abstractC4585.mo6988(runnableC4520, c4518.f15471 ? c4518.f15468 : 0L, c4518.f15469));
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f15472.m6311(interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            SequentialDisposable sequentialDisposable = this.f15472;
            AbstractC4585 abstractC4585 = C4518.this.f15470;
            RunnableC4521 runnableC4521 = new RunnableC4521(t);
            C4518 c4518 = C4518.this;
            sequentialDisposable.m6311(abstractC4585.mo6988(runnableC4521, c4518.f15468, c4518.f15469));
        }
    }

    public C4518(InterfaceC3951<? extends T> interfaceC3951, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        this.f15467 = interfaceC3951;
        this.f15468 = j;
        this.f15469 = timeUnit;
        this.f15470 = abstractC4585;
        this.f15471 = z;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        interfaceC4782.onSubscribe(sequentialDisposable);
        this.f15467.subscribe(new C4519(sequentialDisposable, interfaceC4782));
    }
}
