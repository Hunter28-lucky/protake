package defpackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WXPay.java */
/* loaded from: classes.dex */
public class t7 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static t7 f8580;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public IWXAPI f8581;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f8582;

    /* renamed from: ԩ, reason: contains not printable characters */
    public InterfaceC2286 f8583;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String f8584;

    /* compiled from: WXPay.java */
    /* renamed from: t7$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2286 {
        void onSuccess(@Nullable String str);

        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo8295(@Nullable String str);

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo8296(@Nullable String str, int i);
    }

    public t7(Context context, String str) {
        this.f8584 = str;
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, str);
        this.f8581 = iwxapiCreateWXAPI;
        iwxapiCreateWXAPI.registerApp(str);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static t7 m8288() {
        return f8580;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m8289(Context context, String str) {
        f8580 = new t7(context, str);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean m8290() {
        return !r1.m8138(this.f8584) && this.f8581.isWXAppInstalled() && this.f8581.getWXAppSupportAPI() >= 570425345;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m8291() {
        f8580 = null;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m8292(String str, InterfaceC2286 interfaceC2286) {
        this.f8582 = str;
        this.f8583 = interfaceC2286;
        if (!m8290()) {
            InterfaceC2286 interfaceC22862 = this.f8583;
            if (interfaceC22862 != null) {
                interfaceC22862.mo8296(str, 1);
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f8582);
            C4638.m14099("qiaopc", "json = " + jSONObject);
            if (TextUtils.isEmpty(jSONObject.optString("AppId")) || TextUtils.isEmpty(jSONObject.optString("PartnerId")) || TextUtils.isEmpty(jSONObject.optString("PrepayId")) || TextUtils.isEmpty(jSONObject.optString("Package")) || TextUtils.isEmpty(jSONObject.optString("NonceStr")) || TextUtils.isEmpty(jSONObject.optString("Timestamp")) || TextUtils.isEmpty(jSONObject.optString("Sign"))) {
                InterfaceC2286 interfaceC22863 = this.f8583;
                if (interfaceC22863 != null) {
                    interfaceC22863.mo8296(str, 2);
                    return;
                }
                return;
            }
            PayReq payReq = new PayReq();
            payReq.appId = jSONObject.optString("AppId");
            payReq.partnerId = jSONObject.optString("PartnerId");
            payReq.prepayId = jSONObject.optString("PrepayId");
            payReq.packageValue = jSONObject.optString("Package");
            payReq.nonceStr = jSONObject.optString("NonceStr");
            payReq.timeStamp = jSONObject.optString("Timestamp");
            payReq.sign = jSONObject.optString("Sign");
            this.f8581.sendReq(payReq);
        } catch (JSONException e2) {
            e2.printStackTrace();
            InterfaceC2286 interfaceC22864 = this.f8583;
            if (interfaceC22864 != null) {
                interfaceC22864.mo8296(str, 2);
            }
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public IWXAPI m8293() {
        return this.f8581;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m8294(int i) {
        C4638.m14099("qiaopc", "onResp:" + i);
        InterfaceC2286 interfaceC2286 = this.f8583;
        if (interfaceC2286 == null) {
            return;
        }
        if (i == 0) {
            interfaceC2286.onSuccess("");
        } else if (i == -1) {
            interfaceC2286.mo8296("", 3);
        } else if (i == -2) {
            interfaceC2286.mo8295("");
        }
        this.f8583 = null;
    }
}
