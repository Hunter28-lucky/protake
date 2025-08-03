package defpackage;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BlockingObservableLatest.java */
/* renamed from: ו, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3271<T> implements Iterable<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f11453;

    /* compiled from: BlockingObservableLatest.java */
    /* renamed from: ו$Ϳ, reason: contains not printable characters */
    public static final class C3272<T> extends AbstractC5105<C3906<T>> implements Iterator<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public C3906<T> f11454;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Semaphore f11455 = new Semaphore(0);

        /* renamed from: ԭ, reason: contains not printable characters */
        public final AtomicReference<C3906<T>> f11456 = new AtomicReference<>();

        @Override // java.util.Iterator
        public boolean hasNext() throws InterruptedException {
            C3906<T> c3906 = this.f11454;
            if (c3906 != null && c3906.m12651()) {
                throw ExceptionHelper.m7024(this.f11454.m12648());
            }
            if (this.f11454 == null) {
                try {
                    C2336.m8748();
                    this.f11455.acquire();
                    C3906<T> andSet = this.f11456.getAndSet(null);
                    this.f11454 = andSet;
                    if (andSet.m12651()) {
                        throw ExceptionHelper.m7024(andSet.m12648());
                    }
                } catch (InterruptedException e2) {
                    dispose();
                    this.f11454 = C3906.m12646(e2);
                    throw ExceptionHelper.m7024(e2);
                }
            }
            return this.f11454.m12652();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tM12649 = this.f11454.m12649();
            this.f11454 = null;
            return tM12649;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            C3671.m11803(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }

        @Override // defpackage.InterfaceC5102
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onNext(C3906<T> c3906) {
            if (this.f11456.getAndSet(c3906) == null) {
                this.f11455.release();
            }
        }
    }

    public C3271(InterfaceC2856<T> interfaceC2856) {
        this.f11453 = interfaceC2856;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        C3272 c3272 = new C3272();
        AbstractC4262.wrap(this.f11453).materialize().subscribe(c3272);
        return c3272;
    }
}
