package io.reactivex.subjects;

import defpackage.C3671;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.k0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class PublishSubject<T> extends k0<T> {

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final PublishDisposable[] f7708 = new PublishDisposable[0];

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final PublishDisposable[] f7709 = new PublishDisposable[0];

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AtomicReference<PublishDisposable<T>[]> f7710 = new AtomicReference<>(f7709);

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Throwable f7711;

    public static final class PublishDisposable<T> extends AtomicBoolean implements InterfaceC4478 {
        private static final long serialVersionUID = 3562861878281475070L;
        public final InterfaceC5102<? super T> downstream;
        public final PublishSubject<T> parent;

        public PublishDisposable(InterfaceC5102<? super T> interfaceC5102, PublishSubject<T> publishSubject) {
            this.downstream = interfaceC5102;
            this.parent = publishSubject;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.m7036(this);
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m7037() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m7038(Throwable th) {
            if (get()) {
                C3671.m11803(th);
            } else {
                this.downstream.onError(th);
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m7039(T t) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T> PublishSubject<T> m7034() {
        return new PublishSubject<>();
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.f7710.get();
        PublishDisposable<T>[] publishDisposableArr2 = f7708;
        if (publishDisposableArr == publishDisposableArr2) {
            return;
        }
        for (PublishDisposable<T> publishDisposable : this.f7710.getAndSet(publishDisposableArr2)) {
            publishDisposable.m7037();
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        C4246.m13353(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.f7710.get();
        PublishDisposable<T>[] publishDisposableArr2 = f7708;
        if (publishDisposableArr == publishDisposableArr2) {
            C3671.m11803(th);
            return;
        }
        this.f7711 = th;
        for (PublishDisposable<T> publishDisposable : this.f7710.getAndSet(publishDisposableArr2)) {
            publishDisposable.m7038(th);
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        C4246.m13353(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable<T> publishDisposable : this.f7710.get()) {
            publishDisposable.m7039(t);
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        if (this.f7710.get() == f7708) {
            interfaceC4478.dispose();
        }
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(interfaceC5102, this);
        interfaceC5102.onSubscribe(publishDisposable);
        if (m7035(publishDisposable)) {
            if (publishDisposable.isDisposed()) {
                m7036(publishDisposable);
            }
        } else {
            Throwable th = this.f7711;
            if (th != null) {
                interfaceC5102.onError(th);
            } else {
                interfaceC5102.onComplete();
            }
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean m7035(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f7710.get();
            if (publishDisposableArr == f7708) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!C4905.m14631(this.f7710, publishDisposableArr, publishDisposableArr2));
        return true;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m7036(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f7710.get();
            if (publishDisposableArr == f7708 || publishDisposableArr == f7709) {
                return;
            }
            int length = publishDisposableArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (publishDisposableArr[i2] == publishDisposable) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                publishDisposableArr2 = f7709;
            } else {
                PublishDisposable[] publishDisposableArr3 = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i);
                System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr3, i, (length - i) - 1);
                publishDisposableArr2 = publishDisposableArr3;
            }
        } while (!C4905.m14631(this.f7710, publishDisposableArr, publishDisposableArr2));
    }
}
