package com.jakewharton.rxrelay2;

import defpackage.AbstractC4585;
import defpackage.C4905;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ReplayRelay<T> extends Relay<T> {
    public static final ReplayDisposable[] EMPTY = new ReplayDisposable[0];
    private static final Object[] EMPTY_ARRAY = new Object[0];
    public final ReplayBuffer<T> buffer;
    public final AtomicReference<ReplayDisposable<T>[]> observers = new AtomicReference<>(EMPTY);

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        public final T value;

        public Node(T t) {
            this.value = t;
        }
    }

    public interface ReplayBuffer<T> {
        void add(T t);

        T getValue();

        T[] getValues(T[] tArr);

        void replay(ReplayDisposable<T> replayDisposable);

        int size();

        void trimHead();
    }

    public static final class ReplayDisposable<T> extends AtomicInteger implements InterfaceC4478 {
        private static final long serialVersionUID = 466549804534799122L;
        public volatile boolean cancelled;
        public final InterfaceC5102<? super T> downstream;
        public Object index;
        public final ReplayRelay<T> state;

        public ReplayDisposable(InterfaceC5102<? super T> interfaceC5102, ReplayRelay<T> replayRelay) {
            this.downstream = interfaceC5102;
            this.state = replayRelay;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.remove(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        public volatile TimedNode<T> head;
        public final long maxAge;
        public final int maxSize;
        public final AbstractC4585 scheduler;
        public int size;
        public TimedNode<T> tail;
        public final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            if (i <= 0) {
                throw new IllegalArgumentException("maxSize > 0 required but it was " + i);
            }
            if (j <= 0) {
                throw new IllegalArgumentException("maxAge > 0 required but it was " + j);
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (abstractC4585 == null) {
                throw new NullPointerException("scheduler == null");
            }
            this.maxSize = i;
            this.maxAge = j;
            this.unit = timeUnit;
            this.scheduler = abstractC4585;
            TimedNode<T> timedNode = new TimedNode<>(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public void add(T t) {
            TimedNode<T> timedNode = new TimedNode<>(t, this.scheduler.m14050(this.unit));
            TimedNode<T> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            trim();
        }

        public TimedNode<T> getHead() {
            TimedNode<T> timedNode;
            TimedNode<T> timedNode2 = this.head;
            long jM14050 = this.scheduler.m14050(this.unit) - this.maxAge;
            TimedNode<T> timedNode3 = timedNode2.get();
            while (true) {
                TimedNode<T> timedNode4 = timedNode3;
                timedNode = timedNode2;
                timedNode2 = timedNode4;
                if (timedNode2 == null || timedNode2.time > jM14050) {
                    break;
                }
                timedNode3 = timedNode2.get();
            }
            return timedNode;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public T getValue() {
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    break;
                }
                timedNode = timedNode2;
            }
            if (timedNode.time < this.scheduler.m14050(this.unit) - this.maxAge) {
                return null;
            }
            return timedNode.value;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public T[] getValues(T[] tArr) {
            TimedNode<T> head = getHead();
            int size = size(head);
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i = 0; i != size; i++) {
                    head = head.get();
                    tArr[i] = head.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            InterfaceC5102<? super T> interfaceC5102 = replayDisposable.downstream;
            TimedNode<T> head = (TimedNode) replayDisposable.index;
            if (head == null) {
                head = getHead();
            }
            while (!replayDisposable.cancelled) {
                while (!replayDisposable.cancelled) {
                    TimedNode<T> timedNode = head.get();
                    if (timedNode != null) {
                        interfaceC5102.onNext(timedNode.value);
                        head = timedNode;
                    } else if (head.get() == null) {
                        replayDisposable.index = head;
                        iAddAndGet = replayDisposable.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
                return;
            }
            replayDisposable.index = null;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public int size() {
            return size(getHead());
        }

        public void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = this.head.get();
            }
            long jM14050 = this.scheduler.m14050(this.unit) - this.maxAge;
            TimedNode<T> timedNode = this.head;
            while (this.size > 1) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    this.head = timedNode;
                    return;
                } else if (timedNode2.time > jM14050) {
                    this.head = timedNode;
                    return;
                } else {
                    this.size--;
                    timedNode = timedNode2;
                }
            }
            this.head = timedNode;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public void trimHead() {
            TimedNode<T> timedNode = this.head;
            if (timedNode.value != null) {
                TimedNode<T> timedNode2 = new TimedNode<>(null, 0L);
                timedNode2.lazySet(timedNode.get());
                this.head = timedNode2;
            }
        }

        public int size(TimedNode<T> timedNode) {
            int i = 0;
            while (i != Integer.MAX_VALUE && (timedNode = timedNode.get()) != null) {
                i++;
            }
            return i;
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        public volatile Node<T> head;
        public final int maxSize;
        public int size;
        public Node<T> tail;

        public SizeBoundReplayBuffer(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("maxSize > 0 required but it was " + i);
            }
            this.maxSize = i;
            Node<T> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public void add(T t) {
            Node<T> node = new Node<>(t);
            Node<T> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            trim();
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public T getValue() {
            Node<T> node = this.head;
            while (true) {
                Node<T> node2 = node.get();
                if (node2 == null) {
                    return node.value;
                }
                node = node2;
            }
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public T[] getValues(T[] tArr) {
            Node<T> node = this.head;
            int size = size();
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i = 0; i != size; i++) {
                    node = node.get();
                    tArr[i] = node.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            InterfaceC5102<? super T> interfaceC5102 = replayDisposable.downstream;
            Node<T> node = (Node) replayDisposable.index;
            if (node == null) {
                node = this.head;
            }
            while (!replayDisposable.cancelled) {
                Node<T> node2 = node.get();
                if (node2 != null) {
                    interfaceC5102.onNext(node2.value);
                    node = node2;
                } else if (node.get() != null) {
                    continue;
                } else {
                    replayDisposable.index = node;
                    iAddAndGet = replayDisposable.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            replayDisposable.index = null;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public int size() {
            Node<T> node = this.head;
            int i = 0;
            while (i != Integer.MAX_VALUE && (node = node.get()) != null) {
                i++;
            }
            return i;
        }

        public void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = this.head.get();
            }
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public void trimHead() {
            Node<T> node = this.head;
            if (node.value != null) {
                Node<T> node2 = new Node<>(null);
                node2.lazySet(node.get());
                this.head = node2;
            }
        }
    }

    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        public final long time;
        public final T value;

        public TimedNode(T t, long j) {
            this.value = t;
            this.time = j;
        }
    }

    public static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -733876083048047795L;
        public final List<T> buffer;
        public volatile int size;

        public UnboundedReplayBuffer(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("capacityHint <= 0");
            }
            this.buffer = new ArrayList(i);
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public void add(T t) {
            this.buffer.add(t);
            this.size++;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public T getValue() {
            int i = this.size;
            if (i != 0) {
                return this.buffer.get(i - 1);
            }
            return null;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public T[] getValues(T[] tArr) {
            int i = this.size;
            if (i == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            List<T> list = this.buffer;
            for (int i2 = 0; i2 < i; i2++) {
                tArr[i2] = list.get(i2);
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            List<T> list = this.buffer;
            InterfaceC5102<? super T> interfaceC5102 = replayDisposable.downstream;
            Integer num = (Integer) replayDisposable.index;
            int iIntValue = 0;
            int iAddAndGet = 1;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                replayDisposable.index = 0;
            }
            while (!replayDisposable.cancelled) {
                int i = this.size;
                while (i != iIntValue) {
                    if (replayDisposable.cancelled) {
                        replayDisposable.index = null;
                        return;
                    } else {
                        interfaceC5102.onNext(list.get(iIntValue));
                        iIntValue++;
                    }
                }
                if (iIntValue == this.size) {
                    replayDisposable.index = Integer.valueOf(iIntValue);
                    iAddAndGet = replayDisposable.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            replayDisposable.index = null;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public int size() {
            return this.size;
        }

        @Override // com.jakewharton.rxrelay2.ReplayRelay.ReplayBuffer
        public void trimHead() {
        }
    }

    public ReplayRelay(ReplayBuffer<T> replayBuffer) {
        this.buffer = replayBuffer;
    }

    public static <T> ReplayRelay<T> create() {
        return new ReplayRelay<>(new UnboundedReplayBuffer(16));
    }

    public static <T> ReplayRelay<T> createUnbounded() {
        return new ReplayRelay<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    public static <T> ReplayRelay<T> createWithSize(int i) {
        return new ReplayRelay<>(new SizeBoundReplayBuffer(i));
    }

    public static <T> ReplayRelay<T> createWithTime(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return new ReplayRelay<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j, timeUnit, abstractC4585));
    }

    public static <T> ReplayRelay<T> createWithTimeAndSize(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i) {
        return new ReplayRelay<>(new SizeAndTimeBoundReplayBuffer(i, j, timeUnit, abstractC4585));
    }

    @Override // com.jakewharton.rxrelay2.Relay, defpackage.InterfaceC2857
    public void accept(T t) {
        if (t == null) {
            throw new NullPointerException("value == null");
        }
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.add(t);
        for (ReplayDisposable<T> replayDisposable : this.observers.get()) {
            replayBuffer.replay(replayDisposable);
        }
    }

    public boolean add(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = this.observers.get();
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new ReplayDisposable[length + 1];
            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!C4905.m14631(this.observers, replayDisposableArr, replayDisposableArr2));
        return true;
    }

    public void cleanupBuffer() {
        this.buffer.trimHead();
    }

    public T getValue() {
        return this.buffer.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    @Override // com.jakewharton.rxrelay2.Relay
    public boolean hasObservers() {
        return this.observers.get().length != 0;
    }

    public boolean hasValue() {
        return this.buffer.size() != 0;
    }

    public int observerCount() {
        return this.observers.get().length;
    }

    public void remove(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = this.observers.get();
            if (replayDisposableArr == EMPTY) {
                return;
            }
            int length = replayDisposableArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (replayDisposableArr[i2] == replayDisposable) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                replayDisposableArr2 = EMPTY;
            } else {
                ReplayDisposable[] replayDisposableArr3 = new ReplayDisposable[length - 1];
                System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i);
                System.arraycopy(replayDisposableArr, i + 1, replayDisposableArr3, i, (length - i) - 1);
                replayDisposableArr2 = replayDisposableArr3;
            }
        } while (!C4905.m14631(this.observers, replayDisposableArr, replayDisposableArr2));
    }

    public int size() {
        return this.buffer.size();
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        ReplayDisposable<T> replayDisposable = new ReplayDisposable<>(interfaceC5102, this);
        interfaceC5102.onSubscribe(replayDisposable);
        if (replayDisposable.cancelled) {
            return;
        }
        if (add(replayDisposable) && replayDisposable.cancelled) {
            remove(replayDisposable);
        } else {
            this.buffer.replay(replayDisposable);
        }
    }

    public static <T> ReplayRelay<T> create(int i) {
        return new ReplayRelay<>(new UnboundedReplayBuffer(i));
    }

    public T[] getValues(T[] tArr) {
        return this.buffer.getValues(tArr);
    }
}
