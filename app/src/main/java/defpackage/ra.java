package defpackage;

import android.content.Context;
import android.text.TextUtils;
import defpackage.q9;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ra {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static w9 m8154() {
        try {
            try {
                return y9.m8629("NP", System.currentTimeMillis(), new fd(mc.m7550().m7555()), (short) q9.C2251.m8103(mc.m7550().m7554()), new vf());
            } catch (Exception unused) {
                return y9.m8630();
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static HashMap<String, String> m8155(pa paVar) throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        try {
            w9 w9VarM8154 = m8154();
            JSONObject jSONObject = new JSONObject();
            Context contextM7944 = paVar != null ? paVar.m7944() : null;
            if (contextM7944 == null) {
                contextM7944 = mc.m7550().m7554().getApplicationContext();
            }
            String strM8406 = ug.m8406(paVar, contextM7944);
            String strM8224 = sb.m8224(paVar, contextM7944);
            jSONObject.put("ap_q", w9VarM8154 != null ? w9VarM8154.m8523() : "");
            jSONObject.put("ap_link_token", paVar != null ? paVar.f8291 : "");
            jSONObject.put("u_pd", String.valueOf(ug.m8445()));
            jSONObject.put("u_lk", String.valueOf(ug.m8438(ug.m8425())));
            jSONObject.put("u_pi", String.valueOf(paVar != null ? paVar.f8294 : "_"));
            jSONObject.put("u_fu", strM8406);
            jSONObject.put("u_oi", strM8224);
            map.put("ap_req", jSONObject.toString());
            StringBuilder sb = new StringBuilder();
            sb.append(w9VarM8154 != null ? w9VarM8154.m8523() : "");
            sb.append("|");
            sb.append(strM8406);
            q9.m8086(paVar, "biz", "ap_q", sb.toString());
        } catch (Exception e2) {
            q9.m8087(paVar, "biz", "APMEx1", e2);
        }
        return map;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static JSONObject m8156(pa paVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("ap_resp");
        try {
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            return new JSONObject(strOptString);
        } catch (JSONException e2) {
            q9.m8087(paVar, "biz", "APMEx2", e2);
            return null;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m8157(pa paVar, HashMap<String, String> map) {
        JSONObject jSONObjectM7905 = p9.m7898().m7905();
        if (map == null || jSONObjectM7905 == null) {
            return;
        }
        q9.m8086(paVar, "biz", "ap_r", jSONObjectM7905.optString("ap_r"));
        map.putAll(ug.m8412(jSONObjectM7905));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m8158(pa paVar, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            jSONObject.putOpt("ap_args", jSONObject2);
        } catch (JSONException e2) {
            q9.m8087(paVar, "biz", "APMEx2", e2);
        }
    }
}
