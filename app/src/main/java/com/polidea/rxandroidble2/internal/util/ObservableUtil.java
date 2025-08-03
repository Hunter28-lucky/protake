package com.polidea.rxandroidble2.internal.util;

import defpackage.AbstractC4262;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC5298;

/* loaded from: classes2.dex */
public class ObservableUtil {
    private static final InterfaceC5298<?, ?> IDENTITY_TRANSFORMER = new InterfaceC5298<Object, Object>() { // from class: com.polidea.rxandroidble2.internal.util.ObservableUtil.1
        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<Object> apply(AbstractC4262<Object> abstractC4262) {
            return abstractC4262;
        }
    };

    private ObservableUtil() {
    }

    public static <T> InterfaceC5298<T, T> identityTransformer() {
        return (InterfaceC5298<T, T>) IDENTITY_TRANSFORMER;
    }

    public static <T> AbstractC4262<T> justOnNext(T t) {
        return AbstractC4262.never().startWith((AbstractC4262) t);
    }
}
