package com.zhiyun.protocol.message;

import com.zhiyun.protocol.message.Body;
import com.zhiyun.protocol.message.Head;

/* loaded from: classes2.dex */
public interface e<H extends Head, B extends Body> {
    boolean parseFrom(byte[] bArr);
}
