package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.AbstractC4945;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4503;
import defpackage.InterfaceC5102;
import defpackage.o2;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableReplay<T> extends AbstractC4945<T> implements InterfaceC4503 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final InterfaceC2081 f7435 = new C2089();

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f7436;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AtomicReference<ReplayObserver<T>> f7437;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2081<T> f7438;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC2856<T> f7439;

    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements InterfaceC2085<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        public int size;
        public Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node(null);
            this.tail = node;
            set(node);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.InterfaceC2085
        public final void complete() {
            m6864(new Node(mo6865(NotificationLite.complete())));
            mo6872();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.InterfaceC2085
        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void mo6861(T t) {
            m6864(new Node(mo6865(NotificationLite.next(t))));
            mo6871();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.InterfaceC2085
        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void mo6862(Throwable th) {
            m6864(new Node(mo6865(NotificationLite.error(th))));
            mo6872();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.InterfaceC2085
        /* renamed from: ԩ, reason: contains not printable characters */
        public final void mo6863(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                Node nodeMo6866 = (Node) innerDisposable.m6873();
                if (nodeMo6866 == null) {
                    nodeMo6866 = mo6866();
                    innerDisposable.index = nodeMo6866;
                }
                while (!innerDisposable.isDisposed()) {
                    Node node = nodeMo6866.get();
                    if (node == null) {
                        innerDisposable.index = nodeMo6866;
                        iAddAndGet = innerDisposable.addAndGet(-iAddAndGet);
                    } else {
                        if (NotificationLite.accept(mo6867(node.value), innerDisposable.child)) {
                            innerDisposable.index = null;
                            return;
                        }
                        nodeMo6866 = node;
                    }
                }
                innerDisposable.index = null;
                return;
            } while (iAddAndGet != 0);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final void m6864(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public Object mo6865(Object obj) {
            return obj;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Node mo6866() {
            return get();
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public Object mo6867(Object obj) {
            return obj;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final void m6868() {
            this.size--;
            m6869(get().get());
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final void m6869(Node node) {
            set(node);
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final void m6870() {
            Node node = get();
            if (node.value != null) {
                Node node2 = new Node(null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public abstract void mo6871();

        /* renamed from: ֏, reason: contains not printable characters */
        public void mo6872() {
            m6870();
        }
    }

    public static final class InnerDisposable<T> extends AtomicInteger implements InterfaceC4478 {
        private static final long serialVersionUID = 2728361546769921047L;
        public volatile boolean cancelled;
        public final InterfaceC5102<? super T> child;
        public Object index;
        public final ReplayObserver<T> parent;

        public InnerDisposable(ReplayObserver<T> replayObserver, InterfaceC5102<? super T> interfaceC5102) {
            this.parent = replayObserver;
            this.child = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.parent.m6875(this);
            this.index = null;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public <U> U m6873() {
            return (U) this.index;
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        public final Object value;

        public Node(Object obj) {
            this.value = obj;
        }
    }

    public static final class ReplayObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -533785617179540163L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final InnerDisposable[] f7440 = new InnerDisposable[0];

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final InnerDisposable[] f7441 = new InnerDisposable[0];
        public final InterfaceC2085<T> buffer;
        public boolean done;
        public final AtomicReference<InnerDisposable[]> observers = new AtomicReference<>(f7440);
        public final AtomicBoolean shouldConnect = new AtomicBoolean();

        public ReplayObserver(InterfaceC2085<T> interfaceC2085) {
            this.buffer = interfaceC2085;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.observers.set(f7441);
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.observers.get() == f7441;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            m6877();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.done = true;
            this.buffer.mo6862(th);
            m6877();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.mo6861(t);
            m6876();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.setOnce(this, interfaceC4478)) {
                m6876();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6874(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                if (innerDisposableArr == f7441) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!C4905.m14631(this.observers, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6875(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.observers.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerDisposableArr[i2].equals(innerDisposable)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = f7440;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i);
                    System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr3, i, (length - i) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!C4905.m14631(this.observers, innerDisposableArr, innerDisposableArr2));
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6876() {
            for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                this.buffer.mo6863(innerDisposable);
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6877() {
            for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(f7441)) {
                this.buffer.mo6863(innerDisposable);
            }
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        public final int limit;
        public final long maxAge;
        public final AbstractC4585 scheduler;
        public final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            this.scheduler = abstractC4585;
            this.limit = i;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        /* renamed from: ԫ */
        public Object mo6865(Object obj) {
            return new o2(obj, this.scheduler.m14050(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        /* renamed from: Ԭ */
        public Node mo6866() {
            Node node;
            long jM14050 = this.scheduler.m14050(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                o2 o2Var = (o2) node2.value;
                if (NotificationLite.isComplete(o2Var.m7668()) || NotificationLite.isError(o2Var.m7668()) || o2Var.m7667() > jM14050) {
                    break;
                }
                node3 = node2.get();
            }
            return node;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        /* renamed from: ԭ */
        public Object mo6867(Object obj) {
            return ((o2) obj).m7668();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        /* renamed from: ֈ */
        public void mo6871() {
            Node node;
            long jM14050 = this.scheduler.m14050(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                int i2 = this.size;
                if (i2 > this.limit && i2 > 1) {
                    i++;
                    this.size = i2 - 1;
                    node3 = node2.get();
                } else {
                    if (((o2) node2.value).m7667() > jM14050) {
                        break;
                    }
                    i++;
                    this.size--;
                    node3 = node2.get();
                }
            }
            if (i != 0) {
                m6869(node);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        /* renamed from: ֏ */
        public void mo6872() {
            Node node;
            long jM14050 = this.scheduler.m14050(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null || this.size <= 1 || ((o2) node2.value).m7667() > jM14050) {
                    break;
                }
                i++;
                this.size--;
                node3 = node2.get();
            }
            if (i != 0) {
                m6869(node);
            }
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        public final int limit;

        public SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        /* renamed from: ֈ */
        public void mo6871() {
            if (this.size > this.limit) {
                m6868();
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements InterfaceC2085<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        public volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.InterfaceC2085
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.InterfaceC2085
        /* renamed from: Ϳ */
        public void mo6861(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.InterfaceC2085
        /* renamed from: Ԩ */
        public void mo6862(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.InterfaceC2085
        /* renamed from: ԩ */
        public void mo6863(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            InterfaceC5102<? super T> interfaceC5102 = innerDisposable.child;
            int iAddAndGet = 1;
            while (!innerDisposable.isDisposed()) {
                int i = this.size;
                Integer num = (Integer) innerDisposable.m6873();
                int iIntValue = num != null ? num.intValue() : 0;
                while (iIntValue < i) {
                    if (NotificationLite.accept(get(iIntValue), interfaceC5102) || innerDisposable.isDisposed()) {
                        return;
                    } else {
                        iIntValue++;
                    }
                }
                innerDisposable.index = Integer.valueOf(iIntValue);
                iAddAndGet = innerDisposable.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableReplay$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2081<T> {
        InterfaceC2085<T> call();
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableReplay$Ԩ, reason: contains not printable characters */
    public static final class C2082<R> implements InterfaceC2857<InterfaceC4478> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final ObserverResourceWrapper<R> f7442;

        public C2082(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.f7442 = observerResourceWrapper;
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(InterfaceC4478 interfaceC4478) {
            this.f7442.m6945(interfaceC4478);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableReplay$Ԫ, reason: contains not printable characters */
    public static final class C2083<R, U> extends AbstractC4262<R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Callable<? extends AbstractC4945<U>> f7443;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super AbstractC4262<U>, ? extends InterfaceC2856<R>> f7444;

        public C2083(Callable<? extends AbstractC4945<U>> callable, InterfaceC2368<? super AbstractC4262<U>, ? extends InterfaceC2856<R>> interfaceC2368) {
            this.f7443 = callable;
            this.f7444 = interfaceC2368;
        }

        @Override // defpackage.AbstractC4262
        public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
            try {
                AbstractC4945 abstractC4945 = (AbstractC4945) C4246.m13353(this.f7443.call(), "The connectableFactory returned a null ConnectableObservable");
                InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.f7444.apply(abstractC4945), "The selector returned a null ObservableSource");
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(interfaceC5102);
                interfaceC2856.subscribe(observerResourceWrapper);
                abstractC4945.mo6834(new C2082(observerResourceWrapper));
            } catch (Throwable th) {
                C4089.m13026(th);
                EmptyDisposable.error(th, interfaceC5102);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableReplay$Ԭ, reason: contains not printable characters */
    public static final class C2084<T> extends AbstractC4945<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC4945<T> f7445;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AbstractC4262<T> f7446;

        public C2084(AbstractC4945<T> abstractC4945, AbstractC4262<T> abstractC4262) {
            this.f7445 = abstractC4945;
            this.f7446 = abstractC4262;
        }

        @Override // defpackage.AbstractC4262
        public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
            this.f7446.subscribe(interfaceC5102);
        }

        @Override // defpackage.AbstractC4945
        /* renamed from: ԫ */
        public void mo6834(InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
            this.f7445.mo6834(interfaceC2857);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableReplay$Ԯ, reason: contains not printable characters */
    public interface InterfaceC2085<T> {
        void complete();

        /* renamed from: Ϳ */
        void mo6861(T t);

        /* renamed from: Ԩ */
        void mo6862(Throwable th);

        /* renamed from: ԩ */
        void mo6863(InnerDisposable<T> innerDisposable);
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableReplay$ՠ, reason: contains not printable characters */
    public static final class C2086<T> implements InterfaceC2081<T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final int f7447;

        public C2086(int i) {
            this.f7447 = i;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.InterfaceC2081
        public InterfaceC2085<T> call() {
            return new SizeBoundReplayBuffer(this.f7447);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableReplay$ֈ, reason: contains not printable characters */
    public static final class C2087<T> implements InterfaceC2856<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AtomicReference<ReplayObserver<T>> f7448;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2081<T> f7449;

        public C2087(AtomicReference<ReplayObserver<T>> atomicReference, InterfaceC2081<T> interfaceC2081) {
            this.f7448 = atomicReference;
            this.f7449 = interfaceC2081;
        }

        @Override // defpackage.InterfaceC2856
        public void subscribe(InterfaceC5102<? super T> interfaceC5102) {
            ReplayObserver<T> replayObserver;
            while (true) {
                replayObserver = this.f7448.get();
                if (replayObserver != null) {
                    break;
                }
                ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.f7449.call());
                if (C4905.m14631(this.f7448, null, replayObserver2)) {
                    replayObserver = replayObserver2;
                    break;
                }
            }
            InnerDisposable<T> innerDisposable = new InnerDisposable<>(replayObserver, interfaceC5102);
            interfaceC5102.onSubscribe(innerDisposable);
            replayObserver.m6874(innerDisposable);
            if (innerDisposable.isDisposed()) {
                replayObserver.m6875(innerDisposable);
            } else {
                replayObserver.buffer.mo6863(innerDisposable);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableReplay$֏, reason: contains not printable characters */
    public static final class C2088<T> implements InterfaceC2081<T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final int f7450;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final long f7451;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final TimeUnit f7452;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final AbstractC4585 f7453;

        public C2088(int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            this.f7450 = i;
            this.f7451 = j;
            this.f7452 = timeUnit;
            this.f7453 = abstractC4585;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.InterfaceC2081
        public InterfaceC2085<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.f7450, this.f7451, this.f7452, this.f7453);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableReplay$ׯ, reason: contains not printable characters */
    public static final class C2089 implements InterfaceC2081<Object> {
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.InterfaceC2081
        public InterfaceC2085<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    public ObservableReplay(InterfaceC2856<T> interfaceC2856, InterfaceC2856<T> interfaceC28562, AtomicReference<ReplayObserver<T>> atomicReference, InterfaceC2081<T> interfaceC2081) {
        this.f7439 = interfaceC2856;
        this.f7436 = interfaceC28562;
        this.f7437 = atomicReference;
        this.f7438 = interfaceC2081;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static <T> AbstractC4945<T> m6854(InterfaceC2856<T> interfaceC2856, int i) {
        return i == Integer.MAX_VALUE ? m6858(interfaceC2856) : m6857(interfaceC2856, new C2086(i));
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static <T> AbstractC4945<T> m6855(InterfaceC2856<T> interfaceC2856, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return m6856(interfaceC2856, j, timeUnit, abstractC4585, Integer.MAX_VALUE);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static <T> AbstractC4945<T> m6856(InterfaceC2856<T> interfaceC2856, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i) {
        return m6857(interfaceC2856, new C2088(i, j, timeUnit, abstractC4585));
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static <T> AbstractC4945<T> m6857(InterfaceC2856<T> interfaceC2856, InterfaceC2081<T> interfaceC2081) {
        AtomicReference atomicReference = new AtomicReference();
        return C3671.m11795(new ObservableReplay(new C2087(atomicReference, interfaceC2081), interfaceC2856, atomicReference, interfaceC2081));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static <T> AbstractC4945<T> m6858(InterfaceC2856<? extends T> interfaceC2856) {
        return m6857(interfaceC2856, f7435);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static <U, R> AbstractC4262<R> m6859(Callable<? extends AbstractC4945<U>> callable, InterfaceC2368<? super AbstractC4262<U>, ? extends InterfaceC2856<R>> interfaceC2368) {
        return C3671.m11798(new C2083(callable, interfaceC2368));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static <T> AbstractC4945<T> m6860(AbstractC4945<T> abstractC4945, AbstractC4585 abstractC4585) {
        return C3671.m11795(new C2084(abstractC4945, abstractC4945.observeOn(abstractC4585)));
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f7439.subscribe(interfaceC5102);
    }

    @Override // defpackage.InterfaceC4503
    /* renamed from: ԩ */
    public void mo6557(InterfaceC4478 interfaceC4478) {
        C4905.m14631(this.f7437, (ReplayObserver) interfaceC4478, null);
    }

    @Override // defpackage.AbstractC4945
    /* renamed from: ԫ */
    public void mo6834(InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
        ReplayObserver<T> replayObserver;
        while (true) {
            replayObserver = this.f7437.get();
            if (replayObserver != null && !replayObserver.isDisposed()) {
                break;
            }
            ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.f7438.call());
            if (C4905.m14631(this.f7437, replayObserver, replayObserver2)) {
                replayObserver = replayObserver2;
                break;
            }
        }
        boolean z = !replayObserver.shouldConnect.get() && replayObserver.shouldConnect.compareAndSet(false, true);
        try {
            interfaceC2857.accept(replayObserver);
            if (z) {
                this.f7436.subscribe(replayObserver);
            }
        } catch (Throwable th) {
            if (z) {
                replayObserver.shouldConnect.compareAndSet(true, false);
            }
            C4089.m13026(th);
            throw ExceptionHelper.m7024(th);
        }
    }
}
