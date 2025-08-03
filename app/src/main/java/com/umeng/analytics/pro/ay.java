package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bo;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TDeserializer.java */
/* loaded from: classes2.dex */
public class ay {
    private final bu a;
    private final ch b;

    public ay() {
        this(new bo.a());
    }

    private bp j(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        this.b.a(bArr);
        int length = bcVarArr.length + 1;
        bc[] bcVarArr2 = new bc[length];
        int i = 0;
        bcVarArr2[0] = bcVar;
        int i2 = 0;
        while (i2 < bcVarArr.length) {
            int i3 = i2 + 1;
            bcVarArr2[i3] = bcVarArr[i2];
            i2 = i3;
        }
        this.a.j();
        bp bpVarL = null;
        while (i < length) {
            bpVarL = this.a.l();
            if (bpVarL.b == 0 || bpVarL.c > bcVarArr2[i].a()) {
                return null;
            }
            if (bpVarL.c != bcVarArr2[i].a()) {
                bx.a(this.a, bpVarL.b);
                this.a.m();
            } else {
                i++;
                if (i < length) {
                    this.a.j();
                }
            }
        }
        return bpVarL;
    }

    public void a(av avVar, byte[] bArr) throws bb {
        try {
            this.b.a(bArr);
            avVar.read(this.a);
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public Byte b(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Byte) a((byte) 3, bArr, bcVar, bcVarArr);
    }

    public Double c(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Double) a((byte) 4, bArr, bcVar, bcVarArr);
    }

    public Short d(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Short) a((byte) 6, bArr, bcVar, bcVarArr);
    }

    public Integer e(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Integer) a((byte) 8, bArr, bcVar, bcVarArr);
    }

    public Long f(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Long) a((byte) 10, bArr, bcVar, bcVarArr);
    }

    public String g(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (String) a((byte) 11, bArr, bcVar, bcVarArr);
    }

    public ByteBuffer h(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (ByteBuffer) a((byte) 100, bArr, bcVar, bcVarArr);
    }

    public Short i(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        Short shValueOf;
        try {
            try {
                if (j(bArr, bcVar, bcVarArr) != null) {
                    this.a.j();
                    shValueOf = Short.valueOf(this.a.l().c);
                } else {
                    shValueOf = null;
                }
                return shValueOf;
            } catch (Exception e2) {
                throw new bb(e2);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public ay(bw bwVar) {
        ch chVar = new ch();
        this.b = chVar;
        this.a = bwVar.a(chVar);
    }

    public void a(av avVar, String str, String str2) throws bb {
        try {
            try {
                a(avVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new bb("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.a.B();
        }
    }

    public void a(av avVar, byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        try {
            try {
                if (j(bArr, bcVar, bcVarArr) != null) {
                    avVar.read(this.a);
                }
            } catch (Exception e2) {
                throw new bb(e2);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public Boolean a(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Boolean) a((byte) 2, bArr, bcVar, bcVarArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object a(byte r1, byte[] r2, com.umeng.analytics.pro.bc r3, com.umeng.analytics.pro.bc... r4) throws com.umeng.analytics.pro.bb {
        /*
            r0 = this;
            com.umeng.analytics.pro.bp r2 = r0.j(r2, r3, r4)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r2 == 0) goto L9e
            r3 = 2
            if (r1 == r3) goto L8f
            r3 = 3
            if (r1 == r3) goto L80
            r3 = 4
            if (r1 == r3) goto L71
            r3 = 6
            if (r1 == r3) goto L62
            r3 = 8
            if (r1 == r3) goto L53
            r3 = 100
            r4 = 11
            if (r1 == r3) goto L48
            r3 = 10
            if (r1 == r3) goto L39
            if (r1 == r4) goto L24
            goto L9e
        L24:
            byte r1 = r2.b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r4) goto L9e
            com.umeng.analytics.pro.bu r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.String r1 = r1.z()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
        L2e:
            com.umeng.analytics.pro.ch r2 = r0.b
            r2.e()
            com.umeng.analytics.pro.bu r2 = r0.a
            r2.B()
            return r1
        L39:
            byte r1 = r2.b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bu r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            long r1 = r1.x()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L48:
            byte r1 = r2.b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r4) goto L9e
            com.umeng.analytics.pro.bu r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.nio.ByteBuffer r1 = r1.A()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L53:
            byte r1 = r2.b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bu r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            int r1 = r1.w()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L62:
            byte r1 = r2.b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bu r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            short r1 = r1.v()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Short r1 = java.lang.Short.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L71:
            byte r1 = r2.b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bu r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            double r1 = r1.y()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L80:
            byte r1 = r2.b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bu r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            byte r1 = r1.u()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Byte r1 = java.lang.Byte.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L8f:
            byte r1 = r2.b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bu r1 = r0.a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            boolean r1 = r1.t()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L9e:
            r1 = 0
            goto L2e
        La0:
            r1 = move-exception
            goto La9
        La2:
            r1 = move-exception
            com.umeng.analytics.pro.bb r2 = new com.umeng.analytics.pro.bb     // Catch: java.lang.Throwable -> La0
            r2.<init>(r1)     // Catch: java.lang.Throwable -> La0
            throw r2     // Catch: java.lang.Throwable -> La0
        La9:
            com.umeng.analytics.pro.ch r2 = r0.b
            r2.e()
            com.umeng.analytics.pro.bu r2 = r0.a
            r2.B()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.ay.a(byte, byte[], com.umeng.analytics.pro.bc, com.umeng.analytics.pro.bc[]):java.lang.Object");
    }

    public void a(av avVar, String str) throws bb {
        a(avVar, str.getBytes());
    }
}
