package com.blink.academy.film.http.okhttp.func;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.blink.academy.film.http.okhttp.model.ApiResult;
import com.blink.academy.film.http.okhttp.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import defpackage.AbstractC4809;
import defpackage.InterfaceC2368;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ApiResultFunc<T> implements InterfaceC2368<AbstractC4809, ApiResult<T>> {
    public Gson gson = new GsonBuilder().excludeFieldsWithModifiers(16, 128, 8).serializeNulls().create();
    public Type type;

    public ApiResultFunc(Type type) {
        this.type = type;
    }

    private ApiResult parseApiResult(String str, ApiResult apiResult) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("code")) {
            apiResult.setCode(jSONObject.getInt("code"));
        }
        if (jSONObject.has("data")) {
            apiResult.setData(jSONObject.getString("data"));
        }
        if (jSONObject.has(NotificationCompat.CATEGORY_MESSAGE)) {
            apiResult.setMsg(jSONObject.getString(NotificationCompat.CATEGORY_MESSAGE));
        }
        return apiResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.blink.academy.film.http.okhttp.model.ApiResult] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.blink.academy.film.http.okhttp.model.ApiResult] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.blink.academy.film.http.okhttp.model.ApiResult] */
    /* JADX WARN: Type inference failed for: r0v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.blink.academy.film.http.okhttp.model.ApiResult, com.blink.academy.film.http.okhttp.model.ApiResult<T>] */
    @Override // defpackage.InterfaceC2368
    public ApiResult<T> apply(AbstractC4809 abstractC4809) throws Exception {
        JSONException e2;
        ApiResult<T> apiResultEquals;
        IOException e3;
        ApiResult<T> apiResult;
        ApiResult<T> apiResult2;
        Object objFromJson;
        ?? r1 = (ApiResult<T>) new ApiResult();
        r1.setCode(-1);
        Type type = this.type;
        try {
            if (type instanceof ParameterizedType) {
                if (!ApiResult.class.isAssignableFrom((Class) ((ParameterizedType) type).getRawType())) {
                    r1.setMsg("ApiResult.class.isAssignableFrom(cls) err!!");
                    return r1;
                }
                Class<T> cls = Utils.getClass(((ParameterizedType) this.type).getActualTypeArguments()[0], 0);
                Class cls2 = Utils.getClass(this.type, 0);
                try {
                    try {
                        String strString = abstractC4809.string();
                        if (List.class.isAssignableFrom(cls2) || !cls.equals(String.class)) {
                            if (List.class.isAssignableFrom(cls2)) {
                                objFromJson = this.gson.fromJson(strString, ((ParameterizedType) this.type).getActualTypeArguments()[0]);
                            } else {
                                objFromJson = this.gson.fromJson(strString, (Class<Object>) cls);
                            }
                            if (objFromJson != null) {
                                r1.setCode(0);
                                r1.setData(objFromJson);
                            } else {
                                r1.setMsg("json is null");
                            }
                        } else {
                            r1.setData(strString);
                            r1.setCode(0);
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        r1.setMsg(e4.getMessage());
                    }
                    return r1;
                } finally {
                }
            }
            try {
                String strString2 = abstractC4809.string();
                Class<T> cls3 = Utils.getClass(this.type, 0);
                apiResultEquals = cls3.equals(String.class);
                try {
                    if (apiResultEquals != 0) {
                        ApiResult apiResult3 = parseApiResult(strString2, r1);
                        if (apiResult3 != null) {
                            apiResult3.setData(strString2);
                            apiResultEquals = apiResult3;
                            apiResult2 = apiResultEquals;
                        } else {
                            r1.setMsg("json is null");
                            apiResult2 = r1;
                        }
                    } else {
                        ?? apiResult4 = parseApiResult(strString2, r1);
                        if (apiResult4 != 0) {
                            if (apiResult4.getData() != null) {
                                apiResult4.setData(this.gson.fromJson(apiResult4.getData().toString(), (Class) cls3));
                                apiResultEquals = apiResult4;
                            } else {
                                apiResult4.setMsg("ApiResult's data is null");
                                apiResultEquals = apiResult4;
                            }
                            apiResult2 = apiResultEquals;
                        } else {
                            r1.setMsg("json is null");
                            apiResult2 = r1;
                        }
                    }
                    return apiResult2;
                } catch (IOException e5) {
                    e3 = e5;
                    e3.printStackTrace();
                    apiResultEquals.setMsg(e3.getMessage());
                    apiResult = apiResultEquals;
                    abstractC4809.close();
                    return apiResult;
                } catch (JSONException e6) {
                    e2 = e6;
                    e2.printStackTrace();
                    apiResultEquals.setMsg(e2.getMessage());
                    apiResult = apiResultEquals;
                    abstractC4809.close();
                    return apiResult;
                }
            } catch (IOException e7) {
                e3 = e7;
                apiResultEquals = r1;
            } catch (JSONException e8) {
                e2 = e8;
                apiResultEquals = r1;
            }
        } finally {
        }
    }
}
