package defpackage;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import com.android.billingclient.api.Purchase;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.CacheHuaweiBean;
import com.blink.academy.film.netbean.CachePlayStoreBean;
import com.blink.academy.film.netbean.ErrorBean;
import com.blink.academy.film.netbean.MobErrorBean;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.netbean.VerifyResultBean;
import com.blink.academy.film.support.controller.LoginController;
import com.blink.academy.film.support.controller.PayController;
import com.blink.academy.film.support.pay.google.GooglePayHelper;
import com.blink.academy.film.support.pay.huawei.HuaweiPay;
import com.blink.academy.film.widgets.dialog.login.C1131;
import com.blink.academy.protake.R;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.google.gson.Gson;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import defpackage.C3608;
import java.util.Iterator;
import java.util.Map;

/* compiled from: LoginPresenter.java */
/* renamed from: ݒ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3703 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C1131 f12851;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f12852;

    /* renamed from: ԩ, reason: contains not printable characters */
    public DialogInterface.OnDismissListener f12853;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public InterfaceC3719 f12854;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public CallBack<UserBean> f12856;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f12858;

    /* renamed from: ԯ, reason: contains not printable characters */
    public String f12859;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f12860;

    /* renamed from: ԫ, reason: contains not printable characters */
    public InterfaceC3655 f12855 = new C3704();

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC4926 f12857 = new C3705();

    /* compiled from: LoginPresenter.java */
    /* renamed from: ݒ$Ϳ, reason: contains not printable characters */
    public class C3704 implements InterfaceC3655 {
        public C3704() {
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: Ϳ */
        public void mo3086() {
            if (C3703.this.f12860) {
                C3703.this.f12854.mo1355();
            }
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: Ԩ */
        public void mo3087() {
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: ԩ */
        public void mo3088() {
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: Ԫ */
        public void mo3089(String str, String str2) throws Resources.NotFoundException {
            C3703.this.f12852 = str2;
            C3608.m11650().m11660(str);
            Map<String, String> mapM11656 = C3608.m11650().m11656();
            if (mapM11656 != null) {
                Iterator<String> it = mapM11656.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (mapM11656.get(next).equals(str)) {
                        C3608.m11650().m11661(next);
                        break;
                    }
                }
            }
            if (C3703.this.f12851.m3144(str, C3703.this.f12852)) {
                C3703.this.f12851.m3137(1, 200, str, C3703.this.f12852, true);
            } else {
                if (!r1.m8143(C3703.this.f12852)) {
                    C3703.this.f12851.m3142(C3703.this.m11876(R.string.ERROR_PHONE_FORMAT_WRONG), false);
                    return;
                }
                C3703.this.f12851.m3143(true);
                C3703 c3703 = C3703.this;
                c3703.m11881(str, c3703.f12852);
            }
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: ԫ */
        public void mo3090() {
        }
    }

    /* compiled from: LoginPresenter.java */
    /* renamed from: ݒ$Ԩ, reason: contains not printable characters */
    public class C3705 implements InterfaceC4926 {

        /* compiled from: LoginPresenter.java */
        /* renamed from: ݒ$Ԩ$Ϳ, reason: contains not printable characters */
        public class C3706 extends CallBack<VerifyResultBean> {

            /* compiled from: LoginPresenter.java */
            /* renamed from: ݒ$Ԩ$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC3707 implements Runnable {
                public RunnableC3707() {
                }

                @Override // java.lang.Runnable
                public void run() throws Resources.NotFoundException {
                    C3703.this.f12851.m3135();
                    C3703.this.f12851.m3141(C3703.this.m11876(R.string.ERROR_NETWORK_ERROR));
                }
            }

            public C3706() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onCompleted() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onError(ApiException apiException) {
                FilmApp.m405().m427(new RunnableC3707());
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onStart() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public void onSuccess(VerifyResultBean verifyResultBean) throws Resources.NotFoundException {
                if (verifyResultBean == null || !verifyResultBean.isValidNumber()) {
                    C3703.this.f12851.m3142(FilmApp.m402().getResources().getString(R.string.ERROR_PHONE_FORMAT_WRONG), false);
                    return;
                }
                C3703.this.f12858 = "telesign".equals(verifyResultBean.getChannel());
                C3703.this.f12859 = verifyResultBean.getChannel();
                boolean z = "view".equals(verifyResultBean.getModel()) || C3703.this.f12858;
                C3703.this.f12851.m3143(true);
                if (C3703.this.f12858) {
                    C3703.this.f12851.m3145();
                } else {
                    C3703.this.m11879(C3608.m11650().m11655(), C3703.this.f12852, true, false, z);
                }
            }
        }

        /* compiled from: LoginPresenter.java */
        /* renamed from: ݒ$Ԩ$Ԩ, reason: contains not printable characters */
        public class C3708 extends CallBack<VerifyResultBean> {

            /* compiled from: LoginPresenter.java */
            /* renamed from: ݒ$Ԩ$Ԩ$Ϳ, reason: contains not printable characters */
            public class RunnableC3709 implements Runnable {
                public RunnableC3709() {
                }

                @Override // java.lang.Runnable
                public void run() throws Resources.NotFoundException {
                    C3703.this.f12851.m3135();
                    C3703.this.f12851.m3141(C3703.this.m11876(R.string.ERROR_NETWORK_ERROR));
                }
            }

            public C3708() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onCompleted() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onError(ApiException apiException) {
                FilmApp.m405().m427(new RunnableC3709());
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onStart() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public void onSuccess(VerifyResultBean verifyResultBean) throws Resources.NotFoundException {
                if (verifyResultBean == null || !verifyResultBean.isValidNumber()) {
                    C3703.this.f12851.m3142(FilmApp.m402().getResources().getString(R.string.ERROR_PHONE_FORMAT_WRONG), false);
                    return;
                }
                C3703.this.f12858 = "telesign".equals(verifyResultBean.getChannel());
                C3703.this.f12859 = verifyResultBean.getChannel();
                boolean z = "view".equals(verifyResultBean.getModel()) || C3703.this.f12858;
                C3703.this.f12851.m3143(true);
                if (C3703.this.f12858) {
                    C3703.this.f12851.m3145();
                } else {
                    C3703.this.m11879(C3608.m11650().m11655(), C3703.this.f12852, true, true, z);
                }
            }
        }

        public C3705() {
        }

        @Override // defpackage.InterfaceC4926
        /* renamed from: Ϳ */
        public void mo10066() throws Resources.NotFoundException {
            if (!r1.m8143(C3703.this.f12852)) {
                C3703.this.f12851.m3142(C3703.this.m11876(R.string.ERROR_PHONE_FORMAT_WRONG), false);
            } else {
                C3608.m11650().m11665(n.m7588().m7592(), C3608.m11650().m11655(), C3703.this.f12852, "voice", new C3708());
            }
        }

        @Override // defpackage.InterfaceC4926
        /* renamed from: Ԩ */
        public void mo10067() throws Resources.NotFoundException {
            if (!r1.m8143(C3703.this.f12852)) {
                C3703.this.f12851.m3142(C3703.this.m11876(R.string.ERROR_PHONE_FORMAT_WRONG), false);
            } else {
                C3608.m11650().m11665(n.m7588().m7592(), C3608.m11650().m11655(), C3703.this.f12852, "sms", new C3706());
            }
        }

        @Override // defpackage.InterfaceC4926
        /* renamed from: ԩ */
        public void mo10068(String str, String str2) {
            C3703.this.m11878(str, str2);
        }
    }

    /* compiled from: LoginPresenter.java */
    /* renamed from: ݒ$Ԫ, reason: contains not printable characters */
    public class C3710 extends CallBack<UserBean> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ String f12867;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f12868;

        /* compiled from: LoginPresenter.java */
        /* renamed from: ݒ$Ԫ$Ϳ, reason: contains not printable characters */
        public class C3711 extends CallBack<String> {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ UserBean f12870;

            public C3711(UserBean userBean) {
                this.f12870 = userBean;
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onCompleted() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onError(ApiException apiException) {
                if (C3703.m11871(apiException.getCode())) {
                    C3659.m11744().m11745(0);
                }
                C3710 c3710 = C3710.this;
                C3703.this.m11872(this.f12870, c3710.f12868);
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onStart() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onSuccess(String str) {
                C3659.m11744().m11745(0);
                C3710 c3710 = C3710.this;
                C3703.this.m11872(this.f12870, c3710.f12868);
            }
        }

        /* compiled from: LoginPresenter.java */
        /* renamed from: ݒ$Ԫ$Ԩ, reason: contains not printable characters */
        public class C3712 extends CallBack<String> {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ UserBean f12872;

            public C3712(UserBean userBean) {
                this.f12872 = userBean;
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onCompleted() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onError(ApiException apiException) {
                if (C3703.m11871(apiException.getCode())) {
                    C3659.m11744().m11745(0);
                }
                C3710 c3710 = C3710.this;
                C3703.this.m11872(this.f12872, c3710.f12868);
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onStart() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onSuccess(String str) {
                C3659.m11744().m11745(0);
                C3710 c3710 = C3710.this;
                C3703.this.m11872(this.f12872, c3710.f12868);
            }
        }

        public C3710(String str, String str2) {
            this.f12867 = str;
            this.f12868 = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ԩ, reason: contains not printable characters */
        public /* synthetic */ void m11886() throws Resources.NotFoundException {
            C3703.this.f12851.m3142(C3703.this.m11876(R.string.ERROR_WRONG_VALIDATE_CODE), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: Ԫ, reason: contains not printable characters */
        public /* synthetic */ void m11887() throws Resources.NotFoundException {
            C3703.this.f12851.m3142(C3703.this.m11876(R.string.ERROR_WRONG_VALIDATE_CODE), false);
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            ErrorBean errorBean = apiException.getErrorBean();
            if (errorBean != null) {
                if (apiException.getCode() == 401) {
                    FilmApp.m405().m427(new Runnable() { // from class: ज़
                        @Override // java.lang.Runnable
                        public final void run() throws Resources.NotFoundException {
                            this.f14256.m11886();
                        }
                    });
                } else if (errorBean.getError_code() == 55) {
                    FilmApp.m405().m427(new Runnable() { // from class: ʉ
                        @Override // java.lang.Runnable
                        public final void run() throws Resources.NotFoundException {
                            this.f9913.m11887();
                        }
                    });
                }
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(UserBean userBean) {
            if (userBean != null && this.f12867.equals(userBean.getClient_nonce())) {
                e5.m5988().m5992(userBean);
                CachePlayStoreBean cachePlayStoreBeanM11747 = C3659.m11744().m11747();
                if (cachePlayStoreBeanM11747 != null) {
                    Purchase purchase = cachePlayStoreBeanM11747.getPurchase();
                    PayController.queryPlayStoreOrder(userBean.getId() + "", userBean.getAccess_token(), GooglePayHelper.generateGoogleJson(userBean.getId() + "", userBean.getAccess_token(), purchase.getOriginalJson(), purchase.getSignature()), new C3711(userBean));
                    return;
                }
                CacheHuaweiBean cacheHuaweiBeanM11746 = C3659.m11744().m11746();
                if (cacheHuaweiBeanM11746 == null) {
                    C3703.this.m11872(userBean, this.f12868);
                    return;
                }
                PayController.queryHuaweiOrder(userBean.getId() + "", userBean.getAccess_token(), HuaweiPay.generateHuaweiJson(userBean.getId() + "", userBean.getAccess_token(), cacheHuaweiBeanM11746.getInAppPurchaseData(), cacheHuaweiBeanM11746.getInAppSignature()), new C3712(userBean));
            }
        }
    }

    /* compiled from: LoginPresenter.java */
    /* renamed from: ݒ$Ԭ, reason: contains not printable characters */
    public class C3713 implements C3608.InterfaceC3610 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ String f12874;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ UserBean f12875;

        /* compiled from: LoginPresenter.java */
        /* renamed from: ݒ$Ԭ$Ϳ, reason: contains not printable characters */
        public class RunnableC3714 implements Runnable {
            public RunnableC3714() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C3659.m11744().m11745(0);
                C3703.this.f12851.m3130();
            }
        }

        public C3713(String str, UserBean userBean) {
            this.f12874 = str;
            this.f12875 = userBean;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: Ԭ, reason: contains not printable characters */
        public /* synthetic */ void m11891() throws Resources.NotFoundException {
            C3703.this.f12851.m3142(C3703.this.m11876(R.string.ERROR_NETWORK_ERROR), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ԭ, reason: contains not printable characters */
        public /* synthetic */ void m11892(String str, UserBean userBean) {
            C3703.this.f12851.m3130();
            if (e5.m5988().m5990() == null) {
                if (C3703.this.f12856 != null) {
                    C3703.this.f12856.onError(null);
                }
            } else {
                C2618.m9573("user_login_phone_sp", str);
                if (C3703.this.f12856 != null) {
                    C3703.this.f12856.onSuccess(userBean);
                }
            }
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: Ϳ */
        public void mo1336() {
            FilmApp filmAppM405 = FilmApp.m405();
            final String str = this.f12874;
            final UserBean userBean = this.f12875;
            filmAppM405.m427(new Runnable() { // from class: ల
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15588.m11892(str, userBean);
                }
            });
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: Ԩ */
        public void mo1337() {
            FilmApp.m405().m427(new Runnable() { // from class: ܡ
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f12761.m11891();
                }
            });
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: ԩ */
        public void mo1338(int i) {
            FilmApp.m405().m427(new RunnableC3714());
        }
    }

    /* compiled from: LoginPresenter.java */
    /* renamed from: ݒ$Ԯ, reason: contains not printable characters */
    public class C3715 extends CallBack<VerifyResultBean> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ String f12878;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f12879;

        public C3715(String str, String str2) {
            this.f12878 = str;
            this.f12879 = str2;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) throws Resources.NotFoundException {
            C3703.this.f12851.m3143(false);
            C3703.this.f12851.m3141(C3703.this.m11876(R.string.ERROR_NETWORK_ERROR));
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(VerifyResultBean verifyResultBean) throws Resources.NotFoundException {
            if (verifyResultBean == null || !verifyResultBean.isValidNumber()) {
                C3703.this.f12851.m3143(false);
                C3703.this.f12851.m3142(C3703.this.m11876(R.string.ERROR_PHONE_FORMAT_WRONG), false);
            } else {
                C3703.this.f12851.m3143(true);
                C3703.this.f12858 = "telesign".equals(verifyResultBean.getChannel());
                C3703.this.f12859 = verifyResultBean.getChannel();
                C3703.this.m11879(this.f12878, this.f12879, false, false, "view".equals(verifyResultBean.getModel()) || C3703.this.f12858);
            }
        }
    }

    /* compiled from: LoginPresenter.java */
    /* renamed from: ݒ$ՠ, reason: contains not printable characters */
    public class C3716 extends EventHandler {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f12881;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f12882;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f12883;

        /* compiled from: LoginPresenter.java */
        /* renamed from: ݒ$ՠ$Ϳ, reason: contains not printable characters */
        public class C3717 extends CallBack<String> {
            public C3717() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onCompleted() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onError(ApiException apiException) {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onStart() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onSuccess(String str) {
            }
        }

        public C3716(boolean z, String str, String str2) {
            this.f12881 = z;
            this.f12882 = str;
            this.f12883 = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: Ԫ, reason: contains not printable characters */
        public /* synthetic */ void m11897() throws Resources.NotFoundException {
            C3703.this.f12851.m3143(false);
            C3703 c3703 = C3703.this;
            c3703.m11875(c3703.f12852);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ԫ, reason: contains not printable characters */
        public /* synthetic */ void m11898() {
            C3703.this.f12851.m3145();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: Ԭ, reason: contains not printable characters */
        public /* synthetic */ void m11899() throws Resources.NotFoundException {
            C3703.this.f12851.m3143(false);
            C3703.this.f12851.m3141(C3703.this.m11876(R.string.ERROR_NETWORK_ERROR));
        }

        @Override // cn.smssdk.EventHandler
        public void afterEvent(int i, int i2, Object obj) {
            if (i2 == -1) {
                if (this.f12881) {
                    FilmApp.m405().m427(new Runnable() { // from class: Ġ
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f8858.m11898();
                        }
                    });
                    return;
                } else {
                    FilmApp.m405().m427(new Runnable() { // from class: ઋ
                        @Override // java.lang.Runnable
                        public final void run() throws Resources.NotFoundException {
                            this.f14781.m11897();
                        }
                    });
                    return;
                }
            }
            if (!this.f12881) {
                FilmApp.m405().m427(new Runnable() { // from class: ѥ
                    @Override // java.lang.Runnable
                    public final void run() throws Resources.NotFoundException {
                        this.f10647.m11899();
                    }
                });
            }
            MobErrorBean mobErrorBean = new MobErrorBean();
            mobErrorBean.setPhone_number(this.f12882);
            mobErrorBean.setZone(this.f12883);
            mobErrorBean.setEvent(i);
            mobErrorBean.setResult(i2);
            mobErrorBean.setClient_timestamp(System.currentTimeMillis());
            mobErrorBean.setVerify_method(i == 2 ? "voice" : "sms");
            mobErrorBean.setPlatform_type(AnalyticsConstants.SDK_TYPE);
            mobErrorBean.setPlatform_version(Build.VERSION.RELEASE);
            mobErrorBean.setApp_version("3.0.17");
            mobErrorBean.setApp_build(String.valueOf(130));
            mobErrorBean.setDevice_manufacturer(Build.MANUFACTURER);
            mobErrorBean.setDevice_model(Build.MODEL);
            mobErrorBean.setUuid(e5.m5988().m5991());
            mobErrorBean.setA_sha(FilmApp.m405().m409());
            mobErrorBean.setNetwork_type(C4092.f14229 ? NetworkUtil.NETWORK_TYPE_WIFI : "cellular");
            mobErrorBean.setPurpose("signin");
            mobErrorBean.setPlatform_locale(C5213.m15206());
            if (r1.m8142(obj)) {
                mobErrorBean.setData(obj.toString());
            }
            LoginController.postMobSmsErrorInfo(new Gson().toJson(mobErrorBean), new C3717());
        }
    }

    /* compiled from: LoginPresenter.java */
    /* renamed from: ݒ$ֈ, reason: contains not printable characters */
    public class C3718 extends CallBack<String> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC3720 f12886;

        public C3718(InterfaceC3720 interfaceC3720) {
            this.f12886 = interfaceC3720;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            InterfaceC3720 interfaceC3720 = this.f12886;
            if (interfaceC3720 != null) {
                interfaceC3720.onFail();
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            InterfaceC3720 interfaceC3720 = this.f12886;
            if (interfaceC3720 != null) {
                interfaceC3720.onSuc();
            }
        }
    }

    /* compiled from: LoginPresenter.java */
    /* renamed from: ݒ$֏, reason: contains not printable characters */
    public interface InterfaceC3719 {
        /* renamed from: Ϳ */
        void mo1355();
    }

    /* compiled from: LoginPresenter.java */
    /* renamed from: ݒ$ׯ, reason: contains not printable characters */
    public interface InterfaceC3720 {
        void onFail();

        void onSuc();
    }

    public C3703(Activity activity, DialogInterface.OnDismissListener onDismissListener, CallBack<UserBean> callBack, boolean z, boolean z2, InterfaceC3719 interfaceC3719) {
        this.f12851 = new C1131(activity, z, z2);
        this.f12856 = callBack;
        this.f12853 = onDismissListener;
        this.f12854 = interfaceC3719;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ވ, reason: contains not printable characters */
    public /* synthetic */ void m11870() throws Resources.NotFoundException {
        this.f12851.m3143(false);
        m11875(this.f12852);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public static boolean m11871(int i) {
        return i == 401;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m11872(UserBean userBean, String str) {
        C3608.m11650().m11659(userBean.getId() + "", userBean.getAccess_token(), new C3713(str, userBean));
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m11873() {
        this.f12851.m3129();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m11874(InterfaceC3720 interfaceC3720) {
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (userBeanM5990 != null) {
            LoginController.postUnRegister(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), new C3718(interfaceC3720));
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m11875(String str) throws Resources.NotFoundException {
        this.f12851.m3137(1, 200, C3608.m11650().m11655(), str, false);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final String m11876(int i) {
        return FilmApp.m402().getResources().getString(i);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m11877() {
        this.f12851.m3130();
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m11878(String str, String str2) {
        String strM7592 = n.m7588().m7592();
        C3608.m11650().m11654(strM7592, C3608.m11650().m11655(), str, str2, this.f12859, new C3710(strM7592, str));
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m11879(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (z3) {
            FilmApp.m405().m427(new Runnable() { // from class: ର
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f15279.m11870();
                }
            });
            return;
        }
        SMSSDK.registerEventHandler(new C3716(z, str2, str));
        if (z2) {
            SMSSDK.getVoiceVerifyCode(str, str2);
        } else {
            SMSSDK.getVerificationCode(str, str2);
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m11880(boolean z) {
        this.f12860 = z;
        this.f12851.m3138(this.f12855, this.f12857, this.f12853, C3608.m11650().m11658(), C3608.m11650().m11657(), z);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m11881(String str, String str2) {
        C3608.m11650().m11665(n.m7588().m7592(), str, str2, "sms", new C3715(str, str2));
    }
}
