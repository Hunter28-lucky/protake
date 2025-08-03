package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class ck implements Comparable<ck> {
    public int a;

    /* renamed from: a, reason: collision with other field name */
    private long f5672a;

    /* renamed from: a, reason: collision with other field name */
    public String f5673a;

    /* renamed from: a, reason: collision with other field name */
    private final LinkedList<cc> f5674a;

    public ck() {
        this(null, 0);
    }

    public synchronized void a(cc ccVar) {
        if (ccVar != null) {
            this.f5674a.add(ccVar);
            int iA = ccVar.a();
            if (iA > 0) {
                this.a += ccVar.a();
            } else {
                int i = 0;
                for (int size = this.f5674a.size() - 1; size >= 0 && this.f5674a.get(size).a() < 0; size--) {
                    i++;
                }
                this.a += iA * i;
            }
            if (this.f5674a.size() > 30) {
                this.a -= this.f5674a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f5673a + Constants.COLON_SEPARATOR + this.a;
    }

    public ck(String str) {
        this(str, 0);
    }

    public ck(String str, int i) {
        this.f5674a = new LinkedList<>();
        this.f5672a = 0L;
        this.f5673a = str;
        this.a = i;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ck ckVar) {
        if (ckVar == null) {
            return 1;
        }
        return ckVar.a - this.a;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f5672a);
        jSONObject.put("wt", this.a);
        jSONObject.put("host", this.f5673a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cc> it = this.f5674a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m5282a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public synchronized ck a(JSONObject jSONObject) {
        this.f5672a = jSONObject.getLong("tt");
        this.a = jSONObject.getInt("wt");
        this.f5673a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f5674a.add(new cc().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }
}
