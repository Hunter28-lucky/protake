package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C2336;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class BlockingFlowableIterable<T> implements Iterable<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f6851;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f6852;

    public static final class BlockingFlowableIterator<T> extends AtomicReference<Subscription> implements InterfaceC3899<T>, Iterator<T>, Runnable, InterfaceC4478 {
        private static final long serialVersionUID = 6695226475494099826L;
        public final long batchSize;
        public final Condition condition;
        public volatile boolean done;
        public volatile Throwable error;
        public final long limit;
        public final Lock lock;
        public long produced;
        public final SpscArrayQueue<T> queue;

        public BlockingFlowableIterator(int i) {
            this.queue = new SpscArrayQueue<>(i);
            this.batchSize = i;
            this.limit = i - (i >> 2);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            SubscriptionHelper.cancel(this);
            m6375();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!isDisposed()) {
                boolean z = this.done;
                boolean zIsEmpty = this.queue.isEmpty();
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        throw ExceptionHelper.m7024(th);
                    }
                    if (zIsEmpty) {
                        return false;
                    }
                }
                if (!zIsEmpty) {
                    return true;
                }
                C2336.m8748();
                this.lock.lock();
                while (!this.done && this.queue.isEmpty() && !isDisposed()) {
                    try {
                        try {
                            this.condition.await();
                        } catch (InterruptedException e2) {
                            run();
                            throw ExceptionHelper.m7024(e2);
                        }
                    } finally {
                        this.lock.unlock();
                    }
                }
            }
            Throwable th2 = this.error;
            if (th2 == null) {
                return false;
            }
            throw ExceptionHelper.m7024(th2);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tPoll = this.queue.poll();
            long j = this.produced + 1;
            if (j == this.limit) {
                this.produced = 0L;
                get().request(j);
            } else {
                this.produced = j;
            }
            return tPoll;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            m6375();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            m6375();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                m6375();
            } else {
                SubscriptionHelper.cancel(this);
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, this.batchSize);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.lang.Runnable
        public void run() {
            SubscriptionHelper.cancel(this);
            m6375();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6375() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public BlockingFlowableIterable(AbstractC3630<T> abstractC3630, int i) {
        this.f6851 = abstractC3630;
        this.f6852 = i;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingFlowableIterator blockingFlowableIterator = new BlockingFlowableIterator(this.f6852);
        this.f6851.subscribe((InterfaceC3899) blockingFlowableIterator);
        return blockingFlowableIterator;
    }
}
