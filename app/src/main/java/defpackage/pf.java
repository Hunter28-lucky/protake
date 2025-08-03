package defpackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.ja;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class pf {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f8304 = true;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f8305 = true;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m7973(ja.C2124 c2124, String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (c2124 == null || str == null || (map = c2124.f7744) == null || (list = map.get(str)) == null) {
            return null;
        }
        return TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, list);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static JSONObject m7974(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put("method", str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static boolean m7975(ja.C2124 c2124) {
        return Boolean.valueOf(m7973(c2124, "msp-gzip")).booleanValue();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static boolean m7976(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            if (!jSONObject.has("params")) {
                return false;
            }
            String strOptString = jSONObject.getJSONObject("params").optString("public_key", null);
            if (TextUtils.isEmpty(strOptString)) {
                return false;
            }
            ec.m6004(strOptString);
            return true;
        } catch (JSONException e2) {
            hf.m6205(e2);
            return false;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public ic m7977(pa paVar, Context context) throws Throwable {
        return mo7969(paVar, context, "");
    }

    /* renamed from: Ԩ */
    public ic mo7969(pa paVar, Context context, String str) throws Throwable {
        return m7978(paVar, context, str, tg.m8326(context));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public ic m7978(pa paVar, Context context, String str, String str2) throws Throwable {
        return m7979(paVar, context, str, str2, true);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public ic m7979(pa paVar, Context context, String str, String str2, boolean z) throws Throwable {
        hf.m6207("mspl", "Packet: " + str2);
        kd kdVar = new kd(this.f8305);
        ic icVar = new ic(mo7970(paVar), mo7971(paVar, str, mo7189()));
        Map<String, String> mapMo7972 = mo7972(false, str);
        ne neVarM7199 = kdVar.m7199(icVar, this.f8304, mapMo7972.get("iSr"));
        ja.C2124 c2124M7106 = ja.m7106(context, new ja.C2123(str2, mo7972(neVarM7199.m7647(), str), neVarM7199.m7646()));
        if (c2124M7106 == null) {
            throw new RuntimeException("Response is null.");
        }
        ic icVarM7198 = kdVar.m7198(new ne(m7975(c2124M7106), c2124M7106.f7746), mapMo7972.get("iSr"));
        return (icVarM7198 != null && m7976(icVarM7198.m6288()) && z) ? m7979(paVar, context, str, str2, false) : icVarM7198;
    }

    /* renamed from: Ԭ */
    public String mo7970(pa paVar) throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        map.put("device", Build.MODEL);
        map.put("namespace", "com.alipay.mobilecashier");
        map.put("api_name", "com.alipay.mcpay");
        map.put("api_version", mo7190());
        return mo7188(paVar, map, new HashMap<>());
    }

    /* renamed from: ԭ */
    public String mo7971(pa paVar, String str, JSONObject jSONObject) throws JSONException {
        mc mcVarM7550 = mc.m7550();
        qa qaVarM8106 = qa.m8106(mcVarM7550.m7554());
        JSONObject jSONObjectM8128 = qe.m8128(new JSONObject(), jSONObject);
        try {
            jSONObjectM8128.put("external_info", str);
            jSONObjectM8128.put("tid", qaVarM8106.m8113());
            jSONObjectM8128.put("user_agent", mcVarM7550.m7552().m6013(paVar, qaVarM8106, mo7191()));
            jSONObjectM8128.put("has_alipay", ug.m8419(paVar, mcVarM7550.m7554(), ba.f140, false));
            jSONObjectM8128.put("has_msp_app", ug.m8450(mcVarM7550.m7554()));
            jSONObjectM8128.put("app_key", "2014052600006128");
            jSONObjectM8128.put("utdid", mcVarM7550.m7555());
            jSONObjectM8128.put("new_client_key", qaVarM8106.m8112());
            jSONObjectM8128.put("pa", ec.m6007(mcVarM7550.m7554()));
        } catch (Throwable th) {
            q9.m8087(paVar, "biz", "BodyErr", th);
            hf.m6205(th);
        }
        return jSONObjectM8128.toString();
    }

    /* renamed from: Ԯ */
    public String mo7188(pa paVar, HashMap<String, String> map, HashMap<String, String> map2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        if (map2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put("params", jSONObject3);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    /* renamed from: ԯ */
    public Map<String, String> mo7972(boolean z, String str) {
        HashMap map = new HashMap();
        map.put("msp-gzip", String.valueOf(z));
        map.put("Operation-Type", "alipay.msp.cashier.dispatch.bytes");
        map.put("content-type", "application/octet-stream");
        map.put("Version", "2.0");
        map.put("AppId", "TAOBAO");
        map.put("Msp-Param", ka.m7182(str));
        map.put("des-mode", "CBC");
        return map;
    }

    /* renamed from: ՠ */
    public abstract JSONObject mo7189() throws JSONException;

    /* renamed from: ؠ */
    public String mo7190() {
        return "4.9.0";
    }

    /* renamed from: ހ */
    public abstract boolean mo7191();
}
