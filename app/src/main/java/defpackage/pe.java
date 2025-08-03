package defpackage;

import android.content.Context;
import com.umeng.umcrash.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class pe extends pf {
    @Override // defpackage.pf
    /* renamed from: Ԩ, reason: contains not printable characters */
    public ic mo7969(pa paVar, Context context, String str) throws Throwable {
        return m7979(paVar, context, str, "https://mcgw.alipay.com/sdklog.do", true);
    }

    @Override // defpackage.pf
    /* renamed from: Ԭ, reason: contains not printable characters */
    public String mo7970(pa paVar) throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        map.put("api_name", "/sdk/log");
        map.put("api_version", "1.0.0");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("log_v", BuildConfig.VERSION_NAME);
        return mo7188(paVar, map, map2);
    }

    @Override // defpackage.pf
    /* renamed from: ԭ, reason: contains not printable characters */
    public String mo7971(pa paVar, String str, JSONObject jSONObject) {
        return str;
    }

    @Override // defpackage.pf
    /* renamed from: ԯ, reason: contains not printable characters */
    public Map<String, String> mo7972(boolean z, String str) {
        HashMap map = new HashMap();
        map.put("msp-gzip", String.valueOf(z));
        map.put("content-type", "application/octet-stream");
        map.put("des-mode", "CBC");
        return map;
    }

    @Override // defpackage.pf
    /* renamed from: ՠ */
    public JSONObject mo7189() throws JSONException {
        return null;
    }

    @Override // defpackage.pf
    /* renamed from: ހ */
    public boolean mo7191() {
        return false;
    }
}
