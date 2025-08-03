package com.blink.academy.film.http.okhttp.subsciber;

import android.content.Context;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;

/* loaded from: classes.dex */
public class CallBackSubsciber<T> extends BaseSubscriber<T> {
    public CallBack<T> mCallBack;

    public CallBackSubsciber(Context context, CallBack<T> callBack) {
        super(context);
        this.mCallBack = callBack;
    }

    @Override // com.blink.academy.film.http.okhttp.subsciber.BaseSubscriber, defpackage.InterfaceC5102
    public void onComplete() {
        super.onComplete();
        CallBack<T> callBack = this.mCallBack;
        if (callBack != null) {
            callBack.onCompleted();
        }
    }

    @Override // com.blink.academy.film.http.okhttp.subsciber.BaseSubscriber
    public void onError(ApiException apiException) {
        CallBack<T> callBack = this.mCallBack;
        if (callBack != null) {
            callBack.onError(apiException);
        }
    }

    @Override // com.blink.academy.film.http.okhttp.subsciber.BaseSubscriber, defpackage.InterfaceC5102
    public void onNext(T t) {
        super.onNext(t);
        CallBack<T> callBack = this.mCallBack;
        if (callBack != null) {
            callBack.onSuccess(t);
        }
    }

    @Override // com.blink.academy.film.http.okhttp.subsciber.BaseSubscriber, defpackage.AbstractC5105
    public void onStart() {
        super.onStart();
        CallBack<T> callBack = this.mCallBack;
        if (callBack != null) {
            callBack.onStart();
        }
    }
}
