package com.blink.academy.film.http.okhttp.func;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.blink.academy.film.http.okhttp.model.ApiResult;
import com.blink.academy.film.http.okhttp.utils.HttpUtil;
import com.blink.academy.film.http.okhttp.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import defpackage.AbstractC4809;
import defpackage.InterfaceC2368;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ApiResultJWTFunc<T> implements InterfaceC2368<AbstractC4809, ApiResult<T>> {
    private String client_nonce;
    public Gson gson = new GsonBuilder().excludeFieldsWithModifiers(16, 128, 8).serializeNulls().create();
    private int source;
    public Type type;

    public ApiResultJWTFunc(Type type, int i, String str) {
        this.source = i;
        this.client_nonce = str;
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
    /* JADX WARN: Type inference failed for: r0v0, types: [com.blink.academy.film.http.okhttp.model.ApiResult, com.blink.academy.film.http.okhttp.model.ApiResult<T>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.blink.academy.film.http.okhttp.model.ApiResult] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.blink.academy.film.http.okhttp.model.ApiResult] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.blink.academy.film.http.okhttp.model.ApiResult] */
    @Override // defpackage.InterfaceC2368
    public ApiResult<T> apply(AbstractC4809 abstractC4809) throws Exception {
        ApiResult<T> apiResult;
        JSONException e2;
        IOException e3;
        ApiResult<T> apiResult2;
        ApiResult<T> apiResult3;
        ?? r0 = (ApiResult<T>) new ApiResult();
        r0.setCode(-1);
        Type type = this.type;
        try {
            if (type instanceof ParameterizedType) {
                try {
                    if (!ApiResult.class.isAssignableFrom((Class) ((ParameterizedType) type).getRawType())) {
                        r0.setMsg("ApiResult.class.isAssignableFrom(cls) err!!");
                        return r0;
                    }
                    try {
                        Object objDecodeJWT = HttpUtil.decodeJWT(abstractC4809.string(), this.source, this.client_nonce);
                        r0.setCode(0);
                        r0.setData(objDecodeJWT);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        r0.setMsg(e4.getMessage());
                    }
                    return r0;
                } finally {
                }
            }
            try {
                String strString = abstractC4809.string();
                Class<T> cls = Utils.getClass(this.type, 0);
                if (cls.equals(String.class)) {
                    ApiResult<T> apiResult4 = parseApiResult(strString, r0);
                    if (apiResult4 != null) {
                        try {
                            apiResult4.setData(strString);
                            apiResult3 = apiResult4;
                        } catch (IOException e5) {
                            e3 = e5;
                            apiResult = apiResult4;
                            e3.printStackTrace();
                            apiResult.setMsg(e3.getMessage());
                            apiResult2 = apiResult;
                            abstractC4809.close();
                            return apiResult2;
                        } catch (JSONException e6) {
                            e2 = e6;
                            apiResult = apiResult4;
                            e2.printStackTrace();
                            apiResult.setMsg(e2.getMessage());
                            apiResult2 = apiResult;
                            abstractC4809.close();
                            return apiResult2;
                        }
                    } else {
                        r0.setMsg("json is null");
                        apiResult3 = r0;
                    }
                    return apiResult3;
                }
                apiResult = parseApiResult(strString, r0);
                if (apiResult != 0) {
                    try {
                        if (apiResult.getData() != null) {
                            apiResult.setData(this.gson.fromJson(apiResult.getData().toString(), (Class) cls));
                        } else {
                            apiResult.setMsg("ApiResult's data is null");
                        }
                        apiResult3 = apiResult;
                    } catch (IOException e7) {
                        e3 = e7;
                        e3.printStackTrace();
                        apiResult.setMsg(e3.getMessage());
                        apiResult2 = apiResult;
                        abstractC4809.close();
                        return apiResult2;
                    } catch (JSONException e8) {
                        e2 = e8;
                        e2.printStackTrace();
                        apiResult.setMsg(e2.getMessage());
                        apiResult2 = apiResult;
                        abstractC4809.close();
                        return apiResult2;
                    }
                } else {
                    r0.setMsg("json is null");
                    apiResult3 = r0;
                }
                return apiResult3;
            } catch (IOException e9) {
                apiResult = r0;
                e3 = e9;
            } catch (JSONException e10) {
                apiResult = r0;
                e2 = e10;
            }
            abstractC4809.close();
            return apiResult2;
        } finally {
        }
    }
}
