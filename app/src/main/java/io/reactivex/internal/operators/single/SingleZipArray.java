package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.C2109;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleZipArray<T, R> extends AbstractC4838<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T>[] f7632;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Object[], ? extends R> f7633;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements InterfaceC4478 {
        private static final long serialVersionUID = -5556924161382950569L;
        public final InterfaceC4782<? super R> downstream;
        public final ZipSingleObserver<T>[] observers;
        public final Object[] values;
        public final InterfaceC2368<? super Object[], ? extends R> zipper;

        public ZipCoordinator(InterfaceC4782<? super R> interfaceC4782, int i, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
            super(i);
            this.downstream = interfaceC4782;
            this.zipper = interfaceC2368;
            ZipSingleObserver<T>[] zipSingleObserverArr = new ZipSingleObserver[i];
            for (int i2 = 0; i2 < i; i2++) {
                zipSingleObserverArr[i2] = new ZipSingleObserver<>(this, i2);
            }
            this.observers = zipSingleObserverArr;
            this.values = new Object[i];
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipSingleObserver<T> zipSingleObserver : this.observers) {
                    zipSingleObserver.m6968();
                }
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() <= 0;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6965(int i) {
            ZipSingleObserver<T>[] zipSingleObserverArr = this.observers;
            int length = zipSingleObserverArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                zipSingleObserverArr[i2].m6968();
            }
            while (true) {
                i++;
                if (i >= length) {
                    return;
                } else {
                    zipSingleObserverArr[i].m6968();
                }
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6966(Throwable th, int i) {
            if (getAndSet(0) <= 0) {
                C3671.m11803(th);
            } else {
                m6965(i);
                this.downstream.onError(th);
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6967(T t, int i) {
            this.values[i] = t;
            if (decrementAndGet() == 0) {
                try {
                    this.downstream.onSuccess(C4246.m13353(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.downstream.onError(th);
                }
            }
        }
    }

    public static final class ZipSingleObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        public final int index;
        public final ZipCoordinator<T, ?> parent;

        public ZipSingleObserver(ZipCoordinator<T, ?> zipCoordinator, int i) {
            this.parent = zipCoordinator;
            this.index = i;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.parent.m6966(th, this.index);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.parent.m6967(t, this.index);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6968() {
            DisposableHelper.dispose(this);
        }
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleZipArray$Ϳ, reason: contains not printable characters */
    public final class C2108 implements InterfaceC2368<T, R> {
        public C2108() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // defpackage.InterfaceC2368
        public R apply(T t) throws Exception {
            return (R) C4246.m13353(SingleZipArray.this.f7633.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    public SingleZipArray(InterfaceC3951<? extends T>[] interfaceC3951Arr, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        this.f7632 = interfaceC3951Arr;
        this.f7633 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super R> interfaceC4782) {
        InterfaceC3951<? extends T>[] interfaceC3951Arr = this.f7632;
        int length = interfaceC3951Arr.length;
        if (length == 1) {
            interfaceC3951Arr[0].subscribe(new C2109.C2110(interfaceC4782, new C2108()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(interfaceC4782, length, this.f7633);
        interfaceC4782.onSubscribe(zipCoordinator);
        for (int i = 0; i < length && !zipCoordinator.isDisposed(); i++) {
            InterfaceC3951<? extends T> interfaceC3951 = interfaceC3951Arr[i];
            if (interfaceC3951 == null) {
                zipCoordinator.m6966(new NullPointerException("One of the sources is null"), i);
                return;
            }
            interfaceC3951.subscribe(zipCoordinator.observers[i]);
        }
    }
}
