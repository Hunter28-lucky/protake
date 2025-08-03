package com.blink.academy.film.http.okhttp.request;

import com.blink.academy.film.http.okhttp.cache.model.CacheResult;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.callback.CallBackProxy;
import com.blink.academy.film.http.okhttp.callback.CallClazzProxy;
import com.blink.academy.film.http.okhttp.func.ApiResultFunc;
import com.blink.academy.film.http.okhttp.func.ApiResultJWTFunc;
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
import java.util.HashMap;

/* loaded from: classes.dex */
public class GetRequest extends BaseRequest<GetRequest> {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.GetRequest$Ϳ, reason: contains not printable characters */
    public class C0408<T> extends CallClazzProxy<ApiResult<T>, T> {
        public C0408(Type type) {
            super(type);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.GetRequest$Ԩ, reason: contains not printable characters */
    public class C0409<T> extends CallClazzProxy<ApiResult<T>, T> {
        public C0409(Type type) {
            super(type);
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.request.GetRequest$Ԫ, reason: contains not printable characters */
    public class C0410 implements InterfaceC5298 {
        public C0410() {
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856 apply(AbstractC4262 abstractC4262) {
            return abstractC4262.map(new CacheResultFunc());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.GetRequest$Ԭ, reason: contains not printable characters */
    public class C0411<T> extends CallBackProxy<ApiResult<T>, T> {
        public C0411(CallBack callBack) {
            super(callBack);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.GetRequest$Ԯ, reason: contains not printable characters */
    public class C0412<T> implements InterfaceC5298<CacheResult<T>, T> {
        public C0412() {
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<T> apply(AbstractC4262<CacheResult<T>> abstractC4262) {
            return abstractC4262.map(new CacheResultFunc());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.GetRequest$ՠ, reason: contains not printable characters */
    public class C0413<T> implements InterfaceC5298<CacheResult<T>, T> {
        public C0413() {
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<T> apply(AbstractC4262<CacheResult<T>> abstractC4262) {
            return abstractC4262.map(new CacheResultFunc());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.GetRequest$ֈ, reason: contains not printable characters */
    public class C0414<T> implements InterfaceC5298<CacheResult<T>, T> {
        public C0414() {
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<T> apply(AbstractC4262<CacheResult<T>> abstractC4262) {
            return abstractC4262.map(new CacheResultFunc());
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.request.GetRequest$֏, reason: contains not printable characters */
    public class C0415 extends TypeToken<AbstractC4809> {
        public C0415() {
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.request.GetRequest$ׯ, reason: contains not printable characters */
    public class C0416 extends TypeToken<AbstractC4809> {
        public C0416() {
        }
    }

    public GetRequest(String str) {
        super(str);
    }

    private <T> AbstractC4262<CacheResult<T>> toObservable(AbstractC4262 abstractC4262, CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        return abstractC4262.map(new ApiResultFunc(callBackProxy != null ? callBackProxy.getType() : new C0416().getType())).compose(this.isSyncRequest ? RxUtil._main() : RxUtil._io_main()).compose(this.rxCache.transformer(this.cacheMode, callBackProxy.getCallBack().getType())).retryWhen(new RetryExceptionFunc(this.retryCount, this.retryDelay, this.retryIncreaseDelay));
    }

    private <T> AbstractC4262<CacheResult<T>> toObservable2(String str, int i, AbstractC4262 abstractC4262, CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        return abstractC4262.map(new ApiResultJWTFunc(callBackProxy != null ? callBackProxy.getType() : new C0415().getType(), i, str)).compose(this.isSyncRequest ? RxUtil._main() : RxUtil._io_main()).compose(this.rxCache.transformer(this.cacheMode, callBackProxy.getCallBack().getType())).retryWhen(new RetryExceptionFunc(this.retryCount, this.retryDelay, this.retryIncreaseDelay));
    }

    public <T> AbstractC4262<T> execute(Class<T> cls) {
        return execute(new C0408(cls));
    }

    public <T> InterfaceC4478 executeJWT(String str, int i, CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        AbstractC4262<CacheResult<T>> observable2 = build().toObservable2(str, i, this.apiManager.get(this.url, this.params.urlParamsMap), callBackProxy);
        return CacheResult.class != callBackProxy.getCallBack().getRawType() ? (InterfaceC4478) observable2.compose(new C0414()).subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack())) : (InterfaceC4478) observable2.subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack()));
    }

    public <T> InterfaceC4478 executeNoCommomParams(CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        AbstractC4262<CacheResult<T>> observable = build().toObservable(this.apiManager.get(this.url, new HashMap()), callBackProxy);
        return CacheResult.class != callBackProxy.getCallBack().getRawType() ? (InterfaceC4478) observable.compose(new C0412()).subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack())) : (InterfaceC4478) observable.subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack()));
    }

    @Override // com.blink.academy.film.http.okhttp.request.BaseRequest
    public AbstractC4262<AbstractC4809> generateRequest() {
        return this.apiManager.get(this.url, this.params.urlParamsMap);
    }

    public <T> AbstractC4262<T> execute(Type type) {
        return execute(new C0409(type));
    }

    public <T> AbstractC4262<T> execute(CallClazzProxy<? extends ApiResult<T>, T> callClazzProxy) {
        return (AbstractC4262<T>) build().generateRequest().map(new ApiResultFunc(callClazzProxy.getType())).compose(this.isSyncRequest ? RxUtil._main() : RxUtil._io_main()).compose(this.rxCache.transformer(this.cacheMode, callClazzProxy.getCallType())).retryWhen(new RetryExceptionFunc(this.retryCount, this.retryDelay, this.retryIncreaseDelay)).compose(new C0410());
    }

    public <T> InterfaceC4478 execute(CallBack<T> callBack) {
        return execute(new C0411(callBack));
    }

    public <T> InterfaceC4478 execute(CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        AbstractC4262<CacheResult<T>> observable = build().toObservable(this.apiManager.get(this.url, this.params.urlParamsMap), callBackProxy);
        if (CacheResult.class != callBackProxy.getCallBack().getRawType()) {
            return (InterfaceC4478) observable.compose(new C0413()).subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack()));
        }
        return (InterfaceC4478) observable.subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack()));
    }
}
