package com.jakewharton.rxrelay2;

import com.jakewharton.rxrelay2.AppendOnlyLinkedArrayList;
import defpackage.C4905;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes2.dex */
public final class BehaviorRelay<T> extends Relay<T> {
    public long index;
    public final Lock readLock;
    public final AtomicReference<BehaviorDisposable<T>[]> subscribers;
    public final AtomicReference<T> value;
    public final Lock writeLock;
    private static final Object[] EMPTY_ARRAY = new Object[0];
    public static final BehaviorDisposable[] EMPTY = new BehaviorDisposable[0];

    public static final class BehaviorDisposable<T> implements InterfaceC4478, AppendOnlyLinkedArrayList.NonThrowingPredicate<T> {
        public volatile boolean cancelled;
        public final InterfaceC5102<? super T> downstream;
        public boolean emitting;
        public boolean fastPath;
        public long index;
        public boolean next;
        public AppendOnlyLinkedArrayList<T> queue;
        public final BehaviorRelay<T> state;

        public BehaviorDisposable(InterfaceC5102<? super T> interfaceC5102, BehaviorRelay<T> behaviorRelay) {
            this.downstream = interfaceC5102;
            this.state = behaviorRelay;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.remove(this);
        }

        public void emitFirst() {
            if (this.cancelled) {
                return;
            }
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (this.next) {
                    return;
                }
                BehaviorRelay<T> behaviorRelay = this.state;
                Lock lock = behaviorRelay.readLock;
                lock.lock();
                this.index = behaviorRelay.index;
                T t = behaviorRelay.value.get();
                lock.unlock();
                this.emitting = t != null;
                this.next = true;
                if (t != null) {
                    test(t);
                    emitLoop();
                }
            }
        }

        public void emitLoop() {
            AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList;
            while (!this.cancelled) {
                synchronized (this) {
                    appendOnlyLinkedArrayList = this.queue;
                    if (appendOnlyLinkedArrayList == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                }
                appendOnlyLinkedArrayList.forEachWhile(this);
            }
        }

        public void emitNext(T t, long j) {
            if (this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.index == j) {
                        return;
                    }
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(t);
                        return;
                    }
                    this.next = true;
                    this.fastPath = true;
                }
            }
            test(t);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // com.jakewharton.rxrelay2.AppendOnlyLinkedArrayList.NonThrowingPredicate, defpackage.InterfaceC4178
        public boolean test(T t) {
            if (this.cancelled) {
                return false;
            }
            this.downstream.onNext(t);
            return false;
        }
    }

    public BehaviorRelay() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.subscribers = new AtomicReference<>(EMPTY);
        this.value = new AtomicReference<>();
    }

    public static <T> BehaviorRelay<T> create() {
        return new BehaviorRelay<>();
    }

    public static <T> BehaviorRelay<T> createDefault(T t) {
        return new BehaviorRelay<>(t);
    }

    @Override // com.jakewharton.rxrelay2.Relay, defpackage.InterfaceC2857
    public void accept(T t) {
        if (t == null) {
            throw new NullPointerException("value == null");
        }
        setCurrent(t);
        for (BehaviorDisposable<T> behaviorDisposable : this.subscribers.get()) {
            behaviorDisposable.emitNext(t, this.index);
        }
    }

    public void add(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.subscribers.get();
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new BehaviorDisposable[length + 1];
            System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!C4905.m14631(this.subscribers, behaviorDisposableArr, behaviorDisposableArr2));
    }

    public T getValue() {
        return this.value.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    @Override // com.jakewharton.rxrelay2.Relay
    public boolean hasObservers() {
        return this.subscribers.get().length != 0;
    }

    public boolean hasValue() {
        return this.value.get() != null;
    }

    public void remove(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.subscribers.get();
            int length = behaviorDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (behaviorDisposableArr[i2] == behaviorDisposable) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                behaviorDisposableArr2 = EMPTY;
            } else {
                BehaviorDisposable[] behaviorDisposableArr3 = new BehaviorDisposable[length - 1];
                System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i);
                System.arraycopy(behaviorDisposableArr, i + 1, behaviorDisposableArr3, i, (length - i) - 1);
                behaviorDisposableArr2 = behaviorDisposableArr3;
            }
        } while (!C4905.m14631(this.subscribers, behaviorDisposableArr, behaviorDisposableArr2));
    }

    public void setCurrent(T t) {
        this.writeLock.lock();
        this.index++;
        this.value.lazySet(t);
        this.writeLock.unlock();
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        BehaviorDisposable<T> behaviorDisposable = new BehaviorDisposable<>(interfaceC5102, this);
        interfaceC5102.onSubscribe(behaviorDisposable);
        add(behaviorDisposable);
        if (behaviorDisposable.cancelled) {
            remove(behaviorDisposable);
        } else {
            behaviorDisposable.emitFirst();
        }
    }

    public int subscriberCount() {
        return this.subscribers.get().length;
    }

    @Deprecated
    public T[] getValues(T[] tArr) {
        T t = this.value.get();
        if (t == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length != 0) {
            tArr[0] = t;
            if (tArr.length == 1) {
                return tArr;
            }
            tArr[1] = null;
            return tArr;
        }
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
        tArr2[0] = t;
        return tArr2;
    }

    public BehaviorRelay(T t) {
        this();
        if (t != null) {
            this.value.lazySet(t);
            return;
        }
        throw new NullPointerException("defaultValue == null");
    }
}
