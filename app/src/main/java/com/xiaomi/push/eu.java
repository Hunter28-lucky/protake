package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.dq;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* loaded from: classes2.dex */
class eu {

    /* renamed from: a, reason: collision with other field name */
    private ez f5874a;

    /* renamed from: a, reason: collision with other field name */
    private InputStream f5875a;

    /* renamed from: a, reason: collision with other field name */
    private volatile boolean f5878a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f5879a;

    /* renamed from: a, reason: collision with other field name */
    private ByteBuffer f5876a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a, reason: collision with other field name */
    private Adler32 f5877a = new Adler32();
    private ex a = new ex();

    public eu(InputStream inputStream, ez ezVar) {
        this.f5875a = new BufferedInputStream(inputStream);
        this.f5874a = ezVar;
    }

    private void c() throws IOException {
        boolean z = false;
        this.f5878a = false;
        es esVarM5466a = m5466a();
        if ("CONN".equals(esVarM5466a.m5455a())) {
            dq.f fVarA = dq.f.a(esVarM5466a.m5459a());
            if (fVarA.m5397a()) {
                this.f5874a.a(fVarA.m5396a());
                z = true;
            }
            if (fVarA.c()) {
                dq.b bVarM5395a = fVarA.m5395a();
                es esVar = new es();
                esVar.a("SYNC", "CONF");
                esVar.a(bVarM5395a.m5437a(), (String) null);
                this.f5874a.a(esVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("[Slim] CONN: host = " + fVarA.m5398b());
        }
        if (!z) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f5879a = this.f5874a.m5473a();
        while (!this.f5878a) {
            es esVarM5466a2 = m5466a();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f5874a.c();
            short sM5457a = esVarM5466a2.m5457a();
            if (sM5457a == 1) {
                this.f5874a.a(esVarM5466a2);
            } else if (sM5457a != 2) {
                if (sM5457a != 3) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("[Slim] unknow blob type " + ((int) esVarM5466a2.m5457a()));
                } else {
                    try {
                        this.f5874a.b(this.a.a(esVarM5466a2.m5459a(), this.f5874a));
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m5113a("[Slim] Parse packet from Blob chid=" + esVarM5466a2.a() + "; Id=" + esVarM5466a2.e() + " failure:" + e2.getMessage());
                    }
                }
            } else if ("SECMSG".equals(esVarM5466a2.m5455a()) && ((esVarM5466a2.a() == 2 || esVarM5466a2.a() == 3) && TextUtils.isEmpty(esVarM5466a2.m5462b()))) {
                try {
                    fp fpVarA = this.a.a(esVarM5466a2.m5460a(com.xiaomi.push.service.am.a().a(Integer.valueOf(esVarM5466a2.a()).toString(), esVarM5466a2.g()).h), this.f5874a);
                    fpVarA.f5935a = jCurrentTimeMillis;
                    this.f5874a.b(fpVarA);
                } catch (Exception e3) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("[Slim] Parse packet from Blob chid=" + esVarM5466a2.a() + "; Id=" + esVarM5466a2.e() + " failure:" + e3.getMessage());
                }
            } else {
                this.f5874a.a(esVarM5466a2);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5467a() throws IOException {
        try {
            c();
        } catch (IOException e2) {
            if (!this.f5878a) {
                throw e2;
            }
        }
    }

    public void b() {
        this.f5878a = true;
    }

    private ByteBuffer a() throws IOException {
        this.f5876a.clear();
        a(this.f5876a, 8);
        short s = this.f5876a.getShort(0);
        short s2 = this.f5876a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f5876a.getInt(4);
            int iPosition = this.f5876a.position();
            if (i <= 32768) {
                if (i + 4 > this.f5876a.remaining()) {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i + 2048);
                    byteBufferAllocate.put(this.f5876a.array(), 0, this.f5876a.arrayOffset() + this.f5876a.position());
                    this.f5876a = byteBufferAllocate;
                } else if (this.f5876a.capacity() > 4096 && i < 2048) {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(2048);
                    byteBufferAllocate2.put(this.f5876a.array(), 0, this.f5876a.arrayOffset() + this.f5876a.position());
                    this.f5876a = byteBufferAllocate2;
                }
                a(this.f5876a, i);
                this.b.clear();
                a(this.b, 4);
                this.b.position(0);
                int i2 = this.b.getInt();
                this.f5877a.reset();
                this.f5877a.update(this.f5876a.array(), 0, this.f5876a.position());
                if (i2 == ((int) this.f5877a.getValue())) {
                    byte[] bArr = this.f5879a;
                    if (bArr != null) {
                        com.xiaomi.push.service.ar.a(bArr, this.f5876a.array(), true, iPosition, i);
                    }
                    return this.f5876a;
                }
                com.xiaomi.channel.commonutils.logger.b.m5113a("CRC = " + ((int) this.f5877a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            throw new IOException("Blob size too large");
        }
        throw new IOException("Malformed Input");
    }

    /* renamed from: a, reason: collision with other method in class */
    public es m5466a() throws IOException {
        int iPosition;
        es esVarA;
        try {
            ByteBuffer byteBufferA = a();
            iPosition = byteBufferA.position();
            try {
                byteBufferA.flip();
                byteBufferA.position(8);
                if (iPosition == 8) {
                    esVarA = new ey();
                } else {
                    esVarA = es.a(byteBufferA.slice());
                }
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + esVarA.m5455a() + ";chid=" + esVarA.a() + ";len=" + iPosition + "}");
                return esVarA;
            } catch (IOException e2) {
                e = e2;
                if (iPosition == 0) {
                    iPosition = this.f5876a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] bArrArray = this.f5876a.array();
                if (iPosition > 128) {
                    iPosition = 128;
                }
                sb.append(ac.a(bArrArray, 0, iPosition));
                sb.append("] Err:");
                sb.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.m5113a(sb.toString());
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            iPosition = 0;
        }
    }

    private void a(ByteBuffer byteBuffer, int i) throws IOException {
        int iPosition = byteBuffer.position();
        do {
            int i2 = this.f5875a.read(byteBuffer.array(), iPosition, i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i -= i2;
            iPosition += i2;
        } while (i > 0);
        byteBuffer.position(iPosition);
    }
}
