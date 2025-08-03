package com.efs.sdk.net.a.a;

import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public final class h {
    public final f a;
    public ByteArrayOutputStream b;
    public a c;
    private final String d;

    public h(f fVar, String str) {
        this.a = fVar;
        this.d = str;
    }

    public final boolean a() {
        return this.b != null;
    }

    public final void b() {
        if (!a()) {
            throw new IllegalStateException("No body found; has createBodySink been called?");
        }
    }
}
