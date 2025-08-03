package defpackage;

import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class kb extends vb {
    public kb() {
        super(5120, ByteOrder.LITTLE_ENDIAN);
    }

    @Override // defpackage.vb
    /* renamed from: Ϳ */
    public void mo5944() {
        while (m8490() && m8488(4)) {
            this.f8695.mark();
            boolean z = false;
            int iPosition = this.f8695.position();
            while (this.f8695.remaining() > 4) {
                this.f8695.get();
                short s = this.f8695.getShort(iPosition);
                if (s == 15908 || s == 15396) {
                    z = true;
                    break;
                }
                iPosition++;
            }
            this.f8695.get();
            if (!z) {
                this.f8695.reset();
                this.f8695.compact();
                return;
            }
            if (this.f8695.remaining() < 2) {
                this.f8695.reset();
                this.f8695.compact();
                return;
            }
            int i = this.f8695.getShort() + 4 + 2;
            this.f8695.position(this.f8695.position() - 4);
            if (this.f8695.remaining() < i) {
                this.f8695.reset();
                this.f8695.compact();
                return;
            } else {
                byte[] bArr = new byte[i];
                this.f8695.get(bArr);
                m8489(bArr);
            }
        }
    }
}
