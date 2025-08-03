package defpackage;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BlockingObservableNext.java */
/* renamed from: ഽ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4743<T> implements Iterable<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f16010;

    /* compiled from: BlockingObservableNext.java */
    /* renamed from: ഽ$Ϳ, reason: contains not printable characters */
    public static final class C4744<T> implements Iterator<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C4745<T> f16011;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2856<T> f16012;

        /* renamed from: ԭ, reason: contains not printable characters */
        public T f16013;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f16014 = true;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f16015 = true;

        /* renamed from: ՠ, reason: contains not printable characters */
        public Throwable f16016;

        /* renamed from: ֈ, reason: contains not printable characters */
        public boolean f16017;

        public C4744(InterfaceC2856<T> interfaceC2856, C4745<T> c4745) {
            this.f16012 = interfaceC2856;
            this.f16011 = c4745;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f16016;
            if (th != null) {
                throw ExceptionHelper.m7024(th);
            }
            if (this.f16014) {
                return !this.f16015 || m14285();
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f16016;
            if (th != null) {
                throw ExceptionHelper.m7024(th);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f16015 = true;
            return this.f16013;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final boolean m14285() {
            if (!this.f16017) {
                this.f16017 = true;
                this.f16011.m14287();
                new C3878(this.f16012).subscribe(this.f16011);
            }
            try {
                C3906<T> c3906M14288 = this.f16011.m14288();
                if (c3906M14288.m12652()) {
                    this.f16015 = false;
                    this.f16013 = c3906M14288.m12649();
                    return true;
                }
                this.f16014 = false;
                if (c3906M14288.m12650()) {
                    return false;
                }
                Throwable thM12648 = c3906M14288.m12648();
                this.f16016 = thM12648;
                throw ExceptionHelper.m7024(thM12648);
            } catch (InterruptedException e2) {
                this.f16011.dispose();
                this.f16016 = e2;
                throw ExceptionHelper.m7024(e2);
            }
        }
    }

    /* compiled from: BlockingObservableNext.java */
    /* renamed from: ഽ$Ԩ, reason: contains not printable characters */
    public static final class C4745<T> extends AbstractC5105<C3906<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final BlockingQueue<C3906<T>> f16018 = new ArrayBlockingQueue(1);

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AtomicInteger f16019 = new AtomicInteger();

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            C3671.m11803(th);
        }

        @Override // defpackage.InterfaceC5102
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onNext(C3906<T> c3906) {
            if (this.f16019.getAndSet(0) == 1 || !c3906.m12652()) {
                while (!this.f16018.offer(c3906)) {
                    C3906<T> c3906Poll = this.f16018.poll();
                    if (c3906Poll != null && !c3906Poll.m12652()) {
                        c3906 = c3906Poll;
                    }
                }
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m14287() {
            this.f16019.set(1);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public C3906<T> m14288() throws InterruptedException {
            m14287();
            C2336.m8748();
            return this.f16018.take();
        }
    }

    public C4743(InterfaceC2856<T> interfaceC2856) {
        this.f16010 = interfaceC2856;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new C4744(this.f16010, new C4745());
    }
}
