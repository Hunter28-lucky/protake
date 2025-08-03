package defpackage;

import androidx.annotation.NonNull;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.netbean.UserInfoBean;
import com.blink.academy.film.netbean.VerifyResultBean;
import com.blink.academy.film.support.controller.LoginController;
import java.util.Map;

/* compiled from: LoginManager.java */
/* renamed from: ڸ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3608 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static C3608 f12540;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f12541;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f12542;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f12543;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String f12544;

    /* renamed from: ԫ, reason: contains not printable characters */
    public Map<String, String> f12545;

    /* compiled from: LoginManager.java */
    /* renamed from: ڸ$Ϳ, reason: contains not printable characters */
    public class C3609 extends CallBack<UserInfoBean> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC3610 f12546;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f12547;

        public C3609(InterfaceC3610 interfaceC3610, String str) {
            this.f12546 = interfaceC3610;
            this.f12547 = str;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            this.f12546.mo1337();
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(UserInfoBean userInfoBean) {
            C2618.m9570("location__bool_res_sp", false);
            if (userInfoBean == null) {
                C3891 c3891M13890 = C4535.m13880().m13890();
                if (c3891M13890 != null) {
                    c3891M13890.m12539(1);
                    C4535.m13880().m13915();
                }
                C2618.m9570("location__bool_info_sp", false);
                this.f12546.mo1338(0);
                return;
            }
            int user_status = userInfoBean.getUser_status();
            if (!this.f12547.equals(userInfoBean.getClient_nonce())) {
                user_status = 2;
            }
            boolean z = user_status == 1 || user_status == 2 || user_status == 3 || user_status == 4 || user_status == 5;
            if (user_status == 6) {
                C3659.m11744().m11745(0);
            }
            UserBean userBeanM5990 = e5.m5988().m5990();
            if (userInfoBean.isUser_is_logged_in() && !z) {
                userBeanM5990.setSubscription_expire_time(userInfoBean.getSubscription_expire_time());
                userBeanM5990.setIs_subscription_user(userInfoBean.isSubscription_is_valid());
                userBeanM5990.setUser_phone_number_desensitized(userInfoBean.getUser_phone_number_desensitized());
                userBeanM5990.setUser_phone_zone(userInfoBean.getUser_phone_zone());
                e5.m5988().m5996(userBeanM5990);
                C3891 c3891M138902 = C4535.m13880().m13890();
                if (c3891M138902 != null) {
                    c3891M138902.m12539(userInfoBean.isSubscription_is_valid() ? 2 : 1);
                    C4535.m13880().m13915();
                }
                C2618.m9570("location__bool_info_sp", userInfoBean.isSubscription_is_valid());
                this.f12546.mo1336();
                return;
            }
            if (z || userBeanM5990 != null || (C3659.m11744().m11747() == null && C3659.m11744().m11746() == null)) {
                C3891 c3891M138903 = C4535.m13880().m13890();
                if (c3891M138903 != null) {
                    c3891M138903.m12539(1);
                    C4535.m13880().m13915();
                }
                C2618.m9570("location__bool_info_sp", false);
                this.f12546.mo1338(user_status);
                return;
            }
            C2618.m9571("local_sub_date_sp", userInfoBean.getSubscription_expire_time());
            C2618.m9570("local_sub_pro_sp", userInfoBean.isSubscription_is_valid());
            C3659.m11744().m11751(1);
            C3891 c3891M138904 = C4535.m13880().m13890();
            if (c3891M138904 != null) {
                c3891M138904.m12539(userInfoBean.isSubscription_is_valid() ? 2 : 1);
                C4535.m13880().m13915();
            }
            C2618.m9570("location__bool_info_sp", userInfoBean.isSubscription_is_valid());
            this.f12546.mo1336();
        }
    }

    /* compiled from: LoginManager.java */
    /* renamed from: ڸ$Ԩ, reason: contains not printable characters */
    public interface InterfaceC3610 {
        /* renamed from: Ϳ */
        void mo1336();

        /* renamed from: Ԩ */
        void mo1337();

        /* renamed from: ԩ */
        void mo1338(int i);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static C3608 m11650() {
        if (f12540 == null) {
            synchronized (C3608.class) {
                if (f12540 == null) {
                    C3608 c3608 = new C3608();
                    f12540 = c3608;
                    c3608.m11652();
                }
            }
        }
        return f12540;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m11651(String str, String str2, String str3, String str4, CallBack<String> callBack) {
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (userBeanM5990 == null) {
            return;
        }
        LoginController.doChangePhone("" + userBeanM5990.getId(), userBeanM5990.getAccess_token(), str, str2, str3, str4, callBack);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* renamed from: Ԩ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m11652() {
        /*
            r6 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String[] r1 = defpackage.C5213.f17271
            int r2 = r1.length
            r3 = 1
        L9:
            if (r3 >= r2) goto L17
            r4 = r1[r3]
            int r5 = r3 + (-1)
            r5 = r1[r5]
            r0.put(r4, r5)
            int r3 = r3 + 2
            goto L9
        L17:
            com.blink.academy.film.FilmApp r1 = com.blink.academy.film.FilmApp.m405()
            java.lang.String r2 = "phone"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1
            if (r1 == 0) goto L34
            java.lang.String r1 = r1.getNetworkCountryIso()
            boolean r2 = defpackage.r1.m8143(r1)
            if (r2 == 0) goto L34
            java.lang.String r1 = r1.toUpperCase()
            goto L35
        L34:
            r1 = 0
        L35:
            boolean r2 = defpackage.r1.m8143(r1)
            java.lang.String r3 = "86"
            java.lang.String r4 = ""
            java.lang.String r5 = "CN"
            if (r2 == 0) goto L64
            boolean r2 = defpackage.C5213.m15214()
            if (r2 == 0) goto L51
            java.util.Locale r1 = new java.util.Locale
            r1.<init>(r4, r5)
            java.lang.String r1 = r1.getDisplayCountry()
            goto L6d
        L51:
            java.lang.Object r2 = r0.get(r1)
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            java.util.Locale r2 = new java.util.Locale
            r2.<init>(r4, r1)
            java.lang.String r2 = r2.getDisplayCountry()
            r5 = r1
            r1 = r2
            goto L6d
        L64:
            java.util.Locale r1 = new java.util.Locale
            r1.<init>(r4, r5)
            java.lang.String r1 = r1.getDisplayCountry()
        L6d:
            java.lang.String r2 = "中国"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L8d
            java.lang.String r2 = "中华人民共和国"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L8d
            java.lang.String r2 = "中國"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L8d
            java.lang.String r2 = "中華人民共和國"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L8f
        L8d:
            java.lang.String r1 = "中国大陆"
        L8f:
            r6.m11660(r3)
            r6.m11664(r3)
            r6.m11661(r5)
            r6.m11663(r1)
            r6.m11662(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C3608.m11652():void");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m11653(String str, String str2, CallBack<String> callBack) {
        LoginController.doLogout(str, str2, callBack);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m11654(String str, String str2, String str3, String str4, String str5, CallBack<UserBean> callBack) {
        LoginController.doRegister(str, str2, str3, str4, str5, callBack);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public String m11655() {
        return this.f12541;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Map<String, String> m11656() {
        return this.f12545;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public String m11657() {
        return this.f12544;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String m11658() {
        return this.f12542;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m11659(String str, String str2, @NonNull InterfaceC3610 interfaceC3610) {
        String strM7592 = n.m7588().m7592();
        LoginController.getUserInfo(strM7592, str, str2, new C3609(interfaceC3610, strM7592));
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public C3608 m11660(String str) {
        this.f12541 = str;
        return this;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public C3608 m11661(String str) {
        this.f12543 = str;
        return this;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public C3608 m11662(Map<String, String> map) {
        this.f12545 = map;
        return this;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public C3608 m11663(String str) {
        this.f12544 = str;
        return this;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public C3608 m11664(String str) {
        this.f12542 = str;
        return this;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m11665(String str, String str2, String str3, String str4, CallBack<VerifyResultBean> callBack) {
        LoginController.doVerifyPhoneNumber(str, str2, str3, str4, callBack);
    }
}
