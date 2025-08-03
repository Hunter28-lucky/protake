package com.xiaomi.clientreport.data;

import com.umeng.analytics.pro.am;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bm;
import com.xiaomi.push.j;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {
    public String clientInterfaceId;
    private String pkgName;
    public int production;
    public int reportType;
    private String sdkVersion;
    private String os = bm.a();
    private String miuiVersion = j.m5686a();

    public String getPackageName() {
        return this.pkgName;
    }

    public void setAppPackageName(String str) {
        this.pkgName = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("production", this.production);
            jSONObject.put("reportType", this.reportType);
            jSONObject.put("clientInterfaceId", this.clientInterfaceId);
            jSONObject.put(am.x, this.os);
            jSONObject.put("miuiVersion", this.miuiVersion);
            jSONObject.put("pkgName", this.pkgName);
            jSONObject.put("sdkVersion", this.sdkVersion);
            return jSONObject;
        } catch (JSONException e2) {
            b.a(e2);
            return null;
        }
    }

    public String toJsonString() throws JSONException {
        JSONObject json = toJson();
        return json == null ? "" : json.toString();
    }
}
