package com.mob.socketservice;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class ByteMsg implements Serializable {
    private static final long serialVersionUID = 8796700489815186325L;
    private byte[] content;
    private byte head = 1;
    private int length;
    private int type;

    public byte[] getContent() {
        return this.content;
    }

    public byte getHead() {
        return this.head;
    }

    public int getLength() {
        return this.length;
    }

    public int getType() {
        return this.type;
    }

    public String info() {
        return String.format("ByteMsg_type[%s]_len[%s]", Integer.valueOf(this.type), Integer.valueOf(this.length));
    }

    public void setContent(byte[] bArr) {
        this.content = bArr;
        this.length = bArr.length;
    }

    public void setHead(byte b) {
        this.head = b;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public void setType(int i) {
        this.type = i;
    }
}
