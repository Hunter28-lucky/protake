package com.zhiyun.protocol.message;

import com.zhiyun.protocol.utils.Arrays;
import defpackage.ca;
import defpackage.gc;

/* loaded from: classes2.dex */
public abstract class d<H extends gc, B extends ca> extends AbsMessage<gc, B> {
    public d(H h, B b) {
        super(h, b);
        getHead().m6092(false);
        getHead().m6091(6);
        getBody().m274(false);
    }

    @Override // com.zhiyun.protocol.message.AbsMessage
    public byte[] crc(byte[] bArr, byte[] bArr2) {
        return com.zhiyun.protocol.utils.a.a(com.zhiyun.protocol.utils.c.a(Arrays.a(Arrays.sub(bArr, 4, bArr.length - 4), bArr2)), 2, getBody().m275());
    }
}
