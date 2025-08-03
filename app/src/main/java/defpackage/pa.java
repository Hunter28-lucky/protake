package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.umeng.analytics.pro.am;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class pa {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f8288;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f8289;

    /* renamed from: ԩ, reason: contains not printable characters */
    public Context f8290;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String f8291;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final long f8292;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f8293;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final String f8294;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f8295 = false;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f8296 = false;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f8297 = false;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final ActivityInfo f8298;

    /* renamed from: ֏, reason: contains not printable characters */
    public final cc f8299;

    /* renamed from: pa$Ϳ, reason: contains not printable characters */
    public static final class C2227 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final HashMap<UUID, pa> f8300 = new HashMap<>();

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final HashMap<String, pa> f8301 = new HashMap<>();

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static pa m7964(Intent intent) {
            if (intent == null) {
                return null;
            }
            Serializable serializableExtra = intent.getSerializableExtra("i_uuid_b_c");
            if (serializableExtra instanceof UUID) {
                return f8300.remove((UUID) serializableExtra);
            }
            return null;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static pa m7965(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return f8301.remove(str);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public static void m7966(pa paVar, Intent intent) {
            if (paVar == null || intent == null) {
                return;
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            f8300.put(uuidRandomUUID, paVar);
            intent.putExtra("i_uuid_b_c", uuidRandomUUID);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static void m7967(pa paVar, String str) {
            if (paVar == null || TextUtils.isEmpty(str)) {
                return;
            }
            f8301.put(str, paVar);
        }
    }

    public pa(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        String str3;
        this.f8288 = "";
        this.f8289 = "";
        this.f8290 = null;
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        this.f8299 = new cc(context, zIsEmpty);
        String strM7942 = m7942(str, this.f8289);
        this.f8291 = strM7942;
        this.f8292 = SystemClock.elapsedRealtime();
        this.f8293 = ug.m8445();
        ActivityInfo activityInfoM8401 = ug.m8401(context);
        this.f8298 = activityInfoM8401;
        this.f8294 = str2;
        if (!zIsEmpty) {
            q9.m8086(this, "biz", "eptyp", str2 + "|" + strM7942);
            if (activityInfoM8401 != null) {
                str3 = activityInfoM8401.name + "|" + activityInfoM8401.launchMode;
            } else {
                str3 = "null";
            }
            q9.m8086(this, "biz", "actInfo", str3);
            q9.m8086(this, "biz", NotificationCompat.CATEGORY_SYSTEM, ug.m8405(this));
            q9.m8086(this, "biz", "sdkv", "5c4d8f1-clean");
        }
        try {
            this.f8290 = context.getApplicationContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f8288 = packageInfo.versionName;
            this.f8289 = packageInfo.packageName;
        } catch (Exception e2) {
            hf.m6205(e2);
        }
        if (!zIsEmpty) {
            q9.m8085(this, "biz", am.aH + ug.m8445());
            q9.m8086(this, "biz", "PgApiInvoke", "" + SystemClock.elapsedRealtime());
            q9.m8090(context, this, str, this.f8291);
        }
        if (zIsEmpty || !p9.m7898().m7929()) {
            return;
        }
        p9.m7898().m7907(this, this.f8290, true, 2);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static HashMap<String, String> m7941(pa paVar) {
        HashMap<String, String> map = new HashMap<>();
        if (paVar != null) {
            map.put("sdk_ver", "15.8.11");
            map.put("app_name", paVar.f8289);
            map.put("token", paVar.f8291);
            map.put("call_type", paVar.f8294);
            map.put("ts_api_invoke", String.valueOf(paVar.f8292));
            ra.m8157(paVar, map);
        }
        return map;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static String m7942(String str, String str2) {
        try {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[4];
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            if (str2 == null) {
                str2 = "";
            }
            objArr[1] = str2;
            objArr[2] = Long.valueOf(System.currentTimeMillis());
            objArr[3] = UUID.randomUUID().toString();
            return String.format("EP%s%s_%s", "1", ug.m8447(String.format(locale, "%s%s%d%s", objArr)), Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable unused) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public static pa m7943() {
        return null;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Context m7944() {
        return this.f8290;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m7945(String str) {
        return TextUtils.isEmpty(str) ? str : str.startsWith("new_external_info==") ? m7957(str) : m7962(str) ? m7955(str) : m7959(str);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String m7946(String str, String str2) {
        return str + m7948(new JSONObject()) + str2;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String m7947(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(str2);
        for (int i = 0; i < strArrSplit.length; i++) {
            if (!TextUtils.isEmpty(strArrSplit[i]) && strArrSplit[i].startsWith(str3)) {
                return strArrSplit[i];
            }
        }
        return null;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public String m7948(JSONObject jSONObject) {
        String str;
        try {
            if (!jSONObject.has("appkey")) {
                jSONObject.put("appkey", "2014052600006128");
            }
            if (!jSONObject.has("ty")) {
                jSONObject.put("ty", "and_lite");
            }
            if (!jSONObject.has("sv")) {
                jSONObject.put("sv", "h.a.3.8.11");
            }
            if (!jSONObject.has("an")) {
                jSONObject.put("an", this.f8289);
            }
            if (!jSONObject.has("av")) {
                jSONObject.put("av", this.f8288);
            }
            if (!jSONObject.has("sdk_start_time")) {
                jSONObject.put("sdk_start_time", System.currentTimeMillis());
            }
            if (!jSONObject.has("extInfo")) {
                jSONObject.put("extInfo", m7963());
            }
            if (!jSONObject.has("act_info")) {
                if (this.f8298 != null) {
                    str = this.f8298.name + "|" + this.f8298.launchMode;
                } else {
                    str = "null";
                }
                jSONObject.put("act_info", str);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            q9.m8088(this, "biz", "fmt3", th, String.valueOf(jSONObject));
            hf.m6205(th);
            return jSONObject != null ? jSONObject.toString() : "{}";
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m7949(boolean z) {
        this.f8296 = z;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String m7950() {
        return this.f8289;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final String m7951(String str) throws JSONException {
        return m7948(new JSONObject(str));
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final String m7952(String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject;
        String strSubstring = str.substring(str2.length());
        boolean z = false;
        String strSubstring2 = strSubstring.substring(0, strSubstring.length() - str3.length());
        if (strSubstring2.length() >= 2 && strSubstring2.startsWith("\"") && strSubstring2.endsWith("\"")) {
            jSONObject = new JSONObject(strSubstring2.substring(1, strSubstring2.length() - 1));
            z = true;
        } else {
            jSONObject = new JSONObject(strSubstring2);
        }
        String strM7948 = m7948(jSONObject);
        if (z) {
            strM7948 = "\"" + strM7948 + "\"";
        }
        return str2 + strM7948 + str3;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m7953(boolean z) {
        this.f8295 = z;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public String m7954() {
        return this.f8288;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final String m7955(String str) {
        try {
            String strM7947 = m7947(str, "&", "bizcontext=");
            if (TextUtils.isEmpty(strM7947)) {
                str = str + "&" + m7946("bizcontext=", "");
            } else {
                int iIndexOf = str.indexOf(strM7947);
                str = str.substring(0, iIndexOf) + m7952(strM7947, "bizcontext=", "") + str.substring(iIndexOf + strM7947.length());
            }
        } catch (Throwable th) {
            q9.m8088(this, "biz", "fmt1", th, str);
        }
        return str;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m7956(boolean z) {
        this.f8297 = z;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final String m7957(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str.substring(19));
            jSONObject.put("bizcontext", m7951(jSONObject.optString("bizcontext")));
            return "new_external_info==" + jSONObject.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean m7958() {
        return this.f8296;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final String m7959(String str) {
        try {
            String strM7947 = m7947(str, "\"&", "bizcontext=\"");
            if (TextUtils.isEmpty(strM7947)) {
                return str + "&" + m7946("bizcontext=\"", "\"");
            }
            if (!strM7947.endsWith("\"")) {
                strM7947 = strM7947 + "\"";
            }
            int iIndexOf = str.indexOf(strM7947);
            return str.substring(0, iIndexOf) + m7952(strM7947, "bizcontext=\"", "\"") + str.substring(iIndexOf + strM7947.length());
        } catch (Throwable th) {
            q9.m8088(this, "biz", "fmt2", th, str);
            return str;
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public boolean m7960() {
        return this.f8295;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public boolean m7961() {
        return this.f8297;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final boolean m7962(String str) {
        return !str.contains("\"&");
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final JSONObject m7963() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ap_link_token", this.f8291);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
