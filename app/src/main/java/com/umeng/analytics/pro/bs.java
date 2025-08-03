package com.umeng.analytics.pro;

/* compiled from: TMessage.java */
/* loaded from: classes2.dex */
public final class bs {
    public final String a;
    public final byte b;
    public final int c;

    public bs() {
        this("", (byte) 0, 0);
    }

    public boolean a(bs bsVar) {
        return this.a.equals(bsVar.a) && this.b == bsVar.b && this.c == bsVar.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bs) {
            return a((bs) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.a + "' type: " + ((int) this.b) + " seqid:" + this.c + ">";
    }

    public bs(String str, byte b, int i) {
        this.a = str;
        this.b = b;
        this.c = i;
    }
}
