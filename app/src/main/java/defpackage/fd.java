package defpackage;

import org.jcodec.platform.Platform;

/* loaded from: classes.dex */
public final class fd extends yb {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String f6637;

    public fd(String str) {
        this.f6637 = str;
    }

    @Override // defpackage.yb
    /* renamed from: Ϳ */
    public void mo6027() throws Exception {
        this.f8766 = (byte) 1;
        byte[] bytes = this.f6637.getBytes(Platform.UTF_8);
        this.f8768 = bytes;
        this.f8767 = (byte) bytes.length;
    }
}
