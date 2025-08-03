package com.xiaomi.push;

import org.json.JSONArray;

/* loaded from: classes2.dex */
public class bg extends JSONArray implements bf {
    private int a = 2;

    @Override // com.xiaomi.push.bf
    public int a() {
        return this.a + (length() - 1);
    }

    @Override // org.json.JSONArray
    public JSONArray put(Object obj) {
        if (obj instanceof bf) {
            this.a += ((bf) obj).a();
        }
        return super.put(obj);
    }
}
