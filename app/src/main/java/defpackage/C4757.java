package defpackage;

import android.app.Activity;
import com.android.billingclient.api.Purchase;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.support.controller.PayController;
import defpackage.C4757;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PayModel.java */
/* renamed from: ൾ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4757 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static C4757 f16029;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C5145 f16030;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f16031;

    /* compiled from: PayModel.java */
    /* renamed from: ൾ$Ϳ, reason: contains not printable characters */
    public class C4758 extends CallBack<String> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4768 f16032;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ Activity f16033;

        public C4758(InterfaceC4768 interfaceC4768, Activity activity) {
            this.f16032 = interfaceC4768;
            this.f16033 = activity;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static /* synthetic */ void m14325(InterfaceC4768 interfaceC4768) {
            if (interfaceC4768 != null) {
                interfaceC4768.mo438();
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            InterfaceC4768 interfaceC4768 = this.f16032;
            if (interfaceC4768 != null) {
                interfaceC4768.onFail();
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            Activity activity = this.f16033;
            final InterfaceC4768 interfaceC4768 = this.f16032;
            activity.runOnUiThread(new Runnable() { // from class: ӎ
                @Override // java.lang.Runnable
                public final void run() {
                    C4757.C4758.m14325(interfaceC4768);
                }
            });
        }
    }

    /* compiled from: PayModel.java */
    /* renamed from: ൾ$Ԩ, reason: contains not printable characters */
    public class C4759 implements InterfaceC4533 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4768 f16035;

        public C4759(InterfaceC4768 interfaceC4768) {
            this.f16035 = interfaceC4768;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: Ϳ */
        public void mo13874(String str) {
            InterfaceC4768 interfaceC4768 = this.f16035;
            if (interfaceC4768 != null) {
                interfaceC4768.onFail();
            }
            C4757.this.f16031 = false;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: Ԩ */
        public void mo13875(String str) {
            InterfaceC4768 interfaceC4768 = this.f16035;
            if (interfaceC4768 != null) {
                interfaceC4768.mo438();
            }
            C4757.this.f16031 = false;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: ԩ */
        public void mo13876(String str, String str2) {
            InterfaceC4768 interfaceC4768 = this.f16035;
            if (interfaceC4768 != null) {
                interfaceC4768.onFail();
            }
            C4757.this.f16031 = false;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: Ԫ */
        public void mo13877(String str) {
            InterfaceC4768 interfaceC4768 = this.f16035;
            if (interfaceC4768 != null) {
                interfaceC4768.mo438();
            }
            C4757.this.f16031 = false;
        }
    }

    /* compiled from: PayModel.java */
    /* renamed from: ൾ$Ԫ, reason: contains not printable characters */
    public class C4760 implements InterfaceC4533 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4768 f16037;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f16038;

        public C4760(InterfaceC4768 interfaceC4768, String str) {
            this.f16037 = interfaceC4768;
            this.f16038 = str;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: Ϳ */
        public void mo13874(String str) {
            InterfaceC4768 interfaceC4768 = this.f16037;
            if (interfaceC4768 != null) {
                interfaceC4768.onFail();
            }
            C4757.this.f16031 = false;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: Ԩ */
        public void mo13875(String str) {
            C4757.this.m14307(this.f16038, this.f16037);
            C4757.this.f16031 = false;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: ԩ */
        public void mo13876(String str, String str2) {
            InterfaceC4768 interfaceC4768 = this.f16037;
            if (interfaceC4768 != null) {
                interfaceC4768.onFail();
            }
            C4757.this.f16031 = false;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: Ԫ */
        public void mo13877(String str) {
            C4757.this.m14307(this.f16038, this.f16037);
            C4757.this.f16031 = false;
        }
    }

    /* compiled from: PayModel.java */
    /* renamed from: ൾ$Ԭ, reason: contains not printable characters */
    public class C4761 extends CallBack<String> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4768 f16040;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ Activity f16041;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f16042;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f16043;

        public C4761(InterfaceC4768 interfaceC4768, Activity activity, String str, String str2) {
            this.f16040 = interfaceC4768;
            this.f16041 = activity;
            this.f16042 = str;
            this.f16043 = str2;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            if (this.f16040 != null) {
                if (apiException.getCode() == 401) {
                    this.f16040.mo437();
                } else {
                    this.f16040.onFail();
                }
            }
            C4757.this.f16031 = false;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) throws JSONException {
            if (!r1.m8143(str)) {
                InterfaceC4768 interfaceC4768 = this.f16040;
                if (interfaceC4768 != null) {
                    interfaceC4768.onFail();
                }
                C4757.this.f16031 = false;
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.getBoolean("has_bought");
                C4757.this.f16031 = false;
                C4757.this.m14314(this.f16041, jSONObject.getString("pay_request"), this.f16042, this.f16043, jSONObject.getString("out_trade_no"), this.f16040);
            } catch (JSONException e2) {
                e2.printStackTrace();
                InterfaceC4768 interfaceC47682 = this.f16040;
                if (interfaceC47682 != null) {
                    interfaceC47682.onFail();
                }
                C4757.this.f16031 = false;
            }
        }
    }

    /* compiled from: PayModel.java */
    /* renamed from: ൾ$Ԯ, reason: contains not printable characters */
    public class C4762 implements InterfaceC4533 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4768 f16045;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f16046;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ Activity f16047;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f16048;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f16049;

        public C4762(InterfaceC4768 interfaceC4768, String str, Activity activity, String str2, String str3) {
            this.f16045 = interfaceC4768;
            this.f16046 = str;
            this.f16047 = activity;
            this.f16048 = str2;
            this.f16049 = str3;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: Ϳ */
        public void mo13874(String str) {
            InterfaceC4768 interfaceC4768 = this.f16045;
            if (interfaceC4768 != null) {
                interfaceC4768.onFail();
            }
            C4757.this.f16031 = false;
            C4757.this.m14318(this.f16046);
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: Ԩ */
        public void mo13875(String str) {
            C4757.this.m14308(this.f16047, this.f16048, this.f16049, this.f16046, this.f16045);
            C4757.this.f16031 = false;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: ԩ */
        public void mo13876(String str, String str2) {
            InterfaceC4768 interfaceC4768 = this.f16045;
            if (interfaceC4768 != null) {
                interfaceC4768.onFail();
            }
            C4757.this.f16031 = false;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: Ԫ */
        public void mo13877(String str) {
            C4757.this.m14308(this.f16047, this.f16048, this.f16049, this.f16046, this.f16045);
            C4757.this.f16031 = false;
        }
    }

    /* compiled from: PayModel.java */
    /* renamed from: ൾ$ՠ, reason: contains not printable characters */
    public class C4763 extends CallBack<String> {
        public C4763() {
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

    /* compiled from: PayModel.java */
    /* renamed from: ൾ$ֈ, reason: contains not printable characters */
    public class C4764 extends CallBack<String> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4768 f16052;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ Activity f16053;

        public C4764(InterfaceC4768 interfaceC4768, Activity activity) {
            this.f16052 = interfaceC4768;
            this.f16053 = activity;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static /* synthetic */ void m14327(InterfaceC4768 interfaceC4768) {
            if (interfaceC4768 != null) {
                interfaceC4768.mo438();
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            C4757.this.f16031 = false;
            InterfaceC4768 interfaceC4768 = this.f16052;
            if (interfaceC4768 != null) {
                interfaceC4768.onFail();
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            C4757.this.f16031 = false;
            Activity activity = this.f16053;
            final InterfaceC4768 interfaceC4768 = this.f16052;
            activity.runOnUiThread(new Runnable() { // from class: த
                @Override // java.lang.Runnable
                public final void run() {
                    C4757.C4764.m14327(interfaceC4768);
                }
            });
        }
    }

    /* compiled from: PayModel.java */
    /* renamed from: ൾ$֏, reason: contains not printable characters */
    public class C4765 extends CallBack<String> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4768 f16055;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ Activity f16056;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f16057;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f16058;

        public C4765(InterfaceC4768 interfaceC4768, Activity activity, String str, String str2) {
            this.f16055 = interfaceC4768;
            this.f16056 = activity;
            this.f16057 = str;
            this.f16058 = str2;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            if (this.f16055 != null) {
                if (apiException.getCode() == 401) {
                    this.f16055.mo437();
                } else {
                    this.f16055.onFail();
                }
            }
            C4757.this.f16031 = false;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) throws JSONException {
            if (!r1.m8143(str)) {
                InterfaceC4768 interfaceC4768 = this.f16055;
                if (interfaceC4768 != null) {
                    interfaceC4768.onFail();
                }
                C4757.this.f16031 = false;
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.getBoolean("has_bought");
                C4757.this.f16031 = false;
                C4757.this.m14310(this.f16056, jSONObject.getString("order_str"), this.f16057, this.f16058, jSONObject.getString("out_trade_no"), this.f16055);
            } catch (JSONException e2) {
                e2.printStackTrace();
                InterfaceC4768 interfaceC47682 = this.f16055;
                if (interfaceC47682 != null) {
                    interfaceC47682.onFail();
                }
                C4757.this.f16031 = false;
            }
        }
    }

    /* compiled from: PayModel.java */
    /* renamed from: ൾ$ׯ, reason: contains not printable characters */
    public class C4766 implements InterfaceC4533 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4768 f16060;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f16061;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ Activity f16062;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f16063;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f16064;

        public C4766(InterfaceC4768 interfaceC4768, String str, Activity activity, String str2, String str3) {
            this.f16060 = interfaceC4768;
            this.f16061 = str;
            this.f16062 = activity;
            this.f16063 = str2;
            this.f16064 = str3;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: Ϳ */
        public void mo13874(String str) {
            InterfaceC4768 interfaceC4768 = this.f16060;
            if (interfaceC4768 != null) {
                interfaceC4768.onFail();
            }
            C4757.this.f16031 = false;
            C4638.m14101("WME", "onCancel: " + str);
            C4757.this.m14317(this.f16061);
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: Ԩ */
        public void mo13875(String str) {
            C4638.m14101("WME", "onUncertainNeedCheck: " + str);
            C4757.this.m14305(this.f16062, this.f16063, this.f16064, this.f16061, this.f16060);
            C4757.this.f16031 = false;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: ԩ */
        public void mo13876(String str, String str2) {
            C4638.m14101("WME", "onPayFail: " + str + " reason: " + str2);
            InterfaceC4768 interfaceC4768 = this.f16060;
            if (interfaceC4768 != null) {
                interfaceC4768.onFail();
            }
            C4757.this.f16031 = false;
        }

        @Override // defpackage.InterfaceC4533
        /* renamed from: Ԫ */
        public void mo13877(String str) {
            C4638.m14101("WME", "onPaySuccess: " + str);
            C4757.this.m14305(this.f16062, this.f16063, this.f16064, this.f16061, this.f16060);
            C4757.this.f16031 = false;
        }
    }

    /* compiled from: PayModel.java */
    /* renamed from: ൾ$ؠ, reason: contains not printable characters */
    public class C4767 extends CallBack<String> {
        public C4767() {
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

    /* compiled from: PayModel.java */
    /* renamed from: ൾ$ހ, reason: contains not printable characters */
    public interface InterfaceC4768 {
        void onFail();

        /* renamed from: Ϳ */
        void mo437();

        /* renamed from: Ԩ */
        void mo438();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static C4757 m14304() {
        if (f16029 == null) {
            synchronized (C4792.class) {
                if (f16029 == null) {
                    f16029 = new C4757();
                }
            }
        }
        return f16029;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m14305(Activity activity, String str, String str2, String str3, InterfaceC4768 interfaceC4768) {
        PayController.queryAliPayOrder(str, str2, str3, new C4758(interfaceC4768, activity));
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m14306(Activity activity, List<Purchase> list, InterfaceC3866 interfaceC3866) {
        new C5145(2, activity).m15055(list, interfaceC3866);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m14307(String str, InterfaceC4768 interfaceC4768) {
        if (interfaceC4768 != null) {
            interfaceC4768.mo438();
        }
        this.f16031 = false;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m14308(Activity activity, String str, String str2, String str3, InterfaceC4768 interfaceC4768) {
        PayController.queryWechatOrder(str, str2, str3, new C4764(interfaceC4768, activity));
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m14309() {
        C5145 c5145 = this.f16030;
        if (c5145 != null) {
            c5145.destroy();
        }
        f16029 = null;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m14310(Activity activity, String str, String str2, String str3, String str4, InterfaceC4768 interfaceC4768) {
        m14313(activity, 1, str, new C4766(interfaceC4768, str4, activity, str2, str3));
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m14311(Activity activity, String str, boolean z, InterfaceC4768 interfaceC4768) {
        new C5145(2, activity).startPay(str, new C4760(interfaceC4768, str), z, false);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m14312(Activity activity, String str, InterfaceC4768 interfaceC4768) {
        C4759 c4759 = new C4759(interfaceC4768);
        C5145 c5145 = new C5145(4, activity);
        this.f16030 = c5145;
        c5145.startPay(str, c4759, true, false);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m14313(Activity activity, int i, String str, InterfaceC4533 interfaceC4533) {
        C5145 c5145 = new C5145(i, activity);
        this.f16030 = c5145;
        c5145.m15058(str, interfaceC4533);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m14314(Activity activity, String str, String str2, String str3, String str4, InterfaceC4768 interfaceC4768) {
        m14313(activity, 3, str, new C4762(interfaceC4768, str4, activity, str2, str3));
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m14315(Activity activity, int i, String str, String str2, String str3, String str4, String str5, InterfaceC4768 interfaceC4768) {
        m14316(activity, i, str, str2, str3, str4, str5, true, interfaceC4768);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m14316(Activity activity, int i, String str, String str2, String str3, String str4, String str5, boolean z, InterfaceC4768 interfaceC4768) {
        if (this.f16031) {
            return;
        }
        this.f16031 = true;
        if (i == 1) {
            m14321(activity, str, str2, str3, interfaceC4768);
            return;
        }
        if (i == 2) {
            m14311(activity, str4, z, interfaceC4768);
        } else if (i == 3) {
            m14322(activity, str, str2, str3, interfaceC4768);
        } else {
            if (i != 4) {
                return;
            }
            m14312(activity, str5, interfaceC4768);
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m14317(String str) {
        UserBean userBeanM5990 = e5.m5988().m5990();
        PayController.postCancelAliOrder(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), str, new C4767());
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m14318(String str) {
        UserBean userBeanM5990 = e5.m5988().m5990();
        PayController.postCancelWechatOrder(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), str, new C4763());
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m14319(Activity activity, String str, InterfaceC4875 interfaceC4875) {
        new C5145(2, activity).m15056(str, interfaceC4875);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m14320(Activity activity, boolean z, InterfaceC4886 interfaceC4886) {
        new C5145(2, activity).m15057(z, interfaceC4886);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m14321(Activity activity, String str, String str2, String str3, InterfaceC4768 interfaceC4768) {
        PayController.postGetAliOrder(str, str2, str3, new C4765(interfaceC4768, activity, str, str2));
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m14322(Activity activity, String str, String str2, String str3, InterfaceC4768 interfaceC4768) {
        PayController.postGetWechatOrder(str, str2, str3, new C4761(interfaceC4768, activity, str, str2));
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m14323(int i, Activity activity, String str, String str2, InterfaceC4875 interfaceC4875) {
        if (i == 1) {
            new C5145(2, activity).m15056(str, interfaceC4875);
        }
    }
}
