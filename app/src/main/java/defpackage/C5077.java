package defpackage;

import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: BlockingFlowableMostRecent.java */
/* renamed from: ྋ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5077<T> implements Iterable<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f16866;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final T f16867;

    /* compiled from: BlockingFlowableMostRecent.java */
    /* renamed from: ྋ$Ϳ, reason: contains not printable characters */
    public static final class C5078<T> extends AbstractC2496<T> {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public volatile Object f16868;

        /* compiled from: BlockingFlowableMostRecent.java */
        /* renamed from: ྋ$Ϳ$Ϳ, reason: contains not printable characters */
        public final class C5079 implements Iterator<T> {

            /* renamed from: ԫ, reason: contains not printable characters */
            public Object f16869;

            public C5079() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f16869 = C5078.this.f16868;
                return !NotificationLite.isComplete(r0);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f16869 == null) {
                        this.f16869 = C5078.this.f16868;
                    }
                    if (NotificationLite.isComplete(this.f16869)) {
                        throw new NoSuchElementException();
                    }
                    if (NotificationLite.isError(this.f16869)) {
                        throw ExceptionHelper.m7024(NotificationLite.getError(this.f16869));
                    }
                    return (T) NotificationLite.getValue(this.f16869);
                } finally {
                    this.f16869 = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        public C5078(T t) {
            this.f16868 = NotificationLite.next(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f16868 = NotificationLite.complete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f16868 = NotificationLite.error(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f16868 = NotificationLite.next(t);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public C5078<T>.C5079 m14906() {
            return new C5079();
        }
    }

    public C5077(AbstractC3630<T> abstractC3630, T t) {
        this.f16866 = abstractC3630;
        this.f16867 = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        C5078 c5078 = new C5078(this.f16867);
        this.f16866.subscribe((InterfaceC3899) c5078);
        return c5078.m14906();
    }
}
