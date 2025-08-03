// TODO: REMOVE - This class is now a stub. All billing logic removed. Safe to delete after confirming no references remain.
package com.blink.academy.film.support.pay.google;

import android.app.Activity;
import android.os.Build;
import com.android.billingclient.api.Purchase;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.support.controller.PayController;
import com.blink.academy.film.support.pay.google.BillingManager;
import com.google.gson.Gson;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import defpackage.C2618;
import defpackage.C3659;
import defpackage.C4400;
import defpackage.C4638;
import defpackage.C4665;
import defpackage.C5213;
import defpackage.InterfaceC3866;
import defpackage.InterfaceC4183;
import defpackage.InterfaceC4533;
import defpackage.InterfaceC4875;
import defpackage.InterfaceC4886;
import defpackage.e5;
import defpackage.r1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GooglePayHelper implements InterfaceC4183 {
    private InterfaceC3866 consumeGooglePayCallBack;
    private boolean isQuery;
    private final BillingManager mBillingManager;
    private InterfaceC4533 mPayResultCallback;
    private String mProId;
    private InterfaceC4875 mQueryGooglePayCallback;
    private String TAG = "BillingManager";
    public BillingManager.BillingUpdatesListener mBillingUpdatesListener = new BillingManager.BillingUpdatesListener() {
        @Override public void onBillingClientSetupFailed() {}
        @Override public void onBillingClientSetupFinished() {}
        @Override public void onConsumeFinished(String str, int i) {
            if (consumeGooglePayCallBack != null) consumeGooglePayCallBack.mo1315();
        }
        @Override public void onPurchaseItemAlreadyOwned(String str) {
            if (mPayResultCallback != null) mPayResultCallback.mo13877(str);
        }
        @Override public void onPurchaseQueryFinished(String str, Object purchase) {
            if (mPayResultCallback != null) mPayResultCallback.mo13877(str);
        }
        @Override public void onPurchasesCanceled(String str) {
            if (mPayResultCallback != null) mPayResultCallback.mo13877(str);
        }
        @Override public void onPurchasesFailed(String str, int i) {
            if (mPayResultCallback != null) mPayResultCallback.mo13877(str);
        }
        @Override public void onPurchasesFinished(String str, List<Object> list) {
            if (mPayResultCallback != null) mPayResultCallback.mo13877(str);
        }
    };
    private boolean isSub = true;
    private boolean isConsume = false;
    private List<Object> inAppList = new ArrayList<>();

    public GooglePayHelper(Activity activity) {
        this.mBillingManager = new BillingManager(activity, this.mBillingUpdatesListener);
    }

    private void checkConsume() {
        if (consumeGooglePayCallBack != null) {
            consumeGooglePayCallBack.mo1315();
        }
    }

    public static String generateGoogleJson(String str, String str2, String str3, String str4) {
        VerifyBillingBean verifyBillingBean = new VerifyBillingBean();
        verifyBillingBean.setAccess_token(str2);
        verifyBillingBean.setCurrent_user_id(Integer.parseInt(str));
        verifyBillingBean.setSignature(str4);
        verifyBillingBean.setSignedData(str3);
        verifyBillingBean.setUuid(e5.m5988().m5991());
        verifyBillingBean.setPlatform_type(AnalyticsConstants.SDK_TYPE);
        verifyBillingBean.setPlatform_version(Build.VERSION.RELEASE);
        verifyBillingBean.setPlatform_locale(C5213.m15206());
        verifyBillingBean.setApp_version("3.0.17");
        verifyBillingBean.setApp_build(String.valueOf(130));
        verifyBillingBean.setDevice_manufacturer(Build.MANUFACTURER);
        verifyBillingBean.setDevice_model(Build.MODEL);
        verifyBillingBean.setA_sha(C4665.m14153(FilmApp.m402(), FilmApp.m402().getPackageName(), "SHA1"));
        return new Gson().toJson(verifyBillingBean);
    }

    private void verifyPurchase(final Object purchase, final String str) {
        if (mPayResultCallback != null) {
            mPayResultCallback.mo13877(str);
        }
    }

    public void checkIfHasSubHistory(String str, InterfaceC4875 interfaceC4875) {
        if (interfaceC4875 != null) {
            interfaceC4875.mo1310(new Object());
        }
    }

    public void checkInAppsPurchase(List<Object> list, InterfaceC3866 interfaceC3866) {
        if (interfaceC3866 != null) {
            interfaceC3866.mo1315();
        }
    }

    @Override
    public void destroy() {
        // No-op
    }

    public void queryPurchases(boolean z, final InterfaceC4886 interfaceC4886) {
        if (interfaceC4886 != null) {
            interfaceC4886.onQueryPurchases(new ArrayList<>());
        }
    }

    @Override
    public void startPay(String str, InterfaceC4533 interfaceC4533, boolean z, boolean z2) {
        if (interfaceC4533 != null) {
            interfaceC4533.mo13877(str);
        }
    }
}
