package com.blink.academy.film.http.okhttp.transformer;

import com.blink.academy.film.http.okhttp.func.HttpResponseFunc;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC5298;

/* loaded from: classes.dex */
public class HandleErrTransformer<T> implements InterfaceC5298<T, T> {
    @Override // defpackage.InterfaceC5298
    public InterfaceC2856<T> apply(AbstractC4262<T> abstractC4262) {
        return abstractC4262.onErrorResumeNext(new HttpResponseFunc());
    }
}
