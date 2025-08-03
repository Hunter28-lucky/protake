package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SingleAmb.java */
/* renamed from: ȹ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2546<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T>[] f9404;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Iterable<? extends InterfaceC3951<? extends T>> f9405;

    /* compiled from: SingleAmb.java */
    /* renamed from: ȹ$Ϳ, reason: contains not printable characters */
    public static final class C2547<T> implements InterfaceC4782<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C2527 f9406;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f9407;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final AtomicBoolean f9408;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public InterfaceC4478 f9409;

        public C2547(InterfaceC4782<? super T> interfaceC4782, C2527 c2527, AtomicBoolean atomicBoolean) {
            this.f9407 = interfaceC4782;
            this.f9406 = c2527;
            this.f9408 = atomicBoolean;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            if (!this.f9408.compareAndSet(false, true)) {
                C3671.m11803(th);
                return;
            }
            this.f9406.mo9335(this.f9409);
            this.f9406.dispose();
            this.f9407.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f9409 = interfaceC4478;
            this.f9406.mo9333(interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            if (this.f9408.compareAndSet(false, true)) {
                this.f9406.mo9335(this.f9409);
                this.f9406.dispose();
                this.f9407.onSuccess(t);
            }
        }
    }

    public C2546(InterfaceC3951<? extends T>[] interfaceC3951Arr, Iterable<? extends InterfaceC3951<? extends T>> iterable) {
        this.f9404 = interfaceC3951Arr;
        this.f9405 = iterable;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        int length;
        InterfaceC3951<? extends T>[] interfaceC3951Arr = this.f9404;
        if (interfaceC3951Arr == null) {
            interfaceC3951Arr = new InterfaceC3951[8];
            try {
                length = 0;
                for (InterfaceC3951<? extends T> interfaceC3951 : this.f9405) {
                    if (interfaceC3951 == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), interfaceC4782);
                        return;
                    }
                    if (length == interfaceC3951Arr.length) {
                        InterfaceC3951<? extends T>[] interfaceC3951Arr2 = new InterfaceC3951[(length >> 2) + length];
                        System.arraycopy(interfaceC3951Arr, 0, interfaceC3951Arr2, 0, length);
                        interfaceC3951Arr = interfaceC3951Arr2;
                    }
                    int i = length + 1;
                    interfaceC3951Arr[length] = interfaceC3951;
                    length = i;
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                EmptyDisposable.error(th, interfaceC4782);
                return;
            }
        } else {
            length = interfaceC3951Arr.length;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        C2527 c2527 = new C2527();
        interfaceC4782.onSubscribe(c2527);
        for (int i2 = 0; i2 < length; i2++) {
            InterfaceC3951<? extends T> interfaceC39512 = interfaceC3951Arr[i2];
            if (c2527.isDisposed()) {
                return;
            }
            if (interfaceC39512 == null) {
                c2527.dispose();
                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    interfaceC4782.onError(nullPointerException);
                    return;
                } else {
                    C3671.m11803(nullPointerException);
                    return;
                }
            }
            interfaceC39512.subscribe(new C2547(interfaceC4782, c2527, atomicBoolean));
        }
    }
}
