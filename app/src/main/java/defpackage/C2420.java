package defpackage;

import java.nio.IntBuffer;
import java.util.concurrent.Semaphore;

/* compiled from: PixelsReader.java */
/* renamed from: ƕ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2420 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static Semaphore f9015 = new Semaphore(1);

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static C2420 f9016 = new C2420();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public long f9017 = 2073600;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public IntBuffer f9018 = IntBuffer.allocate((int) 2073600);

    /* compiled from: PixelsReader.java */
    /* renamed from: ƕ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2421 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo8916(IntBuffer intBuffer);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static synchronized C2420 m8914() {
        return f9016;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m8915(int i, int i2, InterfaceC2421 interfaceC2421) throws InterruptedException {
        long j = i * i2;
        if (j > this.f9017) {
            this.f9017 = j;
            this.f9018 = IntBuffer.allocate((int) j);
        }
        try {
            f9015.acquire();
            try {
                this.f9018.position(0);
                interfaceC2421.mo8916(this.f9018);
                f9015.release();
            } catch (Throwable th) {
                f9015.release();
                throw th;
            }
        } catch (InterruptedException unused) {
        }
    }
}
