package com.umeng.analytics.pro;

/* compiled from: TField.java */
/* loaded from: classes2.dex */
public class bp {
    public final String a;
    public final byte b;
    public final short c;

    public bp() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(bp bpVar) {
        return this.b == bpVar.b && this.c == bpVar.c;
    }

    public String toString() {
        return "<TField name:'" + this.a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.c) + ">";
    }

    public bp(String str, byte b, short s) {
        this.a = str;
        this.b = b;
        this.c = s;
    }
}
