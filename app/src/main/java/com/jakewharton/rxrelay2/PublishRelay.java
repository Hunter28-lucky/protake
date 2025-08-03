package com.jakewharton.rxrelay2;

import defpackage.C4905;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class PublishRelay<T> extends Relay<T> {
    public static final PublishDisposable[] EMPTY = new PublishDisposable[0];
    public final AtomicReference<PublishDisposable<T>[]> subscribers = new AtomicReference<>(EMPTY);

    public static final class PublishDisposable<T> extends AtomicBoolean implements InterfaceC4478 {
        private static final long serialVersionUID = 3562861878281475070L;
        public final InterfaceC5102<? super T> downstream;
        public final PublishRelay<T> parent;

        public PublishDisposable(InterfaceC5102<? super T> interfaceC5102, PublishRelay<T> publishRelay) {
            this.downstream = interfaceC5102;
            this.parent = publishRelay;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get();
        }

        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t);
        }
    }

    public static <T> PublishRelay<T> create() {
        return new PublishRelay<>();
    }

    @Override // com.jakewharton.rxrelay2.Relay, defpackage.InterfaceC2857
    public void accept(T t) {
        if (t == null) {
            throw new NullPointerException("value == null");
        }
        for (PublishDisposable<T> publishDisposable : this.subscribers.get()) {
            publishDisposable.onNext(t);
        }
    }

    public void add(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.subscribers.get();
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!C4905.m14631(this.subscribers, publishDisposableArr, publishDisposableArr2));
    }

    @Override // com.jakewharton.rxrelay2.Relay
    public boolean hasObservers() {
        return this.subscribers.get().length != 0;
    }

    public void remove(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.subscribers.get();
            if (publishDisposableArr == EMPTY) {
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
                publishDisposableArr2 = EMPTY;
            } else {
                PublishDisposable[] publishDisposableArr3 = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i);
                System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr3, i, (length - i) - 1);
                publishDisposableArr2 = publishDisposableArr3;
            }
        } while (!C4905.m14631(this.subscribers, publishDisposableArr, publishDisposableArr2));
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(interfaceC5102, this);
        interfaceC5102.onSubscribe(publishDisposable);
        add(publishDisposable);
        if (publishDisposable.isDisposed()) {
            remove(publishDisposable);
        }
    }
}
