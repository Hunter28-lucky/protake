package defpackage;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* compiled from: BlockingFlowableNext.java */
/* renamed from: ˍ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2744<T> implements Iterable<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<? extends T> f10078;

    /* compiled from: BlockingFlowableNext.java */
    /* renamed from: ˍ$Ϳ, reason: contains not printable characters */
    public static final class C2745<T> implements Iterator<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C2746<T> f10079;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Publisher<? extends T> f10080;

        /* renamed from: ԭ, reason: contains not printable characters */
        public T f10081;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f10082 = true;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f10083 = true;

        /* renamed from: ՠ, reason: contains not printable characters */
        public Throwable f10084;

        /* renamed from: ֈ, reason: contains not printable characters */
        public boolean f10085;

        public C2745(Publisher<? extends T> publisher, C2746<T> c2746) {
            this.f10080 = publisher;
            this.f10079 = c2746;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f10084;
            if (th != null) {
                throw ExceptionHelper.m7024(th);
            }
            if (this.f10082) {
                return !this.f10083 || m10002();
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f10084;
            if (th != null) {
                throw ExceptionHelper.m7024(th);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f10083 = true;
            return this.f10081;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final boolean m10002() {
            try {
                if (!this.f10085) {
                    this.f10085 = true;
                    this.f10079.m10004();
                    AbstractC3630.fromPublisher(this.f10080).materialize().subscribe((InterfaceC3899<? super C3906<T>>) this.f10079);
                }
                C3906<T> c3906M10005 = this.f10079.m10005();
                if (c3906M10005.m12652()) {
                    this.f10083 = false;
                    this.f10081 = c3906M10005.m12649();
                    return true;
                }
                this.f10082 = false;
                if (c3906M10005.m12650()) {
                    return false;
                }
                if (!c3906M10005.m12651()) {
                    throw new IllegalStateException("Should not reach here");
                }
                Throwable thM12648 = c3906M10005.m12648();
                this.f10084 = thM12648;
                throw ExceptionHelper.m7024(thM12648);
            } catch (InterruptedException e2) {
                this.f10079.dispose();
                this.f10084 = e2;
                throw ExceptionHelper.m7024(e2);
            }
        }
    }

    /* compiled from: BlockingFlowableNext.java */
    /* renamed from: ˍ$Ԩ, reason: contains not printable characters */
    public static final class C2746<T> extends AbstractC2399<C3906<T>> {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final BlockingQueue<C3906<T>> f10086 = new ArrayBlockingQueue(1);

        /* renamed from: ԭ, reason: contains not printable characters */
        public final AtomicInteger f10087 = new AtomicInteger();

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            C3671.m11803(th);
        }

        @Override // org.reactivestreams.Subscriber
        /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onNext(C3906<T> c3906) {
            if (this.f10087.getAndSet(0) == 1 || !c3906.m12652()) {
                while (!this.f10086.offer(c3906)) {
                    C3906<T> c3906Poll = this.f10086.poll();
                    if (c3906Poll != null && !c3906Poll.m12652()) {
                        c3906 = c3906Poll;
                    }
                }
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m10004() {
            this.f10087.set(1);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public C3906<T> m10005() throws InterruptedException {
            m10004();
            C2336.m8748();
            return this.f10086.take();
        }
    }

    public C2744(Publisher<? extends T> publisher) {
        this.f10078 = publisher;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new C2745(this.f10078, new C2746());
    }
}
