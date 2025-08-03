package defpackage;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonLog.java */
/* renamed from: ҥ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2967 extends C5164 {
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m10379(String str, String str2, String str3) {
        try {
            if (str2.startsWith("{")) {
                str2 = new JSONObject(str2).toString(4);
            } else if (str2.startsWith("[")) {
                str2 = new JSONArray(str2).toString(4);
            }
        } catch (JSONException unused) {
        }
        C5164.m15092(str, true);
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        String str4 = InterfaceC2469.f9168;
        sb.append(str4);
        sb.append(str2);
        for (String str5 : sb.toString().split(str4)) {
            Log.d(str, "║ " + str5);
        }
        C5164.m15092(str, false);
    }
}
