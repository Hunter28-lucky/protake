package com.blink.academy.film.http.okhttp.func;

import com.blink.academy.film.http.okhttp.exception.ApiException;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2368;

/* loaded from: classes.dex */
public class HttpResponseFunc<T> implements InterfaceC2368<Throwable, AbstractC4262<T>> {
    @Override // defpackage.InterfaceC2368
    public AbstractC4262<T> apply(Throwable th) throws Exception {
        return AbstractC4262.error(ApiException.handleException(th));
    }
}
