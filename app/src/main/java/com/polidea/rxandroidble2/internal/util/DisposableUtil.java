package com.polidea.rxandroidble2.internal.util;

import defpackage.AbstractC2349;
import defpackage.AbstractC5105;
import defpackage.InterfaceC4671;
import defpackage.InterfaceC5245;

/* loaded from: classes2.dex */
public class DisposableUtil {
    private DisposableUtil() {
    }

    public static <T> AbstractC5105<T> disposableObserverFromEmitter(final InterfaceC5245<T> interfaceC5245) {
        return new AbstractC5105<T>() { // from class: com.polidea.rxandroidble2.internal.util.DisposableUtil.2
            @Override // defpackage.InterfaceC5102
            public void onComplete() {
                interfaceC5245.onComplete();
            }

            @Override // defpackage.InterfaceC5102
            public void onError(Throwable th) {
                interfaceC5245.mo6761(th);
            }

            @Override // defpackage.InterfaceC5102
            public void onNext(T t) {
                interfaceC5245.onNext(t);
            }
        };
    }

    public static <T> AbstractC2349<T> disposableSingleObserverFromEmitter(final InterfaceC4671<T> interfaceC4671) {
        return new AbstractC2349<T>() { // from class: com.polidea.rxandroidble2.internal.util.DisposableUtil.1
            @Override // defpackage.InterfaceC4782
            public void onError(Throwable th) {
                interfaceC4671.mo6948(th);
            }

            @Override // defpackage.InterfaceC4782
            public void onSuccess(T t) {
                interfaceC4671.onSuccess(t);
            }
        };
    }

    public static <T> AbstractC2349<T> disposableSingleObserverFromEmitter(final InterfaceC5245<T> interfaceC5245) {
        return new AbstractC2349<T>() { // from class: com.polidea.rxandroidble2.internal.util.DisposableUtil.3
            @Override // defpackage.InterfaceC4782
            public void onError(Throwable th) {
                interfaceC5245.mo6761(th);
            }

            @Override // defpackage.InterfaceC4782
            public void onSuccess(T t) {
                interfaceC5245.onNext(t);
                interfaceC5245.onComplete();
            }
        };
    }
}
