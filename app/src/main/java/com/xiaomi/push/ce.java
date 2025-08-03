package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class ce {
    private String a;

    /* renamed from: a, reason: collision with other field name */
    private final ArrayList<cd> f5658a = new ArrayList<>();

    public ce(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.a = str;
    }

    public synchronized void a(cd cdVar) {
        int i = 0;
        while (true) {
            if (i >= this.f5658a.size()) {
                break;
            }
            if (this.f5658a.get(i).a(cdVar)) {
                this.f5658a.set(i, cdVar);
                break;
            }
            i++;
        }
        if (i >= this.f5658a.size()) {
            this.f5658a.add(cdVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        Iterator<cd> it = this.f5658a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public ce() {
    }

    public synchronized cd a() {
        for (int size = this.f5658a.size() - 1; size >= 0; size--) {
            cd cdVar = this.f5658a.get(size);
            if (cdVar.m5286a()) {
                ch.a().m5297a(cdVar.a());
                return cdVar;
            }
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public ArrayList<cd> m5288a() {
        return this.f5658a;
    }

    public synchronized void a(boolean z) {
        for (int size = this.f5658a.size() - 1; size >= 0; size--) {
            cd cdVar = this.f5658a.get(size);
            if (z) {
                if (cdVar.c()) {
                    this.f5658a.remove(size);
                }
            } else if (!cdVar.b()) {
                this.f5658a.remove(size);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5287a() {
        return this.a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m5289a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cd> it = this.f5658a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m5284a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized ce a(JSONObject jSONObject) {
        this.a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f5658a.add(new cd(this.a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }
}
