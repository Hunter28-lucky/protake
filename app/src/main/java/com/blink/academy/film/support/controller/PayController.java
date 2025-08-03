package com.blink.academy.film.support.controller;

import android.os.Build;
import com.blink.academy.film.http.okhttp.OkHttpUtils;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.callback.CallBackProxy;
import com.blink.academy.film.http.okhttp.model.ApiResult;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.blink.academy.film.http.okhttp.request.PostRequest;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.C5213;
import defpackage.e5;
import defpackage.n;

/* loaded from: classes.dex */
public class PayController extends BaseController {
    private static final String CANCEL_ALIPAY_ORDER = "/v1/iap/cancel_alipay";
    private static final String CANCEL_WECHAT_ORDER = "/v1/iap/cancel_wxpay";
    private static final String GET_ALI_ORDER = "/v1/iap/gen_alipay";
    private static final String GET_WECHAT_ORDER = "/v1/iap/gen_wxpay";
    private static final String QUERY_ALIPAY_ORDER = "/v1/iap/query_alipay";
    private static final String QUERY_GOOGLE_ORDER = "/v1/iap/playstore_verify";
    private static final String QUERY_HUAWEI_ORDER = "/v1/iap/hms_verify";
    private static final String QUERY_WECHAT_ORDER = "/v1/iap/query_wxpay";

    /* JADX WARN: Multi-variable type inference failed */
    public static void postCancelAliOrder(String str, String str2, String str3, CallBack<String> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(CANCEL_ALIPAY_ORDER).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("current_user_id", str)).params("access_token", str2)).params("out_trade_no", str3)).params("uuid", e5.m5988().m5991())).execute(new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.PayController.2
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postCancelWechatOrder(String str, String str2, String str3, CallBack<String> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(CANCEL_WECHAT_ORDER).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("current_user_id", str)).params("access_token", str2)).params("out_trade_no", str3)).execute(new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.PayController.5
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postGetAliOrder(String str, String str2, String str3, CallBack<String> callBack) {
        String strM7592 = n.m7588().m7592();
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(GET_ALI_ORDER).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("current_user_id", str)).params("access_token", str2)).params("id", str3)).params("client_nonce", strM7592)).params("uuid", e5.m5988().m5991())).executeJWT(strM7592, 8, new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.PayController.1
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postGetWechatOrder(String str, String str2, String str3, CallBack<String> callBack) {
        String strM7592 = n.m7588().m7592();
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(GET_WECHAT_ORDER).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("current_user_id", str)).params("access_token", str2)).params("id", str3)).params("client_nonce", strM7592)).params(Constants.APP_ID, StoreController.WECHAT_APP_ID)).executeJWT(strM7592, 13, new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.PayController.4
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void queryAliPayOrder(String str, String str2, String str3, CallBack<String> callBack) {
        String strM7592 = n.m7588().m7592();
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(QUERY_ALIPAY_ORDER).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("current_user_id", str)).params("access_token", str2)).params("out_trade_no", str3)).params("client_nonce", strM7592)).params("uuid", e5.m5988().m5991())).executeJWT(strM7592, 7, new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.PayController.3
        });
    }

    public static void queryHuaweiOrder(String str, String str2, String str3, CallBack<String> callBack) {
        OkHttpUtils.post(QUERY_HUAWEI_ORDER + "?current_user_id=" + str + "&ANDROID_VERSION=130&locale=" + C5213.m15206() + "&OSVersion=" + Build.VERSION.RELEASE + "&manufacturer=" + Build.MANUFACTURER + "&phone_model_android=" + Build.MODEL + "&uuid=" + e5.m5988().m5991()).upJson(str3).execute(new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.PayController.8
        });
    }

    public static void queryPlayStoreOrder(String str, String str2, String str3, CallBack<String> callBack) {
        OkHttpUtils.post(QUERY_GOOGLE_ORDER + "?current_user_id=" + str + "&ANDROID_VERSION=130&locale=" + C5213.m15206() + "&OSVersion=" + Build.VERSION.RELEASE + "&manufacturer=" + Build.MANUFACTURER + "&phone_model_android=" + Build.MODEL + "&uuid=" + e5.m5988().m5991()).upJson(str3).execute(new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.PayController.7
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void queryWechatOrder(String str, String str2, String str3, CallBack<String> callBack) {
        String strM7592 = n.m7588().m7592();
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(QUERY_WECHAT_ORDER).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("current_user_id", str)).params("access_token", str2)).params("out_trade_no", str3)).params("client_nonce", strM7592)).executeJWT(strM7592, 7, new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.PayController.6
        });
    }
}
