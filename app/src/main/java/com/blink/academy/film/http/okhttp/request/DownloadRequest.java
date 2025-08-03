package com.blink.academy.film.http.okhttp.request;

import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.func.RetryExceptionFunc;
import com.blink.academy.film.http.okhttp.subsciber.DownloadSubscriber;
import com.blink.academy.film.http.okhttp.transformer.HandleErrTransformer;
import defpackage.AbstractC4262;
import defpackage.AbstractC4809;
import defpackage.C4877;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5298;

/* loaded from: classes.dex */
public class DownloadRequest extends BaseRequest<DownloadRequest> {
    private String saveName;
    private String savePath;

    /* renamed from: com.blink.academy.film.http.okhttp.request.DownloadRequest$Ϳ, reason: contains not printable characters */
    public class C0407 implements InterfaceC5298<AbstractC4809, AbstractC4809> {
        public C0407() {
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<AbstractC4809> apply(AbstractC4262<AbstractC4809> abstractC4262) {
            return DownloadRequest.this.isSyncRequest ? abstractC4262 : abstractC4262.subscribeOn(C4877.m14602()).unsubscribeOn(C4877.m14602()).observeOn(C4877.m14600());
        }
    }

    public DownloadRequest(String str) {
        super(str);
    }

    public <T> InterfaceC4478 execute(CallBack<T> callBack) {
        return (InterfaceC4478) build().generateRequest().compose(new C0407()).compose(new HandleErrTransformer()).retryWhen(new RetryExceptionFunc(5, 3000L, 500L)).subscribeWith(new DownloadSubscriber(this.context, this.savePath, this.saveName, callBack));
    }

    @Override // com.blink.academy.film.http.okhttp.request.BaseRequest
    public AbstractC4262<AbstractC4809> generateRequest() {
        return this.apiManager.downloadFile(this.url);
    }

    public DownloadRequest saveName(String str) {
        this.saveName = str;
        return this;
    }

    public DownloadRequest savePath(String str) {
        this.savePath = str;
        return this;
    }
}
