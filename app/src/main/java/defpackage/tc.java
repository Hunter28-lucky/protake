package defpackage;

/* loaded from: classes2.dex */
public class tc extends ve {
    public tc() {
        m6090((byte) 8);
        m6094(24);
    }

    @Override // defpackage.ve, defpackage.gc, com.zhiyun.protocol.message.Head
    public boolean parseFrom(byte[] bArr) {
        return super.parseFrom(bArr) && m6089() == 8;
    }
}
