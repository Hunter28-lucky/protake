package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

/* compiled from: TByteArrayOutputStream.java */
/* loaded from: classes2.dex */
public class ax extends ByteArrayOutputStream {
    public ax(int i) {
        super(i);
    }

    public byte[] a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public int b() {
        return ((ByteArrayOutputStream) this).count;
    }

    public ax() {
    }
}
