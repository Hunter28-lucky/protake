package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.zhiyun.protocol.utils.a;
import com.zhiyun.protocol.utils.e;

/* loaded from: classes.dex */
public class ma extends ca {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public byte f7989;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f7990;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f7991;

    @Override // com.zhiyun.protocol.message.Body
    public boolean parseFrom(byte[] bArr) {
        if (bArr.length < 6) {
            return false;
        }
        this.f7989 = (byte) (bArr[0] & ExifInterface.MARKER);
        byte[] bArrA = a.a(bArr[1], 2, m275());
        byte b = bArrA[0];
        byte b2 = bArrA[1];
        this.f7991 = e.a(bArr[3], 0, bArr[2]);
        this.f7990 = a.a(bArr[4], bArr[5], m275());
        return true;
    }

    @Override // com.zhiyun.protocol.message.Body
    public byte[] toData() {
        int i = this.f7991 & 61695;
        this.f7991 = i;
        byte b = (byte) e.b(i);
        e.a(this.f7991);
        byte bC = (byte) e.c(this.f7991);
        byte[] bArrA = a.a(this.f7990, 2, m275());
        return new byte[]{this.f7989, a.a((byte) 1, (byte) 0, true, m275()), bC, b, bArrA[0], bArrA[1]};
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m7544(byte b) {
        this.f7989 = b;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m7545(int i) {
        this.f7991 = i;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public byte m7546() {
        return this.f7989;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m7547(int i) {
        this.f7990 = i;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public int m7548() {
        return this.f7990;
    }
}
