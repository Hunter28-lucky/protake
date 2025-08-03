package defpackage;

import defpackage.C4741;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: BehaviorSubject.java */
/* renamed from: ႎ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5190<T> extends k0<T> {

    /* renamed from: ֏, reason: contains not printable characters */
    public static final Object[] f17212 = new Object[0];

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final C5191[] f17213 = new C5191[0];

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final C5191[] f17214 = new C5191[0];

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AtomicReference<Object> f17215;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AtomicReference<C5191<T>[]> f17216;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final ReadWriteLock f17217;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Lock f17218;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final Lock f17219;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final AtomicReference<Throwable> f17220;

    /* renamed from: ֈ, reason: contains not printable characters */
    public long f17221;

    /* compiled from: BehaviorSubject.java */
    /* renamed from: ႎ$Ϳ, reason: contains not printable characters */
    public static final class C5191<T> implements InterfaceC4478, C4741.InterfaceC4742<Object> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f17222;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C5190<T> f17223;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f17224;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f17225;

        /* renamed from: ԯ, reason: contains not printable characters */
        public C4741<Object> f17226;

        /* renamed from: ՠ, reason: contains not printable characters */
        public boolean f17227;

        /* renamed from: ֈ, reason: contains not printable characters */
        public volatile boolean f17228;

        /* renamed from: ֏, reason: contains not printable characters */
        public long f17229;

        public C5191(InterfaceC5102<? super T> interfaceC5102, C5190<T> c5190) {
            this.f17222 = interfaceC5102;
            this.f17223 = c5190;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.f17228) {
                return;
            }
            this.f17228 = true;
            this.f17223.m15162(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f17228;
        }

        @Override // defpackage.C4741.InterfaceC4742, defpackage.InterfaceC4178
        public boolean test(Object obj) {
            return this.f17228 || NotificationLite.accept(obj, this.f17222);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m15164() {
            if (this.f17228) {
                return;
            }
            synchronized (this) {
                if (this.f17228) {
                    return;
                }
                if (this.f17224) {
                    return;
                }
                C5190<T> c5190 = this.f17223;
                Lock lock = c5190.f17218;
                lock.lock();
                this.f17229 = c5190.f17221;
                Object obj = c5190.f17215.get();
                lock.unlock();
                this.f17225 = obj != null;
                this.f17224 = true;
                if (obj == null || test(obj)) {
                    return;
                }
                m15165();
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m15165() {
            C4741<Object> c4741;
            while (!this.f17228) {
                synchronized (this) {
                    c4741 = this.f17226;
                    if (c4741 == null) {
                        this.f17225 = false;
                        return;
                    }
                    this.f17226 = null;
                }
                c4741.m14283(this);
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m15166(Object obj, long j) {
            if (this.f17228) {
                return;
            }
            if (!this.f17227) {
                synchronized (this) {
                    if (this.f17228) {
                        return;
                    }
                    if (this.f17229 == j) {
                        return;
                    }
                    if (this.f17225) {
                        C4741<Object> c4741 = this.f17226;
                        if (c4741 == null) {
                            c4741 = new C4741<>(4);
                            this.f17226 = c4741;
                        }
                        c4741.m14282(obj);
                        return;
                    }
                    this.f17224 = true;
                    this.f17227 = true;
                }
            }
            test(obj);
        }
    }

    public C5190() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f17217 = reentrantReadWriteLock;
        this.f17218 = reentrantReadWriteLock.readLock();
        this.f17219 = reentrantReadWriteLock.writeLock();
        this.f17216 = new AtomicReference<>(f17213);
        this.f17215 = new AtomicReference<>();
        this.f17220 = new AtomicReference<>();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T> C5190<T> m15160() {
        return new C5190<>();
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        if (C4905.m14631(this.f17220, null, ExceptionHelper.f7687)) {
            Object objComplete = NotificationLite.complete();
            for (C5191<T> c5191 : m15163(objComplete)) {
                c5191.m15166(objComplete, this.f17221);
            }
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        C4246.m13353(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!C4905.m14631(this.f17220, null, th)) {
            C3671.m11803(th);
            return;
        }
        Object objError = NotificationLite.error(th);
        for (C5191<T> c5191 : m15163(objError)) {
            c5191.m15166(objError, this.f17221);
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        C4246.m13353(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f17220.get() != null) {
            return;
        }
        Object next = NotificationLite.next(t);
        setCurrent(next);
        for (C5191<T> c5191 : this.f17216.get()) {
            c5191.m15166(next, this.f17221);
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        if (this.f17220.get() != null) {
            interfaceC4478.dispose();
        }
    }

    public void setCurrent(Object obj) {
        this.f17219.lock();
        this.f17221++;
        this.f17215.lazySet(obj);
        this.f17219.unlock();
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        C5191<T> c5191 = new C5191<>(interfaceC5102, this);
        interfaceC5102.onSubscribe(c5191);
        if (m15161(c5191)) {
            if (c5191.f17228) {
                m15162(c5191);
                return;
            } else {
                c5191.m15164();
                return;
            }
        }
        Throwable th = this.f17220.get();
        if (th == ExceptionHelper.f7687) {
            interfaceC5102.onComplete();
        } else {
            interfaceC5102.onError(th);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean m15161(C5191<T> c5191) {
        C5191<T>[] c5191Arr;
        C5191[] c5191Arr2;
        do {
            c5191Arr = this.f17216.get();
            if (c5191Arr == f17214) {
                return false;
            }
            int length = c5191Arr.length;
            c5191Arr2 = new C5191[length + 1];
            System.arraycopy(c5191Arr, 0, c5191Arr2, 0, length);
            c5191Arr2[length] = c5191;
        } while (!C4905.m14631(this.f17216, c5191Arr, c5191Arr2));
        return true;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m15162(C5191<T> c5191) {
        C5191<T>[] c5191Arr;
        C5191[] c5191Arr2;
        do {
            c5191Arr = this.f17216.get();
            int length = c5191Arr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (c5191Arr[i2] == c5191) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                c5191Arr2 = f17213;
            } else {
                C5191[] c5191Arr3 = new C5191[length - 1];
                System.arraycopy(c5191Arr, 0, c5191Arr3, 0, i);
                System.arraycopy(c5191Arr, i + 1, c5191Arr3, i, (length - i) - 1);
                c5191Arr2 = c5191Arr3;
            }
        } while (!C4905.m14631(this.f17216, c5191Arr, c5191Arr2));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public C5191<T>[] m15163(Object obj) {
        AtomicReference<C5191<T>[]> atomicReference = this.f17216;
        C5191<T>[] c5191Arr = f17214;
        C5191<T>[] andSet = atomicReference.getAndSet(c5191Arr);
        if (andSet != c5191Arr) {
            setCurrent(obj);
        }
        return andSet;
    }
}
