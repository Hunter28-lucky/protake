package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
public class s implements Closeable {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InputStream f8497;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Charset f8498;

    /* renamed from: ԭ, reason: contains not printable characters */
    public byte[] f8499;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f8500;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f8501;

    /* compiled from: StrictLineReader.java */
    /* renamed from: s$Ϳ, reason: contains not printable characters */
    public class C2260 extends ByteArrayOutputStream {
        public C2260(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
                i--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, s.this.f8498.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public s(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f8497) {
            if (this.f8499 != null) {
                this.f8499 = null;
                this.f8497.close();
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m8203() throws IOException {
        InputStream inputStream = this.f8497;
        byte[] bArr = this.f8499;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.f8500 = 0;
        this.f8501 = i;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean m8204() {
        return this.f8501 == -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* renamed from: Ԫ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m8205() throws java.io.IOException {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.f8497
            monitor-enter(r0)
            byte[] r1 = r7.f8499     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L7f
            int r1 = r7.f8500     // Catch: java.lang.Throwable -> L87
            int r2 = r7.f8501     // Catch: java.lang.Throwable -> L87
            if (r1 < r2) goto L10
            r7.m8203()     // Catch: java.lang.Throwable -> L87
        L10:
            int r1 = r7.f8500     // Catch: java.lang.Throwable -> L87
        L12:
            int r2 = r7.f8501     // Catch: java.lang.Throwable -> L87
            r3 = 10
            if (r1 == r2) goto L41
            byte[] r2 = r7.f8499     // Catch: java.lang.Throwable -> L87
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L87
            if (r4 != r3) goto L3e
            int r3 = r7.f8500     // Catch: java.lang.Throwable -> L87
            if (r1 == r3) goto L2b
            int r4 = r1 + (-1)
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L87
            r6 = 13
            if (r5 != r6) goto L2b
            goto L2c
        L2b:
            r4 = r1
        L2c:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L87
            int r4 = r4 - r3
            java.nio.charset.Charset r6 = r7.f8498     // Catch: java.lang.Throwable -> L87
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L87
            r5.<init>(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L87
            int r1 = r1 + 1
            r7.f8500 = r1     // Catch: java.lang.Throwable -> L87
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            return r5
        L3e:
            int r1 = r1 + 1
            goto L12
        L41:
            s$Ϳ r1 = new s$Ϳ     // Catch: java.lang.Throwable -> L87
            int r2 = r7.f8501     // Catch: java.lang.Throwable -> L87
            int r4 = r7.f8500     // Catch: java.lang.Throwable -> L87
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L87
        L4d:
            byte[] r2 = r7.f8499     // Catch: java.lang.Throwable -> L87
            int r4 = r7.f8500     // Catch: java.lang.Throwable -> L87
            int r5 = r7.f8501     // Catch: java.lang.Throwable -> L87
            int r5 = r5 - r4
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L87
            r2 = -1
            r7.f8501 = r2     // Catch: java.lang.Throwable -> L87
            r7.m8203()     // Catch: java.lang.Throwable -> L87
            int r2 = r7.f8500     // Catch: java.lang.Throwable -> L87
        L5f:
            int r4 = r7.f8501     // Catch: java.lang.Throwable -> L87
            if (r2 == r4) goto L4d
            byte[] r4 = r7.f8499     // Catch: java.lang.Throwable -> L87
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L87
            if (r5 != r3) goto L7c
            int r3 = r7.f8500     // Catch: java.lang.Throwable -> L87
            if (r2 == r3) goto L72
            int r5 = r2 - r3
            r1.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L87
        L72:
            int r2 = r2 + 1
            r7.f8500 = r2     // Catch: java.lang.Throwable -> L87
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L87
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            return r1
        L7c:
            int r2 = r2 + 1
            goto L5f
        L7f:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L87
            java.lang.String r2 = "LineReader is closed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L87
            throw r1     // Catch: java.lang.Throwable -> L87
        L87:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s.m8205():java.lang.String");
    }

    public s(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(k5.f7821)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f8497 = inputStream;
        this.f8498 = charset;
        this.f8499 = new byte[i];
    }
}
