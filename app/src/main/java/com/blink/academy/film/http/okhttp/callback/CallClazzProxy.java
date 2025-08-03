package com.blink.academy.film.http.okhttp.callback;

import com.blink.academy.film.http.okhttp.model.ApiResult;
import com.blink.academy.film.http.okhttp.utils.Utils;
import com.google.gson.internal.C$Gson$Types;
import defpackage.AbstractC4809;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public abstract class CallClazzProxy<T extends ApiResult<R>, R> implements IType<T> {
    private Type type;

    public CallClazzProxy(Type type) {
        this.type = type;
    }

    public Type getCallType() {
        return this.type;
    }

    @Override // com.blink.academy.film.http.okhttp.callback.IType
    public Type getType() {
        Type type = this.type;
        if (type == null) {
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
