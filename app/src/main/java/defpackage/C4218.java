package defpackage;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

/* compiled from: BlockingFlowableLatest.java */
/* renamed from: ৲, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4218<T> implements Iterable<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<? extends T> f14508;

    /* compiled from: BlockingFlowableLatest.java */
    /* renamed from: ৲$Ϳ, reason: contains not printable characters */
    public static final class C4219<T> extends AbstractC2399<C3906<T>> implements Iterator<T> {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Semaphore f14509 = new Semaphore(0);

        /* renamed from: ԭ, reason: contains not printable characters */
        public final AtomicReference<C3906<T>> f14510 = new AtomicReference<>();

        /* renamed from: Ԯ, reason: contains not printable characters */
        public C3906<T> f14511;

        @Override // java.util.Iterator
        public boolean hasNext() throws InterruptedException {
            C3906<T> c3906 = this.f14511;
            if (c3906 != null && c3906.m12651()) {
                throw ExceptionHelper.m7024(this.f14511.m12648());
            }
            C3906<T> c39062 = this.f14511;
            if ((c39062 == null || c39062.m12652()) && this.f14511 == null) {
                try {
                    C2336.m8748();
                    this.f14509.acquire();
                    C3906<T> andSet = this.f14510.getAndSet(null);
                    this.f14511 = andSet;
                    if (andSet.m12651()) {
                        throw ExceptionHelper.m7024(andSet.m12648());
                    }
                } catch (InterruptedException e2) {
                    dispose();
                    this.f14511 = C3906.m12646(e2);
                    throw ExceptionHelper.m7024(e2);
                }
            }
            return this.f14511.m12652();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext() || !this.f14511.m12652()) {
                throw new NoSuchElementException();
            }
            T tM12649 = this.f14511.m12649();
            this.f14511 = null;
            return tM12649;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            C3671.m11803(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }

        @Override // org.reactivestreams.Subscriber
        /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onNext(C3906<T> c3906) {
            if (this.f14510.getAndSet(c3906) == null) {
                this.f14509.release();
            }
        }
    }

    public C4218(Publisher<? extends T> publisher) {
        this.f14508 = publisher;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        C4219 c4219 = new C4219();
        AbstractC3630.fromPublisher(this.f14508).materialize().subscribe((InterfaceC3899<? super C3906<T>>) c4219);
        return c4219;
    }
}
