package com.zhiyun.protocol.message;

/* loaded from: classes2.dex */
public interface Head {
    int getBodyLength();

    int getHeadLength();

    boolean parseFrom(byte[] bArr);

    void setBodyLength(int i);

    byte[] toData();
}
