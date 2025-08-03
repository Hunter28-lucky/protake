package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public abstract class vb {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final ByteBuffer f8695;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public InterfaceC2302 f8696;

    /* renamed from: vb$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2302 {
        void a(byte[] bArr);
    }

    public vb(int i, ByteOrder byteOrder) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        this.f8695 = byteBufferAllocate;
        byteBufferAllocate.order(byteOrder);
    }

    /* renamed from: Ϳ */
    public abstract void mo5944();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m8486(InterfaceC2302 interfaceC2302) {
        this.f8696 = interfaceC2302;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m8487(byte[] bArr) {
        this.f8695.limit(this.f8695.capacity());
        this.f8695.put(bArr);
        this.f8695.flip();
        mo5944();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final boolean m8488(int i) {
        if (this.f8695.remaining() >= i) {
            return true;
        }
        int iRemaining = this.f8695.remaining();
        this.f8695.compact();
        this.f8695.position(iRemaining);
        this.f8695.limit(iRemaining);
        return false;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m8489(byte[] bArr) {
        InterfaceC2302 interfaceC2302 = this.f8696;
        if (interfaceC2302 != null) {
            interfaceC2302.a(bArr);
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean m8490() {
        if (this.f8695.hasRemaining()) {
            return true;
        }
        this.f8695.compact();
        this.f8695.clear();
        return false;
    }
}
