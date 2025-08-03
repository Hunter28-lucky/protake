package io.reactivex.internal.operators.observable;

import defpackage.C2336;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public final class BlockingObservableIterable<T> implements Iterable<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<? extends T> f7292;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f7293;

    public static final class BlockingObservableIterator<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T>, Iterator<T>, InterfaceC4478 {
        private static final long serialVersionUID = 6695226475494099826L;
        public final Condition condition;
        public volatile boolean done;
        public volatile Throwable error;
        public final Lock lock;
        public final d<T> queue;

        public BlockingObservableIterator(int i) {
            this.queue = new d<>(i);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
            m6729();
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
                try {
                    C2336.m8748();
                    this.lock.lock();
                    while (!this.done && this.queue.isEmpty() && !isDisposed()) {
                        try {
                            this.condition.await();
                        } finally {
                        }
                    }
                    this.lock.unlock();
                } catch (InterruptedException e2) {
                    DisposableHelper.dispose(this);
                    m6729();
                    throw ExceptionHelper.m7024(e2);
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
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.queue.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.done = true;
            m6729();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            m6729();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.queue.offer(t);
            m6729();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6729() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public BlockingObservableIterable(InterfaceC2856<? extends T> interfaceC2856, int i) {
        this.f7292 = interfaceC2856;
        this.f7293 = i;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.f7293);
        this.f7292.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
