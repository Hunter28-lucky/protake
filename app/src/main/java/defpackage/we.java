package defpackage;

/* loaded from: classes2.dex */
public class we extends gc {
    public we() {
        m6094(24);
        m6092(false);
    }

    @Override // defpackage.gc, com.zhiyun.protocol.message.Head
    public boolean parseFrom(byte[] bArr) {
        return super.parseFrom(bArr) && m6093() == 24;
    }
}
