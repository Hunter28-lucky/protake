package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class at {
    public int a;

    /* renamed from: a, reason: collision with other field name */
    public String f5601a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f5602a = new HashMap();

    public String a() {
        return this.f5601a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.a), this.f5602a.toString(), this.f5601a);
    }
}
