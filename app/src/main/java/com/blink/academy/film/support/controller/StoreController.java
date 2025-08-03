package com.blink.academy.film.support.controller;

import com.blink.academy.film.http.okhttp.OkHttpUtils;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.callback.CallBackProxy;
import com.blink.academy.film.http.okhttp.model.ApiResult;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.blink.academy.film.http.okhttp.request.PostRequest;
import com.blink.academy.film.netbean.srt.SRTConnectionCallbackEntity;
import com.blink.academy.film.netbean.srt.SRTConnectionRoomIdCallbackEntity;
import com.blink.academy.film.netbean.store.AppConfigCallbackEntity;
import com.blink.academy.film.netbean.store.FilterTokenCallback;
import com.blink.academy.film.netbean.store.ModuleCallbackEntity;
import com.blink.academy.film.netbean.store.NvtInfoCallbackEntity;
import com.blink.academy.film.netbean.store.NvtProductListCallbackEntity;
import com.blink.academy.film.netbean.store.NvtReceiveRewardCallbackEntity;
import com.blink.academy.film.netbean.store.StoreCallbackEntity;
import com.blink.academy.film.netbean.store.SubscribeInfoCallback;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.umeng.analytics.pro.am;
import defpackage.C3659;
import defpackage.C4092;
import defpackage.e5;

/* loaded from: classes.dex */
public class StoreController extends BaseController {
    private static final String APP_CONFIG = "/v1/app/config";
    private static final String DO_REDEEM_URL = "/v1/iap/giftcode/redeem";
    private static final String FILTER_RECORD_FAIL_URL = "/v1/download/record_failed";
    private static final String FILTER_RECORD_SUC_URL = "/v1/download/record_succeed";
    private static final String GET_FILTER_SIGN_URL = "/v1/download/sign";
    private static final String MODULE_LIST_URL = "/v1/client/module_list";
    private static final String NVT_INFO = "/v1/nvt/info";
    private static final String NVT_PRODUCT_LIST = "/v1/nvt/product_list";
    private static final String NVT_PUT_BLACK_LIST = "/v1/nvt/blacklist/put";
    private static final String NVT_RECEIVE_REWARD = "/v1nvt/receive_award";
    public static final String PRODUCT_LIST_URL = "/v2/product/filter_group_list";
    private static final String SRT_CREATE = "/v1/srt/connection/create";
    private static final String SRT_ROOM_ID = "/v1/srt/room_id/create";
    private static final String SUBS_INFO_URL = "/v1/iap/android_product_list";
    public static String WECHAT_APP_ID = "";

    /* JADX WARN: Multi-variable type inference failed */
    public static void FilterRecordFail(String str, String str2, String str3, String str4, CallBack<String> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(FILTER_RECORD_FAIL_URL).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("current_user_id", str2)).params("access_token", str3)).params("file_ids", str4)).params("file_type", str)).params("receipt_type", C3659.m11744().m11747() == null ? "" : "play.store")).params("receipt_hash", C3659.m11744().m11747() != null ? C3659.m11744().m11749(0) : "")).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular")).execute(new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.5
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void FilterRecordSuc(String str, String str2, String str3, String str4, CallBack<String> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(FILTER_RECORD_SUC_URL).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("current_user_id", str2)).params("access_token", str3)).params("file_ids", str4)).params("file_type", str)).params("receipt_type", C3659.m11744().m11747() == null ? "" : "play.store")).params("receipt_hash", C3659.m11744().m11747() != null ? C3659.m11744().m11749(0) : "")).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular")).execute(new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.4
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void doReceiveReward(String str, String str2, String str3, CallBack<NvtReceiveRewardCallbackEntity> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(NVT_RECEIVE_REWARD).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("client_nonce", str)).params("current_user_id", str2)).params("uuid", e5.m5988().m5991())).params("access_token", str3)).executeJWT(str, 19, new CallBackProxy<ApiResult<NvtReceiveRewardCallbackEntity>, NvtReceiveRewardCallbackEntity>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.14
        });
    }

    public static void doRedeem(String str, String str2, CallBack<String> callBack) {
        OkHttpUtils.post(DO_REDEEM_URL).upJson(str2).executeJWT(str, 7, new CallBackProxy<ApiResult<String>, String>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.7
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getAppConfig(String str, String str2, String str3, CallBack<AppConfigCallbackEntity> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(APP_CONFIG).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("app_version", "130")).params("client_nonce", str)).params("current_user_id", str2)).params("access_token", str3)).params("client_version", "3")).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular")).params("playstore_purchase_tokens", C3659.m11744().m11747() == null ? "" : C3659.m11744().m11749(0))).params("hms_purchase_tokens", C3659.m11744().m11746() != null ? C3659.m11744().m11749(1) : "")).executeJWT(str, 14, new CallBackProxy<ApiResult<AppConfigCallbackEntity>, AppConfigCallbackEntity>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.8
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getFilterToken(String str, boolean z, String str2, String str3, String str4, CallBack<FilterTokenCallback> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(GET_FILTER_SIGN_URL).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("current_user_id", str2)).params("client_nonce", str)).params("access_token", str3)).params("file_ids", str4)).params("file_type", z ? "filter" : am.f17753e)).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular")).params("playstore_purchase_tokens", C3659.m11744().m11747() == null ? "" : C3659.m11744().m11749(0))).params("hms_purchase_tokens", C3659.m11744().m11746() != null ? C3659.m11744().m11749(1) : "")).executeJWT(str, 6, new CallBackProxy<ApiResult<FilterTokenCallback>, FilterTokenCallback>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.3
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getModuleList(String str, String str2, String str3, CallBack<ModuleCallbackEntity> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(MODULE_LIST_URL).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("app_version", "130")).params("client_nonce", str3)).params("current_user_id", str)).params("access_token", str2)).params("client_version", "3")).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular")).execute(new CallBackProxy<ApiResult<ModuleCallbackEntity>, ModuleCallbackEntity>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.6
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getNvtInfo(String str, String str2, String str3, CallBack<NvtInfoCallbackEntity> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(NVT_INFO).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("client_nonce", str)).params("current_user_id", str2)).params("uuid", e5.m5988().m5991())).params("access_token", str3)).executeJWT(str, 17, new CallBackProxy<ApiResult<NvtInfoCallbackEntity>, NvtInfoCallbackEntity>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.11
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getProductList(String str, String str2, String str3, CallBack<NvtProductListCallbackEntity> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(NVT_PRODUCT_LIST).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("client_nonce", str)).params("current_user_id", str2)).params("uuid", e5.m5988().m5991())).params("playstore_purchase_tokens", C3659.m11744().m11747() == null ? "" : C3659.m11744().m11749(0))).params("hms_purchase_tokens", C3659.m11744().m11746() != null ? C3659.m11744().m11749(1) : "")).params("access_token", str3)).executeJWT(str, 18, new CallBackProxy<ApiResult<NvtProductListCallbackEntity>, NvtProductListCallbackEntity>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.12
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getSRTRoomId(String str, boolean z, String str2, String str3, CallBack<SRTConnectionRoomIdCallbackEntity> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(SRT_ROOM_ID).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).connectTimeout(5000L)).retryCount(0)).params("current_user_id", str2)).params("access_token", str3)).params("client_nonce", str)).params("refresh_srt_room_id", z ? "true" : "")).params("playstore_purchase_tokens", C3659.m11744().m11747() == null ? "" : C3659.m11744().m11749(0))).params("hms_purchase_tokens", C3659.m11744().m11746() != null ? C3659.m11744().m11749(1) : "")).executeJWT(str, 15, new CallBackProxy<ApiResult<SRTConnectionRoomIdCallbackEntity>, SRTConnectionRoomIdCallbackEntity>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.9
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getSRTServerInfo(String str, String str2, String str3, String str4, boolean z, String str5, CallBack<SRTConnectionCallbackEntity> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(SRT_CREATE).connectTimeout(5000L)).retryCount(0)).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("client_nonce", str)).params("current_user_id", str2)).params("blacklist", str3)).params("access_token", str4)).params("srt_connection_type", z ? "camera" : "monitor")).params("srt_connection_version", "0.1")).params("srt_room_id", str5)).params("playstore_purchase_tokens", C3659.m11744().m11747() == null ? "" : C3659.m11744().m11749(0))).params("hms_purchase_tokens", C3659.m11744().m11746() != null ? C3659.m11744().m11749(1) : "")).executeJWT(str, 16, new CallBackProxy<ApiResult<SRTConnectionCallbackEntity>, SRTConnectionCallbackEntity>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.10
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getStoreList(String str, String str2, String str3, CallBack<StoreCallbackEntity> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(PRODUCT_LIST_URL).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("app_version", "130")).params("client_nonce", str)).params("current_user_id", str2)).params("access_token", str3)).params("client_version", "3")).params("isVIP", e5.m5988().m5993() ? "1" : "0")).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular")).params("playstore_purchase_tokens", C3659.m11744().m11747() == null ? "" : C3659.m11744().m11749(0))).params("hms_purchase_tokens", C3659.m11744().m11746() != null ? C3659.m11744().m11749(1) : "")).executeJWT(str, 1, new CallBackProxy<ApiResult<StoreCallbackEntity>, StoreCallbackEntity>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.1
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getSubsInfo(String str, String str2, String str3, CallBack<SubscribeInfoCallback> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(SUBS_INFO_URL).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("app_version", "130")).params("current_user_id", str2)).params("client_nonce", str)).params("access_token", str3)).params(am.T, C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular")).executeJWT(str, 3, new CallBackProxy<ApiResult<SubscribeInfoCallback>, SubscribeInfoCallback>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.2
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void putBlackList(String str, String str2, String str3, String str4, CallBack<SRTConnectionCallbackEntity> callBack) {
        ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkHttpUtils.post(NVT_PUT_BLACK_LIST).headers(HttpHeaders.HEAD_KEY_CONTENT_TYPE, "application/x-www-form-urlencoded")).params("client_nonce", str)).params("current_user_id", str2)).params("uuid", e5.m5988().m5991())).params("blacklist", str4)).params("access_token", str3)).executeJWT(str, 18, new CallBackProxy<ApiResult<SRTConnectionCallbackEntity>, SRTConnectionCallbackEntity>(callBack) { // from class: com.blink.academy.film.support.controller.StoreController.13
        });
    }
}
