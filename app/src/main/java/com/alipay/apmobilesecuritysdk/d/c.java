package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.f;
import defpackage.ua;
import defpackage.wc;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c {
    public static Map<String, String> a(Context context) throws JSONException {
        wc wcVarM8529 = wc.m8529();
        HashMap map = new HashMap();
        f fVarA = com.alipay.apmobilesecuritysdk.e.e.a(context);
        String strM8565 = wcVarM8529.m8565(context);
        String strM8566 = wcVarM8529.m8566(context);
        String strM8549 = wc.m8549(context);
        if (fVarA != null) {
            if (ua.m8370(strM8565)) {
                strM8565 = fVarA.a();
            }
            if (ua.m8370(strM8566)) {
                strM8566 = fVarA.b();
            }
            if (ua.m8370(strM8549)) {
                strM8549 = fVarA.e();
            }
        }
        f fVar = new f(strM8565, strM8566, "", "", strM8549);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", fVar.a());
                jSONObject.put("imsi", fVar.b());
                jSONObject.put("mac", fVar.c());
                jSONObject.put("bluetoothmac", fVar.d());
                jSONObject.put("gsi", fVar.e());
                String string = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", string);
                com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", string);
            } catch (Exception e2) {
                com.alipay.apmobilesecuritysdk.c.a.a(e2);
            }
        }
        map.put("AD1", strM8565);
        map.put("AD2", strM8566);
        map.put("AD3", wc.m8539(context));
        map.put("AD5", wc.m8543(context));
        map.put("AD6", wc.m8545(context));
        map.put("AD7", wc.m8547(context));
        map.put("AD9", wcVarM8529.m8567(context));
        map.put("AD10", strM8549);
        map.put("AD11", wc.m8532());
        map.put("AD12", wcVarM8529.m8564());
        map.put("AD13", wc.m8534());
        map.put("AD14", wc.m8538());
        map.put("AD15", wc.m8540());
        map.put("AD16", wc.m8542());
        map.put("AD17", "");
        map.put("AD19", wc.m8551(context));
        map.put("AD20", wc.m8544());
        map.put("AD22", "");
        map.put("AD23", wc.m8553(context));
        map.put("AD24", ua.m8378(wc.m8541(context)));
        map.put("AD26", wc.m8537(context));
        map.put("AD27", wc.m8554());
        map.put("AD28", wc.m8558());
        map.put("AD29", wc.m8561());
        map.put("AD30", wc.m8556());
        map.put("AD31", wc.m8560());
        map.put("AD32", wc.m8550());
        map.put("AD33", wc.m8552());
        map.put("AD34", wc.m8555(context));
        map.put("AD35", wc.m8557(context));
        map.put("AD36", wcVarM8529.m8568(context));
        map.put("AD37", wc.m8548());
        map.put("AD38", wc.m8546());
        map.put("AD39", wc.m8533(context));
        map.put("AD40", wc.m8535(context));
        map.put("AD41", wc.m8530());
        map.put("AD42", wc.m8531());
        return map;
    }
}
