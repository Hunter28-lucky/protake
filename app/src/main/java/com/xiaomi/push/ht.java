package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* loaded from: classes2.dex */
public class ht extends ByteArrayOutputStream {
    public ht(int i) {
        super(i);
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m5663a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public ht() {
    }

    public int a() {
        return ((ByteArrayOutputStream) this).count;
    }
}
