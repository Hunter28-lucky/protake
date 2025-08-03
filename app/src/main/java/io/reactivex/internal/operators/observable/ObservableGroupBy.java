package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3101;
import defpackage.AbstractC3414;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableGroupBy<T, K, V> extends AbstractC3414<T, AbstractC3101<K, V>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends K> f7367;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends V> f7368;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7369;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f7370;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -3688291656102519502L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final Object f7371 = new Object();
        public final int bufferSize;
        public final boolean delayError;
        public final InterfaceC5102<? super AbstractC3101<K, V>> downstream;
        public final InterfaceC2368<? super T, ? extends K> keySelector;
        public InterfaceC4478 upstream;
        public final InterfaceC2368<? super T, ? extends V> valueSelector;
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final Map<Object, C2076<K, V>> groups = new ConcurrentHashMap();

        public GroupByObserver(InterfaceC5102<? super AbstractC3101<K, V>> interfaceC5102, InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, int i, boolean z) {
            this.downstream = interfaceC5102;
            this.keySelector = interfaceC2368;
            this.valueSelector = interfaceC23682;
            this.bufferSize = i;
            this.delayError = z;
            lazySet(1);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((C2076) it.next()).onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((C2076) it.next()).onError(th);
            }
            this.downstream.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Map, java.util.Map<java.lang.Object, io.reactivex.internal.operators.observable.ObservableGroupBy$Ϳ<K, V>>] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v3, types: [io.reactivex.internal.operators.observable.ObservableGroupBy$Ϳ] */
        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            try {
                K kApply = this.keySelector.apply(t);
                Object obj = kApply != null ? kApply : f7371;
                C2076<K, V> c2076 = this.groups.get(obj);
                ?? r2 = c2076;
                if (c2076 == false) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    Object objM6799 = C2076.m6799(kApply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, objM6799);
                    getAndIncrement();
                    this.downstream.onNext(objM6799);
                    r2 = objM6799;
                }
                try {
                    r2.onNext(C4246.m13353(this.valueSelector.apply(t), "The value supplied is null"));
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.upstream.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.upstream.dispose();
                onError(th2);
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
        public void m6793(K k) {
            if (k == null) {
                k = (K) f7371;
            }
            this.groups.remove(k);
            if (decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }
    }

    public static final class State<T, K> extends AtomicInteger implements InterfaceC4478, InterfaceC2856<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final K key;
        public final GroupByObserver<?, K, T> parent;
        public final d<T> queue;
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final AtomicBoolean once = new AtomicBoolean();
        public final AtomicReference<InterfaceC5102<? super T>> actual = new AtomicReference<>();

        public State(int i, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.queue = new d<>(i);
            this.parent = groupByObserver;
            this.key = k;
            this.delayError = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.m6793(this.key);
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // defpackage.InterfaceC2856
        public void subscribe(InterfaceC5102<? super T> interfaceC5102) {
            if (!this.once.compareAndSet(false, true)) {
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), interfaceC5102);
                return;
            }
            interfaceC5102.onSubscribe(this);
            this.actual.lazySet(interfaceC5102);
            if (this.cancelled.get()) {
                this.actual.lazySet(null);
            } else {
                m6795();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6794(boolean z, boolean z2, InterfaceC5102<? super T> interfaceC5102, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.m6793(this.key);
                this.actual.lazySet(null);
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.error;
                this.actual.lazySet(null);
                if (th != null) {
                    interfaceC5102.onError(th);
                } else {
                    interfaceC5102.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                this.actual.lazySet(null);
                interfaceC5102.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            this.actual.lazySet(null);
            interfaceC5102.onComplete();
            return true;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6795() {
            if (getAndIncrement() != 0) {
                return;
            }
            d<T> dVar = this.queue;
            boolean z = this.delayError;
            InterfaceC5102<? super T> interfaceC5102 = this.actual.get();
            int iAddAndGet = 1;
            while (true) {
                if (interfaceC5102 != null) {
                    while (true) {
                        boolean z2 = this.done;
                        T tPoll = dVar.poll();
                        boolean z3 = tPoll == null;
                        if (m6794(z2, z3, interfaceC5102, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        } else {
                            interfaceC5102.onNext(tPoll);
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (interfaceC5102 == null) {
                    interfaceC5102 = this.actual.get();
                }
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6796() {
            this.done = true;
            m6795();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6797(Throwable th) {
            this.error = th;
            this.done = true;
            m6795();
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6798(T t) {
            this.queue.offer(t);
            m6795();
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableGroupBy$Ϳ, reason: contains not printable characters */
    public static final class C2076<K, T> extends AbstractC3101<K, T> {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final State<T, K> f7372;

        public C2076(K k, State<T, K> state) {
            super(k);
            this.f7372 = state;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static <T, K> C2076<K, T> m6799(K k, int i, GroupByObserver<?, K, T> groupByObserver, boolean z) {
            return new C2076<>(k, new State(i, groupByObserver, k, z));
        }

        public void onComplete() {
            this.f7372.m6796();
        }

        public void onError(Throwable th) {
            this.f7372.m6797(th);
        }

        public void onNext(T t) {
            this.f7372.m6798(t);
        }

        @Override // defpackage.AbstractC4262
        public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
            this.f7372.subscribe(interfaceC5102);
        }
    }

    public ObservableGroupBy(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, int i, boolean z) {
        super(interfaceC2856);
        this.f7367 = interfaceC2368;
        this.f7368 = interfaceC23682;
        this.f7369 = i;
        this.f7370 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super AbstractC3101<K, V>> interfaceC5102) {
        this.f11778.subscribe(new GroupByObserver(interfaceC5102, this.f7367, this.f7368, this.f7369, this.f7370));
    }
}
