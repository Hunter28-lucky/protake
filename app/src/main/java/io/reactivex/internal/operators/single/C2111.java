package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.single.C2109;
import io.reactivex.internal.operators.single.SingleZipArray;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* compiled from: SingleZipIterable.java */
/* renamed from: io.reactivex.internal.operators.single.Ԩ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2111<T, R> extends AbstractC4838<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Iterable<? extends InterfaceC3951<? extends T>> f7639;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Object[], ? extends R> f7640;

    /* compiled from: SingleZipIterable.java */
    /* renamed from: io.reactivex.internal.operators.single.Ԩ$Ϳ, reason: contains not printable characters */
    public final class C2112 implements InterfaceC2368<T, R> {
        public C2112() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // defpackage.InterfaceC2368
        public R apply(T t) throws Exception {
            return (R) C4246.m13353(C2111.this.f7640.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    public C2111(Iterable<? extends InterfaceC3951<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        this.f7639 = iterable;
        this.f7640 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super R> interfaceC4782) {
        InterfaceC3951[] interfaceC3951Arr = new InterfaceC3951[8];
        try {
            int i = 0;
            for (InterfaceC3951<? extends T> interfaceC3951 : this.f7639) {
                if (interfaceC3951 == null) {
                    EmptyDisposable.error(new NullPointerException("One of the sources is null"), interfaceC4782);
                    return;
                }
                if (i == interfaceC3951Arr.length) {
                    interfaceC3951Arr = (InterfaceC3951[]) Arrays.copyOf(interfaceC3951Arr, (i >> 2) + i);
                }
                int i2 = i + 1;
                interfaceC3951Arr[i] = interfaceC3951;
                i = i2;
            }
            if (i == 0) {
                EmptyDisposable.error(new NoSuchElementException(), interfaceC4782);
                return;
            }
            if (i == 1) {
                interfaceC3951Arr[0].subscribe(new C2109.C2110(interfaceC4782, new C2112()));
                return;
            }
            SingleZipArray.ZipCoordinator zipCoordinator = new SingleZipArray.ZipCoordinator(interfaceC4782, i, this.f7640);
            interfaceC4782.onSubscribe(zipCoordinator);
            for (int i3 = 0; i3 < i && !zipCoordinator.isDisposed(); i3++) {
                interfaceC3951Arr[i3].subscribe(zipCoordinator.observers[i3]);
            }
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptyDisposable.error(th, interfaceC4782);
        }
    }
}
