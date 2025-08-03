package com.blink.academy.film.http.okhttp.callback;

/* loaded from: classes.dex */
public abstract class DownloadProgressCallBack<T> extends CallBack<T> {
    public abstract void onComplete(String str);

    @Override // com.blink.academy.film.http.okhttp.callback.CallBack
    public void onCompleted() {
    }

    @Override // com.blink.academy.film.http.okhttp.callback.CallBack
    public void onSuccess(T t) {
    }

    public abstract void update(long j, long j2, boolean z);
}
