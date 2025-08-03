package defpackage;

import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: BlockingObservableMostRecent.java */
/* renamed from: ӏ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3103<T> implements Iterable<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f11045;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final T f11046;

    /* compiled from: BlockingObservableMostRecent.java */
    /* renamed from: ӏ$Ϳ, reason: contains not printable characters */
    public static final class C3104<T> extends AbstractC3525<T> {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public volatile Object f11047;

        /* compiled from: BlockingObservableMostRecent.java */
        /* renamed from: ӏ$Ϳ$Ϳ, reason: contains not printable characters */
        public final class C3105 implements Iterator<T> {

            /* renamed from: ԫ, reason: contains not printable characters */
            public Object f11048;

            public C3105() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f11048 = C3104.this.f11047;
                return !NotificationLite.isComplete(r0);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f11048 == null) {
                        this.f11048 = C3104.this.f11047;
                    }
                    if (NotificationLite.isComplete(this.f11048)) {
                        throw new NoSuchElementException();
                    }
                    if (NotificationLite.isError(this.f11048)) {
                        throw ExceptionHelper.m7024(NotificationLite.getError(this.f11048));
                    }
                    return (T) NotificationLite.getValue(this.f11048);
                } finally {
                    this.f11048 = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        public C3104(T t) {
            this.f11047 = NotificationLite.next(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f11047 = NotificationLite.complete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f11047 = NotificationLite.error(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f11047 = NotificationLite.next(t);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public C3104<T>.C3105 m10694() {
            return new C3105();
        }
    }

    public C3103(InterfaceC2856<T> interfaceC2856, T t) {
        this.f11045 = interfaceC2856;
        this.f11046 = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        C3104 c3104 = new C3104(this.f11046);
        this.f11045.subscribe(c3104);
        return c3104.m10694();
    }
}
