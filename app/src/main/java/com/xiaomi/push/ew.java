package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
public class ew {
    public static final byte[] a = {80, 85, 83, 72};

    /* renamed from: a, reason: collision with other field name */
    private byte f5886a;

    /* renamed from: a, reason: collision with other field name */
    private int f5887a;

    /* renamed from: a, reason: collision with other field name */
    private short f5888a;
    private byte[] b;

    public static class a {
        public static final c a = new c();

        /* renamed from: a, reason: collision with other field name */
        public static final d f5889a = new d();

        public static byte[] a(byte[] bArr) {
            return a(bArr, f5889a);
        }

        public static byte[] a(byte[] bArr, b bVar) {
            if (!ew.m5469a(bArr)) {
                return bArr;
            }
            ew ewVarA = ew.a(bArr);
            return (ewVarA.f5886a == 0 || ewVarA.f5886a != bVar.a()) ? ewVarA.b : bVar.a(ewVarA.b, ewVarA.f5887a);
        }
    }

    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i);
    }

    public static final class c {
    }

    public static final class d implements b {
        @Override // com.xiaomi.push.ew.b
        public byte a() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.ew.b
        public byte[] a(byte[] bArr, int i) throws Throwable {
            GZIPInputStream gZIPInputStream;
            GZIPInputStream gZIPInputStream2 = null;
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr2 = new byte[i];
                gZIPInputStream.read(bArr2);
                try {
                    gZIPInputStream.close();
                } catch (IOException unused2) {
                }
                return bArr2;
            } catch (IOException unused3) {
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
    }

    public ew(byte b2, int i, byte[] bArr) {
        this((short) 1, b2, i, bArr);
    }

    public ew(short s, byte b2, int i, byte[] bArr) {
        this.f5888a = s;
        this.f5886a = b2;
        this.f5887a = i;
        this.b = bArr;
    }

    public static ew a(byte b2, int i, byte[] bArr) {
        return new ew(b2, i, bArr);
    }

    public static ew a(short s, byte b2, int i, byte[] bArr) {
        return new ew(s, b2, i, bArr);
    }

    public static ew a(byte[] bArr) {
        if (m5469a(bArr)) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            byteBufferOrder.getInt();
            short s = byteBufferOrder.getShort();
            byte b2 = byteBufferOrder.get();
            int i = byteBufferOrder.getInt();
            byte[] bArr2 = new byte[byteBufferOrder.getInt()];
            byteBufferOrder.get(bArr2);
            return a(s, b2, i, bArr2);
        }
        return a((byte) 0, bArr.length, bArr);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5469a(byte[] bArr) {
        byte[] bArr2 = a;
        return a(bArr2, bArr, bArr2.length);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
