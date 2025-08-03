package defpackage;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class qe {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static JSONObject m8128(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject[] jSONObjectArr = {jSONObject, jSONObject2};
            for (int i = 0; i < 2; i++) {
                JSONObject jSONObject4 = jSONObjectArr[i];
                if (jSONObject4 != null) {
                    Iterator<String> itKeys = jSONObject4.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject3.put(next, jSONObject4.get(next));
                    }
                }
            }
        } catch (JSONException e2) {
            hf.m6205(e2);
        }
        return jSONObject3;
    }
}
