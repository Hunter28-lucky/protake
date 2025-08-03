package defpackage;

import com.zhiyun.protocol.utils.Arrays;
import e.a;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class uc extends sd {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f8643;

    /* renamed from: ԩ, reason: contains not printable characters */
    public a f8644;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public byte f8645 = 0;

    public uc() {
        m8393();
    }

    @Override // com.zhiyun.protocol.message.Body
    public boolean parseFrom(byte[] bArr) {
        if (9 != bArr[0]) {
            return false;
        }
        this.f8645 = bArr[1];
        this.f8644 = a.a(bArr[2]);
        return true;
    }

    @Override // com.zhiyun.protocol.message.Body
    public byte[] toData() {
        byte b = this.f8643 ? BER.ASN_LONG_LEN : (byte) 0;
        this.f8645 = b;
        return Arrays.a(new byte[]{9}, new byte[]{b, (byte) this.f8644.a});
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m8392(a aVar) {
        this.f8644 = aVar;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m8393() {
        this.f8644 = a.CAMERA;
    }
}
