package defpackage;

import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class gf extends vb {
    public gf() {
        super(1024, ByteOrder.BIG_ENDIAN);
    }

    @Override // defpackage.vb
    /* renamed from: Ϳ */
    public void mo5944() {
        while (m8490() && m8488(7)) {
            byte[] bArr = new byte[7];
            this.f8695.get(bArr);
            m8489(bArr);
        }
    }
}
