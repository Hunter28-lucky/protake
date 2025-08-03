package defpackage;

import com.zhiyun.protocol.constants.Model;
import defpackage.vb;

/* loaded from: classes2.dex */
public class bb {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public vb f141;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public vb f142;

    public bb(Model model, vb.InterfaceC2302 interfaceC2302) {
        this.f141 = model.isBl() ? new kb() : new gf();
        this.f142 = new de();
        this.f141.m8486(interfaceC2302);
        this.f142.m8486(interfaceC2302);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m162(boolean z, byte[] bArr) {
        if (z) {
            this.f142.m8487(bArr);
        } else {
            this.f141.m8487(bArr);
        }
    }
}
