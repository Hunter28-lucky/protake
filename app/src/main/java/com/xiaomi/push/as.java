package com.xiaomi.push;

/* loaded from: classes2.dex */
public class as implements au {
    private final String a;
    private final String b;

    public as(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.au
    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.au
    public String b() {
        return this.b;
    }
}
