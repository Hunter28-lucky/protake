package com.blink.academy.film.http.okhttp.request;

import com.blink.academy.film.http.okhttp.cache.model.CacheResult;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.callback.CallBackProxy;
import com.blink.academy.film.http.okhttp.func.ApiResultFunc;
import com.blink.academy.film.http.okhttp.func.CacheResultFunc;
import com.blink.academy.film.http.okhttp.func.HandleFuc;
import com.blink.academy.film.http.okhttp.func.RetryExceptionFunc;
import com.blink.academy.film.http.okhttp.model.ApiResult;
import com.blink.academy.film.http.okhttp.subsciber.CallBackSubsciber;
import com.blink.academy.film.http.okhttp.transformer.HandleErrTransformer;
import com.blink.academy.film.http.okhttp.utils.RxUtil;
import com.blink.academy.film.http.okhttp.utils.Utils;
import com.google.gson.reflect.TypeToken;
import defpackage.AbstractC4262;
import defpackage.AbstractC4809;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5298;
import java.util.HashMap;

/* loaded from: classes.dex */
public class CustomRequest extends BaseRequest<CustomRequest> {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.CustomRequest$Ϳ, reason: contains not printable characters */
    public class C0400<T> extends CallBackProxy<ApiResult<T>, T> {
        public C0400(CallBack callBack) {
            super(callBack);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.CustomRequest$Ԩ, reason: contains not printable characters */
    public class C0401<T> implements InterfaceC5298<CacheResult<T>, T> {
        public C0401() {
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<T> apply(AbstractC4262<CacheResult<T>> abstractC4262) {
            return abstractC4262.map(new CacheResultFunc());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.CustomRequest$Ԫ, reason: contains not printable characters */
    public class C0402<T> implements InterfaceC5298<CacheResult<T>, T> {
        public C0402() {
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<T> apply(AbstractC4262<CacheResult<T>> abstractC4262) {
            return abstractC4262.map(new CacheResultFunc());
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.request.CustomRequest$Ԭ, reason: contains not printable characters */
    public class C0403 extends TypeToken<AbstractC4809> {
        public C0403() {
        }
    }

    public CustomRequest() {
        super("");
    }

    private void checkvalidate() {
        Utils.checkNotNull(this.retrofit, "请先在调用build()才能使用");
    }

    private <T> AbstractC4262<CacheResult<T>> toObservable(AbstractC4262 abstractC4262, CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        return abstractC4262.map(new ApiResultFunc(callBackProxy != null ? callBackProxy.getType() : new C0403().getType())).compose(this.isSyncRequest ? RxUtil._main() : RxUtil._io_main()).compose(this.rxCache.transformer(this.cacheMode, callBackProxy.getCallBack().getType())).retryWhen(new RetryExceptionFunc(this.retryCount, this.retryDelay, this.retryIncreaseDelay));
    }

    public <T> AbstractC4262<T> apiCall(AbstractC4262<ApiResult<T>> abstractC4262) {
        checkvalidate();
        return abstractC4262.map(new HandleFuc()).compose(RxUtil.io_main()).compose(new HandleErrTransformer()).retryWhen(new RetryExceptionFunc(this.retryCount, this.retryDelay, this.retryIncreaseDelay));
    }

    public <T> AbstractC4262<T> call(AbstractC4262<T> abstractC4262) {
        checkvalidate();
        return abstractC4262.compose(RxUtil.io_main()).compose(new HandleErrTransformer()).retryWhen(new RetryExceptionFunc(this.retryCount, this.retryDelay, this.retryIncreaseDelay));
    }

    public <T> T create(Class<T> cls) {
        checkvalidate();
        return (T) this.retrofit.create(cls);
    }

    public <T> InterfaceC4478 execute(CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        AbstractC4262<CacheResult<T>> observable = build().toObservable(this.apiManager.get(this.url, new HashMap()), callBackProxy);
        return CacheResult.class != callBackProxy.getCallBack().getRawType() ? (InterfaceC4478) observable.compose(new C0402()).subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack())) : (InterfaceC4478) observable.subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack()));
    }

    @Override // com.blink.academy.film.http.okhttp.request.BaseRequest
    public AbstractC4262<AbstractC4809> generateRequest() {
        return null;
    }

    @Override // com.blink.academy.film.http.okhttp.request.BaseRequest
    public CustomRequest build() {
        return (CustomRequest) super.build();
    }

    public <T> void call(AbstractC4262<T> abstractC4262, CallBack<T> callBack) {
        call(abstractC4262, new CallBackSubsciber(this.context, callBack));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <R> void call(AbstractC4262 abstractC4262, InterfaceC5102<R> interfaceC5102) {
        abstractC4262.compose(RxUtil.io_main()).subscribe((InterfaceC5102<? super R>) interfaceC5102);
    }

    public <T> InterfaceC4478 apiCall(AbstractC4262<T> abstractC4262, CallBack<T> callBack) {
        return call(abstractC4262, new C0400(callBack));
    }

    public <T> InterfaceC4478 call(AbstractC4262<T> abstractC4262, CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        AbstractC4262<CacheResult<T>> observable = build().toObservable(abstractC4262, callBackProxy);
        if (CacheResult.class != callBackProxy.getCallBack().getRawType()) {
            return (InterfaceC4478) observable.compose(new C0401()).subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack()));
        }
        return (InterfaceC4478) observable.subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack()));
    }
}
