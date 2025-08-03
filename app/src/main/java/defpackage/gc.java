package defpackage;

import com.zhiyun.protocol.message.Head;
import com.zhiyun.protocol.utils.a;

/* loaded from: classes.dex */
public class gc implements Head {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f6654;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f6655;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f6658;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f6653 = 15396;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public byte f6656 = 8;

    /* renamed from: ԫ, reason: contains not printable characters */
    public byte f6657 = 1;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f6659 = false;

    @Override // com.zhiyun.protocol.message.Head
    public int getBodyLength() {
        return this.f6655;
    }

    @Override // com.zhiyun.protocol.message.Head
    public int getHeadLength() {
        return this.f6654;
    }

    @Override // com.zhiyun.protocol.message.Head
    public boolean parseFrom(byte[] bArr) {
        if (bArr == null || bArr.length < 6) {
            return false;
        }
        this.f6653 = a.a(bArr[0], bArr[1], this.f6659);
        this.f6655 = (a.b(bArr[2], bArr[3], this.f6659) - 1) - 1;
        byte[] bArrA = a.a(bArr[4], this.f6659);
        this.f6656 = bArrA[0];
        this.f6657 = bArrA[1];
        this.f6658 = bArr[5];
        this.f6654 = 6;
        return true;
    }

    @Override // com.zhiyun.protocol.message.Head
    public void setBodyLength(int i) {
        this.f6655 = i;
    }

    @Override // com.zhiyun.protocol.message.Head
    public byte[] toData() {
        byte[] bArrA = a.a(this.f6653, 2, this.f6659);
        byte[] bArrA2 = a.a(this.f6655, 2, this.f6659);
        return new byte[]{bArrA[0], bArrA[1], bArrA2[0], bArrA2[1], a.a(this.f6656, this.f6657, true, this.f6659), (byte) this.f6658};
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public byte m6089() {
        return this.f6656;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m6090(byte b) {
        this.f6656 = b;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m6091(int i) {
        this.f6654 = i;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m6092(boolean z) {
        this.f6659 = z;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public int m6093() {
        return this.f6658;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m6094(int i) {
        this.f6658 = i;
    }
}
