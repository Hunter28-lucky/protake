package com.xiaomi.push;

import com.xiaomi.push.hx;
import java.io.ByteArrayOutputStream;

/* loaded from: classes2.dex */
public class hw {
    private ib a;

    /* renamed from: a, reason: collision with other field name */
    private final ii f6295a;

    /* renamed from: a, reason: collision with other field name */
    private final ByteArrayOutputStream f6296a;

    public hw() {
        this(new hx.a());
    }

    public byte[] a(hr hrVar) {
        this.f6296a.reset();
        hrVar.b(this.a);
        return this.f6296a.toByteArray();
    }

    public hw(id idVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f6296a = byteArrayOutputStream;
        ii iiVar = new ii(byteArrayOutputStream);
        this.f6295a = iiVar;
        this.a = idVar.a(iiVar);
    }
}
