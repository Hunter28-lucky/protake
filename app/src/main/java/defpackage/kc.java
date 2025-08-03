package defpackage;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class kc extends pf {
    @Override // defpackage.pf
    /* renamed from: Ԯ, reason: contains not printable characters */
    public String mo7188(pa paVar, HashMap<String, String> map, HashMap<String, String> map2) throws JSONException {
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        map2.putAll(ra.m8155(paVar));
        hf.m6209("mspl", "cf " + map2);
        return super.mo7188(paVar, map, map2);
    }

    @Override // defpackage.pf
    /* renamed from: ՠ, reason: contains not printable characters */
    public JSONObject mo7189() throws JSONException {
        return pf.m7974("sdkConfig", "obtain");
    }

    @Override // defpackage.pf
    /* renamed from: ؠ, reason: contains not printable characters */
    public String mo7190() {
        return "5.0.0";
    }

    @Override // defpackage.pf
    /* renamed from: ހ, reason: contains not printable characters */
    public boolean mo7191() {
        return true;
    }
}
