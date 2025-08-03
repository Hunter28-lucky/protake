package defpackage;

import com.umeng.analytics.pro.cb;
import com.zhiyun.protocol.utils.Arrays;

/* loaded from: classes2.dex */
public class ya extends rd {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f8765;

    @Override // com.zhiyun.protocol.message.Body
    public boolean parseFrom(byte[] bArr) {
        if (bArr.length <= 1 || bArr[0] != 16) {
            return false;
        }
        byte[] bArrA = Arrays.a(bArr, 1);
        if (bArrA.length >= 1) {
            byte b = bArrA[0];
        }
        if (bArrA.length >= 2) {
            byte b2 = bArrA[1];
        }
        return true;
    }

    @Override // com.zhiyun.protocol.message.Body
    public byte[] toData() {
        return Arrays.a(new byte[]{cb.n}, new byte[]{(byte) this.f8765});
    }
}
