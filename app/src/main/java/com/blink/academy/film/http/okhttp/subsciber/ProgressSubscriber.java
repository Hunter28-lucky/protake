package com.blink.academy.film.http.okhttp.subsciber;

import android.content.Context;
import com.blink.academy.film.http.okhttp.exception.ApiException;

/* loaded from: classes.dex */
public abstract class ProgressSubscriber<T> extends BaseSubscriber<T> implements ProgressCancelListener {
    private boolean isShowProgress;

    public ProgressSubscriber(Context context) {
        super(context);
        this.isShowProgress = true;
        init(false);
    }

    private void init(boolean z) {
    }

    @Override // com.blink.academy.film.http.okhttp.subsciber.ProgressCancelListener
    public void onCancelProgress() {
        if (isDisposed()) {
            return;
        }
        dispose();
    }

    @Override // com.blink.academy.film.http.okhttp.subsciber.BaseSubscriber, defpackage.InterfaceC5102
    public void onComplete() {
    }

    @Override // com.blink.academy.film.http.okhttp.subsciber.BaseSubscriber
    public void onError(ApiException apiException) {
    }

    @Override // com.blink.academy.film.http.okhttp.subsciber.BaseSubscriber, defpackage.AbstractC5105
    public void onStart() {
    }
}
