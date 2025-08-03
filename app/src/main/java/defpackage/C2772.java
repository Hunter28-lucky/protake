package defpackage;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.ErrorBean;
import com.blink.academy.film.netbean.MobErrorBean;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.netbean.VerifyResultBean;
import com.blink.academy.film.support.controller.LoginController;
import com.blink.academy.film.widgets.dialog.login.C1118;
import com.blink.academy.protake.R;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.google.gson.Gson;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import defpackage.C3608;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ChangePhonePresenter.java */
/* renamed from: ΐ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2772 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C1118 f10131;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public DialogInterface.OnDismissListener f10132;

    /* renamed from: ԩ, reason: contains not printable characters */
    public InterfaceC2787 f10133;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String f10134;

    /* renamed from: ԫ, reason: contains not printable characters */
    public InterfaceC3655 f10135 = new C2773();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC4926 f10136 = new C2774();

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f10137;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String f10138;

    /* compiled from: ChangePhonePresenter.java */
    /* renamed from: ΐ$Ϳ, reason: contains not printable characters */
    public class C2773 implements InterfaceC3655 {
        public C2773() {
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: Ϳ */
        public void mo3086() {
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
            C2772.this.f10134 = str2;
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
            if (C2772.this.f10131.m3084(str, C2772.this.f10134)) {
                C2772.this.f10131.m3077(1, 200, str, C2772.this.f10134, true);
            } else if (!r1.m8143(C2772.this.f10134)) {
                C2772.this.f10131.m3082(FilmApp.m402().getResources().getString(R.string.ERROR_PHONE_FORMAT_WRONG), false);
            } else {
                C2772 c2772 = C2772.this;
                c2772.m10065(str, c2772.f10134);
            }
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: ԫ */
        public void mo3090() {
        }
    }

    /* compiled from: ChangePhonePresenter.java */
    /* renamed from: ΐ$Ԩ, reason: contains not printable characters */
    public class C2774 implements InterfaceC4926 {

        /* compiled from: ChangePhonePresenter.java */
        /* renamed from: ΐ$Ԩ$Ϳ, reason: contains not printable characters */
        public class C2775 extends CallBack<VerifyResultBean> {

            /* compiled from: ChangePhonePresenter.java */
            /* renamed from: ΐ$Ԩ$Ϳ$Ϳ, reason: contains not printable characters */
            public class RunnableC2776 implements Runnable {
                public RunnableC2776() {
                }

                @Override // java.lang.Runnable
                public void run() throws Resources.NotFoundException {
                    C2772.this.f10131.m3075();
                    C2772.this.f10131.m3081(FilmApp.m402().getResources().getString(R.string.ERROR_NETWORK_ERROR));
                }
            }

            public C2775() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onCompleted() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onError(ApiException apiException) {
                FilmApp.m405().m427(new RunnableC2776());
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onStart() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public void onSuccess(VerifyResultBean verifyResultBean) throws Resources.NotFoundException {
                if (verifyResultBean == null || !verifyResultBean.isValidNumber()) {
                    C2772.this.f10131.m3082(FilmApp.m402().getResources().getString(R.string.ERROR_PHONE_FORMAT_WRONG), false);
                    return;
                }
                C2772.this.f10137 = "telesign".equals(verifyResultBean.getChannel());
                C2772.this.f10138 = verifyResultBean.getChannel();
                boolean z = "view".equals(verifyResultBean.getModel()) || C2772.this.f10137;
                C2772.this.f10131.m3083(true);
                if (C2772.this.f10137) {
                    C2772.this.f10131.m3085();
                } else {
                    C2772.this.m10063(C3608.m11650().m11655(), C2772.this.f10134, true, false, z);
                }
            }
        }

        /* compiled from: ChangePhonePresenter.java */
        /* renamed from: ΐ$Ԩ$Ԩ, reason: contains not printable characters */
        public class C2777 extends CallBack<String> {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ String f10143;

            /* compiled from: ChangePhonePresenter.java */
            /* renamed from: ΐ$Ԩ$Ԩ$Ϳ, reason: contains not printable characters */
            public class RunnableC2778 implements Runnable {
                public RunnableC2778() {
                }

                @Override // java.lang.Runnable
                public void run() throws Resources.NotFoundException {
                    C2772.this.f10131.m3082(FilmApp.m402().getResources().getString(R.string.ALERT_NUMBER_OCCUPIED), false);
                }
            }

            /* compiled from: ChangePhonePresenter.java */
            /* renamed from: ΐ$Ԩ$Ԩ$Ԩ, reason: contains not printable characters */
            public class RunnableC2779 implements Runnable {
                public RunnableC2779() {
                }

                @Override // java.lang.Runnable
                public void run() throws Resources.NotFoundException {
                    C2772.this.f10131.m3082(FilmApp.m402().getResources().getString(R.string.ALERT_WRONG_NUMBER), false);
                }
            }

            /* compiled from: ChangePhonePresenter.java */
            /* renamed from: ΐ$Ԩ$Ԩ$Ԫ, reason: contains not printable characters */
            public class RunnableC2780 implements Runnable {
                public RunnableC2780() {
                }

                @Override // java.lang.Runnable
                public void run() throws Resources.NotFoundException {
                    C2772.this.f10131.m3082(FilmApp.m402().getResources().getString(R.string.ERROR_NETWORK_ERROR), false);
                }
            }

            public C2777(String str) {
                this.f10143 = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: ԩ, reason: contains not printable characters */
            public /* synthetic */ void m10072() throws Resources.NotFoundException {
                C2772.this.f10131.m3082(FilmApp.m402().getResources().getString(R.string.ERROR_WRONG_VALIDATE_CODE), false);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: Ԫ, reason: contains not printable characters */
            public /* synthetic */ void m10073(String str) {
                C2772.this.f10131.m3068();
                C2618.m9573("user_login_phone_sp", str);
                C2772.this.m10062();
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onCompleted() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onError(ApiException apiException) {
                ErrorBean errorBean = apiException.getErrorBean();
                if (errorBean != null) {
                    int error_code = errorBean.getError_code();
                    if (error_code == 429 || error_code == 401 || error_code == 502) {
                        FilmApp.m405().m427(new Runnable() { // from class: ڈ
                            @Override // java.lang.Runnable
                            public final void run() throws Resources.NotFoundException {
                                this.f12307.m10072();
                            }
                        });
                        return;
                    }
                    if (error_code == 409) {
                        FilmApp.m405().m427(new RunnableC2778());
                    } else if (error_code == 400) {
                        FilmApp.m405().m427(new RunnableC2779());
                    } else {
                        FilmApp.m405().m427(new RunnableC2780());
                    }
                }
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onStart() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onSuccess(String str) {
                FilmApp filmAppM405 = FilmApp.m405();
                final String str2 = this.f10143;
                filmAppM405.m427(new Runnable() { // from class: ד
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11451.m10073(str2);
                    }
                });
            }
        }

        /* compiled from: ChangePhonePresenter.java */
        /* renamed from: ΐ$Ԩ$Ԫ, reason: contains not printable characters */
        public class C2781 extends CallBack<VerifyResultBean> {

            /* compiled from: ChangePhonePresenter.java */
            /* renamed from: ΐ$Ԩ$Ԫ$Ϳ, reason: contains not printable characters */
            public class RunnableC2782 implements Runnable {
                public RunnableC2782() {
                }

                @Override // java.lang.Runnable
                public void run() throws Resources.NotFoundException {
                    C2772.this.f10131.m3075();
                    C2772.this.f10131.m3081(FilmApp.m402().getResources().getString(R.string.ERROR_NETWORK_ERROR));
                }
            }

            public C2781() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onCompleted() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onError(ApiException apiException) {
                FilmApp.m405().m427(new RunnableC2782());
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            public void onStart() {
            }

            @Override // com.blink.academy.film.http.okhttp.callback.CallBack
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public void onSuccess(VerifyResultBean verifyResultBean) throws Resources.NotFoundException {
                if (verifyResultBean == null || !verifyResultBean.isValidNumber()) {
                    C2772.this.f10131.m3082(FilmApp.m402().getResources().getString(R.string.ERROR_PHONE_FORMAT_WRONG), false);
                    return;
                }
                C2772.this.f10137 = "telesign".equals(verifyResultBean.getChannel());
                C2772.this.f10138 = verifyResultBean.getChannel();
                boolean z = "view".equals(verifyResultBean.getModel()) || C2772.this.f10137;
                C2772.this.f10131.m3083(true);
                if (C2772.this.f10137) {
                    C2772.this.f10131.m3085();
                } else {
                    C2772.this.m10063(C3608.m11650().m11655(), C2772.this.f10134, true, true, z);
                }
            }
        }

        public C2774() {
        }

        @Override // defpackage.InterfaceC4926
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo10066() throws Resources.NotFoundException {
            if (!r1.m8143(C2772.this.f10134)) {
                C2772.this.f10131.m3082(FilmApp.m402().getResources().getString(R.string.ERROR_PHONE_FORMAT_WRONG), false);
            } else {
                C3608.m11650().m11665(n.m7588().m7592(), C3608.m11650().m11655(), C2772.this.f10134, "voice", new C2781());
            }
        }

        @Override // defpackage.InterfaceC4926
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo10067() throws Resources.NotFoundException {
            if (!r1.m8143(C2772.this.f10134)) {
                C2772.this.f10131.m3082(FilmApp.m402().getResources().getString(R.string.ERROR_PHONE_FORMAT_WRONG), false);
            } else {
                C3608.m11650().m11665(n.m7588().m7592(), C3608.m11650().m11655(), C2772.this.f10134, "sms", new C2775());
            }
        }

        @Override // defpackage.InterfaceC4926
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo10068(String str, String str2) {
            C3608.m11650().m11651(C3608.m11650().m11655(), str, str2, C2772.this.f10138, new C2777(str));
        }
    }

    /* compiled from: ChangePhonePresenter.java */
    /* renamed from: ΐ$Ԫ, reason: contains not printable characters */
    public class C2783 implements C3608.InterfaceC3610 {
        public C2783() {
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: Ϳ */
        public void mo1336() {
            if (C2772.this.f10133 != null) {
                C2772.this.f10133.onChange();
            }
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: Ԩ */
        public void mo1337() {
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: ԩ */
        public void mo1338(int i) {
        }
    }

    /* compiled from: ChangePhonePresenter.java */
    /* renamed from: ΐ$Ԭ, reason: contains not printable characters */
    public class C2784 extends CallBack<VerifyResultBean> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ String f10151;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f10152;

        public C2784(String str, String str2) {
            this.f10151 = str;
            this.f10152 = str2;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) throws Resources.NotFoundException {
            C2772.this.f10131.m3081(FilmApp.m402().getResources().getString(R.string.ERROR_NETWORK_ERROR));
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(VerifyResultBean verifyResultBean) throws Resources.NotFoundException {
            if (verifyResultBean == null || !verifyResultBean.isValidNumber()) {
                C2772.this.f10131.m3082(FilmApp.m402().getResources().getString(R.string.ERROR_PHONE_FORMAT_WRONG), false);
                return;
            }
            C2772.this.f10137 = "telesign".equals(verifyResultBean.getChannel());
            C2772.this.f10138 = verifyResultBean.getChannel();
            boolean z = "view".equals(verifyResultBean.getModel()) || C2772.this.f10137;
            C2772.this.f10131.m3083(true);
            C2772.this.m10063(this.f10151, this.f10152, false, false, z);
        }
    }

    /* compiled from: ChangePhonePresenter.java */
    /* renamed from: ΐ$Ԯ, reason: contains not printable characters */
    public class C2785 extends EventHandler {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f10154;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f10155;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f10156;

        /* compiled from: ChangePhonePresenter.java */
        /* renamed from: ΐ$Ԯ$Ϳ, reason: contains not printable characters */
        public class C2786 extends CallBack<String> {
            public C2786() {
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

        public C2785(boolean z, String str, String str2) {
            this.f10154 = z;
            this.f10155 = str;
            this.f10156 = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: Ԫ, reason: contains not printable characters */
        public /* synthetic */ void m10079() throws Resources.NotFoundException {
            C2772.this.f10131.m3083(false);
            C2772.this.f10131.m3077(1, 200, C3608.m11650().m11655(), C2772.this.f10134, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ԫ, reason: contains not printable characters */
        public /* synthetic */ void m10080() {
            C2772.this.f10131.m3085();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: Ԭ, reason: contains not printable characters */
        public /* synthetic */ void m10081() throws Resources.NotFoundException {
            C2772.this.f10131.m3083(false);
            C2772.this.f10131.m3081(FilmApp.m405().getResources().getString(R.string.ERROR_NETWORK_ERROR));
        }

        @Override // cn.smssdk.EventHandler
        public void afterEvent(int i, int i2, Object obj) {
            if (i2 == -1) {
                if (this.f10154) {
                    FilmApp.m405().m427(new Runnable() { // from class: ة
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f11795.m10080();
                        }
                    });
                    return;
                } else {
                    FilmApp.m405().m427(new Runnable() { // from class: ƚ
                        @Override // java.lang.Runnable
                        public final void run() throws Resources.NotFoundException {
                            this.f9023.m10079();
                        }
                    });
                    return;
                }
            }
            if (!this.f10154) {
                FilmApp.m405().m427(new Runnable() { // from class: ן
                    @Override // java.lang.Runnable
                    public final void run() throws Resources.NotFoundException {
                        this.f11533.m10081();
                    }
                });
            }
            MobErrorBean mobErrorBean = new MobErrorBean();
            mobErrorBean.setPhone_number(this.f10155);
            mobErrorBean.setZone(this.f10156);
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
            mobErrorBean.setPurpose("change_phone_number");
            mobErrorBean.setPlatform_locale(C5213.m15206());
            if (r1.m8142(obj)) {
                mobErrorBean.setData(obj.toString());
            }
            LoginController.postMobSmsErrorInfo(new Gson().toJson(mobErrorBean), new C2786());
        }
    }

    /* compiled from: ChangePhonePresenter.java */
    /* renamed from: ΐ$ՠ, reason: contains not printable characters */
    public interface InterfaceC2787 {
        void onChange();
    }

    public C2772(Activity activity, DialogInterface.OnDismissListener onDismissListener, InterfaceC2787 interfaceC2787, boolean z) {
        this.f10131 = new C1118(activity, z);
        this.f10132 = onDismissListener;
        this.f10133 = interfaceC2787;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m10061() {
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m10062() {
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (userBeanM5990 != null) {
            C3608.m11650().m11659(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), new C2783());
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m10063(String str, String str2, boolean z, boolean z2, boolean z3) throws Resources.NotFoundException {
        if (z3) {
            this.f10131.m3083(false);
            this.f10131.m3077(1, 200, C3608.m11650().m11655(), this.f10134, false);
            return;
        }
        SMSSDK.registerEventHandler(new C2785(z, str2, str));
        if (z2) {
            SMSSDK.getVoiceVerifyCode(str, str2);
        } else {
            SMSSDK.getVerificationCode(str, str2);
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m10064() throws Resources.NotFoundException {
        this.f10131.m3078(this.f10135, this.f10136, this.f10132, C3608.m11650().m11658(), C3608.m11650().m11657());
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m10065(String str, String str2) {
        C3608.m11650().m11665(n.m7588().m7592(), str, str2, "sms", new C2784(str, str2));
    }
}
