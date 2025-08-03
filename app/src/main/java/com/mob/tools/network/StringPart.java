package com.mob.tools.network;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class StringPart extends HTTPPart {
    private StringBuilder a = new StringBuilder();

    @Override // com.mob.tools.network.HTTPPart
    public InputStream a() throws Throwable {
        return new ByteArrayInputStream(this.a.toString().getBytes("utf-8"));
    }

    public StringPart append(String str) {
        this.a.append(str);
        return this;
    }

    @Override // com.mob.tools.network.HTTPPart
    public long b() throws Throwable {
        return this.a.toString().getBytes("utf-8").length;
    }

    public String toString() {
        return this.a.toString();
    }
}
