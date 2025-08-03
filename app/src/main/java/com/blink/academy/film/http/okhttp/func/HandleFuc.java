package com.blink.academy.film.http.okhttp.func;

import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.http.okhttp.exception.ServerException;
import com.blink.academy.film.http.okhttp.model.ApiResult;
import defpackage.InterfaceC2368;

/* loaded from: classes.dex */
public class HandleFuc<T> implements InterfaceC2368<ApiResult<T>, T> {
    @Override // defpackage.InterfaceC2368
    public T apply(ApiResult<T> apiResult) throws Exception {
        if (ApiException.isOk(apiResult)) {
            return apiResult.getData();
        }
        throw new ServerException(apiResult.getCode(), apiResult.getMsg());
    }
}
