package com.xiaomi.push;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class bh extends JSONObject implements bf {
    private static final int a = 2;
    private static final int b = 3;

    /* renamed from: a, reason: collision with other field name */
    private final LinkedHashMap<String, Integer> f5614a = new LinkedHashMap<>();

    @Override // com.xiaomi.push.bf
    public int a() {
        int iIntValue = a;
        Iterator<Integer> it = this.f5614a.values().iterator();
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue + (length() - 1);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.f5614a.put(str, Integer.valueOf(str.length() + String.valueOf(i).length() + b));
        }
        return super.put(str, i);
    }

    @Override // org.json.JSONObject
    public Object remove(String str) {
        this.f5614a.remove(str);
        return super.remove(str);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.f5614a.put(str, Integer.valueOf(str.length() + String.valueOf(j).length() + b));
        }
        return super.put(str, j);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, double d) {
        if (!TextUtils.isEmpty(str)) {
            this.f5614a.put(str, Integer.valueOf(str.length() + String.valueOf(d).length() + b));
        }
        return super.put(str, d);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, Object obj) throws JSONException {
        JSONObject jSONObjectPut = super.put(str, obj);
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (obj instanceof bf) {
                this.f5614a.put(str, Integer.valueOf(str.length() + ((bf) obj).a() + b));
            } else {
                this.f5614a.put(str, Integer.valueOf(str.length() + String.valueOf(obj).getBytes(StandardCharsets.UTF_8).length + b + a));
            }
        }
        return jSONObjectPut;
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f5614a.put(str, Integer.valueOf(str.length() + String.valueOf(z).length() + b));
        }
        return super.put(str, z);
    }
}
