package com.blink.academy.film.http.okhttp.subsciber;

import android.content.Context;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.http.okhttp.utils.Utils;
import defpackage.AbstractC5105;
import defpackage.C4638;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class BaseSubscriber<T> extends AbstractC5105<T> {
    public WeakReference<Context> contextWeakReference;

    public BaseSubscriber() {
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        C4638.m14100("-->http is onComplete");
    }

    public abstract void onError(ApiException apiException);

    @Override // defpackage.InterfaceC5102
    public final void onError(Throwable th) {
        C4638.m14100("-->http is onError");
        if (!(th instanceof ApiException)) {
            C4638.m14100("--> e !instanceof ApiException err:" + th);
            onError(ApiException.handleException(th));
            return;
        }
        C4638.m14100("--> e instanceof ApiException err:" + th);
        th.printStackTrace();
        onError((ApiException) th);
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        C4638.m14100("-->http is onNext");
    }

    @Override // defpackage.AbstractC5105
    public void onStart() {
        C4638.m14100("-->http is onStart");
        WeakReference<Context> weakReference = this.contextWeakReference;
        if (weakReference == null || weakReference.get() == null || Utils.isNetworkAvailable(this.contextWeakReference.get())) {
            return;
        }
        onComplete();
    }

    public BaseSubscriber(Context context) {
        if (context != null) {
            this.contextWeakReference = new WeakReference<>(context);
        }
    }
}
