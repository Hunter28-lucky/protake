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

/* loaded from: classes.dex */
public class PostRequest extends BaseBodyRequest<PostRequest> {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.PostRequest$Ϳ, reason: contains not printable characters */
    public class C0417<T> extends CallClazzProxy<ApiResult<T>, T> {
        public C0417(Type type) {
            super(type);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.PostRequest$Ԩ, reason: contains not printable characters */
    public class C0418<T> extends CallClazzProxy<ApiResult<T>, T> {
        public C0418(Type type) {
            super(type);
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.request.PostRequest$Ԫ, reason: contains not printable characters */
    public class C0419 implements InterfaceC5298 {
        public C0419() {
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856 apply(AbstractC4262 abstractC4262) {
            return abstractC4262.map(new CacheResultFunc());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.PostRequest$Ԭ, reason: contains not printable characters */
    public class C0420<T> extends CallBackProxy<ApiResult<T>, T> {
        public C0420(CallBack callBack) {
            super(callBack);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.PostRequest$Ԯ, reason: contains not printable characters */
    public class C0421<T> implements InterfaceC5298<CacheResult<T>, T> {
        public C0421() {
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<T> apply(AbstractC4262<CacheResult<T>> abstractC4262) {
            return abstractC4262.map(new CacheResultFunc());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.blink.academy.film.http.okhttp.request.PostRequest$ՠ, reason: contains not printable characters */
    public class C0422<T> implements InterfaceC5298<CacheResult<T>, T> {
        public C0422() {
        }

        @Override // defpackage.InterfaceC5298
        public InterfaceC2856<T> apply(AbstractC4262<CacheResult<T>> abstractC4262) {
            return abstractC4262.map(new CacheResultFunc());
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.request.PostRequest$ֈ, reason: contains not printable characters */
    public class C0423 extends TypeToken<AbstractC4809> {
        public C0423() {
        }
    }

    /* renamed from: com.blink.academy.film.http.okhttp.request.PostRequest$֏, reason: contains not printable characters */
    public class C0424 extends TypeToken<AbstractC4809> {
        public C0424() {
        }
    }

    public PostRequest(String str) {
        super(str);
    }

    private <T> AbstractC4262<CacheResult<T>> toObservable(AbstractC4262 abstractC4262, CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        return abstractC4262.map(new ApiResultFunc(callBackProxy != null ? callBackProxy.getType() : new C0423().getType())).compose(this.isSyncRequest ? RxUtil._main() : RxUtil._io_main()).compose(this.rxCache.transformer(this.cacheMode, callBackProxy.getCallBack().getType())).retryWhen(new RetryExceptionFunc(this.retryCount, this.retryDelay, this.retryIncreaseDelay));
    }

    private <T> AbstractC4262<CacheResult<T>> toObservable2(String str, int i, AbstractC4262 abstractC4262, CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        return abstractC4262.map(new ApiResultJWTFunc(callBackProxy != null ? callBackProxy.getType() : new C0424().getType(), i, str)).compose(this.isSyncRequest ? RxUtil._main() : RxUtil._io_main()).compose(this.rxCache.transformer(this.cacheMode, callBackProxy.getCallBack().getType())).retryWhen(new RetryExceptionFunc(this.retryCount, this.retryDelay, this.retryIncreaseDelay));
    }

    public <T> AbstractC4262<T> execute(Class<T> cls) {
        return execute(new C0417(cls));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> InterfaceC4478 executeJWT(String str, int i, CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        AbstractC4262<CacheResult<T>> observable2 = ((PostRequest) build()).toObservable2(str, i, generateRequest(), callBackProxy);
        return CacheResult.class != callBackProxy.getCallBack().getRawType() ? (InterfaceC4478) observable2.compose(new C0422()).subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack())) : (InterfaceC4478) observable2.subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack()));
    }

    public <T> AbstractC4262<T> execute(Type type) {
        return execute(new C0418(type));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> AbstractC4262<T> execute(CallClazzProxy<? extends ApiResult<T>, T> callClazzProxy) {
        return (AbstractC4262<T>) ((PostRequest) build()).generateRequest().map(new ApiResultFunc(callClazzProxy.getType())).compose(this.isSyncRequest ? RxUtil._main() : RxUtil._io_main()).compose(this.rxCache.transformer(this.cacheMode, callClazzProxy.getCallType())).retryWhen(new RetryExceptionFunc(this.retryCount, this.retryDelay, this.retryIncreaseDelay)).compose(new C0419());
    }

    public <T> InterfaceC4478 execute(CallBack<T> callBack) {
        return execute(new C0420(callBack));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> InterfaceC4478 execute(CallBackProxy<? extends ApiResult<T>, T> callBackProxy) {
        AbstractC4262<CacheResult<T>> observable = ((PostRequest) build()).toObservable(generateRequest(), callBackProxy);
        if (CacheResult.class != callBackProxy.getCallBack().getRawType()) {
            return (InterfaceC4478) observable.compose(new C0421()).subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack()));
        }
        return (InterfaceC4478) observable.subscribeWith(new CallBackSubsciber(this.context, callBackProxy.getCallBack()));
    }
}
