package com.blink.academy.film.http.okhttp.request;

import com.blink.academy.film.http.okhttp.cache.model.CacheResult;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.callback.CallBackProxy;
import com.blink.academy.film.http.okhttp.func.ApiResultFunc;
import com.blink.academy.film.http.okhttp.func.CacheResultFunc;
import com.blink.academy.film.http.okhttp.func.RetryExceptionFunc;
import com.blink.academy.film.http.okhttp.model.ApiResult;
import com.blink.academy.film.http.okhttp.subsciber.CallBackSubsciber;
import com.blink.academy.film.http.okhttp.utils.RxUtil;
import com.google.gson.reflect.TypeToken;
import defpackage.AbstractC2613;
import defpackage.AbstractC4262;
import defpackage.AbstractC4809;
import defpackage.C2314;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5298;

/* loaded from: classes.dex */
public class DeleteRequest extends BaseBodyRequest<DeleteRequest> {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.DeleteRequest$Ϳ, reason: contains not printable characters */
    public class C0404<T> extends CallBackProxy<ApiResult<T>, T> {
        public C0404(CallBack callBack) {
            super(callBack);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.DeleteRequest$Ԩ, reason: contains not printable characters */
    public class C0405<T> implements InterfaceC5298<CacheResult<T>, T> {
        public C0405() {
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<T> apply(AbstractC4262<CacheResult<T>> abstractC4262) {
            return abstractC4262.map(new CacheResultFunc());
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.request.DeleteRequest$Ԫ, reason: contains not printable characters */
    public class C0406 extends TypeToken<AbstractC4809> {
        public C0406() {
        }
    }

    public DeleteRequest(String str) {
        super(str);
    }

    private <T> AbstractC4262<CacheResult<T>> toObservable(AbstractC4262 abstractC4262, CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        return abstractC4262.map(new ApiResultFunc(callBackProxy != null ? callBackProxy.getType() : new C0406().getType())).compose(this.isSyncRequest ? RxUtil._main() : RxUtil._io_main()).compose(this.rxCache.transformer(this.cacheMode, callBackProxy.getCallBack().getType())).retryWhen(new RetryExceptionFunc(this.retryCount, this.retryDelay, this.retryIncreaseDelay));
    }

    public <T> InterfaceC4478 execute(CallBack<T> callBack) {
        return execute(new C0404(callBack));
    }

    @Override // com.blink.academy.film.http.okhttp.request.BaseBodyRequest, com.blink.academy.film.http.okhttp.request.BaseRequest
    public AbstractC4262<AbstractC4809> generateRequest() {
        AbstractC2613 abstractC2613 = this.requestBody;
        if (abstractC2613 != null) {
            return this.apiManager.deleteBody(this.url, abstractC2613);
        }
        if (this.json != null) {
            return this.apiManager.deleteJson(this.url, AbstractC2613.create(C2314.m8683("application/json; charset=utf-8"), this.json));
        }
        Object obj = this.object;
        if (obj != null) {
            return this.apiManager.deleteBody(this.url, obj);
        }
        String str = this.string;
        if (str == null) {
            return this.apiManager.delete(this.url, this.params.urlParamsMap);
        }
        return this.apiManager.deleteBody(this.url, AbstractC2613.create(this.mediaType, str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> InterfaceC4478 execute(CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        AbstractC4262<CacheResult<T>> observable = ((DeleteRequest) build()).toObservable(generateRequest(), callBackProxy);
        return CacheResult.class != callBackProxy.getCallBack().getRawType() ? (InterfaceC4478) observable.compose(new C0405()).subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack())) : (InterfaceC4478) observable.subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack()));
    }
}
