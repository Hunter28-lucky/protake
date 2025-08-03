package com.zhiyun.protocol.message;

import com.zhiyun.protocol.message.Body;
import com.zhiyun.protocol.message.Head;

/* loaded from: classes2.dex */
public abstract class AbsMessage<H extends Head, B extends Body> implements e<H, B> {
    private H a;
    private B b;

    public AbsMessage(H h, B b) {
        this.a = h;
        this.b = b;
    }

    private native boolean c_parse(byte[] bArr);

    private native byte[] to_data(Head head, Body body);

    public abstract byte[] crc(byte[] bArr, byte[] bArr2);

    public B getBody() {
        return this.b;
    }

    public H getHead() {
        return this.a;
    }

    @Override // com.zhiyun.protocol.message.e
    public boolean parseFrom(byte[] bArr) {
        return c_parse(bArr);
    }

    public byte[] toData() {
        return to_data(this.a, this.b);
    }
}
