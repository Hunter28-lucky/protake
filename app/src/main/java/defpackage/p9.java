package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.blink.academy.film.stream.FinderManager;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;
import com.polidea.rxandroidble2.ClientComponent;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class p9 {

    /* renamed from: ސ, reason: contains not printable characters */
    public static p9 f8249;

    /* renamed from: ތ, reason: contains not printable characters */
    public JSONObject f8276;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f8250 = ModuleDescriptor.MODULE_VERSION;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f8251 = false;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f8252 = "https://h5.m.taobao.com/mlapp/olist.html";

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f8253 = 10;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f8254 = true;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f8255 = true;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f8256 = false;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f8257 = false;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f8258 = false;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f8259 = true;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f8260 = true;

    /* renamed from: ֏, reason: contains not printable characters */
    public String f8261 = "";

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f8262 = false;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f8263 = false;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f8264 = false;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f8265 = false;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f8266 = true;

    /* renamed from: ރ, reason: contains not printable characters */
    public String f8267 = "";

    /* renamed from: ބ, reason: contains not printable characters */
    public String f8268 = "";

    /* renamed from: ޅ, reason: contains not printable characters */
    public boolean f8269 = false;

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean f8270 = false;

    /* renamed from: އ, reason: contains not printable characters */
    public boolean f8271 = false;

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean f8272 = false;

    /* renamed from: މ, reason: contains not printable characters */
    public boolean f8273 = false;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f8274 = 1000;

    /* renamed from: ދ, reason: contains not printable characters */
    public boolean f8275 = false;

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean f8277 = true;

    /* renamed from: ގ, reason: contains not printable characters */
    public List<C2226> f8278 = null;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f8279 = -1;

    /* renamed from: p9$Ϳ, reason: contains not printable characters */
    public class RunnableC2225 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ pa f8280;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ Context f8281;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f8282;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f8283;

        public RunnableC2225(pa paVar, Context context, boolean z, int i) {
            this.f8280 = paVar;
            this.f8281 = context;
            this.f8282 = z;
            this.f8283 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ic icVarM7977 = new kc().m7977(this.f8280, this.f8281);
                if (icVarM7977 != null) {
                    p9.this.m7908(this.f8280, icVarM7977.m6287());
                    p9.this.m7906(pa.m7943());
                    q9.m8085(this.f8280, "biz", "offcfg|" + this.f8282 + "|" + this.f8283);
                }
            } catch (Throwable th) {
                hf.m6205(th);
            }
        }
    }

    /* renamed from: p9$Ԩ, reason: contains not printable characters */
    public static final class C2226 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final String f8285;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final int f8286;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final String f8287;

        public C2226(String str, int i, String str2) {
            this.f8285 = str;
            this.f8286 = i;
            this.f8287 = str2;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static C2226 m7937(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new C2226(jSONObject.optString("pn"), jSONObject.optInt(am.aE, 0), jSONObject.optString("pk"));
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static List<C2226> m7938(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                C2226 c2226M7937 = m7937(jSONArray.optJSONObject(i));
                if (c2226M7937 != null) {
                    arrayList.add(c2226M7937);
                }
            }
            return arrayList;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public static JSONArray m7939(List<C2226> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<C2226> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(m7940(it.next()));
            }
            return jSONArray;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static JSONObject m7940(C2226 c2226) throws JSONException {
            if (c2226 == null) {
                return null;
            }
            try {
                return new JSONObject().put("pn", c2226.f8285).put(am.aE, c2226.f8286).put("pk", c2226.f8287);
            } catch (JSONException e2) {
                hf.m6205(e2);
                return null;
            }
        }

        public String toString() {
            return String.valueOf(m7940(this));
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static p9 m7898() {
        if (f8249 == null) {
            p9 p9Var = new p9();
            f8249 = p9Var;
            p9Var.m7930();
        }
        return f8249;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m7901() {
        return this.f8273;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean m7902() {
        return this.f8265;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int m7903() {
        return this.f8274;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final JSONObject m7904() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ClientComponent.NamedSchedulers.TIMEOUT, m7921());
        jSONObject.put("h5_port_degrade", m7935());
        jSONObject.put("tbreturl", m7928());
        jSONObject.put("configQueryInterval", m7914());
        jSONObject.put("launchAppSwitch", C2226.m7939(m7922()));
        jSONObject.put("scheme_pay_2", m7919());
        jSONObject.put("intercept_batch", m7918());
        jSONObject.put("deg_log_mcgw", m7915());
        jSONObject.put("deg_start_srv_first", m7916());
        jSONObject.put("prev_jump_dual", m7923());
        jSONObject.put("use_sc_only", m7917());
        jSONObject.put("bind_use_imp", m7912());
        jSONObject.put("retry_bnd_once", m7924());
        jSONObject.put("skip_trans", m7926());
        jSONObject.put("start_trans", m7902());
        jSONObject.put("up_before_pay", m7929());
        jSONObject.put("use_sc_lck_a", m7925());
        jSONObject.put("lck_k", m7920());
        jSONObject.put("bind_with_startActivity", m7913());
        jSONObject.put("startActivity_InsteadOf_Scheme", m7927());
        jSONObject.put("retry_aidl_activity_not_start", m7901());
        jSONObject.put("cfg_max_time", m7903());
        jSONObject.put("get_oa_id", m7934());
        jSONObject.put("notifyFailApp", m7932());
        jSONObject.put("enableStartActivityFallback", m7933());
        jSONObject.put("enableBindExFallback", m7931());
        jSONObject.put("startactivity_in_ui_thread", m7936());
        jSONObject.put("ap_args", m7905());
        return jSONObject;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public JSONObject m7905() {
        return this.f8276;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m7906(pa paVar) {
        try {
            JSONObject jSONObjectM7904 = m7904();
            ng.m7659(paVar, mc.m7550().m7554(), "alipay_cashier_dynamic_config", jSONObjectM7904.toString());
        } catch (Exception e2) {
            hf.m6205(e2);
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m7907(pa paVar, Context context, boolean z, int i) {
        q9.m8085(paVar, "biz", "oncfg|" + z + "|" + i);
        RunnableC2225 runnableC2225 = new RunnableC2225(paVar, context, z, i);
        if (!z || ug.m8449()) {
            Thread thread = new Thread(runnableC2225);
            thread.setName("AlipayDCP");
            thread.start();
            return;
        }
        int iM7903 = m7903();
        if (ug.m8418(iM7903, runnableC2225, "AlipayDCPBlok")) {
            return;
        }
        q9.m8091(paVar, "biz", "LogAppFetchConfigTimeout", "" + iM7903);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m7908(pa paVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("st_sdk_config");
            ra.m8158(paVar, jSONObjectOptJSONObject, ra.m8156(paVar, jSONObject));
            if (jSONObjectOptJSONObject != null) {
                m7910(jSONObjectOptJSONObject);
            } else {
                hf.m6210("DynCon", "empty config");
            }
        } catch (Throwable th) {
            hf.m6205(th);
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m7909(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            m7910(new JSONObject(str));
        } catch (Throwable th) {
            hf.m6205(th);
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m7910(JSONObject jSONObject) {
        this.f8250 = jSONObject.optInt(ClientComponent.NamedSchedulers.TIMEOUT, ModuleDescriptor.MODULE_VERSION);
        this.f8251 = jSONObject.optBoolean("h5_port_degrade", false);
        this.f8252 = jSONObject.optString("tbreturl", "https://h5.m.taobao.com/mlapp/olist.html").trim();
        this.f8253 = jSONObject.optInt("configQueryInterval", 10);
        this.f8278 = C2226.m7938(jSONObject.optJSONArray("launchAppSwitch"));
        this.f8254 = jSONObject.optBoolean("scheme_pay_2", true);
        this.f8255 = jSONObject.optBoolean("intercept_batch", true);
        this.f8258 = jSONObject.optBoolean("deg_log_mcgw", false);
        this.f8259 = jSONObject.optBoolean("deg_start_srv_first", true);
        this.f8260 = jSONObject.optBoolean("prev_jump_dual", true);
        this.f8261 = jSONObject.optString("use_sc_only", "");
        this.f8262 = jSONObject.optBoolean("bind_use_imp", false);
        this.f8263 = jSONObject.optBoolean("retry_bnd_once", false);
        this.f8264 = jSONObject.optBoolean("skip_trans", false);
        this.f8265 = jSONObject.optBoolean("start_trans", false);
        this.f8266 = jSONObject.optBoolean("up_before_pay", true);
        this.f8267 = jSONObject.optString("lck_k", "");
        this.f8272 = jSONObject.optBoolean("use_sc_lck_a", false);
        this.f8273 = jSONObject.optBoolean("retry_aidl_activity_not_start", false);
        this.f8275 = jSONObject.optBoolean("notifyFailApp", false);
        this.f8268 = jSONObject.optString("bind_with_startActivity", "");
        this.f8269 = jSONObject.optBoolean("startActivity_InsteadOf_Scheme", false);
        this.f8274 = jSONObject.optInt("cfg_max_time", 1000);
        this.f8277 = jSONObject.optBoolean("get_oa_id", true);
        this.f8270 = jSONObject.optBoolean("enableStartActivityFallback", false);
        this.f8271 = jSONObject.optBoolean("enableBindExFallback", false);
        this.f8256 = jSONObject.optBoolean("startactivity_in_ui_thread", false);
        this.f8276 = jSONObject.optJSONObject("ap_args");
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean m7911(Context context, int i) {
        if (this.f8279 == -1) {
            this.f8279 = ug.m8398();
            ng.m7659(pa.m7943(), context, "utdid_factor", String.valueOf(this.f8279));
        }
        return this.f8279 < i;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean m7912() {
        return this.f8262;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public String m7913() {
        return this.f8268;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public int m7914() {
        return this.f8253;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean m7915() {
        return this.f8258;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public boolean m7916() {
        return this.f8259;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public String m7917() {
        return this.f8261;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean m7918() {
        return this.f8255;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public boolean m7919() {
        return this.f8254;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public String m7920() {
        return this.f8267;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public int m7921() {
        int i = this.f8250;
        if (i < 1000 || i > 20000) {
            hf.m6207("DynCon", "time(def) = 10000");
            return ModuleDescriptor.MODULE_VERSION;
        }
        hf.m6207("DynCon", "time = " + this.f8250);
        return this.f8250;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public List<C2226> m7922() {
        return this.f8278;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public boolean m7923() {
        return this.f8260;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public boolean m7924() {
        return this.f8263;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean m7925() {
        return this.f8272;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public boolean m7926() {
        return this.f8264;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public boolean m7927() {
        return this.f8269;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public String m7928() {
        return this.f8252;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public boolean m7929() {
        return this.f8266;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m7930() {
        Context contextM7554 = mc.m7550().m7554();
        String strM7657 = ng.m7657(pa.m7943(), contextM7554, "alipay_cashier_dynamic_config", null);
        try {
            this.f8279 = Integer.parseInt(ng.m7657(pa.m7943(), contextM7554, "utdid_factor", FinderManager.MACHINE_NOT_VALID));
        } catch (Exception unused) {
        }
        m7909(strM7657);
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public boolean m7931() {
        return this.f8271;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public boolean m7932() {
        return this.f8275;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public boolean m7933() {
        return this.f8270;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public boolean m7934() {
        return this.f8277;
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public boolean m7935() {
        return this.f8251;
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public boolean m7936() {
        return this.f8256;
    }
}
