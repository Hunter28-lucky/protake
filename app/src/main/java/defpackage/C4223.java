package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableBufferExactBoundary.java */
/* renamed from: ਅ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4223<T, U extends Collection<? super T>, B> extends AbstractC3414<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<B> f14516;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Callable<U> f14517;

    /* compiled from: ObservableBufferExactBoundary.java */
    /* renamed from: ਅ$Ϳ, reason: contains not printable characters */
    public static final class C4224<T, U extends Collection<? super T>, B> extends AbstractC5105<B> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C4225<T, U, B> f14518;

        public C4224(C4225<T, U, B> c4225) {
            this.f14518 = c4225;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f14518.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f14518.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(B b) {
            this.f14518.m13312();
        }
    }

    /* compiled from: ObservableBufferExactBoundary.java */
    /* renamed from: ਅ$Ԩ, reason: contains not printable characters */
    public static final class C4225<T, U extends Collection<? super T>, B> extends AbstractC4701<T, U, U> implements InterfaceC4478 {

        /* renamed from: ֈ, reason: contains not printable characters */
        public final Callable<U> f14519;

        /* renamed from: ֏, reason: contains not printable characters */
        public final InterfaceC2856<B> f14520;

        /* renamed from: ׯ, reason: contains not printable characters */
        public InterfaceC4478 f14521;

        /* renamed from: ؠ, reason: contains not printable characters */
        public InterfaceC4478 f14522;

        /* renamed from: ހ, reason: contains not printable characters */
        public U f14523;

        public C4225(InterfaceC5102<? super U> interfaceC5102, Callable<U> callable, InterfaceC2856<B> interfaceC2856) {
            super(interfaceC5102, new MpscLinkedQueue());
            this.f14519 = callable;
            this.f14520 = interfaceC2856;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.f15960) {
                return;
            }
            this.f15960 = true;
            this.f14522.dispose();
            this.f14521.dispose();
            if (m14234()) {
                this.f15959.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15960;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            synchronized (this) {
                U u = this.f14523;
                if (u == null) {
                    return;
                }
                this.f14523 = null;
                this.f15959.offer(u);
                this.f15961 = true;
                if (m14234()) {
                    C5263.m15305(this.f15959, this.f15958, false, this, this);
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            dispose();
            this.f15958.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f14523;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f14521, interfaceC4478)) {
                this.f14521 = interfaceC4478;
                try {
                    this.f14523 = (U) C4246.m13353(this.f14519.call(), "The buffer supplied is null");
                    C4224 c4224 = new C4224(this);
                    this.f14522 = c4224;
                    this.f15958.onSubscribe(this);
                    if (this.f15960) {
                        return;
                    }
                    this.f14520.subscribe(c4224);
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.f15960 = true;
                    interfaceC4478.dispose();
                    EmptyDisposable.error(th, this.f15958);
                }
            }
        }

        @Override // defpackage.AbstractC4701, defpackage.InterfaceC3556
        /* renamed from: ՠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo10684(InterfaceC5102<? super U> interfaceC5102, U u) {
            this.f15958.onNext(u);
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public void m13312() {
            try {
                U u = (U) C4246.m13353(this.f14519.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.f14523;
                    if (u2 == null) {
                        return;
                    }
                    this.f14523 = u;
                    m14236(u2, false, this);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                dispose();
                this.f15958.onError(th);
            }
        }
    }

    public C4223(InterfaceC2856<T> interfaceC2856, InterfaceC2856<B> interfaceC28562, Callable<U> callable) {
        super(interfaceC2856);
        this.f14516 = interfaceC28562;
        this.f14517 = callable;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super U> interfaceC5102) {
        this.f11778.subscribe(new C4225(new C5312(interfaceC5102), this.f14517, this.f14516));
    }
}
