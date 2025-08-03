package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3164;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4851;
import defpackage.InterfaceC5102;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableSwitchMap<T, R> extends AbstractC3414<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> f7494;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f7495;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean f7496;

    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        public final int bufferSize;
        public volatile boolean done;
        public final long index;
        public final SwitchMapObserver<T, R> parent;
        public volatile InterfaceC4851<R> queue;

        public SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j, int i) {
            this.parent = switchMapObserver;
            this.index = j;
            this.bufferSize = i;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.m6908();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.parent.m6909(this, th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(R r) {
            if (this.index == this.parent.unique) {
                if (r != null) {
                    this.queue.offer(r);
                }
                this.parent.m6908();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.setOnce(this, interfaceC4478)) {
                if (interfaceC4478 instanceof InterfaceC3164) {
                    InterfaceC3164 interfaceC3164 = (InterfaceC3164) interfaceC4478;
                    int iMo6310 = interfaceC3164.mo6310(7);
                    if (iMo6310 == 1) {
                        this.queue = interfaceC3164;
                        this.done = true;
                        this.parent.m6908();
                        return;
                    } else if (iMo6310 == 2) {
                        this.queue = interfaceC3164;
                        return;
                    }
                }
                this.queue = new d(this.bufferSize);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6906() {
            DisposableHelper.dispose(this);
        }
    }

    public static final class SwitchMapObserver<T, R> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -3491074160481096299L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final SwitchMapInnerObserver<Object, Object> f7497;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final InterfaceC5102<? super R> downstream;
        public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> mapper;
        public volatile long unique;
        public InterfaceC4478 upstream;
        public final AtomicReference<SwitchMapInnerObserver<T, R>> active = new AtomicReference<>();
        public final AtomicThrowable errors = new AtomicThrowable();

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>(null, -1L, 1);
            f7497 = switchMapInnerObserver;
            switchMapInnerObserver.m6906();
        }

        public SwitchMapObserver(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, int i, boolean z) {
            this.downstream = interfaceC5102;
            this.mapper = interfaceC2368;
            this.bufferSize = i;
            this.delayErrors = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            m6907();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            m6908();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.done || !this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                m6907();
            }
            this.done = true;
            m6908();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            SwitchMapInnerObserver<T, R> switchMapInnerObserver;
            long j = this.unique + 1;
            this.unique = j;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.m6906();
            }
            try {
                InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.mapper.apply(t), "The ObservableSource returned is null");
                SwitchMapInnerObserver switchMapInnerObserver3 = new SwitchMapInnerObserver(this, j, this.bufferSize);
                do {
                    switchMapInnerObserver = this.active.get();
                    if (switchMapInnerObserver == f7497) {
                        return;
                    }
                } while (!C4905.m14631(this.active, switchMapInnerObserver, switchMapInnerObserver3));
                interfaceC2856.subscribe(switchMapInnerObserver3);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6907() {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver3 = f7497;
            if (switchMapInnerObserver2 == switchMapInnerObserver3 || (switchMapInnerObserver = (SwitchMapInnerObserver) this.active.getAndSet(switchMapInnerObserver3)) == switchMapInnerObserver3 || switchMapInnerObserver == null) {
                return;
            }
            switchMapInnerObserver.m6906();
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x000f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x00e9 A[SYNTHETIC] */
        /* renamed from: Ԩ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6908() {
            /*
                Method dump skipped, instructions count: 241
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver.m6908():void");
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6909(SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable th) {
            if (switchMapInnerObserver.index != this.unique || !this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                this.done = true;
            }
            switchMapInnerObserver.done = true;
            m6908();
        }
    }

    public ObservableSwitchMap(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, int i, boolean z) {
        super(interfaceC2856);
        this.f7494 = interfaceC2368;
        this.f7495 = i;
        this.f7496 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        if (ObservableScalarXMap.m6895(this.f11778, interfaceC5102, this.f7494)) {
            return;
        }
        this.f11778.subscribe(new SwitchMapObserver(interfaceC5102, this.f7494, this.f7495, this.f7496));
    }
}
