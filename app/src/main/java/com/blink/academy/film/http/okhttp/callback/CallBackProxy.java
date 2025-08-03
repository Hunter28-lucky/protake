package com.blink.academy.film.http.okhttp.callback;

import com.blink.academy.film.http.okhttp.cache.model.CacheResult;
import com.blink.academy.film.http.okhttp.model.ApiResult;
import com.blink.academy.film.http.okhttp.utils.Utils;
import com.google.gson.internal.C$Gson$Types;
import defpackage.AbstractC4809;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class CallBackProxy<T extends ApiResult<R>, R> implements IType<T> {
    public CallBack<R> mCallBack;

    public CallBackProxy(CallBack<R> callBack) {
        this.mCallBack = callBack;
    }

    public CallBack getCallBack() {
        return this.mCallBack;
    }

    @Override // com.blink.academy.film.http.okhttp.callback.IType
    public Type getType() {
        Type type;
        CallBack<R> callBack = this.mCallBack;
        if (callBack != null) {
            Type rawType = callBack.getRawType();
            type = (List.class.isAssignableFrom(Utils.getClass(rawType, 0)) || Map.class.isAssignableFrom(Utils.getClass(rawType, 0))) ? this.mCallBack.getType() : CacheResult.class.isAssignableFrom(Utils.getClass(rawType, 0)) ? Utils.getParameterizedType(this.mCallBack.getType(), 0) : Utils.getClass(this.mCallBack.getType(), 0);
        } else {
            type = null;
        }
        if (type == null) {
            type = AbstractC4809.class;
        }
        Type typeFindNeedType = Utils.findNeedType(getClass());
        if (typeFindNeedType instanceof ParameterizedType) {
            typeFindNeedType = ((ParameterizedType) typeFindNeedType).getRawType();
        }
        return C$Gson$Types.newParameterizedTypeWithOwner(null, typeFindNeedType, type);
    }
}
