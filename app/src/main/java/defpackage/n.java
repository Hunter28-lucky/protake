package defpackage;

import androidx.annotation.NonNull;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.http.okhttp.OkHttpUtils;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.callback.SimpleCallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.netbean.srt.SRTConnectionCallbackEntity;
import com.blink.academy.film.netbean.srt.SRTConnectionRoomIdCallbackEntity;
import com.blink.academy.film.netbean.store.AppConfigCallbackEntity;
import com.blink.academy.film.netbean.store.NvtInfoCallbackEntity;
import com.blink.academy.film.netbean.store.NvtProductListCallbackEntity;
import com.blink.academy.film.netbean.store.StoreCallbackEntity;
import com.blink.academy.film.netbean.store.StoreMessageBean;
import com.blink.academy.film.netbean.store.SubscribeInfoCallback;
import com.blink.academy.film.stream.ban.ACBanBean;
import com.blink.academy.film.stream.ban.ACBanManager;
import com.blink.academy.film.support.controller.StoreController;
import com.blink.academy.protake.R;
import com.google.gson.Gson;
import java.util.List;
import java.util.Random;

/* compiled from: StoreManager.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: ހ, reason: contains not printable characters */
    public static n f8009;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C3287 f8010 = C3184.m10827().m10859();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C3699 f8011 = C3184.m10827().m10858();

    /* renamed from: ԩ, reason: contains not printable characters */
    public StoreCallbackEntity f8012;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public SubscribeInfoCallback f8013;

    /* renamed from: ԫ, reason: contains not printable characters */
    public NvtProductListCallbackEntity f8014;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public NvtInfoCallbackEntity f8015;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f8016;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String f8017;

    /* renamed from: ԯ, reason: contains not printable characters */
    public String f8018;

    /* renamed from: ՠ, reason: contains not printable characters */
    public String f8019;

    /* renamed from: ֈ, reason: contains not printable characters */
    public String f8020;

    /* renamed from: ֏, reason: contains not printable characters */
    public String f8021;

    /* renamed from: ׯ, reason: contains not printable characters */
    public String f8022;

    /* renamed from: ؠ, reason: contains not printable characters */
    public String f8023;

    /* compiled from: StoreManager.java */
    /* renamed from: n$Ϳ, reason: contains not printable characters */
    public class C2178 extends CallBack<StoreCallbackEntity> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC2187 f8024;

        public C2178(InterfaceC2187 interfaceC2187) {
            this.f8024 = interfaceC2187;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            C4638.m14099("slim", apiException);
            if (apiException.getCode() == 1009 || apiException.getCode() == 1004) {
                long jLongValue = C2618.m9567("temp_host_time_sp", 0L).longValue();
                String strM9569 = C2618.m9569("temp_host_sp", "");
                if (jLongValue <= 0 || !r1.m8143(strM9569)) {
                    C2618.m9572("temp_host_time_sp", System.currentTimeMillis());
                    C2618.m9573("temp_host_sp", "https://protake.nomoshoot.com");
                    OkHttpUtils.getInstance().setBaseUrl("https://protake.nomoshoot.com");
                    FilmApp.m405().m429("https://protake.nomoshoot.com");
                } else {
                    C2618.m9572("temp_host_time_sp", 0L);
                    C2618.m9573("temp_host_sp", "");
                    OkHttpUtils.getInstance().setBaseUrl("https://protake.dafork.com");
                    FilmApp.m405().m429("https://protake.dafork.com");
                }
            }
            InterfaceC2187 interfaceC2187 = this.f8024;
            if (interfaceC2187 != null) {
                interfaceC2187.mo1340();
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(StoreCallbackEntity storeCallbackEntity) {
            if (storeCallbackEntity == null) {
                InterfaceC2187 interfaceC2187 = this.f8024;
                if (interfaceC2187 != null) {
                    interfaceC2187.mo1340();
                    return;
                }
                return;
            }
            String client_nonce = storeCallbackEntity.getClient_nonce();
            String strM7608 = n.m7588().m7608();
            if (r1.m8143(strM7608) && strM7608.equals(client_nonce)) {
                n.this.f8012 = storeCallbackEntity;
                C4151.m13162().m13193(n.this.f8012, this.f8024);
            } else {
                InterfaceC2187 interfaceC21872 = this.f8024;
                if (interfaceC21872 != null) {
                    interfaceC21872.mo1340();
                }
            }
        }
    }

    /* compiled from: StoreManager.java */
    /* renamed from: n$Ԩ, reason: contains not printable characters */
    public class C2179 extends CallBack<AppConfigCallbackEntity> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC2186 f8026;

        public C2179(InterfaceC2186 interfaceC2186) {
            this.f8026 = interfaceC2186;
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
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(AppConfigCallbackEntity appConfigCallbackEntity) {
            if (appConfigCallbackEntity != null) {
                String client_nonce = appConfigCallbackEntity.getClient_nonce();
                String strM7607 = n.m7588().m7607();
                if (r1.m8143(strM7607) && strM7607.equals(client_nonce)) {
                    C2618.m9571("privacy_remote_v_sp", appConfigCallbackEntity.getLegal().getPrivacy_version_integer());
                    C2618.m9571("terms_remote_v_sp", appConfigCallbackEntity.getLegal().getTerms_version_integer());
                    if (C2618.m9566("terms_alert_v_sp2", 1) < appConfigCallbackEntity.getLegal().getTerms_version_integer()) {
                        C2618.m9570("terms_alert_sp", false);
                    }
                    if (this.f8026 != null) {
                        StoreController.WECHAT_APP_ID = appConfigCallbackEntity.getWxpay_app_id();
                        this.f8026.mo1373(appConfigCallbackEntity.getApp_alert());
                    }
                }
            }
        }
    }

    /* compiled from: StoreManager.java */
    /* renamed from: n$Ԫ, reason: contains not printable characters */
    public class C2180 extends SimpleCallBack<SRTConnectionCallbackEntity> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC2189 f8028;

        public C2180(InterfaceC2189 interfaceC2189) {
            this.f8028 = interfaceC2189;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            this.f8028.onFail(apiException);
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(SRTConnectionCallbackEntity sRTConnectionCallbackEntity) {
            this.f8028.onSuc(sRTConnectionCallbackEntity);
        }
    }

    /* compiled from: StoreManager.java */
    /* renamed from: n$Ԭ, reason: contains not printable characters */
    public class C2181 extends SimpleCallBack<SRTConnectionCallbackEntity> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC2189 f8030;

        public C2181(InterfaceC2189 interfaceC2189) {
            this.f8030 = interfaceC2189;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            this.f8030.onFail(apiException);
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(SRTConnectionCallbackEntity sRTConnectionCallbackEntity) {
            this.f8030.onSuc(sRTConnectionCallbackEntity);
        }
    }

    /* compiled from: StoreManager.java */
    /* renamed from: n$Ԯ, reason: contains not printable characters */
    public class C2182 extends CallBack<SRTConnectionRoomIdCallbackEntity> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC2188 f8032;

        public C2182(InterfaceC2188 interfaceC2188) {
            this.f8032 = interfaceC2188;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            this.f8032.onFail();
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(SRTConnectionRoomIdCallbackEntity sRTConnectionRoomIdCallbackEntity) {
            if (sRTConnectionRoomIdCallbackEntity != null) {
                String client_nonce = sRTConnectionRoomIdCallbackEntity.getClient_nonce();
                String strM7611 = n.m7588().m7611();
                if (r1.m8143(strM7611) && strM7611.equals(client_nonce)) {
                    this.f8032.mo1374(sRTConnectionRoomIdCallbackEntity);
                }
            }
        }
    }

    /* compiled from: StoreManager.java */
    /* renamed from: n$ՠ, reason: contains not printable characters */
    public class C2183 extends CallBack<SubscribeInfoCallback> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC2190 f8034;

        public C2183(InterfaceC2190 interfaceC2190) {
            this.f8034 = interfaceC2190;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            if (n.this.f8010 != null) {
                String strM11049 = n.this.f8010.m11049();
                if (r1.m8143(strM11049)) {
                    try {
                        n.this.f8013 = (SubscribeInfoCallback) new Gson().fromJson(strM11049, SubscribeInfoCallback.class);
                    } catch (Exception unused) {
                        apiException.printStackTrace();
                    }
                }
            }
            InterfaceC2190 interfaceC2190 = this.f8034;
            if (interfaceC2190 != null) {
                interfaceC2190.onFail();
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(SubscribeInfoCallback subscribeInfoCallback) {
            n.this.f8013 = subscribeInfoCallback;
            if (subscribeInfoCallback != null) {
                String client_nonce = subscribeInfoCallback.getClient_nonce();
                String strM7603 = n.m7588().m7603();
                if (r1.m8143(strM7603) && strM7603.equals(client_nonce)) {
                    if (n.this.f8010 == null) {
                        n.this.f8010 = new C3287();
                        n.this.f8010.m11051(new Gson().toJson(n.this.f8013));
                        C3184.m10827().m10835(n.this.f8010);
                    } else {
                        n.this.f8010.m11051(new Gson().toJson(n.this.f8013));
                        C3184.m10827().m10871(n.this.f8010);
                    }
                    InterfaceC2190 interfaceC2190 = this.f8034;
                    if (interfaceC2190 != null) {
                        interfaceC2190.onSuc();
                        return;
                    }
                    return;
                }
            }
            InterfaceC2190 interfaceC21902 = this.f8034;
            if (interfaceC21902 != null) {
                interfaceC21902.onFail();
            }
        }
    }

    /* compiled from: StoreManager.java */
    /* renamed from: n$ֈ, reason: contains not printable characters */
    public class C2184 extends CallBack<NvtProductListCallbackEntity> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC2190 f8036;

        public C2184(InterfaceC2190 interfaceC2190) {
            this.f8036 = interfaceC2190;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            if (n.this.f8011 != null) {
                String strM11846 = n.this.f8011.m11846();
                if (r1.m8143(strM11846)) {
                    try {
                        n.this.f8014 = (NvtProductListCallbackEntity) new Gson().fromJson(strM11846, NvtProductListCallbackEntity.class);
                    } catch (Exception unused) {
                        apiException.printStackTrace();
                    }
                }
            }
            InterfaceC2190 interfaceC2190 = this.f8036;
            if (interfaceC2190 != null) {
                interfaceC2190.onFail();
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(NvtProductListCallbackEntity nvtProductListCallbackEntity) {
            n.this.f8014 = nvtProductListCallbackEntity;
            if (n.this.f8014 != null) {
                String client_nonce = n.this.f8014.getClient_nonce();
                String strM7610 = n.m7588().m7610();
                if (r1.m8143(strM7610) && strM7610.equals(client_nonce)) {
                    if (n.this.f8011 == null) {
                        n.this.f8011 = new C3699();
                        n.this.f8011.m11848(new Gson().toJson(n.this.f8014));
                        C3184.m10827().m10834(n.this.f8011);
                    } else {
                        n.this.f8011.m11848(new Gson().toJson(n.this.f8014));
                        C3184.m10827().m10869(n.this.f8011);
                    }
                    InterfaceC2190 interfaceC2190 = this.f8036;
                    if (interfaceC2190 != null) {
                        interfaceC2190.onSuc();
                        return;
                    }
                    return;
                }
            }
            InterfaceC2190 interfaceC21902 = this.f8036;
            if (interfaceC21902 != null) {
                interfaceC21902.onFail();
            }
        }
    }

    /* compiled from: StoreManager.java */
    /* renamed from: n$֏, reason: contains not printable characters */
    public class C2185 extends CallBack<NvtInfoCallbackEntity> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC2190 f8038;

        public C2185(InterfaceC2190 interfaceC2190) {
            this.f8038 = interfaceC2190;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            n.this.f8015 = null;
            InterfaceC2190 interfaceC2190 = this.f8038;
            if (interfaceC2190 != null) {
                interfaceC2190.onFail();
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(NvtInfoCallbackEntity nvtInfoCallbackEntity) {
            if (!e5.m5988().m5994()) {
                n.this.f8015 = null;
                return;
            }
            n.this.f8015 = nvtInfoCallbackEntity;
            if (n.this.f8015 != null) {
                String client_nonce = n.this.f8015.getClient_nonce();
                String strM7609 = n.m7588().m7609();
                if (r1.m8143(strM7609) && strM7609.equals(client_nonce)) {
                    InterfaceC2190 interfaceC2190 = this.f8038;
                    if (interfaceC2190 != null) {
                        interfaceC2190.onSuc();
                        return;
                    }
                    return;
                }
            }
            InterfaceC2190 interfaceC21902 = this.f8038;
            if (interfaceC21902 != null) {
                interfaceC21902.onFail();
            }
        }
    }

    /* compiled from: StoreManager.java */
    /* renamed from: n$ׯ, reason: contains not printable characters */
    public interface InterfaceC2186 {
        /* renamed from: Ϳ */
        void mo1373(StoreMessageBean storeMessageBean);
    }

    /* compiled from: StoreManager.java */
    /* renamed from: n$ؠ, reason: contains not printable characters */
    public interface InterfaceC2187 {
        void onSuccess();

        /* renamed from: Ϳ */
        void mo1339();

        /* renamed from: Ԩ */
        void mo1340();
    }

    /* compiled from: StoreManager.java */
    /* renamed from: n$ހ, reason: contains not printable characters */
    public interface InterfaceC2188 {
        void onFail();

        /* renamed from: Ϳ */
        void mo1374(SRTConnectionRoomIdCallbackEntity sRTConnectionRoomIdCallbackEntity);
    }

    /* compiled from: StoreManager.java */
    /* renamed from: n$ށ, reason: contains not printable characters */
    public interface InterfaceC2189 {
        void onFail(ApiException apiException);

        void onSuc(SRTConnectionCallbackEntity sRTConnectionCallbackEntity);
    }

    /* compiled from: StoreManager.java */
    /* renamed from: n$ނ, reason: contains not printable characters */
    public interface InterfaceC2190 {
        void onFail();

        void onSuc();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static n m7588() {
        if (f8009 == null) {
            synchronized (n.class) {
                if (f8009 == null) {
                    f8009 = new n();
                }
            }
        }
        return f8009;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m7589() {
        this.f8015 = null;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m7590(InterfaceC2186 interfaceC2186) {
        String access_token;
        UserBean userBeanM5990 = e5.m5988().m5990();
        String str = "";
        if (userBeanM5990 != null) {
            str = userBeanM5990.getId() + "";
            access_token = userBeanM5990.getAccess_token();
        } else {
            access_token = "";
        }
        String strM7592 = m7592();
        this.f8018 = strM7592;
        StoreController.getAppConfig(strM7592, str, access_token, new C2179(interfaceC2186));
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final String m7591(int i) {
        switch (i) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            default:
                return "";
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public String m7592() {
        String str;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            if (random.nextBoolean()) {
                str = ((char) (random.nextInt(26) + 65)) + "";
            } else if (random.nextBoolean()) {
                str = "" + Math.min(random.nextInt(10), 9);
            } else {
                str = "" + Math.min(random.nextInt(10), 97);
            }
            sb.append(str);
        }
        return sb.toString();
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public String m7593() {
        if (r1.m8137(this.f8013)) {
            return "";
        }
        if (C5213.m15210()) {
            if (this.f8013.getSubscription_price_cny() == this.f8013.getSubscription_price_cny_origin()) {
                return "";
            }
            float subscription_price_cny = (this.f8013.getSubscription_price_cny() / this.f8013.getSubscription_price_cny_origin()) * 10.0f;
            int i = (int) subscription_price_cny;
            return subscription_price_cny == ((float) i) ? m7591(i) : m7591(Math.round(subscription_price_cny));
        }
        if (this.f8013.getSubscription_price_usd() == this.f8013.getSubscription_price_usd_origin()) {
            return "";
        }
        float subscription_price_usd = this.f8013.getSubscription_price_usd() / this.f8013.getSubscription_price_usd_origin();
        int i2 = ((int) subscription_price_usd) * 10;
        if (subscription_price_usd * 10.0f == i2) {
            return i2 + "%";
        }
        return (Math.round((1.0f - subscription_price_usd) * 10.0f) * 10) + "%";
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m7594(InterfaceC2190 interfaceC2190) {
        String access_token;
        UserBean userBeanM5990 = e5.m5988().m5990();
        String str = "";
        if (userBeanM5990 != null) {
            str = userBeanM5990.getId() + "";
            access_token = userBeanM5990.getAccess_token();
        } else {
            access_token = "";
        }
        String strM7592 = m7592();
        this.f8022 = strM7592;
        StoreController.getNvtInfo(strM7592, str, access_token, new C2185(interfaceC2190));
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public NvtInfoCallbackEntity m7595() {
        return this.f8015;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m7596(InterfaceC2190 interfaceC2190) {
        String access_token;
        UserBean userBeanM5990 = e5.m5988().m5990();
        String str = "";
        if (userBeanM5990 != null) {
            str = userBeanM5990.getId() + "";
            access_token = userBeanM5990.getAccess_token();
        } else {
            access_token = "";
        }
        String strM7592 = m7592();
        this.f8021 = strM7592;
        StoreController.getProductList(strM7592, str, access_token, new C2184(interfaceC2190));
    }

    /* renamed from: އ, reason: contains not printable characters */
    public NvtProductListCallbackEntity m7597() {
        return this.f8014;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public String m7598() {
        return r1.m8137(this.f8013) ? C5213.m15210() ? String.format("%s%s", FilmApp.m402().getResources().getString(R.string.PRICE_UNIT), "148") : String.format("%s%s", FilmApp.m402().getResources().getString(R.string.PRICE_UNIT), "19.99") : C5213.m15210() ? String.format("%s%s", FilmApp.m402().getResources().getString(R.string.PRICE_UNIT), String.valueOf(this.f8013.getShow_Subscription_price_cny_Origin())) : String.format("%s%s", FilmApp.m402().getResources().getString(R.string.PRICE_UNIT), String.valueOf(this.f8013.getShow_Subscription_price_usd_Origin()));
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m7599(@NonNull InterfaceC2189 interfaceC2189, boolean z, String str) {
        String str2;
        String access_token;
        String[] strArr;
        this.f8020 = m7592();
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (userBeanM5990 != null) {
            String str3 = userBeanM5990.getId() + "";
            access_token = userBeanM5990.getAccess_token();
            str2 = str3;
        } else {
            str2 = "";
            access_token = str2;
        }
        List<ACBanBean> list = ACBanManager.getInstance().getList();
        if (r1.m8144(list)) {
            strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strArr[i] = list.get(i).getUuid();
            }
        } else {
            strArr = new String[0];
        }
        StoreController.getSRTServerInfo(this.f8020, str2, z ? new Gson().toJson(strArr) : "", access_token, z, str, new C2180(interfaceC2189));
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m7600(boolean z, @NonNull InterfaceC2188 interfaceC2188) {
        String access_token;
        UserBean userBeanM5990 = e5.m5988().m5990();
        String str = "";
        if (userBeanM5990 != null) {
            str = userBeanM5990.getId() + "";
            access_token = userBeanM5990.getAccess_token();
        } else {
            access_token = "";
        }
        String strM7592 = m7592();
        this.f8019 = strM7592;
        StoreController.getSRTRoomId(strM7592, z, str, access_token, new C2182(interfaceC2188));
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public StoreCallbackEntity m7601() {
        return this.f8012;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m7602(InterfaceC2187 interfaceC2187) {
        String access_token;
        UserBean userBeanM5990 = e5.m5988().m5990();
        String str = "";
        if (userBeanM5990 != null) {
            str = userBeanM5990.getId() + "";
            access_token = userBeanM5990.getAccess_token();
        } else {
            access_token = "";
        }
        String strM7592 = m7592();
        this.f8016 = strM7592;
        StoreController.getStoreList(strM7592, str, access_token, new C2178(interfaceC2187));
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public String m7603() {
        return this.f8017;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m7604(InterfaceC2190 interfaceC2190) {
        String access_token;
        UserBean userBeanM5990 = e5.m5988().m5990();
        String str = "";
        if (userBeanM5990 != null) {
            str = userBeanM5990.getId() + "";
            access_token = userBeanM5990.getAccess_token();
        } else {
            access_token = "";
        }
        String strM7592 = m7592();
        this.f8017 = strM7592;
        StoreController.getSubsInfo(strM7592, str, access_token, new C2183(interfaceC2190));
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public SubscribeInfoCallback m7605() {
        return this.f8013;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public String m7606() {
        return r1.m8137(this.f8013) ? C5213.m15210() ? String.format("%s%s", FilmApp.m402().getResources().getString(R.string.PRICE_UNIT), "148") : String.format("%s%s", FilmApp.m402().getResources().getString(R.string.PRICE_UNIT), "19.99") : C5213.m15210() ? String.format("%s%s", FilmApp.m402().getResources().getString(R.string.PRICE_UNIT), String.valueOf(this.f8013.getShow_Subscription_price_cny())) : String.format("%s%s", FilmApp.m402().getResources().getString(R.string.PRICE_UNIT), String.valueOf(this.f8013.getShow_Subscription_price_usd()));
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public String m7607() {
        return this.f8018;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public String m7608() {
        return this.f8016;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public String m7609() {
        return this.f8022;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public String m7610() {
        return this.f8021;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public String m7611() {
        return this.f8019;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public void m7612(@NonNull InterfaceC2189 interfaceC2189) {
        String access_token;
        String[] strArr;
        this.f8023 = m7592();
        UserBean userBeanM5990 = e5.m5988().m5990();
        String str = "";
        if (userBeanM5990 != null) {
            str = userBeanM5990.getId() + "";
            access_token = userBeanM5990.getAccess_token();
        } else {
            access_token = "";
        }
        List<ACBanBean> list = ACBanManager.getInstance().getList();
        if (r1.m8144(list)) {
            strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strArr[i] = list.get(i).getUuid();
            }
        } else {
            strArr = new String[0];
        }
        StoreController.putBlackList(this.f8023, str, access_token, new Gson().toJson(strArr), new C2181(interfaceC2189));
    }
}
