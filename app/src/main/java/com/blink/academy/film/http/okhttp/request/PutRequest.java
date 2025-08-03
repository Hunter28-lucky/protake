package com.blink.academy.film.http.okhttp.request;

import com.blink.academy.film.http.okhttp.cache.model.CacheResult;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.callback.CallBackProxy;
import com.blink.academy.film.http.okhttp.callback.CallClazzProxy;
import com.blink.academy.film.http.okhttp.func.ApiResultFunc;
import com.blink.academy.film.http.okhttp.func.CacheResultFunc;
import com.blink.academy.film.http.okhttp.func.RetryExceptionFunc;
import com.blink.academy.film.http.okhttp.model.ApiResult;
import com.blink.academy.film.http.okhttp.subsciber.CallBackSubsciber;
import com.blink.academy.film.http.okhttp.utils.RxUtil;
import com.google.gson.reflect.TypeToken;
import defpackage.AbstractC4262;
import defpackage.AbstractC4809;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5298;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class PutRequest extends BaseBodyRequest<PutRequest> {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.PutRequest$Ϳ, reason: contains not printable characters */
    public class C0425<T> extends CallClazzProxy<ApiResult<T>, T> {
        public C0425(Type type) {
            super(type);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.PutRequest$Ԩ, reason: contains not printable characters */
    public class C0426<T> extends CallClazzProxy<ApiResult<T>, T> {
        public C0426(Type type) {
            super(type);
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.request.PutRequest$Ԫ, reason: contains not printable characters */
    public class C0427 implements InterfaceC5298 {
        public C0427() {
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856 apply(AbstractC4262 abstractC4262) {
            return abstractC4262.map(new CacheResultFunc());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.PutRequest$Ԭ, reason: contains not printable characters */
    public class C0428<T> extends CallBackProxy<ApiResult<T>, T> {
        public C0428(CallBack callBack) {
            super(callBack);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.PutRequest$Ԯ, reason: contains not printable characters */
    public class C0429<T> implements InterfaceC5298<CacheResult<T>, T> {
        public C0429() {
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<T> apply(AbstractC4262<CacheResult<T>> abstractC4262) {
            return abstractC4262.map(new CacheResultFunc());
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.request.PutRequest$ՠ, reason: contains not printable characters */
    public class C0430 extends TypeToken<AbstractC4809> {
        public C0430() {
        }
    }

    public PutRequest(String str) {
        super(str);
    }

    private <T> AbstractC4262<CacheResult<T>> toObservable(AbstractC4262 abstractC4262, CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        return abstractC4262.map(new ApiResultFunc(callBackProxy != null ? callBackProxy.getType() : new C0430().getType())).compose(this.isSyncRequest ? RxUtil._main() : RxUtil._io_main()).compose(this.rxCache.transformer(this.cacheMode, callBackProxy.getCallBack().getType())).retryWhen(new RetryExceptionFunc(this.retryCount, this.retryDelay, this.retryIncreaseDelay));
    }

    public <T> AbstractC4262<T> execute(Class<T> cls) {
        return execute(new C0425(cls));
    }

    @Override // com.blink.academy.film.http.okhttp.request.BaseBodyRequest, com.blink.academy.film.http.okhttp.request.BaseRequest
    public AbstractC4262<AbstractC4809> generateRequest() {
        Object obj = this.object;
        return obj != null ? this.apiManager.putBody(this.url, obj) : this.apiManager.put(this.url, this.params.urlParamsMap);
    }

    public <T> AbstractC4262<T> execute(Type type) {
        return execute(new C0426(type));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> AbstractC4262<T> execute(CallClazzProxy<? extends ApiResult<T>, T> callClazzProxy) {
        return (AbstractC4262<T>) ((PutRequest) build()).generateRequest().map(new ApiResultFunc(callClazzProxy.getType())).compose(this.isSyncRequest ? RxUtil._main() : RxUtil._io_main()).compose(this.rxCache.transformer(this.cacheMode, callClazzProxy.getCallType())).retryWhen(new RetryExceptionFunc(this.retryCount, this.retryDelay, this.retryIncreaseDelay)).compose(new C0427());
    }

    public <T> InterfaceC4478 execute(CallBack<T> callBack) {
        return execute(new C0428(callBack));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> InterfaceC4478 execute(CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        AbstractC4262<CacheResult<T>> observable = ((PutRequest) build()).toObservable(generateRequest(), callBackProxy);
        if (CacheResult.class != callBackProxy.getCallBack().getRawType()) {
            return (InterfaceC4478) observable.compose(new C0429()).subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack()));
        }
        return (InterfaceC4478) observable.subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack()));
    }
}
