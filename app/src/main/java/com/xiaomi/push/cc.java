package com.xiaomi.push;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class cc {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private long f5652a;

    /* renamed from: a, reason: collision with other field name */
    private String f5653a;
    private long b;
    private long c;

    public cc() {
        this(0, 0L, 0L, null);
    }

    public int a() {
        return this.a;
    }

    public cc(int i, long j, long j2, Exception exc) {
        this.a = i;
        this.f5652a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f5653a = exc.getClass().getSimpleName();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public JSONObject m5282a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f5652a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.b);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.f5653a);
        return jSONObject;
    }

    public cc a(JSONObject jSONObject) {
        this.f5652a = jSONObject.getLong("cost");
        this.c = jSONObject.getLong("size");
        this.b = jSONObject.getLong("ts");
        this.a = jSONObject.getInt("wt");
        this.f5653a = jSONObject.optString("expt");
        return this;
    }
}
