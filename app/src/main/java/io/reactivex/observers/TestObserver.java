package io.reactivex.observers;

import defpackage.AbstractC5174;
import defpackage.C4905;
import defpackage.InterfaceC3164;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5053;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5216;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class TestObserver<T> extends AbstractC5174<T, TestObserver<T>> implements InterfaceC5102<T>, InterfaceC5216<T>, InterfaceC4782<T>, InterfaceC5053 {

    /* renamed from: ׯ, reason: contains not printable characters */
    public final InterfaceC5102<? super T> f7692;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final AtomicReference<InterfaceC4478> f7693;

    /* renamed from: ހ, reason: contains not printable characters */
    public InterfaceC3164<T> f7694;

    public enum EmptyObserver implements InterfaceC5102<Object> {
        INSTANCE;

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(Object obj) {
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
        }
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    public final void cancel() {
        dispose();
    }

    @Override // defpackage.InterfaceC4478
    public final void dispose() {
        DisposableHelper.dispose(this.f7693);
    }

    @Override // defpackage.InterfaceC4478
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f7693.get());
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        if (!this.f17130) {
            this.f17130 = true;
            if (this.f7693.get() == null) {
                this.f17127.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f17129 = Thread.currentThread();
            this.f17128++;
            this.f7692.onComplete();
        } finally {
            this.f17125.countDown();
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        if (!this.f17130) {
            this.f17130 = true;
            if (this.f7693.get() == null) {
                this.f17127.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f17129 = Thread.currentThread();
            if (th == null) {
                this.f17127.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f17127.add(th);
            }
            this.f7692.onError(th);
        } finally {
            this.f17125.countDown();
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        if (!this.f17130) {
            this.f17130 = true;
            if (this.f7693.get() == null) {
                this.f17127.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f17129 = Thread.currentThread();
        if (this.f17132 != 2) {
            this.f17126.add(t);
            if (t == null) {
                this.f17127.add(new NullPointerException("onNext received a null value"));
            }
            this.f7692.onNext(t);
            return;
        }
        while (true) {
            try {
                T tPoll = this.f7694.poll();
                if (tPoll == null) {
                    return;
                } else {
                    this.f17126.add(tPoll);
                }
            } catch (Throwable th) {
                this.f17127.add(th);
                this.f7694.dispose();
                return;
            }
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        this.f17129 = Thread.currentThread();
        if (interfaceC4478 == null) {
            this.f17127.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!C4905.m14631(this.f7693, null, interfaceC4478)) {
            interfaceC4478.dispose();
            if (this.f7693.get() != DisposableHelper.DISPOSED) {
                this.f17127.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + interfaceC4478));
                return;
            }
            return;
        }
        int i = this.f17131;
        if (i != 0 && (interfaceC4478 instanceof InterfaceC3164)) {
            InterfaceC3164<T> interfaceC3164 = (InterfaceC3164) interfaceC4478;
            this.f7694 = interfaceC3164;
            int iMo6310 = interfaceC3164.mo6310(i);
            this.f17132 = iMo6310;
            if (iMo6310 == 1) {
                this.f17130 = true;
                this.f17129 = Thread.currentThread();
                while (true) {
                    try {
                        T tPoll = this.f7694.poll();
                        if (tPoll == null) {
                            this.f17128++;
                            this.f7693.lazySet(DisposableHelper.DISPOSED);
                            return;
                        }
                        this.f17126.add(tPoll);
                    } catch (Throwable th) {
                        this.f17127.add(th);
                        return;
                    }
                }
            }
        }
        this.f7692.onSubscribe(interfaceC4478);
    }

    @Override // defpackage.InterfaceC5216
    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }

    public TestObserver(InterfaceC5102<? super T> interfaceC5102) {
        this.f7693 = new AtomicReference<>();
        this.f7692 = interfaceC5102;
    }
}
