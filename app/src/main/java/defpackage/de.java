package defpackage;

import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class de extends vb {
    public de() {
        super(1024, ByteOrder.BIG_ENDIAN);
    }

    @Override // defpackage.vb
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo5944() {
        while (m8490() && m8488(4)) {
            byte[] bArr = new byte[4];
            this.f8695.get(bArr);
            m8489(bArr);
        }
    }
}
