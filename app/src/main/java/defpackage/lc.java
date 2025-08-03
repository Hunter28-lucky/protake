package defpackage;

import android.text.TextUtils;
import com.alipay.sdk.m.r.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class lc {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public a f7952;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f7953;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String[] f7954;

    public lc(String str, a aVar) {
        this.f7953 = str;
        this.f7952 = aVar;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static List<lc> m7493(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        String[] strArrM7495 = m7495(jSONObject.optString("name", ""));
        for (int i = 0; i < strArrM7495.length; i++) {
            a aVarA = a.a(strArrM7495[i]);
            if (aVarA != a.None) {
                lc lcVar = new lc(strArrM7495[i], aVarA);
                lcVar.f7954 = m7496(strArrM7495[i]);
                arrayList.add(lcVar);
            }
        }
        return arrayList;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m7494(lc lcVar) throws JSONException {
        String[] strArrM7498 = lcVar.m7498();
        if (strArrM7498.length == 3 && TextUtils.equals("tid", strArrM7498[0])) {
            qa qaVarM8106 = qa.m8106(mc.m7550().m7554());
            if (TextUtils.isEmpty(strArrM7498[1]) || TextUtils.isEmpty(strArrM7498[2])) {
                return;
            }
            qaVarM8106.m8108(strArrM7498[1], strArrM7498[2]);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String[] m7495(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(";");
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String[] m7496(String str) {
        ArrayList arrayList = new ArrayList();
        int iIndexOf = str.indexOf(40);
        int iLastIndexOf = str.lastIndexOf(41);
        if (iIndexOf == -1 || iLastIndexOf == -1 || iLastIndexOf <= iIndexOf) {
            return null;
        }
        for (String str2 : str.substring(iIndexOf + 1, iLastIndexOf).split("' *, *'", -1)) {
            arrayList.add(str2.trim().replaceAll("'", "").replaceAll("\"", ""));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public a m7497() {
        return this.f7952;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String[] m7498() {
        return this.f7954;
    }
}
