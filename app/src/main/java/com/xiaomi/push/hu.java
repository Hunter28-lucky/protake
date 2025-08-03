package com.xiaomi.push;

import com.xiaomi.push.hx;

/* loaded from: classes2.dex */
public class hu {
    private final ib a;

    /* renamed from: a, reason: collision with other field name */
    private final ik f6294a;

    public hu() {
        this(new hx.a());
    }

    public void a(hr hrVar, byte[] bArr) {
        try {
            this.f6294a.a(bArr);
            hrVar.a(this.a);
        } finally {
            this.a.k();
        }
    }

    public hu(id idVar) {
        ik ikVar = new ik();
        this.f6294a = ikVar;
        this.a = idVar.a(ikVar);
    }
}
