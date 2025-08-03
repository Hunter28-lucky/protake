package com.xiaomi.push;

/* loaded from: classes2.dex */
public class hy {
    public final byte a;

    /* renamed from: a, reason: collision with other field name */
    public final String f6303a;

    /* renamed from: a, reason: collision with other field name */
    public final short f6304a;

    public hy() {
        this("", (byte) 0, (short) 0);
    }

    public String toString() {
        return "<TField name:'" + this.f6303a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f6304a) + ">";
    }

    public hy(String str, byte b, short s) {
        this.f6303a = str;
        this.a = b;
        this.f6304a = s;
    }
}
