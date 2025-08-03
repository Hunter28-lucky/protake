package com.blink.academy.film.support.controller;

import com.blink.academy.film.http.okhttp.OkHttpUtils;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.callback.CallBackProxy;
import com.blink.academy.film.http.okhttp.model.ApiResult;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.blink.academy.film.http.okhttp.request.PostRequest;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.netbean.UserInfoBean;
import com.blink.academy.film.netbean.UserMobileBean;
import com.blink.academy.film.netbean.VerifyResultBean;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.umeng.analytics.pro.am;
import defpackage.C2618;
import defpackage.C3659;
import defpackage.C4092;
import defpackage.e5;
import defpackage.w;

/* loaded from: classes.dex */
public class LoginController extends BaseController {
    private static final String CHANGE_PHONE_URL = "/v1/register/change_phone";
    private static final String GET_PHONE_NUMBER = "/v0/user/phone_number";
    private static final String LOGOUT_URL = "/v1/register/logout";
    private static final String MOB_ERROR_URL = "/v1/phonenum/mob_failed";
    public static final String REGISTER_URL = "/v2/register/phone_signin";
    private static final String UN_REGISTER_URL = "/v1/user/unregister";
    public static final String USER_INFO = "/v2/user/info";
    private static final String VERIFY_PHONE_NUMBER_URL = "/v1/phonenum/validate";

    /* JADX WARN: Multi-variable type inference failed */
    public static void doChangePhone(String str, String str2, String str3, String str4, String str5, String str6, CallBack<String> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(CHANGE_PHONE_URL).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("current_user_id", str)).params("allow_server_sms", "true")).params("access_token", str2)).params("phone_number", str4)).params("old_phone", C2618.m9569("user_login_phone_sp", ""))).params("zone", str3)).params("verify_code", str5)).params("sms_channel", str6)).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular")).execute(new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.LoginController.4
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void doLogout(String str, String str2, CallBack<String> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(LOGOUT_URL).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("current_user_id", str)).params("access_token", str2)).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular")).execute(new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.LoginController.2
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void doRegister(String str, String str2, String str3, String str4, String str5, CallBack<UserBean> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(REGISTER_URL).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("zone", str2)).params("allow_server_sms", "true")).params("client_nonce", str)).params("phone_number", str3)).params("verify_code", str4)).params("sms_channel", str5)).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular")).executeJWT(str, 2, new CallBackProxy<ApiResult<UserBean>, UserBean>(callBack) { // from class: com.blink.academy.film.support.controller.LoginController.1
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void doVerifyPhoneNumber(String str, String str2, String str3, String str4, CallBack<VerifyResultBean> callBack) {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(VERIFY_PHONE_NUMBER_URL).params("zone", str2)).params("client_timestamp", "" + jCurrentTimeMillis)).params("number", str3)).params("client_nonce", str)).params("token", w.m8495(str2 + str3 + jCurrentTimeMillis + "a9450392b0a85b379e35335fa56fb43825eb872de3cdf7d22ed4104e37af5017"))).params("uuid", e5.m5988().m5991())).params("verify_method", str4)).params("allow_server_sms", "true")).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular")).executeJWT(str, 4, new CallBackProxy<ApiResult<VerifyResultBean>, VerifyResultBean>(callBack) { // from class: com.blink.academy.film.support.controller.LoginController.3
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getPhoneNumber(String str, String str2, CallBack<UserMobileBean> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(GET_PHONE_NUMBER).params("current_user_id", str)).params("access_token", str2)).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular")).execute(new CallBackProxy<ApiResult<UserMobileBean>, UserMobileBean>(callBack) { // from class: com.blink.academy.film.support.controller.LoginController.7
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getUserInfo(String str, String str2, String str3, CallBack<UserInfoBean> callBack) {
        PostRequest postRequest = (PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(USER_INFO).params("current_user_id", str2)).params("access_token", str3)).params("client_nonce", str)).params("isVIP", e5.m5988().m5993() ? "1" : "0")).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular");
        if (C2618.m9565("location__bool_res_sp", false)) {
            postRequest.params("zone", "51");
        }
        if (C3659.m11744().m11747() != null) {
            postRequest.params("playstore_purchase_tokens", C3659.m11744().m11749(0));
        }
        if (C3659.m11744().m11746() != null) {
            postRequest.params("hms_purchase_tokens", C3659.m11744().m11749(1));
        }
        postRequest.executeJWT(str, 5, new CallBackProxy<ApiResult<UserInfoBean>, UserInfoBean>(callBack) { // from class: com.blink.academy.film.support.controller.LoginController.5
        });
    }

    public static void postMobSmsErrorInfo(String str, CallBack<String> callBack) {
        OkHttpUtils.post(MOB_ERROR_URL).upJson(str).execute(callBack);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postUnRegister(String str, String str2, CallBack<String> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(UN_REGISTER_URL).params("current_user_id", str)).params("access_token", str2)).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular")).execute(new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.LoginController.6
        });
    }
}
