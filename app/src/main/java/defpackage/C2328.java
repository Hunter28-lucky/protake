package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: Ĝ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2328 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f8851;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f8852;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f8853;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String f8854;

    /* renamed from: ԫ, reason: contains not printable characters */
    public String f8855;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f8856;

    /* renamed from: ԭ, reason: contains not printable characters */
    public long f8857;

    public C2328() {
        this.f8851 = 4096;
        this.f8857 = System.currentTimeMillis();
    }

    public C2328(int i, String str, String str2, String str3, String str4, String str5) {
        this.f8851 = 4096;
        this.f8857 = System.currentTimeMillis();
        m8735(i);
        m8730(str);
        m8732(str2);
        m8734(str3);
        m8731(str4);
        m8733(str5);
    }

    public C2328(String str, String str2, String str3) {
        this(4096, str, null, null, str2, str3);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m8730(String str) {
        this.f8852 = str;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m8731(String str) {
        this.f8853 = str;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m8732(String str) {
        this.f8854 = str;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m8733(String str) {
        this.f8856 = str;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m8734(String str) {
        this.f8855 = str;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m8735(int i) {
        this.f8851 = i;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public String m8736() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("messageType", Integer.valueOf(this.f8851));
            jSONObject.putOpt("eventID", this.f8853);
            jSONObject.putOpt("appPackage", this.f8852);
            jSONObject.putOpt("eventTime", Long.valueOf(this.f8857));
            if (!TextUtils.isEmpty(this.f8854)) {
                jSONObject.putOpt("globalID", this.f8854);
            }
            if (!TextUtils.isEmpty(this.f8855)) {
                jSONObject.putOpt("taskID", this.f8855);
            }
            if (!TextUtils.isEmpty(this.f8856)) {
                jSONObject.putOpt("property", this.f8856);
            }
        } catch (Exception e2) {
            qd.m8125(e2.getLocalizedMessage());
        }
        return jSONObject.toString();
    }
}
