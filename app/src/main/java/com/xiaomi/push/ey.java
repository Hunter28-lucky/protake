package com.xiaomi.push;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class ey extends es {
    public ey() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.es
    /* renamed from: a */
    public ByteBuffer mo5456a(ByteBuffer byteBuffer) {
        return m5459a().length == 0 ? byteBuffer : super.mo5456a(byteBuffer);
    }

    @Override // com.xiaomi.push.es
    public int c() {
        if (m5459a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
