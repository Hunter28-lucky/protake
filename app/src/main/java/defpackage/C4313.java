package defpackage;

import defpackage.AbstractC4585;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableDelay.java */
/* renamed from: એ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4313<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f14783;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f14784;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f14785;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f14786;

    /* compiled from: ObservableDelay.java */
    /* renamed from: એ$Ϳ, reason: contains not printable characters */
    public static final class C4314<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f14787;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f14788;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final TimeUnit f14789;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final AbstractC4585.AbstractC4588 f14790;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final boolean f14791;

        /* renamed from: ՠ, reason: contains not printable characters */
        public InterfaceC4478 f14792;

        /* compiled from: ObservableDelay.java */
        /* renamed from: એ$Ϳ$Ϳ, reason: contains not printable characters */
        public final class RunnableC4315 implements Runnable {
            public RunnableC4315() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    C4314.this.f14787.onComplete();
                } finally {
                    C4314.this.f14790.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        /* renamed from: એ$Ϳ$Ԩ, reason: contains not printable characters */
        public final class RunnableC4316 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final Throwable f14794;

            public RunnableC4316(Throwable th) {
                this.f14794 = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    C4314.this.f14787.onError(this.f14794);
                } finally {
                    C4314.this.f14790.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        /* renamed from: એ$Ϳ$Ԫ, reason: contains not printable characters */
        public final class RunnableC4317 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final T f14796;

            public RunnableC4317(T t) {
                this.f14796 = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                C4314.this.f14787.onNext(this.f14796);
            }
        }

        public C4314(InterfaceC5102<? super T> interfaceC5102, long j, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588, boolean z) {
            this.f14787 = interfaceC5102;
            this.f14788 = j;
            this.f14789 = timeUnit;
            this.f14790 = abstractC4588;
            this.f14791 = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f14792.dispose();
            this.f14790.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f14790.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f14790.mo6991(new RunnableC4315(), this.f14788, this.f14789);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f14790.mo6991(new RunnableC4316(th), this.f14791 ? this.f14788 : 0L, this.f14789);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f14790.mo6991(new RunnableC4317(t), this.f14788, this.f14789);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f14792, interfaceC4478)) {
                this.f14792 = interfaceC4478;
                this.f14787.onSubscribe(this);
            }
        }
    }

    public C4313(InterfaceC2856<T> interfaceC2856, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        super(interfaceC2856);
        this.f14783 = j;
        this.f14784 = timeUnit;
        this.f14785 = abstractC4585;
        this.f14786 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C4314(this.f14786 ? interfaceC5102 : new C5312(interfaceC5102), this.f14783, this.f14784, this.f14785.mo6986(), this.f14786));
    }
}
